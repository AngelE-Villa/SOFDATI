
package Modelo;

/**
 *
 * @author Usuario
 */
public class Detalle_Servicio {
    
    private String cod_dellate_servicio;
    private String cod_producto_servicio;
    private String cod_servicio_servicio;
    private double precio_unitario;
    private int cantidad;

    public Detalle_Servicio() {
    }

    public Detalle_Servicio(String cod_dellate_servicio, String cod_producto_servicio, String cod_servicio_servicio, double precio_unitario, int cantidad) {
        this.cod_dellate_servicio = cod_dellate_servicio;
        this.cod_producto_servicio = cod_producto_servicio;
        this.cod_servicio_servicio = cod_servicio_servicio;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCod_dellate_servicio() {
        return cod_dellate_servicio;
    }

    public void setCod_dellate_servicio(String cod_dellate_servicio) {
        this.cod_dellate_servicio = cod_dellate_servicio;
    }

    public String getCod_producto_servicio() {
        return cod_producto_servicio;
    }

    public void setCod_producto_servicio(String cod_producto_servicio) {
        this.cod_producto_servicio = cod_producto_servicio;
    }

    public String getCod_servicio_servicio() {
        return cod_servicio_servicio;
    }

    public void setCod_servicio_servicio(String cod_servicio_servicio) {
        this.cod_servicio_servicio = cod_servicio_servicio;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    
    
    
}
