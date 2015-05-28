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
	   
	   
	   private static UsuarioDao myDao;
	  
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
		   //UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   //log.debug("-------> " +userDetails);
		   log.debug("-------> " +myDao);
		   out.println("<li><a href=\"/sivec/usuario/list.html\">Usuarios</a></li>");
		   out.println("<li><a href=\"/sivec/equipo/list.html\">Equipos</a></li>");
		   out.println("<li><a href=\"/sivec/usuario/listUsuarioAsignado.html\">Responsable</a></li>");
		   out.println("<li><a href=\"/sivec/reporte/list.html\">Reportes</a> </li>");
	    }


	   @Autowired
	   public static void setUsuarioDao(UsuarioDao usuarioDao) {
		MenuAplicacionTag.myDao = usuarioDao;
	}

}
