/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: ReparacionEquipoService.java
 * Autor: heriberto
 */
package servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import presentacion.manager.MngCrearReparacion;
import presentacion.manager.MngCrearReporte;
import repositorio.EquipoComputoDao;
import repositorio.ReparacionEquipoDao;

/**
 * @author heriberto
 *
 */
@Transactional
@Service
public class ReparacionEquipoService {
	 /**
     * 
     */
    public ReparacionEquipoService() {
    }

    /**
     * DAO inyectado por Spring que maneja las entidades EquipoComputo
     */
    @Autowired
    private EquipoComputoDao equipoComputoDao;

    /**
     * DAO inyectado por Spring que maneja las entidades reparacionEquipo
     */
    @Autowired
    private ReparacionEquipoDao reparacionEquipoDao;

    /**
     * @param mngCrearReparacion 
     * @return
     */
    public MngCrearReparacion iniciarRegistrarReparacion(MngCrearReparacion mngCrearReparacion) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearReparacion 
     * @return
     */
    public MngCrearReparacion insertarReparacionEquipo(MngCrearReparacion mngCrearReparacion) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearReporte 
     * @return
     */
    public MngCrearReporte iniciarReporteMovimiento(MngCrearReporte mngCrearReporte) {
        // TODO implement here
        return null;
    }

}
