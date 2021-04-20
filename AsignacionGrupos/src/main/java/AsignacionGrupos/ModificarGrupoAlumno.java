package AsignacionGrupos;

import java.util.List;

import Exceptions.*;
import Entidades.*;
public interface ModificarGrupoAlumno {
	
	// ESTE SIRVE PARA CAMBIAR A UN ALUMNO DE GRUPO Y POR TANTO DE HORARIO
	public void CambioHorarioyGrupo(Alumno alumn,Grupo antiguo, Grupo nuevo) throws AsignacionGruposException;
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws AsignacionGruposException;
	
	public long numeroPlazas(Grupo grupo) throws AsignacionGruposException;
	
	//get u set de alumno con expediente
	public List<Expediente> getAlumno_expedientes()throws AsignacionGruposException;
	
	public void setAlumno_expedientes(List<Expediente> alumno_expedientes)throws AsignacionGruposException;
	
	public List<Grupo> getAlumno_Grupos()throws AsignacionGruposException;

	public void setAlumno_Grupos(List<Grupo> grupos)throws AsignacionGruposException;
	
	//get y set de expediente con alumno
	public Alumno getAlumno()throws AsignacionGruposException;
	
	public void setAlumno(Alumno a)throws AsignacionGruposException;
	
	//get y set de Expediente con matricula
	public List<Matricula> getexpedientes_num_expedientes()throws AsignacionGruposException;
	
	public void setexpedientes_num_expedientes(List<Matricula> m) throws AsignacionGruposException;
	
	//get y set de matricula con expediente
	public Expediente getExpedientes_num_expedientes() throws AsignacionGruposException;

	public void setExpedientes_num_expedientes(Expediente expedientes_num_expedientes) throws AsignacionGruposException;
	
	// MATRICULA CON GRUPO
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) throws AsignacionGruposException;
	
	//GRUPO CON MATRICULA
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) throws AsignacionGruposException;
}
