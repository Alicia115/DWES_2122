package org.iesalixar.servidor.controller;
import org.apache.log4j.Logger;
import org.iesalixar.servidor.model.Reserva;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Reservar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew()&& sesion.getAttribute("usuario")!= null 
				&& sesion.getAttribute("date") != null) {
			request.getRequestDispatcher("reservar.jsp").forward(request, response);
			return;
			
		}
			
			logger.error("No se puede reservar sin registro previo.");
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession(); 
		
		
		if(!sesion.isNew() && sesion.getAttribute("usuario")!= null 
				&& sesion.getAttribute("date") != null) {
			
			String fechainicio = request.getParameter("fechainicio");
			String fechafinal = request.getParameter("fechafinal");
			int personas = Integer.parseInt(request.getParameter("personas"));
			String[] servicios = request.getParameterValues("servicios");
			
			Reserva registro = new Reserva();
			
			registro.setFechainicio(fechainicio);
			registro.setFechafinal(fechafinal);
			registro.setPersonas(personas);
			registro.setServicios(new ArrayList<String>(Arrays.asList(servicios)));
			
			sesion.setAttribute("userBean",registro);
			
			response.sendRedirect(request.getContextPath()+"/Confirmar");
			return;
			
		} else {
			
			logger.error("No se puede reservar sin registro previo.");
			sesion.invalidate();
			response.sendRedirect(request.getContextPath());
			return;
		}
	
		
	}

}
