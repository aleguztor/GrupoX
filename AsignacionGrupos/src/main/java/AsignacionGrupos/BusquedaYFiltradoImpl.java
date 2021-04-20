package AsignacionGrupos;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Grupo;
import Entidades.Titulacion;
import Exceptions.AlumnoNoEncontradoException;

public class BusquedaYFiltradoImpl implements BusquedaYFiltrado{

	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	public List<Alumno> BusquedaAlumno(Alumno alumno, Titulacion t, Asignatura asignatura) throws  AlumnoNoEncontradoException{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		if(alumno != null && t == null && asignatura == null) {
			TypedQuery<Alumno> filtrado = em.createNamedQuery("SELECT * from ALUMNO WHERE NOMBRE =" + alumno.getNombre() + "APELLIDO1 =" + alumno.getApellido1() + "APELLIDO2" + alumno.getApellido2(), Alumno.class);
			List<Alumno> ListaAlumnos = filtrado.getResultList();
			tx.commit();
			return ListaAlumnos;
		} else if(t != null && alumno == null && asignatura == null) {
			TypedQuery<Alumno> filtrado = em.createNamedQuery("SELECT * from ALUMNO al, TITULACION t, EXPEDIENTE e WHERE al.expedientes = e.matricula AND e.titulacion = t.codigo AND t.nombre =" + t.getNombre(), Alumno.class);
			List<Alumno> ListaAlumnos = filtrado.getResultList();
			tx.commit();
			return ListaAlumnos;
		} else if(asignatura != null && alumno == null && t == null) {
			TypedQuery<Alumno> filtrado = em.createNamedQuery("SELECT * from ALUMNO al, TITULACION t, EXPEDIENTE e, ASIGNATURA as WHERE al.expedientes = e.matricula AND e.titulacion = t.codigo AND as.codigo = t.asignaturas AND as.NOMBRE =" + asignatura.getNombre() , Alumno.class);
			List<Alumno> ListaAlumnos = filtrado.getResultList();
			tx.commit();
			return ListaAlumnos;
		}
		tx.commit();
		return null;
		
	}
	
	
}
