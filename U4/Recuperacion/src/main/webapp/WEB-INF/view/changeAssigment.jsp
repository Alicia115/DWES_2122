<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />    
<jsp:include page="include/bootstrap.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Asignacion del cliente</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<h2><fmt:message key="customer" />: ${cliente.customerName} </h2>
				<h2><fmt:message key="contactCustomer" />: ${cliente.contactFirstName} ${cliente.contactLastName} </h2>
				<form method="post">	 				
    				<label for="salesRepEmployeeNumber" class="form-label mt-3"><fmt:message key="empleadoAsignado" /></label>
    				<select name="salesRepEmployeeNumber" class="form-select">
    					<c:forEach items="${employee}" var="em">
    						<c:choose>
    							<c:when test="${em.employeeNumber == cliente.salesRepEmployeeNumber}">
    								<option value="${em.employeeNumber }" selected>${em.firstName} ${em.lastName}</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${em.employeeNumber }">${em.firstName} ${em.lastName}</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				 
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="asignar" />" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>