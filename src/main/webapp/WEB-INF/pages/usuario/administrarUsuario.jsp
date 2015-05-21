<%-- 
    Document   : administrarUsuario.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="twelve columns">
     <h4>
     <a href=" <c:url value="/usuario/registrar.html" />"
		 class="btn btn-primary btn-lg active" >
		 Nuevo Usuario
     <span class="glyphicon glyphicon-plus" aria-hidden="true">
     </span>
     </a>
     </h4>
</div>
<div id="panel-container" class="col-md-10">
<div class="panel panel-primary ">

	<div class="panel-heading">
   	 	<h3 class="panel-title">Lista de usuarios</h3>
   	 </div>
   <div class="panel-body">
   	
   
		<div class="row ">
			
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<th>Matrícula</th>
						<th>Nombre de usuario</th>
						<th>Nombre completo</th>
						<th>Tipo</th>
						<th>Acción</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarioList}" var="usuario" varStatus="status">
						<tr>
							<td><c:out value="${usuario.idUsuario}" /> </td>
							<td><c:out value="${usuario.correoEletronico}" /> </td>
							<td><c:out value="${usuario.nombreCompleto}" /> </td>
							<td><c:out value="${usuario.descripcionPerfil}" /></td>
							<td>
							<a href=" <c:url value="/usuario/editar.html">
   										  <c:param name="idUsuario" value="${usuario.idUsuario}"/>
										  </c:url>"
										> Editar </a>		
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
		</div>
</div>
</div>
</div> <!-- panel container -->
<div class="col-md-2"> </div>

