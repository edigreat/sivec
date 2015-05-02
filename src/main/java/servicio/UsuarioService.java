/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: UsuarioService.java
 * Autor: heriberto
 */
package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dominio.Usuario;
import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCrearUsuario;
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

	/**
     * Spring service that handles CRUD requests for Usuario entities
     */
    public UsuarioService() {
    }

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
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearUsuario 
     * @return
     */
    public MngCrearUsuario insertarUsuario(MngCrearUsuario mngCrearUsuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param email 
     * @return
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        // TODO implement here
        return null;
    }

    /**
     * @param usuario 
     * @return
     */
    public Usuario actualizarUsuario(Usuario usuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param usuario 
     * @return
     */
    public boolean borrarUsuario(Usuario usuario) {
        // TODO implement here
        return false;
    }

    /**
     * @param idUsuario 
     * @return
     */
    public List<Usuario> buscarEquipoPorResponable(int idUsuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearUsuario 
     * @return
     */
    public MngCrearUsuario iniciarCrearUsuario(MngCrearUsuario mngCrearUsuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param mngCrearUsuario 
     * @return
     */
    public MngCrearUsuario iniciarEditarUsuario(MngCrearUsuario mngCrearUsuario) {
        // TODO implement here
        return null;
    }
}
