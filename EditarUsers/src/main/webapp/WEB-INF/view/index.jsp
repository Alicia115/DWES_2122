<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="includes/bootstrap.jsp"/>
<c:fmt/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="#" data-bs-toggle="modal" data-bs-target="#loginModal">ENTRAR
		EN SESION</a>
	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form method="post">
						<p>
							<label for="usuario" class="form-label">USUARIO</label> <input
								class="form-control" type="text" name="usuario" required />
						</p>
						<p>
							<label for="password" class="form-label">CONTRSEÑA</label> <input
								class="form-control" type="password" name="password" required />
						</p>
						<p>
							<input class="btn btn-primary" type="submit" value="LOGIN" />
						</p>
					</form>
					<c:choose>
						<c:when test="${error!=''}">
							<h3 style="color:red;">${error}</h3>
						</c:when>
					</c:choose>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>