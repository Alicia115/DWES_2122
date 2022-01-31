<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Productos</title>
<jsp:include page="include/bootstrap.jsp" />
</head>
<body>	
	<div class="container mt-5">
		
		<div class="row justify-content-center">
			<div class="col-11">
				<table class="table table-striped table-hover">
					<thead>
						<th>ProductName</th>
						<th>productCode</th>
						<th>productLine</th>
						<th>productScale</th>
						<th>productVendor</th>	
						<th>productDescription</th>	
						<th>quantityInStock</th>	
						<th>buyPrice</th>	
						<th>msrp</th>	
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
								<td><a href="EditarProductServlet?p=${product.productCode}"><i class="bi bi-pencil-fill"></i></a>
									
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