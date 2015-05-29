<%-- 
    Document   : administrarEquipo.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
     			<h4 class="text-center">Lista de  Equipos Asignados </h4>
     			<h5 >Nombre de usuario: ${mngAdminEquipo.usuario.nombreCompleto} </h5>
				<c:if test="${mngAdminEquipo.hasError==true}">
				 <div class="alert alert-danger" role="alert">
				 ${mngAdminEquipo.descripcionError}
				  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				</div>
				</c:if>

</div>
<div id="panel-container" class="col-md-10">
<br />
<div class="panel panel-primary ">

	<div class="panel-heading">
   	 	<h3 class="panel-title">Lista de Equipos</h3>
   	 </div>
   <div class="panel-body">
   	
   
		<div class="row">
			
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Cve. Ref</th>
						<th>Tipo</th>
						<th>Responsable Equipo</th>
						<th>Fecha ult. Movimiento</th>
						<th>Acción</th>
					
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mngAdminEquipo.equipoComputoList}" var="equipoComputo" varStatus="status">
						<tr>
							<td><c:out value="${equipoComputo.idEquipoComputo}" /> </td>
							<td><c:out value="${equipoComputo.descTipoEquipo}" /> </td>
							<td><c:out value="${equipoComputo.usuarioByIdUsuarioResponsable.nombreCompleto}" /> </td>
							<td><c:out value="${equipoComputo.fechaActuallizacionFormato}" /> </td>
							
							<td>
							<a class="linkTabla" href=" <c:url value="/responsable/detalleEquipoComputo.html">
   										  <c:param name="idEquipoComputo" value="${equipoComputo.idEquipoComputo}"/>
										  </c:url>"
										> Ver Detalle</a>		
							</td>
							
							
							
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<c:if test="${mngAdminEquipo.lastPageNumber > 0}">
	  			<nav class="text-center">
				  <ul class="pagination">
				    <li>
				      <a href="<c:url value="/responsable/listUsuarioAsignado.html" />" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach var="i" items="${mngAdminEquipo.pageNumberList}">
				   	<li><a href="<c:url value="/responsable/listUsuarioAsignado/${i}.html" />"> <c:out value="${i}"/></a></li>
					</c:forEach>
				    <li>
				      <a href="<c:url value="/responsable/listUsuarioAsignado/${mngAdminEquipo.lastPageNumber}.html" />" aria-label="Next">
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

