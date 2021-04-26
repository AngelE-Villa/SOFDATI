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

/**
 *
 * @author daysi
 */
public class ModeloProducto extends Productos {

    private static ConexionBADA con = new ConexionBADA();

    public ModeloProducto() {
    }

    public ModeloProducto(String cod_producto, String nombre_producto, String unidad_medida, String cod_categoria) {
        super(cod_producto, nombre_producto, unidad_medida, cod_categoria);
    }

    public ModeloProducto(String cod_producto) {
        super(cod_producto);
    }

    public ModeloProducto(Image foto) {
        super(foto);
    }

    public int NProducto() {
        String query = "select max(cod_producto) as num from producto";
        ResultSet rs = con.query(query);

        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 2000;
    }

    public String codigo_producto(String prod) {

        String query = "select cod_producto from producto where UPPER(nombre_producto)=UPPER('" + prod + "') and estado=1";
        ResultSet rs = con.query(query);
        try {
            while (rs.next()) {
                return rs.getString("cod_producto");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean grabar() {
        //Trnasformar Imagen a base 64
//        String foto64 = null;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//            BufferedImage img = imgBimage(getFoto());
//
//            ImageIO.write(img, "PNG", bos);
//
//            byte[] imgb = bos.toByteArray();
//            foto64 = Base64.encodeBytes(imgb);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
        String sql;
        sql = "INSERT INTO producto(cod_producto,cod_ct_producto,nombre_producto,medida_producto,estado)";
        sql += "VALUES ( '" + getCod_producto() + "','" + getCod_categoria() + "','" + getNombre_producto() + "','" + getUnidad_medida() + "'," + 1 + ")";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    private BufferedImage imgBimage(Image img) {
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

    public boolean editar() {
        //Trnasformar Imagen a base 64
//        String foto64 = null;
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        try {
//            BufferedImage img = imgBimage(getFoto());
//
//            ImageIO.write(img, "PNG", bos);
//
//            byte[] imgb = bos.toByteArray();
//            foto64 = Base64.encodeBytes(imgb);
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
        String sql;
        sql = "UPDATE producto SET nombre_producto='" + getNombre_producto() + "', medida_producto='" + getUnidad_medida() + "', "
                + "cod_ct_producto='" + getCod_categoria() + "',estado="+1+" "
                + "WHERE cod_producto='" + getCod_producto() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar() {
        String sql;
        sql = "UPDATE producto set estado=0 WHERE cod_producto = '" + getCod_producto() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Productos> ListarProducto(String aguja) {

        try {
            String query = "select * from producto where "
                    + "UPPER (cod_producto) like UPPER('" + aguja + "%') AND estado=1 OR "
                    + "UPPER (nombre_producto) like UPPER('" + aguja + "%') AND estado=1 OR "
                    + "UPPER (medida_producto) like UPPER('" + aguja + "%') AND estado=1 OR "
                    + "UPPER (cod_ct_producto) like UPPER ('" + aguja + "%') AND estado=1 ";
            ResultSet rs = con.query(query);
            List<Productos> lista = new ArrayList<Productos>();
//            byte[] bf;
            while (rs.next()) {
                Productos producto = new Productos();
                producto.setCod_producto(rs.getString("cod_producto"));
                producto.setCod_categoria(rs.getString("cod_ct_producto"));
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setUnidad_medida(rs.getString("medida_producto"));
                lista.add(producto);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Productos> BuscarProducto(String prod) {
        try {
            String query = "SELECT p.cod_producto as cod, c.nombre_ct as categoria,p.nombre_producto as nombre, p.medida_producto as medida "
                    + "FROM producto p "
                    + "JOIN categorias c "
                    + "ON p.cod_ct_producto=c.cod_categoria "
                    + "WHERE cod_producto='" + prod + "' AND estado=1;";
            ResultSet rs = con.query(query);
            List<Productos> lista = new ArrayList<Productos>();

            while (rs.next()) {
                Productos producto = new Productos();
                producto.setCod_producto(rs.getString("cod"));
                producto.setCod_categoria(rs.getString("categoria"));
                producto.setNombre_producto(rs.getString("nombre"));
                producto.setUnidad_medida(rs.getString("medida"));
//               
                lista.add(producto);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static Image obterImagen(byte[] bytes) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object sourse = bis;
        ImageInputStream lis = ImageIO.createImageInputStream(sourse);
        reader.setInput(lis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(4, 4, 0, 0);
        return reader.read(0, param);
    }

}
