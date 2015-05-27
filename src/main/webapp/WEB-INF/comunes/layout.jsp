<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
   <tiles:insertAttribute name="title" ignore="true" />
</title>
 	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/base.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/skeleton.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/layout.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/child.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/prettyPhoto.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" />
<link media="screen"  rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css" />

	</head>
<body>
<div class="page-wrapper">
        <div class="slug-pattern"><div class="overlay"><div class="slug-cut"></div></div></div>

		<tiles:insertAttribute name="header" />
	
	 <div class="body">
            <div class="body-round"></div>
            <div class="body-wrapper">
            	<div class="content">
            		<div class="container callout standard">
            			<tiles:insertAttribute name="body" />
 					</div> <!--  fin container callout standard -->
 				</div> <!-- content -->
 				<div class="callout-hr"></div>                        
                    <div class="container">
                     <div class="clear"></div>
                                            
                        
                    </div>
                    
			</div> <!-- fin body-wrapper -->
			
	        <tiles:insertAttribute name="footer" />
			
	</div> <!-- fin body -->
		
		
</div> <!-- fin page-wrapper -->	
<h3>Session Scope (key==values)</h3>
<%
  java.util.Enumeration<String> sessEnum = request.getSession()
.getAttributeNames();
  while (sessEnum.hasMoreElements()) {
String s = sessEnum.nextElement();
out.print(s);
out.println("==" + request.getSession().getAttribute(s));
%><br />
<%
  }
%>

<h3>Request Scope (key==values)</h3>
<%
  java.util.Enumeration<String> requestEnum = request.getAttributeNames();
  while (requestEnum.hasMoreElements()) {
String s = requestEnum.nextElement();
out.print(s);
out.println("==" + request.getAttribute(s));
%><br />
<%
  }
%>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery.carousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery.color.animation.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery.prettyPhoto.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/vendor/jquery.autocomplete.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/default.js"></script>

	<script>
	$(document).ready(function() {
		$('#w-input-search').autocomplete({
			serviceUrl: '${pageContext.request.contextPath}/equipo/getUsuarioResponsable.html',
			paramName: "tagName",
			delimiter: ",",
			onSelect: function (suggestion) {
				$('input#usuarioResponsableTag').val(suggestion['data']);
				console.log("seleccionado " + $('input#usuarioResponsableTag').val());
			} 
			,
		    transformResult: function(response) {
		        return {
		            suggestions: $.map($.parseJSON(response), function(item) {
		        		
		                return { value: item.tagName, data: item.id };
		            })
		            
		        };
		        
		    }
		    
		});
		
		
	});
	</script>

</html>