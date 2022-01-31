package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOCustomersImpl;
import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.model.Customers;
import org.iesalixar.servidor.model.Employees;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
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
			DAOEmployeesImpl daoEmployees = new DAOEmployeesImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			Customers customer = daoCustomers.getCustomer(Integer.parseInt(customerNumber));
			ArrayList<Employees> employees = daoEmployees.getAllEmployee();
	
			//Pasamos la información a la vista
			request.setAttribute("cliente", customer);
			request.setAttribute("employee", employees);
			
			request.getRequestDispatcher("/WEB-INF/view/changeAssigment.jsp").forward(request, response);
			
		} else {
			response.sendRedirect(request.getContextPath()+"/Home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		int salesRepEmployeeNumber = Integer.parseInt(request.getParameter("salesRepEmployeeNumber"));
		
		if (customerNumber!=0  && salesRepEmployeeNumber!=0) {
			
			
			DAOCustomersImpl daoImpl = new DAOCustomersImpl();
			
			daoImpl.updateEmployeeCustomer(customerNumber, salesRepEmployeeNumber);
			
		}
		response.sendRedirect(request.getContextPath()+"/Home");
		
	}

}
