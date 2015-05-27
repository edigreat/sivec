/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: ReparacionEquipoService.java
 * Autor: heriberto
 */
package servicio;

import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;
import static servicio.UsuarioService.isInteger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dominio.EquipoComputo;
import dominio.EquipoValorCarac;
import dominio.ReparacionEquipo;
import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCaracteristicaEquipo;
import presentacion.manager.MngCrearReparacionForm;
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
	
	private static final Logger log = Logger.getLogger(ReparacionEquipoService.class);
	 /**
     * Constructor publico
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
     * @param MngCrearReparacionForm manager de la pantalla crear reperacion de equipo
     * @return manager con la informacion necesaria para registrar la reparacion de
     *  un  equipo
     */
    public MngCrearReparacionForm iniciarRegistrarReparacion(String idEquipoComputoString) {
    	MngCrearReparacionForm mngCrearReparacionForm  = new MngCrearReparacionForm();
    	
    	int idEquipoComputo=0;
    	if(isInteger(idEquipoComputoString)){
    		idEquipoComputo = Integer.parseInt(idEquipoComputoString);
        
        }
    	EquipoComputo equipoComputo =  new EquipoComputo();
    	equipoComputo.setIdEquipoComputo(idEquipoComputo);
    	EquipoComputo currentEquipoComputo = equipoComputoDao.buscarEquipoComputoPorId(equipoComputo);
    	log.debug("Equipo de computo encontrado " + currentEquipoComputo);
    	mngCrearReparacionForm.setEquipoComputo(currentEquipoComputo);
    	log.debug("Equipo de computo encontrado " + currentEquipoComputo.getEquipoValorCaracs());

    	for(Object equipoValorCaracObj: currentEquipoComputo.getEquipoValorCaracs()){
    		EquipoValorCarac equipoValorCarac = (EquipoValorCarac)equipoValorCaracObj;
    		log.info(equipoValorCarac);
    		MngCaracteristicaEquipo mngCaracteristicaEquipo = new MngCaracteristicaEquipo();
    		mngCaracteristicaEquipo.setDescripcionCaract(equipoValorCarac.getDescripcionCaract());
    		mngCaracteristicaEquipo.setValorCaract(equipoValorCarac.getValorCaract());
    		mngCrearReparacionForm.getMngCaracteristicaEquipoList().add(mngCaracteristicaEquipo);
    	}
    	
    	if(currentEquipoComputo.getUsuarioByIdUsuarioAsignado()!=null)
    	{
    		mngCrearReparacionForm.getUsuarioAsignado().setId(currentEquipoComputo.getUsuarioByIdUsuarioAsignado().getIdUsuario()+"");
    		mngCrearReparacionForm.getUsuarioAsignado().setTagName(currentEquipoComputo.getUsuarioByIdUsuarioAsignado().getNombreCompleto()+"");

    	}
    	mngCrearReparacionForm.getUsuarioResponsable().setId(currentEquipoComputo.getUsuarioByIdUsuarioResponsable().getIdUsuario()+"");
    	mngCrearReparacionForm.getUsuarioResponsable().setTagName(currentEquipoComputo.getUsuarioByIdUsuarioResponsable().getNombreCompleto()+"");
    	return mngCrearReparacionForm;
    }

    /**
     * @param mngCrearReparacion 
     * @return
     */
    public MngCrearReparacionForm insertarReparacionEquipo(MngCrearReparacionForm mngCrearReparacionForm) {
    	ReparacionEquipo reparacionEquipo=mngCrearReparacionForm.getReparacionEquipo();
    	EquipoComputo currentEquipoComputo = equipoComputoDao.buscarEquipoComputoPorId(mngCrearReparacionForm.getEquipoComputo());
    	reparacionEquipo.setEquipoComputo(currentEquipoComputo);
    	reparacionEquipo.setIndVigenciaReparacion(0);
    	reparacionEquipo.setUsuarioByIdUsuarioAsignado(currentEquipoComputo.getUsuarioByIdUsuarioAsignado());
    	reparacionEquipo.setUsuarioByIdUsuarioResponsable(currentEquipoComputo.getUsuarioByIdUsuarioResponsable());
    	
    	reparacionEquipoDao.insertarReparacionEquipo(reparacionEquipo);
        return mngCrearReparacionForm;
    }

    /**
     * @param mngCrearReporte 
     * @return
     */
    public MngCrearReporte iniciarReporteMovimiento(MngCrearReporte mngCrearReporte) {
    	mngCrearReporte.setReparacionEquipoList(reparacionEquipoDao.buscarTodos(0, 10));
        return mngCrearReporte;
    }
    
    public MngCrearReporte buscarTodos(String startResultString, int maxRows) {
    	log.debug("Buscando usuarios de la pagina : ["+startResultString.trim()+"] "+isInteger(startResultString.trim()));

    	MngCrearReporte mngCrearReporte = new MngCrearReporte(); 
        Long numTotalRegistros = reparacionEquipoDao.obtenerTotalRegistrosUsuario();
        mngCrearReporte.setNumTotalRegistros(numTotalRegistros.intValue());
        int startResult=0;
        if(isInteger(startResultString)){
        	startResult = Integer.parseInt(startResultString);
        
        }

        if(numTotalRegistros > 0){
        	mngCrearReporte.setLastPageNumber( (int)
        			(mngCrearReporte.getNumTotalRegistros()/maxRows)+1)
        			;
        	mngCrearReporte.setFirstPageNumber(0);
        	mngCrearReporte.setReparacionEquipoList(reparacionEquipoDao.buscarTodos(startResult, maxRows));
        }
        return mngCrearReporte;
    
    }
    
    
    public MngCrearReporte buscarReparacionPorEquipo(String idEquipoComputoString) {
    	log.debug("Buscando usuarios de la pagina : ["+idEquipoComputoString.trim()+"] "+isInteger(idEquipoComputoString.trim()));

    	MngCrearReporte mngCrearReporte = new MngCrearReporte(); 
        int idEquipoComputo=0;
        if(isInteger(idEquipoComputoString)){
        	idEquipoComputo = Integer.parseInt(idEquipoComputoString);
        
        }
        	mngCrearReporte.setFirstPageNumber(0);
        	mngCrearReporte.setLastPageNumber(0); 
        	mngCrearReporte.setReparacionEquipoList(reparacionEquipoDao.buscarReparacionPorEquipo(idEquipoComputo));
        
        return mngCrearReporte;
    
    }

}
