package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name="sedes")
public class Sede implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="city", nullable = false, unique=true)
	private String city;
	
	
	@Column(nullable = false, length = 300)
	private String country;
	
	
	@ManyToMany(mappedBy = "sedes")
	private Set<Departamento> departamentos = new HashSet<>();
	
	
	public Sede() {
	
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(country, departamentos, id, city);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sede other = (Sede) obj;
		return Objects.equals(country, other.country) && Objects.equals(departamentos, other.departamentos)
				&& Objects.equals(id, other.id) && Objects.equals(city, other.city);
	}


	@Override
	public String toString() {
		return "Sede [id=" + id + ", city=" + city + ", country=" + country + ", departamentos=" + departamentos + "]";
	}

}
