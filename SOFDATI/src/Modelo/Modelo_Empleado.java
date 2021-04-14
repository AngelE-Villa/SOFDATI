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
public class Modelo_Empleado extends Empleado {
    
    private static ConexionBADA con = new ConexionBADA();

    public Modelo_Empleado() {
    }

    public Modelo_Empleado(String cedula) {
        super(cedula);
    }
    
    
    public Modelo_Empleado(String cod_empleado, Double sueldo, String cargo, String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        super(cod_empleado, sueldo, cargo,cedula, nombre, apellido, fnacimineto, direccion, telefono);
    }
    
    public int NEmpleados(){
        String query = "select max(cod_empleado) as num from cliente";
        ResultSet rs = con.query(query);
        try {
            while (rs.next()) {
                return rs.getInt("num");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
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
    
    public boolean Grabar_Empleado() {
        String sql;
        sql = "INSERT INTO persona (nombre,cedula,apellido,telefono, fechanacimiento, direccion) "
                + "VALUES ('" + getNombre() + "','" + getCedula() + "','" + getApellido() + "','" + getTelefono()+ "',"
                + "'" + getFnacimiento()+ "','" + getDireccion()+ "');";
        sql += "INSERT INTO empleado (cod_empleado,foto,cargo,sueldo,cedula_pe) "
                + "VALUES ('" + getCod_empleado()+ "','" + foto64() + "','" + getCargo()+ "'," + getSueldo() + ",'" + getCedula() + "');";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean Editar_Empleado() {
        String sql;
        sql = "UPDATE persona SET nombre='" + getNombre()+ "',apellido='" + getApellido()+ "', telefono='" + getTelefono()+ "',fechanacimiento='" + getFnacimiento()
                + "',direccion='"+ getDireccion()+ "'";
        sql += "WHERE cedula='" + getCedula()+ "';";
        sql += "UPDATE empleado SET foto='" + foto64() + "',cargo='" + getCargo()+ "', sueldo=" + getSueldo() + "";
        sql += "WHERE cedula_pe='" + getCedula()+ "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean Eliminar_Empleado() {
        String sql;
        sql = "DELETE FROM empleado WHERE cedula_pe='" + getCedula()+ "'";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public static List<Empleado> Lista_Empleados(String busqueda) {
        try {
            String query = "select e.cod_empleado,e.foto,e.cargo,e.sueldo,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono" +
            " from empleado e join persona p on p.cedula=e.cedula_pe where ";
            query += "UPPER(p.nombre) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(p.apellido) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(p.cedula) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(e.cod_empleado) LIKE UPPER('%" + busqueda + "%') OR ";
            query += "UPPER(e.cargo) LIKE UPPER('%" + busqueda + "%')";
            ResultSet rs = con.query(query);
            List<Empleado> lista = new ArrayList<Empleado>();
            byte[] bf;
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setCod_empleado(rs.getString("cod_empleado"));
                e.setCedula(rs.getString("cedula"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setFnacimiento(rs.getDate("fechanacimiento"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));
                e.setCargo(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        e.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        e.setFoto(null);
                        Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    e.setFoto(null);
                }
                lista.add(e);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public List<Empleado> BuscarporID(String id) {
        try {
            String query = "select e.cod_empleado,e.foto,e.cargo,e.sueldo,p.cedula,p.nombre,p.apellido,p.fechanacimiento,p.direccion,p.telefono" +
            " from empleado e join persona p on p.cedula=e.cedula_pe where ";
            query += "UPPER(e.cod_empleado) LIKE UPPER('%" + id + "%')";
            ResultSet rs = con.query(query);
            List<Empleado> lista = new ArrayList<Empleado>();
            byte[] bf;
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setCod_empleado(rs.getString("cod_empleado"));
                e.setCedula(rs.getString("cedula"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setFnacimiento(rs.getDate("fechanacimiento"));
                e.setDireccion(rs.getString("direccion"));
                e.setTelefono(rs.getString("telefono"));
                e.setCargo(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        e.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        e.setFoto(null);
                        Logger.getLogger(Modelo_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    e.setFoto(null);
                }
                lista.add(e);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
