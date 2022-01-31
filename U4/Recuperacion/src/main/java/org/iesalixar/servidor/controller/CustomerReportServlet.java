package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomersImpl;
import org.iesalixar.servidor.dao.DAOOrdersImpl;
import org.iesalixar.servidor.dao.DAOPaymentsImpl;
import org.iesalixar.servidor.model.Customers;

/**
 * Servlet implementation class CustomerReportServlet
 */
@WebServlet("/CustomerReportServlet")
public class CustomerReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerNumber = request.getParameter("cn");
		
		if (customerNumber !=null) {
			
			DAOCustomersImpl daoCustomers= new DAOCustomersImpl();
			DAOPaymentsImpl daoPayents = new DAOPaymentsImpl();
			DAOOrdersImpl daoOrders = new DAOOrdersImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			Customers customer = daoCustomers.getCustomer(Integer.parseInt(customerNumber));
	
			//Pasamos la información a la vista
			request.setAttribute("cliente", customer);
			
			request.getRequestDispatcher("/WEB-INF/view/customerReport.jsp").forward(request, response);
			
		} else {
			response.sendRedirect(request.getContextPath()+"/Home");
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
