package AsignacionGrupos;
import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entidades.Alumno;
import Entidades.Encuesta;
import Entidades.Expediente;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;


@Stateless
public class AsignarEncuestasImpl implements AsignarEncuestas{
	
	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	@Override
	public void asignarEncuesta(Long numexp, Encuesta en)
			throws ExpedienteNoEncontradoException {
		Expediente e = em.find(Expediente.class, numexp);
		if(e == null) {
			throw new ExpedienteNoEncontradoException();
		}
		Expediente exp = em.merge(e);
		List<Encuesta> exen = e.getEncuesta();
		exen.add(en);
		exp.setEncuesta(exen);
	
	}
	
	public Alumno getAlumnoRandom() {
		return em.find(Alumno.class, (long)1);
	}
	
	
	

	
	
	
	
}
