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
					<label for="employeeNumber" class="form-label"><fmt:message key="employeeNumber" /></label>
    				<input name="employeeNumber" value="${empleado.employeeNumber}" type="text" class="form-control" id="employeeNumber" disabled>
    				<label for="lastName" class="form-label"><fmt:message key="lastName" /></label>
    				<input name="lastName" value="${empleado.lastName}" type="text" class="form-control" id="lastName"  >
    				<label for="firstName" class="form-label"><fmt:message key="firstName" /></label>
    				<input name="firstName" value="${empleado.firstName}" type="text" class="form-control" id="firstName"  >
    				<label for="extension" class="form-label"><fmt:message key="extension" /></label>
    				<input name="extension" value="${empleado.extension}" type="text" class="form-control" id="extension"  >
    				<label for="email" class="form-label"><fmt:message key="email" /></label>
    				<input name="email" value="${empleado.email}" type="text" class="form-control" id="email"  >
    				<label for="officeCode" class="form-label"><fmt:message key="officeCode" /></label>
    				<select name="officeCode" class="form-select">
    					<c:forEach items="${oficina}" var="of">
    						<c:choose>
    							<c:when test="${of.officeCode == empleado.officeCode}">
    								<option value="${of.officeCode}" selected>${of.officeCode }</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${of.officeCode}">${of.officeCode }</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				<label for="reportsTo" class="form-label"><fmt:message key="reportsTo" /></label>
    				<select name="reportsTo" class="form-select">
    					<c:forEach items="${empleados}" var="ems">
    						<c:choose>
    							<c:when test="${ems.employeeNumber == empleado.reportsTo}">
    								<option value="${ems.employeeNumber}" selected>${ems.employeeNumber }</option>
    							</c:when>
    							<c:otherwise>
    								<option value="${ems.employeeNumber}">${ems.employeeNumber }</option>
    							</c:otherwise>
    						</c:choose>
    					</c:forEach>
    				</select>
    				<label for="jobTitle" class="form-label"><fmt:message key="jobTitle" /></label>
    				<input name="jobTitle" value="${empleado.jobTitle}" type="text" class="form-control" id="jobTitle" >
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />	
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>>