package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomersImpl;
import org.iesalixar.servidor.dao.DAOOrdersImpl;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Orders;

/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderNumber = request.getParameter("on");
		
		if (orderNumber!=null ) {
			
			DAOOrdersImpl daoOrder= new DAOOrdersImpl();
			DAOCustomersImpl daocustomer = new DAOCustomersImpl();
			
			//Obtengo el Payment cuyos datos pasaré a la vista
			Orders order = daoOrder.getOrder(Integer.parseInt(orderNumber));
			
			//Obtengo todos los clientes para mostrar los nombre en la vista de edición
			ArrayList<Customers> customers = daocustomer.getAllCustomers();
			
			//Pasamos la información a la vista
			request.setAttribute("orders", order);
			request.setAttribute("customer", customers);
			
			
			request.getRequestDispatcher("/WEB-INF/view/updateorder.jsp").forward(request, response);
		} else {
			response.sendRedirect("InicioOrdersServlet");
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
