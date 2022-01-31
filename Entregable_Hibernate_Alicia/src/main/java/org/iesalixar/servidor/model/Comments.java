package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="content",nullable=false)
	private String content;

	
	@ManyToOne
	private Post post;
	
	@ManyToOne
	private User user;
	
	
	public Comments() {
		
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
	

	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		return Objects.hash(content, id, title);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}


	@Override
	public String toString() {
		return "Comments [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
	

}
