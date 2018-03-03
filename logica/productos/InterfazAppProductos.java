package concesionario.logica.productos;
import concesionario.logica.transferencia.productos.InterfazTransferProductos;
import java.util.ArrayList;

public interface InterfazAppProductos {
	/**
	 * Comprueba si el producto recibido ya existe en base de datos. Si no es as�, llama al DAOProductos para que haga la
	 * inserci�n. Si existe el modelo, comprueba su estado. En caso de estar no activo, llama al DAOProductos para que lo
	 * active. Si ya estaba activo devuelve el identificador del producto, y no se introduce ni se actualiza ning�n registro
	 * en base de datos.
	 * @param producto Datos del producto
	 * @return Devuelve el identificador del producto.
	 */
	public int altaProducto(InterfazTransferProductos producto);
	/**
	 * Comprueba si el identificador recibido ya existe en base de datos. Si no existe, devuelve 0. Si existe, y est� activo,
	 * llama a DAOProductos para que lo marque como no activo. Si existe pero no estaba activo, devuelve 0.
	 * @param id Identificador del producto
	 * @return Devuelve el identificador si ha tenido �xito, 0 en caso de error
	 */
	public int bajaProducto(int id);
	/**
	 * Comprueba que la combinaci�n de modelo y marca del producto recibido (los datos nuevos del producto) ya exista en
	 * base de datos. Si es as�, se llama a DAOProductos para que modifique el registro. Si no existe, devuelve 0. 
	 * @param producto Nuevos datos del producto
	 * @return Devuelve el identificador de producto si ha tenido �xito, 0 en caso de error
	 */
	public int modificaProducto(InterfazTransferProductos producto);
	/**
	 * Genera una lista de todos los productos activos pidiendo productos a DAOProductos
	 * @return Devuelve un ArrayList que contiene todos los productos dados con estado activo
	 */
	public ArrayList<InterfazTransferProductos> listaProductos();
	/**
	 * Comprueba que el identificador de producto existe, y pide el producto a DAOProductos. Si la operaci�n tiene �xito, se 
	 * devuelve el producto, en caso contrario se devuelve null.
	 * @param id Identificador del producto
	 * @return	Datos del producto
	 */
	public InterfazTransferProductos detallesProducto(int id);
}
