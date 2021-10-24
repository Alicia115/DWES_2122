<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%= request.getContextPath()%>/Formularios">
		<p>
			<label for="simple">Campo de formulario simple</label>
			 <input id= "simple" type="text" name="simple" required />
		</p><br>
		
		<p><label for="checkbox">Campo de formulario checkbox</label></p>
		<input type="checkbox" name="checkbox" value="A"> Opcion A<br>
		<input type="checkbox" name="checkbox" value="B"> Opcion B<br>
		<input type="checkbox" name="checkbox" value="C"> Opcion C<br>
		<input type="checkbox" name="checkbox" value="D"> Opcion D<br>
		<input type="checkbox" name="checkbox" value="E"> Opcion E<br>
		<br>
		<select name="select" multiple>
			<option> Seleccion A</option>
			<option selected> Seleccion B</option>
			<option> Seleccion C</option>
			<option> Seleccion D</option>
			<option> Seleccion E</option>
		</select>
		
		
		<p><button type="submit" name="submit">Enviar</button></p>
	</form>
</body>
</html>