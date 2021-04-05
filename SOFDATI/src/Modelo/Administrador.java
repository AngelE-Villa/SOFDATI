
package Modelo;

public class Administrador extends Persona{
    private String password;
    private String palabra;

    public Administrador(String password, String palabra, String cedula) {
        super(cedula);
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
    public Administrador() {
    }

    public Administrador(String codAdmin, String password, String palabra, String cedula) {
        super(cedula);
        this.password = password;
        this.palabra = palabra;
    }



   
        
}
