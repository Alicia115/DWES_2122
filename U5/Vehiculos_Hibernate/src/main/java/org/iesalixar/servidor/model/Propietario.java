package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name="propietarios")
public class Propietario implements Serializable{

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column(name="firstName", nullable = false, unique=true)
	private String firstName;
	
	@Column(name="lastName", nullable = false, unique=true)
	private String lastName;
	
	@Column(name="telefono", nullable = false, unique=true)
	@Digits(integer = 9, fraction = 0)
	private Integer telefono;
	
	@Column(name="dns", nullable = false, unique=true)
	private String dns;
	
	
	@OneToMany(mappedBy="propietario",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<VehiculoPropietario> vehiculoPropietario = new HashSet<VehiculoPropietario>();

	
	public Propietario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}
	
	
	public Set<VehiculoPropietario> getVehiculoPropietario() {
		return vehiculoPropietario;
	}

	public void setVehiculoPropietario(Set<VehiculoPropietario> vehiculoPropietarioss) {
		this.vehiculoPropietario = vehiculoPropietarioss;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dns == null) ? 0 : dns.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propietario other = (Propietario) obj;
		if (dns == null) {
			if (other.dns != null)
				return false;
		} else if (!dns.equals(other.dns))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", telefono="
				+ telefono + ", dns=" + dns + "]";
	}

}
