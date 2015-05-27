/**
 * UNAM - MCC 
 * Proyecto Final  TOO	
 * Nombre: TagAutoCompleteUsuario.java
 * Autor: heriberto
 */
package presentacion.manager;

/**
 * @author heriberto
 *
 */
public class TagAutoCompleteUsuario {
	public String id;
	
	
	public String tagName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public TagAutoCompleteUsuario(String id, String tagName) {
		this.id = id;
		this.tagName = tagName;
	}
	public TagAutoCompleteUsuario() {
		
	}

	@Override
	public String toString() {
		return "TagAutoCompleteUsuario [id=" + id + ", tagName=" + tagName
				+ "]";
	}
}
