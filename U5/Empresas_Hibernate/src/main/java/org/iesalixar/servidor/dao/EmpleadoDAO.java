package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Empleados;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface EmpleadoDAO extends GenericDAO<Empleados>{

	public List<Empleados> searchByFullName(final String firstName,final String lastName);
}
