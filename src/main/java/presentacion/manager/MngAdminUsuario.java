package presentacion.manager;

import java.util.*;

import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngAdminUsuario {

    /**
     * 
     */
    public MngAdminUsuario() {
    }

    /**
     * 
     */
    private List<Usuario> usuarioList;

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

}