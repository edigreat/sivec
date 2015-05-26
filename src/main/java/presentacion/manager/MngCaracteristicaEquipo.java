/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: MngCaracteristicaEquipo.java
 * Autor: heriberto
 */
package presentacion.manager;

import java.io.Serializable;


/**
 * @author heriberto
 *
 */
public class MngCaracteristicaEquipo  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5223738846820767979L;
	
	private Integer idEquipoValCarac;
	private String descripcionCaract;
	private String valorCaract;
	public Integer getIdEquipoValCarac() {
		return idEquipoValCarac;
	}
	public void setIdEquipoValCarac(Integer idEquipoValCarac) {
		this.idEquipoValCarac = idEquipoValCarac;
	}
	public String getDescripcionCaract() {
		return descripcionCaract;
	}
	public void setDescripcionCaract(String descripcionCaract) {
		this.descripcionCaract = descripcionCaract;
	}
	public String getValorCaract() {
		return valorCaract;
	}
	public void setValorCaract(String valorCaract) {
		this.valorCaract = valorCaract;
	}
	@Override
	public String toString() {
		return "MngCaracteristicaEquipo [idEquipoValCarac=" + idEquipoValCarac
				+ ", descripcionCaract=" + descripcionCaract + ", valorCaract="
				+ valorCaract + "]";
	}
}
