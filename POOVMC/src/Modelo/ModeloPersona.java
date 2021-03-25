package Modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
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

public class ModeloPersona extends Persona {

    private static ConexionPG con = new ConexionPG();

    public ModeloPersona() {
    }

    public ModeloPersona(String idpersona, String nombres, String apellidos, Date fnacimiento, String telefono, String sexo, double sueldo, int cupo) {
        super(idpersona, nombres, apellidos, fnacimiento, telefono, sexo, sueldo, cupo);
    }

    public ModeloPersona(String idpersona) {
        super(idpersona);
    }

    
    public boolean ValidarId() throws SQLException {
        String query = "SELECT idpersona FROM persona WHERE idpersona='" + getIdpersona() + "';";
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

    public boolean Grabar() {

        String sql;
        sql = "INSERT INTO persona (idpersona,nombres,apellidos,fechanacimiento,telefono,sexo,sueldo,cupo, foto)";
        sql += "VALUES ('" + getIdpersona() + "','" + getNombres() + "','" + getApellidos() + "','" + getFnacimiento() + "',"
                + "'" + getTelefono() + "','" + getSexo() + "','" + getSueldo() + "','" + getCupo() + "','" + foto64() + "')";
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

    public boolean Editar() {
        String sql;
        sql = "UPDATE persona SET nombres='" + getNombres() + "', apellidos='" + getApellidos() + "',"
                + "fechanacimiento='" + getFnacimiento() + "', telefono='" + getTelefono() + "',"
                + "sexo='" + getSexo() + "',sueldo=" + getSueldo() + ", cupo=" + getCupo() + " , foto='" + foto64() + "'"
                + "WHERE idpersona='" + getIdpersona() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean Eliminar() {
        String sql;
        sql = "DELETE FROM persona  WHERE idpersona='" + getIdpersona() + "';";
        if (con.noQuery(sql) == null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<Persona> ListarPersonas(String buscar) {

        try {
            String query = "SELECT * FROM persona WHERE UPPER(idpersona) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(nombres) LIKE UPPER('" + buscar + "%') OR UPPER(apellidos) LIKE UPPER('" + buscar + "%') "
                    + "OR UPPER(telefono) LIKE UPPER('" + buscar + "%')OR UPPER(sexo) LIKE UPPER('" + buscar + "%')";
            ResultSet rs = con.query(query);
            List<Persona> lista = new ArrayList<Persona>();
            byte[] bf;

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getString("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setFnacimiento(rs.getDate("fechanacimiento"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(Double.parseDouble(rs.getString("sueldo")));
                persona.setCupo(Integer.parseInt(rs.getString("cupo")));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        persona.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<Persona> BuscarPersona(String id) {
        try {
            String query = "SELECT * FROM persona WHERE idpersona='" + id + "';";
            ResultSet rs = con.query(query);
            List<Persona> lista = new ArrayList<Persona>();
            byte[] bf;

            while (rs.next()) {
                Persona persona = new Persona();
                persona.setIdpersona(rs.getString("idpersona"));
                persona.setNombres(rs.getString("nombres"));
                persona.setApellidos(rs.getString("apellidos"));
                persona.setFnacimiento(rs.getDate("fechanacimiento"));
                persona.setTelefono(rs.getString("telefono"));
                persona.setSexo(rs.getString("sexo"));
                persona.setSueldo(Double.parseDouble(rs.getString("sueldo")));
                persona.setCupo(Integer.parseInt(rs.getString("cupo")));
                bf = rs.getBytes("foto");

                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        //OBTENER IMAGEN
                        persona.setFoto(ObtenImagen(bf));
                    } catch (IOException ex) {
                        persona.setFoto(null);
                        Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    persona.setFoto(null);
                }
                lista.add(persona);
            }
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ModeloPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
