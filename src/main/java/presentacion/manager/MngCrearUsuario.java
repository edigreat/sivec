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
    
    private Integer menuRolSeleccionado=0;

    /**
     * 
     */
    private List<DependenciaUniversitaria> dependenciaUniList;

    /**
     * 
     */
    private Map<Integer,String> menuRol;

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

	public  Map<Integer,String> getMenuRol() {
		return menuRol;
	}

	public void setMenuRol( Map<Integer,String> menuRol) {
		this.menuRol = menuRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getMenuRolSeleccionado() {
		return this.menuRolSeleccionado;
	}

	public void setMenuAsignado(Integer menuRolSeleccionado){
		this.menuRolSeleccionado = menuRolSeleccionado;

	}
	public Integer getMenuAsignado(){
		Integer idMenuRol=0;
		if( this.usuario.getMenuRols().iterator().hasNext()){
			MenuRol menuRol = this.usuario.getMenuRols().iterator().next();
			menuRol.getIdMenuRol();
			idMenuRol=menuRol.getIdMenuRol();
		}
		return idMenuRol;
	}
	public void setMenuRolSeleccionado(Integer menuRolSeleccionado) {
		this.menuRolSeleccionado = menuRolSeleccionado;
	}

	@Override
	public String toString() {
		return "MngCrearUsuario [menuRolSeleccionado=" + menuRolSeleccionado
				+ ", dependenciaUniList=" + dependenciaUniList + ", menuRol="
				+ menuRol + ", usuario=" + usuario + "]";
	}

}