package GrupoX.AsignacionGrupos;


import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
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
	private String nombre;
	private Integer creditos;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="titulacion")
	private List<Asignatura> asignaturas;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="titulacion")
	private List<Expediente> expedientes;
	
	@ManyToMany
	@JoinTable(name="jnd_titulacion_centro",joinColumns=@JoinColumn(name="titulacion_fk"),
				inverseJoinColumns=@JoinColumn(name="centro_fk"))
	private List<Centro> centros;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="titulacion")
	private List<Grupo> grupos;
	
	public Titulacion() {
		super();
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
