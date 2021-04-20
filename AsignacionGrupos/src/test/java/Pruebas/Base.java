package Pruebas;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Alumno;
import Entidades.Expediente;

public class Base {
	public static void init(String nombreper) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreper);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Alumno a = new Alumno("Mario", "Vazquez", "1235754a", "asd@uma.es");
		Alumno a1 = new Alumno("Jose", "Vazquez", "1225754a", "asd@uma.es");
//		em.persist(e);
		em.persist(a);
		em.persist(a1);
//		a.getAlumno_expedientes().add(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
