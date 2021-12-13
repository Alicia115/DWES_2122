
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
						<th><fmt:message key="productName" /></th>
						<th><fmt:message key="productCode" /></th>
						<th><fmt:message key="productLine" /></th>
						<th><fmt:message key="productScale" /></th>
						<th><fmt:message key="productVendor" /></th>	
						<th><fmt:message key="productDescription" /></th>	
						<th><fmt:message key="quantityInStock"/></th>	
						<th><fmt:message key="buyPrice" /></th>	
						<th><fmt:message key="msrp" /></th>	
					</thead>
					
					<tbody>
						<c:forEach items="${productos}" var="product">
							<tr>
								<td>${product.productName}</td>
								<td>${product.productCode}</td>
								<td>${product.productLine}</td>
								<td>${product.productScale}</td>
								<td>${product.productVendor}</td>
								<td>${product.productDescription}</td>
								<td>${product.quantityInStock}</td>	
								<td>${product.buyPrice}</td>	
								<td>${product.msrp}</td>					
								<td><a href="UpdateProductServlet?pc=${product.productCode}"><i class="bi bi-pencil-fill"></i></a>
									
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