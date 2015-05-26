<%-- 
    Document   : registrarEquipo.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

  <form:form method="post" action="${pageContext.request.contextPath}/equipo/guardarinformacionequipo.html" modelAttribute="mngCrearEquipo" cssClass="form-horizontal" role="form">
	<h2 class="bg-primary text-center">Registrar Equipo</h2>

	<div id="form-crea-usuario-container" class="col-md-7">
	<div class="form-group ">
		<form:label path="equipoAsignado" class="control-label col-sm-2">Tipo * :
		</form:label>
		<div class="col-sm-6">
		<form:select path="tipoEquipoSeleccionado" items="${mngCrearEquipo.tipoCaracteristicaMap}" />
		</div>
	</div>
	<div class="form-group ">
		<form:label path="equipoComputo.marcaComputo" class="control-label col-sm-2">Marca * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="equipoComputo.marcaComputo" class="form-control"  maxlength="40" />
			<form:errors path="equipoComputo.marcaComputo"  cssClass="text-danger pull-left" element="div"  />
		</div> 
	</div>	
	
	<div class="form-group ">
		<form:label path="equipoComputo.modeloComputo" class="control-label col-sm-2">Modelo * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="equipoComputo.modeloComputo" class="form-control" maxlength="40" />
				<form:errors path="equipoComputo.modeloComputo"  cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>
	
	<div class="form-group ">
		<form:label path="equipoComputo.ubicacion" class="control-label col-sm-2">Ubicación * :
		</form:label>
		<div class="col-sm-6">
			<form:input path="equipoComputo.ubicacion" class="form-control" maxlength="40" />
				<form:errors path="equipoComputo.ubicacion"  cssClass="text-danger pull-left" element="div" />
		</div> 
	</div>
	</div>
	
	<div id="form-crea-caracteristica-container" class="col-md-5">
		<jsp:include page="/WEB-INF/pages/equipo/caracteristica/${mngCrearEquipo.paginaCaracteristica}" />
	</div>
	
  </form:form>


	