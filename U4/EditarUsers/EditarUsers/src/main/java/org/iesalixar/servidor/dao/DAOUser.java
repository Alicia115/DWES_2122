package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.User;


public interface DAOUser {
	
	public User getUser(String usuario);
	public boolean removeUser(String usuario);
	public boolean updateUser(User user);
	public boolean insertUser(User user);
	public boolean comprobacionUser(String usuario, String password);
}
