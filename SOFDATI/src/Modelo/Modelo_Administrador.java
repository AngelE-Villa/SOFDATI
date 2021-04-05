/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Modelo_Administrador extends Administrador {

    private ConexionBADA con = new ConexionBADA();

    public Modelo_Administrador() {
    }

    public Modelo_Administrador(String password, String palabra, String cedula) {
        super( password, palabra, cedula);
    }

    public int NAdministrador() {
        String query = "select count(cod_login) as num from login";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public boolean ValidarDatos() {
        String sql = "SELECT * FROM login WHERE usuario ='" + getCedula() + "' AND password='" + getPassword() + "'";
        ResultSet rs = con.query(sql);
        try {
            if (rs.next() == true) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean RegistarAd(){
        String sql;
        sql = "INSERT INTO persona (cedula) "
                + "VALUES ('" + getCedula() + "');";
        sql += "INSERT INTO login (usuario,password,palabra) "
                + "VALUES ('" + getCedula() + "','" + getPassword() + "','" + getPalabra()+ "');";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public List<Administrador> RecuperarCuenta(String busqueda){
        try {
            String query = "select * from login where password='"+busqueda+"' OR palabra='"+busqueda+"'";
            ResultSet rs = con.query(query);
            List<Administrador> lista = new ArrayList<Administrador>();
            while (rs.next()) {
                Administrador a = new Administrador();
                a.setCedula(rs.getString("usuario"));
                a.setPassword(rs.getString("password"));
                a.setPalabra(rs.getString("palabra"));
                lista.add(a);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
