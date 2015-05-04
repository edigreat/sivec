package integration.repositorio;
/**
 * Clase base para realizar los casos de prueba
 * Implementa lo necesario para la integracion de 
 * spring con junit y el transaction manager
 * de spring
 */
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/springconf/spring-principal.xml" , "classpath:/springconf/spring-security.xml"})
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager")
public class AbstractUtilityTest extends AbstractJUnit4SpringContextTests  {
	/**
	 * Caso de prueba vacio,
	 * para probar el contexto de spring
	 */
	@Test
	public void abstractTest(){
		
	}

}
