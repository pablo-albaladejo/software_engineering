package concesionario.integracion.factoria;

import concesionario.integracion.clientes.InterfazDAOClientes;
import concesionario.integracion.pedidos.InterfazDAOPedidos;
import concesionario.integracion.productos.InterfazDAOProductos;
import concesionario.integracion.proveedores.InterfazDAOProveedores;
import concesionario.integracion.ventas.InterfazDAOVentas;

public abstract class FactoriaDAO {
	static private FactoriaDAO instancia;
	static public FactoriaDAO getInstancia() {
		if ( instancia == null ) instancia = new FactoriaDAOImp();
		return instancia;
	}
	/**
	 * Obtiene el DAO de clientes y lo devuelve
	 * @return DAO de clientes
	 */
	abstract public InterfazDAOClientes dameDAOClientes();
	/** Obtiene el DAO de productos y lo devuelve
	 * @return DAO de productos
	 */
	abstract public InterfazDAOProductos dameDAOProductos();
	/**
	 * Obtiene el DAO de proveedores y lo devuelve
	 * @return DAO de proveedores
	 */
	abstract public InterfazDAOProveedores dameDAOProveedores();
	/**
	 * Obtiene el DAO de ventas y lo devuelve
	 * @return DAO de ventas
	 */
	abstract public InterfazDAOVentas dameDAOVentas();
	/**
	 * Obtiene el DAO de pedidos y lo devuelve
	 * @return DAO de pedidos
	 */
	abstract public InterfazDAOPedidos dameDAOPedidos();
	
}