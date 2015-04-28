package dominio;

/**
 * DependenciaUniversitaria entity. @author MyEclipse Persistence Tools
 */

public class DependenciaUniversitaria implements java.io.Serializable {

	// Fields

	private Integer idDependencia;
	private String descripcion;

	// Constructors

	/** default constructor */
	public DependenciaUniversitaria() {
	}

	/** full constructor */
	public DependenciaUniversitaria(String descripcion) {
		this.descripcion = descripcion;
	}

	// Property accessors

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