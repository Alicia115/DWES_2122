<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conversor dolares</title>
</head>
<body>
	<h1>Conversor a dolares</h1>
	
	<form method="post">
		<label for="n1"> Introduce la cantidad a convertir: </label> <input id= "n1" type="number" name="n1" required> <br>
		<br>
		<button type="submit" name="submit">Enviar</button>
	</form>
	<br>
	<h3>Respuesta:</h3>
	
	<% if (request.getMethod().equals("POST")){
		
		double num1 = Integer.parseInt(request.getParameter("n1")) ;
		
		double conversor = num1*1.16;
		
		%>
		
		
		<%= "La cantidad en euros de "+ num1+ " equivale a " + conversor+ " dolares." %>
		
	<% }%>
</body>
</html>