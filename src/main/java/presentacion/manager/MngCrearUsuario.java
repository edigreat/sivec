package presentacion.manager;

import java.util.*;

import dominio.DependenciaUniversitaria;
import dominio.MenuRol;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngCrearUsuario {

    /**
     * 
     */
    public MngCrearUsuario() {
    }

    /**
     * 
     */
    private List<DependenciaUniversitaria> dependenciaUniList;

    /**
     * 
     */
    private List<MenuRol> menuRol;

    /**
     * 
     */
    private Usuario usuario;

	public List<DependenciaUniversitaria> getDependenciaUniList() {
		return dependenciaUniList;
	}

	public void setDependenciaUniList(
			List<DependenciaUniversitaria> dependenciaUniList) {
		this.dependenciaUniList = dependenciaUniList;
	}

	public List<MenuRol> getMenuRol() {
		return menuRol;
	}

	public void setMenuRol(List<MenuRol> menuRol) {
		this.menuRol = menuRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}