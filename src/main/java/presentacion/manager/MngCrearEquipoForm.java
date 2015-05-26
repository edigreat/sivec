package presentacion.manager;

import java.io.Serializable;
import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import dominio.EquipoComputo;
import dominio.Usuario;


/**
 * @author Heriberto Galdamez
 */
public class MngCrearEquipoForm implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7132602452963417708L;


	/**
     * 
     */
    public MngCrearEquipoForm() {
    	 this.mngCaracteristicaEquipoList =  new ArrayList<MngCaracteristicaEquipo>();
    	 this.equipoComputo = new EquipoComputo();
    }

    private List<MngCaracteristicaEquipo> mngCaracteristicaEquipoList;
    @NotNull
    @Valid
    private EquipoComputo equipoComputo;
    private Usuario usuario;

	public List<MngCaracteristicaEquipo> getMngCaracteristicaEquipoList() {
		return mngCaracteristicaEquipoList;
	}

	public void setMngCaracteristicaEquipoList(
			List<MngCaracteristicaEquipo> mngCaracteristicaEquipoList) {
		this.mngCaracteristicaEquipoList = mngCaracteristicaEquipoList;
	}

	public EquipoComputo getEquipoComputo() {
		return equipoComputo;
	}

	public void setEquipoComputo(EquipoComputo equipoComputo) {
		this.equipoComputo = equipoComputo;
	}
    
	

	
	
	

}