<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Inicio de sesión </h1>
	
	<% if (request.getParameter("error") !=null){
			
	%>
		<p style= "color:red">
		
		<%= request.getParameter("error") %>
		
		 </p>
	<% }%>
	
	<form action="forward.jsp" method="post">
		<label for="usuario"> Nombre: </label> <input id= "usuario" type="text" name="usuario" required> <br>
		<br>
		<label for="pass"> Contraseña: </label> <input id= "pass" type="text" name="pass" required> <br>
		<br>
		<button type="submit" name="submit">Enviar</button>
	</form>
</body>
</html>