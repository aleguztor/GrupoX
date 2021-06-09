package Entidades;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
public class Expediente_Encuesta_PK implements Serializable {
		
	
		/**
		 * 
		 */
		private static final long serialVersionUID = -8997815467337471718L;
		private Long expediente;
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