package concesionario.integracion.pedidos;

import concesionario.logica.transferencia.pedidos.InterfazTransferPedidos;

public interface InterfazDAOPedidos {
	public int insertaPedido(InterfazTransferPedidos pedido);
	public int eliminaPedido(int identificador);
	public InterfazTransferPedidos recuperaPedido(int identificador);
	public int modificaPedido(InterfazTransferPedidos pedido);
	public int existePedido(int id);
	public int productoPendiente(int id);
}

