package concesionario.presentacion.pedidos;

import javax.swing.JOptionPane;
import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.controlador.EventoNegocio;

public class GUIPedidosImp extends GUIPedidos {
	
	public GUIPedidosImp() {
	}

	@Override
	public void actualiza(int evento, Object datos) {
		 switch (evento) {
         case EventoGUI.GUI_ALTA_PEDIDO_COMPROBAR : 
        	try {
         		String valor = JOptionPane.showInputDialog("Inserta Id del proveedor.");
      			if ( valor != null) Controlador.getInstancia().accion(EventoNegocio.COMPRUEBA_PROVEEDOR_ALTA, Integer.valueOf(valor));
      		} catch (Exception e) {
      			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
      		}
             break;
         case EventoGUI.GUI_ALTA_PEDIDO :
        	 GUIAltaPedido vistaAltaPedidos = new GUIAltaPedido();
 	   		vistaAltaPedidos.actualiza(evento, datos);
        	 break;
         case EventoGUI.GUI_ANULAR_PEDIDO : 
        	 try {
        		String valor2 = JOptionPane.showInputDialog("Inserta Id del pedido.");
     			if ( valor2 != null) Controlador.getInstancia().accion(EventoNegocio.ANULAR_PEDIDO, Integer.valueOf(valor2));
     		} catch (Exception e) {
     			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
     		}
             break;
         case EventoGUI.GUI_RECIBIR_PEDIDO : 
        	 try {
         		String valor3 = JOptionPane.showInputDialog("Inserta Id del pedido.");
      			if ( valor3 != null) Controlador.getInstancia().accion(EventoNegocio.RECIBIR_PEDIDO, Integer.valueOf(valor3));
      		} catch (Exception e) {
      			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
      		}
             break;
         case EventoGUI.GUI_MOSTRAR_PEDIDOS :
        	 try {
          		String valor4 = JOptionPane.showInputDialog("Inserta Id del pedido.");
       			if ( valor4 != null) Controlador.getInstancia().accion(EventoNegocio.MOSTRAR_PEDIDOS, Integer.valueOf(valor4));
       		} catch (Exception e) {
       			JOptionPane.showMessageDialog(null, "El id introducido es erróneo.");
       		}
              break;
         case EventoGUI.GUI_MOSTRAR_DETALLES_PEDIDO :
        	 GUIAltaPedido vistaDetallesPedido = new GUIAltaPedido();
        	 vistaDetallesPedido.actualiza(evento, datos);
        	 break;
         case EventoGUI.GUI_LISTAR_PEDIDOS : 
        	 GUIAltaPedido vistaListaPedidos = new GUIAltaPedido();
        	 vistaListaPedidos.actualiza(evento, datos);
             break;
         case EventoGUI.GUI_LISTAR_STOCK :
    		 GUIAltaPedido vistaListaStock = new GUIAltaPedido();
    		 vistaListaStock.actualiza(evento, datos);
    		 break;
		 }
	}

}