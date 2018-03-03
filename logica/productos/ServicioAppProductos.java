package concesionario.logica.productos;

import java.util.ArrayList;

import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.integracion.factoria.FactoriaDAO;


public class ServicioAppProductos implements InterfazAppProductos {

	int id;
	InterfazTransferProductos producto;
	
	
	public ServicioAppProductos(){
		
	}
	
	public int altaProducto(InterfazTransferProductos producto){
		id= FactoriaDAO.getInstancia().dameDAOProductos().existeModelo(producto.getMarca()+producto.getModelo());
		String tipo="";
		if(id==0) //no existe, alta
			id=FactoriaDAO.getInstancia().dameDAOProductos().insertaProducto(producto);
		else{	//existe. comprobamos si está activo
			producto=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(id);
			tipo=FactoriaDAO.getInstancia().dameDAOProductos().tipoProducto(id);
			if(!producto.getActivo()) //no activo. activar
				id=FactoriaDAO.getInstancia().dameDAOProductos().activaProducto(id, tipo);
		}			
		return id;
	}
	public int bajaProducto(int id){
		if(FactoriaDAO.getInstancia().dameDAOProductos().existeProducto(id)){
			String tipo=FactoriaDAO.getInstancia().dameDAOProductos().tipoProducto(id);
			InterfazTransferProductos producto=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(id);
			if(producto.getActivo()){
				id=FactoriaDAO.getInstancia().dameDAOProductos().eliminaProducto(id,tipo);
				return id;
			}else return 0;		
		}else
			return 0;
	}
	public int modificaProducto(InterfazTransferProductos producto){
		
		if(id>0){ //existe el producto
			id=FactoriaDAO.getInstancia().dameDAOProductos().modificaProducto(producto);
			return id;
		}else return 0; //no existe,fallo
		
	}
	public ArrayList<InterfazTransferProductos> listaProductos(){
		int indice = 1;
		ArrayList<InterfazTransferProductos> lista = new ArrayList<InterfazTransferProductos>();
		InterfazTransferProductos producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(indice);
		while ( producto != null ) {
			if ( producto.getActivo() ) {
				lista.add(producto);
			}
			indice++;
			producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(indice);
		}
		return lista;
	}
	
	public InterfazTransferProductos detallesProducto(int id){
		if(FactoriaDAO.getInstancia().dameDAOProductos().existeProducto(id)){
			return FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(id);
		}else
			return null;
		
	}
}
