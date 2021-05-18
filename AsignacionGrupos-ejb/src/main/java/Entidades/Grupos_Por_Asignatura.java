package Entidades;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@IdClass(Grupos_Por_Asignatura.Grupos_Por_Asignatura_PK.class)
public class Grupos_Por_Asignatura implements Serializable {
	public static class Grupos_Por_Asignatura_PK implements Serializable {
		@Column(nullable = false)
		private String Curso_Academico;
		@Column(nullable = false)
		private Long grupo;
		@Column(nullable = false)
		private String asignatura;
		
		public Grupos_Por_Asignatura_PK() {}
		
		public Grupos_Por_Asignatura_PK(String ca, String a, Long g) {
			Curso_Academico = ca;
			grupo = g;
			asignatura = a;
		}
		@Override
		public boolean equals(Object o) {
			if(o instanceof Grupos_Por_Asignatura_PK) {
				if(((Grupos_Por_Asignatura_PK) o).asignatura.equals(asignatura) && ((Grupos_Por_Asignatura_PK)o).Curso_Academico.equals(Curso_Academico) && ((Grupos_Por_Asignatura_PK) o).grupo.equals(grupo)) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return asignatura.hashCode() + grupo.hashCode() + Curso_Academico.hashCode();
		}
		
	}
	@Id
	private String Curso_Academico;
	private boolean Oferta;
	@ManyToMany(mappedBy="gpa")
	private List<Encuesta> encuestas;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Id")
	private Grupo grupo;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Referencia")
	private Asignatura asignatura;
	
	public Grupos_Por_Asignatura() {}
	
	public Grupos_Por_Asignatura(String c, Grupo g, Asignatura a) {
		grupo = g;
		asignatura = a;
		Curso_Academico = c;
	}
	

	public String getCurso_Academico() {
		return Curso_Academico;
	}

	public void setCurso_Academico(String curso_Academico) {
		Curso_Academico = curso_Academico;
	}

	public boolean getOferta() {
		return Oferta;
	}

	public void setOferta(boolean oferta) {
		Oferta = oferta;
	}
	
	public List<Encuesta> getEncuestas() {
		return encuestas;
	}

	public void setEncuestas(List<Encuesta> encuestas) {
		this.encuestas = encuestas;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Grupos_Por_Asignatura) {
			if(((Grupos_Por_Asignatura) o).Curso_Academico.equals(Curso_Academico)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Curso_Academico.hashCode();
	}
}
