package org.iesalixar.servidor.controller;
import org.apache.log4j.Logger;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Confirmar
 */
@WebServlet("/Confirmar")
public class Confirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Confirmar.class);

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sesion = request.getSession();
		
		if(!sesion.isNew() && sesion.getAttribute("usuario")!= null 
				&& sesion.getAttribute("date") != null) {
			
			request.getRequestDispatcher("confirmar.jsp").forward(request, response);
			return;
			
		}
		
		logger.error("No puede confirmar reserva sin haberse registrado");
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
		
		
	}

}
