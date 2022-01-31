<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>
	
	<%if (!session.isNew() && session.getAttribute("usuario")!=null  
			&& session.getAttribute("date") != null) {%>
	
		<jsp:include page="barra.jsp"></jsp:include>
		
		<img src="https://www.lavanguardia.com/files/og_thumbnail/uploads/2018/06/15/5fa43d71a111f.jpeg">
			
		


	<%} else {%>
	
		<h1>CENTRAL DE VIAJES </h1>
		<form method="post">
	
			<p>
				<label for="usuario" class="form-label">Usuario</label> 
				<input class="form-control" type="text" name="usuario" required />
			</p>
	
			<p>
				<label for="password" class="form-label">Password</label> <input
					class="form-control" type="password" name="password" required />
			</p>
			
			<p>
				<label for="confirmpassword" class="form-label">Confirmacion Password</label> <input
					class="form-control" type="password" name="confirmpassword" required />
			</p>
			
			<p>
				<label for="email" class="form-label">Email</label> <input
					class="form-control" type="email" name="email" required />
			</p>
	
			<p>
				<button type="submit" name="registrar" value="REGISTRAR">Registrarse</button>
			</p>
	
	
	
		</form>

	<%}%>

</body>
</html>