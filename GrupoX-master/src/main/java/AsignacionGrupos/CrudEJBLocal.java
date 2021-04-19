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
import Exceptions.GrupoException;
import Exceptions.MatriculaNoEncontradaException;
import Exceptions.OptativaNoEncontradaExpception;
import Exceptions.TitulacionException;

@Local
public interface CrudEJBLocal {
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void modificarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void eliminarExpediente(Expediente e) throws ExpedienteNoEncontradoException;
	public void insertarExpediente(Expediente e) throws ExpedienteDuplicadoException;
	
	public void insertarAlumno(Alumno a) throws AlumnoDuplicadoException;
	public void modificarAlumno(Alumno a) throws AlumnoNoEncontradoException;
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException;
	
	public void insertarOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	public void modificarOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	public void eliminarOptativa(Optativa o ) throws OptativaNoEncontradaExpception;
	public Optativa existeOptativa(Optativa o) throws OptativaNoEncontradaExpception;
	
	public void insertarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void modificarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public void eliminarMatricula(Matricula m) throws MatriculaNoEncontradaException;
	public Matricula existeMatriucla(Matricula m) throws MatriculaNoEncontradaException;
	
	public void insertarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException;
	public void modificarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException;
	public void elimnarGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException;
	public Grupos_Por_Asignatura existeGrupoAsignatura(Grupos_Por_Asignatura gp) throws GrupoAsignaturaException;
	
	
	public void insertarGrupo(Grupo g) throws GrupoException;
	public void modificarGrupo(Grupo g) throws GrupoException;
	public void eliminarGrupo(Grupo g) throws GrupoException;
	public Grupo existeGrupo(Grupo g) throws GrupoException;
	
	public void insertarTitulacion(Titulacion t) throws TitulacionException;
	public void modificarTitulacion(Titulacion t) throws TitulacionException;
	public void eliminarTitulacion(Titulacion t) throws TitulacionException;
	public Titulacion existeTitulacion(Titulacion t)throws TitulacionException;
	
	public void insertarAsignatura(Asignatura a)throws AsignaturaException;
	public void modificarAsignatura(Asignatura a) throws AsignaturaException;
	public void eliminarAsignatura(Asignatura a)throws AsignaturaException;
	public Asignatura existeAsignatura(Asignatura a)throws AsignaturaException;
	
	
	public void insertarAsignaturasMatriculas (Asignaturas_matriculas am)throws AsignaturaMatriculaException;
	public void modificarAsignaturasMatriculas (Asignaturas_matriculas am)throws AsignaturaMatriculaException;
	public void eliminarAsignaturasMatriculas (Asignaturas_matriculas am)throws AsignaturaMatriculaException;
	public Asignaturas_matriculas existeAsignaturasMatriculas (Asignaturas_matriculas am)throws AsignaturaMatriculaException;

	public void insertarCentro (Centro c) throws CentroException;
	public void modificarCentro (Centro c) throws CentroException;
	public Centro existeCentro (Centro c) throws CentroException;
	public void eliminarCentro (Centro c) throws CentroException;
	
	public void insertarEncuesta(Encuesta e)throws EncuestaException;
	public void modificarEncuesta(Encuesta e)throws EncuestaException;
	public void eliminarEncuesta(Encuesta e)throws EncuestaException;
	public Encuesta existeEncuesta(Encuesta e)throws EncuestaException;
	
	public void insertarData(Data d) throws DataException;
	public void modificarData(Data d) throws DataException;
	public void eliminarData(Data d) throws DataException;
	public Data existeData(Data d) throws DataException;
	
	public void insertarClase(Clase c)throws ClaseException;
	public void modificarClase(Clase c)throws ClaseException;
	public void eliminarClase(Clase c)throws ClaseException;
	public Clase existeClase(Clase c)throws ClaseException;

}
