<%-- 
    Document   : editarUsuario.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<br />

<div id="form-edita-usuario-container" class="col-md-10 ">

<form:form method="post" action="${pageContext.request.contextPath}/usuario/actualizarinformacionusuario.html" 
  modelAttribute="mngCrearUsuario" cssClass="form-horizontal" role="form">
	<form:hidden path="usuario.idUsuario" />
  <div class="form-group ">
			<h2 class="bg-primary text-center">Editar Usuario:  ${mngCrearUsuario.usuario.idUsuario}</h2>
	
		<form:label path="usuario.nombre" class="control-label col-sm-2">Nombre * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.nombre" class="form-control"  maxlength="40" />
			<form:errors path="usuario.nombre"  cssClass="text-danger pull-left" element="div"  />
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.apPaterno" class="control-label col-sm-2">Apellido Paterno * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.apPaterno" class="form-control" maxlength="40" />
				<form:errors path="usuario.apPaterno"  cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.apMaterno" class="control-label col-sm-2">Apellido Materno :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.apMaterno" class="form-control" maxlength="40" />
				<form:errors path="usuario.apMaterno"  cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.correoEletronico" class="control-label col-sm-2">Dirección Correo eléctronico *:
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.correoEletronico" class="form-control" maxlength="50" />
				<form:errors path="usuario.correoEletronico"   cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>
	<div class="form-group ">
		<form:label path="usuario.password" class="control-label col-sm-2">Password * :
		</form:label>
		<div class="col-sm-6">
		
		    <form:password path="usuario.password" class="form-control"  maxlength="8" showPassword="true" />
			<form:errors path="usuario.password"  cssClass="text-danger pull-left" element="div" />
		</div>
		<p class="text-muted">Solo digitos, entre 4 y 8</p>
		 
	</div>
	<div class="form-group ">
		<form:label path="usuario.dependenciaUniversitaria" class="control-label col-sm-2">Dependencia Universitaria * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="usuario.dependenciaUniversitaria" class="form-control"  maxlength="50" />
				<form:errors path="usuario.dependenciaUniversitaria" cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>

	<div class="form-group ">
		<form:label path="menuAsignado" class="control-label col-sm-2">Rol * :
		</form:label>
		<div class="col-sm-6">
		<form:select path="menuAsignado" items="${mngCrearUsuario.menuRol}" />
		</div>
	</div>
	
	<div class="form-group ">
	<div class="col-sm-2" ></div>	
		<div class="col-sm-2">
			<input type="submit"  class="btn btn-primary" value="Guardar" />
		</div>
		<div class="col-sm-2">
			<a class="btn btn-warning" href="${pageContext.request.contextPath}/usuario/cancelaractualizacion.html" role="button">Cancelar</a>
		</div>
		<div class="col-sm-2">
		
		  <button type="button" id="btnMostrarBorrarUsuario" class="btn btn-danger" data-toggle="modal" data-target="#confirmaEliminarUsuario">Eliminar</button>

		</div>
		
		
   </div>		
<!-- Modal -->
<div class="modal fade" id="confirmaEliminarUsuario" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirmación</h4>
      </div>
      <div class="modal-body">
        ¿Esta seguro de eliminar el registro con nombre de usuario: ${mngCrearUsuario.usuario.correoEletronico} ? 
      </div>
      <div class="modal-footer">
      	<a href="${pageContext.request.contextPath}/usuario/eliminarusuario.html?idUsuario=${mngCrearUsuario.usuario.idUsuario}" class="btn btn-danger">Eliminar</a>
        <button type="button" class="btn btn-warning" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>
  </form:form>
</div>