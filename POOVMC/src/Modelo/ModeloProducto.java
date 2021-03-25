/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author Usuario
 */
public class ModeloProducto extends Producto {

    private static ConexionPG con = new ConexionPG();

    public ModeloProducto() {
    }

    public ModeloProducto(String codproducto, String nomproducto, String descriproducto, double costo, double precio, String categproducto) {
        super(codproducto, nomproducto, descriproducto, costo, precio, categproducto);
    }

    public ModeloProducto(String codproducto) {
        super(codproducto);
    }

    public boolean ValidarCodigo() throws SQLException {
        String query = "SELECT codigoprod FROM producto WHERE codigoprod='" + getCodproducto() + "';";
        ResultSet rs = con.query(query);
        if (rs.next()) {
            return true;
        } else {
            return false;
        }
    }

    public String foto64() {
        String foto64 = null;
        //Transformar imgagen a base64 para postgresql

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgImage(getImagen());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
            return foto64;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public boolean GrabarProducto() {
        String sql;
        sql = "INSERT INTO producto (codigoprod,nombre,descripcion,costo,precio,categoria,imagen)";
        sql += "VALUES ('" + getCodproducto() + "','" + getNomproducto() + "','" + getDescriproducto() + "','" + getCosto() + "',"
                + "'" + getPrecio() + "','" + getCategproducto() + "','" + foto64() + "')";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    private BufferedImage imgImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }

    public boolean EditarProducto() {
        String sql;
        sql = "UPDATE producto SET nombre='" + getNomproducto() + "', descripcion='" + getDescriproducto() + "',"
                + "costo='" + getCosto() + "', precio='" + getPrecio() + "',"
                + "categoria='" + getCategproducto() + "', imagen='" + foto64() + "'"
                + "WHERE codigoprod='" + getCodproducto() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean EliminarProducto() {
        String sql;
        sql = "DELETE FROM producto WHERE codigoprod='" + getCodproducto() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Producto> ListarProducto(String buscar) {

        try {
            String query = "SELECT * FROM producto WHERE UPPER(codigoprod) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(nombre) LIKE UPPER('" + buscar + "%') OR UPPER(descripcion) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(categoria) LIKE UPPER('" + buscar + "%')";
            ResultSet rs = con.query(query);
            List<Producto> lista = new ArrayList<Producto>();
            byte[] bf;
            while (rs.next()) {
                Producto producto = new ModeloProducto();
                producto.setCodproducto(rs.getString("codigoprod"));
                producto.setNomproducto(rs.getString("nombre"));
                producto.setDescriproducto(rs.getString("descripcion"));
                producto.setCosto(Double.parseDouble(rs.getString("costo")));
                producto.setPrecio(Double.parseDouble(rs.getString("precio")));
                producto.setCategproducto(rs.getString("categoria"));
                bf = rs.getBytes("imagen");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        producto.setImagen(ObtenImagen(bf));
                    } catch (IOException ex) {
                        producto.setImagen(null);
                        Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setImagen(null);
                }
                lista.add(producto);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static Image ObtenImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        return reader.read(0, param);
    }

    public List<Producto> BuscarProducto(String codigo) {
        try {
            String query = "SELECT * FROM producto WHERE codigoprod='" + codigo + "';";
            ResultSet rs = con.query(query);
            List<Producto> lista = new ArrayList<Producto>();
            
            byte[] bf;
            while (rs.next()) {
                Producto producto = new ModeloProducto();
                producto.setCodproducto(rs.getString("codigoprod"));
                producto.setNomproducto(rs.getString("nombre"));
                producto.setDescriproducto(rs.getString("descripcion"));
                producto.setCosto(Double.parseDouble(rs.getString("costo")));
                producto.setPrecio(Double.parseDouble(rs.getString("precio")));
                producto.setCategproducto(rs.getString("categoria"));
                bf = rs.getBytes("imagen");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        producto.setImagen(ObtenImagen(bf));
                    } catch (IOException ex) {
                        producto.setImagen(null);
                        Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setImagen(null);
                }
                lista.add(producto);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
