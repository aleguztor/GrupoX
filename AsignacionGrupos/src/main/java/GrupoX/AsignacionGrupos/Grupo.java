package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long Id;
	private String Curso;
	private String Letra;
	private String Turno_manyana_tarde;
	private String Ingles;
	private String Visible;
	private String Asignar;
	private Long Plazas;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "grupo")
	private Grupos_Por_Asignatura gpa;
	
	@ManyToOne
	private Titulacion titulacion;
	
	public Grupo() {
		super();
	}   
	public Long getId() {
		return this.Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}   
	public String getCurso() {
		return this.Curso;
	}

	public void setCurso(String Curso) {
		this.Curso = Curso;
	}   
	public String getLetra() {
		return this.Letra;
	}

	public void setLetra(String Letra) {
		this.Letra = Letra;
	}   
	public String getTurno_manyana_tarde() {
		return this.Turno_manyana_tarde;
	}

	public void setTurno_manyana_tarde(String Turno_manyana_tarde) {
		this.Turno_manyana_tarde = Turno_manyana_tarde;
	}   
	public String getIngles() {
		return this.Ingles;
	}

	public void setIngles(String Ingles) {
		this.Ingles = Ingles;
	}   
	public String getVisible() {
		return this.Visible;
	}

	public void setVisible(String Visible) {
		this.Visible = Visible;
	}   
	public String getAsignar() {
		return this.Asignar;
	}

	public void setAsignar(String Asignar) {
		this.Asignar = Asignar;
	}   
	public Long getPlazas() {
		return this.Plazas;
	}

	public void setPlazas(Long Plazas) {
		this.Plazas = Plazas;
	}
	public Grupos_Por_Asignatura getGpa() {
		return gpa;
	}
	public void setGpa(Grupos_Por_Asignatura gpa) {
		this.gpa = gpa;
	}
	@Override
	public boolean equals(Object object) {
		if((object instanceof Grupo )) {
			Grupo ma = (Grupo) object;
			return ((this.Id == ma.Id));
		}
		return false;
	}
	@Override
	public String toString() {
		return "GrupoX.AsignacionGrupos.Grupo[Id" + Id +",";
	}
	
	@Override
	public int hashCode() {
		return Id.hashCode();
   }
}
