<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mostrando los datos del formulario</h1>
	<p>Simple: <%= request.getAttribute("simple") %> </p>
	<p>Checkbox: <%= request.getAttribute("checkbox") %> </p>
	<p>Select: <%= request.getAttribute("select") %> </p>
</body>
</html>