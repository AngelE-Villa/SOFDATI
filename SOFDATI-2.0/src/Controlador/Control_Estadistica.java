/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBADA;
import Vista.Estadistica.Clientes;
import Vista.Estadistica.Empleados;
import Vista.Estadistica.Productos;
import Vista.Estadistica.Servicios;
import Vista.Vista_Estadistica;
import java.awt.BorderLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
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
public class Control_Estadistica {

    Vista_Estadistica vista;
    
    public Control_Estadistica(Vista_Estadistica vista) {
        this.vista = vista;
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void iniciarBotones() {
        vista.getBntEstaClientes().addActionListener(l -> EstaCliente());
        vista.getBtnEmpleados().addActionListener(l -> EstaEmpleado());
        vista.getBtnEstaProductos().addActionListener(l -> EstaProducto());
        vista.getBtnEstaServicios().addActionListener(l -> EstaServicio());

    }

    public void EstaCliente() {
        Clientes c = new Clientes();
        c.setSize(350, 250);
        c.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(c, BorderLayout.CENTER);
        Control_Esta_Cli cec=new Control_Esta_Cli(c);
        cec.botones();
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaEmpleado() {
        Empleados e = new Empleados();
        e.setSize(350, 250);
        e.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(e, BorderLayout.CENTER);
        Control_Empleado_Esta cee=new Control_Empleado_Esta(e);
        cee.botones();
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaProducto() {
        Productos p = new Productos();
        p.setSize(350, 250);
        p.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(p, BorderLayout.CENTER);
        Control_Esta_Productos cep=new Control_Esta_Productos(p);
        cep.botones();
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaServicio() {
        Servicios s = new Servicios();
        s.setSize(350, 250);
        s.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(s, BorderLayout.CENTER);
        Control_Esta_Servicio ces=new Control_Esta_Servicio(s);
        ces.botones();
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void mostrar_Esta_Genero() {
        System.out.println("Mostrar_Genero");
        ConexionBADA con = new ConexionBADA();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Empleado/Numero_Ventas_Emple.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
            JasperViewer jv = new JasperViewer(jp);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void mostrar_Esta_Genero() {
//        System.out.println("Mostrar_Genero");
//        ConexionBADA con = new ConexionBADA();
//        try {
//            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResource("/Vista/Reportes/Reporte_Empleado/Numero_Ventas_Emple.jasper"));
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, con.getCon());
//            JasperViewer jv = new JasperViewer(jp);
//            jv.setVisible(true);
//        } catch (JRException ex) {
//            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

}
