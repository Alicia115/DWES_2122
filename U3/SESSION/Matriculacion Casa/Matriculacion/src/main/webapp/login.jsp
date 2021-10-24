<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<%if (!session.isNew() && session.getAttribute("usuario")!=null) {%>
	
		<p>Esta logeado con el usuario <%= session.getAttribute("usuario") %></p>
			
		<a href="Logout"><button type="submit" name="entrar" value="SALIR">Salir</button></a>


	<%} else {%>
	
		
		<form method="post">
	
			<p>
				<label for="usuario" class="form-label">Usuario</label> <input
					class="form-control" type="text" name="usuario" required />
			</p>
	
			<p>
				<label for="password" class="form-label">Password</label> <input
					class="form-control" type="text" name="password" required />
			</p>
	
	
			<p>
				<button type="submit" name="entrar" value="ENTRAR">Entrar</button>
			</p>
	
	
	
		</form>

	<%}%>




</body>
</html>