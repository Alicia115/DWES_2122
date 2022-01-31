package org.iesalixar.servidor.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.iesalixar.servidor.model.Propietario;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class PropietarioDAOImpl extends GenericDAOImpl<Propietario> implements PropietarioDAO {
	
	private Session session;

	public PropietarioDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	public List<Propietario> searchByFullName(String firstName, String lastName) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		
		// Recupero empleados que cumplen las condiciones con Criteria
		// No es una consulta Nativa uso el nombre de la clase
		Criteria cr = session.createCriteria(Propietario.class);
		
		Criterion first = Restrictions.eq("firstName", firstName); 
		Criterion last = Restrictions.eq("lastName", lastName);
		LogicalExpression andExp = Restrictions.and(first,last);
		cr.add(andExp);
		
		List<Propietario> propietarioList = cr.list();		
		

		return propietarioList;
	}
	
}
