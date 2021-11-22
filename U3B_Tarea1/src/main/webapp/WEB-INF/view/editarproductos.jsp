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
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<form method="post">
					<label for="productName" class="form-label">productName</label>
    				<input name="productName" value="${producto.productName}" type="text" class="form-control" id="productName" disabled>
    				<label for="productCode" class="form-label">productCode</label>
    				<input name="productCode" value="${producto.productCode}" type="text" class="form-control" id="productCode" >
    				<label for="productLine" class="form-label">productLine</label>
    				<input name="productLine" value="${producto.productLine}" type="text" class="form-control" id="productLine" >
    				<label for="productScale" class="form-label">productScale</label>
    				<input name="productScale" value="${producto.productScale}" type="text" class="form-control" id="productScale" >
    				<label for="productVendor" class="form-label">productVendor</label>
    				<input name="productVendor" value="${producto.productVendor}" type="text" class="form-control" id="productVendor" >
    				<label for="productDescription" class="form-label">productDescription</label>
    				<input name="productDescription" value="${producto.productDescription}" type="text" class="form-control" id="productDescription" >
    				<label for="quantityInStock" class="form-label">quantityInStock</label>
    				<input name="quantityInStock" value="${producto.quantityInStock}" type="text" class="form-control" id="quantityInStock" >
    				<label for="buyPrice" class="form-label">buyPrice</label>
    				<input name="buyPrice" value="${producto.buyPrice}" type="text" class="form-control" id="buyPrice" >
    				<label for="msrp" class="form-label">msrp</label>
    				<input name="msrp" value="${producto.msrp}" type="text" class="form-control" id="msrp" >
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>