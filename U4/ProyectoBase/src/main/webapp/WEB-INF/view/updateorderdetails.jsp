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
				
					<label for="orderNumber mt-3" class="form-label mt-3"><fmt:message key="orderNumber" /></label>
					<select class="form-select" id="orderNumber" name="orderNumber">
						<c:forEach  items="${orders}" var="order">
							<c:choose>
								<c:when test="${order.orderNumber == orderdetails.orderNumber}">
									<option value="${order.orderNumber}" selected>${order.orderNumber}-${order.orderNumber}</option>
								</c:when>
								<c:otherwise>
									<option value="${order.orderNumber}">${order.orderNumber}-${order.orderNumber}</option>
								</c:otherwise>
							</c:choose>							
						</c:forEach>					
					</select>
					<label for="orderNumber mt-3" class="form-label mt-3"><fmt:message key="productCode" /></label>
					<select class="form-select" id="productCode" name="productCode">
						<c:forEach  items="${productos}" var="product">
							<c:choose>
								<c:when test="${product.productCode == orderdetails.productCode}">
									<option value="${product.productCode}" selected>${product.productCode}-${product.productCode}</option>
								</c:when>
								<c:otherwise>
									<option value="${product.productCode}">${product.productCode}-${product.productCode}</option>
								</c:otherwise>
							</c:choose>							
						</c:forEach>					
					</select>
					<label for="quantityOrdered" class="form-label mt-3"><fmt:message key="quantityOrdered" /></label>
    				<input type="text" class="form-control" id="quantityOrdered" name="quantityOrdered" value="${orderdetails.quantityOrdered}" required >	
    				<label for="priceEach" class="form-label mt-3"><fmt:message key="priceEach" /></label>
    				<input type="text" class="form-control" id="priceEach" name="priceEach" value="${orderdetails.priceEach}" required >	
    				<label for="orderLineNumber" class="form-label mt-3"><fmt:message key="orderLineNumber" /></label>
    				<input type="text" class="form-control" id="orderLineNumber" name="orderLineNumber" value="${orderdetails.orderLineNumber}" required >	
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>