package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Propietario;


public interface PropietarioService {

	public void insertNewPropietario(final Propietario propietario);	
	 
	public void updatePropietario(final Propietario propietario);	
	
	public void deletePropietario(final Propietario propietario);
	
	public Propietario searchById(final Long propietarioId);
	
	public List<Propietario> searchAll();
	
	public List<Propietario> searchByFullName(final String firstName,final String lastName);
}
