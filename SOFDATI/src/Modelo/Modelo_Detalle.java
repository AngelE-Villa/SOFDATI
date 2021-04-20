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
public class Modelo_Detalle extends Detalle_Servicio {

    public static ConexionBADA con = new ConexionBADA();

    public Modelo_Detalle() {
    }

    public Modelo_Detalle(String cod_dellate_servicio) {
        super(cod_dellate_servicio);
    }

    public Modelo_Detalle(String cod_dellate_servicio, String cod_producto_detalle, String cod_servicio_detalle, double precio_unitario, int cantidad) {
        super(cod_dellate_servicio, cod_producto_detalle, cod_servicio_detalle, precio_unitario, cantidad);
    }

    public int NDetalle() {
        String query = "select max(cod_detalle_servicio) as num from detalle_servicio";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Detalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 600;
    }

    public boolean Grabar_Detalle() {

        String sql;
        sql = "INSERT INTO detalle_servicio (cod_detalle_servicio, cod_producto_detalle, cod_servicio_d, precio_unitario,cantidad)";
        sql += "VALUES ('" + getCod_dellate_servicio() + "','" + getCod_producto_detalle() + "','" + getCod_servicio_detalle() + "','"
                + getPrecio_unitario() + "','" + getCantidad() + "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Detalle_Servicio> ListarDetalles(String buscar) {
        try {
            String query = "SELECT * FROM detalle_servicio WHERE ";
            query += "UPPER(cod_detalle_servicio) LIKE UPPER('%" + buscar + "%') OR ";
            query += "UPPER(cod_servicio_d) LIKE UPPER('%" + buscar + "%')";

            ResultSet rs = con.query(query);
            List<Detalle_Servicio> listaD = new ArrayList<Detalle_Servicio>();

            while (rs.next()) {
                Detalle_Servicio detalle = new Detalle_Servicio();
                detalle.setCod_dellate_servicio(rs.getString("cod_detalle_servicio"));
                detalle.setCod_producto_detalle(rs.getString("cod_producto_detalle"));
                detalle.setCod_servicio_detalle(rs.getString("cod_servicio_d"));
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
        String query = "SELECT * FROM servicio_datella WHERE cod_dellate_servicio='" + getCod_dellate_servicio() + "';";
        ResultSet rs = con.query(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public List<Detalle_Servicio> BuscarDetalle(String busqueda) {
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
        sql = "UPDATE detalle_servicio " + " SET cod_producto_detalle='" + getCod_producto_detalle()
                + "',precio_unitario='" + getPrecio_unitario() + "', cantidad='" + getCantidad() + "'";
        sql += "WHERE cod_dellate_servicio='" + getCod_dellate_servicio() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EliminarDetalle(String pro, String cod) {
        String sql;
        sql = "DELETE FROM detalle_servicio WHERE cod_producto_detalle='" +pro+ "' and cod_servicio_d='"+cod+"';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public List<Detalle_Servicio> MostrarTabla() {
        try {
            String query = "SELECT p.cod_producto as codigo, p.nombre_producto as nombre, c.nombre_ct as categoria,d.cantidad as cantidad\n"
                    + "FROM detalle_servicio d "
                    + "JOIN producto p "
                    + "ON d.cod_producto_detalle=p.cod_producto "
                    + "JOIN categorias c "
                    + "ON c.cod_categoria=p.cod_ct_producto "
                    + "WHERE d.cod_servicio_d = '" + getCod_dellate_servicio() + "'";
            ResultSet rs = con.query(query);
            List<Detalle_Servicio> listaD = new ArrayList<Detalle_Servicio>();

            while (rs.next()) {
                Detalle_Servicio detalle = new Detalle_Servicio();
                detalle.setCod_dellate_servicio(rs.getString("codigo"));
                detalle.setCod_producto_detalle(rs.getString("nombre"));
                detalle.setCod_servicio_detalle(rs.getString("categoria"));
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
}
