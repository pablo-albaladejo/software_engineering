/**
 * 
 */
package concesionario.integracion.ventas;

import concesionario.logica.transferencia.ventas.InterfazTransferVentas;


public interface InterfazDAOVentas {
	/**
	 * 
	 * @param venta trae los datos de la venta
	 */
	public void insertaVenta(InterfazTransferVentas venta);
	/**
	 * 
	 * @param id identificador de la compra a recuperar
	 * @return
	 */
	public InterfazTransferVentas recuperaVenta(int id);
	/**
	 * 
	 * @param id identificador de la compra a eliminar
	 */
	public void eliminaVenta(int id);
	/**
	 * 
	 * @param venta datos de la venta modificados para ser insertados
	 */
	public void modificaVenta(InterfazTransferVentas venta);
	/**
	 * 
	 * @param id identificador de la venta para comprobar si existe
	 * @return
	 */
	public boolean existeVenta(int id);
	/**
	 * 
	 * @return devuelve el numero de ventas existentes en el xml
	 */
	public int numeroVentas();

}
