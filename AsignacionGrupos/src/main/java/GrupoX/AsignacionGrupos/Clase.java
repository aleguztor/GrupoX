package GrupoX.AsignacionGrupos;

import java.io.Serializable;
import java.lang.Long;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity

public class Clase implements Serializable {

	   
	@Id
	@Temporal(TemporalType.DATE)
	private Date Dia;   
	@Id
	@Temporal(TemporalType.TIME)
	private Date Horainicio;
	@Temporal(TemporalType.TIME)
	private Date Horafin;
	private static final long serialVersionUID = 1L;

	public Clase() {
		super();
	}   
	public Date getDia() {
		return this.Dia;
	}

	public void setDia(Date Dia) {
		this.Dia = Dia;
	}   
	public Date getHorainicio() {
		return this.Horainicio;
	}

	public void setHorainicio(Date Horainicio) {
		this.Horainicio = Horainicio;
	}   
	public Date getHorafin() {
		return this.Horafin;
	}

	public void setHorafin(Date Horafin) {
		this.Horafin = Horafin;
	}
   
}
