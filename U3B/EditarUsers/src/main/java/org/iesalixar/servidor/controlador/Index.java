package org.iesalixar.servidor.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DAOUserImpl;
import org.iesalixar.servidor.model.User;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		HttpSession sesion = request.getSession();
		
		DAOUserImpl daoImpl = new DAOUserImpl();
		
		
		if(daoImpl.comprobacionUser(usuario, password)) {
			
			User user = new User();
			user.setUsuario(usuario);
			sesion.setAttribute("usuario",user );
			response.sendRedirect("ListaPagos");
			
			
		} else {
			request.setAttribute("error", "Usuario no registrado");
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		}
	}
	

}
