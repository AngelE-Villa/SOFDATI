/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBADA;
import Modelo.Modelo_Servicio;
import Modelo.Servicio;
import Vista.Vista_Consultas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Control_Consulta {

    Vista_Consultas vistaS;
    Modelo_Servicio modelo;
    JasperViewer jv;

    public Control_Consulta(Vista_Consultas vistaS, Modelo_Servicio modelo) {
        this.vistaS = vistaS;
        this.modelo = modelo;
//        vistaS.getBtnmodificarS().setVisible(false);
        vistaS.getBtneliminarS().setVisible(false);
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
                CargarLista(vistaS.getTxtbuscarS().getText());
            }
        };
        vistaS.getBtnactualizar().addActionListener(l -> CargarLista(""));
        vistaS.getTxtbuscarS().addKeyListener(kl);
        vistaS.getBtneliminarS().addActionListener(l -> EliminarServicio());
        vistaS.getBtnimprimirS().addActionListener(l -> imprimirReporteServicio());
        vistaS.getBtnmodificarS().addActionListener(l -> Editar());
        vistaS.getBtnDeudas().addActionListener(l -> imprimirReporteServicioDeudas());

//        vistaS.getBtnCerrarJF().addActionListener(l -> CerrarJF());
    }

    public void CargarLista(String buscar) {
//        vistaS.getTablaServicios().setDefaultRenderer(Object.class, new ImagenTabla());
//        vistaS.getTblpersona().setRowHeight(100);
//        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vistaS.getTablaServicios().getModel();
        tblModel.setNumRows(0);
        List<Servicio> lista = Modelo_Servicio.ListarServicios(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vistaS.getTablaServicios().setValueAt(p1.getCodservicio(), i.value, 0);
            vistaS.getTablaServicios().setValueAt(p1.getCodcliente(), i.value, 1);
            vistaS.getTablaServicios().setValueAt(p1.getFechaServicio(), i.value, 2);
            vistaS.getTablaServicios().setValueAt(p1.getCodciudad(), i.value, 3);
            vistaS.getTablaServicios().setValueAt(p1.getCodvehiculo(), i.value, 4);
            vistaS.getTablaServicios().setValueAt(p1.getCodempleado(), i.value, 5);
            vistaS.getTablaServicios().setValueAt(p1.getKm_salida(), i.value, 6);
            vistaS.getTablaServicios().setValueAt(p1.getKm_llegada(), i.value, 7);
            vistaS.getTablaServicios().setValueAt(p1.getPrecioServicio(), i.value, 8);
            i.value++;
        });
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vistaS.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaS, "Debe seleccionar una fila");
        } else {
            JTable tabla = vistaS.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void EliminarServicio() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vistaS, "Esta seguro en eliminar este Servicio", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Modelo_Servicio ms = new Modelo_Servicio(eleccion);
                if (ms.EliminarServicio()) {
                    CargarLista("");
                    JOptionPane.showMessageDialog(vistaS, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vistaS, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vistaS, "Eliminacion Cancelada");
            }
        }
    }

    public void Editar() {
        String a = ElegirCasilla();
        String b = JOptionPane.showInputDialog(null, "Ingrese el Precio del Servicio");
        Modelo_Servicio ms = new Modelo_Servicio(a);
        if (ms.Editar_Sueldo(Double.parseDouble(b))) {
            JOptionPane.showMessageDialog(vistaS, "Modificado");
            CargarLista("");
        }
    }

    public String ElegirCasillaCon() {

        String idSeleccion = "";
        int fila = vistaS.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaS, "Seleccione un registro del listado");
        } else {
            JTable tabla = vistaS.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void imprimirReporteServicio() {
        ConexionBADA con = new ConexionBADA();

        String servicio = ElegirCasilla();
        if (servicio.isEmpty()) {

        } else {
            try {
                JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Servicios/Reporte_Servicio.jasper"));
//            JasperPrint jp=JasperFillManager.fillReport(jr, null,con.getCon());
                Map<String, Object> parametros = new HashMap<String, Object>();
                parametros.put("servicio", servicio);
                JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
                JasperViewer jv = new JasperViewer(jp);
                jv.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void imprimirReporteServicioDeudas() {
        ConexionBADA con = new ConexionBADA();
        String a = vistaS.getTxtbuscarS().getText();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Servicios/Deudas.jasper"));
//            JasperPrint jp=JasperFillManager.fillReport(jr, null,con.getCon());
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("aguja", "%"+a+"%");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
