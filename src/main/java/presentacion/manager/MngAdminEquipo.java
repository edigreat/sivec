package presentacion.manager;

import java.util.*;

import dominio.EquipoComputo;

/**
 * @author Heriberto Galdamez
 */
public class MngAdminEquipo {

    /**
     * 
     */
    public MngAdminEquipo() {
    }

    /**
     * 
     */
    private List<EquipoComputo> equipoComputoList;

	public List<EquipoComputo> getEquipoComputoList() {
		return equipoComputoList;
	}

	public void setEquipoComputoList(List<EquipoComputo> equipoComputoList) {
		this.equipoComputoList = equipoComputoList;
	}

}