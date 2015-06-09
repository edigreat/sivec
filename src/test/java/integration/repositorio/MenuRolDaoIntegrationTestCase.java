package integration.repositorio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.transaction.annotation.Transactional;

import dominio.MenuItem;
import dominio.MenuRol;
import dominio.Usuario;
import repositorio.MenuRolDao;

@Transactional
public class MenuRolDaoIntegrationTestCase  extends AbstractUtilityTest {

	private static final Logger log = Logger.getLogger(UsuarioDaoIntegrationTestCase.class);
	
	@Autowired
	MenuRolDao menuRolDao;
	/*
	
	@Test
	public void buscarTodosTest(){
		List<MenuRol> menuRolList = menuRolDao.buscarTodos();
		assertThat(menuRolList,is(notNullValue()));
		assertThat(menuRolList.isEmpty(), is(not(true)));

	}
	
	@Test
	public void buscarTodosPaginaTest(){
		List<MenuRol> menuRolList = menuRolDao.buscarTodos(0,10);
		assertThat(menuRolList,is(notNullValue()));
		assertThat(menuRolList.isEmpty(), is(not(true)));

	}
	
	@Test
	public void buscarMenuRolPorUsuarioTest(){
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(2);
		List<MenuRol> menuRolList = menuRolDao.buscarMenuRolPorUsuario(usuario);
		assertThat(menuRolList,is(notNullValue()));
		
		for(MenuRol menuRol: menuRolList){
			log.debug(menuRol);
		}
	}
	
	@Test
	public void buscarMenuRolPorIdTest(){
		
		MenuRol menuRol = menuRolDao.buscarMenuRolPorId(1);
		assertThat(menuRol,is(notNullValue()));
	    log.debug(menuRol);
		
	}
	*/
	@Test
	public void buscarListaMenuPorUsuario(){
		
		List<MenuRol> menuRolList = menuRolDao.buscarListaMenuPorUsuario("ROLE_ADMIN");
		assertThat(menuRolList,is(notNullValue()));
		//log.debug(menuRolList.size());
		//log.debug(menuRolList.get(0).getMenuItems().size());
		for(Object object: menuRolList.get(0).getMenuItems()){
			MenuItem menuItem = (MenuItem) object;
			log.debug(menuItem);
		}
	}
}
