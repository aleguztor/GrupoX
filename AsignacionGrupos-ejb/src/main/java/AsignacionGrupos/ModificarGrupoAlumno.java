package AsignacionGrupos;

import java.util.List;
import javax.ejb.*;
import Exceptions.*;
import Entidades.*;

@Local
public interface ModificarGrupoAlumno {
	
	// ESTE SIRVE PARA CAMBIAR A UN ALUMNO DE GRUPO Y POR TANTO DE HORARIO
	public void CambioHorarioyGrupo(Alumno alumn,Grupo antiguo, Grupo nuevo) throws AsignacionGruposException;
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws NoExisteGrupoEnAlumno, GrupoNoEncontradoException;
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) throws GrupoNoEncontradoException;
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) throws MatriculaNoEncontradaException;
	
	public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException;

}
