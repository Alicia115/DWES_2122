package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private String usuario;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String rol;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String usuario, String firstName, String lastName, String password,String email, String rol) {
		super();
		this.usuario = usuario;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.rol = rol;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRole(String rol) {
		this.rol = rol;
	}	
}
