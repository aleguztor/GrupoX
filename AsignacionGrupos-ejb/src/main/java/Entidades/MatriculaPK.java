package Entidades;

import java.io.Serializable;


/**
 * ID class for entity: Matricula
 *
 */ 
public class MatriculaPK  implements Serializable {   
   
	         
	/**
	 * 
	 */
	private static final long serialVersionUID = 5928146559444850991L;
	private String curso_academico;         
	private Long expedientes_num_expedientes;
	

	public MatriculaPK() {}
	
	public MatriculaPK(String ca, Long ne) {
		curso_academico = ca;
		expedientes_num_expedientes = ne;
	}

	

	public String getCurso_academico() {
		return this.curso_academico;
	}

	public void setCurso_academico(String curso_academico) {
		this.curso_academico = curso_academico;
	}
	

	public Long getExpedientes_num_expedientes() {
		return this.expedientes_num_expedientes;
	}

	public void setExpedientes_num_expedientes(Long expedientes_num_expedientes) {
		this.expedientes_num_expedientes = expedientes_num_expedientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso_academico == null) ? 0 : curso_academico.hashCode());
		result = prime * result + ((expedientes_num_expedientes == null) ? 0 : expedientes_num_expedientes.hashCode());
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
		MatriculaPK other = (MatriculaPK) obj;
		if (curso_academico == null) {
			if (other.curso_academico != null)
				return false;
		} else if (!curso_academico.equals(other.curso_academico))
			return false;
		if (expedientes_num_expedientes == null) {
			if (other.expedientes_num_expedientes != null)
				return false;
		} else if (!expedientes_num_expedientes.equals(other.expedientes_num_expedientes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MatriculaPK [curso_academico=" + curso_academico + ", expedientes_num_expedientes="
				+ expedientes_num_expedientes + "]";
	}

	
	
   
	
   
   
}
