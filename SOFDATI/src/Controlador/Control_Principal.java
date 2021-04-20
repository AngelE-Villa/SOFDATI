package Controlador;

import Modelo.Categoria;
import Modelo.ModeloCliente;
import Modelo.ModeloProducto;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Categoria;
import Modelo.Modelo_Detalle;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Localidad;
import Modelo.Modelo_Servicio;
import Vista.Principal;
import Vista.VistaCategoria;
import Vista.VistaProducto;
import Vista.Vista_Cliente;
import Vista.Vista_Detalle;
import Vista.Vista_Empleado;
import Vista.Vista_Localidad;
import Vista.Vista_Nuevo_Servicio;
import Vista.Vista_Servicio;
import Vista.Vista_Vehiculo;
import desplazable.Desface;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Usuario
 */
public class Control_Principal {

    Principal principal;
    Desface desplace;

    public Control_Principal(Principal principal) {
        this.principal = principal;
        this.principal.setExtendedState(MAXIMIZED_BOTH);
        this.principal.setVisible(true);
        
        this.principal.setLocationRelativeTo(null);
        
        desplace = new Desface();
    }

    public void Inicia_Control() {
        ComponentListener cl = new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                principal.getJpBotones1().getSize(new Dimension(principal.getJpBotones1().getWidth(), principal.getHeight()));

            }

            @Override
            public void componentMoved(ComponentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentShown(ComponentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void componentHidden(ComponentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                desplazable();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                RedimnecionarPantalla();
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        principal.getJlbDesple().addMouseListener(ml);
        principal.addComponentListener(cl);
        principal.setBackground(Color.white);
        principal.setSize(1000, 600);
        principal.setLocationRelativeTo(null);
        principal.getBtnclientes().addActionListener(l -> Abrir_Clientes());
        principal.getBtnEmpleadoP().addActionListener(l -> Abrir_Empleados());
        principal.getBtnServicio().addActionListener(l -> Abrir_Servicios());
        principal.getBtndetalle().addActionListener(l -> Abrir_Detalle());
        principal.getBtnVehiculos().addActionListener(l -> Abrir_Vehiculos());
        principal.getBtnProductos().addActionListener(l -> Abrir_Productos());
        principal.getBtnCategorias().addActionListener(l -> Abrir_Categorias());
        principal.getBtnLocalidad().addActionListener(l -> Abrir_Localidades());
    }

    public void RedimnecionarPantalla() {
        if (principal.getJpBotones1().getX() == 0 && principal.getPantalla().getX() == 203) {
            principal.getPantalla().setSize(new Dimension(principal.getPantalla().getWidth() + 205, principal.getPantalla().getHeight()));
            desplace.desplazarIzquierda(principal.getPantalla(), principal.getPantalla().getX(), -18, 5, 1);

        } else if (principal.getPantalla().getX() == 48) {
             principal.getPantalla().setSize(new Dimension(principal.getPantalla().getWidth() - 203, principal.getPantalla().getHeight()));
            desplace.desplazarDerecha(principal.getPantalla(), principal.getPantalla().getX(), 203, 5, 1);
           
        }
        System.out.println("Pantalla "+principal.getPantalla().getX());
    }

    public void desplazable() {
        if (principal.getJpBotones1().getX() == 0) {
            desplace.desplazarIzquierda(principal.getJpBotones1(), principal.getJpBotones1().getX(), -130, 5, 0);
            
        } else if (principal.getJpBotones1().getX() == -130) {
            desplace.desplazarDerecha(principal.getJpBotones1(), principal.getJpBotones1().getX(), 0, 5, 0);
        }
        System.out.println("Botones "+principal.getJpBotones1().getX());
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
        principal.getPantalla().add(vs);
        Control_Nuevo_Servicio cs = new Control_Nuevo_Servicio(vs, ms);
        cs.IniciarBotones();
        cs.LLenarComboxProducto();
        cs.LLenarComboxVehiculo();

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
        ControlProducto cp = new ControlProducto(mp, vp);
        cp.iniciaControl();
        cp.cargarListaProducto1();

    }

    public void Abrir_Categorias() {
        VistaCategoria vc = new VistaCategoria();
        Modelo_Categoria mc = new Modelo_Categoria();
        principal.getPantalla().add(vc);
        ControlCategoria cc = new ControlCategoria(mc, vc);
        cc.iniciaControl();
        cc.cargarListaCategoria1();

    }

    public void Abrir_Localidades() {
        Vista_Localidad vl = new Vista_Localidad();
        Modelo_Localidad ml = new Modelo_Localidad();
        principal.getPantalla().add(vl);
        Control_Localidad cl = new Control_Localidad(ml, vl);
        cl.iniciaControl();
        cl.cargaLista1();

    }
}
