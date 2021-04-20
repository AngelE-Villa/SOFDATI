/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Cliente extends Persona{
    
  //Atributos  
   String idCliente;

   //Constructor
   public Cliente(){
       
   }

    public Cliente(String cedula) {
        super(cedula);
    }
    public Cliente(String idCliente, String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        super(cedula, nombre, apellido, fnacimineto, direccion, telefono);
        this.idCliente = idCliente;
    }
    
    //gett y sett

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    

 
   
 
   
}
