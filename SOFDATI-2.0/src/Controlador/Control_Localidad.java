/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Localidad;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Localidad;
import Modelo.Vehiculo;
import Vista.Vista_Localidad;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
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
public class Control_Localidad {
//Atributos

    private Modelo_Localidad modelo;
    private Vista_Localidad vista;
    private boolean botonEditar;
//Constructor

    public Control_Localidad(Modelo_Localidad modelo, Vista_Localidad vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setVisible(true);
        ValidaLetras();
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
                cargaLista(vista.getTxtBusquedaL1().getText());
            }
        };

        vista.getBtnBuscarL1().addActionListener(l -> cargaLista(""));
        vista.getBtnAgregarL1().addActionListener(l -> {
            botonEditar = true;
            muestraDialogo();
        });
        vista.getBtnGuardarL2().addActionListener(l -> switchBoton());
        vista.getBntModificarL1().addActionListener(l -> {
            botonEditar = false;
            mostrarDatos();
        });
        vista.getBtnEliminarL1().addActionListener(l -> Eliminar());
        vista.getTxtBusquedaL1().addKeyListener(kl);
        vista.getBtnSalirL1().addActionListener(l -> salirBoton());

    }

    public void switchBoton() {
        if (botonEditar) {
            grabarLocalidad();
        } else {
            editarLocalidad();
        }

    }

    public void cargaLista(String aguja) {
        DefaultTableModel tdlModel;
        tdlModel = (DefaultTableModel) vista.getTblLocalidad().getModel();
        tdlModel.setNumRows(0);
        List<Localidad> Lista = Modelo_Localidad.ListarLocalidad(aguja);
        int ncols = tdlModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0); // problema con paquete 
        Lista.stream().forEach(p1 -> {
            tdlModel.addRow(new Object[ncols]);
            vista.getTblLocalidad().setValueAt(p1.getCod_ciudad(), i.value, 0);
            vista.getTblLocalidad().setValueAt(p1.getPais(), i.value, 1);
            vista.getTblLocalidad().setValueAt(p1.getProvincia(), i.value, 2);
            vista.getTblLocalidad().setValueAt(p1.getCanton(), i.value, 3);
            i.value++;
        });
    }

    private void muestraDialogo() {
        vista.getDlgLocalidad().setSize(350, 250);
        vista.getDlgLocalidad().setTitle("Nuevo Registro - Localidad");
        vista.getDlgLocalidad().setLocationRelativeTo(vista);
        vista.getDlgLocalidad().setVisible(true);
        vista.getTxtCodLocal().setEditable(true);
        vista.getTxtPais().setText("");
        vista.getTxtProvincia().setText("");
        vista.getTxtCanton().setText("");

    }

    private void grabarLocalidad() {
        String cod_localidad = vista.getTxtCodLocal().getText();
        String pais = vista.getTxtPais().getText();
        String provincia = vista.getTxtProvincia().getText();
        String canton = vista.getTxtCanton().getText();

        Modelo_Localidad localidad = new Modelo_Localidad(cod_localidad, pais, canton, provincia);

        if (localidad.grabar()) {
            cargaLista("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
            vista.getDlgLocalidad().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    private void editarLocalidad() {
        String cod_localidad = vista.getTxtCodLocal().getText();
        String pais = vista.getTxtPais().getText();
        String provincia = vista.getTxtProvincia().getText();
        String canton = vista.getTxtCanton().getText();

        Modelo_Localidad localidad = new Modelo_Localidad(cod_localidad, pais, canton, provincia);

        if (localidad.editar()) {
            cargaLista("");
            JOptionPane.showMessageDialog(vista, "Registro Editado Satisfactoriamente");
            vista.getDlgLocalidad().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    private void mostrarDatos() {
        String idSeleccion = ElegirCasilla();
        Modelo_Localidad localidad = new Modelo_Localidad();
        List<Localidad> lista = localidad.BuscarLocalidad(idSeleccion); // preguntar a Angel
        System.out.println("");
        for (int i = 0; i < lista.size(); i++) {
            Localidad l = lista.get(i);
            String cod_localidad = l.getCod_ciudad();
            String pais = l.getPais();
            String provincia = l.getProvincia();
            String canton = l.getCanton();      
            muestraDialogo();
            vista.getDlgLocalidad().setTitle("EDITAR LOCALIDAD");
            vista.getTxtCodLocal().setText(cod_localidad);
            vista.getTxtCodLocal().setEditable(false);
            vista.getTxtPais().setText(pais);
            vista.getTxtProvincia().setText(provincia);
            vista.getTxtCanton().setText(canton);
            
        }

    }

    public String ElegirCasilla() {

        String idSeleccion = "";
        int fila = vista.getTblLocalidad().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un registro del listado");
        } else {
            JTable tabla = vista.getTblLocalidad();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void Eliminar() {
        String seleccion = ElegirCasilla();
        if (seleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar este Registro", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Modelo_Localidad ml = new Modelo_Localidad(seleccion);
                if (ml.eliminar()) {
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
    
     public void ValidaLetras(){
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               char valida = e.getKeyChar();
        if (((valida < 'a' | valida > 'z') & (valida < 'A' | valida > 'Z') &(valida < 'a') && (valida != KeyEvent.VK_SPACE)))  {
            e.consume();}
            }

            @Override
            public void keyPressed(KeyEvent e) {
               
            }

            @Override
            public void keyReleased(KeyEvent e) {
               
            }
        };
        
        vista.getTxtCanton().addKeyListener(ke);
        vista.getTxtProvincia().addKeyListener(ke);
        vista.getTxtPais().addKeyListener(ke);
        
    }

}
