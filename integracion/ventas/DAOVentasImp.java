/**
 * 
 */
package concesionario.integracion.ventas;

import java.util.ArrayList;
import concesionario.integracion.xml.AccesoXml;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.ventas.InterfazTransferVentas;

/**
 * @author m
 *
 */
public class DAOVentasImp implements InterfazDAOVentas {

	private AccesoXml accesoVentas;
	private AccesoXml accesoVentasCliente;
	private final String rutaXML = "c:\\hlocal\\datos";
	private final String entidadVentas = "ventas";
	private final String entidadVentasCliente = "ventasCliente";
	ArrayList<String> estructuraVenta;
	ArrayList<String> estructuraVentaCliente;
	/* (non-Javadoc)
	 * @see concesionario.integracion.ventas.InterfazDAOVentas#eliminaVenta(concesionario.logica.transferencia.InterfazTransferFactura)
	 */
	public DAOVentasImp(){
		this.estructuraVenta = new ArrayList<String>();
		this.estructuraVentaCliente = new ArrayList<String>();
		this.accesoVentas = new AccesoXml("identificador",rutaXML,entidadVentas,estructuraVenta);
		this.accesoVentasCliente = new AccesoXml("identificador",rutaXML,entidadVentasCliente,estructuraVentaCliente);
	}
	public void eliminaVenta(int id) {
		
			//InterfazTransferVentas venta=recuperaVenta(id);		
			this.accesoVentasCliente.setAtributo(Integer.toString(id),"estado", "baja");
		


	}

	public boolean existeVenta(int id) {
		String estado=(String)(accesoVentasCliente.getAtributo(Integer.toString(id), "estado"));
		try{
			if (estado.contentEquals("alta")){
				return true;
			}
			else{
				return false;
			}
		}
		catch (Exception e){
			return false;
		}

	}
	public void insertaVenta(InterfazTransferVentas venta) {


		this.estructuraVenta.clear();
		this.estructuraVenta.add("identificador");

		for (int i=0;i<venta.getListaCompra().size();i++){
			this.estructuraVenta.add("producto");
			this.estructuraVenta.add("cantidad");

		}

		this.estructuraVentaCliente.add("identificador");
		this.estructuraVentaCliente.add("cliente");
		this.estructuraVentaCliente.add("estado");
		this.estructuraVentaCliente.add("montante");




		int id = accesoVentas.nuevaEntidad();

		ArrayList<String> datos = new ArrayList<String>();
		for (int i=0;i<venta.getListaCompra().size();i++){
			datos.add(venta.getListaCompra().get(i));
			datos.add(venta.getCantidades().get(i));

		}

		this.accesoVentas.setAtributo(Integer.toString(id), datos);
		accesoVentasCliente.nuevaEntidad();
		ArrayList<String> datosCliente = new ArrayList<String>();
		datosCliente.add(Integer.toString(venta.getIdCliente()));
		if (venta.isAlta()){
			datosCliente.add("alta");
		}
		else{
			datosCliente.add("baja");
		}
		datosCliente.add(Float.toString((venta.getMontante())));
		this.accesoVentasCliente.setAtributo(Integer.toString(id), datosCliente);


		
	}

	public void modificaVenta(InterfazTransferVentas venta) {

		this.estructuraVenta.clear();
		this.estructuraVenta.add("identificador");
		for (int i=0;i<venta.getListaCompra().size();i++){
			this.estructuraVenta.add("producto");
			this.estructuraVenta.add("cantidad");

		}
		this.estructuraVentaCliente = new ArrayList<String>();
		this.estructuraVentaCliente.add("identificador");
		this.estructuraVentaCliente.add("cliente");
		this.estructuraVentaCliente.add("estado");
		this.estructuraVentaCliente.add("montante");





		ArrayList<String> datos = new ArrayList<String>();
		datos.add(Integer.toString(venta.getIdCompra()));
		for (int i=0;i<venta.getListaCompra().size();i++){
			datos.add(venta.getListaCompra().get(i));
			datos.add(venta.getCantidades().get(i));
		}
		int id=venta.getIdCompra();
		this.accesoVentas.setAtributo(Integer.toString(id),datos,estructuraVenta);

		ArrayList<String> datosCliente = new ArrayList<String>();
		datosCliente.add(Integer.toString(id));
		datosCliente.add(Integer.toString(venta.getIdCliente()));
		if (venta.isAlta()){
			datosCliente.add("alta");
		}
		else{
			datosCliente.add("baja");
		}
		datosCliente.add(Float.toString((venta.getMontante())));
		this.accesoVentasCliente.setAtributo(Integer.toString(id), datosCliente,estructuraVentaCliente);



		
	}

	/* (non-Javadoc)
	 * @see concesionario.integracion.ventas.InterfazDAOVentas#recuperaVenta(int)
	 */
	@Override
	public InterfazTransferVentas recuperaVenta(int id) {

		if (this.existeVenta(id)){
			InterfazTransferVentas venta=FactoriaTransfers.getInstancia().dameTVentas();
			venta.setIdCompra(id);
			ArrayList<String> datos = new ArrayList<String>();
			ArrayList<String> datosCliente = new ArrayList<String>();
			datos=accesoVentas.getAtributo(Integer.toString(id));
			datosCliente=accesoVentasCliente.getAtributo(Integer.toString(id));
			ArrayList<String> carrito = new ArrayList<String>();
			ArrayList<String> cantidad = new ArrayList<String>();
			datos.remove(0);
			for (int i=0;i<datos.size();i=i+2){
				carrito.add(datos.get(i));
				cantidad.add(datos.get(i+1));
			}

			venta.setListaCompra(carrito);
			venta.setCantidades(cantidad);
			venta.setIdCliente(Integer.valueOf(datosCliente.get(1)));
			venta.setAlta(true);
			venta.setMontante(Float.valueOf(datosCliente.get(3)));

			return venta;
		}
		else{

			return null;
		}

	}

	@Override
	public int numeroVentas() {
		int numeroVentas=accesoVentasCliente.numElem();
		return numeroVentas;
	}











}
