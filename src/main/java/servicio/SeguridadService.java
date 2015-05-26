/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: SeguridadService.java
 * Autor: heriberto
 */
package servicio;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dominio.MenuRol;
import dominio.Usuario;
import repositorio.UsuarioDao;

/**
 * @author heriberto
 *
 */
@Service("userDetailsService") 
@Transactional
public class SeguridadService implements UserDetailsService  {

	private static Logger log = Logger.getLogger(SeguridadService.class);

	/**
	 * DAO inyectado por Spring que maneja las entidades usuario
	 */
	@Autowired
	UsuarioDao usuarioDao;

	
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException, DataAccessException {
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		List<GrantedAuthority> grantedAuthorities=null;
		if(usuario.getMenuRol()!=null){
			GrantedAuthority grantedAuthority =new GrantedAuthorityImpl(usuario.getMenuRol().getRefRole());
			grantedAuthorities = Arrays.asList(grantedAuthority);
			
		}
		else{
			log.debug("EL usuario no es valido " +email);
			throw new UsernameNotFoundException("Usuario sin perfil");

		}
		
		return new User(usuario.getCorreoEletronico(), usuario.getPassword(),true,true,true,true, grantedAuthorities);
	}

}
