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
 * Servlet implementation class EjemploPost
 */
@WebServlet("/EjemploPost")
public class EjemploPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EjemploPost() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Muestro un formulario para recoger nombre y apellidos del usuario
				PrintWriter out = response.getWriter();

				out.println("<html>");
				out.println("<head><title>Ejemplo de gestión de peticiones POST desde el Servlet</title><head>");
				out.println("<body>");
				out.println("<h1>Inicio Sesion</h1>");
				out.println(
						"<p>Introduce usuario y contraseña</p>");

				out.println("<form method=\"post\">");
				out.println("<label for=\"usuario\">Usuario:<br></label><input id=\"usuario\" type=\"text\" name=\"usuario\"><br>");
				out.println(
						"<label for=\"contra\">Contraseña:<br></label><input id=\"contra\" type=\"text\" name=\"contra\"><br><br>");
				out.println("<button type=\"submit\" name=\"submit\">Enviar</button>");
				out.println("</form>");
				out.println("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Enumeration paramEnumeration = request.getParameterNames();
		String usuario = request.getParameter("usuario");
		String contra = request.getParameter("contra");

		if (usuario.equals("admin") && contra.equals("admin")) {

			// No hay parámetros en la petición
			out.println("Se ha iniciado sesión correctamente");
			
		} else {

			// Comienzo de la lista de parámetros
			
			
			out.println("<html>");
			out.println("<head><title>Ejemplo de gestión de peticiones POST desde el Servlet</title><head>");
			out.println("<body>");
			out.println("<h1>Inicio Sesion</h1>");
			out.println("<h4 style=\"color:crimson\">Datos introducidos incorrectamente</h4>");
			out.println(
					"<p>Introduce usuario y contraseña</p>");

			out.println("<form method=\"post\">");
			out.println("<label for=\"usuario\">Usuario:<br></label><input id=\"usuario\" type=\"text\" name=\"usuario\"><br>");
			out.println(
					"<label for=\"contra\">Contraseña:<br></label><input id=\"contra\" type=\"text\" name=\"contra\"><br><br>");
			out.println("<button type=\"submit\" name=\"submit\">Enviar</button>");
			out.println("</form>");
			out.println("</body></html>");
			
		

		}
	}

}
