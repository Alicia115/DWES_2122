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
					<label for="officeCode" class="form-label mt-3"><fmt:message key="officeCode" /></label>
    				<input type="text" class="form-control" id="officeCode" name="officeCode" value="${oficina.officeCode}" disabled >	
    				<label for="city" class="form-label mt-3"><fmt:message key="city" /></label>
    				<input type="text" class="form-control" id="city" name="city" value="${oficina.city}" required >	
    				<label for="phone" class="form-label mt-3"><fmt:message key="phone" /></label>
    				<input type="text" class="form-control" id="phone" name="phone" value="${oficina.phone}" required >	
    				<label for="addressLine1" class="form-label mt-3"><fmt:message key="addressLine1" /></label>
    				<input type="text" class="form-control" id="addressLine1" name="addressLine1" value="${oficina.addressLine1}" required >	
    				<label for="addressLine2" class="form-label mt-3"><fmt:message key="addressLine2" /></label>
    				<input type="text" class="form-control" id="addressLine2" name="addressLine2" value="${oficina.addressLine2}" required >	
    				<label for="state" class="form-label mt-3"><fmt:message key="state" /></label>
    				<input type="text" class="form-control" id="state" name="state" value="${oficina.state}" required >	
    				<label for="country" class="form-label mt-3"><fmt:message key="country" /></label>
    				<input type="text" class="form-control" id="country" name="country" value="${oficina.country}" required >	
    				<label for="postalCode" class="form-label mt-3"><fmt:message key="postalCode" /></label>
    				<input type="text" class="form-control" id="postalCode" name="postalCode" value="${oficina.postalCode}" required >	
    				<label for="territory" class="form-label mt-3"><fmt:message key="territory" /></label>
    				<input type="text" class="form-control" id="territory" name="territory" value="${oficina.territory}" required >
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>