package AsignacionGrupos;

import java.util.List;
import javax.ejb.*;
import javax.persistence.*;

import Entidades.*;

@Stateless
public class GestionEntidadesImpl implements GestionEntidades{
	@PersistenceContext(name="Test")
	private EntityManager em;
	
	public List<Alumno> obtenerAlumnos() throws Exception{
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Alumno> q = em.createNamedQuery("SELECT * from ALUMNO", Alumno.class);
		List<Alumno> res = q.getResultList();
		tx.commit();
		return res;
	}

}
