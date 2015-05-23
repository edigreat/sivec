package presentacion.controlador;


import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import dominio.Usuario;
import presentacion.manager.MngCrearUsuario;
import servicio.EquipoComputoService;
import servicio.UsuarioService;

/**
 * Spring MVC controller that handles CRUD requests for Usuario entities
 * @author Heriberto Galdamez
 */
@Controller("usuarioController")
@RequestMapping("/usuario")
@SessionAttributes({"mngEditarUsuarioInstance"})
public class UsuarioController {
	
	private static final Logger log = Logger.getLogger(UsuarioController.class);


    public UsuarioController() {
    }

    @ModelAttribute("mngEditarUsuarioInstance")
    public MngCrearUsuario getMngEditarUsuarioInstance() {
		log.debug("Creando una instancia mngEditarUsuarioInstance ");
        return new MngCrearUsuario();
    }
    
    /**
     * Service injected by Spring that provides CRUD operations for Usuario entities
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * 
     */
    @Autowired
    private EquipoComputoService equipoComputoService;

  
    /**
     * 
     */
    @RequestMapping("/guardarinformacionusuario")
    public String guardarInformacionUsuario(@ModelAttribute("mngCrearUsuarioInstance")MngCrearUsuario mngCrearUsuarioInstance) {
    	log.info(mngCrearUsuarioInstance);
    	mngCrearUsuarioInstance = usuarioService.insertarUsuario(mngCrearUsuarioInstance);
    	return "redirect:/usuario/list.html";
    }

    /**
     * 
     */
    public void borrarUsuario() {
        // TODO implement here
    }
    
    /**
     * Muestra la pantalla para editar un usuario
     */
    @RequestMapping("/editar")
    public ModelAndView mostrarEditarUsuario(@RequestParam("idUsuario")Integer idUsuario,
    		@ModelAttribute("mngEditarUsuarioInstance")MngCrearUsuario mngEditarUsuarioInstance) 
    	{
    	log.info("Entrando a mostrarEditarUsuario [" +idUsuario+"]" );
    	mngEditarUsuarioInstance =usuarioService.iniciarEditarUsuario(mngEditarUsuarioInstance,idUsuario);
        return new ModelAndView("editarUsuario","mngEditarUsuarioInstance",mngEditarUsuarioInstance);

    }

    /**
     * Realiza la actualizacion de la informacion del usuario.
     */
    @RequestMapping("/actualizarinformacionusuario")
    public String actualizarUsuario(@ModelAttribute("mngEditarUsuarioInstance")MngCrearUsuario mngEditarUsuarioInstance) {
    	log.debug("Actualizando usuario : " +mngEditarUsuarioInstance);
    	boolean isUpdate = usuarioService.actualizarUsuario(mngEditarUsuarioInstance);
    	return "redirect:/usuario/list.html";
    }

    /**
     * Cancela la actualizacion del usuario
     * @param status de la session
     * @return nombre de la vista a presentar
     */
    @RequestMapping("/cancelaractualizacion")
    public String cancelarActualizacion(SessionStatus status) {
		status.setComplete();
    	return "redirect:/usuario/list.html";
    }
    
    @RequestMapping("/eliminarusuario")
    public String eliminarUsuario(SessionStatus status,@RequestParam("idUsuario")String idUsuario){
    
    	usuarioService.borrarUsuario(idUsuario);
    	status.setComplete();
    	return "redirect:/usuario/list.html";
    }
    
    /**
     * 
     * 
     */
    public void buscarUsuarioPorEmail() {
        
    }

    /**
     * 
     */
    public void mostrarEquipoResponsable() {
        // TODO implement here
    }

    /**
     * 
     */
    public void seleccionarEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verDetalleEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void regresarConsultaEquipoPorResponsable() {
        // TODO implement here
    }

    /**
     * 
     * 
     */
    @RequestMapping("/list")
   public ModelAndView mostrarPantallaAdministrarUsuario() {
    	log.debug("Entrando a mostrarPantallaAdministrarUsuario ");
    	return new ModelAndView("administrarusuario","usuarioList",usuarioService.buscarTodos(0, 10).getUsuarioList());
    }

    /**
     * @return
     */
    public ModelAndView createMngAdminUsuario() {
    	log.debug("Entrando a createMngAdminUsuario ");
    	return new ModelAndView("registrarUsuario","usuarioInstance",new Usuario());
  
    }

    
    /**
     * Muestra la pantalla de registrar usuario
     * 
     * @return modelo y vista para registar un usuario
     */
    @RequestMapping("/registrar")
    public ModelAndView mostrarPantallaRegistrarUsuario() {
    	MngCrearUsuario mngCrearUsuarioInstance = new MngCrearUsuario();
    	mngCrearUsuarioInstance =usuarioService.iniciarCrearUsuario(mngCrearUsuarioInstance);
    	mngCrearUsuarioInstance.setUsuario(new Usuario());
    	return new ModelAndView("registrarUsuario","mngCrearUsuarioInstance",mngCrearUsuarioInstance);
    	
    }

    

    /**
     * 
     */
    public void mostrarConfirmacionBajaUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void confirmarBajaUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void cancelarBajaUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void cerrarDetalleEquipo() {
        // TODO implement here
    }

}