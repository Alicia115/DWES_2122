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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productCode = request.getParameter("pc");
		
		if (productCode !=null) {
			
			DAOProductsImpl daoProducts = new DAOProductsImpl();
			DAOProductLinesImpl daoProductLines = new DAOProductLinesImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			Products product = daoProducts.getProduct(productCode);
			ArrayList<ProductLines> productlines = daoProductLines.getAll();
	
			//Pasamos la información a la vista
			request.setAttribute("producto", product);
			request.setAttribute("productLine", productlines);
			
			request.getRequestDispatcher("/WEB-INF/view/updateproduct.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("AdminInicioServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productName = request.getParameter("productName");
		String productCode = request.getParameter("pc");
		String productLine = request.getParameter("productLine");
		String productScale = request.getParameter("productScale");
		String productVendor = request.getParameter("productVendor");
		String productDescription = request.getParameter("productDescription");
		int quantityInStock = Integer.parseInt(request.getParameter("quantityInStock"));
		Double buyPrice = Double.parseDouble(request.getParameter("buyPrice"));
		Double msrp= Double.parseDouble(request.getParameter("msrp"));
		
		System.out.println(productName + productCode + productLine + productScale + productVendor + productDescription + quantityInStock + buyPrice + msrp);
		
		if (productName!=null && productCode!=null && productLine!=null && productScale!=null && productVendor!=null && productDescription!=null && quantityInStock!=0 && buyPrice!=0.0 && msrp!=0.0) {
			
			Products product = new Products(productName,productCode,productLine,productScale,productVendor, productDescription, quantityInStock, buyPrice, msrp);
			
			DAOProductsImpl daoImpl = new DAOProductsImpl();
			
			daoImpl.updateProduct(product);
			
		}
		
		response.sendRedirect("AdminInicioServlet");
	}

}
