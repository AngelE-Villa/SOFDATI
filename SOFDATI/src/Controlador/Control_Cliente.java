
package Controlador;

import Modelo.Cliente;
import Modelo.ModeloCliente;
import Vista.Vista_Cliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
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



/**
 *
 * @author emi
 */
public class Control_Cliente {
  
    private ModeloCliente modelo;
    private Vista_Cliente vista;
    private boolean validarBotonA;

    public Control_Cliente(ModeloCliente modelo, Vista_Cliente vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);//aqui mostramos la vista
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
                CargarLista(vista.getTxtBuscar().getText());
            }
        };

        vista.getBtnActualizarcli().addActionListener(p -> CargarLista(""));
        vista.getBtnNuevocli().addActionListener(p -> {
                this.validarBotonA=true;
                MostrarDialog();
        });
        vista.getBtnAceptarcli().addActionListener(p -> OpcionBoton());
        vista.getBtnEditarcli().addActionListener(p -> {
                this.validarBotonA = false;
                Obtener_datos();
        });
        vista.getBtnEliminarcli().addActionListener(p -> EliminarCliente());
        vista.getTxtBuscar().addKeyListener(kl);
//        vista.getBtnExaminar().addActionListener(P -> CargarFoto());
//        vista.getBtnCerrarP().addActionListener(p->salir());
//        vista.getBtnImprimir().addActionListener(P->ImprimirReporte());
     }
     
    public void OpcionBoton() {
        if (validarBotonA) {
            GrabarCliente();
        } else {
            EditarCliente();
        }
    }
     
     public void CargarLista(String busqueda) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblCliente().getModel();
        tblModel.setNumRows(0);//vaciar la tabla

        List<Cliente> lista = ModeloCliente.listaClientes(busqueda);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblCliente().setValueAt(p.getIdCliente(), i.value, 0);
            vista.getTblCliente().setValueAt(p.getCedula(), i.value, 1);
            vista.getTblCliente().setValueAt(p.getNombre(), i.value, 2);
            vista.getTblCliente().setValueAt(p.getApellido(), i.value, 3);
            vista.getTblCliente().setValueAt(p.getFnacimiento(), i.value, 4);
            vista.getTblCliente().setValueAt(p.getDireccion(), i.value, 5);
            vista.getTblCliente().setValueAt(p.getTelefono(), i.value, 6);
            i.value++;
        });

    }
     
     private void MostrarDialog() {
        vista.getDialogCliente().setSize(384,600);
        vista.getDialogCliente().setTitle("NUEVO CLIENTE");
        vista.getDialogCliente().setLocationRelativeTo(vista);
        vista.getTxtcedulacli().setText("");
        vista.getTxtnombrecli().setText("");
        vista.getTxtapellidocli().setText("");
        vista.getTxttelfcli().setText("");
        vista.getDchfechacli().setDate(null);
        vista.getDialogCliente().setVisible(true);
        vista.getTxtcedulacli().setEditable(true);
        vista.getTxtidCliente().setVisible(false);
        vista.getTxtid().setVisible(false);
    }

    private void GrabarCliente() { //crear
        int v=modelo.NCliente()+1;
        String idCliente =String.valueOf(v);
        String cedula = vista.getTxtcedulacli().getText();
        String nombres = vista.getTxtnombrecli().getText();
        String apellidos = vista.getTxtapellidocli().getText();
        Instant intate = vista.getDchfechacli().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        String telefono = vista.getTxttelfcli().getText();
        String direccion = vista.getTxtdireccli().getText();

        ModeloCliente cli = new ModeloCliente(idCliente,cedula, nombres, apellidos,fnacimiento,direccion,telefono);
        if (cli.Grabar_Cliente()) {
            CargarLista("");
            vista.getDialogCliente().setVisible(false);

            JOptionPane.showMessageDialog(vista, "CLIENTE NUEVO GUARDADO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
        }
    }

    private void EditarCliente() {
        String idpersona = vista.getTxtidCliente().getText();
        String cedula = vista.getTxtcedulacli().getText();
        String nombre = vista.getTxtnombrecli().getText();
        String apellido = vista.getTxtapellidocli().getText();
        //Trasformar util.Date a sql.Date
        Instant intate = vista.getDchfecha().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        //Fin de trasformacion
        String direccion = vista.getTxtdireccli().getText();
        String telefono = vista.getTxttelfcli().getText();
        
        ModeloCliente cliente = new ModeloCliente(idpersona,cedula, nombre, apellido, fnacimiento,direccion,telefono);
        
        if (cliente.EditarCliente()) {
            JOptionPane.showMessageDialog(vista, "Cliente modificado con exito");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");

        }
        vista.getDialogCliente().setVisible(false);
        CargarLista("");
    }
    
    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vista.getTblCliente().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTblCliente();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
            return idSeleccion;
        }
        return null;
    }

    private void Obtener_datos() {
        ModeloCliente ms = new ModeloCliente();
        String almacena = ElegirCasilla();            
            List<Cliente> c = ms.BuscarporID(almacena);
            for (int i = 0; i < c.size(); i++) {
                Cliente cli = c.get(i);
                MostrarDialog();
                vista.getDialogCliente().setTitle("EDITAR CLIENTE");
                vista.getTxtidCliente().setVisible(true);
                vista.getTxtid().setVisible(true);
                vista.getTxtidCliente().setText(cli.getIdCliente());
                vista.getTxtidCliente().setEditable(false);
                vista.getTxtcedulacli().setText(cli.getCedula());
                vista.getTxtcedulacli().setEditable(false);
                vista.getTxtnombrecli().setText(cli.getNombre());
                vista.getTxtapellidocli().setText(cli.getApellido());
                vista.getDchfechacli().setDate(cli.getFnacimiento());
                vista.getTxtdireccli().setText(cli.getDireccion());
                vista.getTxttelfcli().setText(cli.getTelefono());   
            }
    }

    public void EliminarCliente() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar este Cliente", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                ModeloCliente mc = new ModeloCliente(eleccion);
                if (mc.EliminarCliente()) {
                    CargarLista("");
                    JOptionPane.showMessageDialog(vista, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Eliminacion Cancelada");
            }
        }
    }


}
