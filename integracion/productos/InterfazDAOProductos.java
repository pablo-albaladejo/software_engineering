package concesionario.integracion.productos;

import concesionario.logica.transferencia.productos.InterfazTransferProductos;

public interface InterfazDAOProductos {
	/**
	 * Comprueba el tipo de veh�culo que recibe,crea un nuevo registro en base de datos para el producto recibido y lo da de
	 * alta en su lugar apropiado, generando un �ndice �nico para todos los tipos de producto.
	 * Adem�s, crea nuevas entradas en sendos ficheros de �ndices, donde la clave principal es la combinaci�n
	 * de marca y modelo en uno, y el identificador en el otro. El primero nos servir� para comprobar si un modelo ya existe 
	 * e impedir duplicados, y el segundo nos permitir� saber de qu� tipo es un producto dado su identificador, para agilizar
	 * las b�squedas.
	 * @param producto Datos del producto a insertar
	 * @return Identificador del producto
	 */
	public int insertaProducto(InterfazTransferProductos producto);
	/**
	 * Accede al registro de un producto, dados su identificador y su tipo, y lo marca como no activo (0).
	 * @param identificador Identificador del producto
	 * @param tipo Tipo de producto
	 * @return	Identificador del producto
	 */
	public int eliminaProducto(int identificador,String tipo);
	/**
	 * Recupera el registro de producto cuyo identificador es el proporcionado. Busca el tipo adecuado de producto en el
	 * �ndice y recupera el registro de la tabla correspondiente al tipo
	 * @param identificador Identificador del producto
	 * @return Datos del producto
	 */
	public InterfazTransferProductos recuperaProducto(int identificador);
	/**
	 * Comprueba el tipo de veh�culo y accede a la tabla correspondiente, sustituyendo los datos existentes por los recibidos
	 * @param producto Datos nuevos del producto
	 * @return  Identificador del producto
	 */
	public int modificaProducto(InterfazTransferProductos producto);
	/**
	 * Comprueba en la tabla de �ndices si existe el identificador recibido
	 * @param id Identificador del producto	
	 * @return   Valor l�gico que indica si existe el �ndice o no
	 */
	public boolean existeProducto(int id);
	/**
	 * Comprueba si la combinaci�n de marca y modelo ya ha sido introducida en la base de datos, para impedir productos 
	 * duplicados. 
	 * @param modelo Combinaci�n de marca y modelo
	 * @return	Identificador del producto si se encuentra, 0 si no.
	 */
	public int existeModelo(String modelo);
	/**
	 * Accede a la tabla de �ndices por el identificador y recupera el tipo de producto asociado.
	 * @param id Identificador de producto
	 * @return Tipo del producto, o null si no se encuentra
	 */
	public String tipoProducto(int id);
	/**
	 * Accede a la tabla indicada en tipo, al producto cuyo identificador es id, y establece su estado a "1" (activo)
	 * @param id Identificador del producto
	 * @param tipo Tipo del producto
	 * @return	Identificador del producto
	 */
	public int activaProducto(int id,String tipo);
}
