package repositorio;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dominio.*;


/**
 * DAO to manage Usuario entities.
 * @author Heriberto Galdamez
 */
@Repository
@Transactional
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
     * JPQL Query - findAllUsuarios
     * @return
     */
    public List<Usuario> buscarTodos() {
        // TODO implement here
        return null;
    }

    /**
     * JPQL Query - findAllUsuarios
     * @param startResult 
     * @param maxRows 
     * @return
     */
    public List<Usuario> buscarTodos(int startResult, int maxRows) {
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
    public Usuario insertarUsuario(Usuario usuario) {
    	log.debug("saving Usuario instance");
    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	Date date=null;
		try {
			date = dateFormat.parse("23/09/2007");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	long time = date.getTime();
    	Timestamp tiempo=new Timestamp(time);
    	usuario.setFechaCreacion(tiempo);
		try {
			getCurrentSession().save(usuario);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return usuario;
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
    public List<Usuario> buscarEquipoResponsable(int idUsuario) {
        // TODO implement here
        return null;
    }

}