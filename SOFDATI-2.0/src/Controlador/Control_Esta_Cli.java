/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBADA;
import Vista.Estadistica.Clientes;
import Vista.Estadistica.Empleados;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Usuario
 */
public class Control_Esta_Cli {

    Clientes vista;

    public Control_Esta_Cli(Clientes vista) {
        this.vista = vista;
    }

    public void botones() {
        vista.getBtnGenero().addActionListener(l -> mostrar_Esta_Genero());
        vista.getBtnLocalizaciones().addActionListener(l -> mostrar_Esta_Localizacion());
    }

    public void mostrar_Esta_Genero() {
        System.out.println("Mostrar_Genero");
        ConexionBADA con = new ConexionBADA();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reportes_Cliente/Genero_Cliente.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrar_Esta_Localizacion() {
        ConexionBADA con = new ConexionBADA();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reportes_Cliente/Localizacion_Clientes.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
