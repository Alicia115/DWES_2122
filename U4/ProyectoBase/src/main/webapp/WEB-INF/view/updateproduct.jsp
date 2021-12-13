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
					<label for="productName" class="form-label"><fmt:message key="productName" /></label>
    				<input name="productName" value="${producto.productName}" type="text" class="form-control" id="productName">
    				<label for="productCode" class="form-label"><fmt:message key="productCode" /></label>
    				<input name="productCode" value="${producto.productCode}" type="text" class="form-control" id="productCode"  disabled>
    				<label for="productLine" class="form-label"><fmt:message key="productLine" /></label>
    				<select name="productLine" class="form-select">
    					<c:forEach items="${productLine}" var="pl">
    						<c:choose>
    							<c:when test="${pl.productLine == producto.productLine}">
    								<option value="${pl.productLine}" selected>${pl.productLine }</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${pl.productLine}">${pl.productLine }</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				<label for="productScale" class="form-label"><fmt:message key="productScale" /></label>
    				<input name="productScale" value="${producto.productScale}" type="text" class="form-control" id="productScale" >
    				<label for="productVendor" class="form-label"><fmt:message key="productVendor"/></label>
    				<input name="productVendor" value="${producto.productVendor}" type="text" class="form-control" id="productVendor" >
    				<label for="productDescription" class="form-label"><fmt:message key="productDescription" /></label>
    				<input name="productDescription" value="${producto.productDescription}" type="text" class="form-control" id="productDescription" >
    				<label for="quantityInStock" class="form-label"><fmt:message key="quantityInStock"/></label>
    				<input name="quantityInStock" value="${producto.quantityInStock}" type="text" class="form-control" id="quantityInStock" >
    				<label for="buyPrice" class="form-label"><fmt:message key="buyPrice" /></label>
    				<input name="buyPrice" value="${producto.buyPrice}" type="text" class="form-control" id="buyPrice" >
    				<label for="msrp" class="form-label"><fmt:message key="msrp" /></label>
    				<input name="msrp" value="${producto.msrp}" type="text" class="form-control" id="msrp" >
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />	
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>>