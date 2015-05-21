/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: UsuarioService.java
 * Autor: heriberto
 */
package servicio;

import integration.servicio.UsuarioServiceIntegrationTestCase;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dominio.MenuRol;
import dominio.Usuario;
import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCrearUsuario;
import repositorio.DependenciaUniDao;
import repositorio.EquipoComputoDao;
import repositorio.MenuRolDao;
import repositorio.ReparacionEquipoDao;
import repositorio.UsuarioDao;

/**
 * @author heriberto
 *
 */
@Transactional
@Service
public class UsuarioService {

	
	private static final Logger log = Logger.getLogger(UsuarioService.class);

	/**
     * Spring service that handles CRUD requests for Usuario entities
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

    /**
     * JPQL Query - findAllUsuarios
     * @param startResult 
     * @param maxRows 
     * @return
     */
    public MngAdminUsuario buscarTodos(int startResult, int maxRows) {
        MngAdminUsuario mngAdminUsuario = new MngAdminUsuario(); 
        mngAdminUsuario.setUsuarioList(usuarioDao.buscarTodos(startResult, maxRows));
        return mngAdminUsuario;
    }

    /**
     * @param mngCrearUsuario 
     * @return
     */
    public MngCrearUsuario insertarUsuario(MngCrearUsuario mngCrearUsuario) {
    	log.debug("---> insertarUsuario "+mngCrearUsuario.getMenuRolSeleccionado());
    	MenuRol menuRol = menuRolDao.buscarMenuRolPorId(mngCrearUsuario.getMenuRolSeleccionado());
    	log.debug("MenuRol asignado :" + menuRol);
    	mngCrearUsuario.getUsuario().addMenuRol(menuRol);
    	mngCrearUsuario.getUsuario().setIndVigenciaUsuario(1);
    	log.debug(mngCrearUsuario);
    	mngCrearUsuario.setUsuario(usuarioDao.insertarUsuario(mngCrearUsuario.getUsuario()));
    	log.debug("<--- insertarUsuario");

    	return mngCrearUsuario;
    }

    /**
     * @param email 
     * @return
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioDao.buscarUsuarioPorEmail(email);
    }

    /**
     * @param usuario 
     * @return
     */
    public boolean actualizarUsuario(MngCrearUsuario mngEditarUsuarioInstance) {
    	log.debug("---> actualizarUsuario " + mngEditarUsuarioInstance.getMenuRolSeleccionado());
    	Usuario usuarioUpdate = usuarioDao.autenticarUsuario(mngEditarUsuarioInstance.getUsuario().getIdUsuario());
    	MenuRol menuRol = menuRolDao.buscarMenuRolPorId(mngEditarUsuarioInstance.getMenuRolSeleccionado());
    	usuarioUpdate.getMenuRols().clear();
    	usuarioUpdate.addMenuRol(menuRol);
    	usuarioUpdate.setNombre(mngEditarUsuarioInstance.getUsuario().getNombre());
    	usuarioUpdate.setApMaterno(mngEditarUsuarioInstance.getUsuario().getApMaterno());
    	usuarioUpdate.setApPaterno(mngEditarUsuarioInstance.getUsuario().getApPaterno());
    	usuarioUpdate.setCorreoEletronico(mngEditarUsuarioInstance.getUsuario().getCorreoEletronico());
    	usuarioUpdate.setPassword(mngEditarUsuarioInstance.getUsuario().getPassword());
    	usuarioUpdate.setDependenciaUniversitaria(mngEditarUsuarioInstance.getUsuario().getDependenciaUniversitaria());
    	boolean res= usuarioDao.actualizarUsuario(usuarioUpdate);
        return res;
    }

    /**
     * @param usuario 
     * @return
     */
    public boolean borrarUsuario(Usuario usuario) {
        return  usuarioDao.borrarUsuario(usuario);
    }

    /**
     * @param idUsuario 
     * @return
     */
    public List<Usuario> buscarEquipoPorResponable(int idUsuario) {
        return usuarioDao.buscarEquipoResponsable(idUsuario);
    }

    /**
     * @param mngCrearUsuario 
     * @return
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
     * @param mngCrearUsuario 
     * @return
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
}
