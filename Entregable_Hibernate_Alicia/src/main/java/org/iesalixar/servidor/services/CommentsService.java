package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;

public interface CommentsService {
	
	public void insertNewComments(final Comments comment);	
	 
	public void updateComments(final Comments comment);	
	
	public void deleteComments(final Comments comment);
	
	public Comments searchById(final Long commentId);
	
	public List<Comments> searchAll();
	
	public List<Comments> searchByWord(String word);

}
