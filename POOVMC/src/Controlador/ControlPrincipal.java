package Controlador;

import Modelo.ModeloPersona;
import Modelo.ModeloProducto;
import Vista.Principal;
import Vista.VistaPersona;
import Vista.VistaProducto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControlPrincipal {

    Principal principal;

    public ControlPrincipal(Principal principal) {
        this.principal = principal;
        this.principal.setVisible(true);
        this.principal.setLocationRelativeTo(null);
        this.principal.setTitle("Programa");
    }

    public void IniciarControl() {
        principal.getBtnAbirPersona().addActionListener(l -> muestraClientes());
        principal.getBtnAbrirProductos().addActionListener(l -> muestraProductos());
        CerrarJF();
    }

    //Metodo Cerrar Jframe
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

    //Mostar Personas
    public void muestraClientes() {
        VistaPersona v = new VistaPersona();
        ModeloPersona n = new ModeloPersona();
        principal.getDesktop().add(v);
        ControlPersona c = new ControlPersona(n, v);
        c.iniciarControl();
        c.CargarLista("");

    }

    //Mostar Productos
    public void muestraProductos() {
        VistaProducto vp = new VistaProducto();
        ModeloProducto mp = new ModeloProducto();
        principal.getDesktop().add(vp);
        ControlProducto cp = new ControlProducto(mp, vp);
        cp.iniciarControlP();
        cp.CargarListaProd("");

    }

    class WindowAdapterImpl extends WindowAdapter {

        public WindowAdapterImpl() {
        }

        public void windowCerrar(WindowAdapter e) {
            confirmarSalida();
        }
    }

}
