package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Marca;


public interface MarcaService {

	public void insertNewMarca(final Marca marca);	
	 
	public void updateMarca(final Marca marca);	
	
	public void deleteMarca(final Marca marca);
	
	public Marca searchById(final Long marcaId);
	
	public List<Marca> searchAll();
	
	public Marca searchByName(final String name);
	
	public Marca searchByCountry(final String country);
}
