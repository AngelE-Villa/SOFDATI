
package Modelo;

import java.awt.Image;

public class Producto {
    private String codproducto;
    private String  nomproducto;
    private String descriproducto;
    private double costo;
    private double precio;
    private String categproducto;
    Image imagen;

    public Producto(String codproducto) {
        this.codproducto = codproducto;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Producto() {
    }

    public Producto(String codproducto, String nomproducto, String descriproducto, double costo, double precio, String categproducto) {
        this.codproducto = codproducto;
        this.nomproducto = nomproducto;
        this.descriproducto = descriproducto;
        this.costo = costo;
        this.precio = precio;
        this.categproducto = categproducto;
    }

    public String getCategproducto() {
        return categproducto;
    }

    public void setCategproducto(String categproducto) {
        this.categproducto = categproducto;
    }

    public String getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(String codproducto) {
        this.codproducto = codproducto;
    }

    public String getNomproducto() {
        return nomproducto;
    }

    public void setNomproducto(String nomproducto) {
        this.nomproducto = nomproducto;
    }

    public String getDescriproducto() {
        return descriproducto;
    }

    public void setDescriproducto(String descriproducto) {
        this.descriproducto = descriproducto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
