/**
 * 
 */
package com.concesionario.logica.transferencia.factoria;

import com.concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import com.concesionario.logica.transferencia.pedidos.InterfazTransferElementoPedido;
import com.concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;
import com.concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import com.concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;
import com.concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import com.concesionario.logica.transferencia.ventas.InterfazTransferVentas;

public abstract class FactoriaTransfers {
	
	private static FactoriaTransfers instancia;
	
	public static FactoriaTransfers getInstancia(){
		if ( instancia == null ) instancia = new FactoriaTransfersImp();
		return instancia;
	}
	/**
	 * Crea un nuevo transfer vac�o de cliente normal y lo devuelve 
	 * @return	Transfer de cliente 
	 */
	abstract public InterfazTransferClientes dameTClienteNormal();
	/**
	 * Crea un nuevo transfer vac�o de cliente empresa y lo devuelve
	 * @return	Transfer de cliente 
	 */
	abstract public InterfazTransferClientes dameTClienteEmpresa();
	/**
	 * Crea un nuevo transfer vac�o de producto turismo y lo devuelve
	 * @return Transfer de producto 
	 */
	abstract public InterfazTransferProductos dameTProductoTurismo();
	/**
	 * Crea un nuevo transfer vac�o de producto moto y lo devuelve
	 * @return Transfer de producto 
	 */
	abstract public InterfazTransferProductos dameTProductoMoto();
	/**
	 * Crea un nuevo transfer vac�o de producto veh�culo comercial y lo devuelve
	 * @return Transfer de produtco
	 */
	abstract public InterfazTransferProductos dameTProductoComercial();
	/**
	 * Crea un nuevo transfer vac�o de proveedor y lo devuelve
	 * @return Transfer de proveedor
	 */
	abstract public InterfazTransferProveedores dameTProveedor();
	/**
	 * Crea un nuevo transfer vac�o de venta y lo devuelve
	 * @return Transfer de venta
	 */
	abstract public InterfazTransferVentas dameTVentas();
	/**
	 * Crea un nuevo transfer vac�o de respuesta y lo devuelve
	 * @return Transfer de respuesta
	 */
	abstract public InterfazTransferRespuesta dameTRespuesta();
	/**
	 * Crea un nuevo transfer vac�o de pedido y lo devuelve
	 * @return Transfer de pedido
	 */
	abstract public InterfazTransferPedidos dameTPedidos();
	/**
	 * Crea un nuevo transfer vac�o de producto y lo devuelve
	 * @return Transfer de producto
	 */
	abstract public InterfazTransferProductos dameTProductos();
	/**
	 * Crea un nuevo transfer vac�o de v�nculo y lo devuelve
	 * @return Transfer de v�nculo
	 */

	abstract public InterfazTransferVinculo dameTVinculo();
	/**
	 * Crea un nuevo transfer vac�o de elemento pedido y lo devuelve
	 * @return Transfer de elemento pedido
	 */
	abstract public InterfazTransferElementoPedido dameTElementoPedido();
}
