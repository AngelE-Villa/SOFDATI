package Controlador;

import Modelo.ModeloCliente;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Servicio;
import Vista.Principal;
import Vista.Vista_Cliente;
import Vista.Vista_Empleado;
import Vista.Vista_Servicio;

/**
 *
 * @author Usuario
 */
public class Control_Principal {

    Principal principal;

    public Control_Principal(Principal principal) {
        this.principal = principal;
        this.principal.setVisible(true);
    }

    public void Inicia_Control() {
        principal.getBtnclientes().addActionListener(l -> Abrir_Clientes());
        principal.getBtnEmpleadoP().addActionListener(l -> Abrir_Empleados());
        principal.getBtnServicio().addActionListener(l -> Abrir_Servicios());
    }

    public void Abrir_Clientes() {
        Vista_Cliente vc = new Vista_Cliente();
        ModeloCliente mc = new ModeloCliente();
        principal.getPantalla().add(vc);
        Control_Cliente cc = new Control_Cliente(mc, vc);
        cc.InicioControl();
        cc.CargarLista("");

    }

    public void Abrir_Empleados() {
        Vista_Empleado ve = new Vista_Empleado();
        Modelo_Empleado me = new Modelo_Empleado();
        principal.getPantalla().add(ve);
        Control_Empleado ce = new Control_Empleado(ve, me);
        ce.InicioControl();
        ce.CargarLista("");
    }

    public void Abrir_Servicios() {
        Vista_Servicio vs = new Vista_Servicio();
        Modelo_Servicio ms = new Modelo_Servicio();
        principal.getPantalla().add(vs);
        Control_Servicio cs = new Control_Servicio(vs, ms);
        cs.iniciarControl();
        cs.CargarLista("");

    }

}
