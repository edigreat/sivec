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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import dominio.MenuRol;
import dominio.Usuario;
import repositorio.UsuarioDao;

/**
 * @author heriberto
 *
 */
@Service("userDetailsService") 
public class SeguridadService implements UserDetailsService  {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException, DataAccessException {
		Usuario usuario = usuarioDao.buscarUsuarioPorEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		Set<MenuRol> menuRolList = usuario.getMenuRols();
		List<GrantedAuthority> grantedAuthorities=null;
		if(!menuRolList.isEmpty()){
			for(MenuRol menuRol: usuario.getMenuRols()){
				GrantedAuthority grantedAuthority =new GrantedAuthorityImpl(menuRol.getRefRole());
				grantedAuthorities = Arrays.asList(grantedAuthority);
			}
		}
		else{
			throw new UsernameNotFoundException("Usuario sin perfil");

		}
		
		return new User(usuario.getCorreoEletronico(), usuario.getPassword(),true,false,false,false, grantedAuthorities);
	}

}
