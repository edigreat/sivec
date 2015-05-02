/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: Usuario.java
 * Autor: heriberto
 */
package dominio;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
/**
 * Entidad Usuario
 * 
 */
public class Usuario implements java.io.Serializable {


	/**
	 * UID a utilizar
	 */
	private static final long serialVersionUID = -7034203322585204901L;
	

	private Integer idUsuario;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	private String correoEletronico;
	private String password;
	private Integer indVigenciaUsuario;
	private String dependenciaUniversitaria;
	
	private Set<EquipoComputo> equipoComputosForIdUsuarioAsignado = new HashSet<EquipoComputo>(0);
	private Set<EquipoComputo> equipoComputosForIdUsuarioResponsable = new HashSet<EquipoComputo>(0);
	private Set<MenuRol> menuRols = new HashSet<MenuRol>(0);
	private Set<ReparacionEquipo> reparacionEquiposForIdUsuarioAsignado = new HashSet<ReparacionEquipo> (0);
	private Set<ReparacionEquipo>  reparacionEquiposForIdUsuarioResponsable = new HashSet<ReparacionEquipo> (0);

	
	/**constructor por omision */
	public Usuario() {
	}

	/** constructor minimo */
	public Usuario(String nombre, String apPaterno,
			String correoEletronico, String password,
			Integer indVigenciaUsuario, String dependenciaUniversitaria) {
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.correoEletronico = correoEletronico;
		this.password = password;
		this.indVigenciaUsuario = indVigenciaUsuario;
		this.dependenciaUniversitaria = dependenciaUniversitaria;
	}
	
	
	
	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApPaterno() {
		return this.apPaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public String getApMaterno() {
		return this.apMaterno;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Timestamp fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public String getCorreoEletronico() {
		return this.correoEletronico;
	}

	public void setCorreoEletronico(String correoEletronico) {
		this.correoEletronico = correoEletronico;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIndVigenciaUsuario() {
		return this.indVigenciaUsuario;
	}

	public void setIndVigenciaUsuario(Integer indVigenciaUsuario) {
		this.indVigenciaUsuario = indVigenciaUsuario;
	}

	public String getDependenciaUniversitaria() {
		return this.dependenciaUniversitaria;
	}

	public void setDependenciaUniversitaria(String dependenciaUniversitaria) {
		this.dependenciaUniversitaria = dependenciaUniversitaria;
	}

	public Set<EquipoComputo> getEquipoComputosForIdUsuarioAsignado() {
		return this.equipoComputosForIdUsuarioAsignado;
	}

	public void setEquipoComputosForIdUsuarioAsignado(
			Set<EquipoComputo> equipoComputosForIdUsuarioAsignado) {
		this.equipoComputosForIdUsuarioAsignado = equipoComputosForIdUsuarioAsignado;
	}

	public Set<EquipoComputo> getEquipoComputosForIdUsuarioResponsable() {
		return this.equipoComputosForIdUsuarioResponsable;
	}

	public void setEquipoComputosForIdUsuarioResponsable(
			Set<EquipoComputo> equipoComputosForIdUsuarioResponsable) {
		this.equipoComputosForIdUsuarioResponsable = equipoComputosForIdUsuarioResponsable;
	}

	public Set<MenuRol> getMenuRols() {
		return this.menuRols;
	}

	public void setMenuRols(Set<MenuRol> menuRols) {
		this.menuRols = menuRols;
	}

	public Set<ReparacionEquipo>  getReparacionEquiposForIdUsuarioAsignado() {
		return this.reparacionEquiposForIdUsuarioAsignado;
	}

	public void setReparacionEquiposForIdUsuarioAsignado(
			Set<ReparacionEquipo>  reparacionEquiposForIdUsuarioAsignado) {
		this.reparacionEquiposForIdUsuarioAsignado = reparacionEquiposForIdUsuarioAsignado;
	}

	public Set<ReparacionEquipo>  getReparacionEquiposForIdUsuarioResponsable() {
		return this.reparacionEquiposForIdUsuarioResponsable;
	}

	public void setReparacionEquiposForIdUsuarioResponsable(
			Set<ReparacionEquipo>  reparacionEquiposForIdUsuarioResponsable) {
		this.reparacionEquiposForIdUsuarioResponsable = reparacionEquiposForIdUsuarioResponsable;
	}

	@Override
	public String toString() {
		String menuRolsString="";
		if(!menuRols.isEmpty()){
			for(MenuRol menuRol:menuRols){
				menuRolsString +=", "+menuRol;
			}
		}
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", correoEletronico=" + correoEletronico
				+ ", password=" + password + ", indVigenciaUsuario="
				+ indVigenciaUsuario + ", dependenciaUniversitaria="
				+ dependenciaUniversitaria +" ("+menuRolsString+") ] ";
	}

	

}