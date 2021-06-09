package Pruebas;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.*;
public class Base {
	private static EntityManager em;
	public static void init(String nombreper) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreper);
		em = emf.createEntityManager();
		Date d = new Date(System.currentTimeMillis());
		Alumno a1 = new Alumno("Mario", "Vazquez", "12345678a", "mario@uma.es");
		Alumno a2 = new Alumno("Juan", "Moreno", "23456789b", "juan@uma.es");
		Alumno a3 = new Alumno("Marta", "Ruiz", "34567890c", "marta@uma.es");
		Alumno a4 = new Alumno("Pedro", "Mu�oz", "45678901d", "pedro@uma.es");
		Alumno a5 = new Alumno("Maria", "Garcia","56789012e", "maria@uma.es");
		Alumno a6 = new Alumno("Luis", "Ramos", "67890123f", "luis@uma.es");
		
		Expediente e1 = new Expediente((long)214623,true,5.0);
		Expediente e2 = new Expediente((long)172411,true,5.0);
		Expediente e3 = new Expediente((long)238413,true,5.0);
		Expediente e4 = new Expediente((long)872163,true,5.0);
		Expediente e5 = new Expediente((long)174615,true,5.0);
		Expediente e6 = new Expediente((long)123642,true,5.0);
		Expediente_Encuesta_PK pk1 = new Expediente_Encuesta_PK((long)214623, d);
		Expediente_Encuesta_PK pk2 = new Expediente_Encuesta_PK((long)172411, d);
		Expediente_Encuesta_PK pk3 = new Expediente_Encuesta_PK((long)238413, d);
		Expediente_Encuesta_PK pk4 = new Expediente_Encuesta_PK((long)872163, d);
		Expediente_Encuesta_PK pk5 = new Expediente_Encuesta_PK((long)174615, d);
		Expediente_Encuesta_PK pk6 = new Expediente_Encuesta_PK((long)123642, d);
		Encuesta en1 = new Encuesta(pk1,e1, "Manyana");
		Encuesta en2 = new Encuesta(pk2,e2, "Manyana");
		Encuesta en3 = new Encuesta(pk3,e3, "Manyana");
		Encuesta en4 = new Encuesta(pk4,e4, "Tarde");
		Encuesta en5 = new Encuesta(pk5,e5, "Tarde");
		Encuesta en6 = new Encuesta(pk6,e6, "Manyana");
		
		
		List<Encuesta> p = new LinkedList<>();
		p.add(en1);
		e1.setEncuesta(p);
		p.remove(en1);
		p.add(en2);
		e2.setEncuesta(p);
		p.remove(en2);
		p.add(en3);
		e3.setEncuesta(p);
		p.remove(en3);
		p.add(en4);
		e4.setEncuesta(p);
		p.remove(en4);
		p.add(en5);
		e5.setEncuesta(p);
		p.remove(en5);
		p.add(en6);
		e6.setEncuesta(p);
		Titulacion t =  new Titulacion(1041,"Grado en Ingenieria Informatica",240);
		Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",101,12,true,true);
		Asignatura as1 = new Asignatura("rf13","Desarrollo de maquinas virtuales",202,12,true,false);
		List<Asignatura> asig = new LinkedList<>();
		asig.add(as);
		asig.add(as1);
		t.setAsignaturas(asig);
		e1.setTitulacion(t);
		e2.setTitulacion(t);
		e3.setTitulacion(t);
		e4.setTitulacion(t);
		e5.setTitulacion(t);
		e6.setTitulacion(t);
		List<Matricula> mats = new LinkedList<>();
		MatriculaPK pk = new MatriculaPK("2", (long)214623);
		Matricula m1 = new Matricula(pk,e1,'I',d);
		mats.add(m1);
		e1.setMatricula(mats);
		e1.setAlumno(a1);
		pk = new MatriculaPK("1", (long)214623);
		Matricula m2 = new Matricula(pk,e2,'I',d);
		mats.remove(0);
		mats.add(m2);
		e2.setMatricula(mats);
		e2.setAlumno(a2);
		pk = new MatriculaPK("2", (long)172411);
		Matricula m3 = new Matricula(pk,e3,'I',d);
		mats.remove(0);
		mats.add(m3);
		e3.setMatricula(mats);
		e3.setAlumno(a3);
		pk = new MatriculaPK("1", (long)872163);
		Matricula m4 = new Matricula(pk,e4,'I',d);
		mats.remove(0);
		mats.add(m4);
		e4.setMatricula(mats);
		e4.setAlumno(a4);
		pk = new MatriculaPK("2", (long)174615);
		Matricula m5 = new Matricula(pk,e5,'I',d);
		mats.remove(0);
		mats.add(m5);
		e5.setMatricula(mats);
		e5.setAlumno(a5);
		pk = new MatriculaPK("1", (long)123642);
		Matricula m6 = new Matricula(pk,e6,'I',d);
		mats.remove(0);
		mats.add(m6);
		e6.setMatricula(mats);
		e6.setAlumno(a6);
		m1.setListado_asignaturas("101,202");
		m2.setListado_asignaturas("202");
		m3.setListado_asignaturas("202");
		m4.setListado_asignaturas("202");
		m5.setListado_asignaturas("202");
		m6.setListado_asignaturas("202");
		Grupo ing = new Grupo((long) 9,"1", "A", "Manyana");
		ing.setIdiomaIngles(true);
		Grupo a = new Grupo((long) 1,"1", "B","Manyana");
		Grupo b = new Grupo((long) 2,"1", "C","Manyana");
		Grupo c = new Grupo((long) 3,"1", "D","Tarde");
		Grupo de = new Grupo((long) 4,"1", "E","Tarde");
		Grupo aa1 = new Grupo((long) 5,"2", "B","Manyana");
		Grupo b1 = new Grupo((long) 6,"2", "C","Manyana");
		Grupo c1 = new Grupo((long) 7,"2", "D","Tarde");
		Grupo de1 = new Grupo((long) 8,"2", "E","Tarde");
		a.setPlazasNuevoIngreso((long)30);
		b.setPlazasNuevoIngreso((long)30);
		b.setPlazasRepetidores((long)20);
		a.setPlazasRepetidores((long)20);
		c.setPlazasNuevoIngreso((long)30);
		de.setPlazasNuevoIngreso((long)30);
		c.setPlazasRepetidores((long)20);
		de.setPlazasRepetidores((long)20);
		aa1.setPlazasNuevoIngreso((long)30);
		b1.setPlazasNuevoIngreso((long)30);
		b1.setPlazasRepetidores((long)20);
		aa1.setPlazasRepetidores((long)20);
		c1.setPlazasNuevoIngreso((long)30);
		de1.setPlazasNuevoIngreso((long)30);
		List<Expediente> exps = new LinkedList<>();
		List<Grupo> gps = new LinkedList<>();
		exps.add(e1);
		a1.setExpedientes(exps);
		exps.remove(0);
		exps.add(e2);
		a2.setExpedientes(exps);
		exps.remove(0);
		exps.add(e3);
		a3.setExpedientes(exps);
		exps.remove(0);
		exps.add(e4);
		a4.setExpedientes(exps);
		exps.remove(0);
		exps.add(e5);
		a5.setExpedientes(exps);
		exps.remove(0);
		exps.add(e6);
		a6.setExpedientes(exps);
		Grupos_Por_Asignatura g1 = new Grupos_Por_Asignatura("20/21",a,as);
		Grupos_Por_Asignatura g1ing = new Grupos_Por_Asignatura("20/21",ing,as);
		Grupos_Por_Asignatura g2 = new Grupos_Por_Asignatura("20/21",b,as);
		Grupos_Por_Asignatura g3 = new Grupos_Por_Asignatura("20/21",c,as);
		Grupos_Por_Asignatura g4 = new Grupos_Por_Asignatura("20/21",de,as);
		Grupos_Por_Asignatura g5 = new Grupos_Por_Asignatura("20/21",aa1,as);
		Grupos_Por_Asignatura g6 = new Grupos_Por_Asignatura("20/21",b1,as);
		Grupos_Por_Asignatura g7 = new Grupos_Por_Asignatura("20/21",c1,as);
		Grupos_Por_Asignatura g8 = new Grupos_Por_Asignatura("20/21",de1,as);
		List<Grupos_Por_Asignatura> gpa = new LinkedList<>();
		List<Alumno> alumnos = new LinkedList<>();
		mats.remove(0);
		mats.add(m1);
		mats.add(m2);
		mats.add(m3);
		mats.add(m4);
		mats.add(m5);
		mats.add(m6);
		exps.remove(0);
		exps.add(e1);
		exps.add(e2);
		exps.add(e3);
		exps.add(e4);
		exps.add(e5);
		exps.add(e6);
		alumnos.add(a1);
		alumnos.add(a2);
		alumnos.add(a3);
		alumnos.add(a4);
		alumnos.add(a5);
		alumnos.add(a6);
		gpa.add(g1);
		gpa.add(g1ing);
		gpa.add(g2);
		gpa.add(g3);
		gpa.add(g4);
		gpa.add(g5);
		
		gpa.add(g6);
		gpa.add(g7);
		gpa.add(g8);
		as.setGpa(gpa);
		a.setGpa(gpa);
		b.setGpa(gpa);
		c.setGpa(gpa);
		aa1.setGpa(gpa);
		b1.setGpa(gpa);
		c1.setGpa(gpa);
		de1.setGpa(gpa);
		de.setGpa(gpa);
		gps.add(a);
		gps.add(ing);
		gps.add(b);
		gps.add(c);
		gps.add(de);
		gps.add(aa1);
		gps.add(b1);
		gps.add(c1);
		gps.add(de1);
		p.remove(0);
		p.add(en1);
		p.add(en2);
		p.add(en3);
		p.add(en4);
		p.add(en5);
		p.add(en6);
		
		EncuestaCambioHorario ech = new EncuestaCambioHorario(d, "2A","12345678a");
		List<EncuestaCambioHorario> echs = new LinkedList<>();
		echs.add(ech);
		a1.setEncuestacambioH(echs);
		em.getTransaction().begin();
		em.persist(ech);
		em.persist(t);
		em.persist(as);
		em.persist(as1);
		
		Grupos_Por_AsignaturaPersist(gpa);
		AlumnosPersist(alumnos);
		MatriculasPersist(mats);
		ExpedientesPersist(exps);
		GruposPersist(gps);
		EncuestasPersist(p);
				
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	
	private static void AlumnosPersist(List<Alumno> al) {
		for(Alumno a : al) {
			em.persist(a);
		}
	}
	private static void ExpedientesPersist(List<Expediente> exps) {
		for(Expediente e : exps) {
			em.persist(e);
		}
	}
	private static void GruposPersist(List<Grupo> g) {
		for(Grupo gr : g) {
			em.persist(gr);
		}
	}
	private static void MatriculasPersist(List<Matricula> mats) {
		for(Matricula m : mats) {
			em.persist(m);
		}
	}
	private static void EncuestasPersist(List<Encuesta> en) {
		for(Encuesta e : en) {
			em.persist(e);
		}
	}
	private static void Grupos_Por_AsignaturaPersist(List<Grupos_Por_Asignatura> gpa) {
		for(Grupos_Por_Asignatura g : gpa) {
			em.persist(g);
		}
	}
}
