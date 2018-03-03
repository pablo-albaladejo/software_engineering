
package concesionario.presentacion.proveedores;

public abstract class GUIProveedores {
    
    static private GUIProveedores instancia;
    
    static public GUIProveedores getInstancia() {
        if ( instancia == null ) instancia = new GUIProveedoresImp();
        return instancia;
    }
    
    abstract public void actualiza(int evento, Object datos);
}
