<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludo JSP</title>
</head>
<body>
	<%= "Saluditos " + request.getParameter("usuario") %>
</body>
</html>