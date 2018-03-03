/**
 * 
 */
package concesionario.presentacion.ventas;


public abstract class GUIVentas{
    
    static private GUIVentas instancia;
    
    /** Creates a new instance of GUIVentas */
    public GUIVentas() {
    }
    
    static public GUIVentas getInstancia() {
        if ( instancia == null ) instancia = new GUIVentasImp();
        return instancia;
    }
    
    abstract public void actualiza(int evento, Object datos);
}