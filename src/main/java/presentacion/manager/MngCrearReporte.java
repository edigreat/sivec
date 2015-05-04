package presentacion.manager;

import java.util.*;

import dominio.EquipoComputo;
import dominio.ReparacionEquipo;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngCrearReporte {

    /**
     * 
     */
    public MngCrearReporte() {
    }

    /**
     * 
     */
    private Usuario usuario;

    /**
     * 
     */
    private List<ReparacionEquipo> reparacionEquipoList;

    /**
     * 
     */
    private List<EquipoComputo> equipoComputoList;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ReparacionEquipo> getReparacionEquipoList() {
		return reparacionEquipoList;
	}

	public void setReparacionEquipoList(List<ReparacionEquipo> reparacionEquipoList) {
		this.reparacionEquipoList = reparacionEquipoList;
	}

	public List<EquipoComputo> getEquipoComputoList() {
		return equipoComputoList;
	}

	public void setEquipoComputoList(List<EquipoComputo> equipoComputoList) {
		this.equipoComputoList = equipoComputoList;
	}

}