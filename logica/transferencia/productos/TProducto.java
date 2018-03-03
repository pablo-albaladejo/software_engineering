package com.concesionario.logica.transferencia.productos;

public class TProducto implements InterfazTransferProductos {
	private int identificador;
	private String marca;
	private String modelo;
	private int anyo;
	private float precio;
	private String cilindrada;
	private int existencias;
	private boolean activo=false;
	
	public void setIdentificador(int id){
		this.identificador = id;
	}
	public int getIdentificador(){
		return this.identificador;
	}
	public void setMarca(String marca){
		this.marca=marca;
	}
	public String getMarca(){
		return this.marca;
	}
	public void setModelo(String modelo){
		this.modelo=modelo;
	}
	public String getModelo(){
		return this.modelo;
	}
	public void setAño(int anyo){
		this.anyo=anyo;
	}
	public int getAño(){
		return this.anyo;
	}
	public void setPrecio(float precio){
		this.precio=precio;
	}
	public float getPrecio(){
		return this.precio;
	}
	public void setCilindrada(String cilindrada){
		this.cilindrada=cilindrada;
	}
	public String getCilindrada(){
		return this.cilindrada;
	}
	public void setExistencias(int existencias){
		this.existencias=existencias;
	}
	public int getExistencias(){
		return this.existencias;
	}
	public void setActivo(boolean activo){
		this.activo=activo;
	}
	public boolean getActivo(){
		return this.activo;
	}
}
