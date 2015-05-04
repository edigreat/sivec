package presentacion.controlador;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import servicio.EquipoComputoService;

/**
 * Spring MVC controller that handles CRUD requests for Equipocomputo entities
 * @author Heriberto Galdamez
 */
@Controller
@RequestMapping("/equipo")
public class EquipocomputoController {

    /**
     * Spring MVC controller that handles CRUD requests for Equipocomputo entities
     */
    public EquipocomputoController() {
    }

    /**
     * Service injected by Spring that provides CRUD operations for Equipocomputo entities
     */
    private EquipoComputoService equipoComputoService;

    /**
     * 
     */
    public void newEquipo() {
        // TODO implement here
    }

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
     * 
     */
    public void mostrarPantallaRegistrarEquipo() {
        // TODO implement here
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
    public void mostrarAdministrarEquipos() {
        // TODO implement here
    }

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