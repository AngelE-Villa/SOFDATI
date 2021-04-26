/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Image;
import java.util.Date;

public class Vehiculo {
//Atributos
    String matricula,pais,color;
    Date fecha_matricula; 
    private Image foto;
// Constructor
    //Metodos
    public Vehiculo() {}

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Vehiculo(String matricula, String pais, String color, Date fecha_matricula) {
        this.matricula = matricula;
        this.pais = pais;
        this.color = color;
        this.fecha_matricula = fecha_matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFecha_matricula() {
        return fecha_matricula;
    }

    public void setFecha_matricula(Date fecha_matricula) {
        this.fecha_matricula = fecha_matricula;
    }
    
}
