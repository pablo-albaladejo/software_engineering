package concesionario.logica.fachada;

import java.util.ArrayList;

import concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;

public interface InterfazFachadaNegocio {
	//Clientes
	public int altaCliente(InterfazTransferClientes cliente);
	public int bajaCliente(int id);
	public int modificaCliente(InterfazTransferClientes cliente);
	public InterfazTransferClientes detallesCliente(int id);
	public ArrayList<InterfazTransferClientes> listaClientes();
	
	//Proveedores
	public int altaProveedor(InterfazTransferProveedores Proveedor);
	public int bajaProveedor(int id);
	public int modificaProveedor(InterfazTransferProveedores Proveedor);
	public InterfazTransferProveedores detallesProveedor(int id);
	public ArrayList<InterfazTransferProveedores> listaProveedores();
	public int vinculaProveedor(InterfazTransferVinculo vinculo);
	public int desvinculaProveedor(InterfazTransferVinculo vinculo);
	
	//Productos
	public int altaProducto(InterfazTransferProductos producto);
	public int bajaProducto(int id);
	public int modificaProducto(InterfazTransferProductos producto);
	public InterfazTransferProductos detallesProducto(int id);
	public ArrayList<InterfazTransferProductos>listaProductos();
	
	//Ventas
	public InterfazTransferRespuesta altaVenta(InterfazTransferVentas venta);
	public boolean bajaVenta(int id, boolean devolver);
	public InterfazTransferRespuesta modificaVenta(InterfazTransferVentas venta);
	public InterfazTransferVentas detallesVenta(int id);
	public InterfazTransferVentas detallesVentaModificar(int id);
	public ArrayList<InterfazTransferVentas> listaVentas();
	
	//Pedidos
	public InterfazTransferRespuesta altaPedido(InterfazTransferPedidos pedido);
	public int anularPedido(int pedido);
	public int recibirPedido(int pedido);
	public InterfazTransferPedidos detallesPedido(int pedido);
	public ArrayList<InterfazTransferPedidos> listaPedidos();
	public ArrayList<InterfazTransferProductos> listaStock();
}