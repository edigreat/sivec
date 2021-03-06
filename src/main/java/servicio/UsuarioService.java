/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: UsuarioService.java
 * Autor: heriberto
 */
package servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dominio.MenuRol;
import dominio.Usuario;
import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCrearUsuario;
import presentacion.manager.TagAutoCompleteUsuario;
import repositorio.DependenciaUniDao;
import repositorio.EquipoComputoDao;
import repositorio.MenuItemDao;
import repositorio.MenuRolDao;
import repositorio.ReparacionEquipoDao;
import repositorio.UsuarioDao;
import static presentacion.manager.ConstantesPresentacion.MAX_ROWS;
/**
 * @author heriberto
 *
 */
@Service
@Transactional
public class UsuarioService {

	/**
	 * Logger a utilizar
	 */
	private static final Logger log = Logger.getLogger(UsuarioService.class);

	/**
	 * Constructor por defecto
	 */
    public UsuarioService() {
    }

    
    /**
     * DAO inyectado por Spring que maneja las entidades DependenciaUniversitaria 
     */
    @Autowired
    private DependenciaUniDao dependenciaUniDao;
    /**
     * DAO inyectado por Spring que maneja las entidades Equipocomputo 
     */
    @Autowired
    private EquipoComputoDao equipoComputoDao;

    /**
     * DAO inyectado por Spring que maneja las entidades Menurol 
     */
    @Autowired
    private MenuRolDao menuRolDao;

    /**
     * DAO inyectado por Spring que maneja las entidades Reparacionequipo 
     */
    @Autowired
    private ReparacionEquipoDao reparacionEquipoDao;

    /**
     *DAO inyectado por Spring que maneja las entidades Usuario 
     */
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    @Autowired
    private MenuItemDao menuItemDao;

    /**
     * Buscar todos los usuarios, paginado
     * 
     * @param startResult pagina inicial 
     * @param maxRows tamanio de pagina 
     * @return lista de usuarios de acuerdo a la pagina
     */
    public MngAdminUsuario buscarTodos(String startResultString, int maxRows) {
    	log.debug("Buscando usuarios de la pagina : ["+startResultString.trim()+"] "+isInteger(startResultString.trim()));

        MngAdminUsuario mngAdminUsuario = new MngAdminUsuario(); 
        Long numTotalUsuarios = usuarioDao.obtenerTotalRegistrosUsuario();
        mngAdminUsuario.setNumTotalUsuarios(numTotalUsuarios.intValue());
        int startResult=0;
        if(isInteger(startResultString)){
        	startResult = Integer.parseInt(startResultString);
        
        }

        if(numTotalUsuarios > 0){
        	mngAdminUsuario.setLastPageNumber( (int)
        			(mngAdminUsuario.getNumTotalUsuarios()/maxRows)+1)
        			;
        	mngAdminUsuario.setFirstPageNumber(0);
        	List<Usuario> usuarioList = usuarioDao.buscarTodos(startResult, maxRows);
        	if(usuarioList==null || usuarioList.isEmpty()){
        		mngAdminUsuario.setHasError(true);
        		mngAdminUsuario.setDescripcionError("No existe en informacion");
        	}
        	else{
            	mngAdminUsuario.setUsuarioList(usuarioDao.buscarTodos(startResult, maxRows));
        	}
        }
        return mngAdminUsuario;
    }
    
    /**
     * Buscar todos los usuarios por correo electronico
     * 
     * @param startResult pagina inicial 
     * @param maxRows tamanio de pagina 
     * @return lista de usuarios de acuerdo a la pagina
     */
    public MngAdminUsuario buscarTodos(String correoElectronico) {
    		log.debug("Buscando usuarios con correo electronico : ["+correoElectronico.trim());
        	MngAdminUsuario mngAdminUsuario = new MngAdminUsuario(); 
        	mngAdminUsuario.setFirstPageNumber(0);
        	mngAdminUsuario.setLastPageNumber(0);
        	List<Usuario> usuarioList = usuarioDao.buscarTodos(correoElectronico);
        	if(usuarioList==null || usuarioList.isEmpty()){
        		mngAdminUsuario.setHasError(true);
        		mngAdminUsuario.setDescripcionError("No existe en informacion");
        	}
        	else{
        		mngAdminUsuario.setUsuarioList(usuarioDao.buscarTodos(correoElectronico));
        	}
        return mngAdminUsuario;
    }
    
    /**
     * Buscar todos los usuarios por correo electronico
     * 
     * @param startResult pagina inicial 
     * @param maxRows tamanio de pagina 
     * @return lista de usuarios de acuerdo a la pagina
     */
    public List<TagAutoCompleteUsuario> buscarTodosPorApPaterno(String apPaterno) {
    		log.debug("Buscando usuarios con correo apPaterno : ["+apPaterno.trim());
    		List<TagAutoCompleteUsuario> tagAutoCompleteUsuarioList = new ArrayList<TagAutoCompleteUsuario>();
    		List<Usuario> usuarioList = usuarioDao.buscarTodosPorApPaterno(apPaterno);
        	for(Usuario usuario:usuarioList){
        		tagAutoCompleteUsuarioList.add(new TagAutoCompleteUsuario(usuario.getIdUsuario()+"",
        				usuario.getNombreCompleto()) );
        	}
        return tagAutoCompleteUsuarioList;
    }
    
    /**
     * Inserta un nuevo usuario
     * @param mngCrearUsuario contiene la informacion para insertar un nuevo usuario
     * @return MngCrearUsuario instancia con la informacion de la bd ya insertada
     */
    public MngCrearUsuario insertarUsuario(MngCrearUsuario mngCrearUsuario) {
    	log.debug("---> insertarUsuario "+mngCrearUsuario.getMenuRolSeleccionado());
    	MenuRol menuRol = menuRolDao.buscarMenuRolPorId(mngCrearUsuario.getMenuRolSeleccionado());
    	log.debug("MenuRol asignado :" + menuRol);
    	mngCrearUsuario.getUsuario().setMenuRol(menuRol);
    	mngCrearUsuario.getUsuario().setIndVigenciaUsuario(1);
    	log.debug(mngCrearUsuario);
    	Usuario usuario = null;
    	usuario = usuarioDao.buscarUsuarioPorEmail(mngCrearUsuario.getUsuario().getCorreoEletronico());
    	if(usuario!=null)
    	{
    		mngCrearUsuario.setHasError(true);
    		mngCrearUsuario.setDescripcionError("La dirección de correo electronico ya existe");
    	
    	}
    	else{
	    	try{
	    		usuario = usuarioDao.insertarUsuario(mngCrearUsuario.getUsuario());
	    		mngCrearUsuario.setUsuario(usuario);
	    	}
	    	catch(ConstraintViolationException e){
	    		log.warn("Error al insertar " + e.getMessage());
	    		mngCrearUsuario.setHasError(true);
	    		mngCrearUsuario.setDescripcionError("La dirección de correo electronico ya existe");

	    	}
    	}
    	
    	log.debug("<--- insertarUsuario");

    	return mngCrearUsuario;
    }

    /**
     * Buscar a un usuario por su id
     * @param email 
     * @return resultado del usuario buscado
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioDao.buscarUsuarioPorEmail(email);
    }

    /**
     * Actualiza la informacion de un usuairo
     * @param MngCrearUsuario instancia que contiene la informacion del usuario 
     * 	a actualizar 
     * @return boolean indicador de si tuvo exito o un error de la actualizacion
     */
    public boolean actualizarUsuario(MngCrearUsuario mngEditarUsuarioInstance) {
    	log.debug("---> actualizarUsuario " + mngEditarUsuarioInstance.getMenuRolSeleccionado());
    	boolean  res = false;
    	
    	Usuario usuarioUpdate = usuarioDao.autenticarUsuario(mngEditarUsuarioInstance.getUsuario().getIdUsuario());
    	MenuRol menuRol = menuRolDao.buscarMenuRolPorId(mngEditarUsuarioInstance.getMenuRolSeleccionado());
    	usuarioUpdate.setMenuRol(menuRol);
    	usuarioUpdate.setNombre(mngEditarUsuarioInstance.getUsuario().getNombre());
    	usuarioUpdate.setApMaterno(mngEditarUsuarioInstance.getUsuario().getApMaterno());
    	usuarioUpdate.setApPaterno(mngEditarUsuarioInstance.getUsuario().getApPaterno());
    	usuarioUpdate.setCorreoEletronico(mngEditarUsuarioInstance.getUsuario().getCorreoEletronico());
    	usuarioUpdate.setPassword(mngEditarUsuarioInstance.getUsuario().getPassword());
    	usuarioUpdate.setDependenciaUniversitaria(mngEditarUsuarioInstance.getUsuario().getDependenciaUniversitaria());
    	res= usuarioDao.actualizarUsuario(usuarioUpdate);
    	
        return res;
    }

    /**
     * Borrar un usuario por el id
     * @param idUsuario id del usuario 
     * @return indicador de exito del borrado
     */
    public boolean borrarUsuario(String  idUsuario,MngCrearUsuario mngCrearUsuario) {
    	boolean isSuccessDelete=false;
    	if(isInteger(idUsuario)){
    		 int intIdUsuario=Integer.parseInt(idUsuario);
    		 Usuario usuario = usuarioDao.autenticarUsuario(intIdUsuario);
    		 log.debug("Usuario a borrar " + usuario);
    		 Long equipoComputoListAsig  = equipoComputoDao.obtenerTotalRegistrosEquipoComputoPorUsuarioAsignado(intIdUsuario);
    		 Long equipoComputoListResp  = equipoComputoDao.obtenerTotalRegistrosEquipoComputoPorUsuarioResponsable(intIdUsuario);
    		log.debug("asignado " + equipoComputoListAsig +" responsable "+equipoComputoListResp) ;
    		 if(equipoComputoListAsig > 0 && equipoComputoListResp > 0){
    		 	 isSuccessDelete = usuarioDao.borrarUsuario(usuario);
    		 }
    		 else{
    			 	mngCrearUsuario.setHasError(true);
    	    		mngCrearUsuario.setDescripcionError("El usuario es responsable de "+equipoComputoListResp 
    	    				+" equipos y  tiene "+equipoComputoListAsig+" asignados, no se puede borrar");
    		 }
    	}
    	
        return  isSuccessDelete;
    }
    /**
     * Utileria para conocer si una cadena es un 
     * numero
     * @param s cadena a validar
     * @return indicador si la cadena es numero regresa true
     */
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }

    /**
     * @param idUsuario 
     * @return
     */
    public List<Usuario> buscarEquipoPorResponable(int idUsuario) {
        return usuarioDao.buscarEquipoResponsable(idUsuario);
    }

    /**
     * Inicia los recursos para crear un usuario
     * @param mngCrearUsuario a inicializr con recursos
     * @return la misma instancia del parametro con recursos listos
     */
    public MngCrearUsuario iniciarCrearUsuario(MngCrearUsuario mngCrearUsuario) {
    	mngCrearUsuario.setDependenciaUniList(dependenciaUniDao.buscarTodos());
    	List<MenuRol>  menuRolList = menuRolDao.buscarTodos();
    	Map<Integer,String> menuRolMap = new HashMap<>();
    	for(MenuRol menuRol :menuRolList ){
    		menuRolMap.put(menuRol.getIdMenuRol(),menuRol.getDescripcionRol());
    	}
    	mngCrearUsuario.setMenuRol(menuRolMap);
        return mngCrearUsuario;
    }

    /**
     * Inicia los recursos para editar un usuario
     * @param mngCrearUsuario instancia a inicializar con recursos
     * @return misma instancia del parametro con recursos listos
     */
    public MngCrearUsuario iniciarEditarUsuario(MngCrearUsuario mngCrearUsuario,Integer idUsuario) {
    	
    	mngCrearUsuario.setUsuario(usuarioDao.autenticarUsuario(idUsuario));
    	List<MenuRol>  menuRolList = menuRolDao.buscarTodos();
    	Map<Integer,String> menuRolMap = new HashMap<>();
    	for(MenuRol menuRol :menuRolList ){
    		menuRolMap.put(menuRol.getIdMenuRol(),menuRol.getDescripcionRol());
    	}
    	mngCrearUsuario.setMenuRol(menuRolMap);
        return mngCrearUsuario;
    }
    
    public List<MenuRol> buscarListaMenuPorUsuario(String refRole){
    	return this.menuRolDao.buscarListaMenuPorUsuario(refRole);
    }
}
