/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoValorCaracDao.java
 * Autor: heriberto
 */
package repositorio;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dominio.EquipoValorCarac;
import dominio.Usuario;

/**
 * @author heriberto
 *
 */
@Repository
public class EquipoValorCaracDao {
	private static final Logger log = Logger.getLogger(EquipoValorCaracDao.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	public EquipoValorCaracDao(){}
	

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	public EquipoValorCarac insertarEquipoValorCarac(EquipoValorCarac equipoValorCarac) {
    	log.debug("Guardando instancia  equipoValorCarac ");
    		getCurrentSession().save(equipoValorCarac);
		log.debug("equipoValorCarac Guardado exitosamente");
		
		return equipoValorCarac;
    }
	
	 /**
     * Actualiza la informacion de un EquipoValorCarac
     * @param EquipoValorCarac a actualizar
     * @return resultado de la  actualizacion
     */
    public boolean actualizarEquipoValorCarac(EquipoValorCarac equipoValorCarac) {
    	getCurrentSession().update(equipoValorCarac);
        return true;
    }
    
    public boolean eliminarCaracteristiscaPorIdEquipo(Integer idEquipoComputo){
    	boolean hasSuccess=false;  
    	String hql = "delete from EquipoValorCarac where equipoComputo.idEquipoComputo= :idEquipoComputo ";
    	  try{
    		  Query query = getCurrentSession().createQuery(hql);
    		  query.setInteger("idEquipoComputo", idEquipoComputo);
    		  System.out.println(query.executeUpdate());
    		  hasSuccess=true;
    	  }
    	  catch(Exception ex){
    		 System.out.println(ex.toString()); 
    	  
    	  }
    	  return hasSuccess;
    }

}
