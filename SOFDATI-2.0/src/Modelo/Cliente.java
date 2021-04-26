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

    public Cliente(String idCliente, String cedula, String nombre, String apellido, Date fnacimiento, String direccion, String telefono, String sexo) {
        super(cedula, nombre, apellido, fnacimiento, direccion, telefono, sexo);
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
