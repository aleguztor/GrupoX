package AsignacionGrupos;

import java.util.List;

import javax.ejb.Local;

import javax.ws.rs.core.UriBuilder;


import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Centro;
import Entidades.Clase;
import Entidades.Encuesta;
import Entidades.EncuestaCambioHorario;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Matricula;
import Entidades.Optativa;
import Entidades.Titulacion;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoInactivoException;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.AsignaturaDuplicadaException;
import Exceptions.AsignaturaNoEncontradaException;
import Exceptions.CentroException;
import Exceptions.ClaseException;
import Exceptions.ContraseniaInvalidaException;
import Exceptions.EncuestaException;
import Exceptions.ExpedienteDuplicadoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.GrupoDuplicadoException;
import Exceptions.GrupoNoEncontradoException;
import Exceptions.MatriculaNoEncontradaException;
import Exceptions.OptativaNoEncontradaExpception;
import Exceptions.TitulacionException;
import Exceptions.ValidacionIncorrectaException;


@Local
public interface CrudEJBLocal {
	
	
	/*
	 * public void registrarAlumno(Alumno a, UriBuilder uriBuilder) throws
	 * AlumnoDuplicadoException; public void validarAlumno(Long id, String
	 * validacion) throws AlumnoNoEncontradoException,
	 * ValidacionIncorrectaException; public void compruebaLogin(Alumno a) throws
	 * AlumnoNoEncontradoException , AlumnoInactivoException,
	 * ContraseniaInvalidaException;
	 */
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void modificarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void eliminarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void insertarExpediente(Expediente e) throws ExpedienteDuplicadoException;
	
	public void insertarAlumno(Alumno a) throws AlumnoDuplicadoException;
	public void modificarAlumno(Alumno a, Alumno b) throws AlumnoNoEncontradoException;
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException;
	public Alumno buscarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException;
	public void eliminarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException;
	public List<Alumno> getAlumnos();
	
	public void insertarOptativa(Optativa o) throws  OptativaNoEncontradaExpception;
	public void modificarOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	public void eliminarOptativa(Optativa o ) throws OptativaNoEncontradaExpception;
	public Optativa existeOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	
	public void insertarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void modificarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void eliminarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public Matricula existeMatricula(Matricula m) throws MatriculaNoEncontradaException;
	
	
	
	public void insertarGrupo(Grupo g) throws GrupoDuplicadoException;
	public void modificarGrupo(Grupo g) throws GrupoNoEncontradoException;
	public void eliminarGrupo(Grupo g) throws GrupoNoEncontradoException;
	public Grupo existeGrupo(Grupo g) throws GrupoNoEncontradoException;
	public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException;
	
	
	public void insertarTitulacion(Titulacion t) throws TitulacionException;
	public void modificarTitulacion(Titulacion t, Titulacion b) throws TitulacionException;
	public void eliminarTitulacion(Titulacion t) throws TitulacionException;
	public Titulacion existeTitulacion(Titulacion t)throws TitulacionException;
	
	public void insertarAsignatura(Asignatura a)throws AsignaturaNoEncontradaException, AsignaturaDuplicadaException;
	public void modificarAsignatura(Asignatura a) throws AsignaturaNoEncontradaException;
	public void eliminarAsignatura(Asignatura a)throws AsignaturaNoEncontradaException;
	public Asignatura existeAsignatura(Asignatura a)throws AsignaturaNoEncontradaException;
	
	

	public void insertarCentro (Centro c) throws CentroException;
	public void modificarCentro (Centro c) throws CentroException;
	public Centro existeCentro (Centro c) throws CentroException;
	public void eliminarCentro (Centro c) throws CentroException;
	
	public void insertarClase(Clase c)throws ClaseException;
	public void modificarClase(Clase c)throws ClaseException;
	public void eliminarClase(Clase c)throws ClaseException;
	public Clase existeClase(Clase c)throws ClaseException;
	
	public void insertarEncuesta(Encuesta e)throws EncuestaException;
	public void insertarEncuestaCambioHorario(EncuestaCambioHorario e)throws EncuestaException;

	public List<Expediente> obtenerExpedientesAlumno(Long id) throws ExpedienteNoEncontradoException;
	public Long buscarNumeroGrupos();
	public List<Encuesta> getEncuestas();
	public List<Matricula> buscarMatriculasPorExpediente(Long num) throws MatriculaNoEncontradaException;
	public void modificarCondDosAlumnos(Alumno nuevo, Alumno antiguo)throws AlumnoNoEncontradoException;
	public List<Titulacion> obtenerTitulaciones();
}
