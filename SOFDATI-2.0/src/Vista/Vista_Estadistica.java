/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Usuario
 */
public class Vista_Estadistica extends javax.swing.JFrame {

// FondoPanel a=new FondoPanel();
//    ConexionBADA conecto=new ConexionBADA();
//    DatosUsuario datos=new DatosUsuario();
//     JuegosUsuario juegos=new JuegosUsuario();
//     EstadisticaUsuario estadistica=new EstadisticaUsuario();

    public Vista_Estadistica() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Contenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bntEstaClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnEstaProductos = new javax.swing.JButton();
        btnEstaServicios = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Contenedor.setBackground(new java.awt.Color(204, 204, 255));
        Contenedor.setPreferredSize(new java.awt.Dimension(310, 285));

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        bntEstaClientes.setBackground(new java.awt.Color(255, 255, 255));
        bntEstaClientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bntEstaClientes.setForeground(new java.awt.Color(255, 255, 255));
        bntEstaClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/user_thin_icon_171437.png"))); // NOI18N
        bntEstaClientes.setToolTipText("Estadistica Cliente");
        bntEstaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEstaClientesActionPerformed(evt);
            }
        });

        btnEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/identification_card_thin_icon_171705.png"))); // NOI18N
        btnEmpleados.setToolTipText("Estadistica Empleados");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnEstaProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnEstaProductos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEstaProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnEstaProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/package_thin_icon_171607.png"))); // NOI18N
        btnEstaProductos.setToolTipText("Estadistica Productos");
        btnEstaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstaProductosActionPerformed(evt);
            }
        });

        btnEstaServicios.setBackground(new java.awt.Color(255, 255, 255));
        btnEstaServicios.setForeground(new java.awt.Color(255, 255, 255));
        btnEstaServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Recursos/clipboard_text_thin_icon_171881.png"))); // NOI18N
        btnEstaServicios.setToolTipText("Estadistica Servicios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(bntEstaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEstaServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEstaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnEstaServicios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bntEstaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 231, 47));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ESTADISTICA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public void usuario(){
//        try {
//            System.out.println(lblUsuarioJ.getText());
//            String sql="SELECT Nombre,apellido,usuario,password,edad FROM persona WHERE usuario LIKE'"+lblUsuarioJ.getText()+"'";
//            ResultSet rs=conecto.query(sql);
//            if(rs.next()){
//                String nombre=rs.getString("Nombre");
//                String apel=rs.getString("apellido");
//                String usuario=rs.getString("usuario");
//                String edad=rs.getString("edad");
//                String password=rs.getString("password");
//                
//                System.out.println(nombre+" "+apel+" "+usuario+" "+edad+" "+password);
//                datos.lblusuario.setText(usuario);
//                datos.lblnombre.setText(nombre);
//                datos.lblapellido.setText(apel);
//                datos.lbledad.setText(edad);
//                datos.lblpassword.setText(password);
//                
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TraductorlogIn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//    }
//    
//    public void usuariojuego(){
//        
//           String usua=lblUsuarioJ.getText();
//           juegos.lblusuarioirJ.setText(usua);
//
//    }

    public JPanel getContenedor() {
        return Contenedor;
    }

    public void setContenedor(JPanel Contenedor) {
        this.Contenedor = Contenedor;
    }

    public JButton getBntEstaClientes() {
        return bntEstaClientes;
    }

    public void setBntEstaClientes(JButton bntEstaClientes) {
        this.bntEstaClientes = bntEstaClientes;
    }
    

    public JButton getBtnEmpleados() {
        return btnEmpleados;
    }

    public void setBtnEmpleados(JButton btnEmpleados) {
        this.btnEmpleados = btnEmpleados;
    }

    public JButton getBtnEstaProductos() {
        return btnEstaProductos;
    }

    public void setBtnEstaProductos(JButton btnEstaProductos) {
        this.btnEstaProductos = btnEstaProductos;
    }

    public JButton getBtnEstaServicios() {
        return btnEstaServicios;
    }

    public void setBtnEstaServicios(JButton btnEstaServicios) {
        this.btnEstaServicios = btnEstaServicios;
    }

    
//    public void usuariojuegoEst(){
//        
//           String usua=lblUsuarioJ.getText();
//           estadistica.lblusuarioEs.setText(usua);
//    }
    
    private void bntEstaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEstaClientesActionPerformed
        
       
//       datos.setSize(479, 488);
//       datos.setLocation(5, 5);
//       Contenedor.removeAll();
//       Contenedor.add(datos,BorderLayout.CENTER);
//       Contenedor.revalidate();
//       Contenedor.repaint();
//       usuario();
    }//GEN-LAST:event_bntEstaClientesActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed

//       juegos.setSize(479, 488);
//       juegos.setLocation(5, 5);
//       Contenedor.removeAll();
//       Contenedor.add(juegos,BorderLayout.CENTER);
//       Contenedor.revalidate();
//       Contenedor.repaint();
//       usuariojuego();
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnEstaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstaProductosActionPerformed
       
//       estadistica.setSize(479, 488);
//       estadistica.setLocation(5, 5);
//       Contenedor.removeAll();
//       Contenedor.add(estadistica,BorderLayout.CENTER);
//       Contenedor.revalidate();
//       Contenedor.repaint();
//       usuariojuegoEst();
    }//GEN-LAST:event_btnEstaProductosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Contenedor;
    private javax.swing.JButton bntEstaClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnEstaProductos;
    private javax.swing.JButton btnEstaServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

//    public void enviardatos(){
//        
//         try {
//            TraductorlogIn tl=new TraductorlogIn();
//            tl.setVisible(true);
//            this.dispose();
//            System.out.println(lblUsuarioJ.getText());
//            String sql="SELECT usuario, Nombre, apellido FROM persona WHERE usuario LIKE '"+lblUsuarioJ.getText()+"'";
//            ResultSet rs=conecto.query(sql);
//            if(rs.next()){
//                
//                String usuario=rs.getString("usuario");
//                String nombre=rs.getString("Nombre");
//                String apel=rs.getString("apellido");
//                
//                String b=nombre+" "+apel;
//                System.out.println(b);
//                
//                System.out.println(usuario);
//                tl.lblusuarioT.setText(usuario);
//                tl.lblnombresUT.setText(b);
//                
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(TraductorlogIn.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  
//    public void eliminar(){
//         int p=JOptionPane.showConfirmDialog(null, "¿Si elimina su cuenta perderá todo su progreso en el juego ¿Seguro desea eliminar su cuenta?");
//        
//        if (p==0) {
//            try {
//            String sql1="DELETE FROM juego WHERE usuarioJ LIKE'"+lblUsuarioJ.getText()+"'";
//            String sql="DELETE FROM persona WHERE usuario LIKE'"+lblUsuarioJ.getText()+"'";
//            PreparedStatement a=conecto.getCon().prepareStatement(sql1);
//            PreparedStatement ab=conecto.getCon().prepareStatement(sql);
//            a.executeUpdate();
//            ab.executeUpdate();
//
//                JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado");
//                    Traductor t1=new Traductor();
//                    t1.setVisible(true);
//                    this.setVisible(false);
//                } catch (SQLException ex) {
//                Logger.getLogger(DatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            
//        } else {
//            if (p==2) {
//                  JOptionPane.showMessageDialog(null, "Cancelado");
//            } else {
//            }
//        }
//    }

}