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
					<label for="customerNumber mt-3" class="form-label mt-3"><fmt:message key="customerNumber" /></label>
					<select class="form-select" id="customerNumber" name="customerNumber">
						<c:forEach  items="${customers}" var="c">
							<c:choose>
								<c:when test="${c.customerNumber == pago.customerNumber}">
									<option value="${c.customerNumber}" selected>${c.customerName}-${c.customerNumber}</option>
								</c:when>
								<c:otherwise>
									<option value="${c.customerNumber}">${c.customerName}-${c.customerNumber}</option>
								</c:otherwise>
							</c:choose>							
						</c:forEach>					
					</select>
					<label for="checkNumber" class="form-label mt-3"><fmt:message key="checkNumber" /></label>
    				<input type="text" class="form-control" id="checkNumber" name="checkNumber" value="${pago.checkNumber}" required >	
    				<label for="paymentDate" class="form-label mt-3"><fmt:message key="date" /></label>
    				<input type="date" class="form-control" id="paymentDate" name="paymentDate" value="${pago.date}" required>
    				<label for="amount" class="form-label mt-3"><fmt:message key="amount" /></label>
    				<input type="number" class="form-control" id="amount" name="amount" value="${pago.amount}" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />					
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>