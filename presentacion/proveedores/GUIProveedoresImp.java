
package concesionario.presentacion.proveedores;

import javax.swing.JOptionPane;

import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;

public class GUIProveedoresImp extends GUIProveedores{
   
    public void actualiza(int evento, Object datos) {
        switch (evento) {
            case EventoGUI.GUI_ALTA_PROVEEDOR :
            	GUIAltaProveedor vistaAltaProveedor = new GUIAltaProveedor();
            	vistaAltaProveedor.actualiza(evento, datos);
                break;
            case EventoGUI.GUI_BAJA_PROVEEDOR:
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id Proveedor.");
            		if ( valor != null)Controlador.getInstancia().accion(EventoNegocio.BAJA_PROVEEDOR, Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
        		}
                break;
            case EventoGUI.GUI_MODIFICA_PROVEEDOR :
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id Proveedor.");
            		if ( valor != null)Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_PROVEEDOR_MODIFICAR, Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
        		}
            	break;
            case EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR :
            	try {
            		String valor = JOptionPane.showInputDialog("Inserta Id Proveedor.");
            		if ( valor != null)Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_PROVEEDOR, (int)Integer.valueOf(valor));
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. El valor introducido no es válido.");
        		}
        		break;
            case EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR_MODIFICAR_CORRECTO :
            	vistaAltaProveedor = new GUIAltaProveedor();
                vistaAltaProveedor.actualiza(EventoGUI.GUI_MODIFICA_PROVEEDOR, datos);
                break;
            case EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR_CORRECTO :
        		vistaAltaProveedor = new GUIAltaProveedor();
                vistaAltaProveedor.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PROVEEDOR, datos);
            	break;
            case EventoGUI.GUI_LISTA_PROVEEDORES :
            	GUIListaProveedores vistaListaProveedores = new GUIListaProveedores();
            	vistaListaProveedores.actualiza(evento, datos);
            	break;
            case EventoGUI.GUI_VINCULA_PROVEEDORES :
            	try {
            		String idProveedor = JOptionPane.showInputDialog("Inserta Id Proveedor.");
            		String idProducto = JOptionPane.showInputDialog("Inserta Id Producto.");
            		String precio = JOptionPane.showInputDialog("Inserta el precio del producto para este proveedor.");
            		if ( (idProveedor != null) && (idProducto != null) && (precio != null)){
            			InterfazTransferVinculo vinculo = FactoriaTransfers.getInstancia().dameTVinculo();
            			vinculo.setIdProveedor(Integer.valueOf(idProveedor));
            			vinculo.setIdProducto(Integer.valueOf(idProducto));
            			vinculo.setPrecio(Integer.valueOf(precio));
            			Controlador.getInstancia().accion(EventoNegocio.VINCULA_PROVEEDORES,vinculo);
            		}
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. El valor introducido no es válido.");
        		}
            	break;
            case EventoGUI.GUI_DESVINCULA_PROVEEDORES :
            	try {
            		String idProveedor = JOptionPane.showInputDialog("Inserta Id Proveedor.");
            		String idProducto = JOptionPane.showInputDialog("Inserta Id Producto.");
            		if ( (idProveedor != null) && (idProducto != null)){
            			InterfazTransferVinculo vinculo = FactoriaTransfers.getInstancia().dameTVinculo();
            			vinculo.setIdProveedor(Integer.valueOf(idProveedor));
            			vinculo.setIdProducto(Integer.valueOf(idProducto));
            			Controlador.getInstancia().accion(EventoNegocio.DESVINCULA_PROVEEDORES,vinculo);
            		}
        		} catch (Exception e) {
        			JOptionPane.showMessageDialog(null, "Tipos de datos incorrectos. El valor introducido no es válido.");
        		}
            	break;
        }
    }
}
