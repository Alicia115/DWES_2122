<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entrar Sesion</title>
</head>
<body>

	<% if(!session.isNew()){ %>


		<a href="Logout"><button type="submit" name="salir" value="SALIR">Salir</button></a>

	<% } else { %>
	
		<form method="post">
			<p>
				<button type="submit" name="entrar" value="ENTRAR">Entrar</button>
			</p>
	
	
		</form>
	
	<% } %>



</body>
</html>