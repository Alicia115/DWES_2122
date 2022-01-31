package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="empleados")
public class Empleados implements Serializable{

	@Id
	@GeneratedValue
	private Long id;	
	
	@Column(name="firstName", nullable = false, unique=true)
	private String firstName;
	
	@Column(name="lastName", nullable = false, unique=true)
	private String lastName;
	
	
	@OneToMany(mappedBy="empleado",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<DepartamentoEmpleado> departamentoEmpleados = new HashSet<>();
	
	

	public Empleados() {
	
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


	public Set<DepartamentoEmpleado> getDepartamentoEmpleados() {
		return departamentoEmpleados;
	}


	public void setDepartamentoEmpleados(Set<DepartamentoEmpleado> departamentoEmpleados) {
		this.departamentoEmpleados = departamentoEmpleados;
	}


	@Override
	public int hashCode() {
		return Objects.hash(departamentoEmpleados, firstName, id, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return Objects.equals(departamentoEmpleados, other.departamentoEmpleados)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString() {
		return "Empleados [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", departamentoEmpleados=" + departamentoEmpleados + "]";
	}

	
	
}
