package Controlador;

import Modelo.ModeloCliente;
import Modelo.ModeloProducto;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Detalle;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Localidad;
import Modelo.Modelo_Servicio;
import Vista.Principal;
import Vista.VistaProducto;
import Vista.Vista_Cliente;
import Vista.Vista_Detalle;
import Vista.Vista_Empleado;
import Vista.Vista_Localidad;
import Vista.Vista_Servicio;
import Vista.Vista_Vehiculo;

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
        principal.getBtndetalle().addActionListener(l -> Abrir_Detalle());
        principal.getBtnVehiculos().addActionListener(l -> Abrir_Vehiculos());
        principal.getBtnProductos().addActionListener(l -> Abrir_Productos());
        principal.getBtnCategorias().addActionListener(l -> Abrir_Categorias());
        principal.getBtnLocalidad().addActionListener(l -> Abrir_Localidades());
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
    
    public void Abrir_Detalle() {
        Vista_Detalle vds = new Vista_Detalle();
        Modelo_Detalle mds = new Modelo_Detalle();
        principal.getPantalla().add(vds);
        Control_DetalleServicio cds = new Control_DetalleServicio(mds, vds);
        cds.InicioControl();
        cds.CargarLista("");
    }
    
    public void Abrir_Vehiculos() {
        Vista_Vehiculo vv = new Vista_Vehiculo();
        ModeloVehiculo mv = new ModeloVehiculo();
        principal.getPantalla().add(vv);
        ControlVehiculo cv = new ControlVehiculo(mv, vv);
        cv.iniciaControl();
        cv.cargaLista("");
        
    }
    
    public void Abrir_Productos() {
        VistaProducto vp = new VistaProducto();
        ModeloProducto mp = new ModeloProducto();
        principal.getPantalla().add(vp);
//        ControlProducto cp = new ControlProducto();
//        cp.iniciarControl();
//        cp.CargarLista("");

    }
    
    public void Abrir_Categorias() {
        Vista_Servicio vs = new Vista_Servicio();
        Modelo_Servicio ms = new Modelo_Servicio();
        principal.getPantalla().add(vs);
        Control_Servicio cs = new Control_Servicio(vs, ms);
        cs.iniciarControl();
        cs.CargarLista("");
        
    }
    
    public void Abrir_Localidades() {
        Vista_Localidad vl = new Vista_Localidad();
        Modelo_Localidad ml = new Modelo_Localidad();
        principal.getPantalla().add(vl);
        Control_Localidad cl = new Control_Localidad(ml, vl);
        cl.iniciaControl();
        cl.cargaLista("");
        
    }
}
