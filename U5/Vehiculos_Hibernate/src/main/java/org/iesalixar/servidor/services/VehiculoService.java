package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Vehiculo;



public interface VehiculoService {
	
	public void insertNewVehiculo(final Vehiculo vehiculo);	
	 
	public void updateVehiculo(final Vehiculo vehiculo);	
	
	public void deleteVehiculo(final Vehiculo vehiculo);
	
	public Vehiculo searchById(final Long vehiculoId);
	
	public List<Vehiculo> searchAll();
	
	public Vehiculo searchByMatricula(final String matricula);

}
