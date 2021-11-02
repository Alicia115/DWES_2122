<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seleccionar</title>
</head>
<body>
		<jsp:include page="barra.jsp"></jsp:include>
		<form method="post">
			<p>
				<label for="nombre"> Nombre</label> <input id="nombre" type="text"
					name="nombre" required />
			</p>
			<br>
			<p>
				<label for="apellidos"> Apellidos</label> <input id="apellidos"
					type="text" name="apellidos" required />
			</p>
			<br>
			<p>
				<label for="email"> Email</label> <input id="email" type="text"
					name="email" required />
			</p>
			<br> <input type="radio" name="curso" value="1"> 1º<br>
			<input type="radio" name="curso" value="2"> 2º<br> <br>
	
			<select name="modulos" multiple>
				<option>DAW</option>
				<option>DIW</option>
				<option>DES</option>
				<option>DEC</option>
				<option>HLC</option>
			</select>
	
	
			<p>
				<button type="submit" name="matricular">Matricular</button>
			</p>
		</form>

</body>
</html>