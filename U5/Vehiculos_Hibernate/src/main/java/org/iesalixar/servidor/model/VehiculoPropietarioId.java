package org.iesalixar.servidor.model;

import java.io.Serializable;

public class VehiculoPropietarioId implements Serializable{

	private Long vehiculo;
	private Long propietario;
	
	
	public VehiculoPropietarioId() {
	
	}


	public Long getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Long vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Long getPropietario() {
		return propietario;
	}


	public void setPropietario(Long propietario) {
		this.propietario = propietario;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((propietario == null) ? 0 : propietario.hashCode());
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		VehiculoPropietarioId other = (VehiculoPropietarioId) obj;
		if (propietario == null) {
			if (other.propietario != null)
				return false;
		} else if (!propietario.equals(other.propietario))
			return false;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}
	
	
	
}
