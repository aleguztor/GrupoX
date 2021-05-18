package Entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(Entidades.Clase.Clase_PK.class)
public class Clase implements Serializable {
	public static class Clase_PK implements Serializable{
		private Long grupo;
		private Date dia;
		private Date horainicio;
		private static final long serialVersionUID = 1L;

		public Clase_PK() {}
		
		public Clase_PK(Long g, Date d, Date hi) {
			grupo = g;
			dia = d;
			horainicio = hi;
		}
		
		public Date getDia() {
			return dia;
		}

		public void setDia(Date dia) {
			this.dia = dia;
		}

		public Date getHorainicio() {
			return horainicio;
		}

		public void setHorainicio(Date horainicio) {
			this.horainicio = horainicio;
		}

		public Long getGrupo() {
			return grupo;
		}

		public void setGrupo(Long grupo) {
			this.grupo = grupo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dia == null) ? 0 : dia.hashCode());
			result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
			result = prime * result + ((horainicio == null) ? 0 : horainicio.hashCode());
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
			Clase_PK other = (Clase_PK) obj;
			if (dia == null) {
				if (other.dia != null)
					return false;
			} else if (!dia.equals(other.dia))
				return false;
			if (grupo == null) {
				if (other.grupo != null)
					return false;
			} else if (!grupo.equals(other.grupo))
				return false;
			if (horainicio == null) {
				if (other.horainicio != null)
					return false;
			} else if (!horainicio.equals(other.horainicio))
				return false;
			return true;
		}
			
	}
	@Id
	private Date dia;
	@Id
	private Date horainicio;
	@ManyToOne
	@Id
	@JoinColumn(referencedColumnName="Id")
	private Grupo grupo;
	@Temporal(TemporalType.TIME)
	private Date Horafin;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Asignatura asignatura;

	public Clase() {}
	
	public Clase(Grupo g, Date d, Date h) {
		grupo = g;
		dia = d;
		horainicio = h;
	}
	
	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Date getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Date horainicio) {
		this.horainicio = horainicio;
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

	public Date getHorafin() {
		return this.Horafin;
	}

	public void setHorafin(Date Horafin) {
		this.Horafin = Horafin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Horafin == null) ? 0 : Horafin.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((horainicio == null) ? 0 : horainicio.hashCode());
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
		Clase other = (Clase) obj;
		if (Horafin == null) {
			if (other.Horafin != null)
				return false;
		} else if (!Horafin.equals(other.Horafin))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (horainicio == null) {
			if (other.horainicio != null)
				return false;
		} else if (!horainicio.equals(other.horainicio))
			return false;
		return true;
	}
	
   
}
