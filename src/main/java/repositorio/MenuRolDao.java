package repositorio;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.*;

/**
 * DAO to manage Menurol entities.
 * @author Heriberto Galdamez
 */
@Repository
public class MenuRolDao {


	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    /**
     * DAO to manage Menurol entities.
     */
    public MenuRolDao() {
    }

    /**
     * Buscar todos los roles de usuario
     * @return lista de roles
     */
    @SuppressWarnings("unchecked")
	public List<MenuRol> buscarTodos() {
    	String queryString = "from MenuRol";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    }

    /**
     * Buscar todos los roles de usuario paginado
     * @param startResult numer de pagina
     * @param maxRows tamanio pagina
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<MenuRol> buscarTodos(int startResult, int maxRows) {
    	String queryString = "from MenuRol";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }

    /**
     * Busca los roles asignados a un usuario
     * @param usuario 
     * @return lista de roles asignados
     */
    @SuppressWarnings("unchecked")
	public List<MenuRol> buscarMenuRolPorUsuario(Usuario usuario) {
    	String queryString = "from MenuRol m join fetch m.usuarios u  where u.idUsuario=:id_usuario ";
		Query queryObject = getCurrentSession().createQuery(queryString)
				.setInteger("id_usuario",usuario.getIdUsuario());
        return queryObject.list();
    }
    
    /**
     * Busca MenuRol por id
     * @param idMenuRol
     * @return MenuRol
     */
	public MenuRol buscarMenuRolPorId(Integer idMenuRol) {
    	return (MenuRol)getCurrentSession().get(MenuRol.class, idMenuRol);
    			//.add(Restrictions.eq("idMenuRol",idMenuRol))
    			//.uniqueResult();
    }
	
	
	/**
     * Busca los roles asignados a un usuario
     * @param usuario 
     * @return lista de roles asignados
     */
    @SuppressWarnings("unchecked")
	public List<MenuRol> buscarListaMenuPorUsuario(String refRole) {
    	return getCurrentSession().createCriteria(MenuRol.class)
				.setFetchMode("menuItems", FetchMode.JOIN)
				.add(Restrictions.eq ("refRole",refRole)).list();
    }
    

}