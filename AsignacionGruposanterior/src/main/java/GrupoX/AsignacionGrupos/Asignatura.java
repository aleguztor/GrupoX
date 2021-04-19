package GrupoX.AsignacionGrupos;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="OPTATIVA", discriminatorType = DiscriminatorType.CHAR)
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

	@Override
	public boolean equals(Object o) {
		if(o instanceof Asignatura) {
			if(((Asignatura) o).Referencia.equals(Referencia) && ((Asignatura) o).Codigo == Codigo && ((Asignatura) o).Creditos == Creditos
					&& ((Asignatura) o).Idioma_de_imparticion == Idioma_de_imparticion && ((Asignatura) o).Ofertada == Ofertada){
						return true;
					}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Referencia.hashCode()+Codigo+Nombre.hashCode()+Creditos;
	}
	
}
