package concesionario.logica.ventas;
import java.util.ArrayList; 

import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteEmpresa;
import concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.ventas.InterfazTransferRespuesta;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;

public class ServicioAppVentas implements InterfazAppVentas {


	public ServicioAppVentas (){

	}
	@Override
	public InterfazTransferRespuesta insertaVenta(InterfazTransferVentas venta){
		float montante=0;
		int descuento=0;
		InterfazTransferRespuesta respuesta=compruebaVenta(venta,FactoriaTransfers.getInstancia().dameTRespuesta());
		if (respuesta.isValida()){
			InterfazTransferClientes cliente=FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(venta.getIdCliente());

			if ( cliente instanceof InterfazTransferClienteEmpresa ){
				descuento=((InterfazTransferClienteEmpresa)cliente).getDescuento();
			} 
			else descuento=0;
			for (int i=0;i<venta.getListaCompra().size();i=i+2){

				montante=montante+FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getPrecio()*Integer.valueOf(venta.getCantidades().get(i));
			}
			venta.setMontante(montante-montante*descuento/100);
			FactoriaDAO.getInstancia().dameDAOVentas().insertaVenta(venta);
		}
		if (respuesta.getNotas().size()==0){
			respuesta.getNotas().add("compra realizada");
		}
		return respuesta;


	}
	public InterfazTransferRespuesta modificaVenta(InterfazTransferVentas venta){
		float montante=0;
		int descuento=0;
		InterfazTransferRespuesta respuesta=compruebaVenta(venta,FactoriaTransfers.getInstancia().dameTRespuesta());
		if (respuesta.isValida()){
			InterfazTransferClientes cliente=FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(venta.getIdCliente());

			if ( cliente instanceof InterfazTransferClienteEmpresa ){
				descuento=((InterfazTransferClienteEmpresa)cliente).getDescuento();
			} 
			else descuento=0;
			for (int i=0;i<venta.getListaCompra().size();i=i+2){

				montante=montante+FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getPrecio()*Integer.valueOf(venta.getCantidades().get(i));
			}
			venta.setMontante(montante-montante*descuento/100);
			FactoriaDAO.getInstancia().dameDAOVentas().modificaVenta(venta);
		}
		if (respuesta.getNotas().size()==0){
			respuesta.getNotas().add("compra realizada");
		}
		return respuesta;



	}
	public InterfazTransferVentas recuperaVenta(int id){

		InterfazTransferVentas venta= FactoriaDAO.getInstancia().dameDAOVentas().recuperaVenta(id);

		return venta;


	}
	public InterfazTransferVentas recuperaVentaModificar(int id){

		InterfazTransferVentas venta= FactoriaDAO.getInstancia().dameDAOVentas().recuperaVenta(id);
		if (venta!=null) devuelveVenta(venta); ///utilizo esta linea para evitar comprar dos veces los mismos productos


		return venta;


	}
	public boolean eliminaVenta(int id,boolean devolver){
		if (existeVenta(id)){
			if (devolver){
				InterfazTransferVentas venta= FactoriaDAO.getInstancia().dameDAOVentas().recuperaVenta(id);
				devuelveVenta(venta);
			}
			FactoriaDAO.getInstancia().dameDAOVentas().eliminaVenta(id);
			return true;
		}
		else{
			return false;
		}

	}
	public boolean existeVenta(int id){

		return FactoriaDAO.getInstancia().dameDAOVentas().existeVenta(id);

	}
	public ArrayList<InterfazTransferVentas> listaVentas(){
		InterfazTransferVentas ventasTemp=FactoriaTransfers.getInstancia().dameTVentas();
		int numeroVentas=FactoriaDAO.getInstancia().dameDAOVentas().numeroVentas();
		ArrayList<InterfazTransferVentas> listadoVentas=new ArrayList<InterfazTransferVentas>();
		for (int i=1;i<=numeroVentas;i++){
			ventasTemp=recuperaVenta(i);
			if (ventasTemp!=null) listadoVentas.add(ventasTemp);
		}
		return listadoVentas;
	}
////	privados:


	private void devuelveVenta(InterfazTransferVentas venta){
		for(int i=0;i<venta.getListaCompra().size();i++){
			int anterior=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getExistencias();
			InterfazTransferProductos producto=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i)));
			if (producto.getActivo()){
				producto.setExistencias(anterior+Integer.valueOf(venta.getCantidades().get(i)));
			}
			else{
				producto.setActivo(true);
				producto.setExistencias(Integer.valueOf(venta.getCantidades().get(i)));
			}


			FactoriaDAO.getInstancia().dameDAOProductos().modificaProducto(producto);
		}
	}

	private InterfazTransferRespuesta compruebaVenta(InterfazTransferVentas venta,InterfazTransferRespuesta respuesta){

		respuesta=compruebaProductosEnStock(venta,compruebaExisteCliente(venta.getIdCliente(),respuesta));

		return respuesta;
	}


	private InterfazTransferRespuesta compruebaProductosEnStock(InterfazTransferVentas venta,InterfazTransferRespuesta respuesta) {
		ArrayList<String> notas=new ArrayList<String>();

		if (respuesta.isValida()){
			for (int i=0;i<venta.getListaCompra().size();i++){

				if (FactoriaDAO.getInstancia().dameDAOProductos().existeProducto(Integer.valueOf(venta.getListaCompra().get(i)))){
					if (FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getExistencias()<Integer.valueOf(venta.getCantidades().get(i))){
						if (FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getExistencias()>0){
							notas.add("no se ha podido comprar todas las existencias del producto "+venta.getListaCompra().get(i)+" por no existir suficiente stock");
							notas.add("es necesario realizar pedido del producto "+venta.getListaCompra().get(i));
							venta.getCantidades().set(i,(Integer.toString(FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getExistencias())));
							InterfazTransferProductos producto=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i)));
							producto.setExistencias(0);
							FactoriaDAO.getInstancia().dameDAOProductos().modificaProducto(producto);

						}
						else{
							notas.add("no se ha podido comprar el producto "+venta.getListaCompra().get(i)+" por no tener existencias actualmente");
							notas.add("es necesario realizar pedido del producto "+venta.getListaCompra().get(i));
							venta.getListaCompra().remove(i);
							venta.getCantidades().remove(i);
							i=i-1;
						}
					}
					else{
						if (Integer.valueOf(venta.getCantidades().get(i))==0){
							venta.getListaCompra().remove(i);
							venta.getCantidades().remove(i);
							i=i-1;
						}
						int anterior=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i))).getExistencias();
						InterfazTransferProductos producto=FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(venta.getListaCompra().get(i)));
						producto.setExistencias(anterior-Integer.valueOf(venta.getCantidades().get(i)));
						FactoriaDAO.getInstancia().dameDAOProductos().modificaProducto(producto);
						if (producto.getExistencias()<5){
							notas.add("las existencias en stock del producto "+ venta.getListaCompra().get(i)+" son menores que 5.realizar pedido");
						}
					}
				}
				else{
					notas.add("no se ha podido comprar el producto "+venta.getListaCompra().get(i)+" por no existir en la base de datos");
					venta.getListaCompra().remove(i);
					venta.getCantidades().remove(i);
					i=i-1;

				}

			}
		}
		if (venta.getListaCompra().size()==0){

			if (existeVenta(Integer.valueOf(venta.getIdCompra()))){
				eliminaVenta(Integer.valueOf(venta.getIdCompra()),false);
				notas.add("al modificar la compra se han eliminado todas las cantidades. la compra queda eliminada");
			}
			else{
				notas.add("NO SE HA REALIZADO LA COMPRA PORQUE LA LISTA DE PRODUCTOS ESTA VACIA");
			}
			respuesta.setValida(false);
		}



		for (int i=0;i<notas.size();i++){
			respuesta.getNotas().add(notas.get(i));
		}


		return respuesta;

	}


	private InterfazTransferRespuesta compruebaExisteCliente(int id,InterfazTransferRespuesta respuesta) {
		ArrayList<String> notas=new ArrayList<String>(); 
		InterfazTransferClientes cliente=FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(id);
		if (cliente!=null){
			if (cliente.getActivo()){
				respuesta.setValida(true);
				respuesta.setId(id);
			}
			else{
				respuesta.setValida(false);
				notas.add("NO SE HA PODIDO REALIZAR LA COMPRA PORQUE EL CLIENTE "+id+" ESTA DADO DE BAJA");
			}

		}
		else {
			respuesta.setValida(false);
			notas.add("NO SE HA PODIDO REALIZAR LA COMPRA PORQUE EL CLIENTE "+id+" NO EXISTE");


		}
		respuesta.setNotas(notas);

		return respuesta;
	}


}