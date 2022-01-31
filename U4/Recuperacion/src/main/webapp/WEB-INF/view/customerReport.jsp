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
<title>Report del cliente</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center">
			<div class="col-6 mt-5">
				<h2><fmt:message key="customer" />: ${cliente.customerName} </h2>
				<h2><fmt:message key="totalPagos" />: 764554 </h2>
				<h2><fmt:message key="numPedidos" />: 546745 </h2>
			</div>
		</div>
		
	</div>
</body>
</html>