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
	
	public List<Alumno> BusquedaAlumno(Alumno alumno, Titulacion t, int a, Grupo g) throws  AlumnoNoEncontradoException{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Alumno> filtrado = em.createNamedQuery("SELECT a.* from ALUMNO a, TITULACION t, GRUPO g", Alumno.class);
		List<Alumno> ListaAlumnos = filtrado.getResultList();
		tx.commit();
		return ListaAlumnos;
		
	}
}
