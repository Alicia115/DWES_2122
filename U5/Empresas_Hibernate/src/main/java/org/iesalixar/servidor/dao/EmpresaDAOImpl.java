package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Empresa;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

import java.util.List;
import org.hibernate.Session;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa> implements EmpresaDAO{
	
	private Session session;
	
	public EmpresaDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Empresa searchByName(String name) {
		
		// Compruebo que la conexión está acticva
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero las editoriales por nombre
		List<Empresa> empresaList = session.createQuery("FROM Empresa WHERE name='" + name+"'").list();

		// Como el nombre del publisher debe ser único me quedo con el primero en caso
		// de que se haya devuelvo algo (existe)
		Empresa empresa = null;
		if (empresaList != null && empresaList.size() > 0) {
			empresa = empresaList.get(0);
		}

		return empresa;
	}
	
	
}
