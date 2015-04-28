package dominio;

import java.util.HashSet;
import java.util.Set;

/**
 * MenuRol entity. @author MyEclipse Persistence Tools
 */

public class MenuRol implements java.io.Serializable {

	// Fields

	private Integer idMenuRol;
	private String refRole;
	private String descripcionRol;
	private Set usuarios = new HashSet(0);
	private Set menuItems = new HashSet(0);

	// Constructors

	/** default constructor */
	public MenuRol() {
	}

	/** minimal constructor */
	public MenuRol(String refRole, String descripcionRol) {
		this.refRole = refRole;
		this.descripcionRol = descripcionRol;
	}

	/** full constructor */
	public MenuRol(String refRole, String descripcionRol, Set usuarios,
			Set menuItems) {
		this.refRole = refRole;
		this.descripcionRol = descripcionRol;
		this.usuarios = usuarios;
		this.menuItems = menuItems;
	}

	// Property accessors

	public Integer getIdMenuRol() {
		return this.idMenuRol;
	}

	public void setIdMenuRol(Integer idMenuRol) {
		this.idMenuRol = idMenuRol;
	}

	public String getRefRole() {
		return this.refRole;
	}

	public void setRefRole(String refRole) {
		this.refRole = refRole;
	}

	public String getDescripcionRol() {
		return this.descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

	public Set getMenuItems() {
		return this.menuItems;
	}

	public void setMenuItems(Set menuItems) {
		this.menuItems = menuItems;
	}

}