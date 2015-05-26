/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: TipoEquipoComputo.java
 * Autor: heriberto
 */
package dominio;

import java.util.HashSet;
import java.util.Set;

/**
 * Entidad TipoEquipoComputo
 * Clase que representa el tipo de equipo de computo
 */

public class TipoEquipoComputo implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4391616175607161711L;
	private Integer idTipoEquipoComputo;
	private String etiquetaTipoEquipo;
	private String descTipoEquipo;
	private Integer valorCaracteristica;
	private Set equipoComputos = new HashSet(0);
	private Set caracteristicaEquipos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoEquipoComputo() {
	}

	/** minimal constructor */
	public TipoEquipoComputo(String etiquetaTipoEquipo) {
		this.etiquetaTipoEquipo = etiquetaTipoEquipo;
	}

	/** full constructor */
	public TipoEquipoComputo(String etiquetaTipoEquipo, String descTipoEquipo,
			Set equipoComputos, Set caracteristicaEquipos) {
		this.etiquetaTipoEquipo = etiquetaTipoEquipo;
		this.descTipoEquipo = descTipoEquipo;
		this.equipoComputos = equipoComputos;
		this.caracteristicaEquipos = caracteristicaEquipos;
	}

	// Property accessors

	public Integer getIdTipoEquipoComputo() {
		return this.idTipoEquipoComputo;
	}

	public void setIdTipoEquipoComputo(Integer idTipoEquipoComputo) {
		this.idTipoEquipoComputo = idTipoEquipoComputo;
	}

	public String getEtiquetaTipoEquipo() {
		return this.etiquetaTipoEquipo;
	}

	public void setEtiquetaTipoEquipo(String etiquetaTipoEquipo) {
		this.etiquetaTipoEquipo = etiquetaTipoEquipo;
	}

	public String getDescTipoEquipo() {
		return this.descTipoEquipo;
	}

	public void setDescTipoEquipo(String descTipoEquipo) {
		this.descTipoEquipo = descTipoEquipo;
	}

	public Set getEquipoComputos() {
		return this.equipoComputos;
	}

	public void setEquipoComputos(Set equipoComputos) {
		this.equipoComputos = equipoComputos;
	}

	public Set getCaracteristicaEquipos() {
		return this.caracteristicaEquipos;
	}

	public void setCaracteristicaEquipos(Set caracteristicaEquipos) {
		this.caracteristicaEquipos = caracteristicaEquipos;
	}

	public Integer getValorCaracteristica() {
		return valorCaracteristica;
	}

	public void setValorCaracteristica(Integer valorCaracteristica) {
		this.valorCaracteristica = valorCaracteristica;
	}

	

}