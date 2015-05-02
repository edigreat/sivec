/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: DependenciaUniversitaria.java
 * Autor: heriberto
 */
package dominio;

/**
 * Entidad DependenciaUniversitaria. 
 */

public class DependenciaUniversitaria implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3839984637280883483L;
	private Integer idDependencia;
	private String descripcion;

	public DependenciaUniversitaria() {
	}

	public DependenciaUniversitaria(String descripcion) {
		this.descripcion = descripcion;
	}


	public Integer getIdDependencia() {
		return this.idDependencia;
	}

	public void setIdDependencia(Integer idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}