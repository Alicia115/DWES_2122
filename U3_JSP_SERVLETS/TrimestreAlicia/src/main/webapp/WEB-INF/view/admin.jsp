
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<fmt:setBundle basename="interface" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>	
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-11">
				<h1>OPERACIONES DISPONIBLES</h1>
					<ul>
						<li>
							<a href="EmpleadosServlet">Mostrar Empleados</a>
						</li>
						<li>
							<a href="AddEmpleadoServlet">Añadir Empleados</a>
						</li>
					</ul>
			</div>
		</div>
	</div>
	
</body>
</html>>