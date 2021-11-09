package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DAOProductLineImpl;
import org.iesalixar.servidor.model.ProductLine;

/**
 * Servlet implementation class LineaProducto
 */
@WebServlet("/LineaProducto")
public class LineaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LineaProducto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOProductLineImpl daoProductImpl = new DAOProductLineImpl();
		
		ArrayList<ProductLine> listaproductos = (ArrayList)daoProductImpl.getAllProductLines();
		
		request.setAttribute("productos", listaproductos);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}


}
