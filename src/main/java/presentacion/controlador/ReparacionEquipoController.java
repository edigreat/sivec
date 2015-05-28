package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;

import java.io.Serializable;
import java.util.*;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentacion.manager.MngAdminEquipo;
import presentacion.manager.MngCrearReparacionForm;
import servicio.EquipoComputoService;
import servicio.ReparacionEquipoService;

/**
 * @author Heriberto Galdamez
 */
@Controller("reparacionEquipoController")
@RequestMapping("/reparacion")
public class ReparacionEquipoController implements Serializable  {

    /**
	 * UID  a utilizar
	 */
	private static final long serialVersionUID = -6343212975878168337L;

	/**
	 * Log a utilizar
	 */
	private static final Logger log = Logger.getLogger(ReparacionEquipoController.class);
	/**
     * Constructor publico
     */
    public ReparacionEquipoController() {
    }

    /**
     * Servicio inyectado por spring que realiza operaciones
     * sobre entidad ReparacionEquipo
     */
    @Autowired
    private ReparacionEquipoService reparacionEquipoService;
    
    @Autowired
    private EquipoComputoService equipoComputoService;

    /**
     * Inicializa la pantalla para
     * registrar una reparacion
     */
    @RequestMapping("/registrarreparacionequipo")
    public ModelAndView mostrarRegistrarReparacion(@RequestParam("idEquipoComputo")String idEquipoComputo) {
    	log.debug("Iniciando registrar equipo" +  reparacionEquipoService);
     	//TODO:Cambiar validar que tenga usuario asignado

    	MngCrearReparacionForm mngCrearReparacionForm = reparacionEquipoService.iniciarRegistrarReparacion(idEquipoComputo);
    	if(mngCrearReparacionForm.isHasError()){
    		MngAdminEquipo mngAdminEquipo = equipoComputoService.buscarTodos("0",MAX_ROWS);
    		mngAdminEquipo.setHasError(true);
    		mngAdminEquipo.setDescripcionError(mngCrearReparacionForm.getDescripcionError());
        	return new ModelAndView("administrarequipo","mngAdminEquipo", mngAdminEquipo  ) ;

    	}
    	
    	return new ModelAndView("registrarReparacion","mngCrearReparacionForm",mngCrearReparacionForm);
   }

    @RequestMapping("/confirmarreparacion")
    public String confirmarRegistrarReparacion(
    		@Valid MngCrearReparacionForm mngCrearReparacionForm,
    		BindingResult result){
    	log.debug("Tiene errores " + result.hasErrors());
  		
  		if(result.hasErrors()){
  			
  			return "registrarReparacion";
  		}else{
  			MngCrearReparacionForm insertarReparacionEquipo = reparacionEquipoService.insertarReparacionEquipo(mngCrearReparacionForm);
  			return "redirect:/equipo/list.html";
  		}
    }

}