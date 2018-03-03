package concesionario.logica.factoria;

import concesionario.logica.clientes.InterfazAppClientes;
import concesionario.logica.clientes.ServicioAppClientes;
import concesionario.logica.fachada.FachadaNegocioImp;
import concesionario.logica.fachada.InterfazFachadaNegocio;
import concesionario.logica.pedidos.InterfazAppPedidos;
import concesionario.logica.pedidos.ServicioAppPedidos;
import concesionario.logica.productos.InterfazAppProductos;
import concesionario.logica.productos.ServicioAppProductos;
import concesionario.logica.proveedores.InterfazAppProveedores;
import concesionario.logica.proveedores.ServicioAppProveedores;
import concesionario.logica.ventas.InterfazAppVentas;
import concesionario.logica.ventas.ServicioAppVentas;

public class FactoriaServicioImp extends FactoriaServicio {
	
	public InterfazFachadaNegocio dameFachadaNegocio() {
		return new FachadaNegocioImp();
	}
	public InterfazAppClientes dameServicioClientes() {
		return new ServicioAppClientes();
	}
	
	public InterfazAppProductos dameServicioProductos() {
		return new ServicioAppProductos();
	}
	
	public InterfazAppProveedores dameServicioProveedores() {
		return new ServicioAppProveedores();
	}
	
	public InterfazAppVentas dameServicioVentas() {
		return new ServicioAppVentas();
	}
	
	public InterfazAppPedidos dameServicioPedidos() {
		return new ServicioAppPedidos();
	}
}
