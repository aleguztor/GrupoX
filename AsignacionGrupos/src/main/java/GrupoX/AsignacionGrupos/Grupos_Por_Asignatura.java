package GrupoX.AsignacionGrupos;
import java.util.List;
import javax.persistence.*;


@Entity
@IdClass(Grupos_Por_Asignatura.gpa_grupoId_asigRef.class)
public class Grupos_Por_Asignatura {
	public static class gpa_grupoId_asigRef{
		private String Curso_Academico;
		private Long gId;
		private String refAsig;
	}
	@Id
	private String Curso_Academico;
	private boolean Oferta;
	@ManyToMany(mappedBy = "encuestasGrupos")
	private List<Encuesta> gpa_encuesta;
	@Id
	@ManyToOne
	private Grupo grupo;
	@Id
	@ManyToOne
	private Asignatura asignatura;
	
	public Grupos_Por_Asignatura() {}
	
	public Grupos_Por_Asignatura(String ca) {
		Curso_Academico = ca;
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
	
	public List<Encuesta> getGpa_encuesta() {
		return gpa_encuesta;
	}

	public void setGpa_encuesta(List<Encuesta> gpa_encuesta) {
		this.gpa_encuesta = gpa_encuesta;
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
