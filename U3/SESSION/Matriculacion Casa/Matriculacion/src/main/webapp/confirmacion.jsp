<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmacion</title>
</head>
<body>
	<jsp:include page="barra.jsp"></jsp:include>
	
	<h1>Confirmación de los datos de matricula</h1>
	
	<p>Nombre: <%= ((String)session.getAttribute("nombre")) %></p>
	<p>Apellidos: <%= ((String)session.getAttribute("apellidos")) %></p>
	<p>Email: <%= ((String)session.getAttribute("email")) %></p>
	<p>Curso: <%= ((String)session.getAttribute("curso")) %></p>
	<p>Modulos: </p>
	<ul>
		<% String[] modulos = (String[]) session.getAttribute("modulos");
		
			if(modulos.length!=0){
				
				for(int i=0; i<modulos.length; i++){ %>
				
				<li><%= modulos[i]%></li>
					
		<% 			
				}
				
			}else{ %>
				
				<li>No ha seleccionado ningun modulo</li>
			
			<%}%>
	</ul>
	

</body>
</html>