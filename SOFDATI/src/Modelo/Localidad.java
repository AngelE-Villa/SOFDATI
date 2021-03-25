/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Localidad {

    //Atributos
    String cod_ciudad, pais, canton, provincia;

    //Constructor
    public Localidad() {
    }
    //Metodos

    public Localidad(String cod_ciudad, String pais, String canton, String provincia) {
        this.cod_ciudad = cod_ciudad;
        this.pais = pais;
        this.canton = canton;
        this.provincia = provincia;
    }

    public String getCod_ciudad() {
        return cod_ciudad;
    }

    public void setCod_ciudad(String cod_ciudad) {
        this.cod_ciudad = cod_ciudad;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
