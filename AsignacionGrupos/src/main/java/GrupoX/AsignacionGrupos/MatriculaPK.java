package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.lang.Integer;

/**
 * ID class for entity: Matricula
 *
 */ 
public class MatriculaPK  implements Serializable {   
   
	         
	private Integer curso_academico;         
	private Integer expedientes_num_expedientes;
	private static final long serialVersionUID = 1L;

	public MatriculaPK() {}

	

	public Integer getCurso_academico() {
		return this.curso_academico;
	}

	public void setCurso_academico(Integer curso_academico) {
		this.curso_academico = curso_academico;
	}
	

	public Integer getExpedientes_num_expedientes() {
		return this.expedientes_num_expedientes;
	}

	public void setExpedientes_num_expedientes(Integer expedientes_num_expedientes) {
		this.expedientes_num_expedientes = expedientes_num_expedientes;
	}
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof MatriculaPK)) {
			return false;
		}
		MatriculaPK other = (MatriculaPK) o;
		return true
			&& (getCurso_academico() == null ? other.getCurso_academico() == null : getCurso_academico().equals(other.getCurso_academico()))
			&& (getExpedientes_num_expedientes() == null ? other.getExpedientes_num_expedientes() == null : getExpedientes_num_expedientes().equals(other.getExpedientes_num_expedientes()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getCurso_academico() == null ? 0 : getCurso_academico().hashCode());
		result = prime * result + (getExpedientes_num_expedientes() == null ? 0 : getExpedientes_num_expedientes().hashCode());
		return result;
	}
   
   
}
