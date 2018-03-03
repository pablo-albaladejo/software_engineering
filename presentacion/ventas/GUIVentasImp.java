package concesionario.presentacion.ventas;


import concesionario.presentacion.controlador.EventoGUI;
import concesionario.presentacion.ventas.GUIAltaVenta;


public class GUIVentasImp extends GUIVentas {
	
	private GUIAltaVenta vistaAltaVentas;
	private GUIRespuesta vistaRespuesta;
	
	public GUIVentasImp() {
		vistaAltaVentas = new GUIAltaVenta();
		
		
	}

	@Override
	public void actualiza(int evento, Object datos) {
		 switch (evento) {
         case EventoGUI.GUI_ALTA_VENTA : 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_ALTA_VENTA, datos);
             break;
         case EventoGUI.GUI_BAJA_VENTA : 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_BAJA_VENTA, datos);
             break;
         case EventoGUI.GUI_MODIFICA_VENTA : 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_MODIFICA_VENTA, datos);
             break;
          
         case EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES: 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_MODIFICA_VENTA_RECUPERAR_DETALLES, datos);
             break;
         case EventoGUI.GUI_MUESTRA_DETALLES_VENTA : 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_MUESTRA_DETALLES_VENTA, datos);
             break;
         case EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES: 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_MUESTRA_VENTA_RECUPERAR_DETALLES, datos);
             break;
         case EventoGUI.GUI_MUESTRA_LISTADO_VENTAS: 
        	 vistaAltaVentas.actualiza(EventoGUI.GUI_MUESTRA_LISTADO_VENTAS, datos);
             break;
         case EventoGUI.GUI_MENSAJE_VENTA_RESPUESTA: 
        	 vistaRespuesta=new GUIRespuesta();
        	 vistaRespuesta.actualiza(evento,datos);
             break;
     }

	}

}