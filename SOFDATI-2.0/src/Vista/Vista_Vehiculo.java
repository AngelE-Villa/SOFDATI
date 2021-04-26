/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class Vista_Vehiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista_Vehiculo
     */
    public Vista_Vehiculo() {
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

        dlgVehiculo = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        lblV2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        FMatricula = new com.toedter.calendar.JDateChooser();
        btnCancelar2 = new javax.swing.JButton();
        btnGuardarV2 = new javax.swing.JButton();
        lblfotoVeh = new javax.swing.JLabel();
        btnExaminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculo = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnSalirV1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtBusquedaV1 = new javax.swing.JTextField();
        btnAgregarV1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bntModificarV1 = new javax.swing.JButton();
        btnBuscarV1 = new javax.swing.JButton();
        btnEliminarV1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 231, 47));

        lblV2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblV2.setText("NUEVO VEHICULO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblV2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblV2)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("N° Matricula");

        jLabel5.setText("Pais Origen");

        jLabel9.setText("Color de Vehiculo");

        jLabel10.setText("Fecha de Matricula");

        btnCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Cancelar_1.PNG"))); // NOI18N
        btnCancelar2.setBorderPainted(false);
        btnCancelar2.setContentAreaFilled(false);
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });

        btnGuardarV2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Aceptar_1.PNG"))); // NOI18N
        btnGuardarV2.setBorderPainted(false);
        btnGuardarV2.setContentAreaFilled(false);

        lblfotoVeh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExaminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Examinar.png"))); // NOI18N
        btnExaminar.setBorderPainted(false);
        btnExaminar.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColor)
                            .addComponent(txtPais)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(FMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfotoVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnGuardarV2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblfotoVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarV2)
                    .addComponent(btnCancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout dlgVehiculoLayout = new javax.swing.GroupLayout(dlgVehiculo.getContentPane());
        dlgVehiculo.getContentPane().setLayout(dlgVehiculoLayout);
        dlgVehiculoLayout.setHorizontalGroup(
            dlgVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dlgVehiculoLayout.setVerticalGroup(
            dlgVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dlgVehiculoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Pais", "Color", "Caducidad", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVehiculo);

        jPanel3.setBackground(new java.awt.Color(255, 231, 47));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("VEHICULOS");

        btnSalirV1.setText("Salir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalirV1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSalirV1))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregarV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Nuevo.PNG"))); // NOI18N
        btnAgregarV1.setBorderPainted(false);
        btnAgregarV1.setContentAreaFilled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Buscar");

        bntModificarV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Editar.PNG"))); // NOI18N
        bntModificarV1.setBorderPainted(false);
        bntModificarV1.setContentAreaFilled(false);

        btnBuscarV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Actualizar.PNG"))); // NOI18N
        btnBuscarV1.setBorderPainted(false);
        btnBuscarV1.setContentAreaFilled(false);

        btnEliminarV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Eliminar.PNG"))); // NOI18N
        btnEliminarV1.setBorderPainted(false);
        btnEliminarV1.setContentAreaFilled(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Imprimir.PNG"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBusquedaV1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnAgregarV1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarV1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntModificarV1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarV1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarV1)
                    .addComponent(bntModificarV1)
                    .addComponent(btnBuscarV1)
                    .addComponent(btnEliminarV1)
                    .addComponent(jButton1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusquedaV1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    public JDialog getDlgVehiculo() {
        return dlgVehiculo;
    }

    public void setDlgVehiculo(JDialog dlgVehiculo) {
        this.dlgVehiculo = dlgVehiculo;
    }

    public JButton getBntModificarV1() {
        return bntModificarV1;
    }

    public void setBntModificarV1(JButton bntModificarV1) {
        this.bntModificarV1 = bntModificarV1;
    }

    public JButton getBtnEliminarV1() {
        return btnEliminarV1;
    }

    public void setBtnEliminarV1(JButton btnEliminar) {
        this.btnEliminarV1 = btnEliminar;
    }

    public JButton getBtnCancelar2() {
        return btnCancelar2;
    }

    public void setBtnCancelar2(JButton btnCancelar2) {
        this.btnCancelar2 = btnCancelar2;
    }

    public JButton getBtnGuardarV2() {
        return btnGuardarV2;
    }

    public void setBtnGuardarV2(JButton btnGuardarV2) {
        this.btnGuardarV2 = btnGuardarV2;
    }

    public JButton getBtnAgregarV1() {
        return btnAgregarV1;
    }

    public void setBtnAgregarV1(JButton btnAgregarV1) {
        this.btnAgregarV1 = btnAgregarV1;
    }

    public JButton getBtnBuscarV1() {
        return btnBuscarV1;
    }

    public void setBtnBuscarV1(JButton btnBuscarV1) {
        this.btnBuscarV1 = btnBuscarV1;
    }

    public JButton getBtnSalirV1() {
        return btnSalirV1;
    }

    public void setBtnSalirV1(JButton btnSalirV1) {
        this.btnSalirV1 = btnSalirV1;
    }

    public JTable getTblVehiculo() {
        return tblVehiculo;
    }

    public void setTblVehiculo(JTable tblVehiculo) {
        this.tblVehiculo = tblVehiculo;
    }

    public JTextField getTxtBusquedaV1() {
        return txtBusquedaV1;
    }

    public void setTxtBusquedaV1(JTextField txtBusquedaV1) {
        this.txtBusquedaV1 = txtBusquedaV1;
    }

    public JDateChooser getFMatricula() {
        return FMatricula;
    }

    public void setFMatricula(JDateChooser FMatricula) {
        this.FMatricula = FMatricula;
    }

    public JButton getBtnExaminar() {
        return btnExaminar;
    }

    public void setBtnExaminar(JButton btnExaminar) {
        this.btnExaminar = btnExaminar;
    }

    public JLabel getLblfotoVeh() {
        return lblfotoVeh;
    }

    public void setLblfotoVeh(JLabel lblfotoVeh) {
        this.lblfotoVeh = lblfotoVeh;
    }

    public JTextField getTxtColor() {
        return txtColor;
    }

    public void setTxtColor(JTextField txtColor) {
        this.txtColor = txtColor;
    }

    public JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(JTextField txtMatricula) {
        this.txtMatricula = txtMatricula;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    public JDateChooser getJdtFCaduce() {
        return FMatricula;
    }

    public void setJdtFCaduce(JDateChooser jdtFCaduce) {
        this.FMatricula = jdtFCaduce;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser FMatricula;
    private javax.swing.JButton bntModificarV1;
    private javax.swing.JButton btnAgregarV1;
    private javax.swing.JButton btnBuscarV1;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnEliminarV1;
    private javax.swing.JButton btnExaminar;
    private javax.swing.JButton btnGuardarV2;
    private javax.swing.JButton btnSalirV1;
    private javax.swing.JDialog dlgVehiculo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblV2;
    private javax.swing.JLabel lblfotoVeh;
    private javax.swing.JTable tblVehiculo;
    private javax.swing.JTextField txtBusquedaV1;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPais;
    // End of variables declaration//GEN-END:variables
}
