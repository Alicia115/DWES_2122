package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Offices;

/**
 * Servlet implementation class AddEmpleadoServlet
 */

public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(AddEmpleadoServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployeesImpl daoEmployee = new DAOEmployeesImpl();
		DAOOfficesImpl daoOffice = new DAOOfficesImpl();
		ArrayList<Offices> oficinas = daoOffice.getAllOffices();
		ArrayList<Employees> empleados = daoEmployee.getAllEmployee();
		request.setAttribute("oficina", oficinas);
		request.setAttribute("empleados", empleados);
		
		request.getRequestDispatcher("/WEB-INF/view/addemployee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeNumber = Integer.parseInt(request.getParameter("employeeNumber"));
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String extension = request.getParameter("extension");
		String email = request.getParameter("email");
		String officeCode = request.getParameter("officeCode");
		int reportsTo = Integer.parseInt(request.getParameter("reportsTo"));
		String jobTitle = request.getParameter("jobTitle");
		
		System.out.println(employeeNumber + lastName + firstName + extension + email + officeCode +reportsTo + jobTitle);
		
		if (employeeNumber!=0 && lastName!=null && firstName!=null && extension!=null && email!=null && officeCode!=null && reportsTo!=0 && jobTitle!=null) {
			
			Employees employee = new Employees(employeeNumber,lastName,firstName,extension,email, officeCode, reportsTo, jobTitle);
			
			DAOEmployeesImpl daoImpl = new DAOEmployeesImpl();
			
			if(daoImpl.createEmployee(employee)) {
				
				request.setAttribute("error", "bien");
				logger.info("Empleado añadido correctamente.");
				
			} else {
				
				request.setAttribute("error", "mal");
				logger.info("Error, empleado no añadido.");
				
			}
			
			doGet(request,response);
			return;
			
		} else {
			
			request.setAttribute("error", "mal");
			logger.info("Error, empleado no añadido. ");
			doGet(request,response);
			return;
		}
		
		
	}

}
