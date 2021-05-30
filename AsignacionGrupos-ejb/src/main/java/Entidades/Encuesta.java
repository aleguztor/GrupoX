package Entidades;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Encuesta.Expediente_Encuesta_PK.class)
public class Encuesta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3085497720995065068L;

	public static class Expediente_Encuesta_PK implements Serializable {
		
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -8997815467337471718L;
		@Column(nullable = false)
		private Long expediente;
		@Column(nullable = false)
		private Date Fecha_envio;
		
		public Expediente_Encuesta_PK() {}
		
		public Expediente_Encuesta_PK(Long ne, Date e) {
			expediente = ne;
			Fecha_envio = e;
		}
		
		public Long getExpediente() {
			return expediente;
		}

		public void setExpediente(Long expediente) {
			this.expediente = expediente;
		}

		public Date getFecha_envio() {
			return Fecha_envio;
		}

		public void setFecha_envio(Date fecha_envio) {
			Fecha_envio = fecha_envio;
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
			Expediente_Encuesta_PK other = (Expediente_Encuesta_PK) obj;
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
			return "Expediente_Encuesta_PK [expediente=" + expediente + ", Fecha_envio=" + Fecha_envio + "]";
		}

		

		
	}
	
	@Id
	private Date Fecha_envio;
	private String Turno_Preferente;
	private String razones;
	private String cursoacambiar;
	private File Documentos;
	private String dameDNI;
	public String getDameDNI() {
		return dameDNI;
	}

	public void setDameDNI(String dameDNI) {
		this.dameDNI = dameDNI;
	}

	public String getRazones() {
		return razones;
	}

	public void setRazones(String razones) {
		this.razones = razones;
	}

	public String getCursoacambiar() {
		return cursoacambiar;
	}

	public void setCursoacambiar(String cursoacambiar) {
		this.cursoacambiar = cursoacambiar;
	}

	public File getDocumentos() {
		return Documentos;
	}

	public void setDocumentos(File documentos) {
		Documentos = documentos;
	}

	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Num_Expediente")
	private Expediente expediente;
	@ManyToMany
	private List<Grupos_Por_Asignatura> gpa;
	
	public Encuesta() {}
	
	public Encuesta(Date f, Expediente e, String tp) {
		Fecha_envio = f;
		expediente = e;
		Turno_Preferente = tp;
	}
	public Encuesta(Date d, String cursoacambiar, String r, File f, String dni ) {
		Fecha_envio = d;
		this.cursoacambiar = cursoacambiar;
		razones = r;
		Documentos=f;
		dameDNI=dni;
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
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
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
		if (Turno_Preferente == null) {
			if (other.Turno_Preferente != null)
				return false;
		} else if (!Turno_Preferente.equals(other.Turno_Preferente))
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
