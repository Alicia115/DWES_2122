
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<fmt:setBundle basename="interface" />   
<c:set var="examen" value="${pageContext.request.contextPath}"/>
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
				<table class="table table-striped table-hover">
					<thead>
						<tr class="table-dark">
							<th><fmt:message key="employeeNumber" /></th>
							<th><fmt:message key="lastName" /></th>
							<th><fmt:message key="firstName" /></th>
							<th><fmt:message key="extension" /></th>
							<th><fmt:message key="email" /></th>
							<th><fmt:message key="city" /></th>
							<th><fmt:message key="reportsTo" /></th>
							<th><fmt:message key="jobTitle" /></th>
						</tr>
					</thead>
					<tbody>
						<a href="${pageContext.request.contextPath}/Admin/AddEmpleado" ><i class="bi bi-pencil-fill row justify-content-end"></i></a>
						<c:forEach items="${empleados}" var="empleado">
						
							<tr>
								<td>${empleado.employeeNumber}</td>
								<td>${empleado.lastName}</td>
								<td>${empleado.firstName}</td>
								<td>${empleado.extension}</td>
								<td>${empleado.email}</td>
								<td>
								<c:forEach items="${oficinas }" var="oficina">
									<c:if test="${empleado.officeCode == oficina.officeCode }">
										${oficina.city }
									</c:if>
								</c:forEach>
								</td>
								<td>
								<c:forEach items="${empleados }" var="emplo">
									<c:if test="${empleado.reportsTo == emplo.employeeNumber }">
										${emplo.firstName } ${emplo.lastName }
									</c:if>
								</c:forEach>
								</td>
								<td>${empleado.jobTitle}</td>
								
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>