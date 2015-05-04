 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>Pagina de login</title>
</head>
<body>

	<h1>Login</h1>
		<form action="<c:url value='j_spring_security_check' />" method="POST">
			<fieldset class="fieldcontainer">
				<legend>Enter username and password</legend>

				<div class="block">
					<div class="field">
						<label>Username:</label>
						<input type="text" name="j_username">
					</div>
	
					<div class="field">
						<label>Password:</label>
						<input type="password" name="j_password">
					</div>

				</div>

				<div class="field vertical">
					<input type="submit" value="Login">
				</div>

			</fieldset>
		</form>
	
</body>
</html>