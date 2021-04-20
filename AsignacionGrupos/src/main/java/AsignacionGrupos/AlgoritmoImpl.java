package AsignacionGrupos;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javax.persistence.*;

import Entidades.*;

public class AlgoritmoImpl {
	
	static class comparatorAlumno implements Comparator<Alumno>{

		@Override
		public int compare(Alumno a1, Alumno a2) {
			Matricula m1 = a1.getExpedientes().get(0).getMatricula().get(0);
			Matricula m2 = a2.getExpedientes().get(0).getMatricula().get(0);
			Encuesta e1 = a1.getExpedientes().get(0).getEncuesta().get(0);
			Encuesta e2 = a2.getExpedientes().get(0).getEncuesta().get(0);
			if(m1.getEstado() == 'I' && m2.getEstado() != 'I') {		
				return 1;
			}else if(e1.getFecha_envio().compareTo(e2.getFecha_envio())<0) {
				return 1;
			}
			return 0;
		}
		
	}
	@PersistenceContext(name="AsignacionGrupos")
	private EntityManager em;
	
	public void asignacionGrupos() {
		List<Alumno> alumnos;
		em.getTransaction().begin();
		TypedQuery<Alumno> q = em.createNamedQuery("SELECT * FROM ALUMNOS", Alumno.class);
		alumnos = q.getResultList();
		Collections.sort(alumnos, new comparatorAlumno());
		Iterator<Alumno> it = alumnos.iterator();
		while(it.hasNext()) {
			Alumno a = it.next();
			Matricula ma = a.getExpedientes().get(0).getMatricula().get(a.getExpedientes().get(0).getMatricula().size()-1);
			String listadoasig = ma.getListado_asignaturas();
			// Suponemos que el alumno de primera matricula no tiene activada la matricula hasta el inicio del curso.
			// Hay que preguntar si es asi o no. Matricula Activa = A 	Inactiva = I
			
			// Orden de preferencia --> Fecha envio encuesta, turno y equitativo. Mirar comparator.
			
		
		
		}
	}
}
