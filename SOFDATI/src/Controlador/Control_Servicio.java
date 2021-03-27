/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Servicio;
import Modelo.Persona;
import Modelo.Servicio;
import Vista.Vista_Servicio;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Usuario
 */
public class Control_Servicio {

    Vista_Servicio vistaS;
    Modelo_Servicio modeloS;
    private boolean validarBotonA;

    public Control_Servicio(Vista_Servicio vistaS, Modelo_Servicio modeloS) {
        this.vistaS = vistaS;
        this.modeloS = modeloS;
        this.vistaS.setVisible(true);
    }

    public void iniciarControl() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarLista(vistaS.getTxtbuscarS().getText());
            }
        };
        vistaS.getBtnactualizar().addActionListener(l -> CargarLista(""));

        vistaS.getBtnnuevoS().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialogo();
        });
        vistaS.getBtnmodificarS().addActionListener((ActionEvent l) -> {
            MostrarServicio();
            this.validarBotonA = false;
        });

        vistaS.getBtnaceptarNS().addActionListener(l -> Grabar_Modificar());
        vistaS.getBtncancelarNS().addActionListener(l -> CerrarDialogo());
        vistaS.getBtneliminarS().addActionListener(l -> EliminarServicio());
//        vistaS.getBtnCerrarJF().addActionListener(l -> CerrarJF());
        vistaS.getTxtbuscarS().addKeyListener(kl);
    }

    private void CerrarDialogo() {
        vistaS.getDialogoServicio().setVisible(false);
    }

    private void CerrarJF() {
        vistaS.setVisible(false);
    }

    private void Grabar_Modificar() {
        if (validarBotonA) {
            GrabaServicio();
        } else {
            EditarServicio();
        }
    }

    public void CargarLista(String buscar) {
//        vistaS.getTablaServicios().setDefaultRenderer(Object.class, new ImagenTabla());
//        vistaS.getTblpersona().setRowHeight(100);
//        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vistaS.getTablaServicios().getModel();
        tblModel.setNumRows(0);
        List<Servicio> lista = Modelo_Servicio.ListarServicios(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vistaS.getTablaServicios().setValueAt(p1.getCodservicio(), i.value, 0);
            vistaS.getTablaServicios().setValueAt(p1.getCodcliente(), i.value, 1);
            vistaS.getTablaServicios().setValueAt(p1.getFechaServicio(), i.value, 2);
            vistaS.getTablaServicios().setValueAt(p1.getCodciudad(), i.value, 3);
            vistaS.getTablaServicios().setValueAt(p1.getCodvehiculo(), i.value, 4);
            vistaS.getTablaServicios().setValueAt(p1.getCodempleado(), i.value, 5);
            vistaS.getTablaServicios().setValueAt(p1.getKm_salida(), i.value, 6);
            vistaS.getTablaServicios().setValueAt(p1.getKm_llegada(), i.value, 7);
            i.value++;
        });
    }

    private void MuestraDialogo() {
        vistaS.getDialogoServicio().setVisible(true);
        vistaS.getDialogoServicio().setTitle("NUEVO SERVICIO");
        vistaS.getDialogoServicio().setSize(450, 600);
        vistaS.getTxtcodServicio().setText("");
        vistaS.getTxtidcliente().setText("");
        vistaS.getTxtJfechaServicio().setCalendar(null);
        vistaS.getTxtcodvehiculo().setText("");
        vistaS.getTxtcodempleado().setText("");
        vistaS.getTxtkmsalida().setText("");
        vistaS.getTxtkmllegada().setText("");
        vistaS.getDialogoServicio().setLocationRelativeTo(vistaS);
        vistaS.getTxtcodServicio().setEditable(true);

    }

    private void GrabaServicio() {
        if (vistaS.getTxtcodServicio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Vacio");
        } else if (vistaS.getTxtidcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Cliente");
        } else if (vistaS.getTxtJfechaServicio().getCalendar() == null) {
            JOptionPane.showMessageDialog(vistaS, "Campo Fecha Vacio");
        } else if (vistaS.getTxtcodvehiculo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Vehiculo Vacio");
        } else if (vistaS.getTxtcodempleado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Empleado Vacio");
        } else if (vistaS.getTxtkmsalida().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Salida Vacio");
        } else if (vistaS.getTxtkmllegada().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Llegada Vacio");
        } else {
            try {
                String idpe = vistaS.getTxtcodServicio().getText();
                Modelo_Servicio ms = new Modelo_Servicio(idpe);
                if (ms.ValidarServicio()== true) {
                    JOptionPane.showMessageDialog(vistaS, "El ID ya existe");

                } else {
                    String codservicio = vistaS.getTxtcodServicio().getText();
                    String idcliente = vistaS.getTxtidcliente().getText();
                    Instant instant = vistaS.getTxtJfechaServicio().getDate().toInstant();
                    ZoneId zoneid = ZoneId.of("America/Guayaquil");
                    ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
                    Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
                    String codciudad = vistaS.getTxtciudadSer().getText();
                    String codVehiculo = vistaS.getTxtcodvehiculo().getText();
                    String codempleado = vistaS.getTxtcodempleado().getText();
                    Double kmSalida = Double.parseDouble(vistaS.getTxtkmsalida().getText());
                    Double kmLlegada = Double.parseDouble(vistaS.getTxtkmllegada().getText());
                    Modelo_Servicio servicio = new Modelo_Servicio(codservicio, fechanacimiento, kmLlegada, kmSalida, codVehiculo, codempleado, idcliente, codciudad);
                    if (servicio.Grabar_Servicio()) {
                        CargarLista("");
                        JOptionPane.showMessageDialog(vistaS, "Registro grabado Satisfactoriamente");
                        vistaS.getDialogoServicio().setVisible(false);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Control_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void EditarServicio() {
        if (vistaS.getTxtcodServicio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Vacio");
        } else if (vistaS.getTxtidcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Cliente");
        } else if (vistaS.getTxtJfechaServicio().getCalendar() == null) {
            JOptionPane.showMessageDialog(vistaS, "Campo Fecha Vacio");
        } else if (vistaS.getTxtcodvehiculo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Vehiculo Vacio");
        } else if (vistaS.getTxtcodempleado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Empleado Vacio");
        } else if (vistaS.getTxtkmsalida().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Salida Vacio");
        } else if (vistaS.getTxtkmllegada().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Llegada Vacio");
        } else {
            String codservicio = vistaS.getTxtcodServicio().getText();
            String idcliente = vistaS.getTxtidcliente().getText();
            Instant instant = vistaS.getTxtJfechaServicio().getDate().toInstant();
            ZoneId zoneid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
            String codciudad = vistaS.getTxtciudadSer().getText();
            String codVehiculo = vistaS.getTxtcodvehiculo().getText();
            String codempleado = vistaS.getTxtcodempleado().getText();
            Double kmSalida = Double.parseDouble(vistaS.getTxtkmsalida().getText());
            Double kmLlegada = Double.parseDouble(vistaS.getTxtkmllegada().getText());
            Modelo_Servicio servicio = new Modelo_Servicio(codservicio, fechanacimiento, kmLlegada, kmSalida, codVehiculo, codempleado, idcliente, codciudad);
            if (servicio.Grabar_Servicio()) {
                CargarLista("");
                JOptionPane.showMessageDialog(vistaS, "Registro editado Satisfactoriamente");
                vistaS.getDialogoServicio().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vistaS, "ERROR AL EDITAR");
            }
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vistaS.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaS, "Debe seleccionar una fila");
        } else {
            JTable tabla = vistaS.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }
//
    public void MostrarServicio()  {
        String eleccion = ElegirCasilla();
        Modelo_Servicio ms = new Modelo_Servicio();
        List<Servicio> lista = ms.BuscarServicio(eleccion);
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i);
            MuestraDialogo();
            vistaS.getDialogoServicio().setTitle("EDITAR SERVICIO");
            vistaS.getTxtcodServicio().setText(s.getCodservicio());
            vistaS.getTxtcodServicio().setEditable(false);
            vistaS.getTxtidcliente().setText(s.getCodcliente());
            vistaS.getTxtJfechaServicio().setDate(s.getFechaServicio());
            vistaS.getTxtcodvehiculo().setText(s.getCodvehiculo());
            vistaS.getTxtcodempleado().setText(s.getCodempleado());
            vistaS.getTxtkmsalida().setText(s.getKm_salida()+"");
            vistaS.getTxtkmllegada().setText(s.getKm_llegada()+ "");
        }
    }

    public void EliminarServicio() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vistaS, "Esta seguro en eliminar este Servicio", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Modelo_Servicio ms = new Modelo_Servicio(eleccion);
                if (ms.EliminarServicio()) {
                    CargarLista("");
                    JOptionPane.showMessageDialog(vistaS, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vistaS, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vistaS, "Eliminacion Cancelada");
            }
        }
    }
}
