package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		
		HttpSession sesion = null;
		
		User user = new User();
		
		if(usuario.equals("admin") && password.equals("admin")) {
			
			sesion= request.getSession();
			user.setNombre(usuario);
			sesion.setAttribute("usuario", user);
			
			response.sendRedirect("Admin");
			
		} else if(usuario.equals("usuario") && password.equals("usuario")) {
			
			sesion= request.getSession();
			user.setNombre(usuario);
			sesion.setAttribute("usuario", user);
			
			response.sendRedirect("Usuario");
			
		} else {
			response.sendRedirect("Login");
		}
		
	}

}
