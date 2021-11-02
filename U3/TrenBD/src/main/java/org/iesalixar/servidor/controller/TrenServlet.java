package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.modelo.Maquinista;
import org.iesalixar.servidor.modelo.Tren;
import org.iesalixar.servidor.modelo.Vagon;

/**
 * Servlet implementation class TrenServlet
 */
@WebServlet("/TrenServlet")
public class TrenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Maquinista maquinista = new Maquinista("Pepe", "Perez", "2547896Z");
		
		ArrayList<Vagon> vagones = new ArrayList<>();
		
		Vagon v1 = new Vagon(1900, 233);
		Vagon v2 = new Vagon(1700, 253);
		Vagon v3 = new Vagon(1400, 123);
		Vagon v4 = new Vagon(1200, 913);
		Vagon v5 = new Vagon(1100, 733);
		
		vagones.add(v5);
		vagones.add(v4);
		vagones.add(v3);
		vagones.add(v2);
		vagones.add(v1);
		
		Tren tren = new Tren ("AVE", maquinista, vagones);
		
		request.setAttribute("tren", tren);
		
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		
		
		
		
	}

}
