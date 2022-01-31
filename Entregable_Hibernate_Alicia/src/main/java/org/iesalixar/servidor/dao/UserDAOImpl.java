package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAO;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;


public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO{
	
	private Session session;

	public UserDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public List<User> searchByUserorEmail(String user, String email) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		CriteriaBuilder cb = session.getCriteriaBuilder();
		Criteria cr = session.createCriteria(User.class);
		
		Criterion usuario = Restrictions.eq("userName", user); 
		Criterion emeil = Restrictions.eq("email", email);
		LogicalExpression andExp = Restrictions.or(usuario,emeil);
		cr.add(andExp);
		
		List<User> userList = cr.list();		
		

		return userList;
	}

	@Override
	public ArrayList<String> searchPostbyTitle(Long id) {
		
		User user = this.searchById(id);
		
		Set<Post> posts = user.getPosts();
		
		ArrayList<String> lista = new ArrayList<String>();
		
		for(Post post:posts) {
			lista.add(post.getTitle());
		}
		
		return lista;
	}



}
