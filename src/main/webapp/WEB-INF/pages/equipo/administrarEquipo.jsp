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
     			<h3 class="text-center">Administrar Equipos </h3>
<div class="col-md-3">
     <a href=" <c:url value="/equipo/registrar.html" />"
		 class="btn btn-primary  active" >
		 Nuevo Equipo </a>
     <span class="glyphicon glyphicon-plus" aria-hidden="true">
     </span>
 </div>
     
     <div class="col-md-6">
     <form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/equipo/buscarEquipoPorId.html" >
     <label for="correoElectronico">Id del equipo</label>
     <input type="text" id="correoElectronico" name="correoElectronico" />
     <input type="submit" class="btn btn-primary  active"  value="buscar" />
      <span class="glyphicon glyphicon-search" aria-hidden="true">
     </span>
     </form>
     
</div>

</div>
<div id="panel-container" class="col-md-10">
<br />
<div class="panel panel-primary ">

	<div class="panel-heading">
   	 	<h3 class="panel-title">Lista de Equipos</h3>
   	 </div>
   <div class="panel-body">
   	
   
		<div class="row ">
			
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Cve. Ref</th>
						<th>Tipo</th>
						<th>Responsable Equipo</th>
						<th>Estado</th>
						<th>Acción</th>
						<th>Reparación</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${mngAdminEquipo.equipoComputoList}" var="equipoComputo" varStatus="status">
						<tr>
							<td><c:out value="${equipoComputo.idEquipoComputo}" /> </td>
							<td><c:out value="${equipoComputo.descTipoEquipo}" /> </td>
							<td><c:out value="${equipoComputo.usuarioByIdUsuarioResponsable.nombreCompleto}" /> </td>
							<td><c:out value="${equipoComputo.estadoEquipo}" /> </td>
							
							<td>
							<a class="linkTabla" href=" <c:url value="/equipo/editar.html">
   										  <c:param name="idEquipoComputo" value="${equipoComputo.idEquipoComputo}"/>
										  </c:url>"
										> Editar/Asignar </a>		
							</td>
							<td>
							<a class="linkTabla" href=" <c:url value="/equipo/registrarReparacion.html">
   										  <c:param name="idEquipoComputo" value="${equipoComputo.idEquipoComputo}"/>
										  </c:url>"
										> Registrar Reparacion </a>		
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<c:if test="${mngAdminEquipo.lastPageNumber > 0}">
	  			<nav class="text-center">
				  <ul class="pagination">
				    <li>
				      <a href="<c:url value="/equipo/list.html" />" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach var="i" items="${mngAdminEquipo.pageNumberList}">
				   	<li><a href="<c:url value="/equipo/list/${i}.html" />"> <c:out value="${i}"/></a></li>
					</c:forEach>
				    <li>
				      <a href="<c:url value="/equipo/list/${mngAdminEquipo.lastPageNumber}.html" />" aria-label="Next">
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

