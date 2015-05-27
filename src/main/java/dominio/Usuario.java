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

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
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
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String nombre;
	@NotNull
	@NotBlank
	@NotEmpty
	private String apPaterno;
	private String apMaterno;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	@NotNull
	@NotBlank
	@Email
	private String correoEletronico;
	@NotNull
	@NotBlank
	@Pattern(regexp = "[0-9]{4,8}",message="Solo digitos, min 4 max 8")
	private String password;

    private Integer indVigenciaUsuario;
	@NotNull
	@NotBlank
	private String dependenciaUniversitaria;
	
	
	private MenuRol menuRol;

	private Set<EquipoComputo> equipoComputosForIdUsuarioAsignado = new HashSet<EquipoComputo>(0);
	private Set<EquipoComputo> equipoComputosForIdUsuarioResponsable = new HashSet<EquipoComputo>(0);
	private Set<ReparacionEquipo> reparacionEquiposForIdUsuarioAsignado = new HashSet<ReparacionEquipo> (0);
	private Set<ReparacionEquipo>  reparacionEquiposForIdUsuarioResponsable = new HashSet<ReparacionEquipo> (0);

	
	
	
	/**
	 * Concatena los atributos para formar
	 * el nombre completo del usuario
	 * @return nombre completo del usuario
	 */
	public String getNombreCompleto(){
		return this.nombre+" "+this.apPaterno+" "+this.apMaterno;
	}
	
	/**
	 * Concatena los atributos para formar
	 * el nombre completo del usuario iniciando
	 * por el apellido paterno
	 * @return nombre completo del usuario
	 */
	public String getNombreCompletoApPaterno(){
		return this.apPaterno+" "+this.apMaterno+" "+this.nombre;
	}
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
		String equipoComputosAsignadoString="";
		
		/*
		if(!this.equipoComputosForIdUsuarioAsignado.isEmpty()){
			for(EquipoComputo equipoComputo:this.equipoComputosForIdUsuarioAsignado)
			{
				equipoComputosAsignadoString+=" , "+equipoComputo;
			}
		}*/
		
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", correoEletronico=" + correoEletronico
				+ ", password=" + password + ", indVigenciaUsuario="
				+ indVigenciaUsuario + ", dependenciaUniversitaria="
				+ dependenciaUniversitaria+")";// +" ("+menuRolsString+") , ("+equipoComputosAsignadoString+")] ";
	}

	public String toStringEquipos() {
		//String menuRolsString="";
		String equipoComputosAsignadoString="";
		/*if(!menuRols.isEmpty()){
			for(MenuRol menuRol:menuRols){
				menuRolsString +=", "+menuRol;
			}
		}
		*/
		if(!this.equipoComputosForIdUsuarioAsignado.isEmpty()){
			for(EquipoComputo equipoComputo:this.equipoComputosForIdUsuarioAsignado)
			{
				equipoComputosAsignadoString+=" , "+equipoComputo;
			}
		}
		
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
				+ ", fechaCreacion=" + fechaCreacion + ", fechaActualizacion="
				+ fechaActualizacion + ", correoEletronico=" + correoEletronico
				+ ", password=" + password + ", indVigenciaUsuario="
				+ indVigenciaUsuario + ", dependenciaUniversitaria="
				+ dependenciaUniversitaria +" ("+equipoComputosAsignadoString+")] ";
	}

	public String getDescripcionPerfil(){
		return this.menuRol.getDescripcionRol();
	}


	public MenuRol getMenuRol() {
		return menuRol;
	}


	public void setMenuRol(MenuRol menuRol) {
		this.menuRol = menuRol;
	}

	

}