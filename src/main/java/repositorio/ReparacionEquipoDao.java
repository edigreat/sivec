package repositorio;

import java.util.*;

import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
    	return getCurrentSession().createCriteria(ReparacionEquipo.class)
    	    	.setFetchMode("equipoComputo", FetchMode.JOIN)
    			.setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
    			.setFetchMode("usuarioByIdUsuarioAsignado", FetchMode.JOIN)
    	    	.addOrder(
    	    			Order.desc("idReparacionEquipo")
    	    			)
    	    	.list();
    
    }
    
    
    /**
     * Realiza la busqueda de usuarios con paginacion
     * @param pageNumber numero de pagina
     * @param pageSize  tamanio de pagina
     * @return lista de usuarios
     */
    @SuppressWarnings("unchecked")
	public List<ReparacionEquipo> buscarTodos(int pageNumber, int pageSize) {
		return getCurrentSession().createCriteria(ReparacionEquipo.class)
    	.setFirstResult((pageNumber - 1) * pageSize)
    	.setFetchMode("equipoComputo", FetchMode.JOIN)
		.setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
		.setFetchMode("usuarioByIdUsuarioAsignado", FetchMode.JOIN)
    	.setMaxResults(pageSize)
    	.addOrder(
    			Order.desc("idReparacionEquipo")
    			)
    	.list();
    }
    /**
	 * Obtiene el total de registros de la tabla de reparaciones
	 * @return numero de registros.
	 */
	public Long obtenerTotalRegistrosUsuario(){
		String query = "Select count(r.idReparacionEquipo) from ReparacionEquipo r";
		Query queryTotal = getCurrentSession().createQuery(query);
		return (Long)queryTotal.uniqueResult();
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
	public List<ReparacionEquipo> buscarReparacionPorEquipo(int idEquipoComputo) {
    	return getCurrentSession().createCriteria(ReparacionEquipo.class)
    	    	.setFetchMode("equipoComputo", FetchMode.JOIN)
    			.setFetchMode("usuarioByIdUsuarioResponsable", FetchMode.JOIN)
    			.setFetchMode("usuarioByIdUsuarioAsignado", FetchMode.JOIN)
    			.add(Restrictions.eq("equipoComputo.idEquipoComputo",idEquipoComputo))
    	    	.addOrder(
    	    			Order.desc("idReparacionEquipo")
    	    			)
    	    	.list();
    }

}