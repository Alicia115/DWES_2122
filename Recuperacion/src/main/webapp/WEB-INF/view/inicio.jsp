<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />    
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
					<div class="col-11">
						<table class="table table-striped table-hover">
							<thead>
								<tr class="table-dark">
									<th><fmt:message key="customerNumber" /></th>
									<th><fmt:message key="customerName" /></th>
									<th><fmt:message key="contactFirstName" /></th>
									<th><fmt:message key="contactLastName" /></th>
						
									<th><fmt:message key="phone" /></th>
									<th><fmt:message key="options" /></th>
								</tr>
							</thead>
							<tbody>
								<a href="${pageContext.request.contextPath}/Admin/AddCustomer" ><button type="button" class="btn btn-primary"><fmt:message key="add" /> <fmt:message key="customer" /></button></a>
								<c:forEach items="${clientes}" var="cliente">
									<tr>
										<td>${cliente.customerNumber}</td>
										
										<td>${cliente.customerName}</td>
										<td>${cliente.contactFirstName}</td>
										<td>${cliente.contactLastName}</td>
										
										<td>${cliente.phone}</td>
										<td><a
											href="ChangeAssigmentServlet?cn=${cliente.customerNumber}"><i class="bi bi-people"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</c:when>
				
				<c:when test="${rol== 'usuario'}">
					<div class="col-11">
						<table class="table table-striped table-hover">
							<thead>
								<tr class="table-dark">
									<th><fmt:message key="customerNumber" /></th>
									<th><fmt:message key="customerName" /></th>
									<th><fmt:message key="contactLastName" /></th>
									<th><fmt:message key="contactFirstName" /></th>
									<th><fmt:message key="phone" /></th>
									<th><fmt:message key="options" /></th>
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
										<td><a
											href="CustomerReportServlet?cn=${cliente.customerNumber}"><i class="bi bi-eye-fill"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
							
						</table>
					</div>
				</c:when>
				
			</c:choose>
		</div>
	</div>
</body>
</html>