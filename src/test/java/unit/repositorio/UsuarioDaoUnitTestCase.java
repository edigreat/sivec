package unit.repositorio;


import java.sql.Timestamp;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static org.hamcrest.CoreMatchers.*;
import dominio.Usuario;
import repositorio.UsuarioDao;

@Transactional

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/springconf/spring-principal.xml" })
public class UsuarioDaoUnitTestCase {
	
	
	private static final Logger log = Logger.getLogger(UsuarioDaoUnitTestCase.class);

	@Autowired
	UsuarioDao usuarioDao;
	

	@Before
	public void separador(){
		log.info("-------------------");
	}
	/*
	@Test
	public void insertarUsuarioTest(){
		Usuario usuarioNew = new Usuario("nombre","apPaterno","correoprueba","pass",1,"dependencia");
		usuarioNew=usuarioDao.insertarUsuario(usuarioNew);
		Assert.notNull(usuarioNew);
		Assert.isTrue(usuarioNew.getIdUsuario()>0);
		log.info(""+usuarioNew);
	}
	
	@Test
	public void buscarTodosTest(){
		List<Usuario> usuarioList = usuarioDao.buscarTodos();
		Assert.notEmpty(usuarioList);
		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}
	
	@Test
	public void buscarTodosTestPaginado(){
		int startResult=0;
		int maxRows=5;
		List<Usuario> usuarioList = usuarioDao.buscarTodos(startResult,maxRows);
		Assert.notEmpty(usuarioList);
		Assert.isTrue(usuarioList.size()==maxRows);
		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}
	
	@Test
	public void buscarUsuarioPorEmaiTestl(){
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		assertThat(usuario, is(notNullValue()));
		
	}*/
	
	@Test
	public void actualizarUsuarioTest(){
		String apPaterno="actualizadoPaterno";
		String apMaterno="actualizadoMaterno";
		
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		Assert.notNull(usuario);
		log.info("Recuperado : " + usuario);
		usuario.setApMaterno(apMaterno);
		usuario.setApPaterno(apPaterno);
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean res = usuarioDao.actualizarUsuario(usuario);
		Usuario usuarioActualizado = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		Assert.notNull(usuarioActualizado);
		assertThat(usuarioActualizado.getApPaterno(), is(apPaterno));
		assertThat(usuarioActualizado.getApMaterno(), is(apMaterno));
		log.info("usuario1 : " + usuario);
		log.info("usuario2 : " + usuarioActualizado);

	}
/*
	@Test
	public void borrarUsuarioTest(){
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		boolean resultado = usuarioDao.borrarUsuario(usuario);
		assertThat(resultado, is(true));
		
	}
	
	@Test
	public void buscarEquipoResponsableTest(){
		List<Usuario> usuarioList = usuarioDao.buscarEquipoResponsable(1);
		assertThat(usuarioList, is(notNullValue()));
		assertThat(usuarioList.isEmpty(), is(not(true)));;

		
	}
	
*/
}
