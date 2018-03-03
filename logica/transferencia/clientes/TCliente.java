package com.concesionario.logica.transferencia.clientes;

public class TCliente implements InterfazTransferClientes {
	
	private int		identificador;
	private String 	nombre;
	private String	direccion;
	private int		telefono;
	private String	email;
	private boolean activo = false;
	
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
}
