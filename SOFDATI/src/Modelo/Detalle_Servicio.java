package Modelo;

/**
 *
 * @author Emi
 */
public class Detalle_Servicio {
    
    private String cod_dellate_servicio;
    private String cod_producto_detalle;
    private String cod_servicio_detalle;
    private double precio_unitario;
    private int cantidad;
    

    public Detalle_Servicio() {
    }

    public Detalle_Servicio(String cod_dellate_servicio) {
        this.cod_dellate_servicio = cod_dellate_servicio;
    }
    
    

    public Detalle_Servicio(String cod_dellate_servicio, String cod_producto_detalle, String cod_servicio_detalle, double precio_unitario, int cantidad) {
        this.cod_dellate_servicio = cod_dellate_servicio;
        this.cod_producto_detalle = cod_producto_detalle;
        this.cod_servicio_detalle = cod_servicio_detalle;
        this.precio_unitario = precio_unitario;
        this.cantidad = cantidad;
    }
    
    public String getCod_dellate_servicio() {
        return cod_dellate_servicio;
    }

    public void setCod_dellate_servicio(String cod_dellate_servicio) {
        this.cod_dellate_servicio = cod_dellate_servicio;
    }

    public String getCod_producto_detalle() {
        return cod_producto_detalle;
    }

    public void setCod_producto_detalle(String cod_producto_detalle) {
        this.cod_producto_detalle = cod_producto_detalle;
    }

    public String getCod_servicio_detalle() {
        return cod_servicio_detalle;
    }

    public void setCod_servicio_detalle(String cod_servicio_detalle) {
        this.cod_servicio_detalle = cod_servicio_detalle;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

  
    
    
}
