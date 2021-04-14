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
public class Modelo_Localidad extends Localidad {

    //Atributos
    private static ConexionBADA con = new ConexionBADA();

    //Constructor
    public Modelo_Localidad() {
    }
    //Metodos

    public Modelo_Localidad(String cod_ciudad) {
        super(cod_ciudad);
    }

    public Modelo_Localidad(String cod_ciudad, String pais, String canton, String provincia) {
        super(cod_ciudad, pais, canton, provincia);
    }


    
    public int NLocalizacion() {
        String query = "select max(cod_ciudad) as num from localidad";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1000;
    }

    public boolean grabar() {
        String sql;
        sql = "INSERT INTO localidad (cod_ciudad,pais,provincia,canton)";
        sql += "VALUES('" + getCod_ciudad() + "','" + getPais() + "','" + getProvincia() + "','" + getCanton() + "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public String CodLocalizacion(String local) {
        String sql="select cod_ciudad from localidad where UPPER(canton)=UPPER('"+local+"')";
        ResultSet rs = con.query(sql);
        try {
            while (rs.next()) {
                return rs.getString("canton");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public static List<Localidad> ListarLocalidad(String aguja) {
        try {
            String query = "Select * from localidad WHERE cod_ciudad LIKE UPPER('" + aguja + "%') OR UPPER(canton) LIKE UPPER('" + aguja + "%')";
            ResultSet rs = con.query(query);
            List<Localidad> lista = new ArrayList<Localidad>();

            while (rs.next()) {
                Localidad localidad = new Localidad();
                localidad.setCod_ciudad(rs.getString("cod_ciudad"));
                localidad.setPais(rs.getString("pais"));
                localidad.setProvincia(rs.getString("provincia"));
                localidad.setCanton(rs.getString("canton"));

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Localidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static List<Localidad> BuscarLocalidad(String aguja) {
        try {
            String query = "SELECT * FROM localidad WHERE cod_ciudad LIKE UPPER('" + aguja + "');";
            ResultSet rs = con.query(query);
            List<Localidad> lista = new ArrayList<Localidad>();

            while (rs.next()) {
                Localidad localidad = new Localidad();
                localidad.setCod_ciudad(rs.getString("cod_ciudad"));
                localidad.setPais(rs.getString("pais"));
                localidad.setProvincia(rs.getString("provincia"));
                localidad.setCanton(rs.getString("canton"));
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Localidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editar() {

        String sql;
        sql = "UPDATE localidad SET " + "cod_ciudad='" + getCod_ciudad()
                + "', pais='" + getPais() + "',"
                + "provincia=" + getProvincia() + ", canton=" + getCanton() + ","
                + "WHERE cod_ciudad='" + getCod_ciudad() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminar() {
        String sql;
        sql = "DELETE FROM localidad WHERE cod_ciudad='" + getCod_ciudad() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
