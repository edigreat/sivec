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
							<td><c:out value="${reparacionEquipo.equipoComputo.descTipoEquipo}" /> </td>
							<td><c:out value="${reparacionEquipo.usuarioByIdUsuarioResponsable.nombreCompleto}" /> </td>
							<td><c:out value="${reparacionEquipo.equipoComputo.estadoEquipo}" /> </td>
							<td><c:out value="${reparacionEquipo.fechaCreacion}" /> </td>
						    <td><c:out value="${reparacionEquipo.descMotivo}" /> </td>
							
							<td><c:out value="${reparacionEquipo.usuarioByIdUsuarioAsignado.nombreCompleto}" /> </td>
						
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<c:if test="${mngCrearReporte.lastPageNumber > 0}">
	  			<nav class="text-center">
				  <ul class="pagination">
				    <li>
				      <a href="<c:url value="/reparacion/list.html" />" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach var="i" items="${mngCrearReporte.pageNumberList}">
				   	<li><a href="<c:url value="/reparacion/list/${i}.html" />"> <c:out value="${i}"/></a></li>
					</c:forEach>
				    <li>
				      <a href="<c:url value="/reparacion/list/${mngCrearReporte.lastPageNumber}.html" />" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</c:if>
		</div>
</div>
</div>
</div> <!-- panel container -->
<div class="col-md-2"> </div>

