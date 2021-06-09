package Entidades;
import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Asignaturas_matriculasPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3232555628239044225L;
	private MatriculaPK matricula;
	
	public Asignaturas_matriculasPK() {}
	
	public Asignaturas_matriculasPK(MatriculaPK e) {
		matricula = e;
	}

	public MatriculaPK getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaPK matricula) {
		this.matricula = matricula;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Asignaturas_matriculasPK other = (Asignaturas_matriculasPK) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas_matriculasPK [matricula=" + matricula + "]";
	}	
	
}
