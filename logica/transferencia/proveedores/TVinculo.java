package com.concesionario.logica.transferencia.proveedores;

public class TVinculo implements InterfazTransferVinculo {
private int idProducto;
private int idProveedor;
private int precio = 0;
	
	public int getIdProducto() { 
		return this.idProducto;
	}

	public int getIdProveedor() {
		return this.idProveedor;
	}
	public int getPrecio(){
		return this.precio;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public void setPrecio(int precio){
		this.precio = precio;
	}

}
