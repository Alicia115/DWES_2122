package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Multas;

public interface MultasService {


	public void insertNewMulta(final Multas multa);	
	 
	public void updateMulta(final Multas multa);	
	
	public void deleteMulta(final Multas multa);
	
	public Multas searchById(final Long multaId);
	
	public List<Multas> searchAll();
}
