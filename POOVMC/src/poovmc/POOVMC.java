package poovmc;

import Controlador.ControlPrincipal;
import Vista.Principal;

public class POOVMC {

    public static void main(String[] args) {
        Principal p=new Principal();
        ControlPrincipal cp=new ControlPrincipal(p);        
        cp.IniciarControl();
    }
    
}
