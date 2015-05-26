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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes({SESSION_TIPOS_EQUIPOS_COMPUTO})
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
    
   
    
    /**
     * Service injected by Spring that provides CRUD operations for Equipocomputo entities
     */
    @Autowired
    private EquipoComputoService equipoComputoService;

    
    /**
     * 
     */
    @RequestMapping(value="/nuevo")
    public void insertarEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void borrarEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void actualizarEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarEquipoPorID() {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarTodos() {
        // TODO implement here
    }

    /**
     * 
     */
    public void cancelarBorrarEquipo() {
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
     * 
     */
    @RequestMapping("/list")
    public ModelAndView mostrarAdministrarEquipos() {
    	log.debug("Entrando a mostrarPantallaAdministrarEquipo ");
    	return new ModelAndView("administrarequipo","mngAdminEquipo",equipoComputoService.buscarTodos("0",MAX_ROWS));    }

    /**
     * 
     */
    public void mostrarEditarEquipo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarConfirmaBajaEquipo() {
        // TODO implement here
    }

}