/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Servicio {
    
    private String codservicio;
    private Date fechaServicio;
    private double km_llegada;
    private double km_salida;
    private String codvehiculo;
    private String codempleado;
    private String codcliente;
    private String codciudad;
    private double precioServicio;

    public Servicio() {
    }

    public Servicio(String codservicio) {
        this.codservicio = codservicio;
    }

    public Servicio(String codservicio, Date fechaServicio, double km_llegada, double km_salida, String codvehiculo, String codempleado, String codcliente, String codciudad, double precioServicio) {
        this.codservicio = codservicio;
        this.fechaServicio = fechaServicio;
        this.km_llegada = km_llegada;
        this.km_salida = km_salida;
        this.codvehiculo = codvehiculo;
        this.codempleado = codempleado;
        this.codcliente = codcliente;
        this.codciudad = codciudad;
        this.precioServicio = precioServicio;
    }

    public double getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(double precioServicio) {
        this.precioServicio = precioServicio;
    }
    
    
    public String getCodciudad() {
        return codciudad;
    }

    public void setCodciudad(String codciudad) {
        this.codciudad = codciudad;
    }

    public String getCodservicio() {
        return codservicio;
    }

    public void setCodservicio(String codservicio) {
        this.codservicio = codservicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public double getKm_llegada() {
        return km_llegada;
    }

    public void setKm_llegada(double km_llegada) {
        this.km_llegada = km_llegada;
    }

    public double getKm_salida() {
        return km_salida;
    }

    public void setKm_salida(double km_salida) {
        this.km_salida = km_salida;
    }

    public String getCodvehiculo() {
        return codvehiculo;
    }

    public void setCodvehiculo(String codvehiculo) {
        this.codvehiculo = codvehiculo;
    }

    public String getCodempleado() {
        return codempleado;
    }

    public void setCodempleado(String codempleado) {
        this.codempleado = codempleado;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }   
}
