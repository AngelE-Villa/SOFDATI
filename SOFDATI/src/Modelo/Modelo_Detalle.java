
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emi
 */
public class Modelo_Detalle extends Detalle_Servicio{
    
    public static ConexionBADA con=new ConexionBADA();

    public Modelo_Detalle() {
    }

    public Modelo_Detalle(String cod_dellate_servicio) {
        super(cod_dellate_servicio);
    }
    
    public Modelo_Detalle(String cod_dellate_servicio, String cod_producto_detalle, String cod_servicio_detalle, double precio_unitario, int cantidad) {
        super(cod_dellate_servicio, cod_producto_detalle, cod_servicio_detalle, precio_unitario, cantidad);
    }
    
    public boolean Grabar_Detalle() {

        String sql;
        sql = "INSERT INTO detalle_servicio (cod_dellate_servicio, cod_producto_detalle, cod_servicio_detalle, precio_unitario,cantidad)";
        sql += "VALUES ('" + getCod_dellate_servicio() + "','" + getCod_producto_detalle() + "','" + getCod_servicio_detalle() + "','" + 
                getPrecio_unitario() + "','" + getCantidad()+ "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Detalle_Servicio> ListarDetalles(String buscar) {
        try {
            String query = "SELECT * FROM servicio_detalle WHERE";
            query += "UPPER(cod_dellate_servicio) LIKE UPPER('%" + buscar + "%') OR ";
            query += "UPPER(cod_servicio_detalle) LIKE UPPER('%" + buscar + "%')";
        
            ResultSet rs = con.query(query);
            List<Detalle_Servicio> listaD = new ArrayList<Detalle_Servicio>();
            
            while (rs.next()) {
                Detalle_Servicio detalle = new Detalle_Servicio();
                detalle.setCod_dellate_servicio(rs.getString("cod_dellate_servicio"));
                detalle.setCod_producto_detalle(rs.getString("cod_producto_detalle"));
                detalle.setCod_servicio_detalle(rs.getString("cod_servicio_detalle"));
                detalle.setPrecio_unitario(rs.getDouble("precio_unitario"));
                detalle.setCantidad(rs.getInt("cantidad"));

                listaD.add(detalle);
            }
            rs.close();
            return listaD;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean ValidarDetalle() throws SQLException {
        String query = "SELECT * FROM servicio_datella WHERE cod_dellate_servicio='" + getCod_dellate_servicio()+ "';";
        ResultSet rs = con.query(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    public  List<Detalle_Servicio> BuscarDetalle(String busqueda) {
        try {
            String query = "SELECT * FROM servicio_detalle WHERE cod_dellate_servicio = '" + busqueda + "'";
            ResultSet rs = con.query(query);
            List<Detalle_Servicio> listaD = new ArrayList<Detalle_Servicio>();
            
            while (rs.next()) {
                Detalle_Servicio detalle = new Detalle_Servicio();
                detalle.setCod_dellate_servicio(rs.getString("cod_dellate_servicio"));
                detalle.setCod_producto_detalle(rs.getString("cod_producto_detalle"));
                detalle.setCod_servicio_detalle(rs.getString("cod_servicio_detalle"));
                detalle.setPrecio_unitario(rs.getDouble("precio_unitario"));
                detalle.setCantidad(rs.getInt("cantidad"));

                listaD.add(detalle);
            }
            rs.close();
            return listaD;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Detalle.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
 
        public boolean Editar() {
        String sql;
        sql = "UPDATE detalle_servicio "+" SET cod_producto_detalle='" + getCod_producto_detalle()+
                "',precio_unitario='" + getPrecio_unitario() + "', cantidad='" + getCantidad()+"'";
        sql += "WHERE cod_dellate_servicio='" + getCod_dellate_servicio()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
      

    public boolean EliminarDetalle() {
        String sql;
        sql = "DELETE FROM detalle_servicio  WHERE cod_detalle_servicio='" + getCod_dellate_servicio()+ "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
}
    
    

