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
<title>Actualización del producto</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="orderNumber" class="form-label mt-3"><fmt:message key="orderNumber" /></label>
    				<input type="text" class="form-control" id="orderNumber" name="orderNumber" value="${orders.orderNumber}" disabled >	
    				<label for="orderDate" class="form-label mt-3"><fmt:message key="orderDate" /></label>
    				<input type="text" class="form-control" id="orderDate" name="orderDate" value="${orders.orderDate}" required >	
    				<label for="requiredDate" class="form-label mt-3"><fmt:message key="requiredDate" /></label>
    				<input type="text" class="form-control" id="requiredDate" name="requiredDate" value="${orders.requiredDate}" required >	
    				<label for="shippedDate" class="form-label mt-3"><fmt:message key="shippedDate" /></label>
    				<input type="text" class="form-control" id="shippedDate" name="shippedDate" value="${orders.shippedDate}" required >	
    				<label for="status" class="form-label mt-3"><fmt:message key="status" /></label>
    				<input type="text" class="form-control" id="status" name="status" value="${orders.status}" required >	
    				<label for="comments" class="form-label mt-3"><fmt:message key="comments" /></label>
    				<input type="text" class="form-control" id="comments" name="comments" value="${orders.comments}" required >	
    				<label for="customerNumber" class="form-label"><fmt:message key="customerNumber" /></label>
    				<select name="customerNumber" class="form-select">
    					<c:forEach items="${customer}" var="c">
    						<c:choose>
    							<c:when test="${c.customerNumber == orders.customerNumber}">
    								<option value="${c.customerNumber}" selected>${c.customerNumber }</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${c.customerNumber}">${c.customerNumber}</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>