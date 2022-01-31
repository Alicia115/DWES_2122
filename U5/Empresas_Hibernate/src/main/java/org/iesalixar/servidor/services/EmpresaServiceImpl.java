package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.EmpresaDAO;
import org.iesalixar.servidor.dao.EmpresaDAOImpl;
import org.iesalixar.servidor.model.Empresa;

public class EmpresaServiceImpl implements EmpresaService{
	
	// El servicio encapsulará el uso del DAO
		// y añadirá lógica de negocio necesaria
		private EmpresaDAO empresaDao;

		public EmpresaServiceImpl(final Session session) {

			this.empresaDao = new EmpresaDAOImpl(session);
		}

	@Override
	public void insertNewEmpresa(Empresa empresa) {
		
		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (empresa != null && empresa.getId() == null) {

			// Inserción del publisher
			empresaDao.insert(empresa);
		}
		
	}

	@Override
	public void updateEmpresa(Empresa empresa) {
	
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (empresa != null && empresa.getId() != null) {

			// Actualizo el publisher
			empresaDao.update(empresa);
		}
		
	}

	@Override
	public void deleteEmpresa(Empresa empresa) {
		
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (empresa != null && empresa.getId() != null) {

			// Actualizo el publisher
			empresaDao.delete(empresa);
		}

	}

	@Override
	public Empresa searchById(Long empresaId) {
	
		Empresa empresa = null;

		if (empresaId != null) {

			empresa = empresaDao.searchById(empresaId);
		}

		return empresa;
	}

	@Override
	public List<Empresa> searchAll() {
		// TODO Auto-generated method stub
	
		List<Empresa> empresaList = new ArrayList<Empresa>();

		empresaList = empresaDao.searchAll();

		return empresaList;
	}

	@Override
	public Empresa searchEmpresaByName(String name) {
		
		Empresa empresa = null;

		if (name != null) {
			
			empresa = empresaDao.searchByName(name);
		}

		return empresa;
	}

}
