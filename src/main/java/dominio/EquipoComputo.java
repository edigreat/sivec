package dominio;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * EquipoComputo entity. @author MyEclipse Persistence Tools
 */

public class EquipoComputo implements java.io.Serializable {

	// Fields

	private Integer idEquipoComputo;
	private TipoEquipoComputo tipoEquipoComputo;
	private Usuario usuarioByIdUsuarioResponsable;
	private Usuario usuarioByIdUsuarioAsignado;
	private String marcaComputo;
	private String modeloComputo;
	private String ubicacion;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	private Integer indVigenciaEquipo;
	private String estadoEquipo;
	private Set reparacionEquipos = new HashSet(0);

	// Constructors

	/** default constructor */
	public EquipoComputo() {
	}

	/** minimal constructor */
	public EquipoComputo(TipoEquipoComputo tipoEquipoComputo,
			Usuario usuarioByIdUsuarioResponsable, String marcaComputo,
			String modeloComputo, Timestamp fechaCreacion,
			Integer indVigenciaEquipo, String estadoEquipo) {
		this.tipoEquipoComputo = tipoEquipoComputo;
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.marcaComputo = marcaComputo;
		this.modeloComputo = modeloComputo;
		this.fechaCreacion = fechaCreacion;
		this.indVigenciaEquipo = indVigenciaEquipo;
		this.estadoEquipo = estadoEquipo;
	}

	/** full constructor */
	public EquipoComputo(TipoEquipoComputo tipoEquipoComputo,
			Usuario usuarioByIdUsuarioResponsable,
			Usuario usuarioByIdUsuarioAsignado, String marcaComputo,
			String modeloComputo, String ubicacion, Timestamp fechaCreacion,
			Timestamp fechaActualizacion, Integer indVigenciaEquipo,
			String estadoEquipo, Set reparacionEquipos) {
		this.tipoEquipoComputo = tipoEquipoComputo;
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.marcaComputo = marcaComputo;
		this.modeloComputo = modeloComputo;
		this.ubicacion = ubicacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.indVigenciaEquipo = indVigenciaEquipo;
		this.estadoEquipo = estadoEquipo;
		this.reparacionEquipos = reparacionEquipos;
	}

	// Property accessors

	public Integer getIdEquipoComputo() {
		return this.idEquipoComputo;
	}

	public void setIdEquipoComputo(Integer idEquipoComputo) {
		this.idEquipoComputo = idEquipoComputo;
	}

	public TipoEquipoComputo getTipoEquipoComputo() {
		return this.tipoEquipoComputo;
	}

	public void setTipoEquipoComputo(TipoEquipoComputo tipoEquipoComputo) {
		this.tipoEquipoComputo = tipoEquipoComputo;
	}

	public Usuario getUsuarioByIdUsuarioResponsable() {
		return this.usuarioByIdUsuarioResponsable;
	}

	public void setUsuarioByIdUsuarioResponsable(
			Usuario usuarioByIdUsuarioResponsable) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
	}

	public Usuario getUsuarioByIdUsuarioAsignado() {
		return this.usuarioByIdUsuarioAsignado;
	}

	public void setUsuarioByIdUsuarioAsignado(Usuario usuarioByIdUsuarioAsignado) {
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
	}

	public String getMarcaComputo() {
		return this.marcaComputo;
	}

	public void setMarcaComputo(String marcaComputo) {
		this.marcaComputo = marcaComputo;
	}

	public String getModeloComputo() {
		return this.modeloComputo;
	}

	public void setModeloComputo(String modeloComputo) {
		this.modeloComputo = modeloComputo;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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

	public Integer getIndVigenciaEquipo() {
		return this.indVigenciaEquipo;
	}

	public void setIndVigenciaEquipo(Integer indVigenciaEquipo) {
		this.indVigenciaEquipo = indVigenciaEquipo;
	}

	public String getEstadoEquipo() {
		return this.estadoEquipo;
	}

	public void setEstadoEquipo(String estadoEquipo) {
		this.estadoEquipo = estadoEquipo;
	}

	public Set getReparacionEquipos() {
		return this.reparacionEquipos;
	}

	public void setReparacionEquipos(Set reparacionEquipos) {
		this.reparacionEquipos = reparacionEquipos;
	}

}