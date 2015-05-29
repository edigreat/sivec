/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: Responsable.java
 * Autor: heriberto
 */
package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dominio.Usuario;
import servicio.EquipoComputoService;

/**
 * @author heriberto
 *
 */
@Controller("responsableController")
@RequestMapping("/responsable")
public class ResponsableController {
	
	/**
	 * log a utilizar
	 */
	private static final Logger log = Logger.getLogger(ResponsableController.class);
	/**
     * Servicio inyectado por spring que provee las operaciones para a entidad Equipo de computo
     */
    @Autowired
    private EquipoComputoService equipoComputoService;

	 @RequestMapping("/listUsuarioAsignado/{startResult}")
	    public ModelAndView mostrarPantallaPorUsuarioAsignadoPaginado(@PathVariable("startResult") String startResult) {
	     	log.debug("Entrando a mostrarPantallaPorUsuarioAsignadoPaginado " + startResult);
	     	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
	     	return new ModelAndView("consultarEquipoResponsable","mngAdminEquipo",equipoComputoService.buscarTodosPorUsuarioAsignado(startResult,MAX_ROWS,username));
	     }
	    
	    @RequestMapping("/listUsuarioAsignado")
	    public ModelAndView mostrarPantallaPorUsuarioAsignado() {
	     	log.debug("Entrando a mostrarPantallaPorUsuarioAsignado" );
	     	UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
	     	return new ModelAndView("consultarEquipoResponsable","mngAdminEquipo",equipoComputoService.buscarTodosPorUsuarioAsignado("0",MAX_ROWS,username));
	     }

}
