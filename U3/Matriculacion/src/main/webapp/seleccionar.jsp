<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath()%>/Seleccionar">
		<p>
			<label for="nombre">Nombre</label> <input id="nombre" type="text"
				name="nombre" required />
		</p>
		<br>
		<p>
			<label for="apellido">Apellido</label> <input id="apellido"
				type="text" name="apellido" required />
		</p>
		<br>
		<p>
			<label for="email">Email</label> <input id="email" type="text"
				name="email" required />
		</p>
		<br> <input type="radio" name="curso" value="1"> 1º<br>
		<input type="radio" name="curso" value="1"> 2º <br>
		<br> <select name="modulos" multiple>
			<option selected>DAW</option>
			<option>DIW</option>
			<option>DES</option>
			<option>DEC</option>
			<option>HLC</option>
		</select>

		<p>
			<button type="submit" name="matricular">Matricular</button>
		</p>
		<br>

		<a href="Logout"><button type="submit" name="salir" value="SALIR">Salir</button></a>

	</form>

</body>
</html>