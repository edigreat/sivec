package integration.presentacion.controlador;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Usuario;
import presentacion.controlador.UsuarioController;
import presentacion.manager.MngCrearUsuario;
import integration.repositorio.AbstractUtilityTest;

public class UsuarioControllerTestCase extends AbstractUtilityTest {

	/*@Autowired
	UsuarioController usuarioController;
	
	@Test
	public void guardarInformacionUsuarioTestCase(){
		MngCrearUsuario mngCrearUsuarioInstance= new MngCrearUsuario();
		String redireccion="redirect:/usuario/list.html";
		Usuario usuario = new Usuario("nombre","apPaterno","correopruebaController","pass",1,"dependencia");
		mngCrearUsuarioInstance.setUsuario(usuario);
		mngCrearUsuarioInstance.setMenuRolSeleccionado(3);
		String resultado = usuarioController.guardarInformacionUsuario(mngCrearUsuarioInstance);
		assertThat(redireccion, is(resultado));
	}*/
	
}
