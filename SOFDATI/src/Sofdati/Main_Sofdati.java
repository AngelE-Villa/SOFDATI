/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sofdati;

import Controlador.Control_Principal;
import Vista.Principal;

/**
 *
 * @author Usuario
 */
public class Main_Sofdati {
    public static void main(String[] args) {
        Principal p=new Principal();
        Control_Principal cp=new Control_Principal(p);
        cp.Inicia_Control();
        
    }
}
