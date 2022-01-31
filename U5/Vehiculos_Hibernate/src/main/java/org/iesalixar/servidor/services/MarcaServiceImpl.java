package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.MarcaDAO;
import org.iesalixar.servidor.dao.MarcaDAOImpl;
import org.iesalixar.servidor.model.Marca;
import org.iesalixar.servidor.model.Vehiculo;

public class MarcaServiceImpl implements MarcaService{
	
	private MarcaDAO marcaDao;

	public MarcaServiceImpl(final Session session) {

		this.marcaDao = new MarcaDAOImpl(session);
	}

	public void insertNewMarca(Marca marca) {
		
		if (marca != null && marca.getId() == null) {

			// Inserción del publisher
			marcaDao.insert(marca);
		}
		
	}

	public void updateMarca(Marca marca) {
		
		if (marca != null && marca.getId() != null) {

			// Actualizo el publisher
			marcaDao.update(marca);
		}
	}

	public void deleteMarca(Marca marca) {
	
		if (marca != null && marca.getId() != null) {

			// Actualizo el publisher
			marcaDao.delete(marca);
		}
	}
	

	public Marca searchById(Long marcaId) {
		
		Marca marca = null;

		if (marcaId != null) {

			marca = marcaDao.searchById(marcaId);
		}

		return marca;
	}
	

	public List<Marca> searchAll() {
		
		List<Marca> marcaList = new ArrayList<Marca>();

		marcaList = marcaDao.searchAll();

		return marcaList;
	}
	

	public Marca searchByName(String name) {
		
		Marca marca = null;

		if (name != null) {
			
			marca = marcaDao.searchByName(name);
		}

		return marca;
	}
	

	public Marca searchByCountry(String country) {
		
		Marca marca = null;

		if (country != null) {
			
			marca = marcaDao.searchByCountry(country);
		}

		return marca;
	}

}
