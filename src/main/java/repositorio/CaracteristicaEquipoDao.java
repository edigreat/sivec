package repositorio;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.*;

/**
 * DAO to manage Caracteristicaequipo entities.
 * @author Heriberto Galdamez
 */
@Repository
public class CaracteristicaEquipoDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    /**
     * DAO to manage Caracteristicaequipo entities.
     */
    public CaracteristicaEquipoDao() {
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<CaracteristicaEquipo> buscarTodos() {
    	String queryString = "from CaracteristicaEquipo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    }

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<CaracteristicaEquipo> buscarTodos(int startResult, int maxRows) {
    	String queryString = "from CaracteristicaEquipo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }

}