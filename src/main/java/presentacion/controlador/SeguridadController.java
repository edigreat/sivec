package presentacion.controlador;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import presentacion.manager.MngSeguridad;
import servicio.SeguridadService;

/**
 * @author Heriberto Galdamez
 */
@Controller
@RequestMapping("/seguridad")

public class SeguridadController {

    /**
     * 
     */
    public SeguridadController() {
    }

    /**
     * 
     */
    public SeguridadService seguridadService;

    /**
     * 
     */
    public void autenticarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarFormaLogin() {
        // TODO implement here
    }

    /**
     * 
     */
    public void newUsuario() {
        // TODO implement here
    }

    /**
     * @return
     */
    public MngSeguridad crearMngAutenticarUsuario() {
        // TODO implement here
        return null;
    }

}