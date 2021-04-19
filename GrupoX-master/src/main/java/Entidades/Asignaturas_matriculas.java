package Entidades;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@IdClass(Entidades.Asignaturas_matriculas.Asignaturas_matriculas_PK.class)
public class Asignaturas_matriculas {
	
	public static class Asignaturas_matriculas_PK implements Serializable{
		@EmbeddedId
		private Asignaturas_matriculasPK am;
		private String asignatura;
		
		public Asignaturas_matriculas_PK() {}

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
		
		@Override
		public boolean equals(Object o) {
			if(o instanceof Asignaturas_matriculas_PK) {
				if(((Asignaturas_matriculas_PK) o).am.equals(am) && ((Asignaturas_matriculas_PK) o).asignatura.equals(asignatura)) {
					return true;
				}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return am.hashCode()+asignatura.hashCode();
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
	@ManyToOne
	private Matricula matricula;
	
	
	public Asignaturas_matriculas() {}


	
	
}
