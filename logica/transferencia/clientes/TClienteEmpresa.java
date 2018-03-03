package com.concesionario.logica.transferencia.clientes;

public class TClienteEmpresa extends TCliente implements 
	InterfazTransferClienteEmpresa {

	private int		descuento = 0;
	private int 	cif;
	
	public int getCIF() {
		return this.cif;
	}

	public void setCIF(int cif) {
		this.cif = cif;
	}

	public int getDescuento() {
		return this.descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
}
