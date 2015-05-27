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
	 * UID a utilizar
	 */
	private static final long serialVersionUID = -7132602452963417708L;


	/**
     * Constructor publico
     */
    public MngCrearEquipoForm() {
    	 this.mngCaracteristicaEquipoList =  new ArrayList<MngCaracteristicaEquipo>();
    	 this.equipoComputo = new EquipoComputo();
    	 usuarioResponsable = new TagAutoCompleteUsuario();
    	 usuarioAsignado = new TagAutoCompleteUsuario();
    }

    TagAutoCompleteUsuario usuarioResponsable;
    TagAutoCompleteUsuario usuarioAsignado;
    
    
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

	public TagAutoCompleteUsuario getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(TagAutoCompleteUsuario usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public TagAutoCompleteUsuario getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(TagAutoCompleteUsuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
	

	
	
	

}