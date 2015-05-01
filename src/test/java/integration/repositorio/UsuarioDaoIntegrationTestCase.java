package integration.repositorio;


import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import static org.hamcrest.Matchers.*;

import dominio.Usuario;
import repositorio.UsuarioDao;

@Transactional
public class UsuarioDaoIntegrationTestCase extends AbstractUtilityTest {
	
	
	private static final Logger log = Logger.getLogger(UsuarioDaoIntegrationTestCase.class);

	@Autowired
	UsuarioDao usuarioDao;
	

	@Before
	public void separador(){
		log.info("-------------------");
	}
	
	@Test
	public void insertarUsuarioTest(){
		Usuario usuarioNew = new Usuario("nombre","apPaterno","correoprueba","pass",1,"dependencia");
		usuarioNew=usuarioDao.insertarUsuario(usuarioNew);
		assertThat(usuarioNew,is(notNullValue()));
		assertThat(usuarioNew.getIdUsuario(), greaterThan(0));
		log.info(""+usuarioNew);
	}
	
	@Test
	public void buscarTodosTest(){
		List<Usuario> usuarioList = usuarioDao.buscarTodos();
		assertThat(usuarioList, is(notNullValue()));
		assertThat(usuarioList.isEmpty(), is(not(true)));

		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}
	
	@Test
	public void buscarTodosTestPaginado(){
		int startResult=0;
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
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		assertThat(usuario, is(notNullValue()));
		log.info(usuario);
		
	}
	
	@Test
	public void actualizarUsuarioTest(){
		String apPaterno="actualizadoPaterno";
		String apMaterno="actualizadoMaterno";
		
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail("miccreo1");
		assertThat(usuario,is(notNullValue()));
		log.info("Recuperado : " + usuario);
		usuario.setApMaterno(apMaterno);
		usuario.setApPaterno(apPaterno);
	
		boolean res = usuarioDao.actualizarUsuario(usuario);
		assertThat(res, is (true));
		Usuario usuarioActualizado = usuarioDao.buscarUsuarioPorEmail("miccreo1");
     	assertThat(usuarioActualizado,is(notNullValue()));
		assertThat(usuarioActualizado.getApPaterno(), is(apPaterno));
		assertThat(usuarioActualizado.getApMaterno(), is(apMaterno));
		log.info("usuario1 : " + usuario);
		log.info("usuario2 : " + usuarioActualizado);

	}

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
		assertThat(usuarioList.isEmpty(), is(not(true)));

		
	}
	

}
