package AsignacionGrupos;

import java.util.List;

import Exceptions.*;
import Entidades.*;
public interface ModificarGrupoAlumno {
	
	// ESTE SIRVE PARA CAMBIAR A UN ALUMNO DE GRUPO Y POR TANTO DE HORARIO
	public void CambioHorarioyGrupo(Alumno alumn,Grupo antiguo, Grupo nuevo) throws AsignacionGruposException;
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws NoExisteGrupoEnAlumno;
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) throws AsignacionGruposException;
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) throws AsignacionGruposException;
}
