package backingbeans;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.AsignarEncuestas;
import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Encuesta;
import Entidades.Expediente;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.EncuestaException;
import Exceptions.ExpedienteNoEncontradoException;

@Named
@RequestScoped
public class EncuestaController {
	private Long numexpediente;
	private String turnopreferente;
	private Date date;
	private String dni;
	private
	@Inject
	CrudEJBLocal crud;
	
	@Inject
	AsignarEncuestas AE;
	
	
	public String CrearEncuesta() throws EncuestaException, AlumnoNoEncontradoException, ExpedienteNoEncontradoException {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		
		Alumno a= crud.buscarAlumnoPorDNI(dni);
		List<Expediente> lista= a.getExpedientes();
		Expediente exp= lista.get(0);
		
								// cogemos el expediente de alumno
		List<Encuesta >encuestas= exp.getEncuesta();
		Encuesta en= new Encuesta(date,exp,turnopreferente);
		
		
		AE.asignarEncuesta(exp.getNum_Expediente(), en);
		//crud.modificarExpediente(exp); 
		//crud.insertarEncuesta(en); 
		
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
}
