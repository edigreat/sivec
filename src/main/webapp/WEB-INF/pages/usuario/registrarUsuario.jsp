<%-- 
    Document   : registrarUsuario.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="form-crea-usuario-container" class="col-md-10">

  <form:form method="post" action="${pageContext.request.contextPath}/usuario/guardarinformacionusuario.html" modelAttribute="mngCrearUsuarioInstance" cssClass="form-horizontal" role="form">
	<div class="form-group ">
			<h2 class="bg-primary">Registrar Usuario</h2>
	
		<form:label path="usuario.nombre" class="control-label col-sm-2">Nombre :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.nombre" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.nombre" />
			</div>
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.apPaterno" class="control-label col-sm-2">Apellido Paterno :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.apPaterno" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.apPaterno" />
			</div>
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.apMaterno" class="control-label col-sm-2">Apellido Materno :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.apMaterno" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.apMaterno" />
			</div>
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.correoEletronico" class="control-label col-sm-2">Correo eléctronico:
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.correoEletronico" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.correoEletronico" />
			</div>
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.password" class="control-label col-sm-2">Password :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.password" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.password" />
			</div>
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.dependenciaUniversitaria" class="control-label col-sm-2">Dependencia Universitaria :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.dependenciaUniversitaria" class="form-control" />
			<div class="text-danger pull-left">
				<form:errors path="usuario.dependenciaUniversitaria" />
			</div>
		</div> 
	</div>

	<div class="form-group ">
		<form:label path="menuAsignado" class="control-label col-sm-2">Rol :
		</form:label>
		<div class="col-sm-6">
		<form:select path="menuRolSeleccionado" items="${mngCrearUsuarioInstance.menuRol}" />
		</div>
	</div>
	<div class="form-group ">
	<div class="col-sm-4" ></div>	
		<div class="col-sm-2">
			<input type="submit"  class="btn btn-primary" value="Guardar" />
		</div>
		<div class="col-sm-2">
			<a class="btn btn-warning" href="${pageContext.request.contextPath}/usuario/cancelaractualizacion.html" role="button">Cancelar</a>

		</div>
		
   </div>	
									

  </form:form>
  </div>