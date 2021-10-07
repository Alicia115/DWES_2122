package org.iesalixar.servidor.alicia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploGet
 */
@WebServlet("/EjemploGet")
public class EjemploGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo el elemento para la salida
		PrintWriter out = response.getWriter();
		int numParams = 0;
		
		//Genero la salida de la página
		out.println("<html>");
		out.println("<head><title>Ejemplo de gestión de peticiones GET desde el Servlet</title><head>");
		out.println("<body>");
		
		//Si no recibo parámetros muestro un enlace con parámetros en la query
		//Tb podré obtener un mapa, tengo varias formas de hacerlo
		Enumeration paramEnumeration = request.getParameterNames();
		
		
		if (!paramEnumeration.hasMoreElements() ) {
			
			//No hay parámetros en la petición
			out.println("<p><a href=\"?modulo=servidor&profesor=Alicia \">Pasando parámetros</a></p>");
			
		} else {
			
			//Comienzo de la lista de parámetros
			out.println("<ul>");
			
			while (paramEnumeration.hasMoreElements()) {
				
				//Recorro la lista de parámetros 
				String param = (String) paramEnumeration.nextElement();				
				out.write("<li>He recibido el parámetro "+param+" con el siguiente valor: "+request.getParameter(param)+"</li>");
				
			}
			
			//Fin de la lista de parámetros
			out.println("</ul>");
			
		}
		
		
		
		
		
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

}
