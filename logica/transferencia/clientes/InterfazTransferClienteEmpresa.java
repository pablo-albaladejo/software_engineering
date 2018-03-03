package com.concesionario.logica.transferencia.clientes;

public interface InterfazTransferClienteEmpresa extends InterfazTransferClientes {
	/**
	 * Actualiza el descuento en un cliente empresa
	 * @param descuento
	 */
	public void setDescuento(int descuento);
	
	/**
	 * Devuelve el descuento que se le es aplicado a una empresa
	 * @return descuento
	 */
	public int getDescuento();
	
	/**
	 * Modifica el cif de una empresa
	 * @param cif Nuevo  cif asignado a la empresa
	 */
	public void setCIF(int cif);
	
	/**
	 * Acceso al cif asignado a esa empresa
	 * @return el cif
	 */
	public int getCIF();
}