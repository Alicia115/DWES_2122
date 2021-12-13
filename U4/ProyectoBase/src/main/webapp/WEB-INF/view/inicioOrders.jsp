
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
							<th><fmt:message key="orderNumber" /></th>
							<th><fmt:message key="orderDate" /></th>
							<th><fmt:message key="requiredDate" /></th>
							<th><fmt:message key="shippedDate" /></th>
							<th><fmt:message key="status" /></th>
							<th><fmt:message key="comments" /></th>
							<th><fmt:message key="customerNumber" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${order}" var="orde">
							<tr>
								<td>${orde.orderNumber}</td>
								<td>${orde.orderDate}</td>
								<td>${orde.requiredDate}</td>
								<td>${orde.shippedDate}</td>
								<td>${orde.status}</td>
								<td>${orde.comments}</td>
								<td>${orde.customerNumber}</td>
								<td><a
									href="UpdateOrderServlet?on=${orde.orderNumber}"><i class="bi bi-pencil-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>