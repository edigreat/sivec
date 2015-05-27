/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoComputoService.java
 * Autor: heriberto
 */
package servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import presentacion.manager.MngAdminEquipo;
import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCaracteristicaEquipo;
import presentacion.manager.MngCrearEquipoForm;
import presentacion.manager.MngCrearReparacionForm;
import dominio.EquipoComputo;
import dominio.EquipoValorCarac;
import repositorio.EquipoComputoDao;
import repositorio.EquipoValorCaracDao;
import repositorio.ReparacionEquipoDao;
import repositorio.UsuarioDao;
import static servicio.UsuarioService.isInteger;
import static presentacion.manager.ConstantesPresentacion.*;
/**
 * Servicio de spring que maneja las peticiones
 * para las entidades de equipo de computo
 * @author heriberto
 *
 */
@Service
@Transactional
public class EquipoComputoService {
	 
	private static final Logger log = Logger.getLogger(EquipoComputoService.class);

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

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private EquipoValorCaracDao equipoValorCaracDao;

    
    /**
     * Buscar todos los equipos  por tipo
     * 
     * @param startResult pagina inicial 
     * @param maxRows tamanio de pagina 
     * @return lista de equipo de acuerdo a su tipo
     */
    public MngAdminEquipo buscarTodos(String equipoComputo) {
    		log.debug("Buscando usuarios con correo equipoComputo : ["+equipoComputo.trim());
    		MngAdminEquipo mngAdminEquipo = new MngAdminEquipo(); 
    		mngAdminEquipo.setFirstPageNumber(0);
    		mngAdminEquipo.setLastPageNumber(0);
    		mngAdminEquipo.setEquipoComputoList(equipoComputoDao.buscarTodos(equipoComputo));
        return mngAdminEquipo;
    }
    /**
     * Busca todos los equipos de computo registrados
     * @param startResult pagina de inicio  
     * @param maxRows tamanio de la pagina
     * @return lista de equipos
     */
    public MngAdminEquipo buscarTodos(String startResultString, int maxRows) {
    	log.debug("Buscando equipos de la pagina : ["+startResultString.trim()+"] "+isInteger(startResultString.trim()));

    	MngAdminEquipo mngAdminEquipo = new MngAdminEquipo(); 
        Long numTotalEquipos = equipoComputoDao.obtenerTotalRegistrosEquipoComputo();
        mngAdminEquipo.setNumTotalEquipos(numTotalEquipos.intValue());
        int startResult=0;
        if(isInteger(startResultString)){
        	startResult = Integer.parseInt(startResultString);
        
        }

        if(numTotalEquipos > 0){
        	mngAdminEquipo.setLastPageNumber( (int)
        			(mngAdminEquipo.getNumTotalEquipos()/maxRows)+1)
        			;
        	mngAdminEquipo.setFirstPageNumber(0);
        	mngAdminEquipo.setEquipoComputoList(equipoComputoDao.buscarTodos(startResult, maxRows));
        }
        return mngAdminEquipo;
    }

    /**
     * Registra un equipo de computo
     * @param MngCrearEquipoForm manager de la pantalla de registro
     * @return manager de la pantalla de registro con el equipo registrado
     */
    @SuppressWarnings("unchecked")
	public MngCrearEquipoForm insertarEquipo( MngCrearEquipoForm mngCrearEquipoForm) {
    	int idUsuarioResponsable = Integer.parseInt(mngCrearEquipoForm.getUsuarioResponsableTag().trim());
    	mngCrearEquipoForm.getEquipoComputo().setUsuarioByIdUsuarioResponsable(usuarioDao.autenticarUsuario(idUsuarioResponsable));
    	mngCrearEquipoForm.getEquipoComputo().setIndVigenciaEquipo(0);
    	mngCrearEquipoForm.getEquipoComputo().setEstadoEquipo(EQUIPO_REGISTRADO);
    	equipoComputoDao.insertarEquipoComputo(mngCrearEquipoForm.getEquipoComputo());

    	for(MngCaracteristicaEquipo mngCaracteristicaEquipo:mngCrearEquipoForm.getMngCaracteristicaEquipoList()){
    		if(mngCaracteristicaEquipo.getDescripcionCaract()!=null&&
    				!mngCaracteristicaEquipo.getDescripcionCaract().isEmpty() &&
    				mngCaracteristicaEquipo.getValorCaract()!=null &&
    				!mngCaracteristicaEquipo.getValorCaract().isEmpty())
    		{
    			EquipoValorCarac equipoValorCarac = new EquipoValorCarac(
						mngCrearEquipoForm.getEquipoComputo(),
						mngCaracteristicaEquipo.getDescripcionCaract(),
						mngCaracteristicaEquipo.getValorCaract());
    		mngCrearEquipoForm.getEquipoComputo().getEquipoValorCaracs().add(equipoValorCarac);
    		log.debug(mngCaracteristicaEquipo);
        	equipoValorCaracDao.insertarEquipoValorCarac(equipoValorCarac);

    		}
        }
    	
        return mngCrearEquipoForm;
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
    public MngCrearEquipoForm actualizarEquipo(MngCrearEquipoForm mngCrearEquipoForm) {
    	EquipoComputo currentEquipoComputo  = new EquipoComputo();
    	currentEquipoComputo.setIdEquipoComputo(mngCrearEquipoForm.getEquipoComputo().getIdEquipoComputo());
    	EquipoComputo equipoComputo = equipoComputoDao.buscarEquipoComputoPorId(currentEquipoComputo);
    	
    	int idUsuarioResponsable = Integer.parseInt(mngCrearEquipoForm.getUsuarioResponsableTag().trim());
    	equipoComputo.setUsuarioByIdUsuarioResponsable(usuarioDao.autenticarUsuario(idUsuarioResponsable));
    	if(mngCrearEquipoForm.getUsuarioAsignadoTag()!=null && 
    			!mngCrearEquipoForm.getUsuarioAsignadoTag().isEmpty())
    	{
        	int idUsuarioAsignado = Integer.parseInt(mngCrearEquipoForm.getUsuarioAsignadoTag().trim());
        	equipoComputo.setUsuarioByIdUsuarioAsignado(usuarioDao.autenticarUsuario(idUsuarioAsignado));

    	}
    	else{
    		equipoComputo.setUsuarioByIdUsuarioAsignado(null);
    	}
    	
    	
    	equipoComputo.setDescTipoEquipo(mngCrearEquipoForm.getEquipoComputo().getDescTipoEquipo());
    	equipoComputo.setMarcaComputo(mngCrearEquipoForm.getEquipoComputo().getMarcaComputo());
    	equipoComputo.setModeloComputo(mngCrearEquipoForm.getEquipoComputo().getModeloComputo());
    	equipoComputo.setUbicacion(mngCrearEquipoForm.getEquipoComputo().getUbicacion());
    	equipoComputo.setEstadoEquipo(mngCrearEquipoForm.getEquipoComputo().getEstadoEquipo());

    	equipoComputo.getEquipoValorCaracs().clear();
    	boolean hasSuccess=equipoValorCaracDao.eliminarCaracteristiscaPorIdEquipo(currentEquipoComputo.getIdEquipoComputo());
    	equipoComputo = equipoComputoDao.actualizarEquipoComputo(equipoComputo);

    	for(MngCaracteristicaEquipo mngCaracteristicaEquipo:mngCrearEquipoForm.getMngCaracteristicaEquipoList()){
    		if(mngCaracteristicaEquipo.getDescripcionCaract()!=null&&
    				!mngCaracteristicaEquipo.getDescripcionCaract().isEmpty() &&
    				mngCaracteristicaEquipo.getValorCaract()!=null &&
    				!mngCaracteristicaEquipo.getValorCaract().isEmpty())
    		{
    			EquipoValorCarac equipoValorCarac = new EquipoValorCarac(
    					equipoComputo,
						mngCaracteristicaEquipo.getDescripcionCaract(),
						mngCaracteristicaEquipo.getValorCaract());
    					equipoComputo.getEquipoValorCaracs().add(equipoValorCarac);
    		log.debug(mngCaracteristicaEquipo);
        	equipoValorCaracDao.insertarEquipoValorCarac(equipoValorCarac);

    		}
        }
    	
    	return mngCrearEquipoForm;

    }

    /**
     * Elimina un equipo de computo
     * @param equipo de computo a borrar
     * @return boolean si el borrado tuvo exito
     */
    public boolean borrarEquipo(String idEquipoComputoString) {
    	int idEquipoComputo=0;
    	if(isInteger(idEquipoComputoString)){
    		idEquipoComputo = Integer.parseInt(idEquipoComputoString);
        
        }
    	EquipoComputo equipoComputo = new EquipoComputo();
    	equipoComputo.setIdEquipoComputo(idEquipoComputo);
    	EquipoComputo currentEquipoComputo = equipoComputoDao.buscarEquipoComputoPorId(equipoComputo);
    	boolean hasSuccess = equipoComputoDao.borrarEquipoComputo(currentEquipoComputo);
        return hasSuccess;
    }

    /**
     * Obtiene lo necesario para presentar la pantalla de
     * registrar equipo de computo
     * @param MngCrearEquipoForm manager de la pantalla registrar equipo
     * @return manager con la informacion necesaria para registrar un  equipo
     */
	public MngCrearEquipoForm iniciarCrearEquipoComputo(MngCrearEquipoForm mngCrearEquipo ) {
    	//mngCrearEquipo.setEquipoComputo(new EquipoComputo());
    	
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
     * @param MngCrearEquipoForm manager de la pantalla editar equipo
     * @return manager con la informacion necesaria para editar un  equipo
     */
    public MngCrearEquipoForm iniciarEditarEquipo(String idEquipoComputoString, MngCrearEquipoForm mngCrearEquipoForm) {
    	int idEquipoComputo=0;
    	if(isInteger(idEquipoComputoString)){
    		idEquipoComputo = Integer.parseInt(idEquipoComputoString);
        
        }
    	EquipoComputo equipoComputo =  new EquipoComputo();
    	equipoComputo.setIdEquipoComputo(idEquipoComputo);
    	equipoComputo = equipoComputoDao.buscarEquipoComputoPorId(equipoComputo);
    	mngCrearEquipoForm.setEquipoComputo(equipoComputo);
    	for(Object equipoValorCaracObj: equipoComputo.getEquipoValorCaracs()){
    		EquipoValorCarac equipoValorCarac = (EquipoValorCarac)equipoValorCaracObj;
    		log.info(equipoValorCarac);
    		MngCaracteristicaEquipo mngCaracteristicaEquipo = new MngCaracteristicaEquipo();
    		mngCaracteristicaEquipo.setDescripcionCaract(equipoValorCarac.getDescripcionCaract());
    		mngCaracteristicaEquipo.setValorCaract(equipoValorCarac.getValorCaract());
    		mngCrearEquipoForm.getMngCaracteristicaEquipoList().add(mngCaracteristicaEquipo);
    	}
    	for(int i=0;i<(MAX_ROWS-equipoComputo.getEquipoValorCaracs().size());i++){
    		mngCrearEquipoForm.getMngCaracteristicaEquipoList().add(new MngCaracteristicaEquipo());
    	}
    	if(equipoComputo.getUsuarioByIdUsuarioAsignado()!=null)
    	{
    		mngCrearEquipoForm.getUsuarioAsignado().setId(equipoComputo.getUsuarioByIdUsuarioAsignado().getIdUsuario()+"");
    		mngCrearEquipoForm.getUsuarioAsignado().setTagName(equipoComputo.getUsuarioByIdUsuarioAsignado().getNombreCompleto()+"");
        	mngCrearEquipoForm.setUsuarioAsignadoTag(equipoComputo.getUsuarioByIdUsuarioAsignado().getIdUsuario()+"");;

    	}
    	mngCrearEquipoForm.getUsuarioResponsable().setId(equipoComputo.getUsuarioByIdUsuarioResponsable().getIdUsuario()+"");
    	mngCrearEquipoForm.getUsuarioResponsable().setTagName(equipoComputo.getUsuarioByIdUsuarioResponsable().getNombreCompleto()+"");
    	mngCrearEquipoForm.setUsuarioResponsableTag(equipoComputo.getUsuarioByIdUsuarioResponsable().getIdUsuario()+"");;
        return mngCrearEquipoForm;
    }

  
}
