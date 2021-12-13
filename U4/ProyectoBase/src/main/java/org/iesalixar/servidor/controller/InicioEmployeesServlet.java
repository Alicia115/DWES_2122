package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOEmployeesImpl;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Payments;

/**
 * Servlet implementation class InicioEmployeesServlet
 */
@WebServlet("/InicioEmployeesServlet")
public class InicioEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOEmployeesImpl dao = new DAOEmployeesImpl();
		ArrayList<Employees> employees = dao.getAllEmployee();
		
		
		request.setAttribute("empleados", employees);
		
		request.getRequestDispatcher("/WEB-INF/view/inicioemployees.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
