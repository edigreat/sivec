package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import repositorio.CaracteristicaEquipoDao;
import dominio.CaracteristicaEquipo;

@Transactional
public class CaracteristicaEquipoDaoIntegrationTestCase extends AbstractUtilityTest {

	@Autowired
	CaracteristicaEquipoDao caracteristicaEquipoDao;
	
	@Test
	public void buscarTodosTest(){
		List<CaracteristicaEquipo> caracteristicaEquipoList = caracteristicaEquipoDao.buscarTodos();
		assertThat(caracteristicaEquipoList,is(notNullValue()));
		assertThat(caracteristicaEquipoList.isEmpty(), is(not(true)));
	}
	
	@Test
	public void buscarTodosPaginaTest(){
		List<CaracteristicaEquipo> caracteristicaEquipoList = caracteristicaEquipoDao.buscarTodos(0,10);
		assertThat(caracteristicaEquipoList,is(notNullValue()));
		assertThat(caracteristicaEquipoList.isEmpty(), is(not(true)));

	}

}
