package AsignacionGrupos;
import java.sql.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entidades.*;
import Entidades.Encuesta.Expediente_Encuesta_PK;
//import Excepciones.*;
import Exceptions.ExpedienteNoEncontradoException;


@Stateful
public class AGNegocioImpl implements AGNegocio{
	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	@Override
	public void asignarEncuesta(Long numexp, Date fechaenvio, String turno)
			throws ExpedienteNoEncontradoException {
		Expediente e = em.find(Expediente.class, numexp);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		List<Encuesta> exen = e.getEncuesta();
		Expediente_Encuesta_PK enpk = new Expediente_Encuesta_PK(e.getNum_Expediente(), fechaenvio);
		Encuesta en = new Encuesta(enpk, turno);
		en.setExpediente(e);
		exen.add(en);
		e.setEncuesta(exen);
		em.persist(en);
	
	}
	
	@Override
	public Alumno obtenerAlumnoPorExpediente(Long num) throws ExpedienteNoEncontradoException{
		Expediente e = em.find(Expediente.class, num);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		Alumno a = e.getAlumno();
		return a;
	}

	

	
	
	
	
}
