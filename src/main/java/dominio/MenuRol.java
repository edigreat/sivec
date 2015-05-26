/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MenuRol.java
 * Autor: heriberto
 */
package dominio;

import java.util.HashSet;
import java.util.Set;

/**
 * Entidad MenuRol
 * Clase que representa los roles asignados a los 
 * usuarios
 * 
 */

public class MenuRol implements java.io.Serializable {

	// Fields

		/**
	 * 
	 */
	private static final long serialVersionUID = 3556956187829812240L;
		private Integer idMenuRol;
		private String refRole;
		private String descripcionRol;
		private Set menuItems = new HashSet(0);
		private Set usuarios = new HashSet(0);

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
		public MenuRol(String refRole, String descripcionRol, Set menuItems,
				Set usuarios) {
			this.refRole = refRole;
			this.descripcionRol = descripcionRol;
			this.menuItems = menuItems;
			this.usuarios = usuarios;
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

		public Set getMenuItems() {
			return this.menuItems;
		}

		public void setMenuItems(Set menuItems) {
			this.menuItems = menuItems;
		}

		public Set getUsuarios() {
			return this.usuarios;
		}

		public void setUsuarios(Set usuarios) {
			this.usuarios = usuarios;
		}
	@Override
	public String toString() {
		return "MenuRol [idMenuRol=" + idMenuRol + ", refRole=" + refRole
				+ ", descripcionRol=" + descripcionRol + "]";
	}

}