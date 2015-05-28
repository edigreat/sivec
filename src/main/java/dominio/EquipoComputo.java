/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoComputo.java
 * Autor: heriberto
 */
package dominio;

import static presentacion.manager.ConstantesPresentacion.FORMATO_FECHA;
import static presentacion.manager.ConstantesPresentacion.FORMATO_HORA;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Clase que representa una Entidad EquipoComputo 
 */

public class EquipoComputo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4150412060216682521L;
	private Integer idEquipoComputo;
	private Usuario usuarioByIdUsuarioResponsable;
	private Usuario usuarioByIdUsuarioAsignado;
	@NotNull
	@NotBlank
	@NotEmpty
	private String descTipoEquipo;
	@NotNull
	@NotBlank
	@NotEmpty
	private String marcaComputo;
	@NotNull
	@NotBlank
	@NotEmpty
	private String modeloComputo;
	@NotNull
	@NotBlank
	@NotEmpty
	private String ubicacion;
	private Timestamp fechaCreacion;
	private Timestamp fechaActualizacion;
	private Integer indVigenciaEquipo;
	private String estadoEquipo;
	private Set equipoValorCaracs = new HashSet(0);
	private Set reparacionEquipos = new HashSet(0);

	// Constructors

	/** default constructor */
	public EquipoComputo() {
	}

	/** minimal constructor */
	public EquipoComputo(Usuario usuarioByIdUsuarioResponsable,
			String descTipoEquipo, String marcaComputo, String modeloComputo,
			Timestamp fechaCreacion, Integer indVigenciaEquipo,
			String estadoEquipo) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.descTipoEquipo = descTipoEquipo;
		this.marcaComputo = marcaComputo;
		this.modeloComputo = modeloComputo;
		this.fechaCreacion = fechaCreacion;
		this.indVigenciaEquipo = indVigenciaEquipo;
		this.estadoEquipo = estadoEquipo;
	}

	/** full constructor */
	public EquipoComputo(Usuario usuarioByIdUsuarioResponsable,
			Usuario usuarioByIdUsuarioAsignado, String descTipoEquipo,
			String marcaComputo, String modeloComputo, String ubicacion,
			Timestamp fechaCreacion, Timestamp fechaActualizacion,
			Integer indVigenciaEquipo, String estadoEquipo,
			Set equipoValorCaracs, Set reparacionEquipos) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.descTipoEquipo = descTipoEquipo;
		this.marcaComputo = marcaComputo;
		this.modeloComputo = modeloComputo;
		this.ubicacion = ubicacion;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
		this.indVigenciaEquipo = indVigenciaEquipo;
		this.estadoEquipo = estadoEquipo;
		this.equipoValorCaracs = equipoValorCaracs;
		this.reparacionEquipos = reparacionEquipos;
	}


	public String getFechaActuallizacionFormato(){
   	 SimpleDateFormat simpleDateFormatFecha = 
   	            new SimpleDateFormat(FORMATO_FECHA,new Locale("es"));
   	SimpleDateFormat simpleDateFormatHora = 
	            new SimpleDateFormat(FORMATO_HORA,new Locale("es"));
   	 return simpleDateFormatFecha.format(this.fechaActualizacion.getTime()) 
   			 + " "+simpleDateFormatHora.format(this.fechaActualizacion.getTime()) ;
	}
	
	// Property accessors

	public Integer getIdEquipoComputo() {
		return this.idEquipoComputo;
	}

	public void setIdEquipoComputo(Integer idEquipoComputo) {
		this.idEquipoComputo = idEquipoComputo;
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

	public String getDescTipoEquipo() {
		return this.descTipoEquipo;
	}

	public void setDescTipoEquipo(String descTipoEquipo) {
		this.descTipoEquipo = descTipoEquipo;
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

	public Set getEquipoValorCaracs() {
		return this.equipoValorCaracs;
	}

	public void setEquipoValorCaracs(Set equipoValorCaracs) {
		this.equipoValorCaracs = equipoValorCaracs;
	}

	public Set getReparacionEquipos() {
		return this.reparacionEquipos;
	}

	public void setReparacionEquipos(Set reparacionEquipos) {
		this.reparacionEquipos = reparacionEquipos;
	}

	@Override
	public String toString() {
		return "EquipoComputo [idEquipoComputo=" + idEquipoComputo
				+ ", usuarioByIdUsuarioResponsable="
				+ usuarioByIdUsuarioResponsable
				+ ", usuarioByIdUsuarioAsignado=" + usuarioByIdUsuarioAsignado
				+ ", descTipoEquipo=" + descTipoEquipo + ", marcaComputo="
				+ marcaComputo + ", modeloComputo=" + modeloComputo
				+ ", ubicacion=" + ubicacion + ", fechaCreacion="
				+ fechaCreacion + ", fechaActualizacion=" + fechaActualizacion
				+ ", indVigenciaEquipo=" + indVigenciaEquipo
				+ ", estadoEquipo=" + estadoEquipo + ", equipoValorCaracs="
				+ equipoValorCaracs.size() + ", reparacionEquipos="
				+ reparacionEquipos + "]";
	}
}