package Entidades;
import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Asignaturas_matriculasPK implements Serializable{
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
}
