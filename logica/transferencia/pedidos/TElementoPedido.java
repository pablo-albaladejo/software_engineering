package com.concesionario.logica.transferencia.pedidos;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public class TElementoPedido implements InterfazTransferElementoPedido {
private InterfazTransferProductos producto;
private int numProductos;
private float precioU=0;
	
	public InterfazTransferProductos getProducto() { 
		return this.producto;
	}

	public int getNumProductos() {
		return this.numProductos;
	}

	public void setProducto(InterfazTransferProductos producto) {
		this.producto = producto;
	}

	public void setNumProductos(int num) {
		this.numProductos = num;
	}
	
	public void setPrecio(float precio) {
		this.precioU = precio;
	}

	public float getPrecio(){
		return this.precioU;
	}
}
