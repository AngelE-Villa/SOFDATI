package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionPG {
    private Connection con;
    private Statement st;
    
    private String CadenaConexion="jdbc:postgresql://localhost:5432/poobada";
    private String usuario="postgres";
    private String password="Angel0906@";

    public ConexionPG() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection( CadenaConexion, usuario, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public ResultSet query(String sql){
        try {
            st=con.createStatement();
            ResultSet rs=st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }

    public SQLException noQuery (String nqry){
        try {
            st=con.createStatement();
            st.execute(nqry);
            return  null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
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
