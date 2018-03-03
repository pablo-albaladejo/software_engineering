package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferComerciales extends InterfazTransferProductos{
	/**
	 * Establece la capacidad de carga del producto tipo veh�culo comercial
	 * @param capacidad Capacidad de carga, en kilogramos
	 */
	public void setCapcarga(int capacidad);
	/**
	 * Devuelve la capacidad de carga del producto tipo veh�culo comercial
	 * @return Capacidad de carga, en kilogramos
	 */
	public int getCapcarga();
	/**
	 * Establece el volumen �til de la zona de carga del producto tipo veh�culo comercial
	 * @param volutil Vol�men �til de la zona de carga, en metros c�bicos
	 */
	public void setVolutil(int volutil);
	/**
	 * Devuelve el vol�men �til de la zona de carga del producto tipo veh�culo comercial
	 * @return Vol�men �til de la zona de carga, en metros c�bicos
	 */
	public int getVolutil();
	/**
	 * Establece el n�mero de puertas del producto tipo veh�culo comercial
	 * @param puertas N�mero de puertas
	 */
	public void setPuertas(int puertas);
	/**
	 * Devuelve el n�mero de puertas del producto tipo veh�culo comercial
	 * @return N�mero de puertas
	 */
	public int getPuertas();
}
