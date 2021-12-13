package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomersImpl;
import org.iesalixar.servidor.dao.DAOPaymentsImpl;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Payments;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class UpdatePaymentServlet
 */
@WebServlet("/UpdatePaymentServlet")
public class UpdatePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtengo todo los clientes porque los pasaré para mostrarlos en un select
		
		//Obtengo también el pago correspondiente a los datos del enlace
		String customerNumber = request.getParameter("cn");
		String checkNumber = request.getParameter("checkn");
		
		if (customerNumber!=null && checkNumber!=null) {
			
			DAOPaymentsImpl daoPaymentImpl = new DAOPaymentsImpl();
			DAOCustomersImpl daoCustomerImpl = new DAOCustomersImpl();
			
			//Obtengo el Payment cuyos datos pasaré a la vista
			Payments payment = daoPaymentImpl.getPayment(Integer.parseInt(customerNumber), checkNumber); 
			
			//Obtengo todos los clientes para mostrar los nombre en la vista de edición
			ArrayList<Customers> customers = daoCustomerImpl.getAllCustomers();
			
			//Pasamos la información a la vista
			request.setAttribute("pago", payment);
			request.setAttribute("customers", customers);
			
			
			request.getRequestDispatcher("/WEB-INF/view/updatepayment.jsp").forward(request, response);
		} else {
			response.sendRedirect("InicioPaymentsServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String checkNumber = request.getParameter("checkn");
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String date = request.getParameter("paymentDate");
		Double amount  = Double.parseDouble(request.getParameter("amount"));
		
		System.out.println(checkNumber + customerNumber + date+ amount);
		
		if (checkNumber!=null && customerNumber!=0 && date!=null && amount!=0.0) {
			
			Payments payment = new Payments(customerNumber,checkNumber,date,amount);
			
			DAOPaymentsImpl daoImpl = new DAOPaymentsImpl();
			
			daoImpl.updatePayment(payment);
		}
		
		response.sendRedirect("InicioPaymentsServlet");
		
		
	}

}
