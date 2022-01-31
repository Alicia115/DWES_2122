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
    				<input type="text" class="form-control" id="customerNumber" name="customerNumber" required>	
    				<label for="customerName" class="form-label mt-3"><fmt:message key="customerName" /></label>
    				<input type="text" class="form-control" id="customerName" name="customerName">
    				<label for="contactLastName" class="form-label mt-3"><fmt:message key="contactLastName" /></label>
    				<input type="text" class="form-control" id="contactLastName" name="contactLastName" >
    				<label for="contactFirstName" class="form-label mt-3"><fmt:message key="contactFirstName" /></label>
    				<input type="text" class="form-control" id="contactFirstName" name="contactFirstName"  >	
    				<label for="phone" class="form-label mt-3"><fmt:message key="phone" /></label>
    				<input type="text" class="form-control" id="phone" name="phone">	
    				<label for="addressLine1" class="form-label mt-3"><fmt:message key="addressLine1" /></label>
    				<input type="text" class="form-control" id="addressLine1" name="addressLine1" >	
    				<label for="addressLine2" class="form-label mt-3"><fmt:message key="addressLine2" /></label>
    				<input type="text" class="form-control" id="addressLine2" name="addressLine2"  >
    				<label for="city" class="form-label mt-3"><fmt:message key="city" /></label>
    				<input type="text" class="form-control" id="officeCode" name="city" >		
    				<label for="state" class="form-label mt-3"><fmt:message key="state" /></label>
    				<input type="text" class="form-control" id="state" name="state" >	
    				<label for="postalCode" class="form-label mt-3"><fmt:message key="postalCode" /></label>
    				<input type="text" class="form-control" id="postalCode" name="postalCode" >	
    				<label for="country" class="form-label mt-3"><fmt:message key="country" /></label>
    				<input type="text" class="form-control" id="country" name="country" >	 				
    				<label for="salesRepEmployeeNumber" class="form-label mt-3"><fmt:message key="employee" /></label>
    				<select name="salesRepEmployeeNumber" class="form-select">
    					<c:forEach  items="${empleados}" var="e">
							<option value="${e.employeeNumber}"> ${e.lastName } ${e.firstName }</option>
						</c:forEach>
    				</select>
    				<label for="creditLimit" class="form-label mt-3"><fmt:message key="creditLimit" /></label>
    				<input type="text" class="form-control" id="creditLimit" name="creditLimit" required >	 
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="add" />" />	
    				
    				<c:choose>
    					<c:when test="${error=='bien'}">
    						<div class="text-success  mt-3"><fmt:message key="bien"/></div>
    					</c:when>
    					<c:when test="${error=='mal'}">
    					<div class="text-danger text-small mt-3"><fmt:message key="mal"/></div>
    					</c:when>
    				</c:choose>				
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>