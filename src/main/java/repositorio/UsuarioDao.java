package repositorio;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.*;


/**
 * DAO to manage Usuario entities.
 * @author Heriberto Galdamez
 */
@Repository
public class UsuarioDao {

	private static final Logger log = Logger.getLogger(UsuarioDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    /**
     * DAO to manage Usuario entities.
     */
    public UsuarioDao() {
    	
    }

    /**
     * Obtiene toda la lista de usuarios
     * @return lista de usuarios
     */
	@SuppressWarnings("unchecked")
    public List<Usuario> buscarTodos() {
    		//String queryString = "from Usuario";
			//Query queryObject = getCurrentSession().createQuery(queryString);
		return  getCurrentSession().createCriteria(Usuario.class)
				.setFetchMode("menuRols", FetchMode.JOIN)
				.list();
		
    }

    /**
     * Realiza la busqueda de usuarios con paginacion
     * @param pageNumber numero de pagina
     * @param pageSize  tamanio de pagina
     * @return lista de usuarios
     */
    @SuppressWarnings("unchecked")
	public List<Usuario> buscarTodos(int pageNumber, int pageSize) {
		/*String queryString = "from Usuario";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		*/
    	return getCurrentSession().createCriteria(Usuario.class)
    	.setFetchMode("menuRols", FetchMode.JOIN)
    	.setFirstResult((pageNumber - 1) * pageSize)
    	.setMaxResults(pageSize).list();
    }

    /**
     * Realiza la busqueda de un usuario por correo electronico
     * @param email correo electronico
     * @return Usuario correspondiente al correo electronico
     */
    public Usuario buscarUsuarioPorEmail(String email) {
    	/*String queryString = "from Usuario u WHERE u.correoEletronico = :email ";
		Query queryObject = getCurrentSession().createQuery(queryString)
				.setString("email",email);
		return  (Usuario)queryObject.uniqueResult();
        */
    	return (Usuario)getCurrentSession().createCriteria(Usuario.class)
    			.add(Restrictions.eq("correoEletronico",email))
    			.setFetchMode("menuRols", FetchMode.JOIN)
    			.uniqueResult();
    }

    /**
     * Guarda un usuario 
     * @param usuario a guardar
     * @return usuario persistido
     */
    public Usuario insertarUsuario(Usuario usuario) {
    	log.debug("Guardando instancia  Usuario ");
    		getCurrentSession().save(usuario);
		log.debug("Usuario Guardado exitosamente");
		
		return usuario;
    }

    /**
     * Actualiza la informacion de un usuario
     * @param usuario a actualizar
     * @return usuario actualizado
     */
    public boolean actualizarUsuario(Usuario usuario) {
    	getCurrentSession().update(usuario);
        return true;
    }

    /**
     * Borra la informacion de un usuario
     * @param usuario a borrar
     * @return boolean resultado de la eliminacion del usuario
     */
    public boolean borrarUsuario(Usuario usuario) {
    	boolean resultado=false;
    	try{
    	getCurrentSession().delete(usuario);
    	resultado=true;
    	}
    	catch(HibernateException hbex){
    		log.warn(hbex.getMessage());
    	}
        return resultado;
    }

    /**
     * @param usuario 
     * @return
     */
    public Usuario autenticarUsuario(Usuario usuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param idUsuario 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<Usuario> buscarEquipoResponsable(int idUsuario) {
    	/*String queryString = "from Usuario u WHERE u.idUsuario = :idUsuario ";
		Query queryObject = getCurrentSession().createQuery(queryString)
				.setInteger("idUsuario",idUsuario);
        return queryObject.list();*/
    	return getCurrentSession().createCriteria(Usuario.class)
    			.add(Restrictions.eq("idUsuario",idUsuario))
    			.setFetchMode("menuRols", FetchMode.JOIN)
    			.setFetchMode("equipoComputosForIdUsuarioAsignado", FetchMode.JOIN)
    			.list();
    }

}