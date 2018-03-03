package com.concesionario.logica.transferencia.proveedores;

public interface InterfazTransferVinculo {
	public int getIdProveedor();
	public int getIdProducto();
	public int getPrecio();
	public void setIdProveedor(int idProveedor);
	public void setIdProducto(int idProducto);
	public void setPrecio(int precio);
}