package repositorio;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.*;

/**
 * DAO to manage Reparacionequipo entities.
 * @author Heriberto Galdamez
 */
@Repository
public class ReparacionEquipoDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
    /**
     * DAO to manage Reparacionequipo entities.
     */
    public ReparacionEquipoDao() {
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<ReparacionEquipo> buscarTodos() {
    	String queryString = "from ReparacionEquipo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    
    }

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<ReparacionEquipo> buscarTodos(int startResult, int maxRows) {
    	String queryString = "from ReparacionEquipo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }

    /**
     * @param repacionEquipo 
     * @return
     */
    public ReparacionEquipo insertarReparacionEquipo(ReparacionEquipo repacionEquipo) {
    	getCurrentSession().save(repacionEquipo);
        return repacionEquipo;
    }

    /**
     * @param idEquipo 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<ReparacionEquipo> buscarReparacionPorEquipo(int idEquipo) {
    	String queryString = "from ReparacionEquipo r WHERE r.equipoComputo = :idEquipo ";
		Query queryObject = getCurrentSession().createQuery(queryString)
				.setInteger("idEquipo",idEquipo);
        return queryObject.list();
    }

}