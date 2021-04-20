
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
 * @author Emilia
 */
public class ModeloCliente extends Cliente{
    
    private static ConexionBADA con = new ConexionBADA();
    
    public ModeloCliente(){
        
    }

    public ModeloCliente(String cedula) {
        super(cedula);
    }
    
    public ModeloCliente(String idCliente, String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        super(idCliente, cedula, nombre, apellido, fnacimineto, direccion, telefono);
    }
    
    public String CodCliente(String cedula){
        try {
            String query = "select cod_cliente as cod from cliente where cedula_pe='"+cedula+"';";
            ResultSet rs = con.query(query);
            while (rs.next()) {
                return rs.getString("cod");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public int NCliente(){
        String query = "select max(cod_cliente) as num from cliente";
        ResultSet rs = con.query(query);
        
        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 100;
    }
    public boolean Grabar_Cliente() {
        String sql;
        sql = "INSERT INTO persona (nombre,cedula,apellido,telefono, fechanacimiento, direccion) "
                + "VALUES ('" + getNombre() + "','" + getCedula() + "','" + getApellido() + "','" + getTelefono()+ "',"
                + "" + getFnacimiento() + ",'" + getDireccion()+ "');";
        sql += "INSERT INTO cliente (cod_cliente,cedula_pe) "
                + "VALUES ('" + getIdCliente() + "','" + getCedula() + "');";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EditarCliente() {
       
        String sql;
        sql = "UPDATE persona SET nombre='" + getNombre()+ "',apellido='" + getApellido()+ "', telefono='" + getTelefono()+ "',fechanacimiento='" + getFnacimiento()
                + "',direccion='"+ getDireccion()+ "'";
        sql += "WHERE cedula='" + getCedula()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminarCliente() {
        String sql;
        sql = "DELETE FROM cliente WHERE cedula_pe='" + getCedula()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Cliente> listaClientes(String busqueda) {
        try {
            String query = "select cli.cod_cliente,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono" +
            " from cliente cli join persona p on p.cedula=cli.cedula_pe where ";
            query += "UPPER(p.nombre) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(p.apellido) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(p.cedula) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(cli.cod_cliente) LIKE UPPER('%" + busqueda + "%')";
            ResultSet rs = con.query(query);
            List<Cliente> lista = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getString("cod_cliente"));
                c.setCedula(rs.getString("cedula"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setFnacimiento(rs.getDate("fechanacimiento"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Cliente> BuscarporID(String id) {
        try {
            String query = "select cli.cod_cliente,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono" +
            " from cliente cli join persona p on p.cedula=cli.cedula_pe where ";
            query += "UPPER(p.cedula) LIKE UPPER('%" + id + "%') ";
            ResultSet rs = con.query(query);
            List<Cliente> lista = new ArrayList<Cliente>();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getString("cod_cliente"));
                c.setCedula(rs.getString("cedula"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setFnacimiento(rs.getDate("fechanacimiento"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
   
}
