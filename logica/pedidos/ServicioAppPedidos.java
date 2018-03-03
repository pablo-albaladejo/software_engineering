package concesionario.logica.pedidos;

import java.util.ArrayList;

import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.integracion.pedidos.InterfazDAOPedidos;
import concesionario.integracion.productos.InterfazDAOProductos;
import concesionario.integracion.proveedores.InterfazDAOProveedores;

public class ServicioAppPedidos implements InterfazAppPedidos {

	public int anularPedido(int pedido) {
		InterfazDAOPedidos dao = FactoriaDAO.getInstancia().dameDAOPedidos();
		if ( dao.existePedido(pedido) <= 0 )
			return 0;
		else
			return dao.eliminaPedido(pedido);
	}

	public ArrayList<InterfazTransferPedidos> listarPedidos() {
		InterfazDAOPedidos dao = FactoriaDAO.getInstancia().dameDAOPedidos();
		int indice = 1;
		InterfazTransferPedidos pedido = dao.recuperaPedido(indice);
		ArrayList<InterfazTransferPedidos> lista = new ArrayList<InterfazTransferPedidos>();
		while ( pedido != null ) {
			if ( pedido.esActivo())lista.add(pedido);
				indice++;
				pedido = dao.recuperaPedido(indice);
		}
		return lista;
	}

	public ArrayList<InterfazTransferProductos> listarStock() {
		ArrayList<InterfazTransferProductos> lista = new ArrayList<InterfazTransferProductos>();
		int indice = 1;
		InterfazDAOProductos dao = FactoriaDAO.getInstancia().dameDAOProductos();
		InterfazTransferProductos producto = dao.recuperaProducto(indice);
		while ( producto != null  ) {
			if ( producto.getExistencias() < 5 && producto.getActivo() )
				lista.add(producto);
			indice++;
			producto = dao.recuperaProducto(indice);
		}
		return lista;
	}

	public InterfazTransferPedidos mostrarPedido(int pedido) {
		InterfazTransferPedidos detalles = FactoriaDAO.getInstancia().dameDAOPedidos().recuperaPedido(pedido);
		if (detalles.esActivo())return detalles; else return null;
	}

	public InterfazTransferRespuesta realizarPedido(InterfazTransferPedidos pedido) {
		InterfazDAOProductos daoProductos = FactoriaDAO.getInstancia().dameDAOProductos();
		InterfazDAOProveedores daoProveedores = FactoriaDAO.getInstancia().dameDAOProveedores();
		InterfazDAOPedidos daoPedidos = FactoriaDAO.getInstancia().dameDAOPedidos();
		InterfazTransferRespuesta respuesta = FactoriaTransfers.getInstancia().dameTRespuesta();
		respuesta.setValida(true);
		InterfazTransferProveedores proveedor;
		ArrayList<String> notas = new ArrayList<String>();
		InterfazTransferProductos producto;
		respuesta.setId(pedido.getIdentificador());
		proveedor = daoProveedores.recuperaProveedor(pedido.getProveedor());
		if ( proveedor == null) {
			respuesta.setValida(false);
			notas.add("El proveedor con identificador "+pedido.getProveedor()+" no existe.");
		}else{
			for ( int i=0 ; i<pedido.getNumElems() ; i++ ) {
				producto = pedido.getProducto(i);
				//Existe el producto?
				if ( !daoProductos.existeProducto(producto.getIdentificador()) ){
					respuesta.setValida(false);
					notas.add("El producto con identificador "+producto.getIdentificador()+" no existe");
				} else {
					boolean flagEsta=false;
					//El producto está vinculado con el proveedor?
					for ( int h=0 ; h<proveedor.getListaProductos().size() && !flagEsta ; h++ ) {
						if ( proveedor.getListaProductos().get(h).getIdentificador() == producto.getIdentificador() ){
//							le ponemos el precio del proveedor
							pedido.setPrecio(proveedor.getListaProductos().get(h).getPrecio(),i);
							flagEsta=true;
						}
					}
					if ( !flagEsta ){
						respuesta.setValida(false);
						notas.add("El producto con identificador "+producto.getIdentificador()+" no está vinculado con este proveedor.");
					}
				}
			}
		}
		if ( respuesta.isValida() ) {
			int p = daoPedidos.insertaPedido(pedido);
			notas.add("El identificador del pedido es "+p);
			notas.add("Pedido realizado con éxito por un importe total de "+pedido.getTotal());
		}
		respuesta.setNotas(notas);
		return respuesta;
	}

	public int recibirPedido(int pedido) {
		//Existe el pedido?
		InterfazDAOPedidos dao = FactoriaDAO.getInstancia().dameDAOPedidos();
		InterfazDAOProductos daoProductos = FactoriaDAO.getInstancia().dameDAOProductos();
		InterfazTransferPedidos ped;
		InterfazTransferProductos producto;
		InterfazTransferProductos pOriginal;
		ped = dao.recuperaPedido(pedido);
		if ( ped == null || !ped.esActivo()) return 0;
		//Actualizo el stock de cada producto
		for (int i=0 ; i<ped.getNumElems() ; i++) {
			producto = ped.getProducto(i);
			pOriginal = daoProductos.recuperaProducto(producto.getIdentificador());
			pOriginal.setExistencias(pOriginal.getExistencias()+ped.getNumProductos(i));
			daoProductos.modificaProducto(pOriginal);
		}
		//Anulo el pedido
		this.anularPedido(pedido);
		return ped.getIdentificador();
	}
	public int buscaProducto(int id){
		return FactoriaDAO.getInstancia().dameDAOPedidos().productoPendiente(id);
	}
}
