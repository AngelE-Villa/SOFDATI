/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.ConexionBADA;
import Modelo.Modelo_Categoria;
import Vista.VistaCategoria;




import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
public class ControlCategoria {

    private Modelo_Categoria modelo;
    private VistaCategoria vista;

    public ControlCategoria() {
    }

    public ControlCategoria(Modelo_Categoria modelo, VistaCategoria vista) {
        this.modelo = modelo;
        this.vista = vista;
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
                cargarListaCategoria(vista.getTxtbuscar().getText());
            }
        };
        vista.getBtnactualizar().addActionListener(l -> cargarListaCategoria(""));
        vista.getBtnagregar().addActionListener(l -> muestraDialogo());
        vista.getTxtbuscar().addKeyListener(buscar);
        vista.getBtnaceptar().addActionListener(l -> grabarCategoria());
        vista.getBtnmodificar().addActionListener(l -> MostrarDatosCategoria());
        vista.getBtneditar().addActionListener(l -> EditarCategoria());
        vista.getBtneliminar().addActionListener(l -> EliminarCategoria());
        
        vista.getBtnimprimir().addActionListener(l -> ImprimirReporte());
    }

    public void cargarListaCategoria(String aguja) {
        vista.getTablacategoria().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTablacategoria().setRowHeight(100);
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        DefaultTableModel tableModel;
        tableModel = (DefaultTableModel) vista.getTablacategoria().getModel();
        tableModel.setNumRows(0);
        List<Categoria> lista = Modelo_Categoria.ListarCategorias(aguja);
        int ncols = tableModel.getColumnCount();
        Holder<Integer> i = new Holder<Integer>(0);
        lista.stream().forEach(p1 -> {

            tableModel.addRow(new Object[ncols]);

            vista.getTablacategoria().setValueAt(p1.getCod_categoria(), i.value, 0);
             vista.getTablacategoria().setValueAt(p1.getDescripcion(), i.value, 1);
            vista.getTablacategoria().setValueAt(p1.getNombre_categoria(), i.value, 2);
           

            //completar datos
         
       
            i.value++;

        });

//        
//       
    }

    private void muestraDialogo() {

        vista.getBtneditar().setVisible(false);
        vista.getBtnaceptar().setVisible(true);
        vista.getDialocategoria().setSize(600, 500);
        vista.setTitle("NUEVA CATEGORIA");
        vista.getDialocategoria().setLocationRelativeTo(vista);
        vista.getTxtcodcate().setText("");

        vista.getTxtnomcate().setText("");
        vista.getTxtdescripcion().setText("");
        vista.getLblfoto().setIcon(null);
        vista.getDialocategoria().setVisible(true);

    }

    private void grabarCategoria() {
        String codcategoria = vista.getTxtcodcate().getText();
        String nombrecate = vista.getTxtnomcate().getText();
        String descripcion = vista.getTxtdescripcion().getText();

        Modelo_Categoria categoria = new Modelo_Categoria(codcategoria, descripcion, nombrecate);

        if (categoria.Grabar_Categoria()) {
            cargarListaCategoria("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamene");
            vista.getDialocategoria().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }

    }

    private void EditarCategoria() {
        String codcategoria = vista.getTxtcodcate().getText();
        String nombrecate = vista.getTxtnomcate().getText();
        String descripcion = vista.getTxtdescripcion().getText();

        Modelo_Categoria categoria = new Modelo_Categoria(codcategoria, descripcion, nombrecate);

        if (categoria.Editar_Categoria()) {
            cargarListaCategoria("");
            JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamene");
            vista.getDialocategoria().setVisible(false);
        } else {
            JOptionPane.showMessageDialog(vista, "ERROR");
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vista.getTablacategoria().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablacategoria();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void MostrarDatosCategoria() {
        String idSeleccion = ElegirCasilla();
        Modelo_Categoria categoria = new Modelo_Categoria(idSeleccion);
        List<Categoria> lista = categoria.BuscarCategoria();
        for (int i = 0; i < lista.size(); i++) {
            Categoria c = lista.get(i);
            String codcategoria = c.getCod_categoria();
            String descripcion = c.getDescripcion();
            String nombrecategoria = c.getNombre_categoria();

            muestraDialogo();
            vista.getBtnaceptar().setVisible(false);
            vista.getBtneditar().setVisible(true);

            vista.getDialocategoria().setTitle("EDITAR CATEGORIA");
            vista.getTxtcodcate().setText(codcategoria);
            vista.getTxtcodcate().setEditable(false);
            vista.getTxtdescripcion().setText(descripcion);
            vista.getTxtnomcate().setText(nombrecategoria);

        }
    }

    public void EliminarCategoria() {
//        int opcion=JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE DESEA ELIMINAR");
//        if (opcion ==0) {
        String idSeleccion = ElegirCasilla();
         Modelo_Categoria categoria =new Modelo_Categoria(idSeleccion);
        if (categoria.eliminarcategoria()) {
            cargarListaCategoria("");
            JOptionPane.showMessageDialog(vista, "REGISTRO ELIMINADO");

        } else {
        }

//        } else {
//            JOptionPane.showMessageDialog(vista, "ERROR AL ELIMINAR");
//        }
    }

    private void ImprimirReporte() {
        ConexionBADA con = new ConexionBADA();
//        try {
//
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/vista/Reportes/Personas/rptpersonas.jasper"));
////            JasperPrint jp= JasperFillManager.fillReport(jr,null, con.getCon());
//            String aguja = vista.getTxtbuscar().getText();
//            Map<String, Object> parametros = new HashMap<String, Object>();
//            parametros.put("aguja", "%" + aguja + "%");
//            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
//            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControlCategoria.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

}
