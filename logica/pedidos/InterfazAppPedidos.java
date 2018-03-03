package concesionario.logica.pedidos;

import java.util.ArrayList;

import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;

public interface InterfazAppPedidos {
	
	/**
	 * Función que realiza un pedido. 
	 * Debe de comprobar que cada id de producto recibido corresponde con un producto dado de alta y vinculado al proveedor.
	 * @param pedido Pedido soilicitado.
	 * @return Devolverá un transfer respuesta con el identificador del pedido y una lista de los posibles errores del pedido o exito del mismo.
	 * 			
	 */
	public InterfazTransferRespuesta realizarPedido(InterfazTransferPedidos pedido);
	/**
	 * Función que anula un pedido.
	 * @param pedido Identificador del pedido a anular.
	 * @return Devuelve 1 si anulado con éxito, 0 si no existe el pedido o -1 en caso de error.
	 */
	public int anularPedido(int pedido);
	/**
	 * Función que realiza la operación lógica de recibir pedido, actualizando los stock de cada producto.
	 * @param pedido Identificador del pedido a recibir.
	 * @return Devuelve identificador de pedido en caso de pedido recibido, 0 en caso de no existir o -1 en caso de error.
	 */
	public int recibirPedido(int pedido);
	/**
	 * Función que devuelve la lista de pedidos pendientes.
	 * @return Lista de pedidos.
	 */
	public ArrayList<InterfazTransferPedidos> listarPedidos();
	/**
	 * Función que muestra los detalles de un pedido concreto.
	 * @param pedido Identificador del pedido.
	 * @return Pedido solicitado.
	 */
	public InterfazTransferPedidos mostrarPedido(int pedido);
	/**
	 * Función que lista el stock de los productos con un stock bajo.
	 * @return Devuelve una lista con los productos cuyo stock es menor que 5.
	 */
	public ArrayList<InterfazTransferProductos> listarStock();
	public int buscaProducto(int id);
}
