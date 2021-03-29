package GrupoX.AsignacionGrupos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main (String arg[]) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("AsignacionGrupos");
		EntityManager em= emf.createEntityManager();
		em.close();
		emf.close();
	}
}
