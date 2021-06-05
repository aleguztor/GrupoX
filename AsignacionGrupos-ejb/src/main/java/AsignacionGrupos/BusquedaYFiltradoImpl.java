package AsignacionGrupos;

import javax.ejb.*;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Grupo;
import Entidades.Titulacion;
import Exceptions.*;

@Stateless
public class BusquedaYFiltradoImpl implements BusquedaYFiltrado{

	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	public List<Alumno> filtradoAlumnos(Titulacion t, Asignatura asignatura) throws  AlumnoNoEncontradoException, TitulacionNoEncontradaException, AsignaturaNoEncontradaException{
		List<Alumno> ListaAlumnos = new LinkedList<>();
		TypedQuery<Alumno> filtrado = null;
		Titulacion ti = null;
		Asignatura a = null;
		if(t != null) {
			ti = buscarTitulacionPorNombre(t.getNombre());
			if(ti == null) {
				throw new TitulacionNoEncontradaException();
			}
		}
		if(asignatura != null) {
			a = em.find(Asignatura.class, asignatura.getCodigo());
			if(a == null) {
				throw new AsignaturaNoEncontradaException();
			}
		}
		if(ti != null && a != null) {
			filtrado = em.createQuery("SELECT al FROM ALUMNO, TITULACION t, ASIGNATURA a WHERE t.NOMBRE LIKE '"+ti.getNombre()+"' "
					+ "AND a.CODIGO = "+a.getCodigo(), Alumno.class);
		}else if(ti != null && a == null) {
			filtrado = em.createNamedQuery("SELECT al from ALUMNO al, TITULACION t WHERE t.NOMBRE LIKE '"+ti.getNombre()+"'", Alumno.class);
		} else if(a != null && ti == null) {
			filtrado = em.createNamedQuery("SELECT al from ALUMNO al, ASIGNATURA as WHERE as.CODIGO = "+a.getCodigo() , Alumno.class);
		}
		ListaAlumnos = filtrado.getResultList();

		return ListaAlumnos;
		
	}
	
	@Override
	public Alumno buscarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException {
		TypedQuery<Alumno> q = em.createQuery("SELECT a FROM ALUMNO a WHERE a.DNI= :dni", Alumno.class);
		if(q.getSingleResult() == null) {
			throw new AlumnoNoEncontradoException();
		}
		return q.getSingleResult();
	}
	
	@Override
	public Titulacion buscarTitulacionPorNombre(String nombre) throws TitulacionNoEncontradaException{
		TypedQuery<Titulacion> q = em.createQuery("SELECT t FROM TITULACION WHERE t.NOMBRE= :nombre", Titulacion.class);
		if(q.getSingleResult() == null) {
			throw new TitulacionNoEncontradaException();
		}
		return q.getSingleResult();
	}
	
	
	
	
}
