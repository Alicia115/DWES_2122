package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
@IdClass(DepartamentoEmpleadoId.class)
public class DepartamentoEmpleado implements Serializable{

	@Id
	@ManyToOne
	@MapsId("departamento_id")
	@JoinColumn(name="departamento_id",insertable = false, updatable = false, referencedColumnName="id")
	private Departamento departamento;
	
	
	@Id
	@ManyToOne
	@MapsId("empleado_id")
	@JoinColumn(name="empleado_id",insertable = false, updatable = false, referencedColumnName="id")
	private Empleados empleado;
	
	@Column 
	private String puesto;


	public DepartamentoEmpleado() {
		
	}


	public DepartamentoEmpleado(Departamento departamento, Empleados empleado) {
		super();
		this.departamento = departamento;
		this.empleado = empleado;
	}


	public DepartamentoEmpleado(Departamento departamento, Empleados empleado, String puesto) {
		super();
		this.departamento = departamento;
		this.empleado = empleado;
		this.puesto = puesto;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Empleados getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	@Override
	public int hashCode() {
		return Objects.hash(departamento, empleado, puesto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoEmpleado other = (DepartamentoEmpleado) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(empleado, other.empleado)
				&& Objects.equals(puesto, other.puesto);
	}
	
	
	
}
