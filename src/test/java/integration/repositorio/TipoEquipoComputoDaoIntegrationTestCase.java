package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repositorio.TipoEquipoComputoDao;
import dominio.CaracteristicaEquipo;
import dominio.TipoEquipoComputo;

@Transactional
public class TipoEquipoComputoDaoIntegrationTestCase  extends AbstractUtilityTest{

	@Autowired
	TipoEquipoComputoDao tipoEquipoComputoDao;
	
	@Test
	public void buscarTodosTest(){
		List<TipoEquipoComputo> tipoEquipoComputoList = tipoEquipoComputoDao.buscarTodos();
		assertThat(tipoEquipoComputoList,is(notNullValue()));
		assertThat(tipoEquipoComputoList.isEmpty(), is(not(true)));
	}
	
	@Test
	public void buscarTodosPaginaTest(){
		List<TipoEquipoComputo> tipoEquipoComputoList = tipoEquipoComputoDao.buscarTodos(0,10);
		assertThat(tipoEquipoComputoList,is(notNullValue()));
		assertThat(tipoEquipoComputoList.isEmpty(), is(not(true)));

	}
}
