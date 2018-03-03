package com.concesionario.logica.transferencia.productos;

public interface InterfazTransferProductos {
	/**
	 * Establece el identificador �nico del producto
	 * @param id Identificador del producto
	 */
	public void setIdentificador(int id);
	/**
	 * Devuelve el identificador �nico del producto
	 * @return Identificador del producto
	 */
	public int getIdentificador();
	/**
	 * Establece la marca del producto
	 * @param marca Marca del producto
	 */
	public void setMarca(String marca);
	/**
	 * Devuelve la marca del producto
	 * @return Marca del producto
	 */
	public String getMarca();
	/**
	 * Establece el modelo del producto
	 * @param modelo Modelo del producto
	 */
	public void setModelo(String modelo);
	/**
	 * Devuelve el modelo del producto
	 * @return Modelo del producto
	 */
	public String getModelo();
	/**
	 * Establece el a�o de comercializaci�n del producto
	 * @param anyo A�o de comercializaci�n del producto
	 */
	public void setA�o(int anyo);
	/**
	 * Devuelve el a�o de comercializaci�n del producto
	 * @return A�o de comercializaci�n del producto
	 */
	public int getA�o();
	/**
	 * Establece el precio de venta del producto
	 * @param precio Precio de venta del producto
	 */
	public void setPrecio(float precio);
	/**
	 * Devuelve el precio de venta del producto
	 * @return Precio de venta del producto
	 */
	public float getPrecio();
	/**
	 * Establece la cilindrada del producto
	 * @param Cilindrada Cilindrada del producto
	 */
	public void setCilindrada(String cilindrada);
	/**
	 * Devuelve la cilindrada del producto
	 * @return Cilindrada del producto
	 */
	public String getCilindrada();
	/**
	 * Establece el n�mero de unidades del producto disponibles en stock
	 * @param existencias N�mero de unidades disponibles en stock
	 */
	public void setExistencias(int existencias);
	/**
	 * Devuelve el n�mero de unidades del producto disponibles en stock
	 * @return N�meor de unidades disponibles en stock
	 */
	public int getExistencias();
	/**
	 * Establece el estado del producto 1=activo 0=baja
	 * @param activo Estado del producto
	 */
	public void setActivo(boolean activo);
	/**
	 * Devuelve el estado del producto 1=activo 0=baja
	 * @return Estado del producto
	 */
	public boolean getActivo();
}