package concesionario.integracion.proveedores;

import java.util.ArrayList;


import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.integracion.xml.AccesoXml;
import concesionario.logica.transferencia.factoria.FactoriaTransfers;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;

public class DAOProveedoresImp implements InterfazDAOProveedores {

	private AccesoXml accesoProveedores;
	private AccesoXml accesoCif;
	private AccesoXml accesoRelacion;
	private final String rutaXML = "c:\\hlocal\\datos";
	private final String entidadProveedor = "proveedores";
	private final String entidadCif = "relacionCifs";
	private final String entidadRelacion = "relacionProveedores";
	ArrayList<String> estructuraProveedor;
	ArrayList<String> estructuraCif;
	ArrayList<String> estructuraRelacion;
	
	public DAOProveedoresImp() {
        
        this.estructuraProveedor = new ArrayList<String>();
        this.estructuraProveedor.add("identificador");
        this.estructuraProveedor.add("nombre");
        this.estructuraProveedor.add("CIF");
        this.estructuraProveedor.add("direccion");
        this.estructuraProveedor.add("telefono");
        this.estructuraProveedor.add("email");
        this.estructuraProveedor.add("activo");
        
        this.estructuraCif = new ArrayList<String>();
        this.estructuraCif.add("CIF");
        this.estructuraCif.add("identificador");
	
        this.estructuraRelacion = new ArrayList<String>();
        this.estructuraRelacion.add("identificador");
        
        this.accesoProveedores = new AccesoXml("identificador",rutaXML,entidadProveedor,estructuraProveedor);
        this.accesoCif = new AccesoXml("CIF",rutaXML,entidadCif,estructuraCif);
		this.accesoRelacion = new AccesoXml("identificador",rutaXML,entidadRelacion,estructuraRelacion);
	}
	
	public int eliminaProveedor(int identificador) {

		ArrayList atributos;
		atributos = accesoProveedores.getAtributo(Integer.toString(identificador));
		
		if(atributos != null) {
			accesoProveedores.setAtributo(Integer.toString(identificador),"activo","0");
			return 1;
		} else {
			return 0;
		}
	}

	public int existeProveedor(int dni) {
		ArrayList atributos = accesoCif.getAtributo(Integer.toString(dni));
		if(atributos == null){
			return 0;
		}else 
			return Integer.valueOf(accesoCif.getAtributo(Integer.toString(dni),"identificador"));
	}

	public int insertaProveedor(InterfazTransferProveedores proveedor) {
		int id = 0;
			
			id = accesoCif.numElem()+1;
    		accesoProveedores.nuevaEntidad(Integer.toString(id));
    		
    		ArrayList<String> datoProveedor = new ArrayList<String>();
            datoProveedor.add(proveedor.getNombre());
            datoProveedor.add(Integer.toString(proveedor.getCIF()));
            datoProveedor.add(proveedor.getDireccion());
            datoProveedor.add(Integer.toString(proveedor.getTelefono()));
            datoProveedor.add(proveedor.getEmail());
            datoProveedor.add("1");//activo
        	
        	//Se crea el CIF
            accesoCif.nuevaEntidad(Integer.toString(proveedor.getCIF()));
            ArrayList<String> datoDni = new ArrayList<String>();
            datoDni.add(Integer.toString(id));
            
            //Se crea la relacion del proveedor con los producctos
            accesoRelacion.nuevaEntidad();
        	
        	//Se instertan los datos en las tablas Proveedor y cif
            accesoProveedores.setAtributo(Integer.toString(id),datoProveedor);
            accesoCif.setAtributo(Integer.toString(proveedor.getCIF()),datoDni);
            
       return id;
	}

	public int modificaProveedor(InterfazTransferProveedores proveedor) {
		int id = existeProveedor(proveedor.getCIF());
		if(id >0){
			//Carga de datos
			ArrayList<String> datoProveedor = new ArrayList<String>();
            datoProveedor.add(proveedor.getNombre());
            datoProveedor.add(Integer.toString(proveedor.getCIF()));
            datoProveedor.add(proveedor.getDireccion());
            datoProveedor.add(Integer.toString(proveedor.getTelefono()));
            datoProveedor.add(proveedor.getEmail());
            datoProveedor.add("1");
            
            //modificacion
			accesoProveedores.setAtributo(Integer.toString(id),datoProveedor);
			//salida con exito
			
			return 1;
		}else return 0; //salida con fallo
	}

	public InterfazTransferProveedores recuperaProveedor(int identificador) {
		
		ArrayList<String> atributos = accesoProveedores.getAtributo(Integer.toString(identificador));
		if(atributos != null){
			InterfazTransferProveedores Proveedor = (InterfazTransferProveedores)FactoriaTransfers.getInstancia().dameTProveedor();
			Proveedor.setIdentificador(Integer.valueOf(atributos.get(0)));
	        Proveedor.setNombre(atributos.get(1));
	        Proveedor.setCIF(Integer.valueOf(atributos.get(2)));
	        Proveedor.setDireccion(atributos.get(3));
	        Proveedor.setTelefono(Integer.valueOf(atributos.get(4)));
	        Proveedor.setEmail(atributos.get(5));
			if(Integer.valueOf(atributos.get(6)) == 0)
				Proveedor.setActivo(false);
			else
				Proveedor.setActivo(true);
			ArrayList<String> productos = accesoRelacion.getAtributo(Integer.toString(identificador));
			ArrayList<InterfazTransferProductos> listaProductos = new ArrayList<InterfazTransferProductos>();
			for(int i =1;i<productos.size();i=i+2){
				String idProducto = productos.get(i);
				String precio = productos.get(i+1);
				InterfazTransferProductos producto = FactoriaDAO.getInstancia().dameDAOProductos().recuperaProducto(Integer.parseInt(idProducto));
				producto.setPrecio(Float.valueOf(precio.trim()).floatValue());
				listaProductos.add(producto);
			}
			Proveedor.setListaProductos(listaProductos);
			return Proveedor;
		}else
		return null;
	}

	public int vinculaProveedor(int idProveedor, int idProducto,int precio) {
		ArrayList<String> productos = accesoRelacion.getAtributo(Integer.toString(idProveedor));
		boolean encontrado = false;
		for(int i = 0;(i<productos.size()-1)&&!encontrado;i=i+2){
			String id = productos.get(i+1);
			//String valor = productos.get(i+2);
			if(Integer.valueOf(id) == idProducto) encontrado = true;
		}
		if(encontrado == false){//el producto no estaba vinculado al proveedor
			ArrayList<String> estructura = new ArrayList<String>();
			estructura.add("identificador");
			for(int i = 0;i<productos.size();i=i+2){
				estructura.add("producto");
				estructura.add("precio");
			}
			productos.add(Integer.toString(idProducto));
			productos.add(Integer.toString(precio));
			accesoRelacion.setAtributo(Integer.toString(idProveedor),productos, estructura);
			return 1;
		}else return -1;
	}
	public int desvinculaProveedor(int idProveedor, int idProducto) {
		ArrayList<String> productos = accesoRelacion.getAtributo(Integer.toString(idProveedor));
		boolean encontrado = false;
		for(int i = 0;(i<productos.size()-1)&&!encontrado;i=i+2){
			String id = productos.get(i+1);
			//String valor = productos.get(i+2);
			if(Integer.valueOf(id) == idProducto){ 
				encontrado = true;
				productos.remove(i+1);//quitamos el id
				productos.remove(i+1);// y el precio
			}
		}
		if(encontrado == true){//si estaba vinculado
			ArrayList<String> estructura = new ArrayList<String>();
			estructura.add("identificador");
			for(int i = 0;i<productos.size()-1;i=i+2){
				estructura.add("producto");
				estructura.add("precio");
			}
			accesoRelacion.setAtributo(Integer.toString(idProveedor),productos, estructura);
			return 1;
		}else return 0; //error de proveedor
	}
	public int productoVinculado(int id){ //devuelve el id del proveedor al que está vinculado,0 si no se encuentra
		int i=1;
		boolean enc=false;
		ArrayList<InterfazTransferProductos> lista;
		InterfazTransferProveedores proveedor=this.recuperaProveedor(i);
		while(proveedor!=null&&!enc){
			 lista=proveedor.getListaProductos();
			 if(buscaEnLista(lista,id))
				 enc=true;
			 else{
				 i++;
				 proveedor=this.recuperaProveedor(i);
			 }
		}
		if(enc)
			return i;
		else
			return 0;
	}
	public boolean buscaEnLista(ArrayList<InterfazTransferProductos>lista,int id){//compara el id con todos los productos vinculados
		int i=0;
		boolean enc=false;
		InterfazTransferProductos producto;
		while(i<=(lista.size()-1)&&!enc){
			producto=lista.get(i);
			if(producto.getIdentificador()==id)
				return true;
			else
				i++;
		}	
		return false;	
	}
	public int activaProveedor(int id){
		accesoProveedores.setAtributo(Integer.toString(id),"activo","1");
		return id;
	}
}
