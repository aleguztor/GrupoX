package Entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Centro implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id 
	private Long ID;
	@Column(nullable=false, unique = true)
	private String Nombre;
	@Column(nullable=false)
	private String Direccion;
	@Column(nullable=true)
	private int TLF_Conserjeria;
	@ManyToMany (mappedBy = "centros")
	private List<Titulacion> titulaciones;
	
	public Centro() {}
	
	public Centro(Long iD, String nombre, String direccion, int tLF_Conserjeria) {
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
	public int getTLF_Conserjeria() {
		return TLF_Conserjeria;
	}
	public void setTLF_Conserjeria(int tLF_Conserjeria) {
		TLF_Conserjeria = tLF_Conserjeria;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + TLF_Conserjeria;
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
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (TLF_Conserjeria != other.TLF_Conserjeria)
			return false;
		return true;
	}
	
	
}
