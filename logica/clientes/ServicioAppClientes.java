package concesionario.logica.clientes;

import java.util.ArrayList;

import concesionario.integracion.factoria.FactoriaDAO;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteEmpresa;
import concesionario.logica.transferencia.clientes.InterfazTransferClienteNormal;
import concesionario.logica.transferencia.clientes.InterfazTransferClientes;

public class ServicioAppClientes implements InterfazAppClientes {
	
	public ServicioAppClientes(){
		
	}

	public int altaCliente(InterfazTransferClientes cliente) {
		int id;
		if ( cliente instanceof InterfazTransferClienteNormal ) {
			id = FactoriaDAO.getInstancia().dameDAOClientes().existeCliente(((InterfazTransferClienteNormal)cliente).getDNI());
		} else {
			id = FactoriaDAO.getInstancia().dameDAOClientes().existeCliente(((InterfazTransferClienteEmpresa)cliente).getCIF());
		}
		//comprobamos el estado del cliente a traves de su id
		if ( id == 0 ) {
			id = FactoriaDAO.getInstancia().dameDAOClientes().insertaCliente(cliente);
		} else {
			cliente = FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(id);
			if ( cliente.getActivo() ) return -id;
			else
				id = FactoriaDAO.getInstancia().dameDAOClientes().insertaCliente(cliente);
		}
		return id;
	}

	public int bajaCliente(int identificador) {
		int id;
		id = FactoriaDAO.getInstancia().dameDAOClientes().eliminaCliente(identificador);
		return id;
	}
	
	public int modificaCliente(InterfazTransferClientes cliente) {
		int id;
		id = FactoriaDAO.getInstancia().dameDAOClientes().modificaCliente(cliente);
		return id;
	}

	public ArrayList<InterfazTransferClientes> listaClientes() {
		int indice = 1;
		ArrayList<InterfazTransferClientes> lista = new ArrayList<InterfazTransferClientes>();
		InterfazTransferClientes cliente = FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(indice);
		while ( cliente != null ) {
			if ( cliente.getActivo() ) {
				lista.add(cliente);
			}
			indice++;
			cliente = FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(indice);
		}
		return lista;
	}

	public InterfazTransferClientes detallesCliente(int id) {
		InterfazTransferClientes cliente = FactoriaDAO.getInstancia().dameDAOClientes().recuperaCliente(id);
		if ( cliente != null && cliente.getActivo() )
			return cliente;
		else return null;
	}
}
