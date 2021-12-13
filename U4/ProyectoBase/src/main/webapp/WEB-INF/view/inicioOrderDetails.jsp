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
						<tr>
							<th><fmt:message key="orderNumber" /></th>
							<th><fmt:message key="productCode" /></th>
							<th><fmt:message key="quantityOrdered" /></th>
							<th><fmt:message key="priceEach" /></th>
							<th><fmt:message key="orderLineNumber" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${orderdetail}" var="ode">
							<tr>
								<td>${ode.orderNumber}</td>
								<td>${ode.productCode}</td>
								<td>${ode.quantityOrdered}</td>
								<td>${ode.priceEach}</td>
								<td>${ode.orderLineNumber}</td>
								<td><a
									href="UpdateOrderDetailsServlet?od=${ode.orderNumber}&pd=${ode.productCode}"><i class="bi bi-pencil-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>