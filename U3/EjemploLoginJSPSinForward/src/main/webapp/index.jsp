<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Inicio de sesión </h1>

	
	<% if (request.getMethod().equals("POST")){	
		
			if ((request.getParameter("usuario").equals("admin"))
				&&(request.getParameter("pass").equals("admin"))){%>		
	
				<jsp:forward page="admin.jsp" />
			
		<%
			}else if ((request.getParameter("usuario").equals("usuario"))
				&&(request.getParameter("pass").equals("usuario"))){
		%>		
	
				<jsp:forward page="usuario.jsp" />
		
		<%
			}else {
		%>		
	
			<p style= "color:red"> ERROR! Intentelo de nuevo </p>
				
		<% }%>
		
	<% }%>
	
	<form method="post">
		<label for="usuario"> Nombre: </label> <input id= "usuario" type="text" name="usuario" required> <br>
		<br>
		<label for="pass"> Contraseña: </label> <input id= "pass" type="text" name="pass" required> <br>
		<br>
		<button type="submit" name="submit">Enviar</button>
	</form>
	
	
</body>
</html>