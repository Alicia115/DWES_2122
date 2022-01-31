package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="userName",unique=true,nullable=false)
	private String userName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Column(name="firstName",nullable=false)
	private String firstName;
	
	@Column(name="lastName",nullable=false)
	private String lastName;
	
	@Column(name="email",nullable=false)
	private String email;
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Comments> comentarios = new HashSet<>();
	
	
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Set<Post> posts = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<UserPost> userPost = new HashSet<>();
	

	public User() {
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	

	public Set<Comments> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comments> comentarios) {
		this.comentarios = comentarios;
	}


	public Set<Post> getPosts() {
		return posts;
	}


	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}



	public Set<UserPost> getUserPost() {
		return userPost;
	}



	public void setUserPost(Set<UserPost> userPost) {
		this.userPost = userPost;
	}



	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, id, lastName, password, userName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	
	//Helpers Comments
			public void addComments(Comments comment)  {
				this.comentarios.add(comment);
				comment.setUser(this);
			}
			
			public void removeComments(Comments comment) {
				this.comentarios.remove(comment);
				comment.setUser(null);

			}
			
	//Helpers Post
			public void addPost(Post post)  {
				this.posts.add(post);
				post.setUser(this);
			}
			
			public void removePost(Post post) {
				this.posts.remove(post);
				post.setUser(null);

			}
	
			
	// METODOS HELPER CON USERPOST
			public void addUserPost(Post post, Double puntuacion) {
				UserPost userPost = new UserPost(this,post, puntuacion);
				this.userPost.add(userPost);
				post.getUserPost().add(userPost);
			}

			public void removeUserPost(Post post) {
				UserPost userPost = new UserPost(this,post);
				this.userPost.remove(userPost);
				post.getUserPost().remove(userPost);
			}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	

}
