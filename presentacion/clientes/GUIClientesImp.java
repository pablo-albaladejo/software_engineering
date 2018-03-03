/*
 * GUIClientesImp.java
 *
 * Created on 2 de abril de 2008, 1:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package concesionario.presentacion.clientes;

import javax.swing.JOptionPane;

import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;

/**
 *
 * @author Pablo
 */
public class GUIClientesImp extends GUIClientes{
    
    /** Creates a new instance of GUIClientesImp */
    public GUIClientesImp() {
    }
    
    public void actualiza(int evento, Object datos) {
        switch (evento) {
            case EventoGUI.GUI_ALTA_CLIENTE : case EventoGUI.GUI_ALTA_CLIENTE_EMPRESA :
            	GUIAltaCliente vistaAltaCliente = new GUIAltaCliente();
            	vistaAltaCliente.actualiza(evento, datos);
                break;
            case EventoGUI.GUI_BAJA_CLIENTE:
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id cliente.");
        			if ( valor != null) Controlador.getInstancia().accion(EventoNegocio.BAJA_CLIENTE, Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
        		}
                break;
            case EventoGUI.GUI_MODIFICA_CLIENTE :
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id cliente.");
            		if ( valor != null)Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_CLIENTE_MODIFICAR, Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
        		}
            	break;
            case EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE :
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id cliente.");
            		if ( valor != null)Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_CLIENTE, (int)Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. El valor introducido no es válido.");
        		}
        		break;
            case EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE_MODIFICAR_CORRECTO :
            	vistaAltaCliente = new GUIAltaCliente();
                vistaAltaCliente.actualiza(EventoGUI.GUI_MODIFICA_CLIENTE, datos);
                break;
            case EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE_CORRECTO :
        		vistaAltaCliente = new GUIAltaCliente();
                vistaAltaCliente.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_CLIENTE, datos);
            	break;
            case EventoGUI.GUI_LISTA_CLIENTES :
            	GUIListaClientes vistaListaClientes = new GUIListaClientes();
            	vistaListaClientes.actualiza(evento, datos);
            	break;
        }
    }
}
