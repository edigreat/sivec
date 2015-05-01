package dominio;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que contiene los items de los menus
 * a presentar, contiene una lista de menuRols
 * los cuales son los roles asociados a esos items
 */

public class MenuItem implements java.io.Serializable {

	// Fields

	private Integer idMenuItem;
	private MenuItem menuItem;
	private String etiqueta;
	private String accion;
	private String nombreMenu;
	private Set menuItems = new HashSet(0);
	private Set menuRols = new HashSet(0);

	// Constructors

	/** default constructor */
	public MenuItem() {
	}

	/** minimal constructor */
	public MenuItem(String etiqueta, String accion, String nombreMenu) {
		this.etiqueta = etiqueta;
		this.accion = accion;
		this.nombreMenu = nombreMenu;
	}

	/** full constructor */
	public MenuItem(MenuItem menuItem, String etiqueta, String accion,
			String nombreMenu, Set menuItems, Set menuRols) {
		this.menuItem = menuItem;
		this.etiqueta = etiqueta;
		this.accion = accion;
		this.nombreMenu = nombreMenu;
		this.menuItems = menuItems;
		this.menuRols = menuRols;
	}

	// Property accessors

	public Integer getIdMenuItem() {
		return this.idMenuItem;
	}

	public void setIdMenuItem(Integer idMenuItem) {
		this.idMenuItem = idMenuItem;
	}

	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getNombreMenu() {
		return this.nombreMenu;
	}

	public void setNombreMenu(String nombreMenu) {
		this.nombreMenu = nombreMenu;
	}

	public Set getMenuItems() {
		return this.menuItems;
	}

	public void setMenuItems(Set menuItems) {
		this.menuItems = menuItems;
	}

	public Set getMenuRols() {
		return this.menuRols;
	}

	public void setMenuRols(Set menuRols) {
		this.menuRols = menuRols;
	}

	@Override
	public String toString() {
		return "MenuItem [idMenuItem=" + idMenuItem + ", menuItem=" + menuItem
				+ ", etiqueta=" + etiqueta + ", accion=" + accion
				+ ", nombreMenu=" + nombreMenu + "]";
	}

}