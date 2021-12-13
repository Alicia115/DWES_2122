
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<fmt:setBundle basename="interface" />   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>	
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-11">
				<table class="table table-striped table-hover">
				<thead>
						<th><fmt:message key="productLine" /></th>
						<th><fmt:message key="textDescription" /></th>
						<th><fmt:message key="htmlDescription" /></th>
					</thead>
					<tbody>
						<c:forEach items="${categorias}" var="categoria">
							<tr>
								<td>${categoria.productLine}</td>
								<td>${categoria.textDescription}</td>
								<td>${categoria.htmlDescription}</td>								
								<td><a href="UpdateProductLineServlet?pl=${categoria.productLine}"><i class="bi bi-pencil-fill"></i></a>
									<a href="RemoveProductLineServlet?pl=${categoria.productLine}"><i class="bi bi-trash-fill"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>>