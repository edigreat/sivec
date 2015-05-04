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
 * Servicio de spring que maneja las peticiones
 * para las entidades de reparacion de equipos  de computo
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
     * Obtiene lo necesario para presentar la pantalla de
     * registrar reparacion  de un equipo de computo
     * @param MngCrearReparacion manager de la pantalla crear reperacion de equipo
     * @return manager con la informacion necesaria para registrar la reparacion de
     *  un  equipo
     */
    public MngCrearReparacion iniciarRegistrarReparacion(MngCrearReparacion mngCrearReparacion) {
    	mngCrearReparacion.setEquipoComputo(
    			equipoComputoDao.buscarEquipoComputoPorId
    			(mngCrearReparacion.getEquipoComputo()));
    	return mngCrearReparacion;
    }

    /**
     * @param mngCrearReparacion 
     * @return
     */
    public MngCrearReparacion insertarReparacionEquipo(MngCrearReparacion mngCrearReparacion) {
    	reparacionEquipoDao.insertarReparacionEquipo(mngCrearReparacion.getReparacionEquipo());
        return mngCrearReparacion;
    }

    /**
     * @param mngCrearReporte 
     * @return
     */
    public MngCrearReporte iniciarReporteMovimiento(MngCrearReporte mngCrearReporte) {
    	mngCrearReporte.setReparacionEquipoList(reparacionEquipoDao.buscarTodos(0, 10));
        return mngCrearReporte;
    }

}
