package concesionario.presentacion.productos;

public abstract class GUIProductos {
	static private GUIProductos instancia;
	public GUIProductos(){
		
	}
	static public GUIProductos getInstancia(){
		if(instancia==null) instancia=new GUIProductosImp();
		return instancia;
	}
	abstract public void actualiza(int evento,Object datos); 
}
