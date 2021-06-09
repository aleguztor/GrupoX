package Entidades;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OPTATIVA", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("A")
public class Asignatura {
	@Id
	private String Referencia;
	@Column(nullable = false)
	private int Codigo;
	@Column(nullable = false)
	private int Creditos;
	@Column(nullable = false)
	private boolean Ofertada;
	@Column(nullable = false)
	private String Nombre;
	private String Curso;
	private String Caracter;
	private int Duracion;
	private int Unidad_Temporal;
	@Column(nullable = false)
	private boolean Idioma_de_imparticion;
	@OneToMany(mappedBy = "asignatura")
	private List<Grupos_Por_Asignatura> gpa;
	@OneToMany (mappedBy = "asignatura")
	private List<Clase> clases;
	@ManyToOne
	private Titulacion titulacion;
	@OneToMany(mappedBy="asignatura")
	private List<Asignaturas_matriculas> am;
	
	public Asignatura() {}
	
	public Asignatura(String r, String n, int c, int cred, boolean of, boolean idimp) {
		Referencia = r;
		Codigo = c;
		Creditos = cred;
		Nombre = n;
		Ofertada = of;
		Idioma_de_imparticion = idimp;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public int getCreditos() {
		return Creditos;
	}

	public void setCreditos(int creditos) {
		Creditos = creditos;
	}

	public boolean isOfertada() {
		return Ofertada;
	}

	public void setOfertada(boolean ofertada) {
		Ofertada = ofertada;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getCaracter() {
		return Caracter;
	}

	public void setCaracter(String caracter) {
		Caracter = caracter;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}

	public int getUnidad_Temporal() {
		return Unidad_Temporal;
	}

	public void setUnidad_Temporal(int unidad_Temporal) {
		Unidad_Temporal = unidad_Temporal;
	}

	public boolean isIdioma_de_imparticion() {
		return Idioma_de_imparticion;
	}

	public void setIdioma_de_imparticion(boolean idioma_de_imparticion) {
		Idioma_de_imparticion = idioma_de_imparticion;
	}
	
	public List<Grupos_Por_Asignatura> getGpa() {
		return gpa;
	}

	public void setGpa(List<Grupos_Por_Asignatura> gpa) {
		this.gpa = gpa;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
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
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
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
		Asignatura other = (Asignatura) obj;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Creditos=" + Creditos + ", Ofertada="
				+ Ofertada + ", Nombre=" + Nombre + ", Idioma_de_imparticion=" + Idioma_de_imparticion + "]";
	}

	
	
	
}
