package unidad.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import dominio.Usuario;
import integration.repositorio.AbstractUtilityTest;

import javax.validation.Validator;

public class UsuarioTestCase extends AbstractUtilityTest {

	private static final Logger log = Logger.getLogger(UsuarioTestCase.class);

	@Autowired
	private Validator validator;

	@Test
	public void verifica_camposNulos() {
		Usuario usuario = new Usuario();
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		assertThat(constraintViolations.size(),greaterThan(0));
		for(ConstraintViolation<Usuario> singleConstraint : constraintViolations )
		  {
			  log.debug("El campo ["+singleConstraint.getPropertyPath()+ "] mensaje [" + singleConstraint.getMessage() +"] Valor :" + singleConstraint.getInvalidValue());
		  }
		//assertTrue(violationsMap.get("name").getMessageTemplate().contains("NotEmpty"));
		//assertTrue(violationsMap.get("email").getMessageTemplate().contains("NotEmpty"));
		//assertTrue(violationsMap.get("address").getMessageTemplate().contains("NotNull"));
	}
	
	@Test
	public void verifica_campos_formato_email() {
		Usuario usuario = new Usuario("nombre","apPaterno","correoprueba@gmail.com","12345678",1,"dependencia");
		Set<ConstraintViolation<Usuario>> constraintViolations = validator.validate(usuario);
		assertThat(constraintViolations.size(),is(0));
		
	}
}
