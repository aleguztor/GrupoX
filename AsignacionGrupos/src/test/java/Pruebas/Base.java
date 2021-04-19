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
		Expediente e = new Expediente((long)10,true,5.0);
		a.setAlumno_expedientes(new LinkedList<Expediente>());
//		em.persist(e);
		em.persist(a);
//		a.getAlumno_expedientes().add(e);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
