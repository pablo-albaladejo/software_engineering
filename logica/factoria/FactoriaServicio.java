package concesionario.logica.factoria;

import concesionario.logica.clientes.InterfazAppClientes;
import concesionario.logica.fachada.InterfazFachadaNegocio;
import concesionario.logica.pedidos.InterfazAppPedidos;
import concesionario.logica.productos.InterfazAppProductos;
import concesionario.logica.proveedores.InterfazAppProveedores;
import concesionario.logica.ventas.InterfazAppVentas;

public abstract class FactoriaServicio {
	static private FactoriaServicio instancia;
	static public FactoriaServicio getInstancia() {
		if ( instancia == null ) instancia = new FactoriaServicioImp();
		return instancia;
	}
	/**
	 * Obtiene la fachada del negocio y la devuelve
	 * @return Fachada de negocio
	 */
	abstract public InterfazFachadaNegocio dameFachadaNegocio();
	/**
	 * Obtiene el servicio de aplicación de clientes y lo devuelve
	 * @return Servicio de aplicación de clientes
	 */
	abstract public InterfazAppClientes dameServicioClientes();
	/**
	 * Obtiene el servicio de aplicación de productos y lo devuelve
	 * @return Servicio de aplicación de productos
	 */
	abstract public InterfazAppProductos dameServicioProductos();
	/**
	 * Obtiene el servicio de aplicación de proveedores y lo devuelve
	 * @return Servicio de aplicación de proveedores
	 */
	abstract public InterfazAppProveedores dameServicioProveedores();
	/**
	 * Obtiene el servicio de aplicación de ventas y lo devuelve
	 * @return Servicio de aplicación de ventas
	 */
	abstract public InterfazAppVentas dameServicioVentas();
	/**
	 * Obtiene el servicio de aplicación de pedidos y lo devuelve
	 * @return Servicio de aplicación de pedidos
	 */
	abstract public InterfazAppPedidos dameServicioPedidos();
}
