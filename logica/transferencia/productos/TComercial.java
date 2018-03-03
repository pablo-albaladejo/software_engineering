package com.concesionario.logica.transferencia.productos;

public class TComercial extends TProducto implements InterfazTransferComerciales {
	private int capacidad;
	private int volumen;
	private int puertas;
	
	public void setCapcarga(int capacidad){
		this.capacidad=capacidad;
	}
	public int getCapcarga(){
		return this.capacidad;
	}
	public void setVolutil(int volumen){
		this.volumen=volumen;
	}
	public int getVolutil(){
		return this.volumen;
	}
	public void setPuertas(int puertas){
		this.puertas=puertas;
	}
	public int getPuertas(){
		return this.puertas;
	}
	

}
