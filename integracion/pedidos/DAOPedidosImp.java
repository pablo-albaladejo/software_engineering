package concesionario.integracion.pedidos;

import java.util.ArrayList;

import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.integracion.xml.AccesoXml;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;

public class DAOPedidosImp implements InterfazDAOPedidos {

	private AccesoXml accesoPedidos;
	private AccesoXml accesoPedidosProveedor;
	private final String rutaXML = "c:\\hlocal\\datos";
	private final String entidadPedidos = "pedidos";
	private final String entidadPedidosProveedor = "pedidosProveedor";
	ArrayList<String> estructuraPedido;
	ArrayList<String> estructuraPedidoProveedor;
	
	public DAOPedidosImp() {
		//EN estructuraPedidoProveedor se almacena las relaciones Pedidos-proveedor con su estado asociado
		this.estructuraPedidoProveedor = new ArrayList<String>();
		this.estructuraPedidoProveedor.add("identificador");
		this.estructuraPedidoProveedor.add("idProveedor");
		this.estructuraPedidoProveedor.add("estado");
		
		this.estructuraPedido = new ArrayList<String>();
		this.estructuraPedido.add("identificador");
		this.estructuraPedido.add("idProveedor");
		this.estructuraPedido.add("importe");
		
		this.accesoPedidos = new AccesoXml("identificador",rutaXML,entidadPedidos,estructuraPedido);
		this.accesoPedidosProveedor = new AccesoXml("identificador",rutaXML,entidadPedidosProveedor,estructuraPedidoProveedor);
	}
	
	public int insertaPedido(InterfazTransferPedidos pedido) {
		this.estructuraPedido = new ArrayList<String>();
		this.estructuraPedido.add("identificador");
		this.estructuraPedido.add("idProveedor");
		this.estructuraPedido.add("importe");
		
		for ( int i=0 ; i<pedido.getNumElems() ; i++) {
			this.estructuraPedido.add("idProducto");
			this.estructuraPedido.add("cantidad");
			this.estructuraPedido.add("precioU");
		}
		
		//this.accesoPedidos = new AccesoXml("identificador",rutaXML,entidadPedidos,estructuraPedido);
		
		int id = accesoPedidos.numElem()+1;
		accesoPedidos.nuevaEntidad(Integer.toString(id));
		ArrayList<String> datos = new ArrayList<String>();
		datos.add(Integer.toString(id));
		datos.add(Integer.toString(pedido.getProveedor()));
		datos.add(Float.toString(pedido.getTotal()));
		for ( int i=0 ; i<pedido.getNumElems() ; i++) {
			datos.add(Integer.toString(pedido.getProducto(i).getIdentificador()));
			datos.add(Integer.toString(pedido.getNumProductos(i)));
			datos.add(Float.toString(pedido.getPrecioProducto(i)));
		}
		accesoPedidos.setAtributo(Integer.toString(id), datos,this.estructuraPedido);
		
		ArrayList<String> datos2 = new ArrayList<String>();
		accesoPedidosProveedor.nuevaEntidad(Integer.toString(id));
		datos2.add(Integer.toString(pedido.getProveedor()));
		datos2.add("1");
		accesoPedidosProveedor.setAtributo(Integer.toString(id), datos2);
		return id;
	}

	public int eliminaPedido(int identificador) {
		accesoPedidosProveedor.setAtributo(Integer.toString(identificador),
				"estado","0");
		return identificador;
	}

	public int modificaPedido(InterfazTransferPedidos pedido) {
		this.estructuraPedido = new ArrayList<String>();
		this.estructuraPedido.add("identificador");
		this.estructuraPedido.add("idProveedor");
		this.estructuraPedido.add("importe");
		
		for ( int i=0 ; i<pedido.getNumElems()-1 ; i++) {
			this.estructuraPedido.add("idProducto");
			this.estructuraPedido.add("cantidad");
			this.estructuraPedido.add("precioU");
		}
		if ( this.existePedido(pedido.getIdentificador())>0 ) {
			this.accesoPedidos = new AccesoXml("identificador",rutaXML,entidadPedidos,estructuraPedido);
			
			ArrayList<String> datos = new ArrayList<String>();
			datos.add(Integer.toString(pedido.getProveedor()));
			datos.add(Float.toString(pedido.getTotal()));
			for ( int i=0 ; i<pedido.getNumElems() ; i++) {
				datos.add(Integer.toString(pedido.getProducto(i).getIdentificador()));
				datos.add(Integer.toString(pedido.getNumProductos(i)));
				datos.add(Float.toString(pedido.getPrecioProducto(i)));
			}
			accesoPedidos.setAtributo(Integer.toString(pedido.getIdentificador()), datos);
			return pedido.getIdentificador();
		} else
			return -1;
	}

	public InterfazTransferPedidos recuperaPedido(int identificador) {
		ArrayList<String> atributos = accesoPedidosProveedor.getAtributo(Integer.toString(identificador));
		InterfazTransferPedidos pedido = FactoriaTransfers.getInstancia().dameTPedidos();
		if ( atributos == null )return null;
		else if ( Integer.valueOf(atributos.get(2)) == 0 ) {
			pedido.setActivo(false);
		}else pedido.setActivo(true);
		
		InterfazTransferProductos producto;
		atributos = accesoPedidos.getAtributo(Integer.toString(identificador));
		pedido.setIdentificador(Integer.valueOf(atributos.get(0)));
		pedido.setProveedor(Integer.valueOf(atributos.get(1)));
		for (int i=3 ; i<atributos.size() ; i+=3 ) {
			producto = FactoriaTransfers.getInstancia().dameTProductos();
			producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.valueOf(atributos.get(i)));
			pedido.addElementoPedido(producto, Integer.valueOf(atributos.get(i+1)), Float.valueOf(atributos.get(i+2)));
		}
		return pedido;
	}

	public int existePedido(int id) {
		ArrayList<String> atributos = accesoPedidosProveedor.getAtributo(Integer.toString(id));
		if ( atributos == null || Integer.valueOf(atributos.get(2)) == 0 ) {
			return -1;
		}
		return id;
	}
	public int productoPendiente(int id){
		InterfazTransferPedidos pedido;
		InterfazTransferProductos producto;
		for ( int i=1 ; i<=accesoPedidos.numElem() ; i++ ) {
			pedido = this.recuperaPedido(i);
			if ( pedido != null || !pedido.esActivo()) {
				for ( int h=0 ; h<pedido.getNumElems() ; h++ ) {
					producto = pedido.getProducto(h);
					if ( producto.getIdentificador() == id ) return pedido.getIdentificador();
				}
			}
		}
		return 0;
	}
	

}
