<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmacion reserva</title>
</head>
<body>

	<jsp:include page="barra.jsp"></jsp:include>
	
	<jsp:useBean id="userBean" scope="session" class="org.iesalixar.servidor.model.Reserva"> 
	</jsp:useBean>
	
	<h1>RESERVA CONFIRMADA</h1>
	<p>FECHA DE INICIO: <%= (userBean.getFechainicio()) %></p>
	<p>FECHA DE FIN: <%= (userBean.getFechafinal()) %></p>
	<p>NUMERO DE PERSONAS: <%= (userBean.getPersonas()) %></p>
	<p>SERVICIOS RESERVADOS: <%= (userBean.getServicios()) %> </p>
	
	
	

</body>
</html>