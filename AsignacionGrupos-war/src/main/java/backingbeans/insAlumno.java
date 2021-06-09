package backingbeans;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Matricula;
import Entidades.MatriculaPK;
import Entidades.Titulacion;
import Exceptions.*;



@Named("alumnoBean")
@RequestScoped
public class insAlumno {

	private Integer idtitulacion;
	private Alumno alumno = new Alumno();
	private Expediente expediente = new Expediente();
	private Matricula matricula = new Matricula();
	private static final Logger LOG = Logger.getLogger(insAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public Expediente getExpediente() {
		return expediente;
	}
	
	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	
	public Integer getIdtitulacion() {
		return idtitulacion;
	}

	public void setIdtitulacion(Integer idtitulacion) {
		this.idtitulacion = idtitulacion;
	}

	public String doCrearAlumno() throws TitulacionException, MatriculaNoEncontradaException, ExpedienteNoEncontradoException, ParseException {
		try {
			
			crud.insertarAlumno(alumno);
			try {
				expediente.setTitulacion(crud.obtenerTitulacionPorId(idtitulacion));
				expediente.setAlumno(alumno);
				crud.insertarExpediente(expediente);
			} catch (ExpedienteDuplicadoException e) {
				// TODO Auto-generated catch block
				LOG.info("El expediente ya ha sido creado antes");
			}
		} catch (AlumnoDuplicadoException e) {
				LOG.info("El alumno ya esta en Base de datos incluido");
		}
		return "Main.html";
	}
	
	public List<Alumno> listaAlumnos(){
		 return crud.getAlumnos();
	}

	
	
}
