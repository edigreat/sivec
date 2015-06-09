 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Pagina de login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">
	
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-md-12">
            <div class="wrap">
                <p class="form-title"> Iniciar Sesión</p>
                <form class="login" action="<c:url value='j_spring_security_check' />" method="POST" >
                <input type="text" placeholder="Nombre de usuario" name="j_username" />
                <input type="password" placeholder="Contraseña" name="j_password" />
                <input type="submit" name="Enviar" value="Enviar" class="btn btn-success btn-sm" />
               	<br />
                <c:if test="${param.failed==1}">
        			<br />
        			<p class="bg-danger text-center ">
        			<b>Usuario o password incorrectos</b><br/>
        			</p>
   				</c:if>
   				 </form>
   				 
            </div>
        </div>
        
    </div>
    
</div>
</body>
</html>