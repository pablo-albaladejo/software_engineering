package concesionario.integracion.factoria;

import concesionario.integracion.clientes.DAOClientesImp;
import concesionario.integracion.clientes.InterfazDAOClientes;
import concesionario.integracion.pedidos.DAOPedidosImp;
import concesionario.integracion.pedidos.InterfazDAOPedidos;
import concesionario.integracion.productos.DAOProductosImp;
import concesionario.integracion.productos.InterfazDAOProductos;
import concesionario.integracion.proveedores.DAOProveedoresImp;
import concesionario.integracion.proveedores.InterfazDAOProveedores;
import concesionario.integracion.ventas.DAOVentasImp;
import concesionario.integracion.ventas.InterfazDAOVentas;

public class FactoriaDAOImp extends FactoriaDAO {
	public InterfazDAOClientes dameDAOClientes() {
		return new DAOClientesImp();
	}
	public InterfazDAOProductos dameDAOProductos() {
		return new DAOProductosImp();
	}
	public InterfazDAOProveedores dameDAOProveedores() {
		return new DAOProveedoresImp();
	}
	public InterfazDAOVentas dameDAOVentas() {
		return new DAOVentasImp();
	}
	public InterfazDAOPedidos dameDAOPedidos() {
		return new DAOPedidosImp();
	}
}
