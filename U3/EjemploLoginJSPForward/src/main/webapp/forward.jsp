<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward</title>
</head>
<body>
	
	<%
		if ((request.getParameter("usuario").equals("admin"))
				&&(request.getParameter("pass").equals("admin"))){
	%>		
	
			<jsp:forward page="admin.jsp" />
			
	<%
		}else if ((request.getParameter("usuario").equals("usuario"))
				&&(request.getParameter("pass").equals("usuario"))){
	%>		
	
			<jsp:forward page="usuario.jsp" />
		
	<%
		}else {
	%>		
	
			<jsp:forward page="login.jsp">
			<jsp:param name="error" value="El usuario y contrasenia introducido no son validos" />
			</jsp:forward>	
				
	
	<% }%>

</body>
</html>