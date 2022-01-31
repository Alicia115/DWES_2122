package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.iesalixar.servidor.model.Empleados;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class EmpleadoDAOImpl  extends GenericDAOImpl<Empleados> implements EmpleadoDAO { 
	
	private Session session;

	public EmpleadoDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	
	@Override
	public List<Empleados> searchByFullName(String firstName, String lastName) {

		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		
		// Recupero empleados que cumplen las condiciones con Criteria
		// No es una consulta Nativa uso el nombre de la clase
		Criteria cr = session.createCriteria(Empleados.class);
		
		Criterion first = Restrictions.eq("firstName", firstName); 
		Criterion last = Restrictions.eq("lastName", lastName);
		LogicalExpression andExp = Restrictions.and(first,last);
		cr.add(andExp);
		
		List<Empleados> empleadoList = cr.list();		
		

		return empleadoList;
	}
	
	
}
