package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final String PASSWORD_REGEX =
		        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
		 
		    private static final Pattern PASSWORD_PATTERN =
		            Pattern.compile(PASSWORD_REGEX);

    /**
     * Default constructor. 
     */
    public Inicio() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password"); //aaLL89Op&
		String confirmpassword = request.getParameter("confirmpassword");
		
		HttpSession sesion = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		if(usuario !=null && password !=null && confirmpassword!=null && 
				request.getParameter("email")!=null && password.equals(confirmpassword) && 
				PASSWORD_PATTERN.matcher(password).matches()){
			
			sesion = request.getSession();
			
			sesion.setAttribute("usuario", usuario);
			
			Date date = new Date();
			date.setTime(sesion.getCreationTime());
			sesion.setAttribute("date", new SimpleDateFormat().format(date));
			
			response.sendRedirect(request.getContextPath()+"/Reservar");
			
			return;
		
		} else {
			
			sesion.invalidate();
			
			response.sendRedirect(request.getContextPath());
			return;
		}
		
		
		
	}

}
