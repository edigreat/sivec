package presentacion.manager;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Valid
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
		int idMenuAsignado=0;
		if(this.usuario.getMenuRol()!=null){
			idMenuAsignado=this.usuario.getMenuRol().getIdMenuRol();
		}
		return idMenuAsignado;
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