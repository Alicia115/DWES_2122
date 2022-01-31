package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.UserDAO;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDao;

	public UserServiceImpl(final Session session) {
		this.userDao = new UserDAOImpl(session);
	}

	@Override
	public void insertNewUser(User user) {
	
		if (user != null && user.getId() == null) {
			// Inserción del pedido
			userDao.insert(user);
		}
		
	}

	@Override
	public void updateUser(User user) {
		
		if (user != null && user.getId() != null) {

			// Actualizo el pedido
			userDao.update(user);
		}
	}

	@Override
	public void deleteUser(User user) {
		
		if (user != null && user.getId() != null) {

			// Actualizo el pedido
			userDao.delete(user);
		}
		
	}

	@Override
	public User searchById(Long userId) {
		
		User user = null;

		if (userId != null) {

			user = userDao.searchById(userId);
		}

		return user;
	}

	@Override
	public List<User> searchAll() {
		

		List<User> userList = new ArrayList<User>();

		userList = userDao.searchAll();

		return userList;
	}

	@Override
	public List<User> searchByUserorEmail(String user, String email) {
		
		List<User> userList = new ArrayList<User>();
		
		userList = userDao.searchByUserorEmail(user, email);

		return userList;
	}

	@Override
	public ArrayList<String> searchPostbyTitle(Long id) {
		
		ArrayList<String> userList = new ArrayList<String>();
		
		userList = userDao.searchPostbyTitle(id);

		return userList;
	}

}
