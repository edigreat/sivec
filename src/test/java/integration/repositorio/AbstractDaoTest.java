package integration.repositorio;
/**
 * Clase base para realizar los test de los daos
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
@ContextConfiguration(locations = { "classpath:/springconf/spring-principal.xml" })
@TestExecutionListeners({TransactionalTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager")
public class AbstractDaoTest extends AbstractJUnit4SpringContextTests  {
	/**
	 * Metodo vacio, gradle se queja si no 
	 * tiene runner
	 */
	
	@Test
	public void abstractTest(){
		
	}

}
