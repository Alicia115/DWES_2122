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
 * Servlet implementation class UpdateProductLineServlet
 */
@WebServlet("/UpdateProductLineServlet")
public class UpdateProductLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductLineServlet() {
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
			
			request.getRequestDispatcher("/WEB-INF/view/updateproductline.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("InicioProductLineServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productLine = request.getParameter("pl");
		String textDescription = request.getParameter("textDescription");
		String htmlDescription = request.getParameter("htmlDescription");

		
		
		if (productLine!=null && textDescription!=null && htmlDescription!=null ) {
			
			ProductLines productline = new ProductLines(productLine,textDescription,htmlDescription);
			
			DAOProductLinesImpl daoImpl = new DAOProductLinesImpl();
			
			daoImpl.updateProductLine(productline);
			
		}
		
		response.sendRedirect("InicioProductLineServlet");
	}

}
