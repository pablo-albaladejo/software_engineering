package com.concesionario.logica.transferencia.clientes;

public interface InterfazTransferClientes {
	/**
	 * 
	 * @param id
	 */
	public void setIdentificador(int id);
	public int getIdentificador();
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
}