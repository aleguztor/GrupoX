package AsignacionGrupos;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Encuesta;
import Entidades.Expediente;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;



@Stateful
public class AGNegocioImpl implements AGNegocio{
	
	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	@Override
	public void asignarEncuesta(Long numexp, Encuesta en)
			throws ExpedienteNoEncontradoException {
		Expediente e = em.find(Expediente.class, numexp);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		List<Encuesta> exen = e.getEncuesta();
		exen.add(en);
		e.setEncuesta(exen);
		em.persist(en);
	
	}
	
	public Alumno getAlumnoRandom() {
		return em.find(Alumno.class, (long)1);
	}
	
	@Override
	public Expediente obtenerExpedientePorAlumno(Alumno a) throws AlumnoNoEncontradoException {
		
		Alumno al = em.find(Alumno.class, a.getId());
		if(al == null) {
			throw new AlumnoNoEncontradoException();
		}
		return al.getExpedientes().get(0);
	}

	@Override
	public Alumno obtenerAlumnoPorExpediente(Long num_expediente) throws ExpedienteNoEncontradoException {
		Expediente e = em.find(Expediente.class, num_expediente);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		Alumno a = e.getAlumno();
		return a;
	}
	
	

	
	
	
	
}
