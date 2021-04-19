package Entidades;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

public class Main{

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AsignacionGrupos");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Expediente e = new Expediente();
		e.setActivo(true);
		e.setNota_Media_Provisional(5);
		Expediente e2 = new Expediente();
		e.setActivo(true);
		e.setNota_Media_Provisional(8);
		List<Expediente> expedientes = new LinkedList<>();
		expedientes.add(e2);
		expedientes.add(e);
		Alumno a = new Alumno("Juan","Perez","23456789B","abcde@uma.es");
		a.setAlumno_expedientes(expedientes);
		e.setAlumno(a);
		e.setAlumno(a);
		e2.setAlumno(a);
		em.persist(a);
		em.persist(e);
		em.persist(e2);
		tx.commit();		
		em.close();
		emf.close();
	}
}
