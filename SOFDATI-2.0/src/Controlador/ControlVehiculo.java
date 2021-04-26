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
        this.vista.setVisible(true);
        ValidaLetras();
        ValidaNumeros();
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
        vista.getBtnExaminar().addActionListener(l->CargarImagen());

    }

    public void switchBoton() {
        if (botonEditar) {
            grabarVehiculo();
        } else {
            editarVehiculo();
        }

    }

    public void cargaLista(String aguja) {
        vista.getTblVehiculo().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblVehiculo().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();
        System.out.println("Cargar");
        DefaultTableModel tdlModel;
        tdlModel = (DefaultTableModel) vista.getTblVehiculo().getModel();
        tdlModel.setNumRows(0);
        List<Vehiculo> Lista = ModeloVehiculo.ListarVehiculo(aguja);
        System.out.println(Lista);
        int ncols = tdlModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0); // problema con paquete 
        Lista.stream().forEach(p1 -> {
            tdlModel.addRow(new Object[ncols]);
            vista.getTblVehiculo().setValueAt(p1.getMatricula(), i.value, 0);
            vista.getTblVehiculo().setValueAt(p1.getPais(), i.value, 1);
            vista.getTblVehiculo().setValueAt(p1.getColor(), i.value, 2);
            vista.getTblVehiculo().setValueAt(p1.getFecha_matricula(), i.value, 3);
            Image img = p1.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblVehiculo().setValueAt(new JLabel(icon), i.value, 4);
            } else {
                vista.getTblVehiculo().setValueAt(null, i.value, 4);
            }
            i.value++;
        });
    }

    private void muestraDialogo() {
        vista.getDlgVehiculo().setSize(700, 350);
        vista.getDlgVehiculo().setTitle("Nuevo Registro - Vehiculo");
        vista.getDlgVehiculo().setLocationRelativeTo(vista);
        vista.getDlgVehiculo().setVisible(true);
        vista.getTxtMatricula().setText("");
        vista.getTxtPais().setText("");
        vista.getTxtColor().setText("");
        vista.getJdtFCaduce().setDate(null);
        vista.getLblfotoVeh().setText("");

    }

    private void grabarVehiculo() {
        String matricula = vista.getTxtMatricula().getText();
        String pais = vista.getTxtPais().getText();
        String color = vista.getTxtColor().getText();
        //Fechas
        Instant instant2 = vista.getJdtFCaduce().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant2, zid);
        Date fechaCaduce = Date.valueOf(zdt2.toLocalDate());

        ModeloVehiculo vehiculo = new ModeloVehiculo(matricula, pais, color, fechaCaduce);
        ImageIcon ic = (ImageIcon) vista.getLblfotoVeh().getIcon();
        vehiculo.setFoto(ic.getImage());
        if (vehiculo.grabar()) {
            cargaLista("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
            vista.getDlgVehiculo().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    private void editarVehiculo() {
        String matricula = vista.getTxtMatricula().getText();
        String pais = vista.getTxtPais().getText();
        String color = vista.getTxtColor().getText();
        //Fechas
        Instant instant2 = vista.getJdtFCaduce().getDate().toInstant();
        ZoneId zid = ZoneId.of("America/Guayaquil");
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant2, zid);
        Date fechaCaduce = Date.valueOf(zdt2.toLocalDate());

        ModeloVehiculo vehiculo = new ModeloVehiculo(matricula, pais, color, fechaCaduce);
        ImageIcon ic = (ImageIcon) vista.getLblfotoVeh().getIcon();
        vehiculo.setFoto(ic.getImage());
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
            String matricula = v.getMatricula();
            String pais = v.getPais();
            String color = v.getColor();
            Date fechaCaduce = (Date) v.getFecha_matricula();
            Image img = v.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(165, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vista.getLblfotoVeh().setIcon(icon);
            } else {
                vista.getLblfotoVeh().setIcon(null);
            }
            muestraDialogo();
            vista.getDlgVehiculo().setTitle("EDITAR VEHICULO");
            vista.getTxtMatricula().setText(matricula);
            vista.getTxtMatricula().setEditable(false);
            vista.getTxtPais().setText(pais);
            vista.getTxtColor().setText(color);
            vista.getFMatricula().setDate(fechaCaduce);
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
    
        public void CargarImagen() {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblfotoVeh().getWidth(),
                        vista.getLblfotoVeh().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                vista.getLblfotoVeh().setIcon(ic);
                vista.getLblfotoVeh().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(Control_Empleado.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
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
        
        vista.getTxtPais().addKeyListener(ke);
        vista.getTxtColor().addKeyListener(ke);
   
    }    
     
     public void ValidaNumeros(){
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               char vn = e.getKeyChar();
        if ((vn < '0' | vn > '9')){
            e.consume();}
        
            }
          
            @Override
            public void keyPressed(KeyEvent e) {
              
            }

            @Override
            public void keyReleased(KeyEvent e) {
              
            }
        };
        
        vista.getTxtMatricula().addKeyListener(ke);
         
    }
     

}
