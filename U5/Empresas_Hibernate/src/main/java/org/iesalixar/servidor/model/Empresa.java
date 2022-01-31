package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
@Table(name="empresas")
public class Empresa implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="name", nullable = false, unique=true)
	private String name;
	
	
	@Column(nullable = false, length = 300)
	private String country;
	
	
	@OneToMany(mappedBy="empresa", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Departamento> departamentos = new HashSet<>();


	public Empresa() {
		
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
		return Objects.hash(country, departamentos, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(country, other.country) && Objects.equals(departamentos, other.departamentos)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}


		//Métodos HELPERs	
		public void addDepartamento(Departamento departamento)  {
			this.departamentos.add(departamento);
			departamento.setEmpresa(this);
		}
		
		public void removeDepartamento(Departamento departamento) {
			this.departamentos.remove(departamento);
			departamento.setEmpresa(null);
		}
	
	
	
	
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", name=" + name + ", country=" + country + ", departamentos=" + departamentos
				+ "]";
	}
	
}
