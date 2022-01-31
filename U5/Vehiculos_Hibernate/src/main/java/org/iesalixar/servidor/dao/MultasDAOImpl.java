package org.iesalixar.servidor.dao;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Multas;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class MultasDAOImpl extends GenericDAOImpl<Multas> implements MultasDAO {

	private Session session;
	
	public MultasDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

}
