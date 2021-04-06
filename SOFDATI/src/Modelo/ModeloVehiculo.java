/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
public class ModeloVehiculo extends Vehiculo {

    //Atributos
    private static ConexionBADA con = new ConexionBADA();

    //Constructor
    public ModeloVehiculo() {
    }

    //Metodos
    public ModeloVehiculo(String matricula) {
        super(matricula);
    }

    public ModeloVehiculo(String ram_o_cpn, String pais, String canton, String servicio_vehiculo, String color, int anio_modelo, float tonelaje, Date fecha_ultima_matricula, Date fecha_caducidad_matricula) {
        super(ram_o_cpn, pais, canton, servicio_vehiculo, color, anio_modelo, tonelaje, fecha_ultima_matricula, fecha_caducidad_matricula);
    }

    public boolean grabar() {
        String sql;
        sql = "INSERT INTO vehiculo (ram_o_cpn,anio_modelo,tonelaje,matricula,pais,canton,fecha_ultima_matricula,servicio_vehiculo,color,fecha_caducidad_matricula)";
        sql += "VALUES('" + getRam_o_cpn() + "','" + getAnio_modelo() + "','" + getTonelaje() + "','" + getMatricula() + "','" + getFecha_ultima_matricula() + "','" + getServicio_vehiculo() + "','" + getColor() + "','" + getFecha_caducidad_matricula() + "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Vehiculo> ListarVehiculo(String aguja) {
        try {
            String query = "Select * from vehiculo WHERE matricula LIKE '" + aguja + "%' OR UPPER(color) LIKE '" + aguja + "%'";;
            ResultSet rs = con.query(query);
            List<Vehiculo> lista = new ArrayList<Vehiculo>();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setRam_o_cpn(rs.getString("ram_o_cpn"));
                vehiculo.setAnio_modelo(rs.getInt("anio_modelo"));
                vehiculo.setTonelaje(rs.getFloat("tonelaje"));
                vehiculo.setMatricula(rs.getString("matricula"));
                vehiculo.setPais(rs.getString("pais"));
                vehiculo.setCanton(rs.getString("canton"));
                vehiculo.setFecha_ultima_matricula(rs.getDate("fecha_ultima_matricula"));
                vehiculo.setColor(rs.getString("Color"));
                vehiculo.setFecha_caducidad_matricula(rs.getDate("fecha_caducidad_matricula"));
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Vehiculo> BuscarVehiculo(String aguja) {
        try {
            String query = "SELECT * FROM vehiculo WHERE matricula ='" + aguja + "';";
            ResultSet rs = con.query(query);
            List<Vehiculo> lista = new ArrayList<Vehiculo>();

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setRam_o_cpn(rs.getString("ram_o_cpn"));
                vehiculo.setAnio_modelo(rs.getInt("anio_modelo"));
                vehiculo.setTonelaje(rs.getFloat("tonelaje"));
                vehiculo.setMatricula(rs.getString("matricula"));
                vehiculo.setPais(rs.getString("pais"));
                vehiculo.setCanton(rs.getString("canton"));
                vehiculo.setFecha_ultima_matricula(rs.getDate("fecha_ultima_matricula"));
                vehiculo.setColor(rs.getString("Color"));
                vehiculo.setFecha_caducidad_matricula(rs.getDate("fecha_caducidad_matricula"));
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editar() {

        String sql;
        sql = "UPDATE vehiculo SET " + "anio_modelo='" + getAnio_modelo()
                + "', tonelaje='" + getTonelaje() + "',"
                + "pais=" + getPais() + ", canton=" + getCanton() + ","
                + "servicio_vehiculo='" + getServicio_vehiculo() + "'"
                + "WHERE matricula='" + getMatricula() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminar() {
        String sql;
        sql = "DELETE FROM vehiculo WHERE cedula_pe='" + getMatricula() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
