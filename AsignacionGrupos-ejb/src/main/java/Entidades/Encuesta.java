package Entidades;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Expediente_Encuesta_PK.class)
public class Encuesta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085497720995065068L;	
	@Id
	private Date Fecha_envio;
	private String Turno_Preferente;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Num_Expediente")
	private Expediente expediente;
	@ManyToMany
	private List<Grupos_Por_Asignatura> gpa;
	
	public Encuesta() {}
	
	public Encuesta(Expediente_Encuesta_PK pk, Expediente e, String tp) {
		Fecha_envio = pk.getFecha_envio();
		expediente = e;
		Turno_Preferente = tp;
	}
		
	public Date getFecha_envio() {
		return Fecha_envio;
	}

	public void setFecha_envio(Date fecha_envio) {
		Fecha_envio = fecha_envio;
	}

	public String getTurno_Preferente() {
		return Turno_Preferente;
	}

	public void setTurno_Preferente(String turno_Preferente) {
		Turno_Preferente = turno_Preferente;
	}
	

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public List<Grupos_Por_Asignatura> getGpa() {
		return gpa;
	}

	public void setGpa(List<Grupos_Por_Asignatura> gpa) {
		this.gpa = gpa;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_envio == null) ? 0 : Fecha_envio.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (Fecha_envio == null) {
			if (other.Fecha_envio != null)
				return false;
		} else if (!Fecha_envio.equals(other.Fecha_envio))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [Fecha_envio=" + Fecha_envio + ", Turno_Preferente=" + Turno_Preferente + ", expediente="
				+ expediente + "]";
	}

	

	

	
}
