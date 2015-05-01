package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repositorio.DependenciaUniDao;
import dominio.DependenciaUniversitaria;

@Transactional
public class DependenciaUniDaoTestCase extends AbstractUtilityTest {
	
	@Autowired
	DependenciaUniDao dependenciaUniDao;
	
	@Test
	public void buscarTodosTest(){
		List<DependenciaUniversitaria> dependenciaUniversitariaList = dependenciaUniDao.buscarTodos();
		assertThat(dependenciaUniversitariaList,is(notNullValue()));
		assertThat(dependenciaUniversitariaList.isEmpty(), is(not(true)));
	}
	
	@Test
	public void buscarTodosPaginaTest(){
		List<DependenciaUniversitaria> dependenciaUniversitariaList = dependenciaUniDao.buscarTodos(0,10);
		assertThat(dependenciaUniversitariaList,is(notNullValue()));
		assertThat(dependenciaUniversitariaList.isEmpty(), is(not(true)));

	}

}
