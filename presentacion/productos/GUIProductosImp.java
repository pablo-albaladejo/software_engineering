package concesionario.presentacion.productos;

import javax.swing.JOptionPane;

import concesionario.presentacion.controlador.*;

public class GUIProductosImp extends GUIProductos {

	
	private GUIAltaProducto vistaAltaProducto;
	private GUIListaProductos vistaListaProducto;
	
	public GUIProductosImp(){
		
	}
	@Override
	public void actualiza(int evento, Object datos) {
		switch(evento){
		case EventoGUI.GUI_ALTA_PRODUCTO_TURISMO: case EventoGUI.GUI_ALTA_PRODUCTO_MOTO: case EventoGUI.GUI_ALTA_PRODUCTO_COMERCIAL:
			vistaAltaProducto=new GUIAltaProducto();
			vistaAltaProducto.actualiza(evento, datos);
			break;
		
		case EventoGUI.GUI_BAJA_PRODUCTO:
			try{
				String valor=JOptionPane.showInputDialog("Inserta id producto.");
				Controlador.getInstancia().accion(EventoNegocio.BAJA_PRODUCTO, Integer.valueOf(valor));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
			}
			break;
		case EventoGUI.GUI_MODIFICA_PRODUCTO:
			try{
				String valor=JOptionPane.showInputDialog("Inserta id producto.");
				Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_PRODUCTO_MODIFICAR, Integer.valueOf(valor));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
			}
			break;
		case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO:
			try{
				String valor=JOptionPane.showInputDialog("Inserta id producto.");
				Controlador.getInstancia().accion(EventoNegocio.MUESTRA_DETALLES_PRODUCTO, Integer.valueOf(valor));
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
			}
			break;
		case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_MODIFICAR_CORRECTO :
        	vistaAltaProducto = new GUIAltaProducto();
            vistaAltaProducto.actualiza(EventoGUI.GUI_MODIFICA_PRODUCTO, datos);
            break;
        case EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO :
    		vistaAltaProducto = new GUIAltaProducto();
            vistaAltaProducto.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_PRODUCTO_CORRECTO, datos);
        	break;	
		case EventoGUI.GUI_LISTA_PRODUCTOS:
			vistaListaProducto=new GUIListaProductos();
			vistaListaProducto.actualiza(evento,datos);
			break;
		}

	}

}
