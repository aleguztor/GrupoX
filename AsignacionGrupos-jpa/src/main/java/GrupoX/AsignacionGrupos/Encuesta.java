package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Encuesta.Expediente_Encuesta_PK.class)
public class Encuesta implements Serializable{
	public static class Expediente_Encuesta_PK implements Serializable {
		
		private static final long serialVersionUID = 1L;
		@Column(nullable = false)
		private Long expediente;
		@Column(nullable = false)
		private Date Fecha_envio;
		
		public Expediente_Encuesta_PK() {}
		
		public Expediente_Encuesta_PK(Long ne, Date e) {
			expediente = ne;
			Fecha_envio = e;
		}
		@Override
		public boolean equals(Object o) {
			if(o instanceof Expediente_Encuesta_PK) {
				if(((Expediente_Encuesta_PK) o).expediente.equals(expediente) && ((Expediente_Encuesta_PK) o).Fecha_envio.equals(Fecha_envio)){
							return true;
						}
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			return expediente.hashCode() + Fecha_envio.hashCode();
		}
	}
	private static final long serialVersionUID = 1L;
	@Id
	private Date Fecha_envio;
	private String Turno_Preferente;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Num_Expediente")
	private Expediente expediente;
	@ManyToMany
	private List<Grupos_Por_Asignatura> gpa;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_envio == null) ? 0 : Fecha_envio.hashCode());
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
		return true;
	}

	
}
