package concesionario.presentacion.main;

import concesionario.presentacion.controlador.Controlador;
import concesionario.presentacion.controlador.EventoNegocio;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controlador.getInstancia().accion(EventoNegocio.INICIA_APLICACION, null);
	}

}
