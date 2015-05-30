package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dominio.EquipoComputo;
import dominio.Usuario;
import repositorio.EquipoComputoDao;

@Transactional
public class EquipoComputoDaoIntegrationTestCase extends AbstractUtilityTest {

	private static final Logger log = Logger.getLogger(EquipoComputoDaoIntegrationTestCase.class);

	@Autowired
	EquipoComputoDao equipoComputoDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@After
	@Before
	public void separador(){
		System.out.println("-----------------------------------------");
	}
	
	
	
	/*
	@Test
	public void buscarTodosTest(){
		List<EquipoComputo> equipoComputoList = equipoComputoDao.buscarTodos();
		assertThat(equipoComputoList, is(notNullValue()));
		assertThat(equipoComputoList.isEmpty(), is(not(true)));

		for(EquipoComputo equipoComputo:equipoComputoList){
			log.info(equipoComputo);
		}
	}
	

	@Test
	public void insertarEquipoComputoTest(){
		 Usuario usuarioByIdUsuarioResponsable =(Usuario)getCurrentSession().get(Usuario.class,1);  
		 Usuario usuarioByIdUsuarioAsignado =(Usuario)getCurrentSession().get(Usuario.class,2); 
		EquipoComputo equipoComputo = new EquipoComputo();
		equipoComputo.setDescTipoEquipo("CPU");
		equipoComputo.setUsuarioByIdUsuarioAsignado(usuarioByIdUsuarioAsignado);
		equipoComputo.setUsuarioByIdUsuarioResponsable(usuarioByIdUsuarioResponsable);
		equipoComputo.setMarcaComputo("marcha");
		equipoComputo.setModeloComputo("modelo");
		equipoComputo.setUbicacion("ubicacion");
		equipoComputo.setEstadoEquipo("REGISTRADO");
		equipoComputo.setIndVigenciaEquipo(0);
		EquipoComputo equipoComputoPersistido= equipoComputoDao.insertarEquipoComputo(equipoComputo);
	}
	
	@Test
	public void buscarEquipoComputoPorIdTest(){
		EquipoComputo equipoComputo = new EquipoComputo();
		equipoComputo.setIdEquipoComputo(1);
		EquipoComputo equipoComputoBuscado = equipoComputoDao.buscarEquipoComputoPorId(equipoComputo);
		assertThat(equipoComputoBuscado, is(notNullValue()));
		
	}
	
	@Test
	public void actualizarEquipoComputoTest(){
		EquipoComputo equipoComputo = (EquipoComputo)getCurrentSession().get(EquipoComputo.class,1);  ;
		equipoComputo.setEstadoEquipo("ACTUALIZADO");
		EquipoComputo equipoComputoBuscado = equipoComputoDao.actualizarEquipoComputo(equipoComputo);
		assertThat(equipoComputoBuscado, is(notNullValue()));
		log.info(equipoComputoBuscado);
		
	}
	
	
	@Test
	public void borrarEquipoComputoTest(){
		EquipoComputo equipoComputoSearch =  new EquipoComputo();
		equipoComputoSearch.setIdEquipoComputo(8);
		EquipoComputo equipoComputo = equipoComputoDao.buscarEquipoComputoPorId(equipoComputoSearch);  
		equipoComputo.getEquipoValorCaracs().clear();
		//log.debug(equipoComputo);
		//equipoComputoDao.insertarEquipoComputo(equipoComputo);
		boolean resultado = equipoComputoDao.borrarEquipoComputo(equipoComputo);
		//assertThat(resultado, is(true));
		
	}
	
	@Test
	public void buscarTodosConReparacionTest(){
		List<EquipoComputo> equipoComputoList = equipoComputoDao.buscarTodosConReparacion(0,10);
		assertThat(equipoComputoList, is(notNullValue()));
		assertThat(equipoComputoList.isEmpty(), is(not(true)));
		for(EquipoComputo equipoComputo: equipoComputoList){
			log.debug(equipoComputo);
		}
		
	}
	
	@Test
	public void obtenerTotalRegistrosEquipoComputoTest(){
		Long numTotalRegistro=equipoComputoDao.obtenerTotalRegistrosEquipoComputo();
		assertThat(numTotalRegistro.intValue(),greaterThan(0));
	}
	@Test
	public void buscarTodosPaginadoTest(){
		List<EquipoComputo> equipoComputoList = equipoComputoDao.buscarTodos(0,5);
		assertThat(equipoComputoList, is(notNullValue()));
		assertThat(equipoComputoList.isEmpty(), is(not(true)));

		//for(EquipoComputo equipoComputo:equipoComputoList){
			//log.info(equipoComputo);
		//}
	}*/
	
	@Test
	public void buscarTodosPorDescEquipoTest(){
		List<EquipoComputo> equipoComputoList = equipoComputoDao.buscarTodos("MO");
		assertThat(equipoComputoList, is(notNullValue()));
		assertThat(equipoComputoList.isEmpty(), is(not(true)));

		//for(EquipoComputo equipoComputo:equipoComputoList){
			//log.info(equipoComputo);
		//}
	}
	
	@Test
	public void buscarTodosPorIdAsignadoTest(){
		List<EquipoComputo> equipoComputoList = equipoComputoDao.buscarTodosPorIdAsignado(0,10,3);
		assertThat(equipoComputoList, is(notNullValue()));
		assertThat(equipoComputoList.isEmpty(), is(not(true)));
		Long total = equipoComputoDao.obtenerTotalRegistrosEquipoComputoPorUsuarioAsignado(3);
		assertThat(total.intValue(),greaterThan(0));

		//for(EquipoComputo equipoComputo:equipoComputoList){
			//log.info(equipoComputo);
		//}
	}
	
	@Test
	public void obtenerTotalRegistrosEquipoComputoPorUsuarioAsignadoTest(){
		Long val1=equipoComputoDao.obtenerTotalRegistrosEquipoComputoPorUsuarioAsignado(13);
		Long val2=equipoComputoDao.obtenerTotalRegistrosEquipoComputoPorUsuarioResponsable(13);
		System.out.println("val1:: " + val1 +"  val2 ::"+ val2);

	}
	
}
