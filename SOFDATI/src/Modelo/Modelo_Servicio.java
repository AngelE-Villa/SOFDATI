/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Modelo_Servicio(String codservicio) {
        super(codservicio);
    }
    
    public boolean Grabar_Servicio() {

        String sql;
        sql = "INSERT INTO servicio (km_salida,km_llegada,cod_ciudad_s,cod_cliente_s,cod_empleado_s,fecha_servicio,cod_vehiculo_s,cod_servicio)";
        sql += "VALUES ('" + getKm_salida() + "','" + getKm_llegada() + "','" + getCodciudad() + "','" + getCodcliente() + "',"
                + "'" + getCodempleado() + "','" + getFechaServicio() + "','" + getCodvehiculo() + "','" + getCodservicio()+ "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Servicio> ListarServicios(String buscar) {
        try {
            String query = "SELECT * FROM servicio WHERE UPPER(cod_servicio) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(cod_vehiculo_s) LIKE UPPER('" + buscar + "%') OR UPPER(cod_empleado_s) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(cod_cliente_s) LIKE UPPER('" + buscar + "%')OR UPPER(cod_ciudad_s) LIKE UPPER('" + buscar + "%')";
            ResultSet rs = con.query(query);
            List<Servicio> listaS = new ArrayList<Servicio>();
            
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setCodservicio(rs.getString("cod_servicio"));
                servicio.setCodvehiculo(rs.getString("cod_vehiculo_s"));
                servicio.setFechaServicio(rs.getDate("fecha_servicio"));
                servicio.setCodempleado(rs.getString("cod_servicio"));
                servicio.setCodcliente(rs.getString("cod_cliente_s"));
                servicio.setCodciudad(rs.getString("cod_ciudad_s"));
                servicio.setKm_llegada(rs.getDouble("km_llegada"));
                servicio.setKm_salida(rs.getDouble("km_salida"));

                listaS.add(servicio);
            }
            rs.close();
            return listaS;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean ValidarServicio() throws SQLException {
        String query = "SELECT * FROM servicio WHERE cod_servicio='" + getCodservicio() + "';";
        ResultSet rs = con.query(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    public  List<Servicio> BuscarServicio(String codservicio) {
        try {
            String query = "SELECT * FROM servicio WHERE UPPER(cod_servicio) LIKE UPPER('" + codservicio + "%') ";
            ResultSet rs = con.query(query);
            List<Servicio> listaS = new ArrayList<Servicio>();
            
            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setCodservicio(rs.getString("cod_servicio"));
                servicio.setCodvehiculo(rs.getString("cod_vehiculo_s"));
                servicio.setFechaServicio(rs.getDate("fecha_servicio"));
                servicio.setCodempleado(rs.getString("cod_servicio"));
                servicio.setCodcliente(rs.getString("cod_cliente_s"));
                servicio.setCodciudad(rs.getString("cod_ciudad_s"));
                
                servicio.setKm_llegada(rs.getDouble("km_llegada"));
                servicio.setKm_salida(rs.getDouble("km_salida"));

                listaS.add(servicio);
            }
            rs.close();
            return listaS;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public boolean Editar() {
        String sql;
        sql = "UPDATE servicio SET km_salida=" + getKm_salida()+ ", km_llegada= " + getKm_llegada() + " ,"
                + "cod_ciudad_s='" + getCodciudad() + "', cod_cliente_s='" + getCodcliente() + "',"
                + "cod_empleado_s='" + getCodempleado()+ "',fecha_servicio='" + getFechaServicio() + "', "
                + "cod_vehiculo_s=" + getCodvehiculo()+ "'"
                + "WHERE cod_servicio='" + getCodservicio() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EliminarServicio() {
        String sql;
        sql = "DELETE FROM servicio  WHERE cod_servicio='" + getCodservicio() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
}
