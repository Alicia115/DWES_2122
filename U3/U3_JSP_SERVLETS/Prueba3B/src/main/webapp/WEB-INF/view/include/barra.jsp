
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />  
<jsp:include page="bootstrap.jsp" /> 
<c:if test="${sessionScope.usuario!=null}">
	<c:choose>
		<c:when test="${rol== 'admin'}">
			<div class="row justify-content-between" >
				<div class="col-12 text-center">
					<p class="bg-primary text-white p-2">
						<a class="text-white" href="${pageContext.request.contextPath}/"><fmt:message key="home" /></a>
						<fmt:message key="log" /><c:out value="${sessionScope.usuario}" />
						<a class="text-white" href="${pageContext.request.contextPath}/Logout"><i class="bi bi-box-arrow-left"></i></a>
					</p>  
				</div>	
			</div>
		</c:when>
		
		<c:when test="${rol== 'usuario'}">
			<div class="row justify-content-end" >
				<div class="col-12 text-center ">
					<p class="bg-primary text-white p-2 ">
						<a class="text-white" href="${pageContext.request.contextPath}/"><fmt:message key="home" /></a>
						<a class="text-white" href="${pageContext.request.contextPath}/Oficinas"><fmt:message key="show" /> <fmt:message key="offices" /></a>
						<fmt:message key="log" /> <c:out value="${sessionScope.usuario}" />
						<a class="text-white" href="${pageContext.request.contextPath}/Logout"><i class="bi bi-box-arrow-left"></i></a>
					</p>  
				</div>	
			</div>
		</c:when>
		
	</c:choose>
</c:if>