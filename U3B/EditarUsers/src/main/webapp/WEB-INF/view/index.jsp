<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="includes/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
</head>
<body>

	<div class="modal-body" id="loginModal" 
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">ENTRAR EN SESION</h5>
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
							<label for="password" class="form-label">CONTRASEÑA</label> <input
								class="form-control" type="password" name="password" required />
						</p>
						<p>
							<input class="btn btn-primary" type="submit" value="LOGIN" />
						</p>
						
					</form>
					
					<a href="InsertUser" >REGISTRO DE USUARIO</a></br>
					
					<c:choose>
						<c:when test="${error!='' or error!=null}">
							<h3 style="color:red;">${error}</h3>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${registro!=null}">
							<h3 style="color:green;">${registro}</h3>
						</c:when>
					</c:choose>
				</div>				
			</div>
		</div>
	</div>
</body>
</html>