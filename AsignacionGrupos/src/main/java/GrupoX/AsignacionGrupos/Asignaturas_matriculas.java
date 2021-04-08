package GrupoX.AsignacionGrupos;
import javax.persistence.*;

@Entity
@IdClass(GrupoX.AsignacionGrupos.Asignaturas_matriculas.Asignaturas_matriculas_PK.class)
public class Asignaturas_matriculas {
	
	public static class Asignaturas_matriculas_PK{
		@EmbeddedId
		private Asignaturas_matriculasPK am;
		private String asignatura;
		
		private Asignaturas_matriculas_PK() {}

		public Asignaturas_matriculasPK getAm() {
			return am;
		}

		public void setAm(Asignaturas_matriculasPK am) {
			this.am = am;
		}

		public String getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}
		
	}
	@Id
	private Asignaturas_matriculasPK am;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Referencia")
	private Asignatura asignatura;
	@ManyToOne
	private Grupo grupo;
	
	
	public Asignaturas_matriculas() {}


	
	
}
