<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Barra</title>
</head>
<body>
	<p>
		<a href="<%= request.getContextPath() %>"><button type="submit" name="volver">Volver</button></a>
	</p>
	
	<p>
		<a href="<%= request.getContextPath()+"/Logout" %>"><button type="submit" name="volver">Salir</button></a>
	</p>
	
	<p>Usuario: <%= session.getAttribute("usuario") %>
	<p>Sesion: <%= session.getAttribute("date") %>
	
	</p>
</body>
</html>