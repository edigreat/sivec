package presentacion.manager;

import java.util.*;

import dominio.CaracteristicaEquipo;
import dominio.EquipoComputo;
import dominio.MenuRol;
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
    
    private Map<Integer,String> tipoCaracteristicaMap;


 
    private String tipoEquipoSeleccionado;
    
    private String paginaCaracteristica;
    
	public Integer getEquipoAsignado(){
		
		return 0;
	}

	public void setEquipoAsignado(Integer asignado){
		
	}

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

	

	

	public List<EquipoComputo> getEquipoComputoList() {
		return equipoComputoList;
	}

	public void setEquipoComputoList(List<EquipoComputo> equipoComputoList) {
		this.equipoComputoList = equipoComputoList;
	}

	public String getPaginaCaracteristica() {
		return paginaCaracteristica;
	}

	public void setPaginaCaracteristica(String paginaCaracteristica) {
		this.paginaCaracteristica = paginaCaracteristica;
	}

	public String getTipoEquipoSeleccionado() {
		return tipoEquipoSeleccionado;
	}

	public void setTipoEquipoSeleccionado(String tipoEquipoSeleccionado) {
		this.tipoEquipoSeleccionado = tipoEquipoSeleccionado;
	}

	public Map<Integer, String> getTipoCaracteristicaMap() {
		return tipoCaracteristicaMap;
	}

	public void setTipoCaracteristicaMap(Map<Integer, String> tipoCaracteristicaMap) {
		this.tipoCaracteristicaMap = tipoCaracteristicaMap;
	}

	

}