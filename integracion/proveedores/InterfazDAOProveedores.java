package concesionario.integracion.proveedores;

import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;

public interface InterfazDAOProveedores {
	public int insertaProveedor(InterfazTransferProveedores Proveedor);
	public InterfazTransferProveedores recuperaProveedor(int identificador);
	public int eliminaProveedor(int identificador);
	public int modificaProveedor(InterfazTransferProveedores Proveedor);
	public int existeProveedor(int dni);
	public int vinculaProveedor(int idProveedor, int idProducto,int precio);
	public int desvinculaProveedor(int idProveedor, int idProducto);
	public int productoVinculado(int id);
	/**
	 * Accede al proveedor que tiene el id indicado y establece su estado de activación a 1
	 * @param id Identificador del proveedor
	 * @return 
	 */
	abstract public int activaProveedor(int id);
}
