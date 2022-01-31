package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLinesImpl;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.ProductLines;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class MostrarProductosServlet
 */

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
			DAOProductsImpl daoProducts = new DAOProductsImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
		
			ArrayList<Products> product = daoProducts.getProductLi(productLine);
	
			//Pasamos la información a la vista
			request.setAttribute("productLi", product);
			request.setAttribute("categoria", productLine);
			
			request.getRequestDispatcher("/WEB-INF/view/productos.jsp").forward(request, response);
			
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
