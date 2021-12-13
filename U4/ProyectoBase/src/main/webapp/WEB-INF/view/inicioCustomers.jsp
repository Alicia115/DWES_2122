
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
							<th><fmt:message key="customerNumber" /></th>
							<th><fmt:message key="customerName" /></th>
							<th><fmt:message key="contactLastName" /></th>
							<th><fmt:message key="contactFirstName" /></th>
							<th><fmt:message key="phone" /></th>
							<th><fmt:message key="addressLine1" /></th>
							<th><fmt:message key="addressLine2" /></th>
							<th><fmt:message key="city" /></th>
							<th><fmt:message key="state" /></th>
							<th><fmt:message key="postalCode" /></th>
							<th><fmt:message key="country" /></th>
							<th><fmt:message key="salesRepEmployeeNumber" /></th>
							<th><fmt:message key="creditLimit" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.customerNumber}</td>
								<td>${cliente.customerName}</td>
								<td>${cliente.contactLastName}</td>
								<td>${cliente.contactFirstName}</td>
								<td>${cliente.phone}</td>
								<td>${cliente.addressLine1}</td>
								<td>${cliente.addressLine2}</td>
								<td>${cliente.city}</td>								
								<td>${cliente.state}</td>
								<td>${cliente.postalCode}</td>
								<td>${cliente.country}</td>
								<td>${cliente.salesRepEmployeeNumber}</td>
								<td>${cliente.creditLimit}</td>
								<td><a
									href="UpdateCustomerServlet?cn=${cliente.customerNumber}"><i class="bi bi-pencil-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>