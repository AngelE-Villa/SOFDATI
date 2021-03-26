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
public class Productos extends Categoria{
    private String cod_producto;
    private String nombre_producto;
    private String unidad_medida;

    public Productos() {
    }

    public Productos(String cod_producto, String nombre_producto, String unidad_medida, String cod_categoria, String descripcion, String nombre_categoria) {
        super(cod_categoria, descripcion, nombre_categoria);
        this.cod_producto = cod_producto;
        this.nombre_producto = nombre_producto;
        this.unidad_medida = unidad_medida;
    }

  

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    
}
