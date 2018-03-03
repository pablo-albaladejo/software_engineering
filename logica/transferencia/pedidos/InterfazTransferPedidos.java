package com.concesionario.logica.transferencia.pedidos;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public interface InterfazTransferPedidos {
	/**
	 * Establece el identificador único del pedido.
	 * @param id Identificadior del pedido.
	 */
	public void setIdentificador(int id);
	/** Devuelve el identificador único del pedido.
	 * @return Identificador de pedido.
	 */
	public int getIdentificador();
	/**
	 * Añade un producto a la lista del pedido con el número de productos para ese pedido y su valor por unidad.
	 * recalcula el importe del pedido.
	 * @param producto Producto a insertar en la lista.
	 * @param num Número de productos solicitados.
	 * @param precio Importe por unidad de producto.
	 */
	public void addElementoPedido(InterfazTransferProductos producto, int num, float precio);
	/**
	 * Devuelve el producto solicitado de la lista de productos del pedido.
	 * @param elem Indice del producto solicitado (0 a size()-1).
	 * @return Devuelve el producto solicitado de la lista del pedido según el indice indicado. Si el indice está fuera de rango devolverá null.
	 */
	public InterfazTransferProductos getProducto(int elem);
	/**
	 * Función que devuelve el número de unidades solicitadas de un producto.
	 * @param elem Indice del producto en la lista de pedido (0 a size()-1).
	 * @return Número de elementos solicitado.
	 */
	public int getNumProductos(int elem);
	/**
	 * Devuelve el precio por unidad de un producto.
	 * @param elem Indice del prodcuto en la lista de pedido (0 a size()-1).
	 * @return Precio del producto.
	 */
	public float getPrecioProducto(int elem);
	/**
	 * Funcion para ingresar el identificador del proveedor al que se solicita el pedido.
	 * @param idproveedor Identificador del proveedor.
	 */
	public void setProveedor(int idproveedor);
	/**
	 * Función que devuelve el identificador único del proveedor al que se solicita el pedido.
	 * @return Identifcador del proveedor.
	 */
	public int getProveedor();
	/**
	 * Función que devuelve el importe total del pedido.
	 * @return Importe total.
	 */
	public float getTotal();
	/**
	 * Función que devuelve el número de elementos en la lista de pedidos.
	 * @return Número de elementos.
	 */
	public int getNumElems();
	/**
	 * Modifica el precio de un elemento del pedido y recalcula el impote del pedido.
	 * @param precio
	 * @param elem indice del elemento
	 * @return Devuelve true en caso de exito o false en caso de fuera de rango
	 */
	public boolean setPrecio(float precio, int indice);
	/**
	 * Devuelve el número de unidades totales del pedido
	 * @return Unidades totales
	 */
	public int getUnidades();
	/**
	 * Devuelve si el pedido actual esta pendiente, true o eliminado, false;
	 * @return
	 */
	public boolean esActivo();
	/**
	 * Establece si el pedido esta activo o no
	 * @param activo
	 */
	public void setActivo(boolean activo);
}
