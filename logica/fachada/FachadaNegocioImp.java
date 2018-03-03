package concesionario.logica.fachada;

import java.util.ArrayList;

import concesionario.logica.factoria.FactoriaServicio;
import concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;

public class FachadaNegocioImp implements InterfazFachadaNegocio {
	
	//Clientes
	public int altaCliente(InterfazTransferClientes cliente) {
		return FactoriaServicio.getInstancia().dameServicioClientes().altaCliente(cliente);
	}
	
	public int bajaCliente(int id) {
		return FactoriaServicio.getInstancia().dameServicioClientes().bajaCliente(id);
	}

	public InterfazTransferClientes detallesCliente(int id) {
		return FactoriaServicio.getInstancia().dameServicioClientes().detallesCliente(id);
	}

	public ArrayList<InterfazTransferClientes> listaClientes() {
		return FactoriaServicio.getInstancia().dameServicioClientes().listaClientes();
	}

	public int modificaCliente(InterfazTransferClientes cliente) {
		return FactoriaServicio.getInstancia().dameServicioClientes().modificaCliente(cliente);
	}
	
	//Proveedores
	public int altaProveedor(InterfazTransferProveedores Proveedor) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().altaProveedor(Proveedor);
	}
	
	public int bajaProveedor(int id) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().bajaProveedor(id);
	}

	public InterfazTransferProveedores detallesProveedor(int id) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().detallesProveedor(id);
	}

	public ArrayList<InterfazTransferProveedores> listaProveedores() {
		return FactoriaServicio.getInstancia().dameServicioProveedores().listaProveedores();
	}

	public int modificaProveedor(InterfazTransferProveedores proveedor) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().modificaProveedor(proveedor);
	}
	
	public int vinculaProveedor(InterfazTransferVinculo vinculo) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().vinculaProveedor(vinculo);
	}
	public int desvinculaProveedor(InterfazTransferVinculo vinculo) {
		return FactoriaServicio.getInstancia().dameServicioProveedores().desvinculaProveedor(vinculo);
	}
	
	//Ventas
	
	public InterfazTransferRespuesta altaVenta(InterfazTransferVentas venta) {
		return FactoriaServicio.getInstancia().dameServicioVentas().insertaVenta(venta);
	}

	@Override
	public boolean bajaVenta(int id, boolean devolver) {
		return FactoriaServicio.getInstancia().dameServicioVentas().eliminaVenta(id,true);
	}

	@Override
	public InterfazTransferVentas detallesVenta(int id) {
		return FactoriaServicio.getInstancia().dameServicioVentas().recuperaVenta(id);
	}
	@Override
	public InterfazTransferVentas detallesVentaModificar(int id) {
		return FactoriaServicio.getInstancia().dameServicioVentas().recuperaVentaModificar(id);
	}

	@Override
	public ArrayList<InterfazTransferVentas> listaVentas() {
		return FactoriaServicio.getInstancia().dameServicioVentas().listaVentas();
	}

	@Override
	public InterfazTransferRespuesta modificaVenta(InterfazTransferVentas venta) {
		return FactoriaServicio.getInstancia().dameServicioVentas().modificaVenta(venta);	
	}
	//Productos
	public int altaProducto(InterfazTransferProductos producto){
		return FactoriaServicio.getInstancia().dameServicioProductos().altaProducto(producto);
	}
	public int bajaProducto(int id){
		return FactoriaServicio.getInstancia().dameServicioProductos().bajaProducto(id);
	}
	public int modificaProducto(InterfazTransferProductos producto){
		return FactoriaServicio.getInstancia().dameServicioProductos().modificaProducto(producto);
	}
	public InterfazTransferProductos detallesProducto(int id){
		return FactoriaServicio.getInstancia().dameServicioProductos().detallesProducto(id);
	}
	public ArrayList<InterfazTransferProductos> listaProductos(){
		return FactoriaServicio.getInstancia().dameServicioProductos().listaProductos();
	}

	//Pedidos
	public InterfazTransferRespuesta altaPedido(InterfazTransferPedidos pedido) {
		return FactoriaServicio.getInstancia().dameServicioPedidos().realizarPedido(pedido);
	}

	public int anularPedido(int pedido) {
		return FactoriaServicio.getInstancia().dameServicioPedidos().anularPedido(pedido);
	}

	public int recibirPedido(int pedido) {
		return FactoriaServicio.getInstancia().dameServicioPedidos().recibirPedido(pedido);
	}

	public InterfazTransferPedidos detallesPedido(int pedido) {
		return FactoriaServicio.getInstancia().dameServicioPedidos().mostrarPedido(pedido);
	}

	public ArrayList<InterfazTransferPedidos> listaPedidos() {
		return FactoriaServicio.getInstancia().dameServicioPedidos().listarPedidos();
	}

	public ArrayList<InterfazTransferProductos> listaStock() {
		return FactoriaServicio.getInstancia().dameServicioPedidos().listarStock();
	}
}
