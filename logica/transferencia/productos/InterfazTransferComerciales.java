package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferComerciales extends InterfazTransferProductos{
	/**
	 * Establece la capacidad de carga del producto tipo vehículo comercial
	 * @param capacidad Capacidad de carga, en kilogramos
	 */
	public void setCapcarga(int capacidad);
	/**
	 * Devuelve la capacidad de carga del producto tipo vehículo comercial
	 * @return Capacidad de carga, en kilogramos
	 */
	public int getCapcarga();
	/**
	 * Establece el volumen útil de la zona de carga del producto tipo vehículo comercial
	 * @param volutil Volúmen útil de la zona de carga, en metros cúbicos
	 */
	public void setVolutil(int volutil);
	/**
	 * Devuelve el volúmen útil de la zona de carga del producto tipo vehículo comercial
	 * @return Volúmen útil de la zona de carga, en metros cúbicos
	 */
	public int getVolutil();
	/**
	 * Establece el número de puertas del producto tipo vehículo comercial
	 * @param puertas Número de puertas
	 */
	public void setPuertas(int puertas);
	/**
	 * Devuelve el número de puertas del producto tipo vehículo comercial
	 * @return Número de puertas
	 */
	public int getPuertas();
}
