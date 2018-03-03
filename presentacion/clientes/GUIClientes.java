/*
 * GUIClientes.java
 *
 * Created on 2 de abril de 2008, 1:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package concesionario.presentacion.clientes;

/**
 *
 * @author Pablo
 */
public abstract class GUIClientes {
    
    static private GUIClientes instancia;
    
    /** Creates a new instance of GUIClientes */
    public GUIClientes() {
    }
    
    static public GUIClientes getInstancia() {
        if ( instancia == null ) instancia = new GUIClientesImp();
        return instancia;
    }
    
    abstract public void actualiza(int evento, Object datos);
}
