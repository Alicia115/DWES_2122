<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Conversor a dólares</h1>
	
	<form method="post">
		 <p>
	    	Escoge en que dinero quiere convertir dicha cantidad:
	    	<select name="convertidor">
	      		<option value="dolares">Dólares a euro</option>
	      		<option value="euros">Euros a dólares</option>
	    </select>
	  	</p>
		<label for="num">Convertir de euros a dólares: </label><input id="num" type="number" name="num"/><br>
		<button type="submit" value="convertir">Convertir</button>
	</form>
	
	<h3>Respuesta: </h3>
	
	<%if (request.getMethod().equals("POST")) {
		
		if (request.getParameter("convertidor").equals("dolares"))
		
	%>
	
	
	
	<%} %>


</body>
</html>