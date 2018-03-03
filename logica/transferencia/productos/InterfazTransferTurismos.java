package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferTurismos extends InterfazTransferProductos{
	/**
	 * Establece el númer de puertas que tiene el producto de tipo turismo
	 * @param puertas Número de puertas
	 */
	public void setPuertas(int puertas);
	/**
	 * Devuelve el númer de puertas que tiene el producto de tipo turismo
	 * @return Número de puertas
	 */
	public int getPuertas();
	/**
	 * Establece el número de plazas que tiene el producto de tipo turismo
	 * @param plazas Número de plazas
	 */
	public void setPlazas(int plazas);
	/**
	 * Devuelve el número de plazas que tiene el producto de tipo turismo
	 * @return Número de plazas
	 */
	public int getPlazas();
	/**
	 * Establece el tipo de chasis del producto de tipo turismo. Posibles valores: Sedán, berlina, coupé, cabrio, monovolúmen...
	 * @param chasis Tipo de chasis
	 */
	public void setChasis(String chasis);
	/**
	 * Devuelve el tipo de chasis del producto de tipo turismo. Posibles valores: Sedán, berlina, coupé, cabrio, monovolúmen...
	 * @return Tipo de chasis
	 */
	public String getChasis();
	/**
	 * Establece el tipo de transmisión del producto de tipo turismo
	 * @param cambio Tipo de transmisión
	 */
	public void setCambio(String cambio);
	/**
	 * Devuelve el tipo de transmisión del producto de tipo turismo
	 * @return Tipo de transmisión
	 */
	public String getCambio();
}
