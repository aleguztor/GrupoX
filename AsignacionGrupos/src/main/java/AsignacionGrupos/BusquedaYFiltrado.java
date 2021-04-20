package AsignacionGrupos;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Grupo;
import Entidades.Titulacion;
import Exceptions.AlumnoNoEncontradoException;

public interface BusquedaYFiltrado {

	public List<Alumno> BusquedaAlumno(Alumno a, Titulacion t, int a, Grupo g) throws  AlumnoNoEncontradoException;
		
}
