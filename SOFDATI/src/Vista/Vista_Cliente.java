/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Vista_Cliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vista_Cliente
     */
    public Vista_Cliente() {
        initComponents();
       // DialogCliente.getContentPane().setBackground(new Color(255,159,28));
        
    }

   
    
    public JButton getBtnActualizarcli() {
        return btnActualizarcli;
    }

    public void setBtnActualizarcli(JButton btnActualizarcli) {
        this.btnActualizarcli = btnActualizarcli;
    }

    public JButton getBtnCerrarP() {
        return btnCerrarP;
    }

    public void setBtnCerrarP(JButton btnCerrarP) {
        this.btnCerrarP = btnCerrarP;
    }

    public JButton getBtnEditarcli() {
        return btnEditarcli;
    }

    public void setBtnEditarcli(JButton btnEditarcli) {
        this.btnEditarcli = btnEditarcli;
    }

    public JButton getBtnEliminarcli() {
        return btnEliminarcli;
    }

    public void setBtnEliminarcli(JButton btnEliminarcli) {
        this.btnEliminarcli = btnEliminarcli;
    }

    public JButton getBtnImprimircli() {
        return btnImprimircli;
    }

    public void setBtnImprimircli(JButton btnImprimircli) {
        this.btnImprimircli = btnImprimircli;
    }

    public JButton getBtnNuevocli() {
        return btnNuevocli;
    }

    public void setBtnNuevocli(JButton btnNuevocli) {
        this.btnNuevocli = btnNuevocli;
    }

    public JLabel getLblMensaje() {
        return lblMensaje;
    }

    public void setLblMensaje(JLabel lblMensaje) {
        this.lblMensaje = lblMensaje;
    }

    public JTable getTblCliente() {
        return tblCliente;
    }

    public void setTblCliente(JTable tblCliente) {
        this.tblCliente = tblCliente;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JDialog getDialogCliente() {
        return DialogCliente;
    }

    public void setDialogCliente(JDialog DialogCliente) {
        this.DialogCliente = DialogCliente;
    }

    public JButton getBtnAceptar() {
        return btnAceptarcli;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptarcli = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelarcli;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelarcli = btnCancelar;
    }

    public JDateChooser getDchfecha() {
        return dchfechacli;
    }

    public void setDchfecha(JDateChooser dchfecha) {
        this.dchfechacli = dchfecha;
    }

    public JButton getBtnAceptarcli() {
        return btnAceptarcli;
    }

    public void setBtnAceptarcli(JButton btnAceptarcli) {
        this.btnAceptarcli = btnAceptarcli;
    }

    public JButton getBtnCancelarcli() {
        return btnCancelarcli;
    }

    public void setBtnCancelarcli(JButton btnCancelarcli) {
        this.btnCancelarcli = btnCancelarcli;
    }

    public JDateChooser getDchfechacli() {
        return dchfechacli;
    }

    public JLabel getTxtid() {
        return txtid;
    }

    public void setTxtid(JLabel txtid) {
        this.txtid = txtid;
    }

    public JTextField getTxtidCliente() {
        return txtidCliente;
    }

    public void setTxtidCliente(JTextField txtidCliente) {
        this.txtidCliente = txtidCliente;
    }

    

    public void setDchfechacli(JDateChooser dchfechacli) {
        this.dchfechacli = dchfechacli;
    }
    
    public JTextField getTxtapellidocli() {
        return txtapellidocli;
    }

    public void setTxtapellidocli(JTextField txtapellidocli) {
        this.txtapellidocli = txtapellidocli;
    }
    
    

    public JTextField getTxtcedulacli() {
        return txtcedulacli;
    }

    public void setTxtcedulacli(JTextField txtcedulacli) {
        this.txtcedulacli = txtcedulacli;
    }

    public JTextField getTxtdireccli() {
        return txtdireccli;
    }

    public void setTxtdireccli(JTextField txtdireccli) {
        this.txtdireccli = txtdireccli;
    }

    public JTextField getTxtnombrecli() {
        return txtnombrecli;
    }

    public void setTxtnombrecli(JTextField txtnombrecli) {
        this.txtnombrecli = txtnombrecli;
    }

    public JTextField getTxttelfcli() {
        return txttelfcli;
    }
    
    

    public void setTxttelfcli(JTextField txttelfcli) {
        this.txttelfcli = txttelfcli;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DialogCliente = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        txtcedulacli = new javax.swing.JTextField();
        txtapellidocli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnombrecli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttelfcli = new javax.swing.JTextField();
        txtdireccli = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dchfechacli = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        btnCancelarcli = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtidCliente = new javax.swing.JTextField();
        btnAceptarcli = new javax.swing.JButton();
        txtid = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevocli = new javax.swing.JButton();
        btnEditarcli = new javax.swing.JButton();
        btnEliminarcli = new javax.swing.JButton();
        btnActualizarcli = new javax.swing.JButton();
        btnImprimircli = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        lblMensaje = new javax.swing.JLabel();
        btnCerrarP = new javax.swing.JButton();

        DialogCliente.setBackground(new java.awt.Color(255, 153, 0));
        DialogCliente.setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(241, 218, 154));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 155, 28)));

        jLabel3.setText("Cedula:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Fecha:");

        jLabel10.setText("Direccion:");

        jLabel6.setText("Apellido:");

        btnCancelarcli.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/btn_cancel-02.png"))); // NOI18N
        btnCancelarcli.setBorder(null);
        btnCancelarcli.setBorderPainted(false);
        btnCancelarcli.setContentAreaFilled(false);

        jLabel8.setText("Teléfono:");

        btnAceptarcli.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptarcli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/btn_aceptar-02.png"))); // NOI18N
        btnAceptarcli.setBorder(null);
        btnAceptarcli.setBorderPainted(false);
        btnAceptarcli.setContentAreaFilled(false);

        txtid.setText("ID:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/Logoe.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 155, 28));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("NUEVO CLIENTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid)
                    .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtcedulacli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtapellidocli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(dchfechacli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txttelfcli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAceptarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdireccli, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(133, 133, 133))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcedulacli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtapellidocli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dchfechacli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttelfcli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdireccli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAceptarcli))
                    .addComponent(btnCancelarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DialogClienteLayout = new javax.swing.GroupLayout(DialogCliente.getContentPane());
        DialogCliente.getContentPane().setLayout(DialogClienteLayout);
        DialogClienteLayout.setHorizontalGroup(
            DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DialogClienteLayout.setVerticalGroup(
            DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        DialogCliente.getAccessibleContext().setAccessibleParent(DialogCliente);

        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar");

        btnNuevocli.setText("Nuevo");

        btnEditarcli.setText("Editar");

        btnEliminarcli.setText("Eliminar");

        btnActualizarcli.setText("Actualizar");

        btnImprimircli.setText("Imprimir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevocli, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(btnImprimircli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevocli)
                    .addComponent(btnEditarcli)
                    .addComponent(btnEliminarcli)
                    .addComponent(btnActualizarcli)
                    .addComponent(btnImprimircli))
                .addContainerGap())
        );

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Cedula", "Nombre", "Apellido", "Fecha Nac", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        lblMensaje.setText("Sistema Personas :");

        btnCerrarP.setText("CERRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarP, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensaje)
                    .addComponent(btnCerrarP)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog DialogCliente;
    private javax.swing.JButton btnAceptarcli;
    private javax.swing.JButton btnActualizarcli;
    private javax.swing.JButton btnCancelarcli;
    private javax.swing.JButton btnCerrarP;
    private javax.swing.JButton btnEditarcli;
    private javax.swing.JButton btnEliminarcli;
    private javax.swing.JButton btnImprimircli;
    private javax.swing.JButton btnNuevocli;
    private com.toedter.calendar.JDateChooser dchfechacli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtapellidocli;
    private javax.swing.JTextField txtcedulacli;
    private javax.swing.JTextField txtdireccli;
    private javax.swing.JLabel txtid;
    private javax.swing.JTextField txtidCliente;
    private javax.swing.JTextField txtnombrecli;
    private javax.swing.JTextField txttelfcli;
    // End of variables declaration//GEN-END:variables
}
