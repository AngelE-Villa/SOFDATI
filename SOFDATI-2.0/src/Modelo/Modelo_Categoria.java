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

public class Modelo_Categoria extends Categoria {
    
    private static ConexionBADA con = new ConexionBADA();

    public Modelo_Categoria() {
    }

    public Modelo_Categoria(String cod_categoria, String descripcion, String nombre_categoria) {
        super(cod_categoria, descripcion, nombre_categoria);
    }

    public Modelo_Categoria(String cod_categoria) {
        super(cod_categoria);
    }
    
    public String CategNombre(String codcat){
        String query = "SELECT nombre_ct FROM categorias WHERE cod_categoria='"+codcat+"' and estado=1";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getString("nombre_ct");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
    public int NCategoria(){
        String query = "select max(cod_categoria) as num from categorias";
        ResultSet rs = con.query(query);
        
        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 100;
    }
      public List<Categoria> BuscarCategoria() {
        try {
            String query = "SELECT * FROM categorias WHERE cod_categoria='" + getCod_categoria() + "' AND estado=1";
            ResultSet rs = con.query(query);
            List<Categoria> lista = new ArrayList<Categoria>();
            byte[] bf;
            while (rs.next()) {
                 Categoria categoria = new Categoria();
                categoria.setCod_categoria(rs.getString("cod_categoria"));
                categoria.setDescripcion(rs.getString("descripcion_ct"));
                categoria.setNombre_categoria(rs.getString("nombre_ct"));  
                lista.add(categoria);
                
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Categoria.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
        public boolean Grabar_Categoria() {
            String sql;
            sql = "INSERT INTO categorias (cod_categoria, nombre_ct, estado, descripcion_ct) "
                    + "VALUES ('" + getCod_categoria() + "','" + getNombre_categoria() + "'," + 1 + ",'" + getDescripcion()+ "')";

            if (con.noQuery(sql) == null) {
                return true;
            } else {
                return false;
            }
        }
        
        public String codigo_Categoria(String categ) {
            
            String query = "select cod_categoria from categorias where UPPER(nombre_ct)=UPPER('"+ categ +"') and estado=1";
            ResultSet rs = con.query(query);
            try {
                while (rs.next()) {
                    return rs.getString("cod_categoria");
                }
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;   
        }
        
    public static List<Categoria> ListarCategorias(String buscar) {
        try {
            String query = "SELECT * FROM categorias WHERE ";
            query += "UPPER(cod_categoria) LIKE UPPER('%" + buscar + "%') and estado=1 OR ";
            query += "UPPER(nombre_ct) LIKE UPPER('%" + buscar + "%') and estado=1";
        
            ResultSet rs = con.query(query);
            List<Categoria> listaD = new ArrayList<Categoria>();
            
            while (rs.next()) {
                Categoria ct = new Categoria();
                ct.setCod_categoria(rs.getString("cod_categoria"));
                ct.setDescripcion(rs.getString("descripcion_ct"));
                ct.setNombre_categoria(rs.getString("nombre_ct"));;

                listaD.add(ct);
            }
            rs.close();
            return listaD;
        } catch (SQLException ex) {
            Logger.getLogger(Modelo_Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }  
        
    public boolean Editar_Categoria(){  
     String sql;
        sql = "UPDATE categorias SET nombre_ct='" + getNombre_categoria() + "', descripcion_ct='"+getDescripcion()+"', estado="+1+" "
                + "WHERE cod_categoria='" + getCod_categoria() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }   
    } 
     public boolean eliminarcategoria() {
        String sql;
        sql = "UPDATE categorias SET estado= 0 where cod_categoria='"+getCod_categoria()+"';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    } 
}
