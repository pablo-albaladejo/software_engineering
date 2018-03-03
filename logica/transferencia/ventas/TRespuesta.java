package com.concesionario.logica.transferencia.ventas;

import java.util.ArrayList;
/**
 * @author carlos
 *
 */
public class TRespuesta implements InterfazTransferRespuesta {
	private boolean valida;
	private int id;
	private ArrayList<String> notas;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<String> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<String> notas) {
		this.notas = notas;
	}
	public boolean isValida() {
		return valida;
	}
	public void setValida(boolean valida) {
		this.valida = valida;
	}

}
