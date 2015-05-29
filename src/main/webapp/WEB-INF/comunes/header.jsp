<!DOCTYPE html>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="/WEB-INF/menuaplicaciontag.tld" prefix="menuapp" %>
  <div class="header">
            <div class="nav">
            
                
                <div class="container">
                
                    <!-- Standard Nav (x >= 768px) -->
                    <div class="standard">
                    
                        <div class="five column alpha">
                            <div class="logo">
                                <a href="index.html">
                                <img  height="55px" src="${pageContext.request.contextPath}/static/images/logoSivec.png"  />
                                </a>
                            </div>
                        </div>
                        <div class="eleven column omega tabwrapper">
                            <div class="menu-wrapper">
                                <ul class="tabs menu">
                                    <li>
                                    	<menuapp:menuseguridad/>
                                    </li>
                                    <li>
										<a href="<c:url value="/seguridad/salirdelsistema.html" />" > Salir </a>
                                    </li>
                                 </ul>
                                 </div>
                          </div>
                     </div>
               </div>
        </div>
         
            <div class="shadow"></div>
            <div class="container">
                <div class="page-title">
                    <div class="rg"></div>
                </div>
            </div>
    </div> <!-- fin header -->
