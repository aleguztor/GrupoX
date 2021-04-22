package AsignacionGrupos;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Grupo;
import Entidades.Titulacion;
import Exceptions.*;

public interface BusquedaYFiltrado {

	public List<Alumno> filtradoAlumnos(Titulacion t, Asignatura a1) throws  AlumnoNoEncontradoException, TitulacionNoEncontradaException, AsignaturaNoEncontradaException;
	public Alumno buscarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException;
	public Titulacion buscarTitulacionPorNombre(String nombre) throws TitulacionNoEncontradaException;
}
