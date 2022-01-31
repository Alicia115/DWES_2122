package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.MultasDAO;
import org.iesalixar.servidor.dao.MultasDAOImpl;
import org.iesalixar.servidor.model.Multas;

public class MultasServiceImpl implements MultasService{
	
	private MultasDAO multaDao;
	
	public MultasServiceImpl(final Session session) {
		this.multaDao = new MultasDAOImpl(session);
	}
	

	public void insertNewMulta(Multas multa) {
		
		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (multa != null && multa.getId() == null) {
			// Inserción del pedido
			multaDao.insert(multa);
		}
		
	}

	public void updateMulta(Multas multa) {

		if (multa != null && multa.getId() != null) {

			// Actualizo el pedido
			multaDao.update(multa);
		}
		
	}

	public void deleteMulta(Multas multa) {

		if (multa != null && multa.getId() != null) {

			// Actualizo el pedido
			multaDao.delete(multa);
		}
		
	}

	public Multas searchById(Long multaId) {

		Multas multa = null;

		if (multaId != null) {

			multa = multaDao.searchById(multaId);
		}

		return multa;
	}

	public List<Multas> searchAll() {

		List<Multas> multaList = new ArrayList<Multas>();

		multaList = multaDao.searchAll();

		return multaList;
	}

}
