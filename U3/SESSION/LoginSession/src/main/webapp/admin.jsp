<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	
	<jsp:include page="barra.jsp" />
	<jsp:useBean id="usebean" class="org.iesalixar.servidor.model.User" scope="request"/>
	<h2>Admin pasado por USEBEAN</h2>
	
	<%= usebean.getNombre() %>

</body>
</html>