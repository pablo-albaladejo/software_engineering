package com.concesionario.logica.transferencia.productos;

public class TTurismo extends TProducto implements InterfazTransferTurismos{
	private int puertas;
	private int plazas;
	private String chasis;
	private String cambio;
	
	
	public void setPuertas(int puertas){
		this.puertas=puertas;
	}
	public int getPuertas(){
		return this.puertas;
	}
	public void setPlazas(int plazas){
		this.plazas=plazas;
	}
	public int getPlazas(){
		return this.plazas;
	}
	public void setChasis(String chasis){
		this.chasis=chasis;
	}
	public String getChasis(){
		return this.chasis;
	}
	public void setCambio(String cambio){
		this.cambio=cambio;
	}
	public String getCambio(){
		return this.cambio;
	}

}
