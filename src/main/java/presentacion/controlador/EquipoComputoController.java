package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentacion.manager.MngCrearEquipo;
import presentacion.manager.MngCrearUsuario;
import dominio.EquipoComputo;
import dominio.Usuario;
import servicio.EquipoComputoService;

/**
 * Spring MVC controller that handles CRUD requests for Equipocomputo entities
 * @author Heriberto Galdamez
 */
@Controller("equipoComputoController")
@RequestMapping("/equipo")
public class EquipoComputoController {

	
	/**
	 * log a utilizar
	 */
	private static final Logger log = Logger.getLogger(EquipoComputoController.class);

    /**
     * Spring MVC controller that handles CRUD requests for Equipocomputo entities
     */
    public EquipoComputoController() {
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
    @RequestMapping("/registrar")
    public ModelAndView mostrarPantallaRegistrarUsuario() {
    	MngCrearEquipo mngCrearEquipo =equipoComputoService.iniciarCrearEquipoComputo(new MngCrearEquipo());
    	mngCrearEquipo.setPaginaCaracteristica("cpu.jsp");
    	mngCrearEquipo.setEquipoComputo(new EquipoComputo());
    	log.debug("tamanio del mapa " +mngCrearEquipo.getTipoCaracteristicaMap().size());
    	return new ModelAndView("registrarEquipo","mngCrearEquipo",mngCrearEquipo);
    	
    }

    /**
     * 
     */
    public void registarEquipoComputo() {
        // TODO implement here
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