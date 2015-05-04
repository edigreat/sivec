package presentacion.manager;

import java.util.*;

import dominio.EquipoComputo;
import dominio.ReparacionEquipo;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngCrearReparacion {

    /**
     * 
     */
    public MngCrearReparacion() {
    }

    /**
     * 
     */
    private EquipoComputo equipoComputo;

    /**
     * 
     */
    private Usuario usuario;

    /**
     * 
     */
    private ReparacionEquipo reparacionEquipo ;

	public EquipoComputo getEquipoComputo() {
		return equipoComputo;
	}

	public void setEquipoComputo(EquipoComputo equipoComputo) {
		this.equipoComputo = equipoComputo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ReparacionEquipo getReparacionEquipo() {
		return reparacionEquipo;
	}

	public void setReparacionEquipo(ReparacionEquipo reparacionEquipo) {
		this.reparacionEquipo = reparacionEquipo;
	}

}