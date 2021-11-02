<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reservar</title>
</head>
<body>

	<jsp:include page="barra.jsp"></jsp:include>

	<h1> DATOS DE LA RESERVA</h1>
	
	<form method="post">
		<label for="fechainicio" class="form-label">Fecha de Inicio</label> 
		<input class="form-control" type="date" name="fechainicio" required />
	
		<label for="fechafinal" class="form-label">Fecha de Fin</label> 
		<input class="form-control" type="date" name="fechafinal" required />
		
		<label for="personas" class="form-label">Numero de personas</label> 
		<input class="form-control" type="number" name="personas" required />
		
		<h3>Servicios</h3>
		
		  <input type="checkbox" id="wifi" name="servicios" value="wifi">
		  <label for="wifi"> Wifi</label><br>
		  <input type="checkbox" id="toallas" name="servicios" value="toallas">
		  <label for="toallas"> Toallas </label><br>
		  <input type="checkbox" id="desayuno" name="servicios" value="desayuno">
		  <label for="desayuno"> Desayuno</label><br><br>
		   <input type="checkbox" id="limpieza" name="servicios" value="limpieza">
		  <label for="limpieza"> Limpieza</label><br><br>
		   <input type="checkbox" id="ruta" name="servicios" value="ruta">
		  <label for="ruta"> Ruta Guiada</label><br><br>
		  <input type="checkbox" id="sauna" name="servicios" value="sauna">
		  <label for="sauna"> Sauna</label><br><br>
		
			<p>
				<button type="submit" name="reservar" value="RESERVAR">Reservar</button>
			</p>
	</form>
	

</body>
</html>