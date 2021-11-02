package org.iesalixar.servidor.modelo;

import java.io.Serializable;

public class Vagon implements Serializable {
	
	private double longitud;
	private int capacidad;
	
	public Vagon() {
		
	}
	
	
	public Vagon(double longitud, int capacidad) {
		super();
		this.longitud = longitud;
		this.capacidad = capacidad;
	}


	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	
	

}
