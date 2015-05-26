package presentacion.manager;

public interface ConstantesPresentacion {
	/**
	 * Tamanio de la paginacion
	 */
	int MAX_ROWS=5;
	
	/**
	 * Tamanio del numero maximo de
	 * caracterisitcas por equipos
	 */
	int MAX_CARACTERISTICA_EQUIPO=5;
	
	/**
	 * Estados de los equipos
	 */
	String 	EQUIPO_REGISTRADO="REGISTRADO";
	String  EQUIPO_ASIGNADO="ASIGNADO";
	String  EQUIPO_REPARACION="REPARACION";
	
	//Nombre de los beans de sesion
	String SESSION_TIPOS_EQUIPOS_COMPUTO="tipoEquipoComputoMap";
}
