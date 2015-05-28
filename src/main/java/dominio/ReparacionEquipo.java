/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: ReparacionEquipo.java
 * Autor: heriberto
 */
package dominio;

import static presentacion.manager.ConstantesPresentacion.FORMATO_FECHA;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entidad ReparacionEquipo
 * Clase que representa la reparacion de un equipo
 */

public class ReparacionEquipo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5248327679633298351L;
	private Integer idReparacionEquipo;
	private Usuario usuarioByIdUsuarioResponsable;
	private EquipoComputo equipoComputo;
	private Usuario usuarioByIdUsuarioAsignado;
	@NotNull
	@NotEmpty
	private String descReparacion;
	@NotNull
	@NotEmpty
	private String descMotivo;
	private Timestamp fechaCreacion;
	private Integer indVigenciaReparacion;

	
	public ReparacionEquipo() {
	}

	public ReparacionEquipo(Usuario usuarioByIdUsuarioResponsable,
			EquipoComputo equipoComputo, Usuario usuarioByIdUsuarioAsignado,
			String descReparacion, String descMotivo, String fechaCreacion) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.equipoComputo = equipoComputo;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.descReparacion = descReparacion;
		this.descMotivo = descMotivo;
		//this.fechaCreacion = fechaCreacion;
	}

	public ReparacionEquipo(Usuario usuarioByIdUsuarioResponsable,
			EquipoComputo equipoComputo, Usuario usuarioByIdUsuarioAsignado,
			String descReparacion, String descMotivo, String fechaCreacion,
			Integer indVigenciaReparacion) {
		this.usuarioByIdUsuarioResponsable = usuarioByIdUsuarioResponsable;
		this.equipoComputo = equipoComputo;
		this.usuarioByIdUsuarioAsignado = usuarioByIdUsuarioAsignado;
		this.descReparacion = descReparacion;
		this.descMotivo = descMotivo;
		//this.fechaCreacion = fechaCreacion;
		this.indVigenciaReparacion = indVigenciaReparacion;
	}

	public String getFechaRegistroFormato(){
   	 SimpleDateFormat simpleDateFormatFecha = 
   	            new SimpleDateFormat(FORMATO_FECHA,new Locale("es"));
   	 return simpleDateFormatFecha.format(this.fechaCreacion.getTime());
	}
	
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

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIndVigenciaReparacion() {
		return this.indVigenciaReparacion;
	}

	public void setIndVigenciaReparacion(Integer indVigenciaReparacion) {
		this.indVigenciaReparacion = indVigenciaReparacion;
	}

}