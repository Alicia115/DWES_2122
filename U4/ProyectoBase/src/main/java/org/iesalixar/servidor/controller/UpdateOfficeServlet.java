package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOfficesImpl;
import org.iesalixar.servidor.dao.DAOProductsImpl;
import org.iesalixar.servidor.model.Offices;
import org.iesalixar.servidor.model.Products;

/**
 * Servlet implementation class UpdateOfficeServlet
 */
@WebServlet("/UpdateOfficeServlet")
public class UpdateOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String officeCode = request.getParameter("oc");
		
		if (officeCode !=null) {
			
			DAOOfficesImpl daoOffices = new DAOOfficesImpl();
			
			//Obtengo el Product cuyos datos pasaré a la vista
			
			Offices office = daoOffices.getOffice(officeCode);
	
			//Pasamos la información a la vista
			request.setAttribute("oficina", office);
			
			request.getRequestDispatcher("/WEB-INF/view/updateoffice.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("InicioOfficeServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String officeCode = request.getParameter("oc");
		String city = request.getParameter("city");
		String phone = request.getParameter("phone");
		String addressLine1 = request.getParameter("addressLine1");
		String addressLine2 = request.getParameter("addressLine2");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String postalCode = request.getParameter("postalCode");
		String territory = request.getParameter("territory");
		
		
		
		if (officeCode!=null && city!=null && phone!=null && addressLine1!=null && addressLine2!=null && state!=null && country!=null && postalCode!=null && territory!=null) {
			
			Offices office = new Offices(officeCode,city,phone,addressLine1,addressLine2, state, country, postalCode, territory);
			
			DAOOfficesImpl daoImpl = new DAOOfficesImpl();
			
			daoImpl.updateOffice(office);
			
		}
		
		response.sendRedirect("InicioOfficeServlet");
	}

}
