package Controlador;

import Modelo.Categoria;
import Modelo.ConexionBADA;
import Modelo.ModeloProducto;
import Modelo.Modelo_Categoria;
import Modelo.Productos;

import Vista.VistaProducto;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

/**
 *
 * @author daysi
 */
public class ControlProducto {

    private ModeloProducto modelo;
    private VistaProducto vista;
    private boolean validarBotonA;

    public ControlProducto() {
    }

    public ControlProducto(ModeloProducto modelo, VistaProducto vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);//MOSTRAR LA 
        ValidaLetras();
        
    }

    public void iniciaControl() {

        KeyListener buscar = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                cargarListaProducto(vista.getTxtbuscar().getText());
            }
        };
        vista.getBtnvizualizar().addActionListener(l -> cargarListaProducto(""));
        vista.getBtnagregar().addActionListener(l -> {
            this.validarBotonA = true;
            muestraDialogo();
            LLenarComboxCategoria();
        });
        vista.getTxtbuscar().addKeyListener(buscar);
        vista.getBtnaceptar().addActionListener(l -> Grabar_Modificar());
        vista.getBtnmodificar().addActionListener(l -> {
            MostrarDatosProducto();
            this.validarBotonA = false;
        });
        vista.getBtneliminar().addActionListener(l -> EliminarProducto());
//        vista.getBtnexaminar().addActionListener(l -> cargarImagen());
//        vista.getBtnimprimir().addActionListener(l -> ImprimirReporte());
        vista.getBtnAgregarNuevacategoria().addActionListener(l -> AgregarNuevaCategoria());
    }

    private void Grabar_Modificar() {
        if (validarBotonA) {
            grabarProducto();
        } else {
            EditarProducto();
        }
    }

    public void AgregarNuevaCategoria() {
        String cat = JOptionPane.showInputDialog(vista, "Ingrese la Nueva Categoria");
        Modelo_Categoria mc = new Modelo_Categoria();
        String numCategoria = mc.NCategoria() + 1 + "";
        Modelo_Categoria mc1 = new Modelo_Categoria(numCategoria, "", cat);
        if (mc1.Grabar_Categoria()) {
            System.out.println("Registro Categoria");
        }
        LLenarComboxCategoria();
        vista.getCbxCategoria().setSelectedItem(cat);
    }

    public void cargarListaProducto(String aguja) {
        vista.getTablaproducto().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTablaproducto().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) vista.getTablaproducto().getModel();
        tableModel.setNumRows(0);
        List<Productos> lista = ModeloProducto.ListarProducto(aguja);
        int ncols = tableModel.getColumnCount();
        Holder<Integer> i = new Holder<Integer>(0);
        lista.stream().forEach(p1 -> {

            tableModel.addRow(new Object[ncols]);
            vista.getTablaproducto().setValueAt(p1.getCod_producto(), i.value, 0);
            vista.getTablaproducto().setValueAt(p1.getCod_categoria(), i.value, 1);
            vista.getTablaproducto().setValueAt(p1.getNombre_producto(), i.value, 2);
            vista.getTablaproducto().setValueAt(p1.getUnidad_medida(), i.value, 3);

            //completar datos
//            Image img = p1.getFoto();
//            if (img != null) {
//                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(newimg);
//                renderer.setIcon(icon);
//                vista.getTablaproducto().setValueAt(new JLabel(icon), i.value, 4);
//            } else {
//                vista.getTablaproducto().setValueAt(null, i.value, 4);
//            }
            i.value++;

        });

//        
//       
    }

    private void muestraDialogo() {

        vista.getDialogoproducto().setSize(600, 500);
        vista.setTitle("NUEVO PRODUCTO");
        vista.getDialogoproducto().setLocationRelativeTo(vista);
        vista.getTxtcodproducto().setText("");
        vista.getCbxCategoria().setSelectedIndex(0);
        vista.getTxtnompro().setText("");
        vista.getTxtunidadm().setText("");
//        vista.getLblfoto().setIcon(null);
        vista.getDialogoproducto().setVisible(true);

    }

    private void grabarProducto() {
        ModeloProducto mp = new ModeloProducto();
        String codproducto = mp.NProducto() + 1 + "";
        String categoria = (String) vista.getCbxCategoria().getSelectedItem();
        Modelo_Categoria mc = new Modelo_Categoria();
        String codcategoria = mc.codigo_Categoria(categoria);
        String nombreproducto = vista.getTxtnompro().getText();
        String unidad = vista.getTxtunidadm().getText();
        System.out.println(unidad);
        ModeloProducto producto = new ModeloProducto(codproducto, nombreproducto, unidad, codcategoria);
//        ImageIcon ic = (ImageIcon) vista.getLblfoto().getIcon();
//        producto.setFoto(ic.getImage());
        if (producto.grabar()) {
            cargarListaProducto("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamene");
            vista.getDialogoproducto().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }

    }

    private void EditarProducto() {
        String codproducto = vista.getTxtcodproducto().getText();
        String categoria = (String) vista.getCbxCategoria().getSelectedItem();
        Modelo_Categoria mc = new Modelo_Categoria();
        String codcategoria = mc.codigo_Categoria(categoria);
        String nombreproducto = vista.getTxtnompro().getText();

        String unidad = vista.getTxtunidadm().getText();

        ModeloProducto producto = new ModeloProducto(codproducto, nombreproducto, unidad, codcategoria);
//        ImageIcon ic = (ImageIcon) vista.getLblfoto().getIcon();
//        producto.setFoto(ic.getImage());
        if (producto.editar()) {
            cargarListaProducto("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamene");
            vista.getDialogoproducto().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vista.getTablaproducto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablaproducto();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void MostrarDatosProducto() {
        String Seleccioncod = ElegirCasilla();
        ModeloProducto producto = new ModeloProducto(Seleccioncod);
        LLenarComboxCategoria();
        List<Productos> lista = producto.BuscarProducto(Seleccioncod);
        for (int i = 0; i < lista.size(); i++) {
            Productos p = lista.get(i);
            String codproducto = p.getCod_producto();
            String codcategoria = p.getCod_categoria();
            String nombreproducto = p.getNombre_producto();
            String unidadm = p.getUnidad_medida();

            muestraDialogo();
//            Image img = p.getFoto();
//            if (img != null) {
//                Image newimg = img.getScaledInstance(155, 190, java.awt.Image.SCALE_SMOOTH);
//                ImageIcon icon = new ImageIcon(newimg);
//
//                vista.getLblfoto().setIcon(icon);
//            } else {
//                vista.getLblfoto().setIcon(null);
//            }
            vista.getDialogoproducto().setTitle("EDITAR PRODUCTO");
            vista.getTxtcodproducto().setText(codproducto);
            vista.getTxtcodproducto().setEditable(false);
            vista.getCbxCategoria().setSelectedItem(codcategoria);
            vista.getTxtnompro().setText(nombreproducto);
            vista.getTxtunidadm().setText(unidadm);

        }
    }

    public void LLenarComboxCategoria() {
        List<Categoria> lista = Modelo_Categoria.ListarCategorias("");
        vista.getCbxCategoria().removeAllItems();
        vista.getCbxCategoria().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Categoria c = lista.get(i);
            String categoria = c.getNombre_categoria();
            vista.getCbxCategoria().addItem(categoria);
        }

    }

    public void EliminarProducto() {
        String idSeleccion = ElegirCasilla();
        int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro de Eliminar este producto", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            ModeloProducto producto = new ModeloProducto(idSeleccion);
            if (producto.eliminar()) {
                cargarListaProducto("");
                JOptionPane.showMessageDialog(vista, "REGISTRO ELIMINADO");

            } else {
                System.out.println("ERROR AL ELIMINAR");       
            }
        }else {
            JOptionPane.showMessageDialog(vista,"Eliminacion Cancelada");
        }

    }

//    public void cargarImagen() {
//        JFileChooser jfc = new JFileChooser();
//        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        int estado = jfc.showOpenDialog(null);
//        if (estado == JFileChooser.APPROVE_OPTION) {
//
////            try {
////                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
////                        vista.getLblfoto().getWidth(),
////                        vista.getLblfoto().getHeight(),
////                        Image.SCALE_DEFAULT
////                );
////
////                vista.getLblfoto().setIcon(new ImageIcon(icono));
////                vista.getLblfoto().updateUI();
//
//            } catch (IOException ex) {
//                Logger.getLogger(ControlProducto.class
//                        .getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//    }
    private void ImprimirReporte() {
        ConexionBADA con = new ConexionBADA();
//        try {
//            
//
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/Reportes/Personas/rptpersonas.jasper"));
//            JasperPrint jp= JasperFillManager.fillReport(jr,null, con.getCon());
//            String aguja = vista.getTxtbuscar().getText();
//            Map<String, Object> parametros = new HashMap<String, Object>();
//            parametros.put("aguja", "%" + aguja + "%");
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
//            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
        
        vista.getTxtnompro().addKeyListener(ke);
        
        
    }

}
