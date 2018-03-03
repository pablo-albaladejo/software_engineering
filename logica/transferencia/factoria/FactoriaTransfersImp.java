package com.concesionario.logica.transferencia.factoria;


import com.concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import com.concesionario.logica.transferencia.clientes.TClienteEmpresa;
import com.concesionario.logica.transferencia.clientes.TClienteNormal;
import com.concesionario.logica.transferencia.pedidos.InterfazTransferElementoPedido;
import com.concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import com.concesionario.logica.transferencia.pedidos.TElementoPedido;
import com.concesionario.logica.transferencia.pedidos.TPedido;
import com.concesionario.logica.transferencia.productos.InterfazTransferProductos;
import com.concesionario.logica.transferencia.productos.TProducto;
import com.concesionario.logica.transferencia.productos.TTurismo;
import com.concesionario.logica.transferencia.productos.TMoto;
import com.concesionario.logica.transferencia.productos.TComercial;
import com.concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import com.concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;
import com.concesionario.logica.transferencia.proveedores.TProveedor;
import com.concesionario.logica.transferencia.proveedores.TVinculo;
import com.concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import com.concesionario.logica.transferencia.ventas.InterfazTransferVentas;
import com.concesionario.logica.transferencia.ventas.TRespuesta;
import com.concesionario.logica.transferencia.ventas.TVenta;

public class FactoriaTransfersImp extends FactoriaTransfers {

	public InterfazTransferPedidos dameTPedidos() {
		return new TPedido();
	}

	public InterfazTransferProductos dameTProductos() {
		return new TProducto();
	}

	public InterfazTransferProveedores dameTProveedor() {
		return new TProveedor();
	}

	public InterfazTransferVentas dameTVentas() {
		return new TVenta();
	}

	public InterfazTransferClientes dameTClienteEmpresa() {
		return new TClienteEmpresa();
	}

	public InterfazTransferClientes dameTClienteNormal() {
		return new TClienteNormal();
	}
	public InterfazTransferProductos dameTProductoTurismo(){
		return new TTurismo();
	}
	public InterfazTransferProductos dameTProductoMoto(){
		return new TMoto();
	}
	public InterfazTransferProductos dameTProductoComercial(){
		return new TComercial();
	}

	public InterfazTransferRespuesta dameTRespuesta() {
		return new TRespuesta();
	}

	public InterfazTransferVinculo dameTVinculo() {
		return new TVinculo();
	}

	public InterfazTransferElementoPedido dameTElementoPedido() {
		return new TElementoPedido();
	}
}
