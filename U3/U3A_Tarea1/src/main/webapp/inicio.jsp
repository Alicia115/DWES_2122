<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>

	<%if (!session.isNew() && session.getAttribute("usuario")!=null  
			&& session.getAttribute("date") != null) {%>

	<jsp:include page="barra.jsp"></jsp:include>

	<img
		src="https://www.lavanguardia.com/files/og_thumbnail/uploads/2018/06/15/5fa43d71a111f.jpeg">




	<%} else {%>

	<h1><fmt:message key="CENTRALDEVIAJES" /></h1>
	<form method="post">

		<p>
			<label for="usuario" class="form-label"><fmt:message key="usuario" /></label> <input
				class="form-control" type="text" name="usuario" required />
		</p>

		<p>
			<label for="password" class="form-label"><fmt:message key="password" /></label> <input
				class="form-control" type="password" name="password" required />
		</p>

		<p>
			<label for="confirmpassword" class="form-label"><fmt:message key="confirmpassword" /></label> <input class="form-control" type="password"
				name="confirmpassword" required />
		</p>

		<p>
			<label for="email" class="form-label"><fmt:message key="email" /></label> <input
				class="form-control" type="email" name="email" required />
		</p>

		<p>
			<button type="submit" name="registrar" value="REGISTRAR"><fmt:message key="registrarse" /></button>
		</p>



	</form>

	<%}%>

</body>
</html>