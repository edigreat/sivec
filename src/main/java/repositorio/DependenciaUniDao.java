package repositorio;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.*;


/**
 * DAO to manage Dependenciauniversitaria entities.
 * @author Heriberto Galdamez
 */
@Repository
public class DependenciaUniDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    /**
     * DAO to manage Dependenciauniversitaria entities.
     */
    public DependenciaUniDao() {
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<DependenciaUniversitaria> buscarTodos() {
    	String queryString = "from DependenciaUniversitaria";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    }

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<DependenciaUniversitaria> buscarTodos(int startResult, int maxRows) {
    	String queryString = "from DependenciaUniversitaria";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }

}