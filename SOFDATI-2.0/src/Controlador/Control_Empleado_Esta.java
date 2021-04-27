/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBADA;
import Vista.Estadistica.Empleados;
import java.util.HashMap;
import java.util.Map;
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
public class Control_Empleado_Esta {
    Empleados vista;

    public Control_Empleado_Esta(Empleados e) {
        this.vista = e;
    }
    
    public void botones(){
        vista.getBtnGenero().addActionListener(l->mostrar_Esta_Genero());
        vista.getBtnVentas().addActionListener(l->mostrar_Esta_Ventas());
    }
    
    public void mostrar_Esta_Ventas(){
        System.out.println("Mostrar_Genero");
                ConexionBADA con=new ConexionBADA();
        try {
            JasperReport jr= (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Empleado/Numero_Ventas_Emple.jasper"));       
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con.getCon());
//            Map<String,Object> parametros= new HashMap<String,Object>();
//            parametros.put("servicio","%"+servicio+"%");
//            JasperPrint jp=JasperFillManager.fillReport(jr,parametros,con.getCon());
            JasperViewer jv=new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
        public void mostrar_Esta_Genero(){
        System.out.println("Mostrar_Genero");
                ConexionBADA con=new ConexionBADA();
        try {
            JasperReport jr= (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Empleado/Sexo_Empleado.jasper"));       
            JasperPrint jp=JasperFillManager.fillReport(jr, null,con.getCon());
//            Map<String,Object> parametros= new HashMap<String,Object>();
//            parametros.put("servicio","%"+servicio+"%");
//            JasperPrint jp=JasperFillManager.fillReport(jr,parametros,con.getCon());
            JasperViewer jv=new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
