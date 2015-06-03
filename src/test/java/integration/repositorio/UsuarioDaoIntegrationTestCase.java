package integration.repositorio;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
import dominio.MenuRol;
import dominio.Usuario;
import repositorio.MenuRolDao;
import repositorio.UsuarioDao;


@Transactional
public class UsuarioDaoIntegrationTestCase extends AbstractUtilityTest {
	
	private static final Logger log = Logger.getLogger(UsuarioDaoIntegrationTestCase.class);

	@Autowired
	UsuarioDao usuarioDao;
	@Autowired
	MenuRolDao menuRolDao;
	

	@Before
	public void separador(){
		System.out.println ("------------------------------------------------");
	}
	
	@Test
	public void insertarUsuarioTest(){
		Usuario usuarioNew = new Usuario("nombre","apPaterno","correoprueba1@gmail.com","pass",1,"dependencia");
		MenuRol menuRol = menuRolDao.buscarMenuRolPorId(1);
		usuarioNew.setMenuRol(menuRol);
		usuarioNew=usuarioDao.insertarUsuario(usuarioNew);
		assertThat(usuarioNew,is(notNullValue()));
		assertThat(usuarioNew.getIdUsuario(), greaterThan(0));
		log.info(""+usuarioNew);
	}

	@Test
	public void buscarTodosTest(){
		List<Usuario> usuarioList = usuarioDao.buscarTodos("gmail");
		assertThat(usuarioList, is(notNullValue()));
		assertThat(usuarioList.isEmpty(), is(not(true)));

		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}
	
	@Test
	public void buscarTodosTestPaginado(){
		int startResult=3;
		int maxRows=5;
		List<Usuario> usuarioList = usuarioDao.buscarTodos(startResult,maxRows);
		assertThat(usuarioList, is(notNullValue()));
		assertThat(usuarioList.isEmpty(), is(not(true)));
		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}
	
	@Test
	public void buscarUsuarioPorEmaiTestl(){
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1@gmail.com");
		assertThat(usuario, is(notNullValue()));
		log.debug("Usuario " + usuario);
		
	}

	@Test
	public void actualizarUsuarioTest(){
		String apPaterno="actualizadoPaterno";
		String apMaterno="actualizadoMaterno";
		
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1@gmail.com");
		assertThat(usuario,is(notNullValue()));
		log.info("Recuperado : " + usuario);
		usuario.setApMaterno(apMaterno);
		usuario.setApPaterno(apPaterno);
	
		boolean res = usuarioDao.actualizarUsuario(usuario);
		assertThat(res, is (true));
		Usuario usuarioActualizado = usuarioDao.buscarUsuarioPorEmail("miccreo1@gmail.com");
     	assertThat(usuarioActualizado,is(notNullValue()));
		assertThat(usuarioActualizado.getApPaterno(), is(apPaterno));
		assertThat(usuarioActualizado.getApMaterno(), is(apMaterno));
		log.info("usuario1 : " + usuario);
		log.info("usuario2 : " + usuarioActualizado);

	}

	@Test
	public void borrarUsuarioTest(){
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1@gmail.com");
		boolean resultado = usuarioDao.borrarUsuario(usuario);
		assertThat(resultado, is(true));
		
	}
	
	@Test
	public void buscarEquipoResponsableTest(){
		List<Usuario> usuarioList = usuarioDao.buscarEquipoResponsable(1);
		assertThat(usuarioList, is(notNullValue()));
		assertThat(usuarioList.isEmpty(), is(not(true)));
		for(Usuario usuario:usuarioList){
			log.info(usuario.toStringEquipos());
		}
		
	}
	
	@Test
	public void obtenerTotalRegistrosUsuarioTest(){
		Long numUsuarios = usuarioDao.obtenerTotalRegistrosUsuario();
		assertThat(numUsuarios.intValue(),greaterThan(0));
	}
	

}
