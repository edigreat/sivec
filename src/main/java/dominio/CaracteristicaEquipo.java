package dominio;

import java.util.HashSet;
import java.util.Set;

/**
 * CaracteristicaEquipo entity. @author MyEclipse Persistence Tools
 */

public class CaracteristicaEquipo implements java.io.Serializable {

	// Fields

	private Integer idCaractaristicaEquipo;
	private String etiquetaCaracteristica;
	private String descCaracteristica;
	private Set tipoEquipoComputos = new HashSet(0);

	// Constructors

	/** default constructor */
	public CaracteristicaEquipo() {
	}

	/** minimal constructor */
	public CaracteristicaEquipo(String etiquetaCaracteristica,
			String descCaracteristica) {
		this.etiquetaCaracteristica = etiquetaCaracteristica;
		this.descCaracteristica = descCaracteristica;
	}

	/** full constructor */
	public CaracteristicaEquipo(String etiquetaCaracteristica,
			String descCaracteristica, Set tipoEquipoComputos) {
		this.etiquetaCaracteristica = etiquetaCaracteristica;
		this.descCaracteristica = descCaracteristica;
		this.tipoEquipoComputos = tipoEquipoComputos;
	}

	// Property accessors

	public Integer getIdCaractaristicaEquipo() {
		return this.idCaractaristicaEquipo;
	}

	public void setIdCaractaristicaEquipo(Integer idCaractaristicaEquipo) {
		this.idCaractaristicaEquipo = idCaractaristicaEquipo;
	}

	public String getEtiquetaCaracteristica() {
		return this.etiquetaCaracteristica;
	}

	public void setEtiquetaCaracteristica(String etiquetaCaracteristica) {
		this.etiquetaCaracteristica = etiquetaCaracteristica;
	}

	public String getDescCaracteristica() {
		return this.descCaracteristica;
	}

	public void setDescCaracteristica(String descCaracteristica) {
		this.descCaracteristica = descCaracteristica;
	}

	public Set getTipoEquipoComputos() {
		return this.tipoEquipoComputos;
	}

	public void setTipoEquipoComputos(Set tipoEquipoComputos) {
		this.tipoEquipoComputos = tipoEquipoComputos;
	}

}