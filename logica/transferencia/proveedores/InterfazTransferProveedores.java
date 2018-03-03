package com.concesionario.logica.transferencia.proveedores;

import java.util.ArrayList;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public interface InterfazTransferProveedores {
	public void setIdentificador(int id);
	public int getIdentificador();
	public void setCIF(int cif);
	public int getCIF();
	public void setNombre(String nombre);
	public String getNombre();
	public void setDireccion(String direccion);
	public String getDireccion();
	public void setTelefono(int telefono);
	public int getTelefono();
	public void setEmail(String email);
	public String getEmail();
	public void setActivo(boolean activo);
	public boolean getActivo();
	public void setListaProductos(ArrayList<InterfazTransferProductos> listaProductos);
	public ArrayList<InterfazTransferProductos> getListaProductos();
}