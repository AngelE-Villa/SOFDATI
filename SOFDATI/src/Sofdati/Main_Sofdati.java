/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sofdati;

import Controlador.Control_Servicio;
import Modelo.Modelo_Servicio;
import Vista.Vista_Servicio;

/**
 *
 * @author Usuario
 */
public class Main_Sofdati {
    public static void main(String[] args) {
        Vista_Servicio vs=new Vista_Servicio();
        Modelo_Servicio ms=new Modelo_Servicio();
        Control_Servicio cs=new Control_Servicio(vs, ms);
        cs.iniciarControl();
        cs.CargarLista("");
    }
}
