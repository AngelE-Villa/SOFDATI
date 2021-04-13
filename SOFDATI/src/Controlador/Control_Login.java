/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Administrador;
import Modelo.Modelo_Administrador;
import Vista.Login;
import Vista.Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Control_Login {
    Login login;
    Modelo_Administrador modelo;
    
    FondoPanel a=new FondoPanel();
    
    public Control_Login(Login login, Modelo_Administrador modelo) {
        this.login = login;
        this.modelo = modelo;
        this.login.setVisible(true);
        this.login.setLocationRelativeTo(null);
        
    }
    
    public void Iniciar_Controles(){
        login.getBtnIngresar().addActionListener(l->Ingresar());
        login.getBtnregistrarDReg().addActionListener(l->Registrar());
        login.getBtnRegistar().addActionListener(l->AbriDialogoRegistar());
        login.getBtnDRecup().addActionListener(l->Recuperar());
        login.getBtnRecuperar().addActionListener(l->AbriDialogoRecuperar());
           
    }

    public void Ingresar() {
//        modelo.setCedula(login.getTxtUsuario().getText());
//        modelo.setPassword(String.valueOf(login.getTxtpassword().getPassword()));
        
        modelo.setCedula("1400995096");
        modelo.setPassword("Angel");

        if (modelo.ValidarDatos()) {
            login.setVisible(false);
            Principal p=new Principal();
            Control_Principal cp=new Control_Principal(p);
            cp.Inicia_Control();  
        } else {
            JOptionPane.showMessageDialog(login, "Usuario o Contraseña Invalidos");
            login.getTxtpassword().setText("");
        }
    }
    
    public void AbriDialogoRegistar(){
        login.getRegistarLogin().setVisible(true);
        login.getRegistarLogin().setSize(300, 450);
        login.getRegistarLogin().setLocationRelativeTo(login);
        login.getTxtcedulaReg().setText("");
        login.getTxtcontra1reg().setText("");
        login.getTxtcontra2reg().setText("");
        login.getTxtpalabra().setText("");
    }
    
    class FondoPanel extends JPanel{
        private Image imagen;
        
        public void paint(Graphics g){
            imagen=new ImageIcon(getClass().getResource("/Vista/Recursos/Fondo.jpg")).getImage();
            
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), login);
            setOpaque(false);
            
            super.paint(g);
        }
    }    
    
    public void Registrar(){
        String ced=login.getTxtcedulaReg().getText();
        String contra1=String.valueOf(login.getTxtcontra1reg().getPassword());
        String contra2=String.valueOf(login.getTxtcontra1reg().getPassword());
        String palabra=login.getTxtpalabra().getText();
        if (contra1.equals(contra2)) {
            Modelo_Administrador mr=new Modelo_Administrador(contra1, palabra, ced);
            if (mr.RegistarAd()) {
                JOptionPane.showMessageDialog(login, "Registro Exitoso");
                login.getRegistarLogin().setVisible(false);
            }else {
                JOptionPane.showMessageDialog(login, "Error al Registrar");
            }

        } else {
            JOptionPane.showMessageDialog(login, "Las contraseñas no coinciden");
        }
        
    
    }
    
    
    public void AbriDialogoRecuperar(){
        login.getDialogoRecuperar().setVisible(true);
        login.getDialogoRecuperar().setSize(300, 320);
        login.getDialogoRecuperar().setLocationRelativeTo(login);
        login.getTxtbuscarRecup().setText("");
        login.getLblDRecuperar().setText("");        
    }
    public void Recuperar(){
        String busqueda=login.getTxtbuscarRecup().getText();
        List<Administrador> adm=modelo.RecuperarCuenta(busqueda);
        if (0 == adm.size()) {
            JOptionPane.showMessageDialog(login, "Lo existe la cuenta");
        } else {
            for (int i = 0; i < adm.size(); i++) {
                Administrador a = adm.get(i);
                String usuario=a.getCedula();
                String password=a.getPassword();
                String palabra=a.getPalabra();
                
                login.getLblDRecuperar().setText(password);
                login.getLblDRecuperar().setBackground(Color.white);
            }
        }
    }
}
