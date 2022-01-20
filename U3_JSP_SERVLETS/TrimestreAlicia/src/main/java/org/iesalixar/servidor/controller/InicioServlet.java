package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOProductLinesImpl;
import org.iesalixar.servidor.dao.DAOUsuarioImpl;
import org.iesalixar.servidor.model.ProductLines;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.utils.PasswordHashGenerator;

/**
 * Servlet implementation class Home
 */
@WebServlet("/InicioServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(InicioServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (email!=null && password!=null) {
			
			DAOUsuarioImpl dao = new DAOUsuarioImpl();
			
			Usuario user = dao.getUsuario(email);
			
			if (user!=null) {
				if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {
					
					HttpSession sesion = request.getSession();
					
					sesion.setAttribute("usuario", user.getUsuario());
					sesion.setAttribute("firstName", user.getFirstName());
					sesion.setAttribute("lastName", user.getLastName());
					sesion.setAttribute("email", user.getEmail());
					sesion.setAttribute("role", user.getRol());
					
					if ("admin".equals(user.getRol())) {
						request.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(request, response);
					} else {
						DAOProductLinesImpl daoImpl = new DAOProductLinesImpl();
						ArrayList<ProductLines> categorias = daoImpl.getAll();
						
						request.setAttribute("categorias", categorias);
						request.getRequestDispatcher("/WEB-INF/view/usuario.jsp").forward(request, response);
					}
					
					
				} else {
				
					request.setAttribute("error", "login inválido");
					doGet(request,response);
					return;
				}
			} else {
				   
				request.setAttribute("error", "Usuario no existente");
				doGet(request,response);
				return;
			}
			
			
		}
	}

}
