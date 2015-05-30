<%-- 
    Document   : administrarUsuario.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
     			<h3 class="text-center">Administrar Usuarios </h3>
     			<c:if test="${mngAdminUsuario.hasMensaje==true}">
				 <div class="alert alert-success" role="alert">
				 ${mngAdminUsuario.descripcionMensaje}
				  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				</div>
				</c:if>
     			<c:if test="${mngAdminUsuario.hasError==true}">
				 <div class="alert alert-danger" role="alert">
				 ${mngAdminUsuario.descripcionError}
				  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				</div>
				</c:if>
<div class="col-md-3">
     <a href=" <c:url value="/usuario/registrar.html" />"
		 class="btn btn-primary  active" >
		 Nuevo Usuario </a>
     <span class="glyphicon glyphicon-plus" aria-hidden="true">
     </span>
 </div>
     
     <div class="col-md-6">
     <form name="formbuscarporid" id="formbuscarporid" action="${pageContext.request.contextPath}/usuario/buscarUsuarioPorEmail.html" >
     <label for="correoElectronico">Nombre de usuario</label>
     <input type="text" id="correoElectronico" name="correoElectronico" maxlength="10" />
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
					<c:forEach items="${mngAdminUsuario.usuarioList}" var="usuario" varStatus="status">
						<tr>
							<td><c:out value="${usuario.idUsuario}" /> </td>
							<td><c:out value="${usuario.correoEletronico}" /> </td>
							<td><c:out value="${usuario.nombreCompleto}" /> </td>
							<td><c:out value="${usuario.descripcionPerfil}" /></td>
							<td>
							<a class="linkTabla" href=" <c:url value="/usuario/editar.html">
   										  <c:param name="idUsuario" value="${usuario.idUsuario}"/>
										  </c:url>"
										> Editar </a>		
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>
			<c:if test="${mngAdminUsuario.lastPageNumber > 0}">
	  			<nav class="text-center">
				  <ul class="pagination">
				    <li>
				      <a href="<c:url value="/usuario/list.html" />" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <c:forEach var="i" items="${mngAdminUsuario.pageNumberList}">
				   	<li><a href="<c:url value="/usuario/list/${i}.html" />"> <c:out value="${i}"/></a></li>
					</c:forEach>
				    <li>
				      <a href="<c:url value="/usuario/list/${mngAdminUsuario.lastPageNumber}.html" />" aria-label="Next">
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

