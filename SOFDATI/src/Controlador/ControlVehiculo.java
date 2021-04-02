/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloVehiculo;
import Modelo.Persona;
import Modelo.Vehiculo;
import Vista.Vista_Vehiculo;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Usuario
 */
public class ControlVehiculo {
//Atributos

    private ModeloVehiculo modelo;
    private Vista_Vehiculo vista;
    private boolean botonEditar;

//Contructor
    public ControlVehiculo(ModeloVehiculo modelo, Vista_Vehiculo vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
//Metodos   

    public void iniciaControl() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cargaLista(vista.getTxtBusquedaV1().getText());
            }
        };

        vista.getBtnBuscarV1().addActionListener(l -> cargaLista(""));
        vista.getBtnAgregarV1().addActionListener(l -> {
            this.botonEditar = true;
            muestraDialogo();
        });
        vista.getBtnGuardarV2().addActionListener(l -> switchBoton());
        vista.getBntModificarV1().addActionListener(l -> {
            this.botonEditar = false;
            mostrarDatos();
        });
        vista.getBtnEliminarV1().addActionListener(l -> ElegirCasilla());
        vista.getTxtBusquedaV1().addKeyListener(kl);
        vista.getBtnSalirV1().addActionListener(l -> salirBoton());

    }

    public void switchBoton() {
        if (botonEditar) {
            grabarVehiculo();
        } else {
            editarVehiculo();
        }

    }

    public void cargaLista(String aguja) {
//        vista.getTblVehiculo().setDefaultRenderer(Object.class, new ImagenTabla());
//        vista.getTblVehiculo().setRowHeight(100);
//        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tdlModel;
        tdlModel = (DefaultTableModel) vista.getTblVehiculo().getModel();
        tdlModel.setNumRows(0);
        List<Vehiculo> Lista = ModeloVehiculo.ListarVehiculo(aguja);
        int ncols = tdlModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0); // problema con paquete 
        Lista.stream().forEach(p1 -> {
            tdlModel.addRow(new Object[ncols]);
            vista.getTblVehiculo().setValueAt(p1.getRam_o_cpn(), i.value, 0);
            vista.getTblVehiculo().setValueAt(p1.getAnio_modelo(), i.value, 1);
            vista.getTblVehiculo().setValueAt(p1.getTonelaje(), i.value, 2);
            vista.getTblVehiculo().setValueAt(p1.getMatricula(), i.value, 3);
            vista.getTblVehiculo().setValueAt(p1.getPais(), i.value, 7);
            vista.getTblVehiculo().setValueAt(p1.getCanton(), i.value, 4);
            vista.getTblVehiculo().setValueAt(p1.getFecha_ultima_matricula(), i.value, 5);
            vista.getTblVehiculo().setValueAt(p1.getServicio_vehiculo(), i.value, 6);
            vista.getTblVehiculo().setValueAt(p1.getColor(), i.value, 7);
            vista.getTblVehiculo().setValueAt(p1.getFecha_caducidad_matricula(), i.value, 8);

            i.value++;
        });
    }

    private void muestraDialogo() {
        vista.getDlgVehiculo().setSize(700, 350);
        vista.getDlgVehiculo().setTitle("Nuevo Registro - Vehiculo");
        vista.getDlgVehiculo().setLocationRelativeTo(vista);
        vista.getDlgVehiculo().setVisible(true);
        vista.getTxtRam().setEditable(true);
        vista.getTxtRam().setText("");
        vista.getTxtAnio().setText("");
        vista.getTxtTonelaje().setText("");
        vista.getTxtMatricula().setText("");
        vista.getTxtPais().setText("");
        vista.getTxtCanton().setText("");
        vista.getJdtFUltima().setDate(null);
        vista.getTxtServicio().setText("");
        vista.getTxtColor().setText("");
        vista.getJdtFCaduce().setDate(null);

    }

    private void grabarVehiculo() {
        String ram = vista.getTxtRam().getText();
        String anio = vista.getTxtAnio().getText();
        String tonelaje = vista.getTxtTonelaje().getText();
        String matricula = vista.getTxtMatricula().getText();
        String pais = vista.getTxtPais().getText();
        String canton = vista.getTxtCanton().getText();
        String servicio = vista.getTxtServicio().getText();
        String color = vista.getTxtColor().getText();
        //Fechas
        Instant instant1 = vista.getJdtFUltima().getDate().toInstant();
        Instant instant2 = vista.getJdtFCaduce().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(instant1, zid);
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant2, zid);
        Date fechaUltima = Date.valueOf(zdt1.toLocalDate());
        Date fechaCaduce = Date.valueOf(zdt2.toLocalDate());

        ModeloVehiculo vehiculo = new ModeloVehiculo();

        if (vehiculo.grabar()) {
            cargaLista("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
            vista.getDlgVehiculo().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    private void editarVehiculo() {
        String ram = vista.getTxtRam().getText();
        String anio = vista.getTxtAnio().getText();
        String tonelaje = vista.getTxtTonelaje().getText();
        String matricula = vista.getTxtMatricula().getText();
        String pais = vista.getTxtPais().getText();
        String canton = vista.getTxtCanton().getText();
        String servicio = vista.getTxtServicio().getText();
        String color = vista.getTxtColor().getText();
        //Fechas
        Instant instant1 = vista.getJdtFUltima().getDate().toInstant();
        Instant instant2 = vista.getJdtFCaduce().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(instant1, zid);
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant2, zid);
        Date fechaUltima = Date.valueOf(zdt1.toLocalDate());
        Date fechaCaduce = Date.valueOf(zdt2.toLocalDate());

        ModeloVehiculo vehiculo = new ModeloVehiculo(canton, pais, canton, servicio, color, 0, 0, fechaUltima, fechaCaduce);

        if (vehiculo.editar()) {
            cargaLista("");
            JOptionPane.showMessageDialog(vista, "Registro editado Satisfactoriamente");
            vista.getDlgVehiculo().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    private void mostrarDatos() {
        String idSeleccion = ElegirCasilla();
        ModeloVehiculo vehiculo = new ModeloVehiculo(idSeleccion);
        List<Vehiculo> lista = vehiculo.BuscarVehiculo(idSeleccion); // preguntar a Angel
        for (int i = 0; i < lista.size(); i++) {
            Vehiculo v = lista.get(i);
            String ram = v.getRam_o_cpn();
            int anio = v.getAnio_modelo();
            float tonelaje = v.getTonelaje();
            String matricula = v.getMatricula();
            String pais = v.getPais();
            String canton = v.getCanton();
            Date fechaUltima = (Date) v.getFecha_ultima_matricula();
            String servicio = v.getServicio_vehiculo();
            String color = v.getColor();
            Date fechaCaduce = (Date) v.getFecha_caducidad_matricula();

            muestraDialogo();
            vista.getDlgVehiculo().setTitle("EDITAR PERSONA");
            vista.getTxtRam().setText(ram);
            vista.getTxtAnio().setText(anio + "");
            vista.getTxtTonelaje().setText(tonelaje + "");
            vista.getTxtMatricula().setText(matricula);
            vista.getTxtMatricula().setEditable(false);
            vista.getTxtPais().setText(pais);
            vista.getTxtCanton().setText(canton);
            vista.getJdtFUltima().setDate(fechaCaduce);
            vista.getTxtServicio().setText(servicio);
            vista.getTxtColor().setText(color);
            vista.getJdtFUltima().setDate(fechaCaduce);
        }

    }

    public String ElegirCasilla() {

        String idSeleccion = "";
        int fila = vista.getTblVehiculo().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un registro del listado");
        } else {
            JTable tabla = vista.getTblVehiculo();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void Eliminiar() {
        String seleccion = ElegirCasilla();
        if (seleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar este Registro", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                ModeloVehiculo mv = new ModeloVehiculo(seleccion);
                if (mv.eliminar()) {
                    cargaLista("");
                    JOptionPane.showMessageDialog(vista, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Eliminacion Cancelada"); // mucho mensaje 
            }
        }
    }

    public void salirBoton() {
        this.vista.setVisible(false);
    }

}
