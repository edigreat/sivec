package repositorio;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
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
 * DAO to manage EquipoComputocomputo entities.
 * @author Heriberto Galdamez
 */
@Repository
public class EquipoComputoDao {

	private static final Logger log = Logger.getLogger(EquipoComputoDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
    /**
     * DAO to manage EquipoComputocomputo entities.
     */
    public EquipoComputoDao() {
    }

    /**
     * 
     */
    @SuppressWarnings("unchecked")
	public List<EquipoComputo> buscarTodos() {
    	String queryString = "from EquipoComputo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		return  queryObject.list();
    }

    /**
	 * Obtiene el total de registros de la tabla de usuarios
	 * @return numero de registros de usuario.
	 */
	public Long obtenerTotalRegistrosEquipoComputo(){
		String query = "Select count(e.idEquipoComputo) from EquipoComputo e";
		Query queryTotal = getCurrentSession().createQuery(query);
		return (Long)queryTotal.uniqueResult();
	}
	
    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<EquipoComputo> buscarTodos(int pageNumber, int maxRows) {
    	return getCurrentSession().createCriteria(EquipoComputo.class)
    	    	.setFirstResult((pageNumber - 1) * maxRows)
    	    	 .setFetchMode("tipoEquipoComputo", FetchMode.JOIN)
    	    	 .setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
    	    	.setMaxResults(maxRows)
    	    	.addOrder(
    	    			Order.desc("idEquipoComputo")
    	    			)
    	    	.list();
    }

    /**
     * @param EquipoComputo 
     * @return
     */
    public EquipoComputo buscarEquipoComputoPorId(EquipoComputo equipoComputo) {
    	return (EquipoComputo)getCurrentSession().createCriteria(EquipoComputo.class)
			.add(Restrictions.eq("idEquipoComputo",equipoComputo.getIdEquipoComputo()))
			.setFetchMode("equipoValorCaracs", FetchMode.JOIN)
			.setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
			.setFetchMode("usuarioByIdUsuarioAsignado", FetchMode.JOIN)
			.uniqueResult();
    }

    /**
     * @param EquipoComputo 
     * @return
     */
    public EquipoComputo insertarEquipoComputo(EquipoComputo equipoComputo) {
    	getCurrentSession().save(equipoComputo);
        return equipoComputo;
    }

    /**
     * @param EquipoComputo 
     * @return
     */
    public EquipoComputo actualizarEquipoComputo(EquipoComputo equipoComputo) {
    	getCurrentSession().update(equipoComputo);
        return equipoComputo;
    }

    /**
     * @param EquipoComputo 
     * @return
     */
    public boolean borrarEquipoComputo(EquipoComputo equipoComputo) {
    	boolean resultado=false;
    	try{
    	getCurrentSession().delete(equipoComputo);
    	resultado=true;
    	}
    	catch(HibernateException hbex){
    		log.warn(hbex.getMessage());
    	}
        return resultado;
    }

    /**
     * @param startResult 
     * @param maxRows 
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<EquipoComputo> buscarTodosConReparacion(int startResult, int maxRows) {
    	String queryString = "from EquipoComputo e  join fetch e.reparacionEquipos r where r.equipoComputo=e.idEquipoComputo";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setFirstResult(startResult);
		queryObject.setMaxResults(maxRows);
		return  queryObject.list();
    }
    
    /**
     * Obtiene toda la lista de usuarios
     * @return lista de usuarios
     */
	@SuppressWarnings("unchecked")
    public List<EquipoComputo> buscarTodos(String equipoComputo) {
		return getCurrentSession().createCriteria(EquipoComputo.class)
				.add(Restrictions.ilike("descTipoEquipo",equipoComputo,MatchMode.ANYWHERE))
				.setFetchMode("tipoEquipoComputo", FetchMode.JOIN)
    	    	.setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
    	    	.addOrder(
    	    			Order.desc("idEquipoComputo")
    	    			)
    	    	.list();
				
		
		
    			
		
    }

}