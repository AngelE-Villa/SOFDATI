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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
        ValidaLetras();
    }

    public void Iniciar_Controles() {
        login.getBtnIngresar().addActionListener(l -> Ingresar());
        login.getBtnregistrarDReg().addActionListener(l -> Registrar());
        login.getBtnRegistar().addActionListener(l -> AbriDialogoRegistar());
        login.getBtnDRecup().addActionListener(l -> Recuperar());
        login.getBtnRecuperar().addActionListener(l -> AbriDialogoRecuperar());
        login.getBtnCerrarLogin().addActionListener(l -> CerrarLogin());
        login.getBtnver().addActionListener(l -> Botonver());

    }

    public void CerrarLogin() {
        int a = JOptionPane.showConfirmDialog(login, "Esta Seguro de Salir", "", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);

        }
    }

    public void Ingresar() {
//        String con=login.getPassvisible().getText();
//        String con1=String.valueOf(login.getTxtpassword().getPassword());
//        con=con1;
//        String cont=con;
//        modelo.setCedula(login.getTxtUsuario().getText());
//        modelo.setPassword(cont);

        modelo.setCedula("1400995010");
        modelo.setPassword("Valeria");

        if (modelo.ValidarDatos()) {
            login.setVisible(false);
            Principal p = new Principal();
            Control_Principal cp = new Control_Principal(p);
            cp.MandarUsuario(modelo.getCedula());
            cp.Inicia_Control();
            cp.MostrarEstadistica(login.getTxtUsuario().getText());
        } else {
            JOptionPane.showMessageDialog(login, "Usuario o Contraseña Invalidos");
            login.getTxtpassword().setText("");
        }
    }

    public void AbriDialogoRegistar() {
        login.getRegistarLogin().setVisible(true);
        login.getRegistarLogin().setSize(270, 370);
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
        String contra2 = String.valueOf(login.getTxtcontra1reg().getPassword());
        if (modelo.buscarEmpleado(ced)) {
            if (contra1.equals(contra2)) {
                System.out.println("Empleado existe");
                if (modelo.Editar_EmpleadoAd(ced, contra1, palabra)) {
                    JOptionPane.showMessageDialog(login, "Regsitro Exitoso");
                }

            } else {
                JOptionPane.showMessageDialog(login, "Las contraseñas no coinciden");
            }
        } else {
            JOptionPane.showMessageDialog(login,"No eres empleado de SOFDATI");
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

    public boolean ValidacionesCedula(String cedula) {
        int c, suma = 0, acum, resta = 0;
        try {
            for (int i = 0; i < login.getTxtcedulaReg().getText().length() - 1; i++) {
                c = Integer.parseInt(login.getTxtcedulaReg().getText().charAt(i) + "");
                if (i % 2 == 0) {
                    c = c * 2;
                    if (c > 9) {
                        c = c - 9;
                    }
                }
                suma = suma + c;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cedula Ecuatoriana no tinen letras por defecto", "ERROR", 0);
            return false;
        }
        if (suma % 10 != 0) {
            acum = ((suma / 10) + 1) * 10;
            resta = acum - suma;
        }
        int ultimos = 0;
        try {
            ultimos = Integer.parseInt(login.getTxtcedulaReg().getText().charAt(9) + "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No cumple dos 10 dijitos por defecto", "ERROR", 0);
            return false;
        }
        int ultimo = ultimos;
        if (ultimo == resta) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "la cedula es incorrecta o no existe por defecto", "ERROR", 0);
            return false;
        }
    }

    KeyListener ValidacionesCedula = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            ValidacionesCedula("");
        }

        public void keyPressed(KeyEvent e) {
        }

        public void keyReleased(KeyEvent e) {
            if (ValidacionesCedula(login.getTxtcedulaReg().getText()) == true) {
                login.getTxtcedulaReg().setForeground(Color.GREEN);
                login.getTxtcedulaReg().setText("/");
            } else {
                login.getTxtcedulaReg().setText("*");
                login.getTxtcedulaReg().setForeground(Color.RED);
            }
        }
    };

    public void ValidaLetras() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char valida = e.getKeyChar();
                if (((valida < 'a' | valida > 'z') & (valida < 'A' | valida > 'Z') & (valida < 'a') && (valida != KeyEvent.VK_SPACE))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        login.getTxtpalabra().addKeyListener(ke);

    }

}
