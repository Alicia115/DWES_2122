package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOCustomersImpl;
import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Offices;

/**
 * Servlet implementation class AddCustomerServlet
 */
@WebServlet("/AddCustomerServlet")
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(AddCustomerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeesImpl daoEmployee = new DAOEmployeesImpl();
		ArrayList<Employees> empleados = daoEmployee.getAllEmployee();
		request.setAttribute("empleados", empleados);
		
		request.getRequestDispatcher("/WEB-INF/view/addCustomer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
		String customerName = request.getParameter("customerName");
		String contactLastName = request.getParameter("contactLastName");
		String contactFirstName = request.getParameter("contactFirstName");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String country = request.getParameter("country");
		int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		Double creditLimit = Double.parseDouble(request.getParameter("creditLimit"));
		
		if (customerNumber!=0 && customerName!=null && contactLastName!=null && contactFirstName!=null && phone!=null && addressLine1!=null && addressLine2!=null && 
				city!=null && state!=null && postalCode!=null && country!=null && salesRepEmployeeNumber!=0 && creditLimit!=0.0) {
			
			Customers customer = new Customers(customerNumber,customerName,contactLastName,contactFirstName,phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber,creditLimit);
			
			DAOCustomersImpl daoImpl = new DAOCustomersImpl();
			
			daoImpl.createCustomer(customer);
			
			/*if(daoImpl.createCustomer(customer)) {
				
				request.setAttribute("error", "bien");
				logger.info("Cliente añadido correctamente.");
				
			} else {
				
				request.setAttribute("error", "mal");
				logger.info("Error, cliente no añadido.");
				
			}
			
			doGet(request,response);
			return;*/
		
		}else {
			
			request.setAttribute("error", "mal");
			logger.info("Error, cliente no añadido. ");
			doGet(request,response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/Home");
		
	}

}
