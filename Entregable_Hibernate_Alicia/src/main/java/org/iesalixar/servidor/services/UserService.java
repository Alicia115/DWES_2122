package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.User;

public interface UserService {
	
	public void insertNewUser(final User user);	
	 
	public void updateUser(final User user);	
	
	public void deleteUser(final User user);
	
	public User searchById(final Long userId);
	
	public List<User> searchAll();
	
	public List<User> searchByUserorEmail(final String user,final String email);
	
	public ArrayList<String> searchPostbyTitle (final Long id);

}
