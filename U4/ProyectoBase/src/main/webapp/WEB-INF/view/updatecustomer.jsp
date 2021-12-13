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
<title>Actualización del cliente</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="customerNumber" class="form-label mt-3"><fmt:message key="customerNumber" /></label>
    				<input type="text" class="form-control" id="customerNumber" name="customerNumber" value="${cliente.customerNumber}" disabled >	
    				<label for="customerName" class="form-label mt-3"><fmt:message key="customerName" /></label>
    				<input type="text" class="form-control" id="customerName" name="customerName" value="${cliente.customerName}">
    				<label for="contactLastName" class="form-label mt-3"><fmt:message key="contactLastName" /></label>
    				<input type="text" class="form-control" id="contactLastName" name="contactLastName" value="${cliente.contactLastName}" >
    				<label for="contactFirstName" class="form-label mt-3"><fmt:message key="contactFirstName" /></label>
    				<input type="text" class="form-control" id="contactFirstName" name="contactFirstName" value="${cliente.contactFirstName}" >	
    				<label for="phone" class="form-label mt-3"><fmt:message key="phone" /></label>
    				<input type="text" class="form-control" id="phone" name="phone" value="${cliente.phone}" >	
    				<label for="addressLine1" class="form-label mt-3"><fmt:message key="addressLine1" /></label>
    				<input type="text" class="form-control" id="addressLine1" name="addressLine1" value="${cliente.addressLine1}" >	
    				<label for="addressLine2" class="form-label mt-3"><fmt:message key="addressLine2" /></label>
    				<input type="text" class="form-control" id="addressLine2" name="addressLine2" value="${cliente.addressLine2}"  >
    				<label for="city" class="form-label mt-3"><fmt:message key="city" /></label>
    				<input type="text" class="form-control" id="officeCode" name="city" value="${cliente.city}" >		
    				<label for="state" class="form-label mt-3"><fmt:message key="state" /></label>
    				<input type="text" class="form-control" id="state" name="state" value="${cliente.state}" >	
    				<label for="postalCode" class="form-label mt-3"><fmt:message key="postalCode" /></label>
    				<input type="text" class="form-control" id="postalCode" name="postalCode" value="${cliente.postalCode}" >	
    				<label for="country" class="form-label mt-3"><fmt:message key="country" /></label>
    				<input type="text" class="form-control" id="country" name="country" value="${cliente.country}" >	 				
    				<label for="salesRepEmployeeNumber" class="form-label mt-3"><fmt:message key="salesRepEmployeeNumber" /></label>
    				<select name="salesRepEmployeeNumber" class="form-select">
    					<c:forEach items="${employee}" var="em">
    						<c:choose>
    							<c:when test="${em.employeeNumber == cliente.salesRepEmployeeNumber}">
    								<option value="${em.employeeNumber}" selected>${em.employeeNumber }</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${em.employeeNumber }">${em.employeeNumber  }</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				<label for="creditLimit" class="form-label mt-3"><fmt:message key="creditLimit" /></label>
    				<input type="text" class="form-control" id="creditLimit" name="creditLimit" value="${cliente.creditLimit}" required >	 
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>