package dominio;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.PrePersist;

/**
 * Usuario entity. @author MyEclipse Persistence Tools
 */

public class Usuario implements java.io.Serializable {

	// Fields

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
	private Set equipoComputosForIdUsuarioAsignado = new HashSet(0);
	private Set equipoComputosForIdUsuarioResponsable = new HashSet(0);
	private Set menuRols = new HashSet(0);
	private Set reparacionEquiposForIdUsuarioAsignado = new HashSet(0);
	private Set reparacionEquiposForIdUsuarioResponsable = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
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
	
	@PrePersist
    public void setLastUpdate() {
        //o.setLastUpdate( new Date() );
		System.out.println("seteano......");
    }
	/** full constructor */
	public Usuario(String nombre, String apPaterno, String apMaterno,
			Timestamp fechaCreacion, Timestamp fechaActualizacion,
			String correoEletronico, String password,
			Integer indVigenciaUsuario, String dependenciaUniversitaria,
			Set equipoComputosForIdUsuarioAsignado,
			Set equipoComputosForIdUsuarioResponsable, Set menuRols,
			Set reparacionEquiposForIdUsuarioAsignado,
			Set reparacionEquiposForIdUsuarioResponsable) {
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.correoEletronico = correoEletronico;
		this.password = password;
		this.indVigenciaUsuario = indVigenciaUsuario;
		this.dependenciaUniversitaria = dependenciaUniversitaria;
		this.equipoComputosForIdUsuarioAsignado = equipoComputosForIdUsuarioAsignado;
		this.equipoComputosForIdUsuarioResponsable = equipoComputosForIdUsuarioResponsable;
		this.menuRols = menuRols;
		this.reparacionEquiposForIdUsuarioAsignado = reparacionEquiposForIdUsuarioAsignado;
		this.reparacionEquiposForIdUsuarioResponsable = reparacionEquiposForIdUsuarioResponsable;
	}

	// Property accessors

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

	public Set getEquipoComputosForIdUsuarioAsignado() {
		return this.equipoComputosForIdUsuarioAsignado;
	}

	public void setEquipoComputosForIdUsuarioAsignado(
			Set equipoComputosForIdUsuarioAsignado) {
		this.equipoComputosForIdUsuarioAsignado = equipoComputosForIdUsuarioAsignado;
	}

	public Set getEquipoComputosForIdUsuarioResponsable() {
		return this.equipoComputosForIdUsuarioResponsable;
	}

	public void setEquipoComputosForIdUsuarioResponsable(
			Set equipoComputosForIdUsuarioResponsable) {
		this.equipoComputosForIdUsuarioResponsable = equipoComputosForIdUsuarioResponsable;
	}

	public Set getMenuRols() {
		return this.menuRols;
	}

	public void setMenuRols(Set menuRols) {
		this.menuRols = menuRols;
	}

	public Set getReparacionEquiposForIdUsuarioAsignado() {
		return this.reparacionEquiposForIdUsuarioAsignado;
	}

	public void setReparacionEquiposForIdUsuarioAsignado(
			Set reparacionEquiposForIdUsuarioAsignado) {
		this.reparacionEquiposForIdUsuarioAsignado = reparacionEquiposForIdUsuarioAsignado;
	}

	public Set getReparacionEquiposForIdUsuarioResponsable() {
		return this.reparacionEquiposForIdUsuarioResponsable;
	}

	public void setReparacionEquiposForIdUsuarioResponsable(
			Set reparacionEquiposForIdUsuarioResponsable) {
		this.reparacionEquiposForIdUsuarioResponsable = reparacionEquiposForIdUsuarioResponsable;
	}

}