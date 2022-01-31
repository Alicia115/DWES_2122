package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Sede;

public interface SedeService {
	
	public void insertNewSede(final Sede sede);	
	 
	public void updateSede(final Sede sede);	
	
	public void deleteSede(final Sede sede);
	
	public Sede searchById(final Long sedeId);
	
	public List<Sede> searchAll();

}
