package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.model.Vehiculo;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface MarcaDAO extends GenericDAO<Marca> {
	
	public Marca searchByName(final String name);
	public Marca searchByCountry(final String country);

}
