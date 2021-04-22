package Controlador;

import Modelo.Empleado;
import Modelo.Modelo_Empleado;
import Vista.Vista_Empleado;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Control_Empleado {

    Vista_Empleado vista;
    Modelo_Empleado modelo;
    private boolean validarBotonA;

    public Control_Empleado(Vista_Empleado vista, Modelo_Empleado modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
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
                CargarLista(vista.getTxtBuscarE().getText());
            }
        };

        vista.getBtnActualizarE().addActionListener(p -> CargarLista(""));
        vista.getBtnNuevoE().addActionListener(p -> {
            this.validarBotonA = true;
            MostrarDialog();
        });
        vista.getBtnAceptarE().addActionListener(p -> OpcionBoton());
        vista.getBtnEditarE().addActionListener(p -> {
            this.validarBotonA = false;
            Obtener_datos();
        });
        vista.getBtnEliminarE().addActionListener(p -> EliminarCliente());
        vista.getTxtBuscarE().addKeyListener(kl);
        vista.getBtnExaminarE().addActionListener(p -> CargarImagen());
//        vista.getBtnCerrarP().addActionListener(p->salir());
//        vista.getBtnImprimir().addActionListener(P->ImprimirReporte());
    }

    public void OpcionBoton() {
        if (validarBotonA) {
            Grabar_Empleado();
        } else {
            Editar_Empleado();
        }
    }

    public void CargarLista(String busqueda) {
        vista.getTblEmpleado().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblEmpleado().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

//        
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblEmpleado().getModel();
        tblModel.setNumRows(0);//vaciar la tabla

        List<Empleado> lista = Modelo_Empleado.Lista_Empleados(busqueda);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblEmpleado().setValueAt(p.getCod_empleado(), i.value, 0);
            vista.getTblEmpleado().setValueAt(p.getCedula(), i.value, 1);
            vista.getTblEmpleado().setValueAt(p.getNombre(), i.value, 2);
            vista.getTblEmpleado().setValueAt(p.getApellido(), i.value, 3);
            vista.getTblEmpleado().setValueAt(p.getFnacimiento(), i.value, 4);
            vista.getTblEmpleado().setValueAt(p.getDireccion(), i.value, 5);
            vista.getTblEmpleado().setValueAt(p.getTelefono(), i.value, 6);
            vista.getTblEmpleado().setValueAt(p.getCargo(), i.value, 7);
            vista.getTblEmpleado().setValueAt(p.getSueldo(), i.value, 8);
            Image img = p.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblEmpleado().setValueAt(new JLabel(icon), i.value, 9);
            } else {
                vista.getTblEmpleado().setValueAt(null, i.value, 9);
            }

            i.value++;
        });

    }

    private void MostrarDialog() {
        vista.getDialogoEmpleado().setSize(534, 536);
        vista.getDialogoEmpleado().setTitle("NUEVO EMPLEADO");
        vista.getDialogoEmpleado().setLocationRelativeTo(vista);
        vista.getTxtcedulaE().setText("");
        vista.getTxtnombreE().setText("");
        vista.getTxtapellidoE().setText("");
        vista.getTxttelfE().setText("");
        vista.getDchfechaE().setDate(null);
        vista.getCmbCargo().setSelectedIndex(0);
        vista.getTxtsueldoE().setText("");
        vista.getLblfotoE().setText("");
        vista.getDialogoEmpleado().setVisible(true);
        vista.getTxtcedulaE().setEditable(true);
        vista.getTxtidEmpleado().setVisible(false);
        vista.getTxtid().setVisible(false);
    }

    private void Grabar_Empleado() { //crear
        int v = modelo.NEmpleados() + 1;
        String cod_empleado = String.valueOf(v);
        String cedula = vista.getTxtcedulaE().getText();
        String nombres = vista.getTxtnombreE().getText();
        String apellidos = vista.getTxtapellidoE().getText();
        Instant intate = vista.getDchfechaE().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        String telefono = vista.getTxttelfE().getText();
        String direccion = vista.getTxtdirecE().getText();
        String cargo = vista.getCmbCargo().getSelectedItem().toString();
        double sueldo = Double.valueOf(vista.getTxtdirecE().getText());

        Modelo_Empleado em = new Modelo_Empleado(cod_empleado, sueldo, cargo, "", "", cedula, nombres, apellidos, fnacimiento, direccion, telefono);
        ImageIcon ic = (ImageIcon) vista.getLblfotoE().getIcon();
        em.setFoto(ic.getImage());

        if (em.Grabar_Empleado()) {
            CargarLista("");
            vista.getDialogoEmpleado().setVisible(false);

            JOptionPane.showMessageDialog(vista, "EMPLEADO NUEVO GUARDADO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
        }
    }

    private void Editar_Empleado() {
        int v = modelo.NEmpleados() + 1;
        String cod_empleado = String.valueOf(v);
        String cedula = vista.getTxtcedulaE().getText();
        String nombres = vista.getTxtnombreE().getText();
        String apellidos = vista.getTxtapellidoE().getText();
        Instant intate = vista.getDchfechaE().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        String telefono = vista.getTxttelfE().getText();
        String direccion = vista.getTxtdirecE().getText();
        String cargo = vista.getCmbCargo().getSelectedItem().toString();
        double sueldo = Double.valueOf(vista.getTxtsueldoE().getText());

        Modelo_Empleado em = new Modelo_Empleado(cod_empleado, sueldo, cargo, "", "", cedula, nombres, apellidos, fnacimiento, direccion, telefono);
        ImageIcon ic = (ImageIcon) vista.getLblfotoE().getIcon();
        em.setFoto(ic.getImage());

        if (em.Editar_Empleado()) {
            JOptionPane.showMessageDialog(vista, "Cliente modificado con exito");
            vista.getDialogoEmpleado().setVisible(false);
            CargarLista("");

        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");

        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vista.getTblEmpleado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTblEmpleado();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 1).toString();
            return idSeleccion;
        }
        return null;
    }

    private void Obtener_datos() {
//        Modelo_Empleado ms = new Modelo_Empleado();
        String almacena = ElegirCasilla();
        List<Empleado> e = Modelo_Empleado.Lista_Empleados(almacena);
        for (int i = 0; i < e.size(); i++) {
            Empleado em = e.get(i);
            Image img = em.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(165, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vista.getLblfotoE().setIcon(icon);
            } else {
                vista.getLblfotoE().setIcon(null);
            }
            MostrarDialog();
            vista.getDialogoEmpleado().setTitle("EDITAR EMPLEADO");
            vista.getTxtidEmpleado().setVisible(true);
            vista.getTxtid().setVisible(true);
            vista.getTxtidEmpleado().setText(em.getCod_empleado());
            vista.getTxtidEmpleado().setEditable(false);
            vista.getTxtcedulaE().setText(em.getCedula());
            vista.getTxtcedulaE().setEditable(false);
            vista.getTxtnombreE().setText(em.getNombre());
            vista.getTxtapellidoE().setText(em.getApellido());
            vista.getDchfechaE().setDate(em.getFnacimiento());
            vista.getTxtdirecE().setText(em.getDireccion());
            vista.getTxttelfE().setText(em.getTelefono());
            vista.getCmbCargo().setSelectedItem(em.getCargo());
            vista.getTxtsueldoE().setText(em.getSueldo() + "");

        }
    }

    public void EliminarCliente() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar este Empkeado", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Modelo_Empleado me = new Modelo_Empleado(eleccion);
                if (me.Eliminar_Empleado()) {
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

    public void CargarImagen() {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblfotoE().getWidth(),
                        vista.getLblfotoE().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                vista.getLblfotoE().setIcon(ic);
                vista.getLblfotoE().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(Control_Empleado.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
