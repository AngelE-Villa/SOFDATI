/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Empleado;
import Vista.Inicio;
import Vista.Login;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Control_Inicio {

    Inicio inicio;

    public Control_Inicio(Inicio inicio) {
        this.inicio = inicio;
        this.inicio.setVisible(true);
        this.inicio.setLocationRelativeTo(null);
    }

    public void iniciarLogin(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
            inicio.setVisible(false);
            Login l = new Login();
            Modelo_Empleado ma = new Modelo_Empleado();
            Control_Login cl = new Control_Login(l, ma);
            cl.Iniciar_Controles();
        } catch (InterruptedException ex) {
            Logger.getLogger(Control_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
