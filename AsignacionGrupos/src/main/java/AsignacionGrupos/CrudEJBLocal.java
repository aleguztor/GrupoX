package AsignacionGrupos;

import javax.ejb.Local;

import Entidades.*;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.AsignaturaException;
import Exceptions.AsignaturaMatriculaException;
import Exceptions.CentroException;
import Exceptions.ClaseException;
import Exceptions.DataException;
import Exceptions.EncuestaException;
import Exceptions.ExpedienteDuplicadoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.GrupoAsignaturaException;
import Exceptions.GrupoNoEncontradoException;
import Exceptions.*;


@Local
public interface CrudEJBLocal {
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void modificarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void eliminarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void insertarExpediente(Expediente e) throws ExpedienteDuplicadoException;
	
	public void insertarAlumno(Alumno a) throws AlumnoDuplicadoException;
	public void modificarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public void insertarOptativa(Optativa o) throws  OptativaNoEncontradaExpception;
	public void modificarOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	public void eliminarOptativa(Optativa o ) throws OptativaNoEncontradaExpception;
	public Optativa existeOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	
	public void insertarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void modificarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void eliminarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public Matricula existeMatricula(Matricula m) throws MatriculaNoEncontradaException;
	
	
	
	public void insertarGrupo(Grupo g) throws GrupoNoEncontradoException;
	public void modificarGrupo(Grupo g) throws GrupoNoEncontradoException;
	public void eliminarGrupo(Grupo g) throws GrupoNoEncontradoException;
	public Grupo existeGrupo(Grupo g) throws GrupoNoEncontradoException;
	
	public void insertarTitulacion(Titulacion t) throws TitulacionException;
	public void modificarTitulacion(Titulacion t) throws TitulacionException;
	public void eliminarTitulacion(Titulacion t) throws TitulacionException;
	public Titulacion existeTitulacion(Titulacion t)throws TitulacionException;
	
	public void insertarAsignatura(Asignatura a)throws AsignaturaException;
	public void modificarAsignatura(Asignatura a) throws AsignaturaException;
	public void eliminarAsignatura(Asignatura a)throws AsignaturaException;
	public Asignatura existeAsignatura(Asignatura a)throws AsignaturaException;
	
	

	public void insertarCentro (Centro c) throws CentroException;
	public void modificarCentro (Centro c) throws CentroException;
	public Centro existeCentro (Centro c) throws CentroException;
	public void eliminarCentro (Centro c) throws CentroException;
	
	
	public void insertarClase(Clase c)throws ClaseException;
	public void modificarClase(Clase c)throws ClaseException;
	public void eliminarClase(Clase c)throws ClaseException;
	public Clase existeClase(Clase c)throws ClaseException;

}
