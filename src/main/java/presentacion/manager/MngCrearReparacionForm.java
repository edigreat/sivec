package presentacion.manager;

import java.util.*;

import javax.validation.Valid;

import dominio.EquipoComputo;
import dominio.ReparacionEquipo;
import dominio.Usuario;

/**
 * @author Heriberto Galdamez
 */
public class MngCrearReparacionForm {

    /**
     * 
     */
    public MngCrearReparacionForm() {
    	this.equipoComputo =  new EquipoComputo();
   	 	this.mngCaracteristicaEquipoList =  new ArrayList<MngCaracteristicaEquipo>();
   	 	this.usuarioResponsable = new TagAutoCompleteUsuario();
   	 	this.usuarioAsignado = new TagAutoCompleteUsuario();
   	 	this.reparacionEquipo =  new ReparacionEquipo();
    }

    private List<MngCaracteristicaEquipo> mngCaracteristicaEquipoList;

    TagAutoCompleteUsuario usuarioResponsable;
    TagAutoCompleteUsuario usuarioAsignado;
    
    /**
     * 
     */
    private EquipoComputo equipoComputo;

    /**
     * 
     */
    private Usuario usuario;

    /**
     *Propiedad de reparacion 
     */
    @Valid
    private ReparacionEquipo reparacionEquipo ;

    
    public String getNombreUsuarioAsignado(){
    	if(this.usuarioAsignado.tagName==null){
    		return "";
    	}
    	return this.usuarioAsignado.tagName.trim();
    }
    
    public void setNombreUsuarioAsignado(String nombreUsuarioAsignado ){
    	this.usuarioAsignado.tagName=nombreUsuarioAsignado;
    }
    
    public String getNombreUsuarioResponsable(){
    	if(this.usuarioResponsable.tagName==null){
    		return "";
    	}
    	return this.usuarioResponsable.tagName.trim();
    }
    
    public void setNombreUsuarioResponsable(String nombreUsuarioResponsable ){
    	this.usuarioResponsable.tagName=nombreUsuarioResponsable;
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

	public ReparacionEquipo getReparacionEquipo() {
		return reparacionEquipo;
	}

	public void setReparacionEquipo(ReparacionEquipo reparacionEquipo) {
		this.reparacionEquipo = reparacionEquipo;
	}

	public List<MngCaracteristicaEquipo> getMngCaracteristicaEquipoList() {
		return mngCaracteristicaEquipoList;
	}

	public void setMngCaracteristicaEquipoList(
			List<MngCaracteristicaEquipo> mngCaracteristicaEquipoList) {
		this.mngCaracteristicaEquipoList = mngCaracteristicaEquipoList;
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

}