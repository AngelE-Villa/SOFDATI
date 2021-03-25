package Controlador;

import Modelo.ConexionPG;
import Modelo.ModeloPersona;
import Modelo.Persona;
import Vista.VistaPersona;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class ControlPersona {

    private ModeloPersona modelo;
    private VistaPersona vista;
    private boolean validarBotonA;

    public ControlPersona(ModeloPersona modelo, VistaPersona vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);//Mostrar la vista
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
                CargarLista(vista.getTxtbuscar().getText());
            }
        };

        vista.getBtnactualizar().addActionListener(l -> CargarLista(""));

        vista.getBtnnuevo().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialogo();
        });
        vista.getBtneditar().addActionListener((ActionEvent l) -> {
            MostrarPersona();
            this.validarBotonA = false;
        });

        vista.getBtnAceptar().addActionListener(l -> Grabar_Modificar());
        vista.getBtnCancelar().addActionListener(l -> CerrarDialogo());
        vista.getBtneliminar().addActionListener(l -> EliminarPersona());
        vista.getBtnCerrarJF().addActionListener(l -> CerrarJF());
        vista.getTxtbuscar().addKeyListener(kl);
        vista.getBtnExaminar().addActionListener(l -> CargarImagen());
        vista.getBtnimprimir().addActionListener(l->imprimirReporte());
    }

    private void CerrarDialogo() {
        vista.getDlgPersona().setVisible(false);
    }

    private void CerrarJF() {
        vista.setVisible(false);
    }

    private void imprimirReporte(){
        ConexionPG con= new ConexionPG();
        try {
            JasperReport jr=(JasperReport)JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Persona/MVC_Reporte.jasper"));
            JasperPrint jp= JasperFillManager.fillReport(jr,null, con.getCon());
            JasperViewer jv=new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    private void Grabar_Modificar() {
        if (validarBotonA) {
            GrabaPersona();
        } else {
            EditarPersona();
        }
    }

    public void CargarLista(String buscar) {
        vista.getTblpersona().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblpersona().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblpersona().getModel();
        tblModel.setNumRows(0);
        List<Persona> lista = ModeloPersona.ListarPersonas(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblpersona().setValueAt(p1.getIdpersona(), i.value, 0);
            vista.getTblpersona().setValueAt(p1.getNombres(), i.value, 1);
            vista.getTblpersona().setValueAt(p1.getApellidos(), i.value, 2);
            vista.getTblpersona().setValueAt(p1.getEdad(), i.value, 3);
            vista.getTblpersona().setValueAt(p1.getTelefono(), i.value, 4);
            vista.getTblpersona().setValueAt(p1.getSexo(), i.value, 5);
            vista.getTblpersona().setValueAt(p1.getSueldo(), i.value, 6);
            vista.getTblpersona().setValueAt(p1.getCupo(), i.value, 7);
            //completar datos
            Image img = p1.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vista.getTblpersona().setValueAt(new JLabel(icon), i.value, 8);
            } else {
                vista.getTblpersona().setValueAt(null, i.value, 8);
            }
            i.value++;
        });
    }

    private void MuestraDialogo() {
        vista.getDlgPersona().setVisible(true);
        vista.getDlgPersona().setTitle("NUEVA PERSONA");
        vista.getDlgPersona().setSize(650, 400);
        vista.getTxtidPersona().setText("");
        vista.getTxtNombres().setText("");
        vista.getTxtapellido().setText("");
        vista.getDateFechaN().setCalendar(null);
        vista.getTxtTelefono().setText("");
        vista.getCbsexo().setSelectedIndex(0);
        vista.getTxtSueldo().setText("");
        vista.getTxtCupo().setText("");
        vista.getLblfoto().setText("");
        vista.getDlgPersona().setLocationRelativeTo(vista);
        vista.getTxtidPersona().setEditable(true);

    }

    private void GrabaPersona() {
        if (vista.getTxtidPersona().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo ID Vacio");
        } else if (vista.getTxtNombres().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Nombre Vacio");
        } else if (vista.getTxtapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Apellido Vacio");
        } else if (vista.getDateFechaN().getCalendar() == null) {
            JOptionPane.showMessageDialog(vista, "Campo Fecha Vacio");
        } else if (vista.getTxtTelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Telefono Vacio");
        } else if (vista.getCbsexo().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vista, "Campo Seleccione Sexo");
        } else if (vista.getTxtSueldo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Sueldo Vacio");
        } else if (vista.getTxtCupo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Cupo Vacio");
        } else if (vista.getLblfoto().getIcon() == null) {
            JOptionPane.showMessageDialog(vista, "Campos Foto Vacio");
        } else {
            try {
                String idpe = vista.getTxtidPersona().getText();
                ModeloPersona p = new ModeloPersona(idpe);
                if (p.ValidarId() == true) {
                    JOptionPane.showMessageDialog(vista, "El ID ya existe");

                } else {
                    String idpersona = vista.getTxtidPersona().getText();
                    String nombres = vista.getTxtNombres().getText();
                    String apellido = vista.getTxtapellido().getText();
                    Instant instant = vista.getDateFechaN().getDate().toInstant();
                    ZoneId zoneid = ZoneId.of("America/Guayaquil");
                    ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
                    Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
                    String telefono = vista.getTxtTelefono().getText();
                    String sexo = (String) vista.getCbsexo().getSelectedItem();
                    Double sueldo = Double.parseDouble(vista.getTxtSueldo().getText());
                    int cupo = Integer.parseInt(vista.getTxtCupo().getText());
                    ModeloPersona persona = new ModeloPersona(idpersona, nombres, apellido, fechanacimiento, telefono, sexo, sueldo, cupo);
                    ImageIcon ic = (ImageIcon) vista.getLblfoto().getIcon();
                    persona.setFoto(ic.getImage());
                    if (persona.Grabar()) {
                        CargarLista("");
                        JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
                        vista.getDlgPersona().setVisible(false);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void EditarPersona() {
        if (vista.getTxtidPersona().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo ID Vacio");
        } else if (vista.getTxtNombres().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Nombre Vacio");
        } else if (vista.getTxtapellido().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Apellido Vacio");
        } else if (vista.getDateFechaN().getCalendar() == null) {
            JOptionPane.showMessageDialog(vista, "Campo Fecha Vacio");
        } else if (vista.getTxtTelefono().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Telefono Vacio");
        } else if (vista.getCbsexo().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vista, "Campo Seleccione Sexo");
        } else if (vista.getTxtSueldo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Sueldo Vacio");
        } else if (vista.getTxtCupo().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Campo Cupo Vacio");
        } else if (vista.getLblfoto().getIcon() == null) {
            JOptionPane.showMessageDialog(vista, "Campos Foto Vacio");
        } else {
            String idpersona = vista.getTxtidPersona().getText();
            String nombres = vista.getTxtNombres().getText();
            String apellido = vista.getTxtapellido().getText();
            Instant instant = vista.getDateFechaN().getDate().toInstant();
            ZoneId zoneid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
            String telefono = vista.getTxtTelefono().getText();
            String sexo = (String) vista.getCbsexo().getSelectedItem();
            Double sueldo = Double.parseDouble(vista.getTxtSueldo().getText());
            int cupo = Integer.parseInt(vista.getTxtCupo().getText());

            ModeloPersona persona = new ModeloPersona(idpersona, nombres, apellido, fechanacimiento, telefono, sexo, sueldo, cupo);
            ImageIcon ic = (ImageIcon) vista.getLblfoto().getIcon();
            persona.setFoto(ic.getImage());

            if (persona.Editar()) {
                CargarLista("");
                JOptionPane.showMessageDialog(vista, "Registro editado Satisfactoriamente");
                vista.getDlgPersona().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vista, "ERROR AL EDITAR");
            }
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vista.getTblpersona().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTblpersona();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void MostrarPersona() {
        String idSeleccion = ElegirCasilla();
        ModeloPersona persona = new ModeloPersona();
        List<Persona> lista = persona.BuscarPersona(idSeleccion);
        for (int i = 0; i < lista.size(); i++) {
            Persona p = lista.get(i);
            String id = p.getIdpersona();
            String nombre = p.getNombres();
            String apellido = p.getApellidos();
            Date fecha = p.getFnacimiento();
            String telefono = p.getTelefono();
            String sexo = p.getSexo();
            double sueldo = p.getSueldo();
            int cupo = p.getCupo();

            Image img = p.getFoto();
            if (img != null) {
                Image newimg = img.getScaledInstance(165, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vista.getLblfoto().setIcon(icon);
            } else {
                vista.getLblfoto().setIcon(null);
            }
            MuestraDialogo();
            vista.getDlgPersona().setTitle("EDITAR PERSONA");
            vista.getTxtidPersona().setText(id);
            vista.getTxtidPersona().setEditable(false);
            vista.getTxtNombres().setText(nombre);
            vista.getTxtapellido().setText(apellido);
            vista.getDateFechaN().setDate(fecha);
            vista.getTxtTelefono().setText(telefono);
            vista.getCbsexo().setSelectedItem(sexo);
            vista.getTxtSueldo().setText(sueldo + "");
            vista.getTxtCupo().setText(cupo + "");
        }
    }

    public void EliminarPersona() {
        String idSeleccion = ElegirCasilla();
        if (idSeleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro en eliminar esta persona", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                ModeloPersona persona = new ModeloPersona(idSeleccion);
                if (persona.Eliminar()) {
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
                        vista.getLblfoto().getWidth(),
                        vista.getLblfoto().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                vista.getLblfoto().setIcon(ic);
                vista.getLblfoto().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(ControlPersona.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
