package Entidades;

import java.io.Serializable;
import java.util.List;

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
	@Column(nullable = false)
	private String Curso;
	@Column(nullable = false)
	private String Letra;
	@Column(nullable = false)
	private String Turno_manyana_tarde;
	private String Ingles;
	private String Visible;
	private String Asignar;
	private Long Plazas;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy = "grupo")
	private List<Grupos_Por_Asignatura> gpa;
	@ManyToOne
	private Titulacion titulacion;
	@OneToMany (mappedBy = "grupo")
	private List<Clase> clases;
	@OneToMany(mappedBy = "grupo")
	private List<Grupo> grupos;
	@ManyToOne
	private Grupo grupo;
	@OneToMany(mappedBy="grupo")
	private List<Asignaturas_matriculas> am;
	@ManyToOne
	private Alumno alumno;
	
	public Grupo() {}
	
	public Grupo(String c, String l, String t) {
		Curso = c;
		Letra = l;
		Turno_manyana_tarde = t;
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
	public List<Grupos_Por_Asignatura> getGpa() {
		return gpa;
	}
	public void setGpa(List<Grupos_Por_Asignatura> gpa) {
		this.gpa = gpa;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alum) {
		this.alumno=alum;
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Grupo) {
			if(((Grupo) o).Id.equals(Id) && ((Grupo) o).Asignar.equals(Asignar) && ((Grupo) o).clases.equals(clases)
					&& ((Grupo) o).Curso.equals(Curso)&& ((Grupo) o).Letra.equals(Letra) && ((Grupo)o).Ingles.equals(Ingles) && ((Grupo)o).Turno_manyana_tarde.equals(Turno_manyana_tarde)
					&& ((Grupo)o).Visible.equals(Visible) && ((Grupo) o).Plazas.equals(Plazas)){
						return true;
					}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Id.hashCode() ;
	}
   
}
