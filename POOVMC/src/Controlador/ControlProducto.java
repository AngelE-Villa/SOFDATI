/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloProducto;
import Modelo.Producto;
import Vista.VistaProducto;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;
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
import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Usuario
 */
public class ControlProducto {

    private ModeloProducto modeloP;
    private VistaProducto vistaP;
    DefaultTableModel tblModel;
    private boolean validarBotonA;

    public ControlProducto(ModeloProducto modeloP, VistaProducto vistaP) {
        this.modeloP = modeloP;
        this.vistaP = vistaP;
        vistaP.setVisible(true);//Mostrar la vista
    }

    public void iniciarControlP() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarListaProd(vistaP.getTxtbuscarProd().getText());
            }
        };

        vistaP.getBtnactualizarProd().addActionListener(l -> CargarListaProd(""));

        vistaP.getBtnnuevoprod().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialogoProd();
        });
        vistaP.getBtneditarProd().addActionListener((ActionEvent l) -> {
            MostrarProducto();
            this.validarBotonA = false;
        });

        vistaP.getBtnAceptarprod().addActionListener(l -> Grabar_Modificar());
        vistaP.getBtnCancelarprod().addActionListener(l -> CerrarDialogo());
        vistaP.getBtneliminarProd().addActionListener(l -> EliminarProducto());
        vistaP.getBtnCerrarJFProd().addActionListener(l -> CerrarJF());
        vistaP.getTxtbuscarProd().addKeyListener(kl);
        vistaP.getBtnExaminar().addActionListener(l -> CargarImagen());
    }

    private void CerrarDialogo() {
        vistaP.getDlgProducto().setVisible(false);
    }

    private void CerrarJF() {
        vistaP.setVisible(false);
    }

    private void Grabar_Modificar() {

        if (validarBotonA) {
            GrabaProducto();
        } else {
            EditarProducto();
        }

    }

    public void CargarListaProd(String buscar) {
        vistaP.getTblproducto().setDefaultRenderer(Object.class, new ImagenTabla());
        vistaP.getTblproducto().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        tblModel = (DefaultTableModel) vistaP.getTblproducto().getModel();
        tblModel.setNumRows(0);
        List<Producto> lista = ModeloProducto.ListarProducto(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vistaP.getTblproducto().setValueAt(p1.getCodproducto(), i.value, 0);
            vistaP.getTblproducto().setValueAt(p1.getNomproducto(), i.value, 1);
            vistaP.getTblproducto().setValueAt(p1.getDescriproducto(), i.value, 2);
            vistaP.getTblproducto().setValueAt(p1.getCosto(), i.value, 3);
            vistaP.getTblproducto().setValueAt(p1.getPrecio(), i.value, 4);
            vistaP.getTblproducto().setValueAt(p1.getCategproducto(), i.value, 5);

            Image img = p1.getImagen();
            if (img != null) {
                Image newimg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                renderer.setIcon(icon);
                vistaP.getTblproducto().setValueAt(new JLabel(icon), i.value, 6);
            } else {
                vistaP.getTblproducto().setValueAt(null, i.value, 6);
            }
            i.value++;
        });
    }

    private void MuestraDialogoProd() {
        vistaP.getDlgProducto().setVisible(true);
        vistaP.getDlgProducto().setTitle("NUEVA PRODUCTO");
        vistaP.getDlgProducto().setSize(550, 400);
        vistaP.getTxtcodprod().setText("");
        vistaP.getTxtNombreprod().setText("");
        vistaP.getTfdescripcionprod().setText("");
        vistaP.getTxtCostoprod().setText("");
        vistaP.getTxtPrecioprod().setText("");
        vistaP.getCbCategoriaprod().setSelectedIndex(0);
        vistaP.getDlgProducto().setLocationRelativeTo(vistaP);
        vistaP.getTxtcodprod().setEditable(true);
    }

    private void GrabaProducto() {
        if (vistaP.getTxtcodprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Codigo Vacio");
        } else if (vistaP.getTxtNombreprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Nombre Vacio");
        } else if (vistaP.getTfdescripcionprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Descripcion Vacio");
        } else if (vistaP.getTxtCostoprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Costo Vacio");
        } else if (vistaP.getTxtPrecioprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Precio Vacio");
        } else if (vistaP.getCbCategoriaprod().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vistaP, "Campo Seleccione Categoria");
        } else {
            try {
                String codpro = vistaP.getTxtcodprod().getText();
                ModeloProducto p = new ModeloProducto(codpro);
                if (p.ValidarCodigo() == true) {
                    JOptionPane.showMessageDialog(vistaP, "El codigo ya existe");

                } else {
                    String codprod = vistaP.getTxtcodprod().getText();
                    String nombre = vistaP.getTxtNombreprod().getText();
                    String descriprod = vistaP.getTfdescripcionprod().getText();
                    double costo = Double.parseDouble(vistaP.getTxtCostoprod().getText());
                    double precio = Double.parseDouble(vistaP.getTxtPrecioprod().getText());
                    String categoria = (String) vistaP.getCbCategoriaprod().getSelectedItem();

                    ModeloProducto producto = new ModeloProducto(codprod, nombre, descriprod, costo, precio, categoria);
                    ImageIcon ic = (ImageIcon) vistaP.getLblimagenprod().getIcon();
                    producto.setImagen(ic.getImage());
                    System.out.println(ic.getImage());
                    if (producto.GrabarProducto()) {
                        CargarListaProd("");
                        JOptionPane.showMessageDialog(vistaP, "Registro grabado Satisfactoriamente");
                        vistaP.getDlgProducto().setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(vistaP, "Error al Grabar");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControlPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void EditarProducto() {
        if (vistaP.getTxtcodprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Codigo Vacio");
        } else if (vistaP.getTxtNombreprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Nombre Vacio");
        } else if (vistaP.getTfdescripcionprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Descripcion Vacio");
        } else if (vistaP.getTxtCostoprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Costo Vacio");
        } else if (vistaP.getTxtPrecioprod().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Campo Precio Vacio");
        } else if (vistaP.getCbCategoriaprod().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(vistaP, "Campo Seleccione Categoria");
        } else {
            String codprod = vistaP.getTxtcodprod().getText();
            String nombre = vistaP.getTxtNombreprod().getText();
            String descriprod = vistaP.getTfdescripcionprod().getText();
            double costo = Double.parseDouble(vistaP.getTxtCostoprod().getText());
            double precio = Double.parseDouble(vistaP.getTxtPrecioprod().getText());
            String categoria = (String) vistaP.getCbCategoriaprod().getSelectedItem();
            ModeloProducto producto = new ModeloProducto(codprod, nombre, descriprod, costo, precio, categoria);
            ImageIcon ic = (ImageIcon) vistaP.getLblimagenprod().getIcon();
            producto.setImagen(ic.getImage());

            if (producto.EditarProducto()) {
                CargarListaProd("");
                JOptionPane.showMessageDialog(vistaP, "Registro editado Satisfactoriamente");
                vistaP.getDlgProducto().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vistaP, "Error al Editar");
            }
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vistaP.getTblproducto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaP, "Debe seleccionar una fila");
        } else {
            JTable tabla = vistaP.getTblproducto();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void MostrarProducto() {
        String idSeleccion = ElegirCasilla();
        ModeloProducto producto = new ModeloProducto();
        List<Producto> lista = producto.BuscarProducto(idSeleccion);
        for (int i = 0; i < lista.size(); i++) {
            Producto p = lista.get(i);
            String codprod = p.getCodproducto();
            String nombre = p.getNomproducto();
            String descriprod = p.getDescriproducto();
            Double costo = p.getCosto();
            Double precio = p.getPrecio();
            String cateprod = p.getCategproducto();
            Image img = p.getImagen();
            if (img != null) {
                Image newimg = img.getScaledInstance(165, 150, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(newimg);
                vistaP.getLblimagenprod().setIcon(icon);
            } else {
                vistaP.getLblimagenprod().setIcon(null);
            }
            MuestraDialogoProd();
            vistaP.getDlgProducto().setTitle("EDITAR PRODUCTO");
            vistaP.getTxtcodprod().setText(codprod);
            vistaP.getTxtcodprod().setEditable(false);
            vistaP.getTxtNombreprod().setText(nombre);
            vistaP.getTfdescripcionprod().setText(descriprod);
            vistaP.getTxtCostoprod().setText(costo + "");
            vistaP.getTxtPrecioprod().setText(precio + "");
            vistaP.getCbCategoriaprod().setSelectedItem(cateprod);
        }
    }

    public void EliminarProducto() {
        String idSeleccion = ElegirCasilla();
        if (idSeleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vistaP, "Esta seguro en eliminar este producto", " Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                ModeloProducto producto = new ModeloProducto(idSeleccion);
                if (producto.EliminarProducto()) {
                    CargarListaProd("");
                    JOptionPane.showMessageDialog(vistaP, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vistaP, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vistaP, "Eliminacion Cancelada");
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
                        vistaP.getLblimagenprod().getWidth(),
                        vistaP.getLblimagenprod().getHeight(),
                        Image.SCALE_DEFAULT
                );
                vistaP.getLblimagenprod().setIcon(new ImageIcon(icono));
            } catch (IOException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
