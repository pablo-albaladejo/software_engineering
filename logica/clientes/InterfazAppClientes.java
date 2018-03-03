package concesionario.logica.clientes;

import java.util.ArrayList;

import concesionario.logica.transferencia.clientes.InterfazTransferClientes;

public interface InterfazAppClientes {
	/**
	 * Función que da de alta a un cliente
	 * @param cliente Transfer del cliente ha dar de alta
	 * @return Identificador del cliente insertado o un número negativo que es el identificador si ya estaba dado de alta.
	 */
	public int altaCliente(InterfazTransferClientes cliente);
	/**
	 * Da de baja un cliente.
	 * @param id Id del cliente a dar de baja.
	 * @return Devuelve 1 en caso de baja correcta o 0 en caso de no existir.
	 */
	public int bajaCliente(int id);
	/**
	 * Modifica un cliente.
	 * @param cliente Cliente a modificar.
	 * @return Devuelve 1 en caso de éxito o 0 en caso de fallo.
	 */
	public int modificaCliente(InterfazTransferClientes cliente);
	/**
	 * Función que obtiene la lista de clientes.
	 * @return Lista de clientes.
	 */
	public ArrayList<InterfazTransferClientes> listaClientes();
	/**
	 * Obtiene los detalles de un cliente
	 * @param id Id del cliente a obtener.
	 * @return Devuelve el transfer del cliente o null en caso de no existir o estar dado de baja.
	 */
	public InterfazTransferClientes detallesCliente(int id);
}
