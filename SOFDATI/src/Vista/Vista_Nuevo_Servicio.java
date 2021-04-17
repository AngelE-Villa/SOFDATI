/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Vista_Nuevo_Servicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form NuevoServicio
     */
    public Vista_Nuevo_Servicio() {
        initComponents();
    }

    public JButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public void setBtnBuscarCliente(JButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }

    public JLabel getLblCliente() {
        return lblCliente;
    }

    public void setLblCliente(JLabel lblCliente) {
        this.lblCliente = lblCliente;
    }

    public JLabel getLblEmpleado() {
        return lblEmpleado;
    }

    public void setLblEmpleado(JLabel lblEmpleado) {
        this.lblEmpleado = lblEmpleado;
    }

    public JButton getBtnAgregaNuevarCategoria() {
        return btnAgregaNuevarCategoria;
    }

    public JButton getMasProductos() {
        return MasProductos;
    }

    public void setMasProductos(JButton MasProductos) {
        this.MasProductos = MasProductos;
    }

    public JButton getBtnbuscarEmpleado() {
        return btnbuscarEmpleado;
    }

    public void setBtnbuscarEmpleado(JButton btnbuscarEmpleado) {
        this.btnbuscarEmpleado = btnbuscarEmpleado;
    }

    public void setBtnAgregaNuevarCategoria(JButton btnAgregaNuevarCategoria) {
        this.btnAgregaNuevarCategoria = btnAgregaNuevarCategoria;
    }

    public JButton getBtnAgregarNuevoProducto() {
        return btnAgregarNuevoProducto;
    }

    public void setBtnAgregarNuevoProducto(JButton btnAgregarNuevoProducto) {
        this.btnAgregarNuevoProducto = btnAgregarNuevoProducto;
    }

    public JButton getBtnQuitarProducto() {
        return btnQuitarProducto;
    }

    public void setBtnQuitarProducto(JButton btnQuitarProducto) {
        this.btnQuitarProducto = btnQuitarProducto;
    }

    public JButton getBtnaceptarNS() {
        return btnaceptarNS;
    }

    public void setBtnaceptarNS(JButton btnaceptarNS) {
        this.btnaceptarNS = btnaceptarNS;
    }

    public JButton getBtncancelarNS() {
        return btncancelarNS;
    }

    public void setBtncancelarNS(JButton btncancelarNS) {
        this.btncancelarNS = btncancelarNS;
    }

    public JComboBox<String> getCbVehiculo() {
        return cbVehiculo;
    }

    public void setCbVehiculo(JComboBox<String> cbVehiculo) {
        this.cbVehiculo = cbVehiculo;
    }

    public JComboBox<String> getCbxCategoria() {
        return cbxCategoria;
    }

    public void setCbxCategoria(JComboBox<String> cbxCategoria) {
        this.cbxCategoria = cbxCategoria;
    }

    public JComboBox<String> getCbxproducto() {
        return cbxproducto;
    }

    public void setCbxproducto(JComboBox<String> cbxproducto) {
        this.cbxproducto = cbxproducto;
    }

    public JTable getTablaProducto() {
        return tablaProducto;
    }

    public void setTablaProducto(JTable tablaProducto) {
        this.tablaProducto = tablaProducto;
    }

    public JDateChooser getTxtJfechaServicio() {
        return txtJfechaServicio;
    }

    public void setTxtJfechaServicio(JDateChooser txtJfechaServicio) {
        this.txtJfechaServicio = txtJfechaServicio;
    }

    public JTextField getTxtcantidad() {
        return txtcantidad;
    }

    public void setTxtcantidad(JTextField txtcantidad) {
        this.txtcantidad = txtcantidad;
    }

    public JTextField getTxtciudadSer() {
        return txtciudadSer;
    }

    public JButton getBtnElegirEmpleado() {
        return btnElegirEmpleado;
    }

    public void setBtnElegirEmpleado(JButton btnElegirEmpleado) {
        this.btnElegirEmpleado = btnElegirEmpleado;
    }

    public JTable getTablaEligeEmpleado() {
        return tablaEligeEmpleado;
    }

    public void setTablaEligeEmpleado(JTable tablaEligeEmpleado) {
        this.tablaEligeEmpleado = tablaEligeEmpleado;
    }

    public JDialog getDialogoEmpreado() {
        return DialogoEmpreado;
    }

    public void setDialogoEmpreado(JDialog DialogoEmpreado) {
        this.DialogoEmpreado = DialogoEmpreado;
    }

    public void setTxtciudadSer(JTextField txtciudadSer) {
        this.txtciudadSer = txtciudadSer;
    }

    public JLabel getLblNServicio() {
        return lblNServicio;
    }

    public void setLblNServicio(JLabel lblNServicio) {
        this.lblNServicio = lblNServicio;
    }

 

    public JTextField getTxtempleado() {
        return txtempleado;
    }

    public void setTxtempleado(JTextField txtempleado) {
        this.txtempleado = txtempleado;
    }

    public JTextField getTxtidcliente() {
        return txtidcliente;
    }

    public void setTxtidcliente(JTextField txtidcliente) {
        this.txtidcliente = txtidcliente;
    }

    public JTextField getTxtkmllegada() {
        return txtkmllegada;
    }

    public void setTxtkmllegada(JTextField txtkmllegada) {
        this.txtkmllegada = txtkmllegada;
    }

    public JTextField getTxtkmsalida() {
        return txtkmsalida;
    }

    public void setTxtkmsalida(JTextField txtkmsalida) {
        this.txtkmsalida = txtkmsalida;
    }

    public JTextField getTxttotalServicio() {
        return txttotalServicio;
    }

    public void setTxttotalServicio(JTextField txttotalServicio) {
        this.txttotalServicio = txttotalServicio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoEmpreado = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEligeEmpleado = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnElegirEmpleado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNServicio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cbxproducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregaNuevarCategoria = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnAgregarNuevoProducto = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtkmsalida = new javax.swing.JTextField();
        txtkmllegada = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtciudadSer = new javax.swing.JTextField();
        txtJfechaServicio = new com.toedter.calendar.JDateChooser();
        cbVehiculo = new javax.swing.JComboBox<>();
        txtempleado = new javax.swing.JTextField();
        btnbuscarEmpleado = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblEmpleado = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        MasProductos = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnQuitarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txttotalServicio = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnaceptarNS = new javax.swing.JButton();
        btncancelarNS = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProducto = new javax.swing.JTable();

        tablaEligeEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula", "Nombre", "Apellido"
            }
        ));
        jScrollPane2.setViewportView(tablaEligeEmpleado);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Elija un Empleado");

        btnElegirEmpleado.setText("Elegir");

        javax.swing.GroupLayout DialogoEmpreadoLayout = new javax.swing.GroupLayout(DialogoEmpreado.getContentPane());
        DialogoEmpreado.getContentPane().setLayout(DialogoEmpreadoLayout);
        DialogoEmpreadoLayout.setHorizontalGroup(
            DialogoEmpreadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoEmpreadoLayout.createSequentialGroup()
                .addGroup(DialogoEmpreadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogoEmpreadoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel17))
                    .addGroup(DialogoEmpreadoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnElegirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        DialogoEmpreadoLayout.setVerticalGroup(
            DialogoEmpreadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogoEmpreadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE)
                .addComponent(btnElegirEmpleado)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SOFDATI");

        jLabel2.setText("Logo");

        jLabel4.setText("N°");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblNServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(98, 98, 98))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("DNI :");

        cbxproducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Producto 1", "Producto 2", "Producto 3", "Producto 4" }));

        jLabel6.setText("Fecha :");

        cbxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria 1", "Categoria 2", "Categoria 3", "Categoria 4" }));

        jLabel7.setText("Ciudad :");

        jLabel8.setText("Vehiculo :");

        jLabel9.setText("Producto:");

        jLabel10.setText("Empleado :");

        btnAgregaNuevarCategoria.setText("Agregar Nueva Categoria");

        jLabel11.setText("Km Salida :");

        btnAgregarNuevoProducto.setText("Agregar Nuevo Producto");

        jLabel12.setText("Km Llegada :");

        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        btnbuscarEmpleado.setText("Buscar");

        jLabel16.setText("Cantidad");

        btnBuscarCliente.setText("Buscar");

        jLabel15.setText("Nombres :");

        jLabel19.setText(" Nombres");

        MasProductos.setText("Agregar");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Productos");

        btnQuitarProducto.setText("Quitar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnBuscarCliente)
                        .addGap(212, 212, 212)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel15)
                        .addGap(8, 8, 8)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(cbxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addGap(8, 8, 8)
                        .addComponent(txtJfechaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(10, 10, 10)
                        .addComponent(txtciudadSer, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel16)
                        .addGap(10, 10, 10)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel10)
                        .addGap(8, 8, 8)
                        .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnbuscarEmpleado)
                        .addGap(212, 212, 212)
                        .addComponent(btnAgregarNuevoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(186, 186, 186)
                        .addComponent(btnAgregaNuevarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtkmsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(txtkmllegada, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(MasProductos)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuitarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarCliente)
                    .addComponent(jLabel14))
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel9))
                    .addComponent(cbxproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(txtJfechaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(txtciudadSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnbuscarEmpleado))
                    .addComponent(btnAgregarNuevoProducto))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregaNuevarCategoria)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtkmllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MasProductos)
                    .addComponent(btnQuitarProducto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtkmsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Total :");

        btnaceptarNS.setText("Guardar Servicio");

        btncancelarNS.setText("Cancelar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btncancelarNS)
                .addGap(40, 40, 40)
                .addComponent(btnaceptarNS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txttotalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnaceptarNS)
                    .addComponent(btncancelarNS)
                    .addComponent(txttotalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Categoria", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablaProducto);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogoEmpreado;
    private javax.swing.JButton MasProductos;
    private javax.swing.JButton btnAgregaNuevarCategoria;
    private javax.swing.JButton btnAgregarNuevoProducto;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnElegirEmpleado;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnaceptarNS;
    private javax.swing.JButton btnbuscarEmpleado;
    private javax.swing.JButton btncancelarNS;
    private javax.swing.JComboBox<String> cbVehiculo;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxproducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblNServicio;
    private javax.swing.JTable tablaEligeEmpleado;
    private javax.swing.JTable tablaProducto;
    private com.toedter.calendar.JDateChooser txtJfechaServicio;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtciudadSer;
    private javax.swing.JTextField txtempleado;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtkmllegada;
    private javax.swing.JTextField txtkmsalida;
    private javax.swing.JTextField txttotalServicio;
    // End of variables declaration//GEN-END:variables
}
