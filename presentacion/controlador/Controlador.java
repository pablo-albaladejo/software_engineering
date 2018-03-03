
package concesionario.presentacion.controlador;

public abstract class Controlador {
    
    static private Controlador instancia;

    public Controlador() {
    }
    
    static public Controlador getInstancia() {
        if ( instancia == null ) instancia = new ControladorImp();
        return instancia;
    }
    
    abstract public void accion(int evento, Object datos);
}
