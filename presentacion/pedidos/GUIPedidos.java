/**
 * 
 */
package concesionario.presentacion.pedidos;

/**
 * @author carlos
 *
 */
public abstract class GUIPedidos{
    
    static private GUIPedidos instancia;
    
    /** Creates a new instance of GUIVentas */
    public GUIPedidos() {
    }
    
    static public GUIPedidos getInstancia() {
        if ( instancia == null ) instancia = new GUIPedidosImp();
        return instancia;
    }
    
    abstract public void actualiza(int evento, Object datos);
}