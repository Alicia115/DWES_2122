
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />   
<c:if test="${sessionScope.usuario!=null}">
	<c:choose>
		<c:when test="${rol== 'admin'}">
		
			<div class="row justify-content-end" >
				<div class="col-12 text-end">
					<p class="d-flex justify-content-between bg-primary text-white p-2">
					
						<a class="text-white" href="${pageContext.request.contextPath}/Home"><fmt:message key="home" /></a>
						<a class="text-white" href="${pageContext.request.contextPath}/Admin/AddCustomer"><fmt:message key="add" />  <fmt:message key="customer" /></a>
					
						<fmt:message key="site"/> <fmt:message key="of"/> <fmt:message key="administration"/>
					
						<a class="text-white" href="${pageContext.request.contextPath}/Logout"><i class="bi bi-box-arrow-left"></i></a>
					</p> 
				</div>	
			</div>
		
		</c:when>
		
		<c:when test="${rol== 'usuario'}">
			
			<div class="row justify-content-center" >
				<div class="col-12 text-center">
					<p class="d-flex justify-content-between bg-primary text-white p-2">
					
						<a class="text-white" href="${pageContext.request.contextPath}/Home"><fmt:message key="home" /></a>
					
						<fmt:message key="site"/> <fmt:message key="of"/> <fmt:message key="usuario"/>
					
						<a class="text-white" href="${pageContext.request.contextPath}/Logout"><i class="bi bi-box-arrow-left"></i></a>
					</p>  
					
				</div>	
					
				
			</div>
			
		</c:when>
		
	</c:choose>
</c:if>