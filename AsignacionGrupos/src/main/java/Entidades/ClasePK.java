package Entidades;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

@Embeddable
public class ClasePK  implements Serializable {   
         
	private Date dia;
	private Date horainicio;
	private static final long serialVersionUID = 1L;

	public ClasePK() {}
	
	public ClasePK(Date d, Date h) {
		dia = d;
		horainicio = h;
	}

	public Date getDia() {
		return this.dia;
	}

	public void setDia(Date Dia) {
		this.dia = Dia;
	}
	
	public Date getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Date hi) {
		horainicio = hi;
	}



	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ClasePK)) {
			return false;
		}
		ClasePK other = (ClasePK) o;
		return true
			&& (getDia() == null ? other.getDia() == null : getDia().equals(other.getDia()));
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getDia() == null ? 0 : getDia().hashCode());
		return result;
	}
   
   
}