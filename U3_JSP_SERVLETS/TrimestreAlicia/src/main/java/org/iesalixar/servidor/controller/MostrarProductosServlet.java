package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLinesImpl;
import org.iesalixar.servidor.model.ProductLines;

/**
 * Servlet implementation class MostrarProductosServlet
 */
@WebServlet("/MostrarProductosServlet")
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productLine = request.getParameter("pl");
		
		if (productLine !=null) {
			
			DAOProductLinesImpl daoProductLines = new DAOProductLinesImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			ProductLines productL = daoProductLines.getProductLine(productLine);
	
			//Pasamos la información a la vista
			request.setAttribute("productLi", productL);
			
			request.getRequestDispatcher("/WEB-INF/view/mostrarProductos.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("InicioServlet");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
