<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />    
<c:set var="examen" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Inicio</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<c:choose>	
				<c:when test="${rol== 'admin'}">
					<h1 class="row justify-content-center" ><fmt:message key="operations" /> <fmt:message key="available" /></h1>
					<ul>
						<li><a class="nav-link" href="${examen }/Admin/Empleados"><fmt:message key="show" /> <fmt:message key="employee" /></a></li>
						<li><a class="nav-link" href="${examen }/Admin/AddEmpleado"><fmt:message key="add" /> <fmt:message key="employee" /></a></li>
					</ul>
				</c:when>
				
				<c:when test="${rol== 'usuario'}">
					<h1 class="row justify-content-center"><fmt:message key="productLines" /> <fmt:message key="available" /></h1>
					<ul class="row justify-content-center">
						<c:forEach items="${productos }" var="pl">
							<li ><a href="MostrarProductos?pl=${pl.productLine }">${pl.productLine }</a></li>
						</c:forEach>
					</ul>
				</c:when>
				
			</c:choose>
		</div>
	</div>
</body>
</html>