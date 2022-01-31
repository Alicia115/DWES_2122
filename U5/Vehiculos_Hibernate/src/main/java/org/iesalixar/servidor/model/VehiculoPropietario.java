package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
@IdClass(VehiculoPropietarioId.class)
public class VehiculoPropietario implements Serializable{
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="vehiculo_id",insertable = false, updatable = false)
	private Vehiculo vehiculo;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="propietario_id",insertable = false, updatable = false)
	private Propietario propietario;
	
	
	@Column
	@Type(type="date")
	private Date date;


	public VehiculoPropietario() {
		
	}


	public VehiculoPropietario(Vehiculo vehiculo, Propietario propietario) {
		super();
		this.vehiculo = vehiculo;
		this.propietario = propietario;
	}

	
	public VehiculoPropietario(Vehiculo vehiculo, Propietario propietario, Date date) {
		super();
		this.vehiculo = vehiculo;
		this.propietario = propietario;
		this.date = date;
	}

	

	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		VehiculoPropietario other = (VehiculoPropietario) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
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
