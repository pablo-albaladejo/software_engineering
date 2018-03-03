package com.concesionario.logica.transferencia.clientes;

public class TClienteNormal extends TCliente implements 
	InterfazTransferClienteNormal {

	private String 	apellidos;
	private int 	dni;
	
	public String getApellidos() {
		return this.apellidos;
	}

	public int getDNI() {
		return this.dni;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDNI(int dni) {
		this.dni = dni;
	}
}
