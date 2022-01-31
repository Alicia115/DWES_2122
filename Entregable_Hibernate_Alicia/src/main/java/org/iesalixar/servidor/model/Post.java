package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="post")
public class Post implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="content",nullable=false)
	private String content;
	
	@Column(name="date",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date;

	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();
	
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPost> userPost = new HashSet<>();
	
	
	@ManyToOne
	private User user;
	
	
	public Post() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Set<Comments> getComentarios() {
		return comentarios;
	}


	public void setComentarios(Set<Comments> comentarios) {
		this.comentarios = comentarios;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	


	public Set<UserPost> getUserPost() {
		return userPost;
	}


	public void setUserPost(Set<UserPost> userPost) {
		this.userPost = userPost;
	}


	@Override
	public int hashCode() {
		return Objects.hash(content, date, id, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(content, other.content) && Objects.equals(date, other.date)
				&& Objects.equals(id, other.id) && Objects.equals(title, other.title);
	}

	
	//Helpers Comments
		public void addComments(Comments comment)  {
			this.comentarios.add(comment);
			comment.setPost(this);
		}
		
		public void removeComments(Comments comment) {
			this.comentarios.remove(comment);
			comment.setPost(null);

		}
	

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	
	

}
