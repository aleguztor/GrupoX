package Entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Centro implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6457694112055166402L;
	@Id 
	private Long ID;
	@Column(nullable=false, unique = true)
	private String Nombre;
	@Column(nullable=false)
	private String Direccion;
	@Column(nullable=true)
	private String TLF_Conserjeria;
	@ManyToMany (mappedBy = "centros")
	private List<Titulacion> titulaciones;
	
	public Centro() {}
	
	public Centro(Long iD, String nombre, String direccion, String tLF_Conserjeria) {
		ID = iD;
		Nombre = nombre;
		Direccion = direccion;
		TLF_Conserjeria = tLF_Conserjeria;
	}
	
	
	public Long getID() {
		return ID;
	}
	
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTLF_Conserjeria() {
		return TLF_Conserjeria;
	}
	public void setTLF_Conserjeria(String tLF_Conserjeria) {
		TLF_Conserjeria = tLF_Conserjeria;
	}
	
	
	public List<Titulacion> getTitulaciones() {
		return titulaciones;
	}

	public void setTitulaciones(List<Titulacion> titulaciones) {
		this.titulaciones = titulaciones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centro other = (Centro) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Centro [ID=" + ID + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", TLF_Conserjeria="
				+ TLF_Conserjeria + "]";
	}

	


	
	
}
