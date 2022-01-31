package org.iesalixar.servidor.dao;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Sede;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class SedeDAOImpl extends GenericDAOImpl<Sede> implements SedeDAO {

	private Session session;
	
	public SedeDAOImpl(Session session) {
		super(session);
		this.session = session;
	}
	
}
