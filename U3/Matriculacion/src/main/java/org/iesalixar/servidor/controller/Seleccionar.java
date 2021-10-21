package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.Arrays;

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
		
		if(!sesion.isNew() && sesion!=null && (boolean)sesion.getAttribute("log")) {
			
			request.getRequestDispatcher("seleccionar.jsp").forward(request, response);
			
		} else {
			
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		Cookie cookie = new Cookie("cookiecurso", request.getParameter("curso"));
		
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellido");
		String email = request.getParameter("email");
		String modulos[] = request.getParameterValues("modulos");
		
		sesion.setAttribute("nombre", nombre);
		sesion.setAttribute("apellido", apellidos);
		sesion.setAttribute("email", email);
		sesion.setAttribute("modulos", modulos);
		response.addCookie(cookie);
		response.sendRedirect("Confirmar");
		
	}

}
