package concesionario.integracion.clientes;

import java.util.ArrayList;

import concesionario.integracion.xml.AccesoXml;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteEmpresa;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteNormal;
import concesionario.logica.transferencia.clientes.InterfazTransferClientes;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;

public class DAOClientesImp implements InterfazDAOClientes {

	private AccesoXml accesoClientesNormal;
	private AccesoXml accesoClientesEmpresa;
	private AccesoXml accesoDni;
	private final String rutaXML = "c:\\hlocal\\datos";
	private final String entidadClienteNormal = "clientesNormal";
	private final String entidadClienteEmpresa = "clientesEmpresa";
	private final String entidadDni = "relacionDnis";
	ArrayList<String> estructuraClienteEmpresa;
	ArrayList<String> estructuraClienteNormal;
	ArrayList<String> estructuraDni;
	
	public DAOClientesImp() {
		
		this.estructuraClienteNormal = new ArrayList<String>();
        this.estructuraClienteNormal.add("identificador");
        this.estructuraClienteNormal.add("nombre");
        this.estructuraClienteNormal.add("apellidos");
        this.estructuraClienteNormal.add("DNI");
        this.estructuraClienteNormal.add("direccion");
        this.estructuraClienteNormal.add("telefono");
        this.estructuraClienteNormal.add("email");
        //this.estructuraClienteNormal.add("esEmpresa");
        //this.estructuraClienteNormal.add("descuento");
        this.estructuraClienteNormal.add("activo");
        
        this.estructuraClienteEmpresa = new ArrayList<String>();
        this.estructuraClienteEmpresa.add("identificador");
        this.estructuraClienteEmpresa.add("nombre");
        //this.estructuraClienteEmpresa.add("apellidos");
        this.estructuraClienteEmpresa.add("CIF");
        this.estructuraClienteEmpresa.add("direccion");
        this.estructuraClienteEmpresa.add("telefono");
        this.estructuraClienteEmpresa.add("email");
        //this.estructuraClienteNormal.add("esEmpresa");
        this.estructuraClienteEmpresa.add("descuento");
        this.estructuraClienteEmpresa.add("activo");
        
        this.estructuraDni = new ArrayList<String>();
        this.estructuraDni.add("DNI");
        this.estructuraDni.add("identificador");
	
        this.accesoClientesNormal = new AccesoXml("identificador",rutaXML,entidadClienteNormal,estructuraClienteNormal);
        this.accesoClientesEmpresa = new AccesoXml("identificador",rutaXML,entidadClienteEmpresa,estructuraClienteEmpresa);
        this.accesoDni = new AccesoXml("DNI",rutaXML,entidadDni,estructuraDni);
		
	}
	
	public int eliminaCliente(int identificador) {
		// TODO Auto-generated method stub
		//vemos si es clienteNormal
		ArrayList atributos;
		atributos = accesoClientesNormal.getAtributo(Integer.toString(identificador));
		
		//era un cliente normal
		if(atributos != null){
			accesoClientesNormal.setAtributo(Integer.toString(identificador),"activo","0");
			return 1;
		}else{//buscamos a ver si es una Empresa
			atributos = accesoClientesEmpresa.getAtributo(Integer.toString(identificador));
			//era una empresa
			if(atributos != null){
				accesoClientesEmpresa.setAtributo(Integer.toString(identificador),"activo","0");
				return 1;
			}else{//el identificador no se corresponde con ningun cliente
				return 0;
			}
		}
				
		
	}

	public int existeCliente(int dni) {
		ArrayList atributos = accesoDni.getAtributo(Integer.toString(dni));
		if(atributos == null){
			return 0;
		}else 
			return Integer.valueOf(accesoDni.getAtributo(Integer.toString(dni),"identificador"));
	}

	public int insertaCliente(InterfazTransferClientes cliente) {
		int id = 0;
		//Es empresa
		if(cliente instanceof InterfazTransferClienteEmpresa){
			InterfazTransferClienteEmpresa clienteEmpresa = (InterfazTransferClienteEmpresa)cliente;
			
			//compruebo existe
			ArrayList atributos = accesoDni.getAtributo(Integer.toString(clienteEmpresa.getCIF()));
	        
	        if(atributos == null){//no existe
	    		//Se crea el cliente
	        	id = accesoDni.numElem()+1;
	    		accesoClientesEmpresa.nuevaEntidad(Integer.toString(id));
	    		
	    		ArrayList<String> datoCliente = new ArrayList<String>();
	            datoCliente.add(clienteEmpresa.getNombre());
	            datoCliente.add(Integer.toString(clienteEmpresa.getCIF()));
	            datoCliente.add(clienteEmpresa.getDireccion());
	            datoCliente.add(Integer.toString(clienteEmpresa.getTelefono()));
	            datoCliente.add(clienteEmpresa.getEmail());
	            datoCliente.add(Integer.toString(clienteEmpresa.getDescuento()));
	            datoCliente.add("1");//activo
	        	
	        	//Se crea el CIF
	            accesoDni.nuevaEntidad(Integer.toString(clienteEmpresa.getCIF()));
	            ArrayList<String> datoDni = new ArrayList<String>();
	            datoDni.add(Integer.toString(id));
	        	
	        	//Se instertan los datos en las tablas cliente y dni
	            accesoClientesEmpresa.setAtributo(Integer.toString(id),datoCliente);
	            accesoDni.setAtributo(Integer.toString(clienteEmpresa.getCIF()),datoDni);        
	        }else{//si existe
	        	//recupero su id
	        	id = Integer.valueOf(accesoDni.getAtributo(Integer.toString(clienteEmpresa.getCIF()),"identificador"));
	        	
	        	//Si estaba de baja, le doy el alta
	        	accesoClientesEmpresa.setAtributo(Integer.toString(id),"activo","1");
	        }        
			return id;	
		//es cliente normal
		}else if(cliente instanceof InterfazTransferClienteNormal){
			InterfazTransferClienteNormal clienteNormal = (InterfazTransferClienteNormal)cliente;
			
			//compruebo existe
			ArrayList atributos = accesoDni.getAtributo(Integer.toString(clienteNormal.getDNI()));
	        
	        if(atributos == null){//no existe
	    		//Se crea el cliente
	        	id= accesoDni.numElem()+1;
	        	accesoClientesNormal.nuevaEntidad(Integer.toString(id));
	    		
	    		ArrayList<String> datoCliente = new ArrayList<String>();
	            datoCliente.add(clienteNormal.getNombre());
	            datoCliente.add(clienteNormal.getApellidos());
	            datoCliente.add(Integer.toString(clienteNormal.getDNI()));
	            datoCliente.add(clienteNormal.getDireccion());
	            datoCliente.add(Integer.toString(clienteNormal.getTelefono()));
	            datoCliente.add(clienteNormal.getEmail());
	            datoCliente.add("1");//activo
	        	
	        	//Se crea el Dni
	            accesoDni.nuevaEntidad(Integer.toString(clienteNormal.getDNI()));
	            ArrayList<String> datoDni = new ArrayList<String>();
	            datoDni.add(Integer.toString(id));
	        	
	        	//Se instertan los datos en las tablas cliente y dni
	            accesoClientesNormal.setAtributo(Integer.toString(id),datoCliente);
	            accesoDni.setAtributo(Integer.toString(clienteNormal.getDNI()),datoDni);        
	        }else{//si existe
	        	//recupero su id
	        	id = Integer.valueOf(accesoDni.getAtributo(Integer.toString(clienteNormal.getDNI()),"identificador"));
	        	
	        	//Si estaba de baja, le doy el alta
	        	accesoClientesNormal.setAtributo(Integer.toString(id),"activo","1");
	        }        
			return id;
		}
		return 0;
	}

	public int modificaCliente(InterfazTransferClientes cliente) {
		if(cliente instanceof InterfazTransferClienteEmpresa){
			InterfazTransferClienteEmpresa clienteEmpresa = (InterfazTransferClienteEmpresa)cliente;
			int id = existeCliente(clienteEmpresa.getCIF());
			if(id >0){
				//Carga de datos
				ArrayList<String> datoCliente = new ArrayList<String>();
	            datoCliente.add(clienteEmpresa.getNombre());
	            datoCliente.add(Integer.toString(clienteEmpresa.getCIF()));
	            datoCliente.add(clienteEmpresa.getDireccion());
	            datoCliente.add(Integer.toString(clienteEmpresa.getTelefono()));
	            datoCliente.add(clienteEmpresa.getEmail());
	            datoCliente.add(Integer.toString(clienteEmpresa.getDescuento()));
	            datoCliente.add("1");
	            
	            //modificacion
				accesoClientesEmpresa.setAtributo(Integer.toString(id),datoCliente);
				//salida con exito
				
				return 1;
			}else return 0; //salida con fallo
			
		}else if(cliente instanceof InterfazTransferClienteNormal){
			InterfazTransferClienteNormal clienteNormal = (InterfazTransferClienteNormal)cliente;
			int id = existeCliente(clienteNormal.getDNI());
			if(id >0){
				//Carga de datos
				ArrayList<String> datoCliente = new ArrayList<String>();
	            datoCliente.add(clienteNormal.getNombre());
	            datoCliente.add(clienteNormal.getApellidos());
	            datoCliente.add(Integer.toString(clienteNormal.getDNI()));
	            datoCliente.add(clienteNormal.getDireccion());
	            datoCliente.add(Integer.toString(clienteNormal.getTelefono()));
	            datoCliente.add(clienteNormal.getEmail());
	            datoCliente.add("1");
	            
	            //modificacion
				accesoClientesNormal.setAtributo(Integer.toString(id),datoCliente);
				//salida con exito
				
				return 1;
			}else return 0; //salida con fallo
		}
		return 0;
	}

	public InterfazTransferClientes recuperaCliente(int identificador) {
		
		//vemos si es un cliente normal
		ArrayList<String> atributos = accesoClientesNormal.getAtributo(Integer.toString(identificador));
		if(atributos != null){
			InterfazTransferClienteNormal cliente = (InterfazTransferClienteNormal)FactoriaTransfers.getInstancia().dameTClienteNormal();
			cliente.setIdentificador(Integer.valueOf(atributos.get(0)));
	        cliente.setNombre(atributos.get(1));
	        cliente.setApellidos(atributos.get(2));
	        cliente.setDNI(Integer.valueOf(atributos.get(3)));
	        cliente.setDireccion(atributos.get(4));
	        cliente.setTelefono(Integer.valueOf(atributos.get(5)));
	        cliente.setEmail(atributos.get(6));
			if(Integer.valueOf(atributos.get(7)) == 0)
				cliente.setActivo(false);
			else
				cliente.setActivo(true);
			return cliente;
		}else{//vemos si es una empresa
			atributos = accesoClientesEmpresa.getAtributo(Integer.toString(identificador));
			if(atributos != null){//Es un cliente empresa
				InterfazTransferClienteEmpresa cliente = (InterfazTransferClienteEmpresa)FactoriaTransfers.getInstancia().dameTClienteEmpresa();
				cliente.setIdentificador(Integer.valueOf(atributos.get(0)));
		        cliente.setNombre(atributos.get(1));
		        cliente.setCIF(Integer.valueOf(atributos.get(2)));
		        cliente.setDireccion(atributos.get(3));
		        cliente.setTelefono(Integer.valueOf(atributos.get(4)));
		        cliente.setEmail(atributos.get(5));
		        cliente.setDescuento(Integer.valueOf(atributos.get(6)));
				if(Integer.valueOf(atributos.get(7)) == 0)
					cliente.setActivo(false);
				else
					cliente.setActivo(true);
				return cliente;
			}else//no es cliente de ningun tipo
			return null;
		}
	}
}
