<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />    
<jsp:include page="include/bootstrap.jsp"/>
<c:set var="examen" value="${pageContext.request.contextPath}"/>
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
    				<input name="employeeNumber" type="text" class="form-control" id="employeeNumber" >
    				<label for="lastName" class="form-label"><fmt:message key="lastName" /></label>
    				<input name="lastName"  type="text" class="form-control" id="lastName"  >
    				<label for="firstName" class="form-label"><fmt:message key="firstName" /></label>
    				<input name="firstName" type="text" class="form-control" id="firstName"  >
    				<label for="extension" class="form-label"><fmt:message key="extension" /></label>
    				<input name="extension" type="text" class="form-control" id="extension"  >
    				<label for="email" class="form-label"><fmt:message key="email" /></label>
    				<input name="email"  type="text" class="form-control" id="email"  >
    				<label for="officeCode" class="form-label"><fmt:message key="officeCode" /></label>
    				<select class="form-select" id="officeCode" name="officeCode">
						<c:forEach  items="${oficina}" var="o">
							<option value="${o.officeCode}">${o.city}</option>
						</c:forEach>					
					</select>
    				<label for="reportsTo" class="form-label"><fmt:message key="reportsTo" /></label>
    				<select class="form-select" id="reportsTo" name="reportsTo">
						<c:forEach  items="${empleados}" var="e">
							<option value="${e.employeeNumber}">${e.firstName } ${e.lastName }</option>
						</c:forEach>					
					</select>
    				<label for="jobTitle" class="form-label"><fmt:message key="jobTitle" /></label>
    				<input name="jobTitle" value="" type="text" class="form-control" id="jobTitle" >
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR" />	
    				
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
</html>>