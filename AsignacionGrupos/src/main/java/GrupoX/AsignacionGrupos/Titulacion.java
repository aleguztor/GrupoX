package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Titulacion
 *
 */
@Entity

public class Titulacion implements Serializable {

	   
	@Id @GeneratedValue
	private Integer codigo;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private Integer creditos;
	private static final long serialVersionUID = 1L;
	@OneToMany (mappedBy = "titulacion")
	private List<Asignatura> asignaturas;
	@ManyToMany
	private List<Centro> centros;
	@OneToMany (mappedBy = "titulacion")
	private List<Expediente> expedientes;
	@OneToMany (mappedBy = "titulacion")
	private List<Grupo> grupos;
	
	public Titulacion() {}
	
	public Titulacion(String n, Integer c) {
		nombre = n;
		creditos = c;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	public Integer getCreditos() {
		return this.creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
	@Override
	public boolean equals(Object object) {
		if((object instanceof Titulacion)) {
			Titulacion t = (Titulacion) object;
			return ((codigo == t.codigo)  );
		}
		return false;
	}
	@Override
	public String toString() {
		return "GrupoX.AsignacionGrupos.Titulacion[codigo= " + codigo +"]";
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode();
	}
   
}
