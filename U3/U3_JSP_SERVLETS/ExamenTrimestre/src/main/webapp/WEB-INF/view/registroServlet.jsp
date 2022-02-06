<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="examen" value="${pageContext.request.contextPath}"/>
<fmt:setBundle basename="interface" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<jsp:include page="include/bootstrap.jsp"/>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="post">
					<label for="usuario" class="form-label mt-3"><fmt:message key="user" /></label>
    				<input type="text" class="form-control" id="usuario" name="usuario" required >	
    				<label for="firstName" class="form-label mt-3"><fmt:message key="firstName" /></label>
    				<input type="text" class="form-control" id="firstName" name="firstName" required >	
    				<label for="lastName" class="form-label mt-3"> <fmt:message key="lastName" /></label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >	
    				<label for="email" class="form-label mt-3"><fmt:message key="email" /></label>
    				<input type="email" class="form-control" id="email" name="email" required >
    				<label for="password" class="form-label mt-3"><fmt:message key="password" /></label>
    				<input type="password" class="form-control" id="password" name="password" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="<fmt:message key="password" />" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>