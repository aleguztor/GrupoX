package AsignacionGrupos;

import java.util.List;
import javax.ejb.*;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Titulacion;
import Exceptions.*;

@Local
public interface BusquedaYFiltrado {

	public List<Alumno> filtradoAlumnos(Titulacion t, Asignatura a1) throws  AlumnoNoEncontradoException, TitulacionNoEncontradaException, AsignaturaNoEncontradaException;
	public Alumno buscarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException;
	public Titulacion buscarTitulacionPorNombre(String nombre) throws TitulacionNoEncontradaException;
}
