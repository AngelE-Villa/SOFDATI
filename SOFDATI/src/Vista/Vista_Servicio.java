/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Vista_Servicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista_Servicio
     */
    public Vista_Servicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogoServicio = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtcodServicio = new javax.swing.JTextField();
        txtcodvehiculo = new javax.swing.JTextField();
        txtcodempleado = new javax.swing.JTextField();
        txtkmsalida = new javax.swing.JTextField();
        txtkmllegada = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtciudadSer = new javax.swing.JTextField();
        txtJfechaServicio = new com.toedter.calendar.JDateChooser();
        btnaceptarNS = new javax.swing.JButton();
        btncancelarNS = new javax.swing.JButton();
        txttotalServicio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnbuscarS = new javax.swing.JButton();
        btnnuevoS = new javax.swing.JButton();
        btnmodificarS = new javax.swing.JButton();
        btneliminarS = new javax.swing.JButton();
        btnimprimirS = new javax.swing.JButton();
        txtbuscarS = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Nuevo Servicio");

        jLabel4.setText("N° :");

        jLabel5.setText("Cliente:");

        jLabel6.setText("Fecha :");

        jLabel7.setText("Ciudad :");

        jLabel8.setText("Vehiculo :");

        jLabel9.setText("Empleado :");

        jLabel10.setText("Km Salida :");

        jLabel11.setText("Km Llegada :");

        btnaceptarNS.setText("Aceptar");

        btncancelarNS.setText("Cancelar");

        jLabel12.setText("Total :");

        javax.swing.GroupLayout DialogoServicioLayout = new javax.swing.GroupLayout(DialogoServicio.getContentPane());
        DialogoServicio.getContentPane().setLayout(DialogoServicioLayout);
        DialogoServicioLayout.setHorizontalGroup(
            DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoServicioLayout.createSequentialGroup()
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogoServicioLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(DialogoServicioLayout.createSequentialGroup()
                                .addComponent(btncancelarNS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnaceptarNS))
                            .addGroup(DialogoServicioLayout.createSequentialGroup()
                                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel12))
                                .addGap(32, 32, 32)
                                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotalServicio)
                                    .addComponent(txtidcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtciudadSer, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtcodempleado, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtkmsalida, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtkmllegada, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtcodvehiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtJfechaServicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogoServicioLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcodServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(DialogoServicioLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        DialogoServicioLayout.setVerticalGroup(
            DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogoServicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcodServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtJfechaServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtciudadSer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcodvehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtcodempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtkmsalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtkmllegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttotalServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(DialogoServicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelarNS)
                    .addComponent(btnaceptarNS))
                .addGap(20, 20, 20))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("SERVICIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Servicio", "Empleado", "Fecha", "Ciudad", "Vehiculo", "Empleado", "Km Salida", "Km Llegada", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaServicios);

        btnbuscarS.setText("Buscar");

        btnnuevoS.setText("Nuevo");

        btnmodificarS.setText("Modificar");

        btneliminarS.setText("Eliminar");

        btnimprimirS.setText("Imprimir");

        btnactualizar.setText("Actualizar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscarS, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnbuscarS)
                .addGap(64, 64, 64)
                .addComponent(btnnuevoS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmodificarS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminarS, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(btnimprimirS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscarS)
                    .addComponent(btnnuevoS)
                    .addComponent(btnmodificarS)
                    .addComponent(btneliminarS)
                    .addComponent(btnimprimirS)
                    .addComponent(txtbuscarS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnaceptarNS() {
        return btnaceptarNS;
    }

    public void setBtnaceptarNS(JButton btnaceptarNS) {
        this.btnaceptarNS = btnaceptarNS;
    }

    public JButton getBtnbuscarS() {
        return btnbuscarS;
    }

    public void setBtnbuscarS(JButton btnbuscarS) {
        this.btnbuscarS = btnbuscarS;
    }

    public JButton getBtncancelarNS() {
        return btncancelarNS;
    }

    public void setBtncancelarNS(JButton btncancelarNS) {
        this.btncancelarNS = btncancelarNS;
    }

    public JButton getBtneliminarS() {
        return btneliminarS;
    }

    public void setBtneliminarS(JButton btneliminarS) {
        this.btneliminarS = btneliminarS;
    }

    public JButton getBtnimprimirS() {
        return btnimprimirS;
    }

    public void setBtnimprimirS(JButton btnimprimirS) {
        this.btnimprimirS = btnimprimirS;
    }

    public JButton getBtnmodificarS() {
        return btnmodificarS;
    }

    public void setBtnmodificarS(JButton btnmodificarS) {
        this.btnmodificarS = btnmodificarS;
    }

    public JButton getBtnactualizar() {
        return btnactualizar;
    }

    public void setBtnactualizar(JButton btnactualizar) {
        this.btnactualizar = btnactualizar;
    }

    public JDialog getDialogoServicio() {
        return DialogoServicio;
    }

    public void setDialogoServicio(JDialog DialogoServicio) {
        this.DialogoServicio = DialogoServicio;
    }

    public JTable getTablaServicios() {
        return tablaServicios;
    }

    public void setTablaServicios(JTable tablaServicios) {
        this.tablaServicios = tablaServicios;
    }

    public JDateChooser getTxtJfechaServicio() {
        return txtJfechaServicio;
    }

    public void setTxtJfechaServicio(JDateChooser txtJfechaServicio) {
        this.txtJfechaServicio = txtJfechaServicio;
    }

    public JTextField getTxtbuscarS() {
        return txtbuscarS;
    }

    public void setTxtbuscarS(JTextField txtbuscarS) {
        this.txtbuscarS = txtbuscarS;
    }

    public JTextField getTxtciudadSer() {
        return txtciudadSer;
    }

    public void setTxtciudadSer(JTextField txtciudadSer) {
        this.txtciudadSer = txtciudadSer;
    }

    public JTextField getTxttotalServicio() {
        return txttotalServicio;
    }

    public void setTxttotalServicio(JTextField txttotalServicio) {
        this.txttotalServicio = txttotalServicio;
    }

    public JTextField getTxtcodServicio() {
        return txtcodServicio;
    }

    public void setTxtcodServicio(JTextField txtcodServicio) {
        this.txtcodServicio = txtcodServicio;
    }

    public JTextField getTxtcodempleado() {
        return txtcodempleado;
    }

    public void setTxtcodempleado(JTextField txtcodempleado) {
        this.txtcodempleado = txtcodempleado;
    }

    public JTextField getTxtcodvehiculo() {
        return txtcodvehiculo;
    }

    public void setTxtcodvehiculo(JTextField txtcodvehiculo) {
        this.txtcodvehiculo = txtcodvehiculo;
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

    public JButton getBtnnuevoS() {
        return btnnuevoS;
    }

    public void setBtnnuevoS(JButton btnnuevoS) {
        this.btnnuevoS = btnnuevoS;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogoServicio;
    private javax.swing.JButton btnaceptarNS;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscarS;
    private javax.swing.JButton btncancelarNS;
    private javax.swing.JButton btneliminarS;
    private javax.swing.JButton btnimprimirS;
    private javax.swing.JButton btnmodificarS;
    private javax.swing.JButton btnnuevoS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaServicios;
    private com.toedter.calendar.JDateChooser txtJfechaServicio;
    private javax.swing.JTextField txtbuscarS;
    private javax.swing.JTextField txtciudadSer;
    private javax.swing.JTextField txtcodServicio;
    private javax.swing.JTextField txtcodempleado;
    private javax.swing.JTextField txtcodvehiculo;
    private javax.swing.JTextField txtidcliente;
    private javax.swing.JTextField txtkmllegada;
    private javax.swing.JTextField txtkmsalida;
    private javax.swing.JTextField txttotalServicio;
    // End of variables declaration//GEN-END:variables
}
