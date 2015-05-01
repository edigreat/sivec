/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MenuItemDaoTestCase.java
 * Autor: heriberto
 */
package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repositorio.MenuItemDao;
import dominio.DependenciaUniversitaria;
import dominio.MenuItem;
import dominio.MenuRol;

/**
 * @author heriberto
 *
 */
@Transactional
public class MenuItemDaoIntegrationTestCase extends AbstractUtilityTest {

	@Autowired
	MenuItemDao menuItemDao;
	@Test
	public void buscarTodosTest(){
		List<MenuItem> menuItemDaoList = menuItemDao.buscarTodos();
		assertThat(menuItemDaoList,is(notNullValue()));
		assertThat(menuItemDaoList.isEmpty(), is(not(true)));
	}
	
	@Test
	public void buscarTodosPaginaTest(){
		List<MenuItem> menuItemDaoList = menuItemDao.buscarTodos(0,10);
		assertThat(menuItemDaoList,is(notNullValue()));
		assertThat(menuItemDaoList.isEmpty(), is(not(true)));

	}
	@Test
	public void buscarItemPorMenuRolTest(){
		MenuRol menuRol =  new MenuRol();
		menuRol.setIdMenuRol(1);
		List<MenuItem> menuItemDaoList = menuItemDao.buscarItemPorMenuRol(menuRol);
		assertThat(menuItemDaoList,is(notNullValue()));
		assertThat(menuItemDaoList.isEmpty(), is(not(true)));
		for(MenuItem menuItem:menuItemDaoList){
			System.out.println(menuItem);
		}

	}

}
