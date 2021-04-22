/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import Modelo.Modelo_Empleado;
import Vista.Login;
import Vista.Principal;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Control_Login {

    Login login;
    Modelo_Empleado modelo;
    public boolean mostrar = true;

    public Control_Login(Login login, Modelo_Empleado modelo) {
        this.login = login;
        this.modelo = modelo;
        this.login.setVisible(true);
        this.login.setLocationRelativeTo(null);
        this.login.getTxtpassword().setVisible(true);
        this.login.getPassvisible().setVisible(false);

    }

    public void Iniciar_Controles() {
        login.getBtnIngresar().addActionListener(l -> Ingresar());
        login.getBtnregistrarDReg().addActionListener(l -> Registrar());
        login.getBtnRegistar().addActionListener(l -> AbriDialogoRegistar());
        login.getBtnDRecup().addActionListener(l -> Recuperar());
        login.getBtnRecuperar().addActionListener(l -> AbriDialogoRecuperar());
        login.getBtnCerrarLogin().addActionListener(l -> CerrarLogin());
        login.getBtnExaminarReg().addActionListener(l -> CargarImagen());
        login.getBtnver().addActionListener(l -> Botonver());

    }

    public void CerrarLogin() {
        int a = JOptionPane.showConfirmDialog(login, "Esta Seguro de Salir", "", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);

        }
    }

    public void Ingresar() {
//        modelo.setCedula(login.getTxtUsuario().getText());
//        modelo.setPassword(String.valueOf(login.getTxtpassword().getPassword()));

        modelo.setCedula("1400995010");
        modelo.setPassword("Valeria");

        if (modelo.ValidarDatos()) {
            login.setVisible(false);
            Principal p = new Principal();
            Control_Principal cp = new Control_Principal(p);
            cp.MandarUsuario(modelo.getCedula());
            cp.Inicia_Control();
        } else {
            JOptionPane.showMessageDialog(login, "Usuario o Contraseña Invalidos");
            login.getTxtpassword().setText("");
        }
    }

    public void AbriDialogoRegistar() {
        login.getRegistarLogin().setVisible(true);
        login.getRegistarLogin().setSize(300, 450);
        login.getRegistarLogin().setLocationRelativeTo(login);
        login.getTxtcedulaReg().setText("");
        login.getTxtcontra1reg().setText("");
        login.getTxtcontra2reg().setText("");
        login.getTxtpalabra().setText("");
    }

    public void Registrar() {
        String ced = login.getTxtcedulaReg().getText();
        String contra1 = String.valueOf(login.getTxtcontra1reg().getPassword());
        String palabra = login.getTxtpalabra().getText();
        if (modelo.buscarEmpleado(ced)) {
            System.out.println("Empleado existe");
            if (modelo.Editar_EmpleadoAd(ced, contra1, palabra)) {
                JOptionPane.showMessageDialog(login, "Regsitro Exitoso");
            }

        } else {
            String cod = modelo.NEmpleados() + 1 + "";
            String nom = login.getTxnombrereg().getText();
            String apel = login.getTxtapellidoreg().getText();
            String tel = login.getTxttelefReg().getText();
            String dir = login.getTxtdireccionReg().getText();
            Instant intate = login.getDatachoserReg().getDate().toInstant();
            ZoneId zona = ZoneId.of("America/Guayaquil");
            ZonedDateTime zot = ZonedDateTime.ofInstant(intate, zona);
            Date fnam = Date.valueOf(zot.toLocalDate());
            String contra2 = String.valueOf(login.getTxtcontra1reg().getPassword());

            if (contra1.equals(contra2)) {
                Modelo_Empleado mr = new Modelo_Empleado(cod, 0.0, "Servicio Cliente", contra1, palabra, ced, nom, apel, fnam, dir, tel);
                ImageIcon ic = (ImageIcon) login.getLblfoto().getIcon();
                mr.setFoto(ic.getImage());

                if (mr.Grabar_Empleado()) {
                    JOptionPane.showMessageDialog(login, "Registro Exitoso");
                    login.getRegistarLogin().setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(login, "Error al Registrar");
                }

            } else {
                JOptionPane.showMessageDialog(login, "Las contraseñas no coinciden");
            }
        }

    }

    public void AbriDialogoRecuperar() {
        login.getDialogoRecuperar().setVisible(true);
        login.getDialogoRecuperar().setSize(360, 300);
        login.getDialogoRecuperar().setLocationRelativeTo(login);
        login.getTxtbuscarRecup().setText("");
        login.getLblDRecuperar().setText("");
    }

    public void Recuperar() {
        String busqueda = login.getTxtbuscarRecup().getText();
        List<Empleado> adm = modelo.RecuperarCuenta(busqueda);
        if (0 == adm.size()) {
            JOptionPane.showMessageDialog(login, "Lo existe la cuenta");
        } else {
            for (int i = 0; i < adm.size(); i++) {
                Empleado a = adm.get(i);
                String usuario = a.getCedula();
                String password = a.getPassword();
                String palabra = a.getPalabra();

                login.getLblDRecuperar().setText(password);
                login.getLblDRecuperar().setBackground(Color.white);
            }
        }
    }

    public void CargarImagen() {

        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int estado = jfc.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {
            try {
                Image icono = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        login.getLblfoto().getWidth(),
                        login.getLblfoto().getHeight(),
                        Image.SCALE_DEFAULT
                );
                Icon ic = new ImageIcon(icono);
                login.getLblfoto().setIcon(ic);
                login.getLblfoto().updateUI();

            } catch (IOException ex) {
                Logger.getLogger(Control_Empleado.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void Botonver() {
        if (mostrar) {
            ImageIcon iconobtn = new ImageIcon("src/Vista/Recursos/ocultar.png");
            login.getTxtpassword().setVisible(false);
            login.getPassvisible().setVisible(true);
            login.getPassvisible().setText(String.valueOf(login.getTxtpassword().getPassword()));
            login.getBtnver().setIcon(iconobtn);
            mostrar = false;
        } else {
            ImageIcon iconolbl = new ImageIcon("src/Vista/Recursos/ver.png");
            login.getTxtpassword().setVisible(true);
            login.getPassvisible().setVisible(false);
            login.getTxtpassword().setText(login.getPassvisible().getText());
            login.getBtnver().setIcon(iconolbl);
            mostrar = true;
        }
    }
}
