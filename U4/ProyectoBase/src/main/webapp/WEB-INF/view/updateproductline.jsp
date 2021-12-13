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
					<label for="productLine" class="form-label"><fmt:message key="productLine" /></label>
    				<input name="productLine" value="${productLi .productLine}" type="text" class="form-control" id="productLine" disabled> 
    				<label for="textDescription" class="form-label"><fmt:message key="textDescription" /></label>
    				<input name="textDescription" value="${productLi.textDescription}" type="text" class="form-control" id="textDescription"  >
    				<label for="htmlDescription" class="form-label"><fmt:message key="htmlDescription" /></label>
    				<input name="htmlDescription" value="${productLi.htmlDescription}" type="text" class="form-control" id="htmlDescription" >
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />	
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>>