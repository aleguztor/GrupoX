package Entidades;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@IdClass(Grupos_Por_Asignatura.Grupos_Por_Asignatura_PK.class)
public class Grupos_Por_Asignatura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4048381271054926555L;

	public static class Grupos_Por_Asignatura_PK implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7704113819650465481L;
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

		public String getCurso_Academico() {
			return Curso_Academico;
		}

		public void setCurso_Academico(String curso_Academico) {
			Curso_Academico = curso_Academico;
		}

		public Long getGrupo() {
			return grupo;
		}

		public void setGrupo(Long grupo) {
			this.grupo = grupo;
		}

		public String getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
			result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
			result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
			Grupos_Por_Asignatura_PK other = (Grupos_Por_Asignatura_PK) obj;
			if (Curso_Academico == null) {
				if (other.Curso_Academico != null)
					return false;
			} else if (!Curso_Academico.equals(other.Curso_Academico))
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
			return true;
		}

		@Override
		public String toString() {
			return "Grupos_Por_Asignatura_PK [Curso_Academico=" + Curso_Academico + ", grupo=" + grupo + ", asignatura="
					+ asignatura + "]";
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		Grupos_Por_Asignatura other = (Grupos_Por_Asignatura) obj;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
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
		return true;
	}

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
	public String toString() {
		return "Grupos_Por_Asignatura [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta + ", grupo=" + grupo
				+ ", asignatura=" + asignatura + "]";
	}

	

	
}
