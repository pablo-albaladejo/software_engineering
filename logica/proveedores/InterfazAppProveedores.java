package concesionario.logica.proveedores;

import java.util.ArrayList;

import concesionario.logica.transferencia.proveedores.InterfazTransferProveedores;
import concesionario.logica.transferencia.proveedores.InterfazTransferVinculo;

public interface InterfazAppProveedores {
	public int altaProveedor(InterfazTransferProveedores Proveedor);
	public int bajaProveedor(int id);
	public int modificaProveedor(InterfazTransferProveedores Proveedor);
	public ArrayList<InterfazTransferProveedores> listaProveedores();
	public InterfazTransferProveedores detallesProveedor(int id);
	public int vinculaProveedor(InterfazTransferVinculo vinculo);
	public int desvinculaProveedor(InterfazTransferVinculo vinculo);
	public int buscaProducto(int id);
}
