<%-- 
    Document   : principalSistema.jsp
    Author     : heriberto
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,java.util.List,dominio.*"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="col-md-10">
   <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Sistema de Inventario de equipos de cómputo</h1>
                <hr>
                <p>Bienvenido: ${usuario.nombreCompleto} </p>
                <p>Perfil: ${usuario.menuRol.descripcionRol} </p>
                <p>Elige una opción </p>
            </div>
        </div>
    </header>
</div>
