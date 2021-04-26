package Modelo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class ModeloCliente extends Cliente {

    private static ConexionBADA con = new ConexionBADA();

    public ModeloCliente() {

    }

    public ModeloCliente(String cedula) {
        super(cedula);
    }

    public ModeloCliente(String idCliente, String cedula, String nombre, String apellido, Date fnacimiento, String direccion, String telefono, String sexo) {
        super(idCliente, cedula, nombre, apellido, fnacimiento, direccion, telefono, sexo);
    }

    public String CodCliente(String cedula) {
        try {
            String query = "select cod_cliente as cod from cliente where cedula_pe='" + cedula + "' and estado=1;";
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

    public int NCliente() {
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
        sql = "INSERT INTO persona (nombre,cedula,apellido,telefono, fechanacimiento, direccion,sexo) "
                + "VALUES ('" + getNombre() + "','" + getCedula() + "','" + getApellido() + "','" + getTelefono() + "',"
                + "'" + getFnacimiento() + "','" + getDireccion() + "','" + getSexo() + "');";
        sql += "INSERT INTO cliente (cod_cliente,cedula_pe, estado) "
                + "VALUES ('" + getIdCliente() + "','" + getCedula() + "','1');";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean Grabar_Solo_Cliente() {
        String sql;
        sql = "INSERT INTO cliente (cod_cliente,cedula_pe, estado) "
                + "VALUES ('" + getIdCliente() + "','" + getCedula() + "','1');";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public String ValidarCliente(String cedula) {
        try {
            String sql;
            sql = "Select * from cliente where cedula_pe='" + cedula + "' and estado=0";
            ResultSet rs = con.query(sql);
            if (rs.next()) {
                return rs.getString("cedula_pe");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String ValidarCliente1(String cedula) {
        try {
            String sql;
            sql = "Select * from cliente where cedula_pe='" + cedula + "' and estado=1";
            ResultSet rs = con.query(sql);
            if (rs.next()) {
                return rs.getString("cedula_pe");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean ValidarCedulaPersona(String ced) {
        String sql = "SELECT * FROM persona WHERE cedula ='" + ced + "'";
        ResultSet rs = con.query(sql);
        try {
            if (rs.next() == true) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    

    public boolean ReactivarCliente(String cedula) {
        String sql;
        sql = "UPDATE cliente set estado=1 where cedula_pe='" + cedula + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EditarCliente() {

        String sql;
        sql = "UPDATE persona SET nombre='" + getNombre() + "',apellido='" + getApellido() + "', telefono='" + getTelefono() + "',fechanacimiento='" + getFnacimiento()
                + "',direccion='" + getDireccion() + "',sexo='" + getSexo() + "'";
        sql += "WHERE cedula='" + getCedula() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EliminarCliente() {
        String sql;
        sql = "UPDATE cliente set estado=0 WHERE cedula_pe='" + getCedula() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Cliente> listaClientes(String busqueda) {
        try {
            String query = "select cli.cod_cliente,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono,p.sexo"
                    + " from cliente cli join persona p on p.cedula=cli.cedula_pe where ";
            query += "UPPER(p.nombre) LIKE UPPER('%" + busqueda + "%') AND estado=1 OR ";
            query += "UPPER(p.apellido) LIKE UPPER('%" + busqueda + "%') AND estado=1 OR ";
            query += "UPPER(p.cedula) LIKE UPPER('%" + busqueda + "%') AND estado=1 OR ";
            query += "UPPER(cli.cod_cliente) LIKE UPPER('%" + busqueda + "%') AND estado=1 OR ";
            query += "UPPER(p.sexo) LIKE UPPER('%" + busqueda + "%') AND estado=1 ";
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
                c.setSexo(rs.getString("sexo"));
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
            String query = "select cli.cod_cliente,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono,p.sexo"
                    + " from cliente cli join persona p on p.cedula=cli.cedula_pe where ";
            query += "UPPER(p.cedula) LIKE UPPER('%" + id + "%') AND estado=1 ";
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
                c.setSexo(rs.getString("sexo"));
                lista.add(c);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void ValidaLetras() {
        KeyListener ke = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char valida = e.getKeyChar();
                if (((valida < 'a' | valida > 'z') & (valida < 'A' | valida > 'Z') && (valida != KeyEvent.VK_SPACE))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
//        nombre, direccion,apellido
    }

}
