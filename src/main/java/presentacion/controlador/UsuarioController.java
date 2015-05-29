package presentacion.controlador;


import java.util.*;

import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import static presentacion.manager.ConstantesPresentacion.*;
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
public class UsuarioController {
	/**
	 * log a utilizar
	 */
	private static final Logger log = Logger.getLogger(UsuarioController.class);

	/**
	 * Constructor a utilzar
	 */

    public UsuarioController() {
    }

    
    /**
     * Servicio inyectado por spring que provee las operaciones para a entidad Usuario
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Servicio inyectado por spring que provee las operaciones para a entidad Equipo de computo
     */
    @Autowired
    private EquipoComputoService equipoComputoService;

    /**
     * Validador inyectdo por spring , la implementacion de hibernate
     */

	@Autowired
	private Validator validator;
	
    /**
     * Inicializa la pantalla para editar un usuario
     * @param idUsuario id del usuario a editar
     * @return vista y  modelo inicializados
     */
    @RequestMapping("/editar")
    public ModelAndView mostrarEditarUsuario(@RequestParam("idUsuario")Integer idUsuario) 
    	{
    	log.info("Entrando a mostrarEditarUsuario [" +idUsuario+"]" );
    	MngCrearUsuario mngCrearUsuario =usuarioService.iniciarEditarUsuario(new MngCrearUsuario(),idUsuario);
        return new ModelAndView("editarUsuario","mngCrearUsuario",mngCrearUsuario);

    }

  /**
   * Guarda la informacion de un usuario actualizada
   * Si tiene errores, regresa la misma pagina mostrandolos
   * @param mngCrearUsuario informacion actualizada del usuario
   * @param result mensajes de errores si existen
   * @return resultado de la actualizacion
   */
    @RequestMapping("/actualizarinformacionusuario")
    public String actualizarUsuario(@Valid MngCrearUsuario mngCrearUsuario,BindingResult result) {
    	log.debug("Actualizando usuario : " +mngCrearUsuario);
    	log.info(mngCrearUsuario);
		log.debug("Tiene errores " + result.hasErrors());
		if(result.hasErrors()){
	    	mngCrearUsuario =usuarioService.iniciarEditarUsuario(mngCrearUsuario,mngCrearUsuario.getUsuario().getIdUsuario());
			return "editarUsuario";
		}
		else
		{	
	    	boolean isUpdate = usuarioService.actualizarUsuario(mngCrearUsuario);
			return "redirect:/usuario/list.html";
		}
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
    
    /**
     * Elimina un usuario
     * @param status variable de control de la session
     * @param idUsuario id de usuario a borrar
     * @return resultado de la operacion
     */
    @RequestMapping("/eliminarusuario")
    public String confirmarBajaUsuario(SessionStatus status,@RequestParam("idUsuario")String idUsuario){
    	usuarioService.borrarUsuario(idUsuario);
    	status.setComplete();
    	return "redirect:/usuario/list.html";
    }
    /**
     * Buscar a todos los usuarios que correspondan
     * a un patron de correo
     * @param correoElectronico
     * @return lista con los usuarios que corresponden al patron de correo
     */
    @RequestMapping("/buscarUsuarioPorEmail")
    public ModelAndView buscarUsuarioPorEmail(@RequestParam("correoElectronico")String correoElectronico) {
    	return new ModelAndView("administrarusuario","mngAdminUsuario",usuarioService.buscarTodos(correoElectronico));
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
     * Muestra la lista de usuarios
     * iniciando por la pagina inicial
     * 
     */
    @RequestMapping("/list")
   public ModelAndView mostrarPantallaAdministrarUsuario() {
    	log.debug("Entrando a mostrarPantallaAdministrarUsuario ");
    	return new ModelAndView("administrarusuario","mngAdminUsuario",usuarioService.buscarTodos("0",MAX_ROWS));
    }
    /**
     * Muestra el listado de usuarios
     * por pagina
     * @param startResult pagina a mostrar
     * @return listado de usuarios de la pagina
     */
    @RequestMapping("/list/{startResult}")
    public ModelAndView mostrarPantallaAdministrarUsuario(@PathVariable("startResult") String startResult) {
     	log.debug("Entrando a mostrarPantallaAdministrarUsuario " + startResult);
     	return new ModelAndView("administrarusuario","mngAdminUsuario",usuarioService.buscarTodos(startResult,MAX_ROWS));
     }
    
    /**
     * Muestra la pantalla de registrar usuario
     * 
     * @return modelo y vista para registar un usuario
     */
    @RequestMapping("/registrar")
    public ModelAndView mostrarPantallaRegistrarUsuario() {
    	MngCrearUsuario mngCrearUsuario = new MngCrearUsuario();
    	mngCrearUsuario =usuarioService.iniciarCrearUsuario(mngCrearUsuario);
    	mngCrearUsuario.setUsuario(new Usuario());
    	return new ModelAndView("registrarUsuario","mngCrearUsuario",mngCrearUsuario);
    	
    }

    /**
     * guarda la informacion de un usuario si 
     * la informacion es validad, en caso contrario
     * envia mensajes de error
     */
    @RequestMapping("/guardarinformacionusuario")
    public String guardarInformacionUsuario(
    		@Valid MngCrearUsuario mngCrearUsuario,BindingResult result) {
    	log.info(mngCrearUsuario);
		log.debug("Tiene errores " + result.hasErrors());
		if(result.hasErrors()){
			mngCrearUsuario =usuarioService.iniciarCrearUsuario(mngCrearUsuario);
	    	return "registrarUsuario";
		}
		else
		{	
			mngCrearUsuario =usuarioService.insertarUsuario(mngCrearUsuario);
			return "redirect:/usuario/list.html";
		}
    }
    

}