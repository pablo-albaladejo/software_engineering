package com.concesionario.logica.transferencia.pedidos;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public interface InterfazTransferPedidos {
	/**
	 * Establece el identificador �nico del pedido.
	 * @param id Identificadior del pedido.
	 */
	public void setIdentificador(int id);
	/** Devuelve el identificador �nico del pedido.
	 * @return Identificador de pedido.
	 */
	public int getIdentificador();
	/**
	 * A�ade un producto a la lista del pedido con el n�mero de productos para ese pedido y su valor por unidad.
	 * recalcula el importe del pedido.
	 * @param producto Producto a insertar en la lista.
	 * @param num N�mero de productos solicitados.
	 * @param precio Importe por unidad de producto.
	 */
	public void addElementoPedido(InterfazTransferProductos producto, int num, float precio);
	/**
	 * Devuelve el producto solicitado de la lista de productos del pedido.
	 * @param elem Indice del producto solicitado (0 a size()-1).
	 * @return Devuelve el producto solicitado de la lista del pedido seg�n el indice indicado. Si el indice est� fuera de rango devolver� null.
	 */
	public InterfazTransferProductos getProducto(int elem);
	/**
	 * Funci�n que devuelve el n�mero de unidades solicitadas de un producto.
	 * @param elem Indice del producto en la lista de pedido (0 a size()-1).
	 * @return N�mero de elementos solicitado.
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
	 * Funci�n que devuelve el identificador �nico del proveedor al que se solicita el pedido.
	 * @return Identifcador del proveedor.
	 */
	public int getProveedor();
	/**
	 * Funci�n que devuelve el importe total del pedido.
	 * @return Importe total.
	 */
	public float getTotal();
	/**
	 * Funci�n que devuelve el n�mero de elementos en la lista de pedidos.
	 * @return N�mero de elementos.
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
	 * Devuelve el n�mero de unidades totales del pedido
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
