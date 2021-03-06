package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.*;

import java.io.Serializable;
import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import dominio.Usuario;
import presentacion.manager.MngAdminEquipo;
import presentacion.manager.MngCaracteristicaEquipo;
import presentacion.manager.MngCrearEquipoForm;
import presentacion.manager.TagAutoCompleteUsuario;
import servicio.EquipoComputoService;
import servicio.UsuarioService;

/**
 * Spring MVC controller that handles CRUD requests for Equipocomputo entities
 * @author Heriberto Galdamez
 */
@Controller("equipoComputoController")
@RequestMapping("/equipo")
@SessionAttributes({SESSION_TIPOS_EQUIPOS_COMPUTO,SESSION_ESTADO_EQUIPO})
public class EquipoComputoController implements Serializable {

	
	/**
	 * UID a utilizar
	 */
	private static final long serialVersionUID = 793233722775492106L;
	/**
	 * log a utilizar
	 */
	private static final Logger log = Logger.getLogger(EquipoComputoController.class);

    /**
     * Constructor publico
     */
    public EquipoComputoController() {
    }

    /**
     * Atributo de session para los tipos
     * de equipos de computo
     * @return mapa con los tipos de computo
     */
    @ModelAttribute(SESSION_TIPOS_EQUIPOS_COMPUTO)
    public Map<String,String> getTipoEquipoComputoMap(){
    	Map<String,String> tipoEquipoComputoMap = new HashMap<>();
    	tipoEquipoComputoMap.put("CPU","CPU");
    	tipoEquipoComputoMap.put("MONITOR","MONITOR");
    	tipoEquipoComputoMap.put("TABLET","TABLET");
    	tipoEquipoComputoMap.put("MOUSE","MOUSE");
    	tipoEquipoComputoMap.put("LAPTOP","LAPTOP");

    	return tipoEquipoComputoMap;
    }
    
    /**
     * Atributo de sesion para los estados 
     * de los equipos
     * @return mapa con los estados de los equipos
     */
    @ModelAttribute(SESSION_ESTADO_EQUIPO)
    public Map<String,String> getEstadoEquipoMap(){
    	Map<String,String> estadoEquipoMap = new HashMap<>();
    	estadoEquipoMap.put("REGISTRADO","REGISTRADO");
    	estadoEquipoMap.put("ASIGNADO","ASIGNADO");
    	estadoEquipoMap.put("REPARACION","REPARACION");
    	return estadoEquipoMap;
    }
   
    
    /**
     * Servicio inyectado por Spring para las operaciones sobre
     * la entdad Equipocomputo 
     */
    @Autowired
    private EquipoComputoService equipoComputoService;
    
    /**
     * Servicio inyectado por Spring para las operaciones
     * sobre a entidad Usuario
     */
    @Autowired
    private UsuarioService usuarioService;
    
    /**
     * Confirma la eliminacion de un registro de usuario
     */
    @RequestMapping(value="/eliminarequipocomputo")
    public ModelAndView confirmarBajaEquipo(SessionStatus status,@RequestParam("idEquipoComputo")String idEquipoComputo){
    	equipoComputoService.borrarEquipo(idEquipoComputo);
    	status.setComplete();
    	MngAdminEquipo mngAdminEquipo = equipoComputoService.buscarTodos("0",MAX_ROWS);
    	mngAdminEquipo.setHasMensaje(true);
       	mngAdminEquipo.setDescripcionMensaje("Registro borrado con exito, id eliminado : " + idEquipoComputo);
       	return new ModelAndView("administrarequipo","mngAdminEquipo",mngAdminEquipo);
    	
    }

    /**
     * Obtiene los nombres de usuarios por apellido paterno
     * @param tagName
     * @return lista con los nombres de los usuarios
     */
    
    @RequestMapping(value = "/getUsuarioResponsable", method = RequestMethod.GET)
	@ResponseBody
	public List<TagAutoCompleteUsuario> getTags(@RequestParam String tagName) {
    	log.debug("Buscando usuario por " + tagName);
    	
		return usuarioService.buscarTodosPorApPaterno(tagName);

	}
   
    /**
     * Muestra la pantalla de registrar usuario
     * 
     * @return modelo y vista para registar un usuario
     */
    @RequestMapping(value="/registrar",method=RequestMethod.GET)
    public ModelAndView mostrarPantallaRegistrarEquipo() {
    	 MngCrearEquipoForm mngCrearEquipoForm  = new MngCrearEquipoForm();
    	 List<MngCaracteristicaEquipo> mngCaracteristicaEquipoList=new ArrayList<MngCaracteristicaEquipo>();
    	 for(int i=0;i < MAX_CARACTERISTICA_EQUIPO ;i++){
    		 mngCaracteristicaEquipoList.add(new MngCaracteristicaEquipo()); 
    	 }
    	 mngCrearEquipoForm.setMngCaracteristicaEquipoList(mngCaracteristicaEquipoList);
    	return new ModelAndView("registrarEquipo","mngCrearEquipoForm",mngCrearEquipoForm);
    	
    }

    /**
     * Confirma y guarda la información de un equipo
     */
    @RequestMapping(value="/guardarinformacionequipo",method=RequestMethod.POST)
    public ModelAndView registarEquipoComputo(@Valid MngCrearEquipoForm mngCrearEquipoForm,
    		BindingResult result) {
       log.debug(mngCrearEquipoForm);
       log.debug("Tiene errores " + result.hasErrors());
		if(result.hasErrors()){
			for (Object object : result.getAllErrors()) {
  			    if(object instanceof FieldError) {
  			        FieldError fieldError = (FieldError) object;

  			        System.out.println(fieldError.getField() + " "+fieldError.getDefaultMessage());
  			    }

  			    if(object instanceof ObjectError) {
  			        ObjectError objectError = (ObjectError) object;
 
  			        System.out.println(objectError.getObjectName());
  			    }
  			    }
	    	return new ModelAndView("registrarEquipo","mngCrearEquipoForm",mngCrearEquipoForm);
	    	
		}
		else
		{	
	       	equipoComputoService.insertarEquipo(mngCrearEquipoForm);
	       
	       	MngAdminEquipo mngAdminEquipo = equipoComputoService.buscarTodos("0",MAX_ROWS);
	       	mngAdminEquipo.setHasMensaje(true);
	       	mngAdminEquipo.setDescripcionMensaje("Registro con exito, id asignado : " + mngCrearEquipoForm.getEquipoComputo().getIdEquipoComputo());
	       	return new ModelAndView("administrarequipo","mngAdminEquipo",mngAdminEquipo);

		}
    }

    /**
     * Muestra la lista de la primera pagina de
     * equipos de computo
     */
    @RequestMapping("/list")
    public ModelAndView mostrarAdministrarEquipos() {
    	log.debug("Entrando a mostrarPantallaAdministrarEquipo ");
		MngAdminEquipo mngAdminEquipo = equipoComputoService.buscarTodos("0",MAX_ROWS);
		if(mngAdminEquipo.getEquipoComputoList()==null || mngAdminEquipo.getEquipoComputoList().size()==0){
			mngAdminEquipo.setHasError(true);
	       	mngAdminEquipo.setDescripcionError("No se encontraron registros");
	       
		}
       	
    	return new ModelAndView("administrarequipo","mngAdminEquipo",mngAdminEquipo);    
    	}

    /**
     * Muestra el listado de equipo
     * por pagina
     * @param startResult pagina a mostrar
     * @return listado de usuarios de la pagina
     */
    @RequestMapping("/list/{startResult}")
    public ModelAndView mostrarAdministrarEquipos(@PathVariable("startResult") String startResult) {
     	log.debug("Entrando a mostrarPantallaAdministrarEquipo " + startResult);
     	return new ModelAndView("administrarequipo","mngAdminEquipo",equipoComputoService.buscarTodos(startResult,MAX_ROWS));
     }
    
    /**
     * Muestra la pantalla de editar un equipo de computo
     */
    @RequestMapping("/editar")
    public ModelAndView mostrarEditarEquipo(@RequestParam("idEquipoComputo")String idEquipoComputo) {
    	log.info("Entrando a mostrarEditarEquipo [" +idEquipoComputo+"]" );
    	 MngCrearEquipoForm mngCrearEquipoForm = equipoComputoService.iniciarEditarEquipo(idEquipoComputo,new MngCrearEquipoForm());
        return new ModelAndView("editarEquipo","mngCrearEquipoForm",mngCrearEquipoForm);

    }
    
    
    /**
     * Buscar a todos los usuarios que correspondan
     * a un patron de tipo de equipo
     * @param tipo de equipo
     * @return lista con los equipos que corresponden al patron
     */
    @RequestMapping("/buscarEquipoPorTipo")
    public ModelAndView buscarEquipoPorTipo(@RequestParam("tipoEquipoComputo")String tipoEquipoComputo) {
    	return new ModelAndView("administrarequipo","mngAdminEquipo",equipoComputoService.buscarTodos(tipoEquipoComputo));
    }

    /**
     * Cancelela calquier operacion
     * @param status status de la sesion
     * @return listado de equipos de computo
     */
    @RequestMapping("/cancelaractualizacion")
    public String cancelarActualizacion(SessionStatus status) {
		status.setComplete();
    	return "redirect:/equipo/list.html";
    }
    
    /**
     * Guarda la informacion de un equipo de equipo actualizada
     * Si tiene errores, regresa la misma pagina mostrandolos
     * @param mngCrearUsuario informacion actualizada del usuario
     * @param result mensajes de errores si existen
     * @return resultado de la actualizacion
     */
      @RequestMapping("/actualizarinformacionusuario")
      public ModelAndView actualizarUsuario(
    		  @Valid MngCrearEquipoForm mngCrearEquipoForm,BindingResult result) {
      	log.info(mngCrearEquipoForm);
  		log.debug("Tiene errores " + result.hasErrors());
  		
  		if(result.hasErrors()){
  			for (Object object : result.getAllErrors()) {
  			    if(object instanceof FieldError) {
  			        FieldError fieldError = (FieldError) object;

  			        System.out.println(fieldError.getField() + " "+fieldError.getDefaultMessage());
  			    }

  			    if(object instanceof ObjectError) {
  			        ObjectError objectError = (ObjectError) object;
 
  			        System.out.println(objectError.getObjectName());
  			    }
  			}
  	    	  mngCrearEquipoForm = equipoComputoService.iniciarEditarEquipo(
  	    			  mngCrearEquipoForm.getEquipoComputo().getIdEquipoComputo()+"",
  	    			  new MngCrearEquipoForm());
  	       	return new ModelAndView("editarEquipo","mngCrearEquipoForm",mngCrearEquipoForm);

  		}
  		else
  		{	
  			mngCrearEquipoForm = equipoComputoService.actualizarEquipo(mngCrearEquipoForm);
  			MngAdminEquipo mngAdminEquipo = equipoComputoService.buscarTodos("0",MAX_ROWS);
	       	mngAdminEquipo.setHasMensaje(true);
	       	mngAdminEquipo.setDescripcionMensaje("Registro actualizado con exito, id actualizado : " + mngCrearEquipoForm.getEquipoComputo().getIdEquipoComputo());
	       	return new ModelAndView("administrarequipo","mngAdminEquipo",mngAdminEquipo);
  		}
      }

}