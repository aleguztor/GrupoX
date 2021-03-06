package AsignacionGrupos;


import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


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
	
		
    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="AsignacionGrupos")
	private EntityManager em;
	
	private static final Logger LOG=Logger.getLogger(CrudEJB.class.getCanonicalName());

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
		em.persist(e);
	}

	@Override
	public void insertarAlumno(Alumno a) throws  AlumnoDuplicadoException {	
				em.persist(a);

	}
	
	@Override
	public Alumno buscarAlumnoPorId(Long id) throws AlumnoNoEncontradoException{
		Alumno a = em.find(Alumno.class, id);
		if(a == null) {
			throw new AlumnoNoEncontradoException();
		}
		return a;
	}
	@Override
	public void eliminarAlumno(Long id) throws AlumnoNoEncontradoException{
		Alumno a = em.find(Alumno.class, id);
		if(a == null) {
			throw new AlumnoNoEncontradoException();
		}
		em.remove(em.merge(a));
	}

	@Override
	public void modificarAlumno(Alumno a, Alumno b) throws AlumnoNoEncontradoException {
		/*
		 * Alumno al = existeAlumno(a); if(al == null) { throw new
		 * AlumnoNoEncontradoException(); }
		 */
		Alumno alumno= em.merge(a);
		LOG.severe(a.toString());
		if(b.getApellido1() != null && !b.getApellido1().equals("")) {
			alumno.setApellido1(b.getApellido1());
		}
		if(b.getApellido2() != null && !b.getApellido2().equals("") ) {
			alumno.setApellido2(b.getApellido2());
		}
		
		if(b.getNombre() != null && !b.getNombre().equals("")) {
			alumno.setNombre(b.getNombre());
			
		}
		
		if(b.getEmail_personal() != null && !b.getEmail_personal().equals("")) {
			alumno.setEmail_personal(b.getEmail_personal());
		}
		
		if(b.getLocalidad_notificacion() != null && !b.getLocalidad_notificacion().equals("")) {
			alumno.setLocalidad_notificacion(b.getLocalidad_notificacion());
		}
		if(b.getCP_notificacion() != null && !b.getCP_notificacion().equals("")) {
			alumno.setCP_notificacion(b.getCP_notificacion());
		}
		if(b.getProvincia_notificacion() != null && !b.getProvincia_notificacion().equals("")) {
			alumno.setProvincia_notificacion(b.getProvincia_notificacion());
		}
		if(b.getDireccion_notificacion() != null && !b.getDireccion_notificacion().equals("")) {
			alumno.setDireccion_notificacion(b.getDireccion_notificacion());
		}
		
		if(b.getMovil() != null && !b.getMovil().equals("")) {
			alumno.setMovil(b.getMovil());
		}
		
		if(b.getTelefono() != null && !b.getTelefono().equals("")) {
			alumno.setTelefono(b.getTelefono());
		}
		
		
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
	public void insertarMatricula(Matricula m) throws MatriculaDuplicadaException {
		em.persist(em.merge(m));
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
		Grupo gr = em.find(Grupo.class,g.getId());
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
	public void modificarTitulacion(Titulacion t, Titulacion nueva) throws TitulacionException {
				
		Titulacion ti = existeTitulacion(t);
		if(ti==null) {
			throw new TitulacionException();
		}else { 
			Titulacion cambiar=em.merge(ti);
			if(!nueva.getCodigo().equals("")) {
				ti.setCodigo(nueva.getCodigo());
			}
			if(!nueva.getNombre().equals("")) {
				ti.setNombre(nueva.getNombre());
			}
			if(!nueva.getCreditos().equals("")) {
				ti.setCreditos(nueva.getCreditos());
			}
		}
		
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
	public void insertarAsignatura(Asignatura a) throws AsignaturaDuplicadaException {
		Asignatura as = em.find(Asignatura.class,a.getReferencia());
		if(as != null) {
			throw new AsignaturaDuplicadaException();
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
		TypedQuery<Alumno> q = em.createQuery("SELECT a FROM Alumno a WHERE a.DNI LIKE '" + dni +"'", Alumno.class);
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
		
		return q.getSingleResult();
	}
	
	@Override
	public List<Alumno> getAlumnos() {
		return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
	}
	
	@Override
	public Expediente obtenerExpedienteAlumno(Long id) throws ExpedienteNoEncontradoException{
		TypedQuery<Expediente> q = em.createQuery("SELECT e FROM Expediente e WHERE alumno_Id = "+id, Expediente.class);

		return q.getSingleResult();
	}
	@Override 
	public List<Encuesta> getEncuestas(){
		TypedQuery<Encuesta> q = em.createQuery("SELECT e FROM Encuesta e", Encuesta.class);
		return q.getResultList();
	}
	@Override
	public void insertarEncuesta(Encuesta e){
		em.persist(em.merge(e));
	}
	@Override
	public void insertarEncuestaCambioHorario(EncuestaCambioHorario e){
			em.persist(e);
	}
	@Override
	public List<Matricula> buscarMatriculasPorExpediente(Long num) throws MatriculaNoEncontradaException{
		TypedQuery<Matricula> q = em.createQuery("SELECT m FROM Matricula m WHERE expedientes_num_expedientes.Num_Expediente = "+num, Matricula.class);
		List<Matricula> m= q.getResultList();
		
		return m;
	}
	@Override
	public void modificarCondDosAlumnos(Alumno nuevo, Alumno antiguo) throws AlumnoNoEncontradoException{
		em.remove((em.merge(antiguo)));
		
		em.persist(nuevo);
	}
	@Override
	public List<Titulacion> obtenerTitulaciones() {
		TypedQuery<Titulacion> q = em.createQuery("SELECT t FROM Titulacion t", Titulacion.class);
		return q.getResultList();
	}
	@Override
	public Titulacion obtenerTitulacionPorId(Integer eas) throws TitulacionException{
		TypedQuery<Titulacion> q = em.createQuery("SELECT m FROM Titulacion m WHERE m.codigo = "+eas, Titulacion.class);
		
		return q.getSingleResult();
	}
	@Override
	public EncuestaCambioHorario existeEncuestaCambioHorario(EncuestaCambioHorario en) throws EncuestaException {
		EncuestaCambioHorario e = em.find(EncuestaCambioHorario.class, en.getDNI());
		if(e == null) {
			throw new EncuestaException();
		}
		return e;
	}
	@Override
	public List<Grupo> obtenerGrupos(){
		TypedQuery<Grupo> q = em.createQuery("SELECT a FROM Grupo a", Grupo.class);
		
		return q.getResultList();
	}
	
	@Override
	public Grupo obtenerGrupoPorId(Long id){
		TypedQuery<Grupo> q = em.createQuery("SELECT a FROM Grupo a where a.Id ="+id, Grupo.class);
		
		return q.getSingleResult();
	}
	@Override
	public List<Expediente> getExpedientesDeAlumno(Long id){
		TypedQuery<Expediente> q = em.createQuery("SELECT e FROM Expediente e WHERE alumno_Id = "+id, Expediente.class);
		return q.getResultList();
	}
	@Override
	public Expediente existeExpedientePorPK(Long num) throws ExpedienteNoEncontradoException{
		Expediente e = em.find(Expediente.class, num);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		return e;
	}
	@Override
	public List<Encuesta> obtenerEncuestasPorExpediente(Long ne) throws ExpedienteNoEncontradoException{
		Expediente e = em.find(Expediente.class, ne);
		
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		return e.getEncuesta();
	}
	@Override
	public void eliminarEncuestaPorExpediente(Long exp) throws EncuestaException{
		TypedQuery<Encuesta> q = em.createQuery("SELECT e FROM Encuesta e WHERE expediente_Num_Expediente = "+exp, Encuesta.class);
		if(q.getResultList() != null) {
			for(Encuesta en : q.getResultList()) {
				em.remove(en);
			}
		}
	}
	@Override
	public void eliminarGrupoPorId(Long id) throws GrupoNoEncontradoException{
		Grupo g = em.find(Grupo.class, id);
		if(g == null) {
			throw new GrupoNoEncontradoException();
		}
		em.remove(em.merge(g));
	}
	@Override
	public List<Asignatura> getAsignaturas(){
		TypedQuery<Asignatura> q = em.createQuery("SELECT a FROM Asignatura a", Asignatura.class);
		return q.getResultList();
	}
	@Override
	public void eliminarAsignaturaPorReferencia(String ref) throws AsignaturaNoEncontradaException{
		Asignatura a = em.find(Asignatura.class, ref);
		if(a == null) {
			throw new AsignaturaNoEncontradaException();
		}
		em.remove(em.merge(a));
	}
	@Override
	public List<Centro> getCentros(){
		TypedQuery<Centro> q = em.createQuery("SELECT c FROM Centro c", Centro.class);
		return q.getResultList();
	}
}
