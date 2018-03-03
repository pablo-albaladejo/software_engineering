package com.concesionario.logica.transferencia.ventas;

import java.util.ArrayList;
/**
 * @author carlos
 *
 */
public class TVenta implements InterfazTransferVentas {
	
	private ArrayList<String> listaCompra;
	private ArrayList<String> cantidades;
	private int idCliente;
	private int idCompra;
	private boolean alta;
	private float montante;
	
	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdCliente() {
		
		return idCliente;
	}

	public ArrayList<String> getListaCompra() {
		return listaCompra;
		
		
	}

	public void setIdCliente(int id) {
		// TODO Auto-generated method stub
		this.idCliente=id;
		
	}

	public void setListaCompra(ArrayList<String> listaCompra) {
		// TODO Auto-generated method stub
		this.listaCompra=listaCompra;
	}

	public ArrayList<String> getCantidades() {
		return cantidades;
	}

	public void setCantidades(ArrayList<String> cantidades) {
		this.cantidades = cantidades;
	}

	public float getMontante() {
		return montante;
	}

	public void setMontante(float montante) {
		this.montante = montante;
	}

}
