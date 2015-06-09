/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MenuAplicacionTag.java
 * Autor: heriberto
 */
package presentacion.manager;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import dominio.MenuItem;
import dominio.MenuRol;
import dominio.Usuario;
import repositorio.UsuarioDao;
import servicio.UsuarioService;

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
		
		   UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		   UsuarioService usuarioService = (UsuarioService) ctx.getBean("usuarioService");
		   log.debug("-------> ctx " +ctx);
		   log.debug("-------> usuarioService " +usuarioService);
		   
		   String autorizacion="";
		   for (GrantedAuthority auth : userDetails.getAuthorities()) {
			   autorizacion = auth.getAuthority();
	        }
		   List<MenuRol> menuRolList = usuarioService.buscarListaMenuPorUsuario(autorizacion);
		   for(Object object: menuRolList.get(0).getMenuItems()){
				MenuItem menuItem = (MenuItem) object;
				log.debug(menuItem);
				out.println("<li><a href=\""+menuItem.getAccion()+"\">" + menuItem.getEtiqueta() +"</a></li>");
			}
		   

	    }



}
