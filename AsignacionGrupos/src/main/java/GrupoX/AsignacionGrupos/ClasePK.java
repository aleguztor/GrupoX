package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.lang.String;

/**
 * ID class for entity: Clase
 *
 */ 
public class ClasePK  implements Serializable {   
   
	         
	private String Dia;
	private static final long serialVersionUID = 1L;

	public ClasePK() {}

	

	public String getDia() {
		return this.Dia;
	}

	public void setDia(String Dia) {
		this.Dia = Dia;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ClasePK)) {
			return false;
		}
		ClasePK other = (ClasePK) o;
		return true
			&& (getDia() == null ? other.getDia() == null : getDia().equals(other.getDia()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getDia() == null ? 0 : getDia().hashCode());
		return result;
	}
   
   
}
