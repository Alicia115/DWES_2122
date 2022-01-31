package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAO;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.dao.PostDAO;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;

public class CommentsServiceImpl implements CommentsService{
	
	private CommentsDAO commentDao;

	public CommentsServiceImpl(final Session session) {
		this.commentDao = new CommentsDAOImpl(session);
	}

	@Override
	public void insertNewComments(Comments comment) {
		
		if (comment != null && comment.getId() == null) {
			// Inserción del pedido
			commentDao.insert(comment);
		}
		
	}

	@Override
	public void updateComments(Comments comment) {
		
		if (comment != null && comment.getId() != null) {

			// Actualizo el pedido
			commentDao.update(comment);
		}
		
	}

	@Override
	public void deleteComments(Comments comment) {
		
		if (comment != null && comment.getId() != null) {

			// Actualizo el pedido
			commentDao.delete(comment);
		}
	}

	@Override
	public Comments searchById(Long commentId) {
	
		Comments comment = null;

		if (commentId != null) {

			comment = commentDao.searchById(commentId);
		}

		return comment;
	}

	@Override
	public List<Comments> searchAll() {
		
		List<Comments> commentList = new ArrayList<Comments>();

		commentList = commentDao.searchAll();

		return commentList;
	}

	@Override
	public List<Comments> searchByWord(String word) {
		
		List<Comments> commentList = new ArrayList<Comments>();
		
		commentList = commentDao.searchByWord(word);
		
		return commentList;
	}



}
