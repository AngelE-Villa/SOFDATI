/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Detalle_Servicio;
import Modelo.Empleado;
import Modelo.ModeloCliente;
import Modelo.ModeloProducto;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Detalle;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Localidad;
import Modelo.Modelo_Servicio;
import Modelo.Productos;
import Modelo.Vehiculo;
import Vista.VistaProducto;
import Vista.Vista_Cliente;
import Vista.Vista_Nuevo_Servicio;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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
    VistaProducto vistaP;
    Modelo_Detalle modeloD;

    public Control_Nuevo_Servicio(Vista_Nuevo_Servicio vista, Modelo_Servicio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setVisible(true);

    }
    public void CargarEmpleadoSer(String id, String nom){
        vista.getLblIDEmpleado().setText(id);
        vista.getLblnombreEmp().setText(nom);
    }
    public void IniciarBotones() {
        vista.getBtnBuscarCliente().addActionListener(l -> buscarCliente());
        vista.getBtnElegirEmpleado().addActionListener(l -> ElegirIDEmpleado());
        vista.getBtnbuscarEmpleado().addActionListener(l -> llenarTablaEmpleados());
        vista.getMasProductos().addActionListener(l -> AgregarMas());
        vista.getBtnQuitarProducto().addActionListener(l -> QuitarProducto());
        vista.getBtnaceptarNS().addActionListener(l -> CerrarServicio());
        vista.getBtncancelarNS().addActionListener(l -> Cancelar());
        vista.getBtnAceptarcli().addActionListener(l->GrabarCliente());
        vista.getBtnCancelarcli().addActionListener(l->salir());
        vista.getBtnAgregarNuevoProducto().addActionListener(l->AgregarNuevaProducto());
    }
    
    public void salir(){
      vista.getDialogCliente().setVisible(false);
    }

    public void buscarCliente() {
        if (vista.getTxtidcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaP, "Ingrese la cedula del Cliente");
        } else {
            ModeloCliente mc = new ModeloCliente();
            List<Cliente> listaC = mc.BuscarporID(vista.getTxtidcliente().getText());
            if (listaC.isEmpty()) {
                int a = JOptionPane.showConfirmDialog(vista, "Desea Ingresar Un Nuevo Cliente", "Mensaje", JOptionPane.YES_NO_OPTION);
                if (a == JOptionPane.YES_OPTION) {
                   MostrarDialogoCli();
                } 
            } else {
                for (int i = 0; i < listaC.size(); i++) {
                    Cliente cli = listaC.get(i);
                    vista.getLblCliente().setText(cli.getNombre() + " " + cli.getApellido());

                }
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
            vista.getLblEmpleado().setText(e.getNombre() + " " + e.getApellido());
            vista.getDialogoEmpreado().setVisible(false);
        }
    }

    public void CerrarServicio() {
        JOptionPane.showMessageDialog(vistaP, "Servicio Guardado Correctamentte");
        vista.setVisible(false);
    }

    public void GuardarServicio() {
        System.out.println("Guardar Servicio");
        double totalServicio;
        double kmSalida;
        double kmLlegada;
        String cod_ciudad;
        String codservicio = vista.getLblNServicio().getText();
        modelo = new Modelo_Servicio(codservicio);
        if (modelo.ValidarServicio()) {
            System.out.println("Existe Servicio");
        } else {
            String codEmpSer=vista.getLblIDEmpleado().getText();
            System.out.println(codEmpSer);
            //Busca en base de datos si existe el cliente y si no lo creo
            String cliente = vista.getTxtidcliente().getText();
            System.out.println(cliente);
            ModeloCliente mc = new ModeloCliente();
            String id = mc.CodCliente(cliente);
            Instant instant = vista.getTxtJfechaServicio().getDate().toInstant();
            ZoneId zoneid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());

            String ciudad = vista.getTxtciudadSer().getText();
            Modelo_Localidad ml = new Modelo_Localidad();
            String cod = ml.CodLocalizacion(ciudad);
            if (cod.equals("")) {
                cod_ciudad = String.valueOf(ml.NLocalizacion() + 1);
                Modelo_Localidad mlc = new Modelo_Localidad(cod_ciudad, "Ecuador", ciudad, "");
                mlc.grabar();
                cod_ciudad = cod_ciudad;
            } else {
                cod_ciudad = cod;
            }
            //Hasta aqui localidad
            String codempleado = vista.getTxtempleado().getText();
            String codVehiculo = (String) vista.getCbVehiculo().getSelectedItem();

            //Validar que ni sea Obligatorio el total
            if (vista.getTxtkmsalida().getText().isEmpty()) {
                kmSalida = 0.0;
            } else {
                kmSalida = Double.parseDouble(vista.getTxtkmsalida().getText());
            }
            if (vista.getTxtkmllegada().getText().isEmpty()) {
                kmLlegada = 0.0;
            } else {
                kmLlegada = Double.parseDouble(vista.getTxtkmllegada().getText());
            }
            if (vista.getTxttotalServicio().getText().isEmpty()) {
                totalServicio = 0.0;
            } else {
                totalServicio = Double.parseDouble(vista.getTxttotalServicio().getText());
            }
            Modelo_Servicio servicio = new Modelo_Servicio(codservicio, fechanacimiento, kmLlegada, kmSalida, codVehiculo, codempleado, id, cod_ciudad, totalServicio,codEmpSer);
            if (servicio.Grabar_Servicio()) {
                JOptionPane.showMessageDialog(vista, "Registro grabado Satisfactoriamente");
            }
        }
    }

    public void LLenarComboxProducto() {
        List<Productos> lista = ModeloProducto.ListarProducto("");
        vista.getCbxproducto().removeAllItems();
        vista.getCbxproducto().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Productos p = lista.get(i);
            String nomprod = p.getNombre_producto();
            vista.getCbxproducto().addItem(nomprod);
        }
        vista.getLblNServicio().setText(modelo.NServicio() + 1 + "");
    }

    public void LLenarComboxVehiculo() {
        List<Vehiculo> lista = ModeloVehiculo.ListarVehiculo("");
        vista.getCbVehiculo().removeAllItems();
        vista.getCbVehiculo().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Vehiculo v = lista.get(i);
            String placa = v.getMatricula();
            System.out.println(placa);
            vista.getCbVehiculo().addItem(placa);
        }

    }

    public void AbrirDialogoProducto() {
        vistaP.getDialogoproducto().setVisible(true);
    }

    public void AgregarNuevaProducto() {
        String prod = JOptionPane.showInputDialog(vista, "Ingrese el Nuevo Producto");
        ModeloProducto mp = new ModeloProducto();
        String numprod = mp.NProducto() + 1 + "";
        ModeloProducto mp1 = new ModeloProducto(numprod, prod, "", "");
        if (mp1.grabar()) {
            JOptionPane.showMessageDialog(vista, "Registro Producto");
        }
        LLenarComboxProducto();
        vista.getCbxproducto().setSelectedItem(prod);
    }

    public void AgregarMas() {
        GuardarServicio();
        Modelo_Detalle mde = new Modelo_Detalle();
        ModeloProducto mp = new ModeloProducto();
        String codde = mde.NDetalle() + 1 + "";
        String codSer = vista.getLblNServicio().getText();
        String pro = (String) vista.getCbxproducto().getSelectedItem();
        String prod = mp.codigo_producto(pro);
        int cantidad = (int) vista.getTxtcantidad().getValue();
        System.out.println(cantidad);
        Modelo_Detalle md = new Modelo_Detalle(codde, prod, codSer, 0, cantidad);
        if (md.Grabar_Detalle()) {
            CargarLista();
            System.out.println("Detalle guardado");
        }

    }

    public void CargarLista() {
//        vistaS.getTablaServicios().setDefaultRenderer(Object.class, new ImagenTabla());
//        vistaS.getTblpersona().setRowHeight(100);
//        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTablaProducto().getModel();
        tblModel.setNumRows(0);
        String id = vista.getLblNServicio().getText();
        Modelo_Detalle mds = new Modelo_Detalle(id);
        List<Detalle_Servicio> lista = mds.MostrarTabla();
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTablaProducto().setValueAt(p1.getCod_dellate_servicio(), i.value, 0);
            vista.getTablaProducto().setValueAt(p1.getCod_producto_detalle(), i.value, 1);
            vista.getTablaProducto().setValueAt(p1.getCod_servicio_detalle(), i.value, 2);
            vista.getTablaProducto().setValueAt(p1.getCantidad(), i.value, 3);
            i.value++;
        });
        vista.getCbxproducto().setSelectedItem(0);
    }

    public String ElegirCasillaQuitar() {
        String idSeleccion = "";
        int fila = vista.getTablaProducto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            JTable tabla = vista.getTablaProducto();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void QuitarProducto() {
        String eleccion = ElegirCasillaQuitar();
        System.out.println(eleccion);
        String cod = vista.getLblNServicio().getText();
        System.out.println(cod);
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro de quitar este producto", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                modeloD = new Modelo_Detalle();
                if (modeloD.EliminarProducto(eleccion, cod)) {
                    CargarLista();
                    JOptionPane.showMessageDialog(vista, "Producto Eliminado");
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Eliminacion Cancelada");
            }
        }
    }

    public void Cancelar() {
        String cod = vista.getLblNServicio().getText();
        int opcion = JOptionPane.showConfirmDialog(vista, "Esta seguro de Cancelar este Servicio", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            modeloD = new Modelo_Detalle();
            if (modeloD.EliminarDetalle(cod)) {
                JOptionPane.showMessageDialog(vista, "Servicio Cancelado");
                vista.setVisible(false);
            } else {
                vista.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Eliminacion Cancelada");
        }

    }
    
    public void MostrarDialogoCli(){
        vista.getDialogCliente().setSize(530, 420);
        vista.getDialogCliente().setTitle("Nuevo Cliente");
        vista.getDialogCliente().getTitle();
        vista.getDialogCliente().setLocationRelativeTo(null);
        vista.getTxtcedulacli().setText("");
        vista.getTxtnombrecli().setText("");
        vista.getTxtapellidocli().setText("");
        vista.getTxttelfcli().setText("");
        vista.getDchfechacli().setDate(null);
        vista.getDialogCliente().setVisible(true);
        vista.getTxtcedulacli().setEditable(true);
        vista.getTxtidCliente().setVisible(false);
        vista.getTxtid().setVisible(false);
    }
    
    private void GrabarCliente() { //crear
        ModeloCliente modelo1=new ModeloCliente();
        int v=modelo1.NCliente()+1;
        String idCliente =String.valueOf(v);
        String cedula = vista.getTxtcedulacli().getText();
        String nombres = vista.getTxtnombrecli().getText();
        String apellidos = vista.getTxtapellidocli().getText();
        Instant intate = vista.getDchfechacli().getDate().toInstant();
        ZoneId zona = ZoneId.of("America/Guayaquil");
        ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
        Date fnacimiento = Date.valueOf(zot.toLocalDate());
        String telefono = vista.getTxttelfcli().getText();
        String direccion = vista.getTxtdireccli().getText();

        ModeloCliente cli = new ModeloCliente(idCliente,cedula, nombres, apellidos,fnacimiento,direccion,telefono);
        if (cli.Grabar_Cliente()) {
            vista.getDialogCliente().setVisible(false);

            JOptionPane.showMessageDialog(vista, "CLIENTE NUEVO GUARDADO CORRECTAMENTE");
        } else {
            JOptionPane.showMessageDialog(vista, "NO SE PUDO GUARDAR");
        }
    }
}
