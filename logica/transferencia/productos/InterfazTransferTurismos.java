package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferTurismos extends InterfazTransferProductos{
	/**
	 * Establece el n�mer de puertas que tiene el producto de tipo turismo
	 * @param puertas N�mero de puertas
	 */
	public void setPuertas(int puertas);
	/**
	 * Devuelve el n�mer de puertas que tiene el producto de tipo turismo
	 * @return N�mero de puertas
	 */
	public int getPuertas();
	/**
	 * Establece el n�mero de plazas que tiene el producto de tipo turismo
	 * @param plazas N�mero de plazas
	 */
	public void setPlazas(int plazas);
	/**
	 * Devuelve el n�mero de plazas que tiene el producto de tipo turismo
	 * @return N�mero de plazas
	 */
	public int getPlazas();
	/**
	 * Establece el tipo de chasis del producto de tipo turismo. Posibles valores: Sed�n, berlina, coup�, cabrio, monovol�men...
	 * @param chasis Tipo de chasis
	 */
	public void setChasis(String chasis);
	/**
	 * Devuelve el tipo de chasis del producto de tipo turismo. Posibles valores: Sed�n, berlina, coup�, cabrio, monovol�men...
	 * @return Tipo de chasis
	 */
	public String getChasis();
	/**
	 * Establece el tipo de transmisi�n del producto de tipo turismo
	 * @param cambio Tipo de transmisi�n
	 */
	public void setCambio(String cambio);
	/**
	 * Devuelve el tipo de transmisi�n del producto de tipo turismo
	 * @return Tipo de transmisi�n
	 */
	public String getCambio();
}
