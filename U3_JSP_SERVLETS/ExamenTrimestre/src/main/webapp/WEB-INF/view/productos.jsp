
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<fmt:setBundle basename="interface" />   
<c:set var="examen" value="${pageContext.request.contextPath}"/>
<jsp:include page="include/bootstrap.jsp" />
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
		<c:choose>
		<c:when test="${categoria != null }">
		<div class="row justify-content-center">
			<div class="col-11">
			
				<h1><fmt:message key="products" /> <fmt:message key="of" /> <fmt:message key="the" /> <fmt:message key="productLine" /> ${categoria }</h1>
				<table class="table table-striped table-hover">
				<thead>
						<th><fmt:message key="productName" /></th>
						<th><fmt:message key="productDescription" /></th>
						<th><fmt:message key="productVendor" /></th>
						<th><fmt:message key="buyPrice" /></th>
						<th><fmt:message key="quantityInStock" /></th>
					</thead>
					<tbody>
						<c:forEach items="${productLi}" var="produ">
							<tr>		
								<td>${produ.productName}</td>
								<td>${produ.productDescription}</td>
								<td>${produ.productVendor}</td>	
								<td>${produ.buyPrice}</td>	
								<td>${produ.quantityInStock}</td>								
							</tr>
						</c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
		</c:when>
		<c:otherwise>
		<h1><fmt:message key="nocategoria"></fmt:message></h1>
		</c:otherwise>
		</c:choose>
	</div>
	
</body>
</html>>