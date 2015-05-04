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
import presentacion.manager.MngCrearReparacion;
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
     * Busca todos los equipos de computo registrados
     * @param startResult pagina de inicio  
     * @param maxRows tamanio de la pagina
     * @return lista de equipos
     */
    public List<EquipoComputo> buscarTodos(int startResult, int maxRows) {
        return equipoComputoDao.buscarTodos(startResult,maxRows);
    }

    /**
     * Registra un equipo de computo
     * @param MngCrearEquipo manager de la pantalla de registro
     * @return manager de la pantalla de registro con el equipo registrado
     */
    public MngCrearEquipo insertarEquipo( MngCrearEquipo mngCrearEquipo) {
    	mngCrearEquipo.setEquipoComputo(
    			equipoComputoDao.insertarEquipoComputo(
    					mngCrearEquipo.getEquipoComputo()
    					)
    			);
        return mngCrearEquipo;
    }

    /**
     * Buscar un equipo de computo por ID
     * @param equipo a buscar
     * @return Equipo de computo 
     */
    public EquipoComputo buscarEquipoPorID(EquipoComputo equipoComputo) {
        return equipoComputoDao.buscarEquipoComputoPorId(equipoComputo);
    }

    /**
     * Actualiza la informacion de un equipo de computo
     * @param equipo de computo a acutalizar
     * @return equipo de computo actualizado
     */
    public EquipoComputo actualizarEquipo(EquipoComputo equipoComputo) {
     return equipoComputoDao.actualizarEquipoComputo(equipoComputo);

    }

    /**
     * Elimina un equipo de computo
     * @param equipo de computo a borrar
     * @return boolean si el borrado tuvo exito
     */
    public boolean borrarEquipo(EquipoComputo equipoComputo) {
        return equipoComputoDao.borrarEquipoComputo(equipoComputo);
    }

    /**
     * Obtiene lo necesario para presentar la pantalla de
     * registrar equipo de computo
     * @param MngCrearEquipo manager de la pantalla registrar equipo
     * @return manager con la informacion necesaria para registrar un  equipo
     */
    public MngCrearEquipo iniciarCrearEquipoComputo(MngCrearEquipo mngCrearEquipo ) {
    	mngCrearEquipo.setTipoEquipoComputo(tipoEquipoComputoDao.buscarTodos());
    	return mngCrearEquipo;
    }

    /**
     * Obtiene lo necesario para presentar la pantalla de
     * administrar equipos de computo
     * @param MngAdminEquipo manager de la pantalla administrar equipos
     * @return manager con la informacion necesaria para administrar equipos
     */
    public MngAdminEquipo iniciarAdministrarEquipos(MngAdminEquipo mngAdminEquipo) {
    	mngAdminEquipo.setEquipoComputoList(equipoComputoDao.buscarTodos(0,10));
        return mngAdminEquipo;
    }

    /**
     * Obtiene lo necesario para presentar la pantalla de
     * edicion de un equipo de computo
     * @param MngCrearEquipo manager de la pantalla editar equipo
     * @return manager con la informacion necesaria para editar un  equipo
     */
    public MngCrearEquipo iniciarEditarEquipo(MngCrearEquipo mngCrearEquipo) {
    	mngCrearEquipo.setEquipoComputo(
    			equipoComputoDao.buscarEquipoComputoPorId(
    					mngCrearEquipo.getEquipoComputo()));
        return mngCrearEquipo;
    }

  
}
