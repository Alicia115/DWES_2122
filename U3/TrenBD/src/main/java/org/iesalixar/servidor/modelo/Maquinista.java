package org.iesalixar.servidor.modelo;

import java.io.Serializable;

public class Maquinista implements Serializable {
	
	private String nombre;
	private String apellido;
	private String dni;
	
	
	public Maquinista() {
		
	}
	
	public Maquinista(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	

}
