/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ConexionBADA {
    private Connection con;
    private Statement st;
    
    private String CadenaConexion="jdbc:postgresql://localhost:5432/basesofdati ";
    private String user="postgres";
    private String password="123";

    public ConexionBADA() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBADA.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection( CadenaConexion, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBADA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public ResultSet query(String sql){
        try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBADA.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    public SQLException noQuery (String nqry){
        try {
            st=con.createStatement();
            st.execute(nqry);
            return  null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBADA.class.getName()).log(Level.SEVERE, null, ex);
            return ex;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
