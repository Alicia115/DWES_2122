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
<title>Lista Productos</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
		
			<div class="col-10"><br>
				<div class="text-end">
					<a href="Insert"><i class="bi bi-plus-circle-fill"></i></a>
				</div>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ProductLine</th>
							<th>TextDescription</th>
							<th>HtmlDescription</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="productos">
							<tr>
								<td>${productos.productLine}</td>
								<td>${productos.textDescription}</td>
								<td>${productos.htmlDescription}</td>
								<td><a href="Update?pl=${productos.productLine}"><i class="bi bi-pencil-fill"></i></a>
									<a href="Remove?pl=${productos.productLine}"><i class="bi bi-trash-fill"></i></a>
									
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>