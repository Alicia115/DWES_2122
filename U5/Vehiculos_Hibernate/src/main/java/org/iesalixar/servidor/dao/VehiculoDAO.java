package org.iesalixar.servidor.dao;


import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface VehiculoDAO extends GenericDAO<Vehiculo> {

	public Vehiculo searchByMatricula(final String matricula);
}
