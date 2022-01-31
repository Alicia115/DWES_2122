package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

public class DepartamentoEmpleadoId implements Serializable{
	
	private Long departamento;
	private Long empleado;
	
	
	public DepartamentoEmpleadoId() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(departamento, empleado);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DepartamentoEmpleadoId other = (DepartamentoEmpleadoId) obj;
		
		if (empleado == null) {
			if (other.empleado != null)
				return false;			
		} else  if (empleado != other.empleado)
				return false;
		
		if (departamento == null) {
			if (other.departamento != null)
				return false;			
		} else if (departamento!= other.departamento)
				return false;
		
		return true;
	}


	public Long getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Long departamento) {
		this.departamento = departamento;
	}


	public Long getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}
	

}
