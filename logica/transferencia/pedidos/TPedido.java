package com.concesionario.logica.transferencia.pedidos;

import java.util.ArrayList;

import com.concesionario.logica.transferencia.factoria.FactoriaTransfers;
import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public class TPedido implements InterfazTransferPedidos {
	private int identificador;
	private ArrayList<InterfazTransferElementoPedido> listaElementos;
	private int idproveedor;
	private int unidades=0;
	private float importeT=0;
	private boolean activo;
	
	public TPedido(){
		listaElementos = new ArrayList<InterfazTransferElementoPedido>();
	}
	
	public void setIdentificador(int id){
		this.identificador = id;
	}
	
	public int getIdentificador(){
		return this.identificador;
	}
	
	public void addElementoPedido(InterfazTransferProductos producto, int num, float precio){
		/*
		 * se podría considerar que se compruebe si el producto ya está en la lista.
		 * Vamos a permitir que pueda insertar varias peticiones del mismo producto
		 * ya que no afectará en el resultado final. Solo aumentará el tamaño de la lista.
		 */
		InterfazTransferElementoPedido elem = FactoriaTransfers.getInstancia().dameTElementoPedido();
		elem.setProducto(producto);
		elem.setNumProductos(num);
		elem.setPrecio(precio);
		this.unidades+=num;
		this.importeT += precio*num;
		this.listaElementos.add(elem);
	}
	public InterfazTransferProductos getProducto(int elem){
		if ( elem < 0 || elem >= this.listaElementos.size() )
			return null;
		else 
			return this.listaElementos.get(elem).getProducto();
	}
	public int getNumProductos(int elem){
		if ( elem < 0 || elem >= this.listaElementos.size() )
			return -1;
		else 
			return this.listaElementos.get(elem).getNumProductos();
	}
	public float getPrecioProducto(int elem){
		if ( elem < 0 || elem >= this.listaElementos.size() )
			return -1;
		else 
			return this.listaElementos.get(elem).getPrecio();
	}
	public void setProveedor(int idproveedor){
		this.idproveedor=idproveedor;
	}
	public int getProveedor(){
		return this.idproveedor;
	}

	public float getTotal() {
		return this.importeT;
	}

	public int getNumElems() {
		return listaElementos.size();
	}

	public boolean setPrecio(float precio, int indice) {
		InterfazTransferElementoPedido elem;
		if ( indice < 0 || indice >= this.listaElementos.size() )
			return false;
		else {
			elem = this.listaElementos.get(indice);
			this.importeT -= elem.getPrecio()*elem.getNumProductos();
			this.importeT += precio*elem.getNumProductos();
			elem.setPrecio(precio);
			return true;
		}
	}

	public int getUnidades() {
		return this.unidades;
	}

	public boolean esActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}

