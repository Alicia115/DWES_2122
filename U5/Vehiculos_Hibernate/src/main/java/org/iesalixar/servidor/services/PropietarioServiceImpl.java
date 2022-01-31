package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import org.iesalixar.servidor.dao.PropietarioDAO;
import org.iesalixar.servidor.dao.PropietarioDAOImpl;
import org.iesalixar.servidor.model.Propietario;

public class PropietarioServiceImpl implements PropietarioService{
	
	private PropietarioDAO propietarioDao;

	public PropietarioServiceImpl(final Session session) {
		this.propietarioDao = new PropietarioDAOImpl(session);
	}

	public void insertNewPropietario(Propietario propietario) {
	
		if (propietario != null && propietario.getId() == null) {
			// Inserción del pedido
			propietarioDao.insert(propietario);
		}
	}

	public void updatePropietario(Propietario propietario) {
		
		if (propietario != null && propietario.getId() != null) {

			// Actualizo el pedido
			propietarioDao.update(propietario);
		}
	}

	public void deletePropietario(Propietario propietario) {
		
		if (propietario != null && propietario.getId() != null) {

			// Actualizo el pedido
			propietarioDao.delete(propietario);
		}
	}

	public Propietario searchById(Long propietarioId) {
		
		Propietario propietario = null;

		if (propietarioId != null) {

			propietario = propietarioDao.searchById(propietarioId);
		}

		return propietario;
	}

	public List<Propietario> searchAll() {
		
		List<Propietario> propietarioList = new ArrayList<Propietario>();

		propietarioList = propietarioDao.searchAll();

		return propietarioList;
	}

	public List<Propietario> searchByFullName(String firstName, String lastName) {
		
		List<Propietario> propietarioList = new ArrayList<Propietario>();

		if (firstName!=null && lastName!=null) {
			propietarioList = propietarioDao.searchByFullName(firstName, lastName);
		}		

		return propietarioList;
	}

}
