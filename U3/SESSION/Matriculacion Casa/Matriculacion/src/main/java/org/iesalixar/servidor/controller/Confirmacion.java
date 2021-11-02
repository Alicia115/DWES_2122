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
 * Servlet implementation class Confirmacion
 */
@WebServlet("/Confirmacion")
public class Confirmacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Seleccionar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew()) {
			
			Cookie[] cookies = request.getCookies();
			
			for(Cookie c:cookies) {
				
				if(c.getName().equals("curso")) {
					
					request.setAttribute("curso", c.getValue().equals("1")? "1ºDAW": "2ºDAW");
					
				}
				
			}
			
			request.getRequestDispatcher("confirmacion.jsp").forward(request, response);
			return;
			
		} else {
			logger.error("Intento de entrar en Seleccionar sin tener sesión");
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		
	}

}
