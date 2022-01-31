package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(UserPost.class)
public class UserPost implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="user_id",insertable = false, updatable = false)
	private User user;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name="post_id",insertable = false, updatable = false)
	private Post post;		
	
	private Double puntuacion;

	public UserPost() {
		
	}

	public UserPost(User user, Post post) {
		super();
		this.user = user;
		this.post = post;
	}

	public UserPost(User user, Post post, Double puntuacion) {
		super();
		this.user = user;
		this.post = post;
		this.puntuacion = puntuacion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Double puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(post, puntuacion, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPost other = (UserPost) obj;
		return Objects.equals(post, other.post) && Objects.equals(puntuacion, other.puntuacion)
				&& Objects.equals(user, other.user);
	}
	
	
	

}
