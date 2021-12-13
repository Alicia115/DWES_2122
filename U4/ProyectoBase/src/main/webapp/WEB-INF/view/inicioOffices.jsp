
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
				<table class="table table-striped table-hover">
					<thead>
						<tr class="table-dark">
							<th><fmt:message key="officeCode" /></th>
							<th><fmt:message key="city" /></th>
							<th><fmt:message key="phone" /></th>
							<th><fmt:message key="addressLine1" /></th>
							<th><fmt:message key="addressLine2" /></th>
							<th><fmt:message key="state" /></th>
							<th><fmt:message key="country" /></th>
							<th><fmt:message key="postalCode" /></th>
							<th><fmt:message key="territory" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${oficinas}" var="oficina">
							<tr>
								<td>${oficina.officeCode}</td>
								<td>${oficina.city}</td>
								<td>${oficina.phone}</td>
								<td>${oficina.addressLine1}</td>
								<td>${oficina.addressLine2}</td>
								<td>${oficina.state}</td>
								<td>${oficina.country}</td>
								<td>${oficina.postalCode}</td>
								<td>${oficina.territory}</td>
								<td><a
									href="UpdateOfficeServlet?oc=${oficina.officeCode}"><i class="bi bi-pencil-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>