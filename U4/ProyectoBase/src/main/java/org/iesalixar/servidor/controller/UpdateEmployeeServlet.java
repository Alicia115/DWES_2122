package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.dao.DAOProductLinesImpl;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Offices;
import org.iesalixar.servidor.model.ProductLines;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String employeeNumber = request.getParameter("en");
		
		if (employeeNumber !=null) {
			
			DAOEmployeesImpl daoEmployee = new DAOEmployeesImpl();
			DAOOfficesImpl daoOffice = new DAOOfficesImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			Employees employee = daoEmployee.getEmployee(Integer.parseInt(employeeNumber));
			ArrayList<Offices> oficinas = daoOffice.getAllOffices();
			ArrayList<Employees> empleados = daoEmployee.getAllEmployee();
	
			//Pasamos la información a la vista
			request.setAttribute("empleado", employee);
			request.setAttribute("oficina", oficinas);
			request.setAttribute("empleados", empleados);

			
			request.getRequestDispatcher("/WEB-INF/view/updateemployee.jsp").forward(request, response);
			
			
		} else {
			response.sendRedirect("InicioEmployeesServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int employeeNumber = Integer.parseInt(request.getParameter("en"));
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
			
			daoImpl.updateEmployee(employee);
			
		}
		
		response.sendRedirect("InicioEmployeesServlet");
		
	}

}
