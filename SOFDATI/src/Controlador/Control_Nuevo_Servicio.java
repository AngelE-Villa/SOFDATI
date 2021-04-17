/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Empleado;
import Modelo.ModeloCliente;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Servicio;
import Vista.Vista_Cliente;
import Vista.Vista_Nuevo_Servicio;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;

public class Control_Nuevo_Servicio {

    Vista_Nuevo_Servicio vista;
    Modelo_Servicio modelo;
    ModeloCliente modeloC;
    Vista_Cliente vistaC;

    public Control_Nuevo_Servicio(Vista_Nuevo_Servicio vista, Modelo_Servicio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);

    }

    public void IniciarBotones() {
        vista.getBtnBuscarCliente().addActionListener(l -> buscarCliente());
        vista.getBtnElegirEmpleado().addActionListener(l -> ElegirIDEmpleado());
        vista.getBtnbuscarEmpleado().addActionListener(l -> llenarTablaEmpleados());
    }

    public void buscarCliente() {
        ModeloCliente mc = new ModeloCliente();
        List<Cliente> listaC = mc.BuscarporID(vista.getTxtidcliente().getText());
        if (listaC == null) {
            int a = JOptionPane.showConfirmDialog(vista, "Desea Ingresar Un Nuevo Cliente", "Adbertencia", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                 vistaC.getDialogCliente().setVisible(true);
                 
            } else {
            }
        } else {
            for (int i = 0; i < listaC.size(); i++) {
                Cliente cli = listaC.get(i);
                vista.getLblCliente().setText(cli.getNombre() + " " + cli.getApellido());

            }
        }
    }

public void llenarTablaEmpleados() {
        vista.getDialogoEmpreado().setVisible(true);
        vista.getDialogoEmpreado().setLocationRelativeTo(vista);
        vista.getDialogoEmpreado().setSize(300, 250);
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTablaEligeEmpleado().getModel();
        tblModel.setNumRows(0);
        List<Empleado> lista = Modelo_Empleado.Lista_Empleados("");
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTablaEligeEmpleado().setValueAt(p1.getCod_empleado(), i.value, 0);
            vista.getTablaEligeEmpleado().setValueAt(p1.getNombre(), i.value, 1);
            vista.getTablaEligeEmpleado().setValueAt(p1.getApellido(), i.value, 2);
            i.value++;
        });

    }
    
    public String ElegirCasillaEmpleado() {
        String idSeleccion = "";
        int fila = vista.getTablaEligeEmpleado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablaEligeEmpleado();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void ElegirIDEmpleado() {
        String eleccion = ElegirCasillaEmpleado();
        Modelo_Empleado ms = new Modelo_Empleado();
        List<Empleado> lista = ms.BuscarporID(eleccion);
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            vista.getTxtempleado().setText(e.getCod_empleado());
            vista.getLblEmpleado().setText(e.getNombre()+" "+e.getApellido());
            vista.getDialogoEmpreado().setVisible(false);
        }

    }

}
