package org.iesalixar.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ConciertoDTO implements Serializable{
	
	private List<String> grupos;
	private int num_entradas;
	private String tipo;
	
	
	public ConciertoDTO() {
		grupos = new ArrayList();
	}


	public List<String> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}


	public int getNum_entradas() {
		return num_entradas;
	}


	public void setNum_entradas(int num_entradas) {
		this.num_entradas = num_entradas;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
