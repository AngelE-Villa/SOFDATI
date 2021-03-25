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
public class Modelo_Servicio extends Servicio {
    
    public static ConexionBADA con=new ConexionBADA();

    public Modelo_Servicio() {
    }

    public Modelo_Servicio(String codservicio, Date fechaServicio, double km_llegada, double km_salida, String codvehiculo, String codempleado, String codcliente, String codciudad) {
        super(codservicio, fechaServicio, km_llegada, km_salida, codvehiculo, codempleado, codcliente, codciudad);
    }
    
    public boolean Grabar_Servicio() {

        String sql;
        sql = "INSERT INTO servicio (km_salida,km_llegada,cod_cuidad_s,cod_cliente_s,cod_empleado_s,fecha_servicio,cod_vehiculo_s,cod_servicio)";
        sql += "VALUES ('" + getKm_salida() + "','" + getKm_llegada() + "','" + getCodciudad() + "','" + getCodcliente() + "',"
                + "'" + getCodempleado() + "','" + getFechaServicio() + "','" + getCodvehiculo() + "','" + getCodservicio()+ "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
}
