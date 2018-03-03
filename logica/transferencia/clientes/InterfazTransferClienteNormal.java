package com.concesionario.logica.transferencia.clientes;

public interface InterfazTransferClienteNormal extends InterfazTransferClientes {
	/**
	 * Modifica los apellidos de un cliente. Ambos apellidos se pasan como un solo
	 * parametro
	 * @param apellidos los nuevos apellidos
	 */
	public void setApellidos(String apellidos);
	
	/**
	 * Devuelve los apellidos del cliente
	 * @return Una cadena con los dos apellidos
	 */
	public String getApellidos();
	
	/**
	 * Modifica el dni asignado a un cliente
	 * @param dni el dni
	 */
	public void setDNI(int dni);
	
	/**
	 * Devuelve el valor del dni asignado al cliente, como un entero
	 * @return el dni
	 */
	public int getDNI();
}