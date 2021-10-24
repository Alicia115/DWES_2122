<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Confirmación de los datos de matricula</h1>
	<p>
		Nombre:
		<%=session.getAttribute("nombre")%></p>
	<p>
		Apellidos:
		<%=session.getAttribute("apellido")%></p>
	<p>
		Email:
		<%=session.getAttribute("email")%></p>
	
	<p>
		Curso:
		<%=session.getAttribute("curso")%>
	</p>
	<p>
		Modulos:<ul>
		<%
		String[] s=(String[]) session.getAttribute("modulo");
		for (String i:s ){ %>
		<li>
			<%=i%>
		</li>
		<%} %>
		</ul>
		
	</p>


	<p>
		<a href="Logout"><button type="submit" name="salir" value="SALIR">Salir</button></a>
	</p>

</body>
</html>