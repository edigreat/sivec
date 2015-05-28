package presentacion.controlador;

import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;

import java.io.Serializable;
import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import presentacion.manager.MngCrearReporte;
import dominio.ReparacionEquipo;
import servicio.EquipoComputoService;
import servicio.ReparacionEquipoService;

/**
 * @author Heriberto Galdamez
 */
@Controller("reporteController")
@RequestMapping("/reporte")
public class ReporteController implements Serializable {

    /**
	 * UID a utilizar
	 */
	private static final long serialVersionUID = -8738930388599013542L;

	/**
	 * Log a utilizar
	 */
	private static final Logger log = Logger.getLogger(ReporteController.class);
	/**
     * Constructur publico
     */
    public ReporteController() {
    }

    /**
     * Servicio inyectado por spring que provee las operaciones para a entidad Equipo de computo
     */
    @Autowired
    private EquipoComputoService equipoComputoService;
    
    @Autowired
    private ReparacionEquipoService reparacionEquipoService;
    /**
     * Buscar a todos los movimientos por id de equipo
     * @param idComputoString id del equipo a buscar
     * @return lista con los movimientos
     */
    @RequestMapping("/buscarmovimientoporid")
    public ModelAndView buscarMovimientosPorEquipo(@RequestParam("idComputoString")String idComputoString) {
    	return new ModelAndView("adminmovimiento","mngCrearReporte",
    			reparacionEquipoService.buscarReparacionPorEquipo(idComputoString));
    }
    
    /**
     * Consulta de movimientos inicial
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView mostrarPantallaAdministrarUsuario() {
     	log.debug("Entrando a mostrarPantallaAdministrarUsuario ");
     	return new ModelAndView("adminmovimiento","mngCrearReporte",reparacionEquipoService.buscarTodos("0",MAX_ROWS));
     }
    
    /**
     * Consulta de movimientos paginado
     * @param startResult pagina inicial
     * @return
     */
    @RequestMapping("/list/{startResult}")
    public ModelAndView mostrarPantallaAdministrarUsuarioPagina(@PathVariable("startResult") String startResult) {
    	return new ModelAndView("adminmovimiento","mngCrearReporte",reparacionEquipoService.buscarTodos());

    }
    

    /**
     * 
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
	public ModelAndView generarReporteExcel() {
    	MngCrearReporte mngCrearReporte = reparacionEquipoService.buscarTodos();
    	System.out.println(mngCrearReporte.getReparacionEquipoList());
		return new ModelAndView("reporteExcel", "reparacionEquipoList",mngCrearReporte.getReparacionEquipoList());
	}

   
    /**
     * 
     */
    public void mostrarGenerarReportePorEquipo() {
        // TODO implement here
    }

}