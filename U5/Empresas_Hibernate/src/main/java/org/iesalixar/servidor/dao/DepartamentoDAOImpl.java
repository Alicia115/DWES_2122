package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Empresa;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class DepartamentoDAOImpl extends GenericDAOImpl<Departamento> implements DepartamentoDAO {
	
	private Session session;
	
	public DepartamentoDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	
	@Override
	public List<Departamento> searchByName(String name) {
		
		// Compruebo que la conexión está actica
				if (!session.getTransaction().isActive()) {
					session.getTransaction().begin();
				}
				

				List<Departamento> departamentoList = new ArrayList<>();
				
				if (name!=null) {
					// Recupero todos los departamento con ese nombre		
					departamentoList = session.createQuery("FROM Departamento WHERE name=:name")
							.setParameter("name", name).list();
				}

				return departamentoList;
	}

	

}
