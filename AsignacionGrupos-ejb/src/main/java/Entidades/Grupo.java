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
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		result = prime * result + ((Asignar == null) ? 0 : Asignar.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((Ingles == null) ? 0 : Ingles.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((PlazasNuevoIngreso == null) ? 0 : PlazasNuevoIngreso.hashCode());
		result = prime * result + ((PlazasRepetidores == null) ? 0 : PlazasRepetidores.hashCode());
		result = prime * result + ((Turno_manyana_tarde == null) ? 0 : Turno_manyana_tarde.hashCode());
		result = prime * result + ((Visible == null) ? 0 : Visible.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((am == null) ? 0 : am.hashCode());
		result = prime * result + ((clases == null) ? 0 : clases.hashCode());
		result = prime * result + ((gpa == null) ? 0 : gpa.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + (idiomaIngles ? 1231 : 1237);
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
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
		if (Asignar == null) {
			if (other.Asignar != null)
				return false;
		} else if (!Asignar.equals(other.Asignar))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (Ingles == null) {
			if (other.Ingles != null)
				return false;
		} else if (!Ingles.equals(other.Ingles))
			return false;
		if (Letra == null) {
			if (other.Letra != null)
				return false;
		} else if (!Letra.equals(other.Letra))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (PlazasNuevoIngreso == null) {
			if (other.PlazasNuevoIngreso != null)
				return false;
		} else if (!PlazasNuevoIngreso.equals(other.PlazasNuevoIngreso))
			return false;
		if (PlazasRepetidores == null) {
			if (other.PlazasRepetidores != null)
				return false;
		} else if (!PlazasRepetidores.equals(other.PlazasRepetidores))
			return false;
		if (Turno_manyana_tarde == null) {
			if (other.Turno_manyana_tarde != null)
				return false;
		} else if (!Turno_manyana_tarde.equals(other.Turno_manyana_tarde))
			return false;
		if (Visible == null) {
			if (other.Visible != null)
				return false;
		} else if (!Visible.equals(other.Visible))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (am == null) {
			if (other.am != null)
				return false;
		} else if (!am.equals(other.am))
			return false;
		if (clases == null) {
			if (other.clases != null)
				return false;
		} else if (!clases.equals(other.clases))
			return false;
		if (gpa == null) {
			if (other.gpa != null)
				return false;
		} else if (!gpa.equals(other.gpa))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (idiomaIngles != other.idiomaIngles)
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo [Id=" + Id + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno_manyana_tarde="
				+ Turno_manyana_tarde + ", Ingles=" + Ingles + ", Visible=" + Visible + ", Asignar=" + Asignar
				+ ", Plazas=" + Plazas + ", PlazasNuevoIngreso=" + PlazasNuevoIngreso + ", PlazasRepetidores="
				+ PlazasRepetidores + ", idiomaIngles=" + idiomaIngles + ", gpa=" + gpa + ", titulacion=" + titulacion
				+ ", clases=" + clases + ", grupos=" + grupos + ", grupo=" + grupo + ", am=" + am + ", alumno=" + alumno
				+ "]";
	}

	
}
