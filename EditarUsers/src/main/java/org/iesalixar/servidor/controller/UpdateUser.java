package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOUserImpl;
import org.iesalixar.servidor.model.User;

/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		
		DAOUserImpl daoImpl = new DAOUserImpl ();
		
		User user= daoImpl.getUser(usuario);
		
		request.setAttribute("usuario", user);
		
		request.getRequestDispatcher("WEB-INF/view/updateUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String rol = request.getParameter("rol");
		
		if (usuario!=null && password!=null && email!=null && rol!=null) {
			
			User user = new User(usuario,password,email,rol);
			
			DAOUserImpl daoImpl = new DAOUserImpl();
			
			daoImpl.updateUser(user);
		}
		
		response.sendRedirect(request.getContextPath());
		
	}

}
