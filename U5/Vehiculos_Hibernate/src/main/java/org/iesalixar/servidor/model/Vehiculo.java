package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vehiculos")
public class Vehiculo implements Serializable{
	

	@Id
	@GeneratedValue
	private Long id;
	
	
	@Column(name="matricula", nullable = false, unique=true)
	private String matricula;
	
	
	@Column(name="color", nullable = false, unique=true)
	private String color;

	
	@OneToMany(mappedBy="vehiculo", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Multas> multas = new HashSet<Multas>();
	
	
	@ManyToOne
	private Marca marca;
	
	
	@OneToMany(mappedBy="vehiculo",cascade=CascadeType.ALL,orphanRemoval = true)
	private Set<VehiculoPropietario> vehiculoPropietario = new HashSet<VehiculoPropietario>();
	

	public Vehiculo() {
		
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getMatricula() {
		return matricula;
	}




	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}




	public String getColor() {
		return color;
	}




	public void setColor(String color) {
		this.color = color;
	}

	


	public Set<Multas> getMultas() {
		return multas;
	}




	public void setMultas(Set<Multas> multas) {
		this.multas = multas;
	}




	public Marca getMarca() {
		return marca;
	}




	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public Set<VehiculoPropietario> getVehiculoPropietario() {
		return vehiculoPropietario;
	}




	public void setVehiculoPropietario(Set<VehiculoPropietario> vehiculoPropietario) {
		this.vehiculoPropietario = vehiculoPropietario;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	
	//Métodos HELPERs	
			public void addMultas(Multas multa)  {
				this.multas.add(multa);
				multa.setVehiculo(this);
			}
			
			public void removeMultas(Multas multa) {
				this.multas.remove(multa);
				multa.setVehiculo(null);
			}
			
			
	// MÉTODOS HELPERS CON EMPLEADO
			public void addPropietario(Propietario propietario, Date date) {
				VehiculoPropietario vehiculoPropietario = new VehiculoPropietario(this,propietario, date);
				this.vehiculoPropietario.add(vehiculoPropietario);
				propietario.getVehiculoPropietario().add(vehiculoPropietario);
			}
			
			public void removePropietario(Propietario propietario) {
				VehiculoPropietario vehiculoPropietario = new VehiculoPropietario(this,propietario);
				propietario.getVehiculoPropietario().remove(vehiculoPropietario);
				this.vehiculoPropietario.remove(vehiculoPropietario);
			}
			
					

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", matricula=" + matricula + ", color=" + color + "]";
	}
	
	
}
