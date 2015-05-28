package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.EquipoComputo;
import dominio.ReparacionEquipo;
import dominio.Usuario;
import repositorio.ReparacionEquipoDao;

@Transactional
public class ReparacionEquipoDaoIntegrationTestCase extends AbstractUtilityTest {

	private static Logger log = Logger.getLogger(ReparacionEquipoDaoIntegrationTestCase.class);
	@Autowired
	ReparacionEquipoDao reparacionEquipoDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Test
	public void buscarTodosTest(){
		List<ReparacionEquipo> reparacionEquipoList = reparacionEquipoDao.buscarTodos();
		assertThat(reparacionEquipoList,is(notNullValue()));
		assertThat(reparacionEquipoList.isEmpty(), is(not(true)));
		for(ReparacionEquipo reparacion:reparacionEquipoList){
			log.debug(reparacion);
		}
	}
	/*
	@Test
	public void buscarTodosPaginaTest(){
		List<ReparacionEquipo> reparacionEquipoList = reparacionEquipoDao.buscarTodos(0,10);
		assertThat(reparacionEquipoList,is(notNullValue()));
		assertThat(reparacionEquipoList.isEmpty(), is(not(true)));

	}
	
	@Test
	public void buscarReparacionPorEquipoTest(){
		List<ReparacionEquipo> reparacionEquipoList = reparacionEquipoDao.buscarReparacionPorEquipo(14);
		assertThat(reparacionEquipoList,is(notNullValue()));
		assertThat(reparacionEquipoList.isEmpty(), is(not(true)));

	}
	
	@Test
	public void insertarReparacionEquipoTest(){
		 Usuario usuarioByIdUsuarioResponsable =(Usuario)getCurrentSession().get(Usuario.class,1);  
		 Usuario usuarioByIdUsuarioAsignado =(Usuario)getCurrentSession().get(Usuario.class,2); 
		 EquipoComputo equipoComputo = (EquipoComputo) getCurrentSession().get(EquipoComputo.class,1);
		ReparacionEquipo reparacionEquipo = new ReparacionEquipo();
		 reparacionEquipo.setIdReparacionEquipo(1);
		 reparacionEquipo.setUsuarioByIdUsuarioResponsable(usuarioByIdUsuarioResponsable);
		 reparacionEquipo.setEquipoComputo(equipoComputo);
		 reparacionEquipo.setUsuarioByIdUsuarioAsignado(usuarioByIdUsuarioAsignado);
		 reparacionEquipo.setDescReparacion("limpieza del teclado");
		 reparacionEquipo.setDescMotivo("algunas teclas no funcionaban");
		 reparacionEquipo.setIndVigenciaReparacion(0);
		 ReparacionEquipo reparacionEquipoInsert =reparacionEquipoDao.insertarReparacionEquipo(reparacionEquipo);
		
		
		
	}
	*/
	
}
