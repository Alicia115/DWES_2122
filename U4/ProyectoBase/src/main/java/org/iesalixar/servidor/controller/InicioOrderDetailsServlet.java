package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOOrderDetailsImpl;
import org.iesalixar.servidor.model.OrderDetails;
import org.iesalixar.servidor.model.Payments;

/**
 * Servlet implementation class InicioOrderDetailsServlet
 */
@WebServlet("/InicioOrderDetailsServlet")
public class InicioOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOOrderDetailsImpl dao = new DAOOrderDetailsImpl();
		ArrayList<OrderDetails> orderdetails = dao.getAllOrderDetails();
		
		
		request.setAttribute("orderdetail", orderdetails);
		
		request.getRequestDispatcher("/WEB-INF/view/inicioOrderDetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
