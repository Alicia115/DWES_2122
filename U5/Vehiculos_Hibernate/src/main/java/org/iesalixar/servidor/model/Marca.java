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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="marcas")
public class Marca implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="name", nullable = false, unique=true)
	private String name;
	
	
	@Column(name="year", nullable = true)
	@Digits(integer = 4, fraction = 0)
	@Min(value = 1600, message = "")
	@Max(value = 3000, message = "")
	private Integer year; 
	
	
	@Column(name="country", nullable = false, unique=true)
	private String country;
	
	
	@OneToMany(mappedBy="marca", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

	
	public Marca() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		Marca other = (Marca) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	
	//Métodos HELPERs	
	public void addVehiculo(Vehiculo vehiculo)  {
		this.vehiculos.add(vehiculo);
		vehiculo.setMarca(this);
	}
	
	public void removeVehiculo(Vehiculo vehiculo) {
		this.vehiculos.remove(vehiculo);
		vehiculo.setMarca(null);
	}
	
	

	@Override
	public String toString() {
		return "Marca [id=" + id + ", name=" + name + ", year=" + year + ", country=" + country + "]";
	}
	


}
