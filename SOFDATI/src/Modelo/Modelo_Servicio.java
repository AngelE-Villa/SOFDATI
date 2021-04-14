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

    public static ConexionBADA con = new ConexionBADA();

    public Modelo_Servicio() {
    }

    public Modelo_Servicio(String codservicio, Date fechaServicio, double km_llegada, double km_salida, String codvehiculo, String codempleado, String codcliente, String codciudad, double precioServicio) {
        super(codservicio, fechaServicio, km_llegada, km_salida, codvehiculo, codempleado, codcliente, codciudad, precioServicio);
    }

    public Modelo_Servicio(String codservicio) {
        super(codservicio);
    }

    public int NServicio() {
        String query = "select max(cod_servicio) as num from servicio";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 10000000;
    }

//    public String CodServicio(String servicio) {
//        String sql="select cod_servicio where UPPER(cod_servicio)='"+servicio+"'";
//        ResultSet rs = con.query(sql);
//        try {
//            while (rs.next()) {
//                return rs.getString("cod_servicio");
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public boolean Grabar_Servicio() {

        String sql;
        sql = "INSERT INTO servicio (km_salida,km_llegada,cod_ciudad_s,cod_cliente_s,cod_empleado_s,fecha_servicio,cod_vehiculo_s,cod_servicio,precioservicio)";
        sql += "VALUES ('" + getKm_salida() + "','" + getKm_llegada() + "','" + getCodciudad() + "','" + getCodcliente() + "',"
                + "'" + getCodempleado() + "','" + getFechaServicio() + "','" + getCodvehiculo() + "','" + getCodservicio() + "','" + getPrecioServicio() + "')";
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
                servicio.setCodempleado(rs.getString("cod_empleado_s"));
                servicio.setCodcliente(rs.getString("cod_cliente_s"));
                servicio.setCodciudad(rs.getString("cod_ciudad_s"));
                servicio.setKm_llegada(rs.getDouble("km_llegada"));
                servicio.setKm_salida(rs.getDouble("km_salida"));
                servicio.setPrecioServicio(rs.getDouble("precioservicio"));

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

    public List<Servicio> BuscarServicio(String codservicio) {
        try {
            String query = "SELECT s.km_salida, s.k_llegada, s.cod_ciudad_s, s.cod_cliente_s, "
                    + "s.cod_empleado_s, s.fecha_servicio, s.cod_vehiculo_s , s.cod_servicio, "
                    + "s.precioservicio, l.canton, c.nombre_ct, p.nombre_producto, ds.cantidad "
                    + "from servicio s "
                    + "join localidad l on s.cod_ciudad_s=l.cod_ciudad "
                    + "join detalle_servicio ds on s.cod_servicio=ds.cod_servicio_d "
                    + "join producto p on p.cod_producto=ds.cod_producto_detalle "
                    + "join categorias c on p.cod_ct_producto=c.cod_categoria "
                    + "WHERE UPPER(cod_servicio) LIKE UPPER('" + codservicio + "%')";
            ResultSet rs = con.query(query);
            List<Servicio> listaS = new ArrayList<Servicio>();

            while (rs.next()) {
                Servicio servicio = new Servicio();
                servicio.setCodservicio(rs.getString("cod_servicio"));
                servicio.setCodvehiculo(rs.getString("cod_vehiculo_s"));
                servicio.setFechaServicio(rs.getDate("fecha_servicio"));
                servicio.setCodempleado(rs.getString("cod_empleado_s"));
                servicio.setCodcliente(rs.getString("cod_cliente_s"));
                servicio.setCodciudad(rs.getString("cod_ciudad_s"));
                servicio.setKm_llegada(rs.getDouble("km_llegada"));
                servicio.setKm_salida(rs.getDouble("km_salida"));
                servicio.setPrecioServicio(rs.getDouble("precioservicio"));

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
        sql = "UPDATE servicio SET km_salida=" + getKm_salida() + ", km_llegada= " + getKm_llegada() + " ,"
                + "cod_ciudad_s='" + getCodciudad() + "', cod_cliente_s='" + getCodcliente() + "',"
                + "cod_empleado_s='" + getCodempleado() + "',fecha_servicio='" + getFechaServicio() + "', "
                + "cod_vehiculo_s=" + getCodvehiculo() + "', precioservicio=" + getPrecioServicio() + "'"
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
