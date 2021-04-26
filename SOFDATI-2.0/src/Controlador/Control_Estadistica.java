/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Estadistica.Clientes;
import Vista.Estadistica.Empleados;
import Vista.Estadistica.Productos;
import Vista.Estadistica.Servicios;
import Vista.Vista_Estadistica;
import java.awt.BorderLayout;
import javax.swing.JFrame;

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
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaEmpleado() {
        Empleados e = new Empleados();
        e.setSize(350, 250);
        e.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(e, BorderLayout.CENTER);
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaProducto() {
        Productos p = new Productos();
        p.setSize(350, 250);
        p.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(p, BorderLayout.CENTER);
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

    public void EstaServicio() {
        Servicios s = new Servicios();
        s.setSize(350, 250);
        s.setLocation(5, 5);
        vista.getContenedor().removeAll();
        vista.getContenedor().add(s, BorderLayout.CENTER);
        vista.getContenedor().revalidate();
        vista.getContenedor().repaint();

    }

}
