package backingbeans;

import java.sql.Date;
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
import Entidades.Expediente_Encuesta_PK;
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
	@Inject
	CrudEJBLocal crud;
	
	@Inject
	AsignarEncuestas AE;
	private static final Logger LOG = Logger.getLogger(EncuestaController.class.getCanonicalName());
	
	
	public String CrearEncuesta() throws EncuestaException, AlumnoNoEncontradoException, ExpedienteNoEncontradoException {
		Date d = new Date(System.currentTimeMillis());
		
		Alumno a= crud.buscarAlumnoPorDNI(dni);
		List<Expediente> lista= crud.getExpedientesDeAlumno(a.getId());
		Expediente exp= lista.get(0);
		Expediente_Encuesta_PK fadfa= new Expediente_Encuesta_PK(exp.getNum_Expediente(),d);
		
								// cogemos el expediente de alumno
		//List<Encuesta >encuestas= exp.getEncuesta();
		Encuesta en= new Encuesta(fadfa,exp,turnopreferente);
		
		
		//crud.modificarExpediente(exp); 
		crud.insertarEncuesta(en); 
		AE.asignarEncuesta(exp.getNum_Expediente(), en);

		
		return "Alumno.html";
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
