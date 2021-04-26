package Controlador;

import Modelo.Cliente;
import Modelo.ModeloCliente;
import Vista.Vista_Cliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
        ValidaLetras();
        ValidaNumeros();
        cedula();

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
            this.validarBotonA = true;
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
        vista.getBtnCancelarcli().addActionListener(l -> salir());
    }

    public void salir() {
        vista.getDialogCliente().setVisible(false);
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
            vista.getTblCliente().setValueAt(p.getSexo(), i.value, 5);
            vista.getTblCliente().setValueAt(p.getDireccion(), i.value, 6);
            vista.getTblCliente().setValueAt(p.getTelefono(), i.value, 7);
            i.value++;
        });

    }

    public void MostrarDialog() {
        vista.getDialogCliente().setSize(530, 420);
        vista.getDialogCliente().setTitle("Nuevo Cliente");
        vista.getDialogCliente().getTitle();
        vista.getDialogCliente().setLocationRelativeTo(null);
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
        int v = modelo.NCliente() + 1;
        String idCliente = String.valueOf(v);
        String cedula = vista.getTxtcedulacli().getText();
        String ced = cedula;
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Ingrese una cedula");
        } else {
            if (vista.getDchfechacli().getDate() == null) {
                JOptionPane.showMessageDialog(vista, "Ingrese una fecha");
            } else {
                if (modelo.ValidarCliente1(cedula) != null) {
                    System.out.println(modelo.ValidarCliente1(cedula));
                    JOptionPane.showMessageDialog(vista, "El cliente ya existe");
                } else {
                    if (modelo.ValidarCliente(cedula) != null) {
                        int a = JOptionPane.showConfirmDialog(vista, "El cliente esta desactivado \n Desea Activarlo ?", "Aviso", JOptionPane.YES_NO_OPTION);
                        if (a == JOptionPane.YES_OPTION) {
                            if (modelo.ReactivarCliente(cedula)) {
                                JOptionPane.showMessageDialog(vista, "Cliente Reactivardo");
                                vista.getDialogCliente().setVisible(false);
                                CargarLista("");
                            } else {
                                System.out.println("Error al activar Cliente");
                            }
                        } else {
                            JOptionPane.showMessageDialog(vista, "Ingrese otra cedula");
                        }

                    } else {
                        ced = cedula;
                        String nombres = vista.getTxtnombrecli().getText();
                        String apellidos = vista.getTxtapellidocli().getText();
                        Instant intate = vista.getDchfechacli().getDate().toInstant();
                        ZoneId zona = ZoneId.of("America/Guayaquil");
                        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
                        Date fnacimiento = Date.valueOf(zot.toLocalDate());
                        String telefono = vista.getTxttelfcli().getText();
                        String direccion = vista.getTxtdireccli().getText();
                        String sexo = (String) vista.getCmbxsexo().getSelectedItem();

                        if (modelo.ValidarCedulaPersona(cedula)) {
                            ModeloCliente cli = new ModeloCliente(idCliente, cedula, nombres, apellidos, fnacimiento, direccion, telefono, sexo);
                            if (cli.Grabar_Solo_Cliente()) {
                                CargarLista("");
                                vista.getDialogCliente().setVisible(false);

                                JOptionPane.showMessageDialog(vista, "CLIENTE NUEVO GUARDADO CORRECTAMENTE");
                            } else {
                                JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
                            }

                        } else {
                            ModeloCliente cli = new ModeloCliente(idCliente, cedula, nombres, apellidos, fnacimiento, direccion, telefono, sexo);
                            if (cli.Grabar_Solo_Cliente()) {
                                CargarLista("");
                                vista.getDialogCliente().setVisible(false);

                                JOptionPane.showMessageDialog(vista, "CLIENTE NUEVO GUARDADO CORRECTAMENTE");
                            } else {
                                JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
                            }
                        }

                    }
                }

            }
        }

    }

    private void EditarCliente() {
        if (vista.getDchfechacli().getDate() == null) {
            JOptionPane.showMessageDialog(vista, "Ingrese una fecha");
        } else {
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
            String sexo = (String) vista.getCmbxsexo().getSelectedItem();

            ModeloCliente cliente = new ModeloCliente(idpersona, cedula, nombre, apellido, fnacimiento, direccion, telefono, sexo);

            if (cliente.EditarCliente()) {
                JOptionPane.showMessageDialog(vista, "Cliente modificado con exito");

            } else {
                JOptionPane.showMessageDialog(vista, "ERROR");

            }
            vista.getDialogCliente().setVisible(false);
            CargarLista("");

        }

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
            vista.getCmbxsexo().setSelectedItem(cli.getSexo());
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

        vista.getTxtnombrecli().addKeyListener(ke);
        vista.getTxtapellidocli().addKeyListener(ke);

    }

    public void ValidaNumeros() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char vn = e.getKeyChar();
                if ((vn < '0' | vn > '9')) {
                    e.consume();
                }
                if (vista.getTxttelfcli().getText().length() == 10 & vista.getTxtcedulacli().getText().length() == 10) {
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

        vista.getTxtcedulacli().addKeyListener(ke);
        vista.getTxttelfcli().addKeyListener(ke);
    }

    public boolean ValidacionesCedula(String cedula) {
        int c, suma = 0, acum, resta = 0;
        try {
            for (int i = 0; i < vista.getTxtcedulacli().getText().length() - 1; i++) {
                c = Integer.parseInt(vista.getTxtcedulacli().getText().charAt(i) + "");
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
            ultimos = Integer.parseInt(vista.getTxtcedulacli().getText().charAt(9) + "");
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

    public void cedula() {
        KeyListener ValidacionesCedula = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ValidacionesCedula("");
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                if (ValidacionesCedula(vista.getTxtcedulacli().getText()) == true) {
                    vista.getTxtcedulacli().setForeground(Color.GREEN);
                    vista.getTxtcedulacli().setText("/");
                } else {
                    vista.getTxtcedulacli().setText("*");
                    vista.getTxtcedulacli().setForeground(Color.RED);
                }
            }
        };
    }

}
