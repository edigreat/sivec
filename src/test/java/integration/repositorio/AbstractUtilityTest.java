package integration.repositorio;
/**
 * Clase base para realizar los casos de prueba
 * Implementa lo necesario para la integracion de 
 * spring con junit y el transaction manager
 * de spring
 */
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import static org.hamcrest.Matchers.*;

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
	
	@Rule
	public TestRule watcher = new TestWatcher() {
	   protected void starting(Description description) {
	      System.out.println("---------------> Iniciando test: " + description.getMethodName());
	   }
	   
	   protected void finished(Description description) {
		      System.out.println("<---------- Finalizando test: " + description.getMethodName());
		   }
	};	


}
