/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

public class Vehiculo {
//Atributos
    String ram_o_cpn,matricula,pais,canton, servicio_vehiculo, color;
    int anio_modelo;
    float tonelaje;
    Date fecha_ultima_matricula, fecha_caducidad_matricula; 
// Constructor
    //Metodos
    public Vehiculo() {}

    public Vehiculo(String ram_o_cpn, String matricula, String pais, String canton, String servicio_vehiculo, String color, int anio_modelo, float tonelaje, Date fecha_ultima_matricula, Date fecha_caducidad_matricula) {
        this.ram_o_cpn = ram_o_cpn;
        this.matricula = matricula;
        this.pais = pais;
        this.canton = canton;
        this.servicio_vehiculo = servicio_vehiculo;
        this.color = color;
        this.anio_modelo = anio_modelo;
        this.tonelaje = tonelaje;
        this.fecha_ultima_matricula = fecha_ultima_matricula;
        this.fecha_caducidad_matricula = fecha_caducidad_matricula;
    }

    public String getRam_o_cpn() {
        return ram_o_cpn;
    }

    public void setRam_o_cpn(String ram_o_cpn) {
        this.ram_o_cpn = ram_o_cpn;
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

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getServicio_vehiculo() {
        return servicio_vehiculo;
    }

    public void setServicio_vehiculo(String servicio_vehiculo) {
        this.servicio_vehiculo = servicio_vehiculo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio_modelo() {
        return anio_modelo;
    }

    public void setAnio_modelo(int anio_modelo) {
        this.anio_modelo = anio_modelo;
    }

    public float getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(float tonelaje) {
        this.tonelaje = tonelaje;
    }

    public Date getFecha_ultima_matricula() {
        return fecha_ultima_matricula;
    }

    public void setFecha_ultima_matricula(Date fecha_ultima_matricula) {
        this.fecha_ultima_matricula = fecha_ultima_matricula;
    }

    public Date getFecha_caducidad_matricula() {
        return fecha_caducidad_matricula;
    }

    public void setFecha_caducidad_matricula(Date fecha_caducidad_matricula) {
        this.fecha_caducidad_matricula = fecha_caducidad_matricula;
    }
    
}
