package Modelo;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Empleado extends Persona{

    private String cod_empleado;
    private Double sueldo;
    private String cargo;
    private Image foto;
    private String password;
    private String palabra;

    public Empleado() {
    }

    public Empleado(String cedula) {
        super(cedula);
    }

    public Empleado(String cod_empleado, Double sueldo, String cargo, String password, String palabra, String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        super(cedula, nombre, apellido, fnacimineto, direccion, telefono);
        this.cod_empleado = cod_empleado;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.password = password;
        this.palabra = palabra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }



    public String getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(String cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }
    
    
        
}
