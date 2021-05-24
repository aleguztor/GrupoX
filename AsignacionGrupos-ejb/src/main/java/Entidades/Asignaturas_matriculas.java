package Entidades;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@IdClass(Entidades.Asignaturas_matriculas.Asignaturas_matriculas_PK.class)
public class Asignaturas_matriculas {
	
	public static class Asignaturas_matriculas_PK implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 9147142761276590696L;
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
		public String toString() {
			return "Asignaturas_matriculas_PK [am=" + am + ", asignatura=" + asignatura + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((am == null) ? 0 : am.hashCode());
			result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
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
			Asignaturas_matriculas_PK other = (Asignaturas_matriculas_PK) obj;
			if (am == null) {
				if (other.am != null)
					return false;
			} else if (!am.equals(other.am))
				return false;
			if (asignatura == null) {
				if (other.asignatura != null)
					return false;
			} else if (!asignatura.equals(other.asignatura))
				return false;
			return true;
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


	public Asignaturas_matriculasPK getAm() {
		return am;
	}


	public void setAm(Asignaturas_matriculasPK am) {
		this.am = am;
	}


	public Asignatura getAsignatura() {
		return asignatura;
	}


	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}


	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((am == null) ? 0 : am.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Asignaturas_matriculas other = (Asignaturas_matriculas) obj;
		if (am == null) {
			if (other.am != null)
				return false;
		} else if (!am.equals(other.am))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Asignaturas_matriculas [am=" + am + ", asignatura=" + asignatura + ", grupo=" + grupo + ", matricula="
				+ matricula + "]";
	}


	
	
}
