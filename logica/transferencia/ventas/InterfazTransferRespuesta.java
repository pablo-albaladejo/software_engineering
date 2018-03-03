/**
 * 
 */
package com.concesionario.logica.transferencia.ventas;

import java.util.ArrayList;

/**
 * @author carlos
 *
 */
public interface InterfazTransferRespuesta {
	/**
	 * 
	 * @return devuelve el id del cliente que hace la compra
	 */
	public int getId();
	/**
	 * 
	 * @param id se inserta el id del cliente que hace la compra
	 */
	public void setId(int id);
	/**
	 * 
	 * @return devuelve una lista de las notas con los problemas encontrados
	 */
	public ArrayList<String> getNotas();
	/**
	 * 
	 * @param notas lista de las notas para ser insertadas
	 */
	public void setNotas(ArrayList<String> notas);
	/**
	 * 
	 * @return devuelve si la compra cumple los requisitos minimos (existe cliente, hay minimo un producto valido)
	 */
	public boolean isValida();
	/**
	 * 
	 * @param valida modifica si la comra es valida o no.
	 */
	public void setValida(boolean valida);

}
