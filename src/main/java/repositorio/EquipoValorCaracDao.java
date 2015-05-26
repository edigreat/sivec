/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoValorCaracDao.java
 * Autor: heriberto
 */
package repositorio;

import org.apache.log4j.Logger;
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
	
	
	public EquipoValorCarac insertarUsuario(EquipoValorCarac equipoValorCarac) {
    	log.debug("Guardando instancia  equipoValorCarac ");
    		getCurrentSession().save(equipoValorCarac);
		log.debug("equipoValorCarac Guardado exitosamente");
		
		return equipoValorCarac;
    }
}
