package AsignacionGrupos;
import Entidades.*;

import Exceptions.*;

import javax.ejb.Local;


@Local
public interface AGNegocio {
	
	public void asignarEncuesta(Long numexp, Encuesta en) throws ExpedienteNoEncontradoException;
	public Expediente obtenerExpedientePorAlumno(Alumno a) throws AlumnoNoEncontradoException;
	public Alumno obtenerAlumnoPorExpediente(Long num_expediente) throws ExpedienteNoEncontradoException;
	public Alumno getAlumnoRandom();

}
