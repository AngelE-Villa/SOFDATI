
package Controlador;

import Modelo.Cliente;
import Modelo.ModeloCliente;
import Vista.Vista_Cliente;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.swing.JOptionPane;
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        vista.getBtnActualizarcli().addActionListener(p -> CargarLista(""));
//        vista.getBtnNuevo().addActionListener(p -> MostrarDialog());
//        vista.getBtnAceptar().addActionListener(p -> OpcionBoton());
//        vista.getBtnEditar().addActionListener(p -> Obtener_datos());
//        vista.getBtnEliminar().addActionListener(p -> eliminarPersona());
//        vista.getTxtBuscar().addKeyListener(kl);
//        vista.getBtnExaminar().addActionListener(P -> CargarFoto());
//        vista.getBtnCerrarP().addActionListener(p->salir());
//        vista.getBtnImprimir().addActionListener(P->ImprimirReporte());
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
        vista.getDialogCliente().setSize(550, 350);
        vista.getDialogCliente().setTitle("NUEVO CLIENTE");
        vista.getDialogCliente().setLocationRelativeTo(vista);
        vista.getTxtIdcli().setText("");
        vista.getTxtcedulacli().setText("");
        vista.getTxtnombrecli().setText("");
        vista.getTxtapellidocli().setText("");
        vista.getTxttelfcli().setText("");
        vista.getDchfechacli().setDate(null);
        vista.getDialogCliente().setVisible(true);
        vista.getBtnAceptarcli().setText("CREAR");
        vista.getTxtIdcli().setEditable(true);
    }

    private void GrabarCliente() { //crear
        String idCliente = vista.getTxtIdcli().getText();
        String cedula = vista.getTxtcedulacli().getText();
        String nombres = vista.getTxtnombrecli().getText();
        String apellidos = vista.getTxtapellidocli().getText();
        Instant intate = vista.getDchfechacli().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        String telefono = vista.getTxttelfcli().getText();
        String direccion = vista.getTxtdireccli().getText();

        ModeloCliente cli = new ModeloCliente(idCliente,cedula, nombres, apellidos,fnacimiento,telefono,direccion);

        if (cli.Grabar_Cliente()) {
            CargarLista("");
            vista.getDialogCliente().setVisible(false);
            vista.getTxtIdcli().setEditable(true);

            JOptionPane.showMessageDialog(vista, "CLIENTE NUEVO GUARDADO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
        }
    }

    private void EditarCliente() {
        String idpersona = vista.getTxtIdcli().getText();
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

    private void Obtener_datos() {
        String almacena = "";
        DefaultTableModel tbCliente = (DefaultTableModel) vista.getTblCliente().getModel();
        int fila = vista.getTblCliente().getSelectedRow();
        if (fila != -1) {
            vista.getDialogCliente().setVisible(true);
            vista.getDialogCliente().setLocationRelativeTo(vista);
            vista.getDialogCliente().setSize(550, 450);
            vista.getDialogCliente().setTitle("MODIFICAR CLIENTE");
            vista.getBtnAceptar().setText("EDITAR");
            almacena = tbCliente.getValueAt(fila, 0).toString();
            
            List<Cliente> c = modelo.BuscarporID(almacena);
            for (int i = 0; i < c.size(); i++) {
                Cliente cli = c.get(i);
                vista.getTxtIdcli().setText(cli.getIdCliente());
                vista.getTxtcedulacli().setText(cli.getCedula());
                vista.getTxtnombrecli().setText(cli.getNombre());
                vista.getTxtapellidocli().setText(cli.getApellido());
                vista.getDchfechacli().setDate(cli.getFnacimiento());
                vista.getTxtdireccli().setText(cli.getDireccion());
                vista.getTxttelfcli().setText(cli.getTelefono());   
            }

            vista.getTxtIdcli().setEditable(false);

        } else {
            JOptionPane.showMessageDialog(vista, "Seleccione una fila para editar");
        }
    }

    public void OpcionBoton() {
        if (vista.getBtnAceptarcli().getText().equals("CREAR")) {
            GrabarCliente();
        } else {
            EditarCliente();
        }
    }

    private void eliminarCliente() {
        DefaultTableModel tbCliente = (DefaultTableModel) vista.getTblCliente().getModel();
        int fila = vista.getTblCliente().getSelectedRow();
        if (fila != -1) {
            String idCliente = tbCliente.getValueAt(fila, 0).toString();
            ModeloCliente cliente = new ModeloCliente();
            cliente.setIdCliente(idCliente);
            int eleccion = JOptionPane.showConfirmDialog(vista, "Esta seguro de elimar esta persona", "advertencia", JOptionPane.YES_NO_OPTION);
            if (eleccion == JOptionPane.YES_OPTION) {
                if (cliente.EliminarCliente()) {
                    JOptionPane.showMessageDialog(vista, "Persona eliminada con exito");

                } else {
                    JOptionPane.showMessageDialog(vista, "ERROR");

                }
                CargarLista("");
            } else {
                JOptionPane.showMessageDialog(vista, "Elimiacion Cancelada");
            }

        } else {
            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUNA PERSONA Y LUEGO EN ELIMINAR");
        }
    }


}
