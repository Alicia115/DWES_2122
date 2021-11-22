<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Búsqueda de Oficinas</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>

	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<form method="post" class="d-flex">
				<input name="busqueda" class="form-control me-2" type="search"
					placeholder="Search" aria-label="Search" required>
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</nav>
		<div class="row justify-content-center">
			<c:choose>
				<c:when test="${oficinas!=null and oficinas.size()>0}">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>officeCode</th>
								<th>city</th>
								<th>phone</th>
								<th>addressLine1</th>
								<th>addressLine2</th>
								<th>state</th>
								<th>country</th>
								<th>postalCode</th>
								<th>territory</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${oficinas}" var="p">
								<tr>
									<td>${p.officeCode}</td>
									<td>${p.city}</td>
									<td>${p.phone}</td>
									<td>${p.addressLine1}</td>
									<td>${p.addressLine2}</td>
									<td>${p.state}</td>
									<td>${p.country}</td>
									<td>${p.postalCode}</td>
									<td>${p.territory}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:when test="${oficinas!=null and oficinas.size()==0}">
					<p class="text-danger">NO HAY RESULTADOS</p>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>