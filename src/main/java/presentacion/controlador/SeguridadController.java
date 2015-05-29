package presentacion.controlador;

import java.security.Principal;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dominio.Usuario;
import presentacion.manager.MngSeguridad;
import repositorio.UsuarioDao;
import servicio.SeguridadService;
import servicio.UsuarioService;

/**
 * @author Heriberto Galdamez
 */
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {

    /**
     * Constructor publico
     */
    public SeguridadController() {
    }
    
	/**
	 * DAO inyectado por Spring que maneja las entidades usuario
	 */
	@Autowired
	UsuarioService usuarioService;

    private static Logger log  = Logger.getLogger(SeguridadController.class);
  
    /**
     * 
     */
    @RequestMapping("/paginaPrincipal")
    public ModelAndView autenticarUsuario() {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Usuario usuario = usuarioService.buscarUsuarioPorEmail(username);
        return new ModelAndView("principalSistema","usuario",usuario);
    }
    
    /**
     * 
     */
    @RequestMapping("/salirdelsistema")
    public String salirUsuario() {
    	log.debug("Saliendo del sistema");
    	SecurityContextHolder.getContext().setAuthentication(null);
    	SecurityContextHolder.clearContext();
        return "redirect:j_spring_security_logout";
    }
    
    
    @RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
    	ModelAndView model = new ModelAndView();
    	if (user != null) {
			model.addObject("msg", "Lo sentimos, " + user.getName() 
			+ ", No tienes permisos para ver este pagina");
		} else {
			model.addObject("msg", 
			"No tienes permisos de acceso");
		}
 
		model.setViewName("403");
    	return model;
    }

  
}