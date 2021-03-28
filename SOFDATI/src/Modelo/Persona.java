

package Modelo;

import java.util.Date;

/**
 *
 * @author Emilia
 */
public class Persona {
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fnacimiento;
    private String direccion;
    private String telefono;

    public Persona(){
        
    }
    
    public Persona(String cedula, String nombre, String apellido, Date fnacimineto, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fnacimiento = fnacimineto;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimineto) {
        this.fnacimiento = fnacimineto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
    
}

