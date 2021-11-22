package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Oficina;

public interface DAOOffice {
	
	public Oficina getOficina(String nombre);
	public ArrayList<Oficina> getOficinaSearch(String searchTerm);

}
