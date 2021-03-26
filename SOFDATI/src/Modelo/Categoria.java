/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daysi
 */
public class Categoria {
    private String cod_categoria;
    private String descripcion;
    private String nombre_categoria;

    public Categoria() {
    }

    public Categoria(String cod_categoria, String descripcion, String nombre_categoria) {
        this.cod_categoria = cod_categoria;
        this.descripcion = descripcion;
        this.nombre_categoria = nombre_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    public String getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(String cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
