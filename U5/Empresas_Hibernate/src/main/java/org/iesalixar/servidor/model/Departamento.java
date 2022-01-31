package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="departamentos")
@Embeddable
public class Departamento implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="name", nullable = false, unique=true)
	private String name;
	
	
	@ManyToOne
	private Empresa empresa;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Sede> sedes = new HashSet<>();
	
	@OneToMany(mappedBy="departamento",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<DepartamentoEmpleado> departamentoEmpleado = new HashSet<>();

	
	public Departamento() {
		
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


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public Set<Sede> getSedes() {
		return sedes;
	}


	public void setSedes(Set<Sede> sedes) {
		this.sedes = sedes;
	}
	


	public Set<DepartamentoEmpleado> getDepartamentoEmpleado() {
		return departamentoEmpleado;
	}


	public void setDepartamentoEmpleado(Set<DepartamentoEmpleado> departamentoEmpleado) {
		this.departamentoEmpleado = departamentoEmpleado;
	}


	@Override
	public int hashCode() {
		return Objects.hash(empresa, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(empresa, other.empresa) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "Departamento [id=" + id + ", name=" + name + ", empresa=" + empresa + "]";
	}
	
	
	// MÉTODOS HELPERS CON SEDE
	public void addSede(Sede sede)  {
		this.sedes.add(sede);
		sede.getDepartamentos().add(this);
	}
	
	public void removeSede(Sede sede) {
		this.sedes.remove(sede);
		sede.getDepartamentos().remove(this);
	}
	
	
	// MÉTODOS HELPERS CON EMPLEADO
	
	public void addEmpleado(Empleados empleado, String puesto) {
		DepartamentoEmpleado departamentoEmpleado = new DepartamentoEmpleado(this,empleado,puesto);
		this.departamentoEmpleado.add(departamentoEmpleado);
		empleado.getDepartamentoEmpleados().add(departamentoEmpleado);
	}
	
	public void removeEmpleado(Empleados empleado) {
		DepartamentoEmpleado departamentoEmpleado = new DepartamentoEmpleado(this,empleado);
		empleado.getDepartamentoEmpleados().remove(departamentoEmpleado);
		this.departamentoEmpleado.remove(departamentoEmpleado);
	}
	

		
}
