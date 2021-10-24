<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>
	<jsp:include page="barra.jsp" />
	<jsp:useBean id="usebean"
		class="org.iesalixar.servidor.model.User" scope="request" />

	<h1>ZONA DE USUARIO</h1>
	<h2>Usuario pasado como BEAN</h2>
	<%= usebean.getNombre() %>

</body>
</html>