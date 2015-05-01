/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: SeguridadServiceIntegrarionTestCase.java
 * Autor: heriberto
 */
package integration.servicio;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import integration.repositorio.AbstractUtilityTest;
import integration.repositorio.UsuarioDaoIntegrationTestCase;

/**
 * @author heriberto
 *
 */
@Transactional
public class SeguridadServiceIntegrarionTestCase extends AbstractUtilityTest {
	
	private static final Logger log = Logger.getLogger(SeguridadServiceIntegrarionTestCase.class);
	@Autowired
	UserDetailsService userDetailsService;
	
	@Test
	public void loadUserByUsernameTest(){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername("miccreo1");
		log.debug(userDetails);
	}
	
	@Test(expected=UsernameNotFoundException.class)
	public void loadUserByUsernameTestNotFound(){
		
		UserDetails userDetails = userDetailsService.loadUserByUsername("noexiste");
		log.debug(userDetails);
	}
	

	@Test(expected=UsernameNotFoundException.class)
	public void loadUserByUsernameTestSinPerfil(){
		UserDetails userDetails = userDetailsService.loadUserByUsername("miccreo13");
		log.debug(userDetails);
	}
	
	
}
