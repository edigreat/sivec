package dominio;

/**
 * ReparacionEquipo entity. @author MyEclipse Persistence Tools
 */

public class ReparacionEquipo implements java.io.Serializable {

	// Fields

	private Integer idReparacionEquipo;
	private Usuario usuarioByIdUsuarioResponsable;
	private EquipoComputo equipoComputo;
	private Usuario usuarioByIdUsuarioAsignado;
	private String descReparacion;
	private String descMotivo;
	private String fechaCreacion;
	private Integer indVigenciaReparacion;

	// Constructors

	/** default constructor */
	public ReparacionEquipo() {
	}

	/** minimal constructor */
	public ReparacionEquipo(Usuario usuarioByIdUsuarioResponsable,
			EquipoComputo equipoComputo, Usuario usuarioByIdUsuarioAsignado,
			String descReparacion, String descMotivo, String fechaCreacion) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.equipoComputo = equipoComputo;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.descReparacion = descReparacion;
		this.descMotivo = descMotivo;
		this.fechaCreacion = fechaCreacion;
	}

	/** full constructor */
	public ReparacionEquipo(Usuario usuarioByIdUsuarioResponsable,
			EquipoComputo equipoComputo, Usuario usuarioByIdUsuarioAsignado,
			String descReparacion, String descMotivo, String fechaCreacion,
			Integer indVigenciaReparacion) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.equipoComputo = equipoComputo;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.descReparacion = descReparacion;
		this.descMotivo = descMotivo;
		this.fechaCreacion = fechaCreacion;
		this.indVigenciaReparacion = indVigenciaReparacion;
	}

	// Property accessors

	public Integer getIdReparacionEquipo() {
		return this.idReparacionEquipo;
	}

	public void setIdReparacionEquipo(Integer idReparacionEquipo) {
		this.idReparacionEquipo = idReparacionEquipo;
	}

	public Usuario getUsuarioByIdUsuarioResponsable() {
		return this.usuarioByIdUsuarioResponsable;
	}

	public void setUsuarioByIdUsuarioResponsable(
			Usuario usuarioByIdUsuarioResponsable) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
	}

	public EquipoComputo getEquipoComputo() {
		return this.equipoComputo;
	}

	public void setEquipoComputo(EquipoComputo equipoComputo) {
		this.equipoComputo = equipoComputo;
	}

	public Usuario getUsuarioByIdUsuarioAsignado() {
		return this.usuarioByIdUsuarioAsignado;
	}

	public void setUsuarioByIdUsuarioAsignado(Usuario usuarioByIdUsuarioAsignado) {
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
	}

	public String getDescReparacion() {
		return this.descReparacion;
	}

	public void setDescReparacion(String descReparacion) {
		this.descReparacion = descReparacion;
	}

	public String getDescMotivo() {
		return this.descMotivo;
	}

	public void setDescMotivo(String descMotivo) {
		this.descMotivo = descMotivo;
	}

	public String getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIndVigenciaReparacion() {
		return this.indVigenciaReparacion;
	}

	public void setIndVigenciaReparacion(Integer indVigenciaReparacion) {
		this.indVigenciaReparacion = indVigenciaReparacion;
	}

}