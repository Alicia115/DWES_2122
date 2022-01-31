package org.iesalixar.servidor;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.services.CommentsService;
import org.iesalixar.servidor.services.CommentsServiceImpl;
import org.iesalixar.servidor.services.PostService;
import org.iesalixar.servidor.services.PostServiceImpl;
import org.iesalixar.servidor.services.UserService;
import org.iesalixar.servidor.services.UserServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {
	
	public static void main(String[] args) {
	
		Calendar calendar = Calendar.getInstance();
		//Creo la sesión
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		// Creo los servicios definidos
		CommentsService commentsService = new CommentsServiceImpl(session);
		PostService postService = new PostServiceImpl(session);
		UserService userService = new UserServiceImpl(session);
		
		
		Post post1 = new Post();
		post1.setTitle("Mi primer post");
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		post1.setDate(calendar.getTime());
		post1.setContent("Mi primer post sobre el instituto");
		
		Post post2 = new Post();
		post2.setTitle("Mi dia dia rutina");
		calendar.set(Calendar.YEAR, 2021);
		calendar.set(Calendar.MONTH, 4);
		calendar.set(Calendar.DAY_OF_MONTH, 18);
		post2.setDate(calendar.getTime());
		post2.setContent("La rutina facial de mi dia a dia");
		
		Post post3 = new Post();
		post3.setTitle("Mi dia dia con mi perro");
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 2);
		calendar.set(Calendar.DAY_OF_MONTH, 23);
		post3.setDate(calendar.getTime());
		post3.setContent("Os presento a bucky");
		
		Post post4 = new Post();
		post4.setTitle("50 cosas sobre mi");
		calendar.set(Calendar.YEAR, 2021);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 25);
		post4.setDate(calendar.getTime());
		post4.setContent("Para conocerme mejor");
		
		Post post5 = new Post();
		post5.setTitle("Respondiendo preguntas");
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 26);
		post5.setDate(calendar.getTime());
		post5.setContent("Respondo a todas las preguntas");
		
		postService.insertNewPost(post1);
		postService.insertNewPost(post2);
		postService.insertNewPost(post3);
		postService.insertNewPost(post4);
		postService.insertNewPost(post5);
		
		
		Comments comen1 = new Comments();
		comen1.setTitle("Me encanta");
		comen1.setContent("Me encanta tu contenido");
		Comments comen2 = new Comments();
		comen2.setTitle("Like pero no");
		comen2.setContent("No me gusta todo tu contenido, cambialo");
		Comments comen3 = new Comments();
		comen3.setTitle("Me gusta");
		comen3.setContent("100% identificada");
		Comments comen5 = new Comments();
		comen5.setTitle("Coment prueba");
		comen5.setContent("100% identificada");
		
		commentsService.insertNewComments(comen1);
		commentsService.insertNewComments(comen2);
		commentsService.insertNewComments(comen3);
		commentsService.insertNewComments(comen5);
		
		User user1 = new User();
		user1.setUserName("Manolin19");
		user1.setPassword("manolito");
		user1.setFirstName("Manolin");
		user1.setLastName("Manolinillo");
		user1.setEmail("manolin@gmail.com");
		
		User user2 = new User();
		user2.setUserName("Diego29");
		user2.setPassword("diegito");
		user2.setFirstName("Diego");
		user2.setLastName("Dieguillo");
		user2.setEmail("diego@gmail.com");
		
		userService.insertNewUser(user1);
		userService.insertNewUser(user2);
		
		userService.updateUser(user1);
		userService.updateUser(user2);
		
		postService.updatePost(post1);
		postService.updatePost(post2);
		postService.updatePost(post3);
		postService.updatePost(post4);
		postService.updatePost(post5);
		
		commentsService.updateComments(comen1);
		commentsService.updateComments(comen2);
		commentsService.updateComments(comen3);
		
		user1.addComments(comen3);
		user2.addComments(comen2);
		user1.addComments(comen1);
		
		user1.addPost(post1);
		user1.addPost(post2);
		user1.addPost(post3);
		user1.addPost(post4);
		user1.addPost(post5);
		user2.addPost(post1);
		user2.addPost(post2);
		user2.addPost(post3);
		user2.addPost(post4);
		user2.addPost(post5);
		
		user1.addUserPost(post1, 4.5);
		user1.addUserPost(post2, 9.8);
		user1.addUserPost(post3, 7.7);
		user1.addUserPost(post4, 8.9);
		user1.addUserPost(post5, 9.7);
		user2.addUserPost(post1, 5.3);
		user2.addUserPost(post2, 6.3);
		user2.addUserPost(post3, 5.8);
		user2.addUserPost(post4, 8.7);
		user2.addUserPost(post5, 7.0);
		
		post1.addComments(comen3);
		post2.addComments(comen3);
		post3.addComments(comen2);
		post4.addComments(comen1);
		post5.addComments(comen1);
		
		userService.updateUser(user1);
		userService.updateUser(user2);
		
		postService.updatePost(post1);
		postService.updatePost(post2);
		postService.updatePost(post3);
		postService.updatePost(post4);
		postService.updatePost(post5);
		
		
		user2.setUserName("Diegaso94");
		userService.updateUser(user2);
		
		commentsService.deleteComments(comen5);
		
		post3.removeComments(comen2);
		user2.removeComments(comen2);
		commentsService.deleteComments(comen2);
		
		//Cerramos la sesión
		session.close();
	}
}
