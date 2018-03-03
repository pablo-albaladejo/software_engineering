package com.concesionario.logica.transferencia.proveedores;


import java.util.ArrayList;

import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;

public class TProveedor implements InterfazTransferProveedores {
	
	private int		identificador;
	private int 	cif;
	private String 	nombre;
	private String	direccion;
	private int		telefono;
	private String	email;
	private boolean activo = false;
	private ArrayList<InterfazTransferProductos> listaProductos;
	
	public String getDireccion() {
		return this.direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIdentificador(int id) {
		this.identificador = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCIF() {
		return this.cif;
	}

	public void setCIF(int cif) {
		this.cif = cif;
	}

	public ArrayList<InterfazTransferProductos> getListaProductos() {
		return this.listaProductos;
	}

	public void setListaProductos(ArrayList<InterfazTransferProductos> lista) {
		this.listaProductos = lista;
	}
}
