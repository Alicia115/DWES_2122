package org.iesalixar.servidor.controller;
import org.apache.log4j.Logger;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Seleccionar
 */
@WebServlet("/Seleccionar")
public class Seleccionar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Seleccionar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seleccionar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew()) {
			request.getRequestDispatcher("seleccionar.jsp").forward(request, response);
			return;
			
		}
			
			logger.error("Intento de entrar en Seleccionar sin tener sesión");
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			return;

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew() && sesion.getAttribute("usuario")!=null) {
			
			
			if(request.getParameter("nombre")!=null || request.getParameter("apellidos")!=null || request.getParameter("email")!=null ||
					request.getParameter("curso")!=null || request.getParameter("modulos")!=null) {
				
				sesion.setAttribute("nombre", request.getParameter("nombre"));
				sesion.setAttribute("apellidos", request.getParameter("apellidos"));
				sesion.setAttribute("email", request.getParameter("email"));
				sesion.setAttribute("modulos", request.getParameterValues("modulos"));
				
				Cookie cookie = new Cookie("curso", request.getParameter("curso"));
				response.addCookie(cookie);
				
				response.sendRedirect(request.getContextPath() + "/Confirmacion");
				
				
			}else {
				
				logger.error("Faltan parámetros o el email es incorrecto");
				
				response.sendRedirect(request.getContextPath()+"/Seleccionar");
				return;
				
				
			}
			
			
			
			
		} 
		
			logger.error("Intento de entrar en Seleccionar sin tener sesión");
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			return;
			
		
		
		
		
		
	}

}
