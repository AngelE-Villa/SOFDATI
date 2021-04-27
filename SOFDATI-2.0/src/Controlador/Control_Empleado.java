package Controlador;

import Modelo.ConexionBADA;
import Modelo.Empleado;
import Modelo.Modelo_Empleado;
import Vista.Vista_Empleado;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class Control_Empleado {

    Vista_Empleado vista;
    Modelo_Empleado modelo;
    private boolean validarBotonA;

    public Control_Empleado(Vista_Empleado vista, Modelo_Empleado modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);
        this.vista.setLocale(Locale.UK);
        ValidaLetras();
        ValidaNumeros();
        ValidaDoubles();

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
        vista.getBtnImprimirE().addActionListener(P -> imprimirEmpleados());

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
            vista.getTblEmpleado().setValueAt(p.getSexo(), i.value, 5);
            vista.getTblEmpleado().setValueAt(p.getDireccion(), i.value, 6);
            vista.getTblEmpleado().setValueAt(p.getTelefono(), i.value, 7);
            vista.getTblEmpleado().setValueAt(p.getCargo(), i.value, 8);
            vista.getTblEmpleado().setValueAt(p.getSueldo(), i.value, 9);
            Image img = p.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblEmpleado().setValueAt(new JLabel(icon), i.value, 10);
            } else {
                vista.getTblEmpleado().setValueAt(null, i.value, 10);
            }

            i.value++;
        });

    }

    private void MostrarDialog() {
        vista.getDialogoEmpleado().setSize(514, 516);
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
        vista.getCmbxsexo().setSelectedIndex(0);
    }

    private void Grabar_Empleado() { //crear
        int v = modelo.NEmpleados() + 1;
        String cod_empleado = String.valueOf(v);
        String cedula = vista.getTxtcedulaE().getText();
        String ced = cedula;
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cedula");
        } else {
            if (vista.getDchfechaE().getDate() == null) {
                JOptionPane.showMessageDialog(vista, "Ingrese una fecha");
            } else {
                if (modelo.ValidarEmpleado1(cedula) != null) {
                    System.out.println(modelo.ValidarEmpleado1(cedula));
                    JOptionPane.showMessageDialog(vista, "El Empleado ya existe");
                } else {
                    if (modelo.ValidarEmpleado(cedula) != null) {
                        int a = JOptionPane.showConfirmDialog(vista, "El Empleado esta desactivado \n Desea Activarlo ?", "Aviso", JOptionPane.YES_NO_OPTION);
                        if (a == JOptionPane.YES_OPTION) {
                            if (modelo.ReactivarEmpleado(cedula)) {
                                JOptionPane.showMessageDialog(vista, "Cliente Reactivardo");
                                vista.getDialogoEmpleado().setVisible(false);
                                CargarLista("");
                            } else {
                                System.out.println("Error al activar Empleado");
                            }
                        } else {
                            JOptionPane.showMessageDialog(vista, "Ingrese otra cedula");
                        }

                    } else {
                        ced = cedula;
                        String nombres = vista.getTxtnombreE().getText();
                        String apellidos = vista.getTxtapellidoE().getText();
                        Instant intate = vista.getDchfechaE().getDate().toInstant();
                        ZoneId zona = ZoneId.of("America/Guayaquil");
                        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
                        Date fnacimiento = Date.valueOf(zot.toLocalDate());
                        String telefono = vista.getTxttelfE().getText();
                        String direccion = vista.getTxtdirecE().getText();
                        String cargo = vista.getCmbCargo().getSelectedItem().toString();
                        double sueldo;
                        if (vista.getTxtdirecE().getText().isEmpty()) {
                            sueldo = 0;
                        } else {
                            sueldo = Double.valueOf(vista.getTxtsueldoE().getText());
                        }
                        String sexo = vista.getCmbxsexo().getSelectedItem().toString();

                        if (modelo.ValidarCedulaPersona(cedula)) {
                            Modelo_Empleado em = new Modelo_Empleado(cod_empleado, sueldo, cargo, "", "", cedula, nombres, apellidos, fnacimiento, direccion, telefono, sexo);
                            if (vista.getLblfotoE().getIcon() == null) {
                                System.out.println("Entra");
                                em.setFoto(null);
                            } else {
                                System.out.println("Entra1");
                                ImageIcon ic = (ImageIcon) vista.getLblfotoE().getIcon();
                                em.setFoto(ic.getImage());
                            }

                            if (em.Grabar_Solo_Empleado()) {
                                CargarLista("");
                                vista.getDialogoEmpleado().setVisible(false);

                                JOptionPane.showMessageDialog(vista, "EMPLEADO NUEVO GUARDADO CORRECTAMENTE");
                            } else {
                                JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
                            }

                        } else {
                            Modelo_Empleado em = new Modelo_Empleado(cod_empleado, sueldo, cargo, "", "", cedula, nombres, apellidos, fnacimiento, direccion, telefono, sexo);
                            if (vista.getLblfotoE().getIcon() == null) {
                                System.out.println("Entra");
                                em.setFoto(null);
                            } else {
                                System.out.println("Entra1");
                                ImageIcon ic = (ImageIcon) vista.getLblfotoE().getIcon();
                                em.setFoto(ic.getImage());
                            }

                            if (em.Grabar_Empleado()) {
                                CargarLista("");
                                vista.getDialogoEmpleado().setVisible(false);

                                JOptionPane.showMessageDialog(vista, "EMPLEADO NUEVO GUARDADO CORRECTAMENTE");
                            } else {
                                JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
                            }
                        }

                    }
                }
            }
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

        String sexo = vista.getCmbxsexo().getSelectedItem().toString();

        Modelo_Empleado em = new Modelo_Empleado(cod_empleado, sueldo, cargo, "", "", cedula, nombres, apellidos, fnacimiento, direccion, telefono, sexo);
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
            vista.getCmbxsexo().setSelectedItem(em.getSexo());
        }
    }

    public void EliminarCliente() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar este Empleado", "Advertencia", JOptionPane.YES_NO_OPTION);
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

    public void ValidaNumeros() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char vn = e.getKeyChar();
                if ((vn < '0' | vn > '9')) {
                    e.consume();
                }
                if (vista.getTxttelfE().getText().length() == 10) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        vista.getTxtcedulaE().addKeyListener(ke);
        vista.getTxttelfE().addKeyListener(ke);
    }

    public void ValidaDoubles() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char vn = e.getKeyChar();
                if ((vn < '0' | vn > '9') & (vn != 46)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        vista.getTxtsueldoE().addKeyListener(ke);
    }

    public void ValidaLetras() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char valida = e.getKeyChar();
                if (((valida < 'a' | valida > 'z') & (valida < 'A' | valida > 'Z') & (valida < 'a') && (valida != KeyEvent.VK_SPACE))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        vista.getTxtnombreE().addKeyListener(ke);
        vista.getTxtapellidoE().addKeyListener(ke);
        vista.getTxtapellidoE().addKeyListener(ke);

    }

    public boolean ValidacionesCedula(String cedula) {
        int c, suma = 0, acum, resta = 0;
        try {
            for (int i = 0; i < vista.getTxtcedulaE().getText().length() - 1; i++) {
                c = Integer.parseInt(vista.getTxtcedulaE().getText().charAt(i) + "");
                if (i % 2 == 0) {
                    c = c * 2;
                    if (c > 9) {
                        c = c - 9;
                    }
                }
                suma = suma + c;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cedula Ecuatoriana no tinen letras por defecto", "ERROR", 0);
            return false;
        }
        if (suma % 10 != 0) {
            acum = ((suma / 10) + 1) * 10;
            resta = acum - suma;
        }
        int ultimos = 0;
        try {
            ultimos = Integer.parseInt(vista.getTxtcedulaE().getText().charAt(9) + "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cumple dos 10 dijitos por defecto", "ERROR", 0);
            return false;
        }
        int ultimo = ultimos;
        if (ultimo == resta) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "la cedula es incorrecta o no existe por defecto", "ERROR", 0);
            return false;
        }
    }

    KeyListener ValidacionesCedula = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            ValidacionesCedula("");
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
            if (ValidacionesCedula(vista.getTxtcedulaE().getText()) == true) {
                vista.getTxtcedulaE().setForeground(Color.GREEN);
                vista.getTxtcedulaE().setText("/");
            } else {
                vista.getTxtcedulaE().setText("*");
                vista.getTxtcedulaE().setForeground(Color.RED);
            }
        }
    };

    public void imprimirEmpleados() {
        ConexionBADA con = new ConexionBADA();
        try {
            String emp = vista.getTxtBuscarE().getText();
            System.out.println(emp);
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Empleado/Empleados.jasper"));
//            JasperPrint jp=JasperFillManager.fillReport(jr, null,con.getCon());
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("aguja", "%" + emp + "%");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Control_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
