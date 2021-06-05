package AsignacionGrupos;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.core.UriBuilder;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Centro;
import Entidades.Clase;
import Entidades.Encuesta;
import Entidades.EncuestaCambioHorario;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Matricula;
import Entidades.Optativa;
import Entidades.Titulacion;
import Exceptions.*;

/**
 * Session Bean implementation class CrudEJB
 */
@Stateless
	public class CrudEJB implements CrudEJBLocal {
	
		/*
		 * private static final int TAM_CADENA_VALIDACION = 20; private static final
		 * Logger LOGGER = Logger.getLogger(CrudEJB.class.getCanonicalName());
		 */
    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="AsignacionGrupos")
	private EntityManager em;
	
  

    @Override
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = em.find(Expediente.class, e.getNum_Expediente());
		if(ex==null) {
			return null;
		}
		return ex;
	}

	@Override
	public void modificarExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = existeExpediente(e);
		em.merge(e);
		
	}

	@Override
	public void eliminarExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = existeExpediente(e);
		em.remove(ex);
		
	}

	@Override
	public void insertarExpediente(Expediente e) throws  ExpedienteDuplicadoException {
		Expediente ex = em.find(Expediente.class, e.getNum_Expediente());
		if(ex == null)
			em.persist(e);
		else 
			throw new ExpedienteDuplicadoException();
	}

	@Override
	public void insertarAlumno(Alumno a) throws  AlumnoDuplicadoException {
		try {
			Alumno al = buscarAlumnoPorDNI(a.getDNI());
			if(al != null) {
				throw new AlumnoDuplicadoException();
			}
				em.persist(a);
			
		} catch (AlumnoNoEncontradoException e) {
			e.printStackTrace();
		}
			
		
	}

	@Override
	public void modificarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = existeAlumno(a);
		if(al == null) {
			throw new AlumnoNoEncontradoException();
		}
		em.merge(a);
		
	}

	@Override
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = buscarAlumnoPorDNI(a.getDNI());
		if(al == null)
			return null;
		else
			return al;
	}

	@Override
	public void insertarOptativa(Optativa o) throws  OptativaNoEncontradaExpception {
		Optativa op = em.find(Optativa.class, o.getReferencia());
		if(op == null)
			em.persist(o);
		else
			throw new OptativaNoEncontradaExpception();
	}

	@Override
	public void modificarOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		Optativa op = existeOptativa(o);
		if(op==null)
			throw new OptativaNoEncontradaExpception();
		else 
			em.merge(o);
		
	}

	@Override
	public void eliminarOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		Optativa op = existeOptativa(o);
		if(op==null)
			throw new OptativaNoEncontradaExpception();
		else 
			em.remove(op);
		
	}

	@Override
	public Optativa existeOptativa(Optativa o) throws OptativaNoEncontradaExpception {
		Optativa op = em.find(Optativa.class, o.getReferencia());
		if(op == null)
			return null;
		else
			return op;
	}

	@Override
	public void insertarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		Matricula ma = em.find(Matricula.class, m.getNum_archivo());
		if(ma == null)
			em.persist(m);
		else 
			throw new MatriculaNoEncontradaException();
		
	}

	@Override
	public void modificarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		Matricula ma = existeMatricula(m);
		if(ma ==null)
			throw new MatriculaNoEncontradaException();
		else 
			em.merge(m);
		
	}

	@Override
	public void eliminarMatricula(Matricula m) throws MatriculaNoEncontradaException {
		Matricula ma = existeMatricula(m);
		if(ma==null)
			throw new MatriculaNoEncontradaException();
		else 
			em.remove(ma);
		
	}

	@Override
	public Matricula existeMatricula(Matricula m) throws MatriculaNoEncontradaException {
		Matricula ma = em.find(Matricula.class, m.getNum_archivo());
		if(ma == null)
			return null;
		else 
			return ma;
	}

	

	@Override
	public void insertarGrupo(Grupo g) throws GrupoDuplicadoException {
		Grupo gr = em.find(Grupo.class, g.getId());
		if(gr == null) {
			g.setId(buscarNumeroGrupos());
			em.persist(g);
		}
		else 
			throw new GrupoDuplicadoException();
		
	}

	@Override
	public void modificarGrupo(Grupo g) throws GrupoNoEncontradoException {
		Grupo gr = existeGrupo(g);
		if(gr ==null)
			throw new GrupoNoEncontradoException();
		else 
			em.merge(g);
		
	}

	@Override
	public void eliminarGrupo(Grupo g) throws GrupoNoEncontradoException {
		Grupo gr = existeGrupo(g);
		if(gr==null)
			throw new GrupoNoEncontradoException();
		else 
			em.remove(gr);
		
	}

	@Override
	public Grupo existeGrupo(Grupo g) throws GrupoNoEncontradoException {
		Grupo	gr = em.find(Grupo.class,g.getId());
		if(gr == null)
			return null;
		else 
			return gr;
	}

	@Override
	public void insertarTitulacion(Titulacion t) throws TitulacionException {
		Titulacion ti = em.find(Titulacion.class,t.getCodigo());
		if(ti == null)
			em.persist(t);
		else 
			throw new TitulacionException();
		
	}

	@Override
	public void modificarTitulacion(Titulacion t) throws TitulacionException {
		Titulacion ti = existeTitulacion(t);
		if(ti==null)
			throw new TitulacionException();
		else 
			em.merge(ti);
		
	}

	@Override
	public void eliminarTitulacion(Titulacion t) throws TitulacionException {
		Titulacion ti = existeTitulacion(t);
		if(ti==null)
			throw new TitulacionException();
		else 
			em.remove(ti);
		
	}

	@Override
	public Titulacion existeTitulacion(Titulacion t) throws TitulacionException {
		Titulacion ti = em.find(Titulacion.class, t.getCodigo());
		if(ti == null)
			return null;
		else
			return ti;

	}

	@Override
	public void insertarAsignatura(Asignatura a) throws AsignaturaNoEncontradaException, AsignaturaDuplicadaException {
		Asignatura as = em.find(Asignatura.class,a.getCodigo());
		if(as == null) {
			throw new AsignaturaNoEncontradaException();
		}else {
			em.persist(a);
			
		}
		
	}

	@Override
	public void modificarAsignatura(Asignatura a) throws AsignaturaNoEncontradaException {
		Asignatura as = existeAsignatura(a);
		if(as==null)
			throw new AsignaturaNoEncontradaException();
		else 
			em.merge(a);
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a) throws AsignaturaNoEncontradaException {
		Asignatura as = existeAsignatura(a);
		if(as==null)
			throw new AsignaturaNoEncontradaException();
		else 
			em.remove(as);

		
	}

	@Override
	public Asignatura existeAsignatura(Asignatura a) throws AsignaturaNoEncontradaException {
		Asignatura as = em.find(Asignatura.class, a.getReferencia());
		if(as == null)
			return null;
		else
			return as;
	}

	

	@Override
	public void insertarCentro(Centro c) throws CentroException {
		Centro ce = em.find(Centro.class,c.getID());
		if(ce == null)
			em.persist(c);
		else
			throw new CentroException();
		
	}

	@Override
	public void modificarCentro(Centro c) throws CentroException {
		Centro ce = existeCentro(c);
		if(ce==null)
			throw new CentroException();
		else 
			em.merge(c);
		
	}

	@Override
	public Centro existeCentro(Centro c) throws CentroException {
		Centro ce = em.find(Centro.class, c.getID());
		if(ce == null)
			return null;
		else
			return ce;
	}

	@Override
	public void eliminarCentro(Centro c) throws CentroException {
		Centro ce = existeCentro(c);
		if(ce==null)
			throw new CentroException();
		else 
			em.remove(ce);
		
	}


	@Override
	public void insertarClase(Clase c) throws ClaseException {
		Clase cl = em.createQuery("SELECT clase FROM CLASE clase where clase.horainicio= :hora and clase.dia = :dia and clase.grupo = :grupo ",Clase.class).setParameter("hora", c.getHorainicio()).setParameter("dia", c.getDia()).setParameter("grupo", c.getGrupo()).getSingleResult();
		if(cl == null)
			em.persist(cl);
		else
			throw new ClaseException();
	}

	@Override
	public void modificarClase(Clase c) throws ClaseException {
		Clase cl = existeClase(c);
		if(cl==null)
			throw new ClaseException();
		else 
			em.merge(c);
		
	}

	@Override
	public void eliminarClase(Clase c) throws ClaseException {
		Clase cl = existeClase(c);
		if(cl==null)
			throw new ClaseException();
		else 
			em.remove(cl);
		
	}

	@Override
	public Clase existeClase(Clase c) throws ClaseException {
		Clase cl = em.createQuery("SELECT clase FROM CLASE clase where clase.horainicio= :hora and clase.dia = :dia and clase.grupo = :grupo ",Clase.class).setParameter("hora", c.getHorainicio()).setParameter("dia", c.getDia()).setParameter("grupo", c.getGrupo()).getSingleResult();
		
		if(cl == null)
				return null;
		else
			return cl;
		
	}

	@Override
	public Alumno buscarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException {
		TypedQuery<Alumno> q = em.createQuery("SELECT a FROM Alumno a WHERE a.DNI LIKE '"+dni+"'", Alumno.class);
		if(q.getResultList().isEmpty()) {
			return null;
		}
		return q.getSingleResult();
	}

	@Override
	public void eliminarAlumnoPorDNI(String dni) throws AlumnoNoEncontradoException {
		Alumno a = buscarAlumnoPorDNI(dni);
		
		em.remove(em.merge(a));
		
	}

	@Override
	public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException {
		TypedQuery<Grupo> q = em.createQuery("SELECT g FROM Grupo g WHERE g.Curso LIKE '"+c+"' AND g.Letra LIKE '"+l+"'"
				+ " AND g.Turno_Manyana_Tarde LIKE '"+t+"'", Grupo.class);
		if(q.getSingleResult() == null) {
			throw new GrupoNoEncontradoException();
		}
		return q.getSingleResult();
	}
	
	@Override 
	public Long buscarNumeroGrupos() {
		Query query =  em.createQuery("SELECT COUNT(g) FROM GRUPO g", Grupo.class);
		Long resultado = (Long) query.getSingleResult();
		return resultado + 1;
	}
	
	@Override
	public List<Alumno> getAlumnos() {
		return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
	}
	
	@Override
	public List<Expediente> obtenerExpedientesAlumno(Long id) throws ExpedienteNoEncontradoException{
		TypedQuery<Expediente> q = em.createQuery("SELECT e FROM Expediente e WHERE alumno_Id = "+id+";", Expediente.class);
		if(q.getResultList() == null) {
			return null;
		}
		return q.getResultList();
	}
	@Override
	public void insertarEncuesta(Encuesta e)throws EncuestaException{
		Encuesta ce = em.find(Encuesta.class,e.getFecha_envio());
		if(ce == null)
			em.persist(e);
		else
			throw new EncuestaException();
	}
	@Override
	public void insertarEncuestaCambioHorario(EncuestaCambioHorario e){
		
			em.persist(e);
		
	}

	


	
	
	

}
