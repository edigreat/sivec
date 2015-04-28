package unit.repositorio;


import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dominio.Usuario;
import repositorio.UsuarioDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/springconf/spring-principal.xml" })
public class UsuarioDaoUnitTestCase {
	
	
	private static final Logger log = Logger.getLogger(UsuarioDaoUnitTestCase.class);

	@Autowired
	UsuarioDao usuarioDao;
	
	@Test
	public void initTest(){
		log.info("Iniciando "+usuarioDao);
		Usuario usuarioNew = new Usuario("nombre","apPaterno", "correo","pass",1,"dependencia");
		usuarioNew=usuarioDao.insertarUsuario(usuarioNew);
		List<Usuario> usuarioList = usuarioDao.buscarTodos();
		for(Usuario usuario:usuarioList){
			log.info(usuario);
		}
	}

}
