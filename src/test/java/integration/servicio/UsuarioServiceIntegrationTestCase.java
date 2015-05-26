package integration.servicio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import presentacion.manager.MngAdminUsuario;
import presentacion.manager.MngCrearUsuario;
import dominio.DependenciaUniversitaria;
import dominio.Usuario;
import servicio.UsuarioService;
import integration.repositorio.AbstractUtilityTest;
@Transactional
public class UsuarioServiceIntegrationTestCase extends AbstractUtilityTest{

	private static final Logger log = Logger.getLogger(UsuarioServiceIntegrationTestCase.class);

	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void buscarTodosTest(){
		MngAdminUsuario mngAdminUsuario = usuarioService.buscarTodos("2",10);
		assertThat(mngAdminUsuario, is(notNullValue()));
		assertThat(mngAdminUsuario.getUsuarioList().isEmpty(), is(not(true)));
		log.info(mngAdminUsuario);
		for(Usuario usuario:mngAdminUsuario.getUsuarioList()){
			log.info(usuario);
		}
	}
	/*
	@Test
	public void insertarUsuarioTest(){
		MngCrearUsuario mngCrearUsuario  = new MngCrearUsuario();
		Usuario usuario = new Usuario("nombreServicio","apPaterno","correopruebaIntegracion@Servicio.com","pass",1,"dependencia");
		mngCrearUsuario.setUsuario(usuario);
		mngCrearUsuario.setMenuRolSeleccionado(3);
		mngCrearUsuario = usuarioService.insertarUsuario(mngCrearUsuario);
		assertThat(mngCrearUsuario,is(notNullValue()));
		assertThat(mngCrearUsuario.getUsuario().getIdUsuario(), greaterThan(0));
		log.debug(""+mngCrearUsuario);
	}
	@Test
	public void iniciarCrearUsuarioTest(){
     MngCrearUsuario mngCrearUsuario =usuarioService.iniciarCrearUsuario( new MngCrearUsuario());
     assertThat(mngCrearUsuario, is(notNullValue()));
	 assertThat(mngCrearUsuario.getDependenciaUniList().isEmpty(), is(not(true)));
	 assertThat(mngCrearUsuario.getMenuRol().isEmpty(), is(not(true)));

		for(DependenciaUniversitaria dependenciaUniversitaria:mngCrearUsuario.getDependenciaUniList()){
			log.info(dependenciaUniversitaria);
		}
    }
    @Test
	public void borrarUsuarioTestFail(){
		boolean isSuccess =  usuarioService.borrarUsuario("error");
		assertThat(isSuccess,is(false));
		
	}
    
	
	@Test
	public void borrarUsuarioTest(){
		boolean isSuccess =  usuarioService.borrarUsuario("17");
		assertThat(isSuccess,is(true));
		
	}*/
	
	
}
