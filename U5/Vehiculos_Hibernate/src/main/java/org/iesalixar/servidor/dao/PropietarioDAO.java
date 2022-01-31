package org.iesalixar.servidor.dao;


import java.util.List;


import org.iesalixar.servidor.model.Propietario;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface PropietarioDAO extends GenericDAO<Propietario>{
	
	public List<Propietario> searchByFullName(final String firstName,final String lastName);

}
