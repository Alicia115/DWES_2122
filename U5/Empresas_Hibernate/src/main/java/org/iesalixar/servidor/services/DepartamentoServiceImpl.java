package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.DepartamentoDAO;
import org.iesalixar.servidor.dao.DepartamentoDAOImpl;
import org.iesalixar.servidor.model.Departamento;

public class DepartamentoServiceImpl implements DepartamentoService{
	
	// El servicio encapsulará el uso del DAO
		// y añadirá lógica de negocio necesaria
		private DepartamentoDAO departamentoDao;

		public DepartamentoServiceImpl(final Session session) {
			this.departamentoDao = new DepartamentoDAOImpl(session);
		}

	@Override
	public void insertNewDepartamento(Departamento departamento) {
		
		// Hago comprobaciones (pueden cambiar dependiendo
		// de la aplicación para varios usos del mismo DAO
		if (departamento != null && departamento.getId() == null) {

			departamentoDao.insert(departamento);
		}
		
	}

	@Override
	public void updateDepartamento(Departamento departamento) {
	
		// Comprobamos que no es nulo y que ya existe
		if (departamento != null && departamento.getId() != null) {

			departamentoDao.update(departamento);

		}
		
	}

	@Override
	public void deleteDepartamento(Departamento departamento) {
	
		// Comprobamos que no es nulo y que ya existe
		if (departamento != null && departamento.getId() != null) {

			departamentoDao.delete(departamento);

		}
		
	}

	@Override
	public Departamento searchById(Long departamentoId) {
		
		Departamento departamento = null;

		if (departamentoId != null) {
			departamentoDao.searchById(departamentoId);
		}

		return departamento;
		
	}

	@Override
	public List<Departamento> searchAll() {
		
		List<Departamento> departamentoList = new ArrayList<Departamento>();

		departamentoList = departamentoDao.searchAll();

		return departamentoList;
		
	}

	@Override
	public List<Departamento> searchByName(String name) {
		

		List<Departamento> departamentoList = new ArrayList<Departamento>();

		if (name!=null) {
			departamentoList = departamentoDao.searchByName(name);
		}
		

		return departamentoList;
	}

	
	

}
