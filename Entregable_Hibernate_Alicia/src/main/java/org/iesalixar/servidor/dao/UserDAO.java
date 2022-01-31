package org.iesalixar.servidor.dao;


import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface UserDAO extends GenericDAO<User>{
	
	public List<User> searchByUserorEmail(final String user,final String email);
	
	public ArrayList<String> searchPostbyTitle (final Long id);

}
