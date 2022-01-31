package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOImplPayments;
import org.iesalixar.servidor.model.Payments;

/**
 * Servlet implementation class AdminMainServlet
 */
@WebServlet("/AdminMainServlet")
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOImplPayments daoImpl = new DAOImplPayments ();

		ArrayList<Payments> listaPagos = (ArrayList) daoImpl.getAllPayments();

		request.setAttribute("pagos", listaPagos);

		request.getRequestDispatcher("/WEB-INF/view/admin/index.jsp").forward(request, response);
	}

}
