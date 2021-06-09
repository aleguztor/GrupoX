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
	   
	/**
	 * 
	 */
	private static final long serialVersionUID = 5977597351027478889L;
	
	@Id
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
	private Long PlazasNuevoIngreso = (long)0;
	private Long PlazasRepetidores = (long)0;
	private boolean idiomaIngles;
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
	@ManyToMany
	private List<Alumno> alumno;
	
	
	

	public Grupo() {
	}
	
	public Grupo(Long id, String c, String l, String t) {
		Id = id;
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
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public List<Alumno> getAlumno() {
		return alumno;
	}

	public void setAlumno(List<Alumno> alumno) {
		this.alumno = alumno;
	}
	public Long getPlazasNuevoIngreso() {
		return PlazasNuevoIngreso;
	}

	public void setPlazasNuevoIngreso(Long plazasNuevoIngreso) {
		PlazasNuevoIngreso = plazasNuevoIngreso;
		Plazas = PlazasNuevoIngreso + PlazasRepetidores;
	}

	public Long getPlazasRepetidores() {
		return PlazasRepetidores;
	}

	public void setPlazasRepetidores(Long plazasRepetidores) {
		PlazasRepetidores = plazasRepetidores;
		Plazas = PlazasNuevoIngreso + PlazasRepetidores;
	}
	
	
	public boolean isIdiomaIngles() {
		return idiomaIngles;
	}

	public void setIdiomaIngles(boolean idiomaIngles) {
		this.idiomaIngles = idiomaIngles;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<Asignaturas_matriculas> getAm() {
		return am;
	}

	public void setAm(List<Asignaturas_matriculas> am) {
		this.am = am;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [Id=" + Id + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno_manyana_tarde="
				+ Turno_manyana_tarde + "]";
	}

	

	
}
