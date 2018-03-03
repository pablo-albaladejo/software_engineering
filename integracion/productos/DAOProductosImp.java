package concesionario.integracion.productos;

import java.util.ArrayList;

import concesionario.integracion.xml.AccesoXml;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.productos.InterfazTransferTurismos;
import concesionario.logica.transferencia.productos.InterfazTransferMotos;
import concesionario.logica.transferencia.productos.InterfazTransferComerciales;


public class DAOProductosImp implements InterfazDAOProductos {

	private AccesoXml accesoProductosTurismo;
	private AccesoXml accesoProductosMoto;
	private AccesoXml accesoProductosComercial;
	private AccesoXml accesoProductosIndex;
	private AccesoXml accesoProductosModelo;
	private final String rutaXML = "c:\\hlocal\\datos";
	private final String entidadProductoTurismo = "productosTurismo";
	private final String entidadProductoMoto = "productosMoto";
	private final String entidadProductoComercial = "productosComercial";
	private final String entidadProductosIndex= "productosIndex";
	private final String entidadProductosModelo= "productosModelo";
	ArrayList<String> estructuraProductoTurismo;
	ArrayList<String> estructuraProductoMoto;
	ArrayList<String> estructuraProductoComercial;	
	ArrayList<String> estructuraProductosIndex;
	ArrayList<String> estructuraProductosModelo;
	
	public DAOProductosImp(){
		this.estructuraProductoTurismo=new ArrayList<String>();
		this.estructuraProductoTurismo.add("identificador");
		this.estructuraProductoTurismo.add("marca");
		this.estructuraProductoTurismo.add("modelo");
		this.estructuraProductoTurismo.add("año");
		this.estructuraProductoTurismo.add("precio");
		this.estructuraProductoTurismo.add("cilindrada");
		this.estructuraProductoTurismo.add("existencias");
		this.estructuraProductoTurismo.add("puertas");
		this.estructuraProductoTurismo.add("plazas");
		this.estructuraProductoTurismo.add("chasis");
		this.estructuraProductoTurismo.add("cambio");
		this.estructuraProductoTurismo.add("activo");
		
		this.estructuraProductoMoto=new ArrayList<String>();
		this.estructuraProductoMoto.add("identificador");
		this.estructuraProductoMoto.add("marca");
		this.estructuraProductoMoto.add("modelo");
		this.estructuraProductoMoto.add("año");
		this.estructuraProductoMoto.add("precio");
		this.estructuraProductoMoto.add("cilindrada");
		this.estructuraProductoMoto.add("existencias");
		this.estructuraProductoMoto.add("tipo");
		this.estructuraProductoMoto.add("arranque");
		this.estructuraProductoMoto.add("embrague");
		this.estructuraProductoMoto.add("activo");
		
		this.estructuraProductoComercial=new ArrayList<String>();
		this.estructuraProductoComercial.add("identificador");
		this.estructuraProductoComercial.add("marca");
		this.estructuraProductoComercial.add("modelo");
		this.estructuraProductoComercial.add("año");
		this.estructuraProductoComercial.add("precio");
		this.estructuraProductoComercial.add("cilindrada");
		this.estructuraProductoComercial.add("existencias");
		this.estructuraProductoComercial.add("capacidad");
		this.estructuraProductoComercial.add("volumen");
		this.estructuraProductoComercial.add("puertas");
		this.estructuraProductoComercial.add("activo");
		
		this.estructuraProductosIndex=new ArrayList<String>();
		this.estructuraProductosIndex.add("identificador");
		this.estructuraProductosIndex.add("tipoproducto");
		
		this.estructuraProductosModelo=new ArrayList<String>();
		this.estructuraProductosModelo.add("modelo");
		this.estructuraProductosModelo.add("identificador");
		
		this.accesoProductosTurismo= new AccesoXml("identificador",rutaXML,entidadProductoTurismo,estructuraProductoTurismo);
		this.accesoProductosMoto= new AccesoXml("identificador",rutaXML,entidadProductoMoto,estructuraProductoMoto);
		this.accesoProductosComercial= new AccesoXml("identificador",rutaXML,entidadProductoComercial,estructuraProductoComercial);
		this.accesoProductosIndex= new AccesoXml("identificador",rutaXML,entidadProductosIndex,estructuraProductosIndex);
		this.accesoProductosModelo= new AccesoXml("modelo",rutaXML,entidadProductosModelo,estructuraProductosModelo);
	}
	
	
	
	public int eliminaProducto(int identificador,String tipo) {
			if(tipo.equalsIgnoreCase("turismo")){
				this.accesoProductosTurismo.setAtributo(Integer.toString(identificador), "activo", "0");
			}else if (tipo.equalsIgnoreCase("moto")){
				this.accesoProductosMoto.setAtributo(Integer.toString(identificador), "activo", "0");
			}else if(tipo.equalsIgnoreCase("comercial")){
				this.accesoProductosComercial.setAtributo(Integer.toString(identificador), "activo", "0");
			}else
				return 0;
			return 1;
		}
		

	public int insertaProducto(InterfazTransferProductos producto) {
		int id=0;
		if (producto instanceof InterfazTransferTurismos){
			InterfazTransferTurismos turismo=(InterfazTransferTurismos)producto;
			
				id=accesoProductosIndex.numElem()+1;
				accesoProductosTurismo.nuevaEntidad(Integer.toString(id));
				ArrayList<String>datoturismo=new ArrayList<String>();
				datoturismo.add(turismo.getMarca());
				datoturismo.add(turismo.getModelo());
				datoturismo.add(Integer.toString(turismo.getAño()));
				datoturismo.add(Float.toString(turismo.getPrecio()));
				datoturismo.add(turismo.getCilindrada());
				datoturismo.add(Integer.toString(turismo.getExistencias()));
				datoturismo.add(Integer.toString(turismo.getPuertas()));
				datoturismo.add(Integer.toString(turismo.getPlazas()));
				datoturismo.add(turismo.getChasis());
				datoturismo.add(turismo.getCambio());
				datoturismo.add("1");
				accesoProductosIndex.nuevaEntidad(Integer.toString(id));
				ArrayList<String> datoIndex=new ArrayList<String>();
				datoIndex.add("turismo");
				accesoProductosModelo.nuevaEntidad(turismo.getMarca()+turismo.getModelo());
				ArrayList<String>datoModelo=new ArrayList<String>();
				datoModelo.add(Integer.toString(id));
				accesoProductosModelo.setAtributo(turismo.getMarca()+turismo.getModelo(),datoModelo);
				accesoProductosIndex.setAtributo(Integer.toString(id),datoIndex);
				accesoProductosTurismo.setAtributo(Integer.toString(id), datoturismo);
			
			}else if(producto instanceof InterfazTransferMotos){
			InterfazTransferMotos moto=(InterfazTransferMotos)producto;
				id=accesoProductosIndex.numElem()+1;
				accesoProductosMoto.nuevaEntidad(Integer.toString(id));
				ArrayList<String>datomoto=new ArrayList<String>();
				datomoto.add(moto.getMarca());
				datomoto.add(moto.getModelo());
				datomoto.add(Integer.toString(moto.getAño()));
				datomoto.add(Float.toString(moto.getPrecio()));
				datomoto.add(moto.getCilindrada());
				datomoto.add(Integer.toString(moto.getExistencias()));
				datomoto.add(moto.getTipo());
				datomoto.add(moto.getArranque());
				datomoto.add(moto.getEmbrague());
				datomoto.add("1");
				accesoProductosIndex.nuevaEntidad(Integer.toString(id));
				ArrayList<String>datoIndex=new ArrayList<String>();
				datoIndex.add("moto");
				accesoProductosModelo.nuevaEntidad(moto.getMarca()+moto.getModelo());
				ArrayList<String>datoModelo=new ArrayList<String>();
				datoModelo.add(Integer.toString(id));
				accesoProductosModelo.setAtributo(moto.getMarca()+moto.getModelo(),datoModelo);
				accesoProductosIndex.setAtributo(Integer.toString(id), datoIndex);
				accesoProductosMoto.setAtributo(Integer.toString(id), datomoto);
				return id;
			
			}else{
				InterfazTransferComerciales comercial=(InterfazTransferComerciales)producto;
				id=existeModelo(producto.getMarca()+producto.getModelo());
				id=accesoProductosIndex.numElem()+1;
				accesoProductosComercial.nuevaEntidad(Integer.toString(id));
				ArrayList<String>datocomercial=new ArrayList<String>();
				datocomercial.add(comercial.getMarca());
				datocomercial.add(comercial.getModelo());
				datocomercial.add(Integer.toString(comercial.getAño()));
				datocomercial.add(Float.toString(comercial.getPrecio()));
				datocomercial.add(comercial.getCilindrada());
				datocomercial.add(Integer.toString(comercial.getExistencias()));
				datocomercial.add(Integer.toString(comercial.getCapcarga()));
				datocomercial.add(Integer.toString(comercial.getVolutil()));
				datocomercial.add(Integer.toString(comercial.getPuertas()));
				datocomercial.add("1");
				accesoProductosIndex.nuevaEntidad(Integer.toString(id));
				ArrayList<String>datoIndex=new ArrayList<String>();
				datoIndex.add("comercial");
				accesoProductosModelo.nuevaEntidad(comercial.getMarca()+comercial.getModelo());
				ArrayList<String>datoModelo=new ArrayList<String>();
				datoModelo.add(Integer.toString(id));
				accesoProductosModelo.setAtributo(comercial.getMarca()+comercial.getModelo(),datoModelo);
				accesoProductosIndex.setAtributo(Integer.toString(id), datoIndex);
				accesoProductosComercial.setAtributo(Integer.toString(id), datocomercial);
				return id;
			
		}
		return id;
	}
	public int activaProducto(int id,String tipo){
		if (tipo.equalsIgnoreCase("turismo")){
			accesoProductosTurismo.setAtributo(Integer.toString(id),"activo" , "1");
			return id;
		}else if(tipo.equalsIgnoreCase("moto")){
			accesoProductosMoto.setAtributo(Integer.toString(id),"activo" , "1");
			return id;
		}else{
			accesoProductosComercial.setAtributo(Integer.toString(id),"activo" , "1");
			return id;
		}
	}

	public int modificaProducto(InterfazTransferProductos producto) {
		if(producto instanceof InterfazTransferTurismos){
				InterfazTransferTurismos turismo= (InterfazTransferTurismos)producto;
				int id = turismo.getIdentificador();
				//Carga de datos
				ArrayList<String> datoturismo = new ArrayList<String>();
				datoturismo.add(turismo.getMarca());
				datoturismo.add(turismo.getModelo());
				datoturismo.add(Integer.toString(turismo.getAño()));
				datoturismo.add(Float.toString(turismo.getPrecio()));
				datoturismo.add(turismo.getCilindrada());
				datoturismo.add(Integer.toString(turismo.getExistencias()));
				datoturismo.add(Integer.toString(turismo.getPuertas()));
				datoturismo.add(Integer.toString(turismo.getPlazas()));
				datoturismo.add(turismo.getChasis());
				datoturismo.add(turismo.getCambio());
				if(turismo.getActivo()==true)
					datoturismo.add("1");
				else
					datoturismo.add("0");
	            //modificacion
				
				//buscar el registro antiguo para obtener modelo y marca antiguos y hacer el cambio en productosModelo
 				accesoProductosTurismo.setAtributo(Integer.toString(id),datoturismo);
				//salida con exito
				
				return 1;
		}else if(producto instanceof InterfazTransferMotos){
			InterfazTransferMotos moto=(InterfazTransferMotos)producto;
			int id=moto.getIdentificador();
			ArrayList<String>datomoto=new ArrayList<String>();
			datomoto.add(moto.getMarca());
			datomoto.add(moto.getModelo());
			datomoto.add(Integer.toString(moto.getAño()));
			datomoto.add(Float.toString(moto.getPrecio()));
			datomoto.add(moto.getCilindrada());
			datomoto.add(Integer.toString(moto.getExistencias()));
			datomoto.add(moto.getTipo());
			datomoto.add(moto.getArranque());
			datomoto.add(moto.getEmbrague());
			if(moto.getActivo())
				datomoto.add("1");
			else
				datomoto.add("0");
			accesoProductosMoto.setAtributo(Integer.toString(id), datomoto);
			return 1;
		}else{
			InterfazTransferComerciales comercial=(InterfazTransferComerciales)producto;
			int id=comercial.getIdentificador();
			ArrayList<String>datocomercial=new ArrayList<String>();
			datocomercial.add(comercial.getMarca());
			datocomercial.add(comercial.getModelo());
			datocomercial.add(Integer.toString(comercial.getAño()));
			datocomercial.add(Float.toString(comercial.getPrecio()));
			datocomercial.add(comercial.getCilindrada());
			datocomercial.add(Integer.toString(comercial.getExistencias()));
			datocomercial.add(Integer.toString(comercial.getCapcarga()));
			datocomercial.add(Integer.toString(comercial.getVolutil()));
			datocomercial.add(Integer.toString(comercial.getPuertas()));
			if (comercial.getActivo())
				datocomercial.add("1");
			else
				datocomercial.add("0");
			accesoProductosComercial.setAtributo(Integer.toString(id), datocomercial);
			return 1;
			
		}
	}

	public InterfazTransferProductos recuperaProducto(int identificador) {
		ArrayList<String> atributos = this.accesoProductosIndex.getAtributo(Integer.toString(identificador));
		if (atributos!=null){
			String tipo=atributos.get(1);
			if(tipo.equalsIgnoreCase("turismo")){
				atributos=accesoProductosTurismo.getAtributo(Integer.toString(identificador));
				InterfazTransferTurismos turismo = (InterfazTransferTurismos)FactoriaTransfers.getInstancia().dameTProductoTurismo();
				turismo.setIdentificador(Integer.valueOf(atributos.get(0)));
		        turismo.setMarca(atributos.get(1));
		        turismo.setModelo(atributos.get(2));
		        turismo.setAño(Integer.valueOf(atributos.get(3)));
		        turismo.setPrecio(Float.valueOf(atributos.get(4)));
		        turismo.setCilindrada(atributos.get(5));
		        turismo.setExistencias(Integer.valueOf(atributos.get(6)));
		        turismo.setPuertas(Integer.valueOf(atributos.get(7)));
		        turismo.setPlazas(Integer.valueOf(atributos.get(8)));
		        turismo.setChasis(atributos.get(9));
		        turismo.setCambio(atributos.get(10));
		        if(Integer.valueOf(atributos.get(11))==0)
		        	turismo.setActivo(false);
		        else
		        	turismo.setActivo(true);
		        return turismo;
			}
			if (tipo.equalsIgnoreCase("moto")){
				atributos = accesoProductosMoto.getAtributo(Integer.toString(identificador));
				InterfazTransferMotos moto = (InterfazTransferMotos)FactoriaTransfers.getInstancia().dameTProductoMoto();
				moto.setIdentificador(Integer.valueOf(atributos.get(0)));
			    moto.setMarca(atributos.get(1));
			    moto.setModelo(atributos.get(2));
			    moto.setAño(Integer.valueOf(atributos.get(3)));
			    moto.setPrecio(Float.valueOf(atributos.get(4)));
			    moto.setCilindrada(atributos.get(5));
			    moto.setExistencias(Integer.valueOf(atributos.get(6)));
				moto.setTipo(atributos.get(7));
				moto.setArranque(atributos.get(8));
				moto.setEmbrague(atributos.get(9));
				if(Integer.valueOf(atributos.get(10))==0)
					moto.setActivo(false);
				else
					moto.setActivo(true);
				return moto;
			}
			if(tipo.equalsIgnoreCase("comercial")){
					atributos = accesoProductosComercial.getAtributo(Integer.toString(identificador));
					InterfazTransferComerciales comercial = (InterfazTransferComerciales)FactoriaTransfers.getInstancia().dameTProductoComercial();
					comercial.setIdentificador(Integer.valueOf(atributos.get(0)));
				    comercial.setMarca(atributos.get(1));
				    comercial.setModelo(atributos.get(2));
				    comercial.setAño(Integer.valueOf(atributos.get(3)));
				    comercial.setPrecio(Float.valueOf(atributos.get(4)));
				    comercial.setCilindrada(atributos.get(5));
				    comercial.setExistencias(Integer.valueOf(atributos.get(6)));
					comercial.setCapcarga(Integer.valueOf((atributos.get(7))));
					comercial.setVolutil(Integer.valueOf((atributos.get(8))));
					comercial.setPuertas(Integer.valueOf((atributos.get(9))));
					if(Integer.valueOf(atributos.get(10))==0)
						comercial.setActivo(false);
					else
						comercial.setActivo(true);
				    return comercial;
			}else return null;
		}else return null;
	}
	public boolean existeProducto(int id){
		if (this.accesoProductosIndex.getAtributo(Integer.toString(id),"identificador")==null)
			return false;
		else 
			return true;
	}
	public int existeModelo(String modelo){
		ArrayList<String> atributos = accesoProductosModelo.getAtributo(modelo);
		if(atributos == null){
			return 0;
		}else 
			return Integer.valueOf(accesoProductosModelo.getAtributo(modelo,"identificador"));
	}
	
	public String tipoProducto(int id){
		ArrayList<String> atributos;
		atributos = this.accesoProductosIndex.getAtributo(Integer.toString(id));
		return atributos.get(1);
	}
}