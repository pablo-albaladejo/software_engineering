package concesionario.logica.proveedores;

import java.util.ArrayList;

import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;

public class ServicioAppProveedores implements InterfazAppProveedores {
	
	public ServicioAppProveedores(){
		
	}

	public int altaProveedor(InterfazTransferProveedores Proveedor) {
		int id;
		id = FactoriaDAO.getInstancia().dameDAOProveedores().existeProveedor(((InterfazTransferProveedores)Proveedor).getCIF());
		//comprobamos el estado del Proveedor a traves de su id
		if ( id == 0 ) id = FactoriaDAO.getInstancia().dameDAOProveedores().insertaProveedor(Proveedor);
		else{
			id=FactoriaDAO.getInstancia().dameDAOProveedores().activaProveedor(id);
		}
		return id;
	}

	public int bajaProveedor(int identificador) {
		int id;
		boolean pendientes = false;
		ArrayList<InterfazTransferProductos> listaProductos = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(identificador).getListaProductos();
		for(int i = 0;i<listaProductos.size() && !pendientes ;i++){
			int valor = FactoriaDAO.getInstancia().dameDAOPedidos().productoPendiente(listaProductos.get(i).getIdentificador());
			if(valor>0) pendientes = true;
		}
		if(pendientes) return -1;
		id = FactoriaDAO.getInstancia().dameDAOProveedores().eliminaProveedor(identificador);
		return id;
	}
	
	public int modificaProveedor(InterfazTransferProveedores Proveedor) {
		int id;
		id = FactoriaDAO.getInstancia().dameDAOProveedores().modificaProveedor(Proveedor);
		return id;
	}

	public ArrayList<InterfazTransferProveedores> listaProveedores() {
		int indice = 1;
		ArrayList<InterfazTransferProveedores> lista = new ArrayList<InterfazTransferProveedores>();
		InterfazTransferProveedores Proveedor = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(indice);
		while ( Proveedor != null ) {
			if ( Proveedor.getActivo() ) {
				lista.add(Proveedor);
			}
			indice++;
			Proveedor = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(indice);
		}
		return lista;
	}

	public InterfazTransferProveedores detallesProveedor(int id) {
		InterfazTransferProveedores Proveedor = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(id);
		if ( Proveedor != null && Proveedor.getActivo() )
			return Proveedor;
		else return null;
	}

	public int vinculaProveedor(InterfazTransferVinculo vinculo) {
		InterfazTransferProveedores proveedor = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(vinculo.getIdProveedor());
    	InterfazTransferProductos producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(vinculo.getIdProducto());
		if(proveedor == null || !proveedor.getActivo()){
			return 0;
		}else if(producto == null || !producto.getActivo()){
			return -1;
		}else{//todo ok!						
			return FactoriaDAO.getInstancia().dameDAOProveedores().vinculaProveedor(vinculo.getIdProveedor(),vinculo.getIdProducto(),vinculo.getPrecio());
		}
	}
	public int desvinculaProveedor(InterfazTransferVinculo vinculo) {
		InterfazTransferProveedores proveedor = FactoriaDAO.getInstancia().dameDAOProveedores().recuperaProveedor(vinculo.getIdProveedor());
    	InterfazTransferProductos producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(vinculo.getIdProducto());
    	if(proveedor == null || //ver si el producto esta activo en algun pedido
		(FactoriaDAO.getInstancia().dameDAOPedidos().productoPendiente(vinculo.getIdProducto())>0)	){
			return 0;
		}else if(producto == null){
			return -1;
		}else{//todo ok!
			return FactoriaDAO.getInstancia().dameDAOProveedores().desvinculaProveedor(vinculo.getIdProveedor(),vinculo.getIdProducto());
		}
	}
	public int buscaProducto(int id){
		return FactoriaDAO.getInstancia().dameDAOProveedores().productoVinculado(id);
	}
}
