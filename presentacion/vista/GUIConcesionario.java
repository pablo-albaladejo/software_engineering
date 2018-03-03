
package concesionario.presentacion.vista;

import javax.swing.*;

public abstract class GUIConcesionario extends JFrame {
    
    static private GUIConcesionario instancia;
    
    public GUIConcesionario() {
    }
    
    static public GUIConcesionario getInstancia() {
        if ( instancia == null ) instancia = new GUIConcesionarioImp();
        return instancia;
    }
    
    abstract public void actualiza(int evento, Object datos);
}
