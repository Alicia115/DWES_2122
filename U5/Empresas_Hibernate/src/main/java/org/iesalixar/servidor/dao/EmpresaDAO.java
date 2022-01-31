package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Empresa;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface EmpresaDAO extends GenericDAO<Empresa> {
	
	public Empresa searchByName(final String name);
	
}
