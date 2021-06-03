package backingbeans;

import java.sql.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Encuesta;
import Entidades.Expediente;
import Exceptions.EncuestaException;

@Named
@RequestScoped
public class EncuestaController {
	private Long numexpediente;
	private String turnopreferente;
	private Date date;
	private
	@Inject
	CrudEJBLocal crud;
	
	public String CrearEncuesta() throws EncuestaException {
		Expediente e= new Expediente(numexpediente,true,0);
		Encuesta en= new Encuesta(date,e,turnopreferente);
		crud.insertarEncuesta(en);
		return "index.xhtml";
	}

	public Long getNumexpediente() {
		return numexpediente;
	}

	public void setNumexpediente(Long numexpediente) {
		this.numexpediente = numexpediente;
	}

	public String getTurnopreferente() {
		return turnopreferente;
	}

	public void setTurnopreferente(String turnopreferente) {
		this.turnopreferente = turnopreferente;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
