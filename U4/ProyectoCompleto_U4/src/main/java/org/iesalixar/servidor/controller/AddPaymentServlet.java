package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOImplCustomers;
import org.iesalixar.servidor.dao.DAOImplPayments;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Payments;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Obtengo los datos de todos los clientes para pasarlo a la vista y
				// mostrarlos en el select como opciones
				DAOImplCustomers daoImpl = new DAOImplCustomers();
				ArrayList<Customers> customers = daoImpl.getAllCustomers();
				
				//Lo añado a la petición que se le pasa a la vista
				request.setAttribute("customers", customers);
				
				request.getRequestDispatcher("/WEB-INF/view/admin/addpayment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo los parámetros
				String customerNumber = request.getParameter("customerNumber");
				String checkNumber = request.getParameter("checkNumber");
				String date = request.getParameter("paymentDate");
				String amount = request.getParameter("amount");
				
				if (customerNumber!=null && checkNumber!=null && date!=null && amount!=null) {
					
					Payments payment = new Payments(Integer.parseInt(customerNumber),checkNumber,date,Double.parseDouble(amount));
					
					DAOImplPayments dao = new DAOImplPayments();
					
					dao.insertPayment(payment);
					
				}
				
				response.sendRedirect(request.getContextPath()+"/Admin/");
	}

}
