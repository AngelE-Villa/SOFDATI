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

import org.postgresql.util.Base64;
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

    public ModeloProducto(String cod_producto, String nombre_producto, String unidad_medida, String cod_categoria, String descripcion, String nombre_categoria) {
        super(cod_producto, nombre_producto, unidad_medida, cod_categoria, descripcion, nombre_categoria);
    }

    public ModeloProducto(String cod_producto) {
        super(cod_producto);
    }

    public ModeloProducto(Image foto) {
        super(foto);
    }

  
  

    public boolean grabar() {
        //Trnasformar Imagen a base 64
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = imgBimage(getFoto());

            ImageIO.write(img, "PNG", bos);

            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String sql;
        sql = "INSERT INTO producto(cod_categoria,descripcion_ct,nombre_categoria,cod_producto, nombre, foto)";
        sql += "VALUES ( '" + getCod_categoria() + "','" + getDescripcion() + "','" + getNombre_categoria()+ "'," + getCod_producto() + " ,'" + getNombre_producto() + "','" + getUnidad_medida() + "','" + foto64 + "')";

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
        String foto64 = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            BufferedImage img = imgBimage(getFoto());

            ImageIO.write(img, "PNG", bos);

            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
//        
        String sql;
        sql = "UPDATE producto SET nombrepro='" + getCod_categoria() + "', descripcion='" + getDescripcion() + "',"
                + "precio=" + getNombre_categoria()+ ", categoria='" + getCod_producto() + "',foto='" + foto64 + "' " 
                + "WHERE codigopro='" + getCod_categoria() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminar() {
        String sql;
        sql = "DELETE FROM producto WHERE cod_producto = '" + getCod_categoria()+ "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Productos> ListarProducto(String aguja) {

        try {
            String query = " select * from producto where UPPER (codigopro) like UPPER('" + aguja + "%') or UPPER (nombrepro) like UPPER('" + aguja + "%') or UPPER (categoria) like UPPER ('" + aguja + "%')";
            ResultSet rs = con.query(query);
            List<Productos> lista = new ArrayList<Productos>();
            byte[] bf;
            while (rs.next()) {
                Productos producto = new Productos();
//                producto.setCodigo(rs.getString("codigopro"));
//                producto.setNombre(rs.getString("nombrepro"));
//                producto.setDescripcion(rs.getString("descripcion"));
//                producto.setPrecio(rs.getDouble("precio"));
//                producto.setCategoria(rs.getString("categoria"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);

                    try {
                        //obtener imagen
                        producto.setFoto(obterImagen(bf));
                    } catch (IOException ex) {
                        producto.setFoto(null);
                        Logger.getLogger(ModeloProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    producto.setFoto(null);
                }
                lista.add(producto);

            }
            rs.close();
            return lista;
        } catch (SQLException ex) {

            return null;
        }

    }

    public List<Productos> BuscarPersona() {
        try {
            String query = "SELECT * FROM producto WHERE codigopro='" + getCod_categoria() + "';";
            ResultSet rs = con.query(query);
            List<Productos> lista = new ArrayList<Productos>();

            while (rs.next()) {
                Productos producto = new Productos();
//                producto.setCodigo(rs.getString("codigopro"));
//                producto.setNombre(rs.getString("nombrepro"));
//                producto.setDescripcion(rs.getString("descripcion"));
//                producto.setPrecio(Double.parseDouble(rs.getString("precio")));
//                producto.setCategoria(rs.getString("categoria"));
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
