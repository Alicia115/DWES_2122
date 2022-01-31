package org.iesalixar.servidor.model;

public class User {
	
	private String usuario;
	private String password;
	private String email;
	private String rol;
	
	public User() {
		
	}

	public User(String usuario, String password, String email, String rol) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
		this.rol = rol;
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

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	

}
