package repositorio;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.*;


/**
 * DAO to manage Menuitem entities.
 * @author Heriberto Galdamez
 */
@Repository
public class MenuItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    /**
     * DAO to manage Menuitem entities.
     */
    public MenuItemDao() {
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<MenuItem> buscarTodos() {
    	String queryString = "from MenuItem";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    }

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<MenuItem> buscarTodos(int startResult, int maxRows) {
    	String queryString = "from MenuItem";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }

    /**
     * Buscar los items de acuerdo a un rol
     * @param menuRol 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<MenuItem> buscarItemPorMenuRol(MenuRol menuRol) {
    	String queryString = "from MenuItem m join fetch m.menuRols u  where u.idMenuRol=:menuRol ";
		Query queryObject = getCurrentSession().createQuery(queryString)
				.setInteger("menuRol",menuRol.getIdMenuRol());
        return queryObject.list();
    }

}