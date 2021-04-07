package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Centro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	public Long ID;
	@Column(nullable=false, unique = true)
	public String Nombre;
	@Column(nullable=false)
	public String Direccion;
	@Column(nullable=true)
	public int TLF_Conserjeria;
	
	@ManyToMany(mappedBy="centros")
	private List<Titulacion> titulaciones;
	
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
	public boolean equals(Object object) {
		if((object instanceof Centro)) {
			Centro obj = (Centro) object;
			return ((ID == obj.ID));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ID.hashCode();
	}
	
	
}
