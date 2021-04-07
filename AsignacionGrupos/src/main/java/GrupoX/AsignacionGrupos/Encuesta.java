package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Encuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	public Date Fecha_envio;
	
	@Id
	@ManyToOne @JoinColumn(name="id_expediente")
	private Long expediente_alumno;
	
	
	
	@ManyToMany
	@JoinTable(name = "Encuesta_Asig", joinColumns = "enc_fk", inverseJoinColumns = @JoinColumn(name = "curso_fk"))
	private List<Grupos_Por_Asignatura> encuentasGrupos; //No se ni como nombrar esto xd
	
	
	public Date getFecha_envio() {
		return Fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		Fecha_envio = fecha_envio;
	}

	public Encuesta(Date fecha_envio) {
		Fecha_envio = fecha_envio;
	}
	
	@Override
	public boolean equals(Object object) {
		if((object instanceof Encuesta)) {
			Encuesta obj = (Encuesta) object;
			return ((obj.expediente_alumno == expediente_alumno));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return expediente_alumno.hashCode();
	}
	

	
}
