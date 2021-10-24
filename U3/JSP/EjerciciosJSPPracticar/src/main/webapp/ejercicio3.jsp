<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ejercicio media</title>
</head>
<body>
	<h1>Calcula la media de tres numeros</h1>
	<br>
	
	<form method="post">
		<label for="n1"> Numero 1: </label> <input id= "n1" type="number" name="n1" required> <br>
		<br>
		<label for="n2"> Numero 2: </label> <input id= "n2" type="number" name="n2" required> <br>
		<br>
		<label for="n3"> Numero 3: </label> <input id= "n3" type="number" name="n3" required> <br>
		<br>
		<button type="submit" name="submit">Enviar</button>
	</form>
	<br>
	<h3>Respuesta:</h3>
	
	<% if (request.getMethod().equals("POST")){
		
		int num1 = Integer.parseInt(request.getParameter("n1")) ;
		int num2 = Integer.parseInt(request.getParameter("n2")) ;
		int num3 = Integer.parseInt(request.getParameter("n3")) ;
		
		int media = (num1+num2+num3)/3;
		
		%>
		
		
		<%= "La media de los tres numeros es " + media %>
		
	<% }%>
	
	
	
</body>
</html>