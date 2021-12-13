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
							<th><fmt:message key="customerNumber" /></th>
							<th><fmt:message key="checkNumber" /></th>
							<th><fmt:message key="date" /></th>
							<th><fmt:message key="amount" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagos}" var="pago">
							<tr>
								<td>${pago.customerNumber}</td>
								<td>${pago.checkNumber}</td>
								<td>${pago.date}</td>
								<td>${pago.amount}</td>
								<td><a
									href="UpdatePaymentServlet?cn=${pago.customerNumber}&checkn=${pago.checkNumber}"><i class="bi bi-pencil-fill"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>