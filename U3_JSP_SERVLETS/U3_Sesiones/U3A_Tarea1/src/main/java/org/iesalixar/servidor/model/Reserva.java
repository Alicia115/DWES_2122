package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable {
	
	private String fechainicio;
	private String fechafinal;
	private int personas;
	private ArrayList<String> servicios;
	
	public Reserva() {
		
	}

	public String getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	public String getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public ArrayList<String> getServicios() {
		return servicios;
	}

	public void setServicios(ArrayList<String> servicios) {
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Registro [fechainicio=" + fechainicio + ", fechafinal=" + fechafinal + ", personas=" + personas
				+ ", servicios=" + servicios + "]";
	}
	
	
	
	

}
