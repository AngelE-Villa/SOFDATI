/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Vista_Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Vista_Cliente
     */
    public Vista_Cliente() {
        initComponents();
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

    public JInternalFrame getjInternalFrame1() {
        return jInternalFrame1;
    }

    public void setjInternalFrame1(JInternalFrame jInternalFrame1) {
        this.jInternalFrame1 = jInternalFrame1;
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

    public void setDchfechacli(JDateChooser dchfechacli) {
        this.dchfechacli = dchfechacli;
    }

    public JTextField getTxtIdcli() {
        return txtIdcli;
    }

    public void setTxtIdcli(JTextField txtIdcli) {
        this.txtIdcli = txtIdcli;
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
        jLabel5 = new javax.swing.JLabel();
        txtdireccli = new javax.swing.JTextField();
        dchfechacli = new com.toedter.calendar.JDateChooser();
        btnCancelarcli = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnAceptarcli = new javax.swing.JButton();
        txtIdcli = new javax.swing.JTextField();
        txtcedulacli = new javax.swing.JTextField();
        txtapellidocli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombrecli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txttelfcli = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        lblMensaje = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevocli = new javax.swing.JButton();
        btnEditarcli = new javax.swing.JButton();
        btnEliminarcli = new javax.swing.JButton();
        btnActualizarcli = new javax.swing.JButton();
        btnImprimircli = new javax.swing.JButton();
        btnCerrarP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();

        jLabel5.setText("Fecha");

        btnCancelarcli.setText("CANCELAR");

        jLabel8.setText("Teléfono");

        btnAceptarcli.setText("ACEPTAR");

        jLabel2.setText("Id Cliente");

        jLabel3.setText("Cedula");

        jLabel4.setText("Nombre");

        jLabel10.setText("Direccion");

        jLabel6.setText("Apellido");

        javax.swing.GroupLayout DialogClienteLayout = new javax.swing.GroupLayout(DialogCliente.getContentPane());
        DialogCliente.getContentPane().setLayout(DialogClienteLayout);
        DialogClienteLayout.setHorizontalGroup(
            DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogClienteLayout.createSequentialGroup()
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DialogClienteLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnAceptarcli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarcli))
                    .addGroup(DialogClienteLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DialogClienteLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtapellidocli, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtdireccli)
                                        .addComponent(txttelfcli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dchfechacli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogClienteLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnombrecli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcedulacli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdcli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(29, 29, 29))
        );
        DialogClienteLayout.setVerticalGroup(
            DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DialogClienteLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcedulacli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtapellidocli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(dchfechacli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelfcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdireccli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(DialogClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarcli)
                    .addComponent(btnAceptarcli))
                .addGap(20, 20, 20))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setVisible(true);

        lblMensaje.setText("Sistema Personas :");

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
                .addComponent(btnNuevocli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActualizarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimircli, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
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

        btnCerrarP.setText("CERRAR");

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Cliente", "Cedula", "Nombre", "Apellido", "Fecha Nac", "Direccion", "Telefono"
            }
        ));
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarP)
                .addGap(19, 19, 19))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarP)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1)
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
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdcli;
    private javax.swing.JTextField txtapellidocli;
    private javax.swing.JTextField txtcedulacli;
    private javax.swing.JTextField txtdireccli;
    private javax.swing.JTextField txtnombrecli;
    private javax.swing.JTextField txttelfcli;
    // End of variables declaration//GEN-END:variables
}
