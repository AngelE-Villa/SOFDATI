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
import java.util.Date;
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
public class ModeloVehiculo extends Vehiculo {

    //Atributos
    private static ConexionBADA con = new ConexionBADA();

    //Constructor
    public ModeloVehiculo() {
    }

    //Metodos
    public ModeloVehiculo(String matricula) {
        super(matricula);
    }

    public ModeloVehiculo(String matricula, String pais, String color, Date fecha_matricula) {
        super(matricula, pais, color, fecha_matricula);
    }

    public String foto64() {
        String foto64 = null;
        //Transformar imgagen a base64 para postgresql
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            BufferedImage img = imgImage(getFoto());
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
            return foto64;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
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

    public boolean grabar() {
        String sql;
        sql = "INSERT INTO vehiculo (matricula,pais,color,fecha_matricula,estado)";
        sql += "VALUES('" + getMatricula() + "','" + getPais() + "','" + getColor() + "','" + getFecha_matricula() + "'," + 1 + ")";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
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

    public static List<Vehiculo> ListarVehiculo(String aguja) {
        try {
            String query = "Select * from vehiculo WHERE "
                    + "UPPER(matricula) LIKE '" + aguja + "%' AND estado=1 OR "
                    + "UPPER(color) LIKE '" + aguja + "%' AND estado=1";
            ResultSet rs = con.query(query);
            List<Vehiculo> lista = new ArrayList<Vehiculo>();
            byte[] bf;
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString("matricula"));
                vehiculo.setPais(rs.getString("pais"));
                vehiculo.setColor(rs.getString("Color"));
                vehiculo.setFecha_matricula(rs.getDate("fecha_matricula"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        vehiculo.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        vehiculo.setFoto(null);
                        Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    vehiculo.setFoto(null);
                }
                lista.add(vehiculo);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Vehiculo> BuscarVehiculo(String aguja) {
        try {
            String query = "SELECT * FROM vehiculo WHERE matricula ='" + aguja + "' AND estado=1";
            ResultSet rs = con.query(query);
            List<Vehiculo> lista = new ArrayList<Vehiculo>();

            byte[] bf;
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setMatricula(rs.getString("matricula"));
                vehiculo.setPais(rs.getString("pais"));
                vehiculo.setColor(rs.getString("Color"));
                vehiculo.setFecha_matricula(rs.getDate("fecha_matricula"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        vehiculo.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        vehiculo.setFoto(null);
                        Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    vehiculo.setFoto(null);
                }

                lista.add(vehiculo);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloVehiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean editar() {

        String sql;
        sql = "UPDATE vehiculo SET pais=" + getPais() + ", color=" + getColor() + ","
                + "fecha_matricula='" + getFecha_matricula() + "',estado=" + 1 + " "
                + "WHERE matricula='" + getMatricula() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean eliminar() {
        String sql;
        sql = "UPDATE vehiculo SET estado=0 WHERE matricula='" + getMatricula() + "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

}
