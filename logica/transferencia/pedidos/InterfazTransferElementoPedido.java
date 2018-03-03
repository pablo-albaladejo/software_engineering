package com.concesionario.logica.transferencia.pedidos;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public interface InterfazTransferElementoPedido {
	public InterfazTransferProductos getProducto();
	public int getNumProductos();
	public void setNumProductos(int num);
	public void setProducto(InterfazTransferProductos producto);
	public void setPrecio(float precio);
	public float getPrecio();
}