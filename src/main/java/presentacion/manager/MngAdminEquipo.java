package presentacion.manager;

import java.util.*;

import dominio.EquipoComputo;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngAdminEquipo {

	private boolean hasError=false;
	private String descripcionError="";
	 /**
     * Atributo que se utiliza
     * para generar la paginacion
     */
    int numTotalEquipos=0;
    
    /**
     * Atributo que se utiliza
     * para navegar hacia la ultima 
     * pagina
     */
    int lastPageNumber=0;
    
    /**
     * Atributo que se utiliza
     * para navegar hacia la primera
     * pagina
     */
    int firstPageNumber=0;
    /**
     * 
     */
    public MngAdminEquipo() {
    }

    private Usuario usuario;
    
    /**
     * 
     */
    private List<EquipoComputo> equipoComputoList;

    public List<Integer>  getPageNumberList(){
    	List<Integer> pageNumberList=new ArrayList<>();
    	for(int i=this.firstPageNumber;i<this.lastPageNumber;i++){
    		pageNumberList.add(i+1);
    	}
    	return pageNumberList;
    }
    
	public List<EquipoComputo> getEquipoComputoList() {
		return equipoComputoList;
	}

	public void setEquipoComputoList(List<EquipoComputo> equipoComputoList) {
		this.equipoComputoList = equipoComputoList;
	}

	public int getNumTotalEquipos() {
		return numTotalEquipos;
	}

	public void setNumTotalEquipos(int numTotalEquipos) {
		this.numTotalEquipos = numTotalEquipos;
	}

	public int getLastPageNumber() {
		return lastPageNumber;
	}

	public void setLastPageNumber(int lastPageNumber) {
		this.lastPageNumber = lastPageNumber;
	}

	public int getFirstPageNumber() {
		return firstPageNumber;
	}

	public void setFirstPageNumber(int firstPageNumber) {
		this.firstPageNumber = firstPageNumber;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

}