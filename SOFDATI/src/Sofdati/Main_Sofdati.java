/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sofdati;

import Controlador.Control_Login;
import Controlador.Control_Principal;
import Modelo.Modelo_Administrador;
import Vista.Login;
import Vista.Principal;

/**
 *
 * @author Usuario
 */
public class Main_Sofdati {
    public static void main(String[] args) {
        Login l=new Login();
        Modelo_Administrador ma=new Modelo_Administrador();
        Control_Login cl=new Control_Login(l, ma);
        cl.Iniciar_Controles();
        
    }
}
