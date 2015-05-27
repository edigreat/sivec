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
     * Atributo que se utiliza
     * para generar la paginacion
     */
    int numTotalRegistros=0;
    
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
    public MngCrearReporte() {
    }

    public List<Integer>  getPageNumberList(){
    	List<Integer> pageNumberList=new ArrayList<>();
    	for(int i=this.firstPageNumber;i<this.lastPageNumber;i++){
    		pageNumberList.add(i+1);
    	}
    	return pageNumberList;
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

	public int getNumTotalRegistros() {
		return numTotalRegistros;
	}

	public void setNumTotalRegistros(int numTotalRegistros) {
		this.numTotalRegistros = numTotalRegistros;
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

}