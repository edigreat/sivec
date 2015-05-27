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

  <form:form method="post" action="${pageContext.request.contextPath}/reparacion/confirmarreparacion.html"   modelAttribute="mngCrearReparacionForm" cssClass="form-horizontal" role="form">
		<form:hidden path="equipoComputo.idEquipoComputo" />
	
	<h2 class="bg-primary text-center">Registrar Reparación Equipo : ${mngCrearReparacionForm.equipoComputo.idEquipoComputo}</h2>
	<div class="row">
    <div id="form-crea-equipo-container" class="col-md-7">
    <div class="form-group ">
        <form:label path="equipoComputo.descTipoEquipo" class="control-label col-sm-3">Tipo:
        </form:label>
        <div class="col-sm-4">
        <form:input path="equipoComputo.descTipoEquipo"  class="form-control"   readonly="true" />
        </div>
    </div>
     <div class="form-group ">
        <form:label path="equipoComputo.marcaComputo" class="control-label col-md-3">Marca:
        </form:label>
        <div class="col-md-6">
            <form:input path="equipoComputo.marcaComputo" class="form-control"  maxlength="40" readonly="true"  />
        </div> 
    </div>  
    
    <div class="form-group ">
        <form:label path="equipoComputo.modeloComputo" class="control-label col-sm-3">Modelo:
        </form:label>
        <div class="col-sm-6">
            <form:input path="equipoComputo.modeloComputo" class="form-control" maxlength="40" readonly="true"  />
        </div> 
    </div>
    
    
    <div class="form-group ">
        <form:label path="nombreUsuarioResponsable" class="control-label col-sm-3">Responsable:
        </form:label>
        <div class="col-sm-6">
             <form:input path="nombreUsuarioResponsable"  id="txt-busqueda-responsable" class="form-control" readonly="true"  maxlength="40" />
        </div> 
    </div>
     <div class="form-group ">
        <form:label path="nombreUsuarioAsignado" class="control-label col-sm-3">Autor de la reparación:
        </form:label>
        <div class="col-sm-6">
             <form:input path="nombreUsuarioAsignado"  id="txt-busqueda-asignado" class="form-control" maxlength="40" readonly="true"  />
        </div> 
    </div>
    
    </div> <!-- fin form-crea-equipo-container -->
	
	<div id="form-crea-caracteristica-container" class="col-md-5">
					<h3>CARACTERISTICAS</h3>
					<ul class="list-group">
					<c:forEach items="${mngCrearReparacionForm.mngCaracteristicaEquipoList}" var="mngCaracteristicaEquipo" varStatus="status">
						<li class="list-group-item"> ${(status.index+1)}.${mngCaracteristicaEquipo.descripcionCaract} : ${mngCaracteristicaEquipo.valorCaract} </li> 
					</c:forEach>
		</ul>
		
	</div><!--fin form-crea-caracteristica-container -->
	</div>
	<div class="row">
	
		<div id="form-crea-detalle-reparacion-container" class="col-md-8">
		<div class="form-group ">
        <form:label path="reparacionEquipo.descMotivo" class="control-label col-sm-4">Motivo de la reparación:
        </form:label>
        <div class="col-sm-8">
             <form:input path="reparacionEquipo.descMotivo" class="form-control" maxlength="40"   />
             <form:errors path="reparacionEquipo.descMotivo"  cssClass="text-danger pull-left" element="div"  />
             
        </div> 
        
   		 </div>	
   		 <div class="form-group ">
        <form:label path="reparacionEquipo.descReparacion" class="control-label col-sm-4">Descripción de la reparación:
        </form:label>
        <div class="col-sm-8">
             <form:textarea path="reparacionEquipo.descReparacion"  class="form-control"  rows="5" maxlength="100"   />
             <form:errors path="reparacionEquipo.descReparacion"  cssClass="text-danger pull-left" element="div"  />
             
        </div> 
        
   		 </div>				
		
		
		</div><!--fin form-crea-detalle-reparacion-container -->
	
	 </div>
	
	<div class="row">
		<div class="form-group ">
	<div class="col-sm-4" ></div>	
		<div class="col-sm-3">
			<input type="submit"  class="btn btn-primary" value="Guardar" />
		</div>
		<div class="col-sm-3">
			<a class="btn btn-warning" href="${pageContext.request.contextPath}/equipo/cancelaractualizacion.html" role="button">Cancelar</a>
		</div>
		
		
   </div>
   </div>	
	

  </form:form>
</div>


	