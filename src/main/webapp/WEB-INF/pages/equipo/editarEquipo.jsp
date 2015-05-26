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

  <form:form method="post" action="${pageContext.request.contextPath}/equipo/guardarinformacionequipo.html"   modelAttribute="mngCrearEquipoForm" cssClass="form-horizontal" role="form">
	<h2 class="bg-primary text-center">Editar Equipo</h2>
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
	<div class="col-sm-4" ></div>	
		<div class="col-sm-2">
			<input type="submit"  class="btn btn-primary" value="Guardar" />
		</div>
		<div class="col-sm-2">
			<a class="btn btn-warning" href="${pageContext.request.contextPath}/equipo/cancelaractualizacion.html" role="button">Cancelar</a>

		</div>
		
   </div>
   </div>	
	
  </form:form>
</div>

	