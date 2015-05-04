package presentacion.manager;

import java.util.*;

import dominio.CaracteristicaEquipo;
import dominio.EquipoComputo;
import dominio.TipoEquipoComputo;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngCrearEquipo {

    /**
     * 
     */
    public MngCrearEquipo() {
    }

    private List<EquipoComputo> equipoComputoList;
    
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
    private List<TipoEquipoComputo> tipoEquipoComputo;

    /**
     * 
     */
    private List<CaracteristicaEquipo> propiedadesEquipo;

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

	public List<TipoEquipoComputo> getTipoEquipoComputo() {
		return tipoEquipoComputo;
	}

	public void setTipoEquipoComputo(List<TipoEquipoComputo> tipoEquipoComputo) {
		this.tipoEquipoComputo = tipoEquipoComputo;
	}

	public List<CaracteristicaEquipo> getPropiedadesEquipo() {
		return propiedadesEquipo;
	}

	public void setPropiedadesEquipo(List<CaracteristicaEquipo> propiedadesEquipo) {
		this.propiedadesEquipo = propiedadesEquipo;
	}

	public List<EquipoComputo> getEquipoComputoList() {
		return equipoComputoList;
	}

	public void setEquipoComputoList(List<EquipoComputo> equipoComputoList) {
		this.equipoComputoList = equipoComputoList;
	}

}