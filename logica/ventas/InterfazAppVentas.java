package concesionario.logica.ventas;
import java.util.ArrayList;

import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;
public interface InterfazAppVentas {
	/**
	 * 
	 * @param carrito
	 * @return respuesta de la inserccion
	 */
	public InterfazTransferRespuesta insertaVenta(InterfazTransferVentas carrito);
	
	/**
	 * 
	 * @param id el identificador unico de la venta
	 * @return el objeto de la venta solicitada
	 */
	public InterfazTransferVentas recuperaVenta(int id);
	
	/**
	 * 
	 * @param id
	 * @return el objeto de la venta para modificarlo
	 */
	public InterfazTransferVentas recuperaVentaModificar(int id);
	
	/**
	 * 
	 * @param id
	 * @param devolver
	 * @return si tuvo exito o no
	 */
	public boolean eliminaVenta(int id,boolean devolver);
	
	/**
	 * 
	 * @param venta
	 * @return respuesta sobre la ejecucion del codigo
	 */
	public InterfazTransferRespuesta modificaVenta(InterfazTransferVentas venta);
	
	/**
	 * 
	 * @param id
	 * @return si es cierto o no que existe la venta en el sistema
	 */
	public boolean existeVenta(int id);
	
	/**
	 * 
	 * @return una lista de interfaces de ventas
	 */
	public ArrayList<InterfazTransferVentas> listaVentas();
	
}
