/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Detalle_Servicio;
import Modelo.Modelo_Detalle;
import Modelo.Persona;
import Vista.Vista_Detalle;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author Emilia
 */
public class Control_DetalleServicio {
    
    private Modelo_Detalle modelo;
    private Vista_Detalle vista ;

    public Control_DetalleServicio(Modelo_Detalle modelo, Vista_Detalle vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void InicioControl() {

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                CargarLista(vista.getTxtBuscar().getText());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        vista.getBtnactualizarD().addActionListener(p -> CargarLista(""));
        vista.getBtnnuevoD().addActionListener(p -> MostrarDialog());
       vista.getBtnaceptarDetalle().addActionListener(p -> OpcionBoton());
        vista.getBtnmodificarD().addActionListener(p -> Obtener_datos());
        vista.getBtneliminarD().addActionListener(p -> Eliminar());
        vista.getTxtbuscarD().addKeyListener(kl);

    }
    
    public void CargarLista(String buscar) {

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblDetalle().getModel();
        tblModel.setNumRows(0);
        List<Detalle_Servicio> lista = Modelo_Detalle.ListarDetalles(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblDetalle().setValueAt(p1.getCod_dellate_servicio(), i.value, 0);
            vista.getTblDetalle().setValueAt(p1.getCod_producto_detalle(), i.value, 1);
            vista.getTblDetalle().setValueAt(p1.getCod_servicio_detalle(), i.value, 2);
            vista.getTblDetalle().setValueAt(p1.getPrecio_unitario(), i.value, 2);
            vista.getTblDetalle().setValueAt(p1.getCantidad(), i.value, 4);
       
            i.value++;
        });
    }
    
    private void MostrarDialog() {
        vista.getDialogoDetalle().setSize(550, 350);
        vista.getDialogoDetalle().setTitle("NUEVO DETALLE");
        vista.getDialogoDetalle().setLocationRelativeTo(vista);
        vista.getTxtcodDetalle().setText("");
        vista.getTxtCodservicio().setText("");
        vista.getTxtCodproducto().setText("");
        vista.getTxtcantidad().setText("");
        vista.getTxtPrecioUnit().setText("");
        vista.getDialogoDetalle().setVisible(true);
        vista.getBtnaceptarDetalle().setText("CREAR");
        vista.getTxtcodDetalle().setEditable(true);
    }
    
    private void GrabaServicio() {
        if (vista.getTxtcodDetalle().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo ID Detalle Vacio");
        } else if (vista.getTxtCodproducto().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo ID Producto");
        } else if (vista.getTxtCodservicio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo ID Servicio Vacio");
        } else if (vista.getTxtPrecioUnit().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Precio Unitario Vacio");
        } else if (vista.getTxtcantidad().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Cantidad Salida Vacio");
        } else {
            try {
                String idpe = vista.getTxtcodDetalle().getText();
                Modelo_Detalle md = new Modelo_Detalle(idpe);
                if (md.ValidarDetalle()== true) {
                    JOptionPane.showMessageDialog(vista, "El ID ya existe");

                } else {
              
                    String cod_detalle_servicio = vista.getTxtcodDetalle().getText();
                    String cod_producto_detalle = vista.getTxtCodproducto().getText();
                    String cod_servicio_detalle = vista.getTxtCodservicio().getText();
                    Double precio_unitario = Double.parseDouble(vista.getTxtPrecioUnit().getText());
                    int cantidad = Integer.parseInt(vista.getTxtcantidad().getText());
                    
                    Modelo_Detalle detalle = new Modelo_Detalle(cod_detalle_servicio ,cod_producto_detalle, cod_servicio_detalle,precio_unitario, cantidad);
                    if (detalle.Grabar_Detalle()) {
                        CargarLista("");
                        JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
                        vista.getDialogoDetalle().setVisible(false);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Control_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void Eliminar() {
        DefaultTableModel tbDetalle = (DefaultTableModel) vista.getTblDetalle().getModel();
        int fila = vista.getTblDetalle().getSelectedRow();
        if (fila != -1) {
            String idPersona = tbDetalle.getValueAt(fila, 0).toString();
            Modelo_Detalle detalle = new Modelo_Detalle();
            detalle.setCod_dellate_servicio(idPersona);
            int eleccion = JOptionPane.showConfirmDialog(vista, "Esta seguro de elimar esta detalle", "advertencia", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                if (detalle.EliminarDetalle()) {
                    JOptionPane.showMessageDialog(vista, "Detalle eliminada con exito");

                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR");

                }
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "Elimiacion Cancelada");
            }

        } else {
            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUN DETALLE Y LUEGO EN ELIMINAR");
        }
    }
    
    public void OpcionBoton() {
        if (vista.getBtnaceptarDetalle().getText().equals("CREAR")) {
            GrabaServicio();
        } else {
            EditarPersona();
        }
    }
    
    private void EditarPersona() {
        
        String cod_detalle_servicio = vista.getTxtcodDetalle().getText();
        String cod_producto_detalle = vista.getTxtCodproducto().getText();
        String cod_servicio_detalle = vista.getTxtCodservicio().getText();
        Double precio_unitario = Double.parseDouble(vista.getTxtPrecioUnit().getText());
        int cantidad = Integer.parseInt(vista.getTxtcantidad().getText());
        Modelo_Detalle detalle = new Modelo_Detalle(cod_detalle_servicio ,cod_producto_detalle, cod_servicio_detalle,precio_unitario, cantidad);
        
        if (detalle.Editar()) {
            JOptionPane.showMessageDialog(vista, "Detalle modificada con exito");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");

        }
        vista.getDialogoDetalle().setVisible(false);
        CargarLista("");
    }
    
    private void Obtener_datos() {
        String almacena = "";
        DefaultTableModel tbDetalle = (DefaultTableModel) vista.getTblDetalle().getModel();
        int fila = vista.getTblDetalle().getSelectedRow();
        if (fila != -1) {
            vista.getDialogoDetalle().setVisible(true);
            vista.getDialogoDetalle().setLocationRelativeTo(vista);
            vista.getDialogoDetalle().setSize(550, 450);
            vista.getDialogoDetalle().setTitle("MODIFICAR DETALLE");
            vista.getBtnaceptarDetalle().setText("EDITAR");
            almacena = tbDetalle.getValueAt(fila, 0).toString();

            List<Detalle_Servicio> d = modelo.BuscarDetalle(almacena);
            for (int i = 0; i < d.size(); i++) {
                Detalle_Servicio pe = d.get(i);
                vista.getTxtcodDetalle().setText(pe.getCod_dellate_servicio());
                vista.getTxtCodproducto().setText(pe.getCod_producto_detalle());
                vista.getTxtCodservicio().setText(pe.getCod_servicio_detalle());
                vista.getTxtPrecioUnit().setText(pe.getPrecio_unitario()+"");
                vista.getTxtcantidad().setText(pe.getCantidad()+ "");
               
            }

            vista.getTxtcodDetalle().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila para editar");
        }
    }
   
    
    
    
    
    

    

   

    
    
}
