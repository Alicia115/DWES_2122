package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;

public interface PostService {
	
	public void insertNewPost(final Post post);	
	 
	public void updatePost(final Post post);	
	
	public void deletePost(final Post post);
	
	public Post searchById(final Long postId);
	
	public List<Post> searchAll();
	
	

}
