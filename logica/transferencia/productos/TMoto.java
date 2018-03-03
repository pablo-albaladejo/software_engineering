package com.concesionario.logica.transferencia.productos;

public class TMoto extends TProducto implements InterfazTransferMotos{
	private String tipo;
	private String arranque;
	private String embrague;
	
	public void setTipo(String tipo){
		this.tipo=tipo;
	}
	public String getTipo(){
		return this.tipo;
	}
	public void setArranque(String arranque){
		this.arranque=arranque;
	}
	public String getArranque(){
		return this.arranque;
	}
	public void setEmbrague(String embrague){
		this.embrague=embrague;
	}
	public String getEmbrague(){
		return this.embrague;
	}
	}
