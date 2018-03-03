package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferMotos extends InterfazTransferProductos{
	/**
	 * Establece el tipo de motocicleta del producto tipo moto. Posibles valores: Scooter, deportiva, trial...
	 * @param tipo Tipo de motocicleta
	 */
	public void setTipo(String tipo);
	/**
	 * Recupera el tipo de motocicleta del procuto tipo moto
	 * @return Tipo de motocicleta
	 */
	public String getTipo();
	/**
	 * Establece el tipo de arranque del producto tipo moto
	 * @param arranque Tipo de arranque
	 */
	public void setArranque(String arranque);
	/**
	 * Devuelve el tipo de arranque del producto tipo moto
	 * @return Tipo de arranque
	 */
	public String getArranque();
	/**
	 * Establece el tipo de embrague del producto tipo moto
	 * @param embrague Tipo de embrague
	 */
	public void setEmbrague(String embrague);
	/**
	 * Devuelve el tipo de embrague del producto tipo moto
	 * @return Tipo de embrague
	 */
	public String getEmbrague();

}
