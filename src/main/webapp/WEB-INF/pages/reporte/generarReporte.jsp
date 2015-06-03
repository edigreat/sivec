<%-- 
    Document   : generarReporte.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
     			<h3 class="text-center">Reporte Reparaciones </h3>
  	<c:if test="${mngCrearReporte.hasError==true}">
				 <div class="alert alert-danger" role="alert">
				 ${mngCrearReporte.descripcionError}
				  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				</div>
				</c:if>
</div>
<div id="panel-container" class="col-md-10">
<br />
<div class="panel panel-primary ">

	<div class="panel-heading">
   	 	<h3 class="panel-title">Lista de Reparaciones</h3>
   	 	
   	 	
   	 </div>
   <div class="panel-body">
   	
   
		<div class="row ">
			
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
					    <th>Clave Equipo</th>
						<th>Tipo</th>
						<th>Responsable Equipo</th>
						<th>Estado</th>
						<th>Fecha de Registro</th>
						<th>Motivo </th> 
						<th>Asignado A</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mngCrearReporte.reparacionEquipoList}" var="reparacionEquipo" varStatus="status">
						<tr>
							<td><c:out value="${reparacionEquipo.equipoComputo.idEquipoComputo}" /> </td>
							<td><c:out value="${reparacionEquipo.equipoComputo.descTipoEquipo}" /> </td>
							<td><c:out value="${reparacionEquipo.usuarioByIdUsuarioResponsable.nombreCompleto}" /> </td>
							<td><c:out value="${reparacionEquipo.equipoComputo.estadoEquipo}" /> </td>
							<td><c:out value="${reparacionEquipo.fechaRegistroFormato}" /> </td>
						    <td><c:out value="${reparacionEquipo.descMotivo}" /> </td>
							
							<td><c:out value="${reparacionEquipo.usuarioByIdUsuarioAsignado.nombreCompleto}" /> </td>
						
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<c:if test="${mngCrearReporte.lastPageNumber > 0}">
			<div class="row">
	  			<div class="col-md-11">
	  			<nav class="text-center">
				  <ul class="pagination">
				    <li>
				      <a href="<c:url value="/reporte/list.html" />" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach var="i" items="${mngCrearReporte.pageNumberList}">
				   	<li><a href="<c:url value="/reporte/list/${i}.html" />"> <c:out value="${i}"/></a></li>
					</c:forEach>
				    <li>
				      <a href="<c:url value="/reporte/list/${mngCrearReporte.lastPageNumber}.html" />" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				   
				  </ul>
  				</nav>
  				</div>
  				<div class="col-md-1 text-center">
  				 <a href="<c:url value="/reporte/export.xls" />" > 
 						 <span class="glyphicon glyphicon-file" aria-hidden="true"> </span>
 						 xls
  				   </a>	
  				   </div>
				 
  			</div>
			</c:if>
			<c:if test="${mngCrearReporte.consultaPorEquipo==true}">
			<div class="col-md-12 text-center">
  				 <a href="<c:url value="/reporte/${mngCrearReporte.idEquipoComputo}/export.xls" />" >
 						 <span class="glyphicon glyphicon-file" aria-hidden="true"></span>
  				   </a>	
  				   </div>
			</c:if>
			        	
			
			
		</div>
			
		
		
</div>
</div>
</div> <!-- panel container -->
<div class="col-md-2"> </div>

