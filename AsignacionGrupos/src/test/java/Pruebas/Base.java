package Pruebas;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Grupo;

public class Base {
	public static void init(String nombreper) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreper);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
			
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
