package com.concesionario.logica.transferencia.ventas;

import java.util.ArrayList;
/**
 * @author carlos
 *
 */
public interface InterfazTransferVentas {
	/**
	 * 
	 * @return devuelve el identificador de la compra
	 */
	public int getIdCompra();
	/**
	 * 
	 * @param idCompra inserta el identificador de la compra
	 */
	public void setIdCompra(int idCompra);
	/**
	 * 
	 * @return devuelve una lista con los articulos comprados
	 */
	public ArrayList<String> getListaCompra();
	/**
	 * 
	 * @param listaCompra inserta la lista de articulos comprados
	 */
	public void setListaCompra(ArrayList<String> listaCompra);
	/**
	 * 
	 * @return devuelve el id del cliente
	 */
	public int getIdCliente();
	/**
	 * 
	 * @param id inserta el identificador del cliente
	 */
	public void setIdCliente(int id);
	/**
	 * 
	 * @return devuelve una lista (paralela a listaCompra con las cantidades de cada articulo)
	 */
	public ArrayList<String> getCantidades() ;
	/**
	 * 
	 * @param cantidades inserta las cantidades de cada articulo
	 */
	public void setCantidades(ArrayList<String> cantidades);
	/**
	 * 
	 * @return devuelve si la compra esta activa, o dada de baja
	 */
	public boolean isAlta();
	/**
	 * 
	 * @param alta marca la compra como alta/baja
	 */
	public void setAlta(boolean alta);
	/**
	 * 
	 * @return devuelve el montante total de la compra (incluyendo los descuentos para el cliente empresa)
	 */
	public float getMontante();
	/**
	 * 
	 * @param montante inserta el montante total de la compra (incluyendo los descuentos)
	 */
	public void setMontante(float montante);
}
