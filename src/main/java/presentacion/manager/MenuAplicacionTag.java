/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MenuAplicacionTag.java
 * Autor: heriberto
 */
package presentacion.manager;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import repositorio.UsuarioDao;

/**
 * @author heriberto
 *
 */
@Configurable
public class MenuAplicacionTag extends SimpleTagSupport {
		
	   private static final Logger log = Logger.getLogger(MenuAplicacionTag.class);
	
	  
	   public void doTag()
	      throws JspException, IOException
	    {
		   JspWriter out = getJspContext().getOut();
		 
		   //Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		    //Set<MenuRol> menuRolList = usuario.getMenuRols();
		    //for(MenuRol menuRol:menuRolList){
		    //	log.debug(menuRol);
		   // }
		   //out.print("Hola");
		   UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  // log.debug("-------> " +userDetails.getAuthorities());
		   String autorizacion="";
		   for (GrantedAuthority auth : userDetails.getAuthorities()) {
			   autorizacion = auth.getAuthority();
	        }
		   switch(autorizacion){
		   case "ROLE_ADMIN":
			   out.println("<li><a href=\"/sivec/usuario/list.html\">Usuarios</a></li>");
			   out.println("<li><a href=\"/sivec/reporte/list.html\">Reportes</a> </li>");
		   case "ROLE_CAPTURISTA":
			   out.println("<li><a href=\"/sivec/equipo/list.html\">Equipos</a></li>");
		   case "ROLE_RESPONSABLE":
			   out.println("<li><a href=\"/sivec/responsable/listUsuarioAsignado.html\">Responsable</a></li>");
		   
			break;
		   
			   	
		   }
		   
		   

	    }



}
