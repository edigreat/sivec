/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: EquipoValorCarac.java
 * Autor: heriberto
 */
package dominio;

/**
 * @author heriberto
 *
 */
public class EquipoValorCarac  implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3477274073411455862L;
	private Integer idEquipoValCarac;
	private EquipoComputo equipoComputo;
	private String descripcionCaract;
	private String valorCaract;

	// Constructors

	/** default constructor */
	public EquipoValorCarac() {
	 this.idEquipoValCarac=0;
	 descripcionCaract=" ";
	 valorCaract=" ";
	}
	
	/** default constructor */
	public EquipoValorCarac(String descripcionCaract, String valorCaract) {
	 this.descripcionCaract=descripcionCaract;
	 this.valorCaract=valorCaract;
	}
	

	

	/** full constructor */
	public EquipoValorCarac(EquipoComputo equipoComputo,
			String descripcionCaract, String valorCaract) {
		this.equipoComputo = equipoComputo;
		this.descripcionCaract = descripcionCaract;
		this.valorCaract = valorCaract;
	}

	// Property accessors

	public Integer getIdEquipoValCarac() {
		return this.idEquipoValCarac;
	}

	public void setIdEquipoValCarac(Integer idEquipoValCarac) {
		this.idEquipoValCarac = idEquipoValCarac;
	}

	public EquipoComputo getEquipoComputo() {
		return this.equipoComputo;
	}

	public void setEquipoComputo(EquipoComputo equipoComputo) {
		this.equipoComputo = equipoComputo;
	}

	public String getDescripcionCaract() {
		return this.descripcionCaract;
	}

	public void setDescripcionCaract(String descripcionCaract) {
		this.descripcionCaract = descripcionCaract;
	}

	public String getValorCaract() {
		return this.valorCaract;
	}

	public void setValorCaract(String valorCaract) {
		this.valorCaract = valorCaract;
	}




	@Override
	public String toString() {
		return "EquipoValorCarac [idEquipoValCarac=" + idEquipoValCarac
				+ ", descripcionCaract=" + descripcionCaract + ", valorCaract="
				+ valorCaract + "]";
	}

}