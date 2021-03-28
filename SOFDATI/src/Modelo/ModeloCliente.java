
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
    
    public ModeloCliente(String idCliente, String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        super(idCliente, cedula, nombre, apellido, fnacimineto, direccion, telefono);
    }
    
    public boolean Grabar_Cliente() {

        String sql;
        sql = "INSERT INTO cliente (cod_cliente,cedula_pe,nombre,apellido,fnacimiento,direccion,telefono)";
        sql += "VALUES ('" + getIdCliente() + "','" + getCedula() + "','" + getNombre() + "','" + getApellido()+ "',"
                + "'" + getFnacimiento()+ "','" + getDireccion()+ "','" + getTelefono()+ "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EditarCliente() {
       
        String sql;
        sql = "UPDATE \"cliente\" " + " " + "SET cod_cliente='" + getIdCliente()+ "',cedula_pe='" + getCedula()+ "',nombre='" + getNombre()+ "',apellido='" + getApellido()
                + "',fnacimiento='"+ getFnacimiento()+ "',direccion='" + getDireccion()+ "','";
        sql += "WHERE idCliente='" + getIdCliente()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminarCliente() {
        String sql;
        sql = "DELETE FROM \"cliente\" " + " " + "WHERE idCliente='" + getIdCliente()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Cliente> listaClientes(String busqueda) {
        try {
            String query = "select cod_cliente,cedula_pe,nombre,apellido,fechanacimineto,direccion,telefono from \"cliente\" WHERE ";
            query += "UPPER(nombre) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(apellido) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(idCliente) LIKE UPPER('%" + busqueda + "%')";
            ResultSet rs = con.query(query);
            List<Cliente> lista = new ArrayList<Cliente>();
            byte[] bf;
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getString("cod_cliente"));
                c.setCedula(rs.getString("cedula_pe"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setFnacimiento(rs.getDate("fechanacimiento"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Cliente> BuscarporID(String busqueda) {
        try {
            String query = "select * from \"cliente\" WHERE cod_cliente = '" + busqueda + "'";

            ResultSet rs = con.query(query);
            List<Cliente> lista = new ArrayList<Cliente>();
            byte[] bf;
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getString("cod_cliente"));
                c.setCedula(rs.getString("cedula_pe"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setFnacimiento(rs.getDate("fechanacimiento"));
                c.setDireccion(rs.getString("direccion"));
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
