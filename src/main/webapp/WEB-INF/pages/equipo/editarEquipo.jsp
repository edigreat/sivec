<%-- 
    Document   : registrarEquipo.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*,presentacion.manager.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="form-crea-equipo-container" class="col-md-10">

  <form:form method="post" action="${pageContext.request.contextPath}/equipo/actualizarinformacionusuario.html"   modelAttribute="mngCrearEquipoForm" cssClass="form-horizontal" role="form">
		<form:hidden path="equipoComputo.idEquipoComputo" />
	
	<h2 class="bg-primary text-center">Editar Equipo : ${mngCrearEquipoForm.equipoComputo.idEquipoComputo}</h2>
	<div class="row">
    <div id="form-crea-equipo-container" class="col-md-7">
    <div class="form-group ">
        <form:label path="equipoComputo.descTipoEquipo" class="control-label col-sm-3">Tipo * :
        </form:label>
        <div class="col-sm-4">
        <form:select path="equipoComputo.descTipoEquipo" items="${tipoEquipoComputoMap}" />
        </div>
    </div>
     <div class="form-group ">
        <form:label path="equipoComputo.estadoEquipo" class="control-label col-sm-3">Estado * :
        </form:label>
        <div class="col-sm-4">
        <form:select path="equipoComputo.estadoEquipo" items="${estadoEquipoMap}" />
        </div>
    </div>
    <div class="form-group ">
        <form:label path="equipoComputo.marcaComputo" class="control-label col-md-3">Marca * :
        </form:label>
        <div class="col-md-6">
            <form:input path="equipoComputo.marcaComputo" class="form-control"  maxlength="40" />
            <form:errors path="equipoComputo.marcaComputo"  cssClass="text-danger pull-left" element="div"  />
        </div> 
    </div>  
    
    <div class="form-group ">
        <form:label path="equipoComputo.modeloComputo" class="control-label col-sm-3">Modelo * :
        </form:label>
        <div class="col-sm-6">
            <form:input path="equipoComputo.modeloComputo" class="form-control" maxlength="40" />
                <form:errors path="equipoComputo.modeloComputo"  cssClass="text-danger pull-left" element="div" />
        </div> 
    </div>
    
    <div class="form-group ">
        <form:label path="equipoComputo.ubicacion" class="control-label col-sm-3">Ubicación * :
        </form:label>
        <div class="col-sm-6">
            <form:input path="equipoComputo.ubicacion" class="form-control" maxlength="40" />
                <form:errors path="equipoComputo.ubicacion"  cssClass="text-danger pull-left" element="div" />
        </div> 
    </div>
    
    <div class="form-group ">
        <form:label path="nombreUsuarioResponsable" class="control-label col-sm-3">Dueño * :
        </form:label>
        <div class="col-sm-6">
             <form:input path="nombreUsuarioResponsable"  id="txt-busqueda-responsable" class="form-control" maxlength="40" />
       		 <form:errors path="nombreUsuarioResponsable"  cssClass="text-danger pull-left" element="div" />
       		 <form:hidden path="usuarioResponsableTag" id="usuarioResponsableTag" />
       		 <span id="helpBlock" class="help-block">Busca por apellido Paterno.</span>
       		 
        </div> 
    </div>
     <div class="form-group ">
        <form:label path="nombreUsuarioAsignado" class="control-label col-sm-3">Asignado a :
        </form:label>
        <div class="col-sm-6">
             <form:input path="nombreUsuarioAsignado"  id="txt-busqueda-asignado" class="form-control" maxlength="40" />
       		 <form:errors path="nombreUsuarioAsignado"  cssClass="text-danger pull-left" element="div" />
       		 <form:hidden path="usuarioAsignadoTag" id="usuarioAsignadoTag" />
       		 <span id="helpBlock" class="help-block">Busca por apellido Paterno.</span>
       		 
        </div> 
    </div>
    </div>
	
	<div id="form-crea-caracteristica-container" class="col-md-5">
	<table class="table table-striped table-condensed">
					<tbody>
					<tr class="text-center">
					<td class="bg-primary" colspan="3"><h5>CARACTERISTICAS</h5>
					  </td>
					</tr>
					
					<tr>
					    <td class="success"> </td>
						<td class="success" >NOMBRE</td>
						<td class="success">VALOR</td>
					</tr>
					
					<tbody>	
		<c:forEach items="${mngCrearEquipoForm.mngCaracteristicaEquipoList}" var="mngCaracteristicaEquipo" varStatus="status">
			 		<tr class="text-center">
						<td> <input type="hidden" name="mngCaracteristicaEquipoList[${status.index}].idEquipoValCarac" value="${status.index}" /> </td>
						<td>	 <input name="mngCaracteristicaEquipoList[${status.index}].descripcionCaract" value="${mngCaracteristicaEquipo.descripcionCaract}" maxlength="20" /> </td>
			 			<td>	<input name="mngCaracteristicaEquipoList[${status.index}].valorCaract" value="${mngCaracteristicaEquipo.valorCaract}" maxlength="20" /> </td>
					</tr>
		</c:forEach>
		</tbody>
			</table>
	</div>
	</div>
	<div class="row">
		<div class="form-group ">
	<div class="col-sm-2" ></div>	
		<div class="col-sm-2">
			<input type="submit"  class="btn btn-primary" value="Guardar" />
		</div>
		<div class="col-sm-2">
			<a class="btn btn-warning" href="${pageContext.request.contextPath}/equipo/cancelaractualizacion.html" role="button">Cancelar</a>
		</div>
		<div class="col-sm-2">
		
		  <button type="button" id="btnMostrarBorrarEquipo" class="btn btn-danger" data-toggle="modal" data-target="#confirmaEliminarEquipo">Eliminar</button>

		</div>
		
		
   </div>
   </div>	
	
	<!-- Modal -->
<div class="modal fade" id="confirmaEliminarEquipo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <br />
 <br />
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
      <h2 class="bg-primary text-center">Eliminar Equipo:  ${mngCrearEquipoForm.equipoComputo.idEquipoComputo}</h2>
      
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Confirmación</h4>
      </div>
      <div class="modal-body">
        ¿Esta seguro de eliminar el registro del equipo de computo: ${mngCrearEquipoForm.equipoComputo.idEquipoComputo} ? 
      </div>
      <div class="modal-footer">
      	<a href="${pageContext.request.contextPath}/equipo/eliminarequipocomputo.html?idEquipoComputo=${mngCrearEquipoForm.equipoComputo.idEquipoComputo}" class="btn btn-danger">Eliminar</a>
        <button type="button" class="btn btn-warning" data-dismiss="modal">Cancelar</button>
      </div>
    </div>
  </div>
</div>
  </form:form>
</div>


	