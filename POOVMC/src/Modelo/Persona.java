package Modelo;

import java.awt.Image;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Persona {

    /**
     * @param edad the edad to set
     */
    private String idpersona;
    private String nombres;
    private String apellidos;
    private Date fnacimiento;
    private String telefono;
    private String sexo;
    private double sueldo;
    private int cupo;
    private int edad;
    private Image foto;

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona() {
    }

    public Persona(String idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(double sueldo) {
        this.sueldo = sueldo;
    }

    public Persona(int cupo) {
        this.cupo = cupo;
    }

    public int getEdad() {
        if (fnacimiento != null) {
            edad = Period.between(getFnacimiento().toLocalDate(), LocalDate.now()).getYears();
            return edad;
        }
        return 0;
    }

    public Persona(String idpersona, String nombres, String apellidos, String telefono, String sexo) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public Persona(String idpersona, String nombres, String apellidos, Date fnacimiento, String telefono, String sexo, double sueldo, int cupo) {
        this.idpersona = idpersona;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fnacimiento = fnacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.sueldo = sueldo;
        this.cupo = cupo;
    }

    public int getCupo() {
        return cupo;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
