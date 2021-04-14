/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Empleado;
import Modelo.Localidad;
import Modelo.ModeloCliente;
import Modelo.ModeloProducto;
import Modelo.ModeloVehiculo;
import Modelo.Modelo_Categoria;
import Modelo.Modelo_Detalle;
import Modelo.Modelo_Empleado;
import Modelo.Modelo_Localidad;
import Modelo.Modelo_Servicio;
import Modelo.Productos;
import Modelo.Servicio;
import Modelo.Vehiculo;
import Vista.Vista_Servicio;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
//import sun.swing.table.DefaultTableCellHeaderRenderer;

/**
 *
 * @author Usuario
 */
public class Control_Servicio {

    Vista_Servicio vistaS;
    Modelo_Servicio modeloS;
    private boolean validarBotonA;

    public Control_Servicio(Vista_Servicio vistaS, Modelo_Servicio modeloS) {
        this.vistaS = vistaS;
        this.modeloS = modeloS;
        this.vistaS.setVisible(true);
    }

    public void iniciarControl() {
        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                CargarLista(vistaS.getTxtbuscarS().getText());
            }
        };
        vistaS.getBtnactualizar().addActionListener(l -> CargarLista(""));

        vistaS.getBtnnuevoS().addActionListener(l -> {
            this.validarBotonA = true;
            MuestraDialogo();
        });
        vistaS.getBtnmodificarS().addActionListener((ActionEvent l) -> {
            MostrarServicio();
            this.validarBotonA = false;
        });

        vistaS.getBtnaceptarNS().addActionListener(l -> Grabar_Modificar());
        vistaS.getBtncancelarNS().addActionListener(l -> CerrarDialogo());
        vistaS.getBtneliminarS().addActionListener(l -> EliminarServicio());
        vistaS.getBtnbuscarEmpleado().addActionListener(l -> llenarTablaEmpleados());
        vistaS.getBtnElegirEmpleado().addActionListener(l -> ElegirIDEmpleado());
//        vistaS.getBtnCerrarJF().addActionListener(l -> CerrarJF());
        vistaS.getTxtbuscarS().addKeyListener(kl);
        vistaS.getBtnAgregaNuevarCategoria().addActionListener(l -> AgregarNuevaCategoria());
        vistaS.getBtnAgregarNuevoProducto().addActionListener(l -> AgregarNuevaProducto());
    }

    private void CerrarDialogo() {
        vistaS.getDialogoServicio().setVisible(false);
    }

    private void CerrarJF() {
        vistaS.setVisible(false);
    }

    private void Grabar_Modificar() {
        if (validarBotonA) {
            GrabaServicio();
        } else {
            EditarServicio();
        }
    }

    public void CargarLista(String buscar) {
//        vistaS.getTablaServicios().setDefaultRenderer(Object.class, new ImagenTabla());
//        vistaS.getTblpersona().setRowHeight(100);
//        DefaultTableCellRenderer renderer = new DefaultTableCellHeaderRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vistaS.getTablaServicios().getModel();
        tblModel.setNumRows(0);
        List<Servicio> lista = Modelo_Servicio.ListarServicios(buscar);
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vistaS.getTablaServicios().setValueAt(p1.getCodservicio(), i.value, 0);
            vistaS.getTablaServicios().setValueAt(p1.getCodcliente(), i.value, 1);
            vistaS.getTablaServicios().setValueAt(p1.getFechaServicio(), i.value, 2);
            vistaS.getTablaServicios().setValueAt(p1.getCodciudad(), i.value, 3);
            vistaS.getTablaServicios().setValueAt(p1.getCodvehiculo(), i.value, 4);
            vistaS.getTablaServicios().setValueAt(p1.getCodempleado(), i.value, 5);
            vistaS.getTablaServicios().setValueAt(p1.getKm_salida(), i.value, 6);
            vistaS.getTablaServicios().setValueAt(p1.getKm_llegada(), i.value, 7);
            i.value++;
        });
    }

    private void MuestraDialogo() {
        vistaS.getDialogoServicio().setVisible(true);
        vistaS.getDialogoServicio().setTitle("NUEVO SERVICIO");
        vistaS.getDialogoServicio().setSize(650, 500);
        vistaS.getTxtcodServicio().setText("");
        vistaS.getTxtidcliente().setText("");
        vistaS.getTxtJfechaServicio().setCalendar(null);
        vistaS.getTxtempleado().setText("");
        vistaS.getCbVehiculo().setSelectedItem(0);
        LLenarComboxVehiculo();
        vistaS.getTxtkmsalida().setText("");
        vistaS.getTxtkmllegada().setText("");
        vistaS.getTxtciudadSer().setText("");
        vistaS.getDialogoServicio().setLocationRelativeTo(vistaS);
        vistaS.getTxtcodServicio().setEditable(true);
        vistaS.getTxtcodServicio().setVisible(false);
        vistaS.getLbln().setVisible(false);
        vistaS.getCbxCategoria().setSelectedItem(0);
        LLenarComboxCategoria();
        vistaS.getCbxproducto().setSelectedItem(0);
        LLenarComboxProducto();
        vistaS.getTxtcantidad().setText("");
    }

    private void GrabaServicio() {

        if (vistaS.getTxtidcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Cliente");
        } else if (vistaS.getTxtJfechaServicio().getCalendar() == null) {
            JOptionPane.showMessageDialog(vistaS, "Campo Fecha Vacio");
        } else if (String.valueOf(vistaS.getCbVehiculo().getSelectedItem()).equals("")) {
            JOptionPane.showMessageDialog(vistaS, "Campo Vehiculo Vacio");
        } else if (vistaS.getTxtempleado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Empleado Vacio");
        } else if (vistaS.getTxtkmsalida().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Salida Vacio");
        } else {
            try {
                String idpe = vistaS.getTxtcodServicio().getText();
                Modelo_Servicio ms = new Modelo_Servicio(idpe);
                if (ms.ValidarServicio() == true) {
                    JOptionPane.showMessageDialog(vistaS, "El ID ya existe");

                } else {

                    double totalServicio;
                    double kmSalida;
                    double kmLlegada;
                    String codCli1;
                    String cod_ciudad;
                    String codservicio = modeloS.NServicio() + 1 + "";
                    //Busca en base de datos si existe el cliente y si no lo creo
                    String idcliente = vistaS.getTxtidcliente().getText();
                    ModeloCliente mc = new ModeloCliente();
                    String codCli = mc.CodCliente(idcliente);
                    if (codCli.equals("")) {
                        codCli1 = String.valueOf(mc.NCliente() + 1);
                        ModeloCliente mcS = new ModeloCliente(codCli1, idcliente, "", "", null, "", "");
                        mcS.Grabar_Cliente();
                        codCli1 = codCli1;
                    } else {
                        codCli1 = codCli;
                    }

                    //hasta aqui clientes
                    Instant instant = vistaS.getTxtJfechaServicio().getDate().toInstant();
                    ZoneId zoneid = ZoneId.of("America/Guayaquil");
                    ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
                    Date fechanacimiento = Date.valueOf(zdt.toLocalDate());

                    //Busca en base de datos si existe la ciudad y si no lo creo
                    String ciudad = vistaS.getTxtciudadSer().getText();
                    Modelo_Localidad ml = new Modelo_Localidad();
                    String cod = ml.CodLocalizacion(ciudad);
                    if (cod.equals("")) {
                        cod_ciudad = String.valueOf(ml.NLocalizacion() + 1);
                        Modelo_Localidad mlc = new Modelo_Localidad(cod_ciudad, "Ecuador", "", ciudad);
                        mlc.grabar();
                        cod_ciudad = cod_ciudad;
                    } else {
                        cod_ciudad = cod;
                    }
                    //Hasta aqui localidad
                    String codempleado = vistaS.getTxtempleado().getText();
                    String codVehiculo = (String) vistaS.getCbVehiculo().getSelectedItem();

                    //Validar que ni sea Obligatorio el total
                    if (vistaS.getTxtkmsalida().getText().isEmpty()) {
                        kmSalida = 0.0;
                    } else {
                        kmSalida = Double.parseDouble(vistaS.getTxtkmsalida().getText());
                    }
                    if (vistaS.getTxtkmllegada().getText().isEmpty()) {
                        kmLlegada = 0.0;
                    } else {
                        kmLlegada = Double.parseDouble(vistaS.getTxtkmllegada().getText());
                    }
                    if (vistaS.getTxttotalServicio().getText().isEmpty()) {
                        totalServicio = 0.0;
                    } else {
                        totalServicio = Double.parseDouble(vistaS.getTxttotalServicio().getText());
                    }
                    Modelo_Servicio servicio = new Modelo_Servicio(codservicio, fechanacimiento, kmLlegada, kmSalida, codVehiculo, codempleado, codCli1, cod_ciudad, totalServicio);
                    if (servicio.Grabar_Servicio()) {
                        CargarLista("");
                        JOptionPane.showMessageDialog(vistaS, "Registro grabado Satisfactoriamente");
                        vistaS.getDialogoServicio().setVisible(false);
                    }

                    //Busca el codigo de Categoria
                    Modelo_Categoria mc1 = new Modelo_Categoria();
                    String nombreCate = (String) vistaS.getCbxCategoria().getSelectedItem();
                    String codCategoria = mc1.codigo_Categoria(nombreCate);
                    //

                    //Busca el codigo de Producto
                    ModeloProducto mp = new ModeloProducto();
                    String nombreprod = (String) vistaS.getCbxproducto().getSelectedItem();
                    String codprod = mp.codigo_producto(nombreprod);
                    String codprod1=codprod;
                    ModeloProducto mp1 = new ModeloProducto(codprod, nombreprod, "", codCategoria);
                    if (mp1.editar()) {
                        JOptionPane.showMessageDialog(null,"Editado");
                    } else {
                        System.out.println("No editado");
                    }

                    //
                    Modelo_Detalle md = new Modelo_Detalle();
                    String numcoddeta = md.NDetalle() + 1 + "";
                    int cantidad = Integer.parseInt(vistaS.getTxtcantidad().getText());
                    Modelo_Detalle md1 = new Modelo_Detalle(numcoddeta, codprod1, codservicio, 0, cantidad);
                    if (md1.Grabar_Detalle()) {
                        JOptionPane.showMessageDialog(vistaS, "Registro Detalle");
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Control_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void EditarServicio() {
        if (vistaS.getTxtcodServicio().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Vacio");
        } else if (vistaS.getTxtidcliente().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo ID Cliente");
        } else if (vistaS.getTxtJfechaServicio().getCalendar() == null) {
            JOptionPane.showMessageDialog(vistaS, "Campo Fecha Vacio");
        } else if (String.valueOf(vistaS.getCbVehiculo().getSelectedItem()).equals("")) {
            JOptionPane.showMessageDialog(vistaS, "Campo Vehiculo Vacio");
        } else if (vistaS.getTxtempleado().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Empleado Vacio");
        } else if (vistaS.getTxtkmsalida().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Salida Vacio");
        } else if (vistaS.getTxtkmllegada().getText().isEmpty()) {
            JOptionPane.showMessageDialog(vistaS, "Campo Kilometro Llegada Vacio");
        } else {
            String codservicio = vistaS.getTxtcodServicio().getText();
            String idcliente = vistaS.getTxtidcliente().getText();
            Instant instant = vistaS.getTxtJfechaServicio().getDate().toInstant();
            ZoneId zoneid = ZoneId.of("America/Guayaquil");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneid);
            Date fechanacimiento = Date.valueOf(zdt.toLocalDate());
            String codciudad = vistaS.getTxtciudadSer().getText();
            String codVehiculo = vistaS.getTxtempleado().getText();
            String codempleado = (String) vistaS.getCbVehiculo().getSelectedItem();
            Double kmSalida = Double.parseDouble(vistaS.getTxtkmsalida().getText());
            Double kmLlegada = Double.parseDouble(vistaS.getTxtkmllegada().getText());
            Double totalServicio = Double.parseDouble(vistaS.getTxttotalServicio().getText());
            Modelo_Servicio servicio = new Modelo_Servicio(codservicio, fechanacimiento, kmLlegada, kmSalida, codVehiculo, codempleado, idcliente, codciudad, totalServicio);
            if (servicio.Grabar_Servicio()) {
                CargarLista("");
                JOptionPane.showMessageDialog(vistaS, "Registro editado Satisfactoriamente");
                vistaS.getDialogoServicio().setVisible(false);
            } else {
                JOptionPane.showMessageDialog(vistaS, "ERROR AL EDITAR");
            }
        }
    }

    public String ElegirCasilla() {
        String idSeleccion = "";
        int fila = vistaS.getTablaServicios().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaS, "Debe seleccionar una fila");
        } else {
            JTable tabla = vistaS.getTablaServicios();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }
//

    public void MostrarServicio() {
        String eleccion = ElegirCasilla();
        Modelo_Servicio ms = new Modelo_Servicio();
        List<Servicio> lista = ms.BuscarServicio(eleccion);
        for (int i = 0; i < lista.size(); i++) {
            Servicio s = lista.get(i);
            MuestraDialogo();
            vistaS.getTxtcodServicio().setVisible(true);
            vistaS.getTxtidcliente().setEditable(false);
            vistaS.getLbln().setVisible(true);
            vistaS.getTxtcodServicio().setText(s.getCodservicio());
            vistaS.getDialogoServicio().setTitle("EDITAR SERVICIO");
            vistaS.getTxtcodServicio().setText(s.getCodservicio());
            vistaS.getTxtcodServicio().setEditable(false);
            vistaS.getTxtidcliente().setText(s.getCodcliente());
            vistaS.getTxtJfechaServicio().setDate(s.getFechaServicio());
            vistaS.getCbVehiculo().setSelectedItem(s.getCodvehiculo());
            vistaS.getTxtempleado().setText(s.getCodempleado());
            vistaS.getTxtkmsalida().setText(s.getKm_salida() + "");
            vistaS.getTxtkmllegada().setText(s.getKm_llegada() + "");
        }
    }

    public void LLenarComboxVehiculo() {
        System.out.println("lleno");
        List<Vehiculo> lista = ModeloVehiculo.ListarVehiculo("");
        System.out.println(lista);
        vistaS.getCbVehiculo().removeAllItems();
        vistaS.getCbVehiculo().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Vehiculo v = lista.get(i);
            String placa = v.getMatricula();
            System.out.println(placa);
            vistaS.getCbVehiculo().addItem(placa);
//            vistaS.getCbVehiculo().setSelectedItem(combo);
        }

    }

    public void LLenarComboxCategoria() {
        List<Categoria> lista = Modelo_Categoria.ListarCategorias("");
        vistaS.getCbxCategoria().removeAllItems();
        vistaS.getCbxCategoria().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Categoria v = lista.get(i);
            String nomCate = v.getNombre_categoria();
            vistaS.getCbxCategoria().addItem(nomCate);
        }
    }

    public void LLenarComboxProducto() {
        List<Productos> lista = ModeloProducto.ListarProducto("");
        vistaS.getCbxproducto().removeAllItems();
        vistaS.getCbxproducto().addItem("Seleccione");
        for (int i = 0; i < lista.size(); i++) {
            Productos p = lista.get(i);
            String nomprod = p.getNombre_producto();
            vistaS.getCbxproducto().addItem(nomprod);
        }
    }

    public void EliminarServicio() {
        String eleccion = ElegirCasilla();
        if (eleccion != null) {
            int opcion = JOptionPane.showConfirmDialog(vistaS, "Esta seguro en eliminar este Servicio", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                Modelo_Servicio ms = new Modelo_Servicio(eleccion);
                if (ms.EliminarServicio()) {
                    CargarLista("");
                    JOptionPane.showMessageDialog(vistaS, "Registro Eliminado Satisfactoriamente");
                } else {
                    JOptionPane.showMessageDialog(vistaS, "Error al Eliminar");
                }
            } else {
                JOptionPane.showMessageDialog(vistaS, "Eliminacion Cancelada");
            }
        }
    }

    public String ElegirCasillaEmpleado() {
        String idSeleccion = "";
        int fila = vistaS.getTablaEligeEmpleado().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaS, "Debe seleccionar una fila");
        } else {
            JTable tabla = vistaS.getTablaEligeEmpleado();
            idSeleccion = tabla.getValueAt(tabla.getSelectedRow(), 0).toString();
            return idSeleccion;
        }
        return null;
    }

    public void llenarTablaEmpleados() {
        vistaS.getDialogoEmpreado().setVisible(true);
        vistaS.getDialogoEmpreado().setLocationRelativeTo(vistaS);
        vistaS.getDialogoEmpreado().setSize(300, 250);
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vistaS.getTablaEligeEmpleado().getModel();
        tblModel.setNumRows(0);
        List<Empleado> lista = Modelo_Empleado.Lista_Empleados("");
        int ncols = tblModel.getColumnCount();
        Holder<Integer> i = new Holder<>(0);
        lista.stream().forEach(p1 -> {
            tblModel.addRow(new Object[ncols]);
            vistaS.getTablaEligeEmpleado().setValueAt(p1.getCod_empleado(), i.value, 0);
            vistaS.getTablaEligeEmpleado().setValueAt(p1.getNombre(), i.value, 1);
            vistaS.getTablaEligeEmpleado().setValueAt(p1.getApellido(), i.value, 2);
            i.value++;
        });

    }

    public void ElegirIDEmpleado() {
        String eleccion = ElegirCasillaEmpleado();
        Modelo_Empleado ms = new Modelo_Empleado();
        List<Empleado> lista = ms.BuscarporID(eleccion);
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            vistaS.getTxtempleado().setText(e.getCod_empleado());
            vistaS.getDialogoEmpreado().setVisible(false);
        }

    }

    public void AgregarNuevaCategoria() {
        String cat = JOptionPane.showInputDialog(vistaS, "Ingrese la Nueva Categoria");
        Modelo_Categoria mc = new Modelo_Categoria();
        String numCategoria = mc.NCategoria() + 1 + "";
        Modelo_Categoria mc1 = new Modelo_Categoria(numCategoria, "", cat);
        if (mc1.Grabar_Categoria()) {
            JOptionPane.showMessageDialog(vistaS, "Registro Categoria");
        }
        LLenarComboxCategoria();
        vistaS.getCbxCategoria().setSelectedItem(cat);
    }

    public void AgregarNuevaProducto() {
        String prod = JOptionPane.showInputDialog(vistaS, "Ingrese el Nuevo Producto");
        ModeloProducto mp = new ModeloProducto();
        String numprod = mp.NProducto() + 1 + "";
        ModeloProducto mp1 = new ModeloProducto(numprod, prod, "", "");
        if (mp1.grabar()) {
            JOptionPane.showMessageDialog(vistaS, "Registro Producto");
        }
        LLenarComboxProducto();
        vistaS.getCbxproducto().setSelectedItem(prod);
    }
}
