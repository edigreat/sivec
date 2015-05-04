package presentacion.controlador;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import presentacion.manager.MngAdminUsuario;
import servicio.EquipoComputoService;
import servicio.UsuarioService;

/**
 * Spring MVC controller that handles CRUD requests for Usuario entities
 * @author Heriberto Galdamez
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    /**
     * Spring MVC controller that handles CRUD requests for Usuario entities
     */
    public UsuarioController() {
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
     * Create a new Usuario entity
     * @return
     */
    @RequestMapping(value="nuevo")
    public ModelAndView newUsuario() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void guardarInformacionUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void borrarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void actualizarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarUsuarioPorEmail() {
        // TODO implement here
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
     */
    public void mostrarPantallaAdministrarUsuario() {
        // TODO implement here
    }

    /**
     * @return
     */
    public MngAdminUsuario createMngAdminUsuario() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void mostrarPantallaRegistrarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarEditarUsuario() {
        // TODO implement here
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