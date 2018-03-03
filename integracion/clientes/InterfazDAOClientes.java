package concesionario.integracion.clientes;

import concesionario.logica.transferencia.clientes.InterfazTransferClientes;

public interface InterfazDAOClientes {
	public int insertaCliente(InterfazTransferClientes cliente);
	public InterfazTransferClientes recuperaCliente(int identificador);
	public int eliminaCliente(int identificador);
	public int modificaCliente(InterfazTransferClientes cliente);
	public int existeCliente(int dni);
}
