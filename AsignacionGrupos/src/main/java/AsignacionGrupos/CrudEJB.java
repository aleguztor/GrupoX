package AsignacionGrupos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;

import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Asignaturas_matriculas;
import Entidades.Centro;
import Entidades.Clase;
import Entidades.Data;
import Entidades.Encuesta;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Grupos_Por_Asignatura;
import Entidades.Matricula;
import Entidades.Optativa;
import Entidades.Titulacion;
import Exceptions.*;

/**
 * Session Bean implementation class CrudEJB
 */
@Stateless
@LocalBean
public class CrudEJB implements CrudEJBLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="AsignacionGrupos")
	private EntityManager em;
	
    public CrudEJB() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Expediente existeExpediente(Expediente e) throws ExpedienteNoEncontradoException {
		Expediente ex = em.find(Expediente.class, e.getNum_Expediente());
		if(ex==null) {
			throw new ExpedienteNoEncontradoException();
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
			em.persist(ex);
		else 
			throw new ExpedienteDuplicadoException();
	}

	@Override
	public void insertarAlumno(Alumno a) throws  AlumnoDuplicadoException {
		Alumno al = em.find(Alumno.class, a.getId());
		if(al == null)
			em.persist(a);
		else 
			throw new AlumnoDuplicadoException();
		
	}

	@Override
	public void modificarAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = existeAlumno(a);
		em.merge(a);
		
	}

	@Override
	public Alumno existeAlumno(Alumno a) throws AlumnoNoEncontradoException {
		Alumno al = em.find(Alumno.class, a.getId());
		if(al == null)
			throw new AlumnoNoEncontradoException();
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
			throw new OptativaNoEncontradaExpception();
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
			throw new MatriculaNoEncontradaException();
		else 
			return ma;
	}

	

	@Override
	public void insertarGrupo(Grupo g) throws GrupoException {
		Grupo gr = em.find(Grupo.class, g.getId());
		if(gr == null)
			em.persist(gr);
		else 
			throw new GrupoException();
		
	}

	@Override
	public void modificarGrupo(Grupo g) throws GrupoException {
		Grupo gr = existeGrupo(g);
		if(gr ==null)
			throw new GrupoException();
		else 
			em.merge(gr);
		
	}

	@Override
	public void eliminarGrupo(Grupo g) throws GrupoException {
		Grupo gr = existeGrupo(g);
		if(gr==null)
			throw new GrupoException();
		else 
			em.remove(gr);
		
	}

	@Override
	public Grupo existeGrupo(Grupo g) throws GrupoException {
		Grupo	gr = em.find(Grupo.class,g.getId());
		if(gr == null)
			throw new GrupoException();
		else 
			return gr;
	}

	@Override
	public void insertarTitulacion(Titulacion t) throws TitulacionException {
		Titulacion ti = em.find(Titulacion.class,t.getCodigo());
		if(ti == null)
			em.persist(ti);
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
			throw new TitulacionException();
		else
			return ti;

	}

	@Override
	public void insertarAsignatura(Asignatura a) throws AsignaturaException {
		Asignatura as = em.find(Asignatura.class,a.getCodigo());
		if(as == null)
			em.persist(a);
		else
			throw new AsignaturaException();
		
	}

	@Override
	public void modificarAsignatura(Asignatura a) throws AsignaturaException {
		Asignatura as = existeAsignatura(a);
		if(as==null)
			throw new AsignaturaException();
		else 
			em.merge(as);
		
	}

	@Override
	public void eliminarAsignatura(Asignatura a) throws AsignaturaException {
		Asignatura as = existeAsignatura(a);
		if(as==null)
			throw new AsignaturaException();
		else 
			em.remove(as);

		
	}

	@Override
	public Asignatura existeAsignatura(Asignatura a) throws AsignaturaException {
		Asignatura as = em.find(Asignatura.class, a.getReferencia());
		if(as == null)
			throw new AsignaturaException();
		else
			return as;
	}

	

	@Override
	public void insertarCentro(Centro c) throws CentroException {
		Centro ce = em.find(Centro.class,c.getID());
		if(ce == null)
			em.persist(ce);
		else
			throw new CentroException();
		
	}

	@Override
	public void modificarCentro(Centro c) throws CentroException {
		Centro ce = existeCentro(c);
		if(ce==null)
			throw new CentroException();
		else 
			em.merge(ce);
		
	}

	@Override
	public Centro existeCentro(Centro c) throws CentroException {
		Centro ce = em.find(Centro.class, c.getID());
		if(ce == null)
			throw new CentroException();
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
		Clase cl= em.find(Clase.class,c.getClasePK());
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
			em.merge(cl);
		
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
		Clase cl = em.find(Clase.class, c.getClasePK());
		if(cl == null)
			throw new ClaseException();
		else
			return cl;
		
	}

	

	
	
	
	

}
