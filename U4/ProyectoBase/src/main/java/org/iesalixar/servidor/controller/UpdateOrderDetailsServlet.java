package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderDetailsImpl;
import org.iesalixar.servidor.dao.DAOOrdersImpl;
import org.iesalixar.servidor.dao.DAOPaymentsImpl;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.OrderDetails;
import org.iesalixar.servidor.model.Orders;
import org.iesalixar.servidor.model.Payments;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class UpdateOrderDetailsServlet
 */
@WebServlet("/UpdateOrderDetailsServlet")
public class UpdateOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNumber = request.getParameter("on");
		String productCode = request.getParameter("pc");
		
		if (orderNumber!=null && productCode!=null) {
			
			DAOOrderDetailsImpl daood = new DAOOrderDetailsImpl();
			DAOProductsImpl daopro = new DAOProductsImpl();
			DAOOrdersImpl daoorder = new DAOOrdersImpl();
			
			//Obtengo el Payment cuyos datos pasaré a la vista
			OrderDetails orderdetail = daood.getOrderDetail(Integer.parseInt(orderNumber), productCode);
			
			//Obtengo todos los clientes para mostrar los nombre en la vista de edición
			ArrayList<Products> products = daopro.getAllProducts();
			ArrayList<Orders> order = daoorder.getAllOrders();
			
			//Pasamos la información a la vista
			request.setAttribute("orderdetails", orderdetail);
			request.setAttribute("productos", products);
			request.setAttribute("orders", order);
			
			
			request.getRequestDispatcher("/WEB-INF/view/updateorderdetails.jsp").forward(request, response);
		} else {
			response.sendRedirect("InicioOrderDetailsServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int orderNumber = Integer.parseInt(request.getParameter("on"));
		String productCode = request.getParameter("pc");
		int quantityOrdered = Integer.parseInt(request.getParameter("quantityOrdered"));
		Double priceEach  = Double.parseDouble(request.getParameter("priceEach"));
		int orderLineNumber = Integer.parseInt(request.getParameter("orderLineNumber"));
		
		if (orderNumber!=0 && productCode!=null && quantityOrdered!=0 && priceEach!=0.0 && orderLineNumber!=0 ) {
			
			OrderDetails orderdetail = new OrderDetails(orderNumber,productCode,quantityOrdered,priceEach, orderLineNumber);
			
			DAOOrderDetailsImpl dao = new DAOOrderDetailsImpl();
			
			dao.updateOrderDetail(orderdetail);
		}
		
		response.sendRedirect("InicioOrderDetailsServlet");
		
	}

}
