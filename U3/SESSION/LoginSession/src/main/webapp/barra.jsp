<%@ page import="org.iesalixar.servidor.model.User" %>

<div class="d-flex justify-content-end">

	<h4>
		<%
			User usuario = (User) session.getAttribute("usuario");
		
			out.println(usuario.getNombre());
		%>
	
	
	</h4>
	
	<a href="Logout">Logout</a>

</div>