package Controlador;

import Modelo.Empleado;
import Modelo.ModeloCliente;
import Modelo.ModeloProducto;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Categoria;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Localidad;
import Modelo.Modelo_Servicio;
import Vista.Login;
import Vista.Principal;
import Vista.VistaCategoria;
import Vista.VistaProducto;
import Vista.Vista_Cliente;
import Vista.Vista_Consultas;
import Vista.Vista_Empleado;
import Vista.Vista_Estadistica;
import Vista.Vista_Localidad;
import Vista.Vista_Nuevo_Servicio;
import Vista.Vista_Perfil;
import Vista.Vista_Vehiculo;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Control_Principal {

    Principal principal;

    public Control_Principal(Principal principal) {
        this.principal = principal;
        this.principal.setVisible(true);
        this.principal.setExtendedState(MAXIMIZED_BOTH);
//        this.principal.setLocationRelativeTo(null);
        principal.getBtnEstadistica().setVisible(false);
        CerrarJF();

    }

    public void MandarUsuario(String cod) {
        principal.getLblusuario().setText(cod);
        principal.getLblusuario().setVisible(false);
        Modelo_Empleado me = new Modelo_Empleado();
        List<Empleado> lis = me.BuscarporID(cod);
        for (int i = 0; i < lis.size(); i++) {
            Empleado e = lis.get(i);
            principal.getLblnombres().setText(e.getNombre() + " " + e.getApellido());
        }
//        principal.getLblnombres().setText(cod);
    }
    
        public void CerrarJF() {
        try {
            principal.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            principal.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
               
            });
            principal.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Confimar Cierre de Jframe
    public void confirmarSalida() {
        int index = JOptionPane.showConfirmDialog(principal, "Esta seguro de cerrar la aplicacion", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (index == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }
    }

    public void Inicia_Control() {

        principal.setBackground(Color.white);
        principal.setSize(1000, 600);
        principal.setLocationRelativeTo(null);
        principal.getBtnclientes().addActionListener(l -> Abrir_Clientes());
        principal.getBtnEmpleadoP().addActionListener(l -> Abrir_Empleados());
        principal.getBtnServicio().addActionListener(l -> Abrir_Servicios());
        principal.getBtnVehiculos().addActionListener(l -> Abrir_Vehiculos());
        principal.getBtnProductos().addActionListener(l -> Abrir_Productos());
        principal.getBtnCategorias().addActionListener(l -> Abrir_Categorias());
        principal.getBtnLocalidad().addActionListener(l -> Abrir_Localidades());
        principal.getBtnCerrarSesion().addActionListener(l -> CerrarSesion());
        principal.getBtnperfil().addActionListener(l -> perfil());
        principal.getBtnEstadistica().addActionListener(l->Estadistica());
        principal.getBtnConsultas().addActionListener(l->Abrir_Consultas());
    }

    public void Estadistica(){
        Vista_Estadistica ve=new Vista_Estadistica();
        Control_Estadistica ce=new Control_Estadistica(ve);
        ce.iniciarBotones();
    }
    
    public void MostrarEstadistica(String usuario){
        if (usuario.equals("Admin")) {
            principal.getBtnEstadistica().setVisible(true);
        } else {
            principal.getBtnEstadistica().setVisible(false);
        }
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
        Vista_Nuevo_Servicio vs = new Vista_Nuevo_Servicio();
        Modelo_Servicio ms = new Modelo_Servicio();
        CentrarVentana(vs);
        Control_Nuevo_Servicio cs = new Control_Nuevo_Servicio(vs, ms);
        String id=principal.getLblusuario().getText();
        String nom=principal.getLblnombres().getText();
        cs.IniciarBotones();
        cs.CargarEmpleadoSer(id, nom);
        cs.LLenarComboxProducto();
        cs.LLenarComboxVehiculo();

    }

    public void Abrir_Consultas() {
        Vista_Consultas vc = new Vista_Consultas();
        Modelo_Servicio mc = new Modelo_Servicio();
        CentrarVentana(vc);
        Control_Consulta cc = new Control_Consulta(vc, mc);
        cc.iniciarControl();
        cc.CargarLista("");
    }

    public void Abrir_Vehiculos() {
        Vista_Vehiculo vv = new Vista_Vehiculo();
        ModeloVehiculo mv = new ModeloVehiculo();
        CentrarVentana(vv);
        ControlVehiculo cv = new ControlVehiculo(mv, vv);
        cv.iniciaControl();
        cv.cargaLista("");

    }

    public void Abrir_Productos() {
        VistaProducto vp = new VistaProducto();
        ModeloProducto mp = new ModeloProducto();
        principal.getPantalla().add(vp);
        ControlProducto cp = new ControlProducto(mp, vp);
        cp.iniciaControl();
        cp.cargarListaProducto("");

    }

    public void Abrir_Categorias() {
        VistaCategoria vc = new VistaCategoria();
        Modelo_Categoria mc = new Modelo_Categoria();
        principal.getPantalla().add(vc);
        ControlCategoria cc = new ControlCategoria(mc, vc);
        cc.iniciaControl();
        cc.cargarListaCategoria("");

    }

    public void Abrir_Localidades() {
        Vista_Localidad vl = new Vista_Localidad();
        Modelo_Localidad ml = new Modelo_Localidad();
        principal.getPantalla().add(vl);
        Control_Localidad cl = new Control_Localidad(ml, vl);
        cl.iniciaControl();
        cl.cargaLista("");

    }

    public void CerrarSesion() {
        principal.setVisible(false);
        Login l = new Login();
        Modelo_Empleado ma = new Modelo_Empleado();
        Control_Login cl = new Control_Login(l, ma);
        cl.Iniciar_Controles();
    }

    public void perfil() {
        Vista_Perfil vp = new Vista_Perfil();
        Control_Perfil cp=new Control_Perfil(vp);
        cp.perfil(principal.getLblusuario().getText());
        cp.mostarServicio(principal.getLblusuario().getText());
        cp.iniciarBotones();
    
    }
    
    public void CentrarVentana(JInternalFrame internal){
    
        int x=(principal.getPantalla().getWidth()/2)-internal.getWidth()/2;
        int y=(principal.getPantalla().getHeight()/2)-internal.getHeight()/2;
        
        if (internal.isShowing()) {
            internal.setLocation(x, y); 
        } else {
           principal.getPantalla().add(internal);
           internal.show();
        }
    }
}
