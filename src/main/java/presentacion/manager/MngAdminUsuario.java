package presentacion.manager;

import java.util.*;

import org.h2.engine.SysProperties;

import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngAdminUsuario {

    /**
     * Constructor Privado
     */
    public MngAdminUsuario() {
    }

    /**
     * Atributo que se utiliza
     * para generar la paginacion
     */
    int numTotalUsuarios=0;
    
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
     * Lista de usuario
     */
    private List<Usuario> usuarioList;

    
    public List<Integer>  getPageNumberList(){
    	List<Integer> pageNumberList=new ArrayList<>();
    	for(int i=this.firstPageNumber;i<this.lastPageNumber;i++){
    		pageNumberList.add(i+1);
    	}
    	return pageNumberList;
    }
    
    
	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}

	public int getNumTotalUsuarios() {
		return numTotalUsuarios;
	}

	public void setNumTotalUsuarios(int numTotalUsuarios) {
		this.numTotalUsuarios = numTotalUsuarios;
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

	@Override
	public String toString() {
		return "MngAdminUsuario [numTotalUsuarios=" + numTotalUsuarios
				+ ", lastPageNumber=" + lastPageNumber + ", firstPageNumber="
				+ firstPageNumber + ", usuarioList=" + usuarioList + "]";
	}

	

}