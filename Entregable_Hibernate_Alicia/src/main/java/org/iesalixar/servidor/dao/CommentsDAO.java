package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface CommentsDAO extends GenericDAO<Comments>{
	
	public List<Comments> searchByWord(String word);

}
