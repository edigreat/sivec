/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoComputoService.java
 * Autor: heriberto
 */
package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import presentacion.manager.MngAdminEquipo;
import presentacion.manager.MngCrearEquipo;
import dominio.EquipoComputo;
import repositorio.EquipoComputoDao;
import repositorio.ReparacionEquipoDao;
import repositorio.TipoEquipoComputoDao;

/**
 * Servicio de spring que maneja las peticiones
 * para las entidades de equipo de computo
 * @author heriberto
 *
 */
@Transactional
@Service
public class EquipoComputoService {
	 
	public EquipoComputoService() {
    }

    /**
     * DAO inyectado por Spring que maneja las entidades Equipocomputo 
     */
    @Autowired
    private EquipoComputoDao equipoComputoDao;

    /**
     * DAO inyectado por Spring que maneja las entidades Reparacionequipo 
     */
    @Autowired
    private ReparacionEquipoDao reparacionEquipoDao;

    /**
     *DAO inyectado por Spring que maneja las entidades Tipoequipocomputo 
     */
    @Autowired
    private TipoEquipoComputoDao tipoEquipoComputoDao;

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    public List<EquipoComputo> buscarTodos(int startResult, int maxRows) {
        // TODO implement here
        return null;
    }

    /**
     * @param MngCrearEquipo 
     * @return
     */
    public MngCrearEquipo insertarEquipo( MngCrearEquipo mngCrearEquipo) {
        // TODO implement here
        return null;
    }

    /**
     * @param equipo 
     * @return
     */
    public EquipoComputo buscarEquipoPorID(EquipoComputo equipoComputo) {
        // TODO implement here
        return null;
    }

    /**
     * @param equipo 
     * @return
     */
    public EquipoComputo actualizarEquipo(EquipoComputo equipoComputo) {
        // TODO implement here
        return null;
    }

    /**
     * @param equipo 
     * @return
     */
    public boolean borrarEquipo(EquipoComputo equipoComputo) {
        // TODO implement here
        return false;
    }

    /**
     * @param MngCrearEquipo 
     * @return
     */
    public MngCrearEquipo iniciarCrearEquipoComputo(MngCrearEquipo mngCrearEquipo ) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngAdminEquipo 
     * @return
     */
    public MngCrearEquipo iniciarAdministrarEquipos(MngAdminEquipo mngAdminEquipo) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearEquipo 
     * @return
     */
    public MngCrearEquipo iniciarEditarEquipo(MngCrearEquipo mngCrearEquipo) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void iniciarCrearReparacion() {
        // TODO implement here
    }
}
