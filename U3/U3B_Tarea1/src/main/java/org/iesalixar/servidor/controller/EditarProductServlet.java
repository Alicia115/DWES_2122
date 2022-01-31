package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class EditarProductServlet
 */
@WebServlet("/EditarProductServlet")
public class EditarProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String productCode = request.getParameter("p");
	
		
		if (productCode!=null) {
			
			DAOProductImpl dao = new DAOProductImpl();
			
			Product producto = dao.getProduct(productCode);
			
		
			request.setAttribute("producto", producto);
			
			
			
			request.getRequestDispatcher("/WEB-INF/view/admin/editarproductos.jsp").forward(request, response);
		} else {
			response.sendRedirect("/Admin/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("productName");
		String productCode = request.getParameter("productCode");
		String productLine = request.getParameter("productLine");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		Double msrp= Double.parseDouble(request.getParameter("msrp"));
		
		if (productName!=null && productCode!=null && productLine!=null && productScale!=null && productVendor!=null && productDescription!=null && quantityInStock!=0 && buyPrice!=0.0 && msrp!=0.0) {
			
			Product product = new Product(productName,productCode,productLine,productScale,productVendor, productDescription, quantityInStock, buyPrice, msrp);
			
			DAOProductImpl daoImpl = new DAOProductImpl();
			
			daoImpl.updateProduct(product);
			
		}
		
		response.sendRedirect("/Admin/");
		
		
	}

}
