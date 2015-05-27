package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.*;

import java.io.Serializable;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import presentacion.manager.MngCaracteristicaEquipo;
import presentacion.manager.MngCrearEquipoForm;
import presentacion.manager.MngCrearUsuario;
import dominio.EquipoComputo;
import dominio.EquipoValorCarac;
import dominio.MenuRol;
import dominio.Usuario;
import servicio.EquipoComputoService;

/**
 * Spring MVC controller that handles CRUD requests for Equipocomputo entities
 * @author Heriberto Galdamez
 */
@Controller("equipoComputoController")
@RequestMapping("/equipo")
@SessionAttributes({SESSION_TIPOS_EQUIPOS_COMPUTO,SESSION_ESTADO_EQUIPO})
public class EquipoComputoController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 793233722775492106L;
	/**
	 * log a utilizar
	 */
	private static final Logger log = Logger.getLogger(EquipoComputoController.class);

    /**
     * Spring MVC controller that handles CRUD requests for Equipocomputo entities
     */
    public EquipoComputoController() {
    }

    @ModelAttribute(SESSION_TIPOS_EQUIPOS_COMPUTO)
    public Map<String,String> getTipoEquipoComputoMap(){
    	Map<String,String> tipoEquipoComputoMap = new HashMap<>();
    	tipoEquipoComputoMap.put("CPU","CPU");
    	tipoEquipoComputoMap.put("MONITOR","MONITOR");
    	tipoEquipoComputoMap.put("TABLET","TABLET");
    	tipoEquipoComputoMap.put("MOUSE","MOUSE");
    	return tipoEquipoComputoMap;
    }
    
    @ModelAttribute(SESSION_ESTADO_EQUIPO)
    public Map<String,String> getEstadoEquipoMap(){
    	Map<String,String> estadoEquipoMap = new HashMap<>();
    	estadoEquipoMap.put("REGISTRADO","REGISTRADO");
    	estadoEquipoMap.put("ASIGNADO","ASIGNADO");
    	estadoEquipoMap.put("REPARACION","REPARACION");
    	return estadoEquipoMap;
    }
   
    
    /**
     * Service injected by Spring that provides CRUD operations for Equipocomputo entities
     */
    @Autowired
    private EquipoComputoService equipoComputoService;

    /**
     * 
     */
    @RequestMapping(value="/eliminarequipocomputo")
    public String confirmarBajaEquipo(SessionStatus status,@RequestParam("idEquipoComputo")String idEquipoComputo){
    	equipoComputoService.borrarEquipo(idEquipoComputo);
    	status.setComplete();
    	return "redirect:/equipo/list.html";
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
     * Guarda la información de un equipo
     */
    @RequestMapping(value="/guardarinformacionequipo",method=RequestMethod.POST)
    public String registarEquipoComputo(@Valid MngCrearEquipoForm mngCrearEquipoForm,
    		BindingResult result) {
       log.debug(mngCrearEquipoForm);
       log.debug("Tiene errores " + result.hasErrors());
		if(result.hasErrors()){
			return "registrarEquipo";
		}
		else
		{	
	       	equipoComputoService.insertarEquipo(mngCrearEquipoForm);

			return "redirect:/equipo/list.html";
		}
    }

    /**
     * Muestra la lista de la primera pagina de
     * equipos de computo
     */
    @RequestMapping("/list")
    public ModelAndView mostrarAdministrarEquipos() {
    	log.debug("Entrando a mostrarPantallaAdministrarEquipo ");
    	return new ModelAndView("administrarequipo","mngAdminEquipo",equipoComputoService.buscarTodos("0",MAX_ROWS));    }

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
     * Muestra la pantalla de editar equipo de computo
     */
    @RequestMapping("/editar")
    public ModelAndView mostrarEditarEquipo(@RequestParam("idEquipoComputo")String idEquipoComputo) {
    	log.info("Entrando a mostrarEditarEquipo [" +idEquipoComputo+"]" );
    	 MngCrearEquipoForm mngCrearEquipoForm = equipoComputoService.iniciarEditarEquipo(idEquipoComputo,new MngCrearEquipoForm());
        return new ModelAndView("editarEquipo","mngCrearEquipoForm",mngCrearEquipoForm);

    }
    
    
    /**
     * Buscar a todos los usuarios que correspondan
     * a un patron de correo
     * @param correoElectronico
     * @return lista con los usuarios que corresponden al patron de correo
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
      public String actualizarUsuario(@Valid MngCrearEquipoForm mngCrearEquipoForm,BindingResult result) {
      	log.debug("Actualizando Equipo : " +mngCrearEquipoForm);
      	log.info(mngCrearEquipoForm);
  		log.debug("Tiene errores " + result.hasErrors());
  		if(result.hasErrors()){
  	    	  mngCrearEquipoForm = equipoComputoService.iniciarEditarEquipo(
  	    			  mngCrearEquipoForm.getEquipoComputo().getIdEquipoComputo()+"",
  	    			  new MngCrearEquipoForm());
  			return "editarEquipo";
  		}
  		else
  		{	
  			mngCrearEquipoForm = equipoComputoService.actualizarEquipo(mngCrearEquipoForm);
  			return "redirect:/equipo/list.html";
  		}
      }

}