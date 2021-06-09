package Pruebas;

import Entidades.*;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.AsignacionGruposException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.GrupoNoEncontradoException;
import Exceptions.MatriculaNoEncontradaException;
import Exceptions.NoExisteGrupoEnAlumno;

import static org.junit.Assert.*;


import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


import org.junit.*;

import AsignacionGrupos.*;



public class ModAlumnos {
	private static final Logger LOG = Logger.getLogger(ModAlumnos.class.getCanonicalName());
	private static final String MODIFICARGRUPO = "java:global/classes/ModificarGrupoEJB";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	
	
	private CrudEJBLocal crud;
	private ModificarGrupoAlumno modg;

	
	@Before
	public void setup() throws NamingException{
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		modg = (ModificarGrupoAlumno) SuiteTest.ctx.lookup(MODIFICARGRUPO);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF8"})
	@Test
	public void testCambioGrupoAlumnos() {
		List<Alumno> alumnos = new LinkedList<>();
		try {
			alumnos.add(crud.buscarAlumnoPorDNI("12345678a"));
			Grupo a = crud.busquedaGrupo("2�", "a", "Manyana");
			Grupo n = crud.busquedaGrupo("1�", "c","Tarde");
			modg.CambioGrupoAlumnos(alumnos, a, n);
			assertEquals(alumnos.get(0).getAlumno_Grupos().indexOf(a),-1);
			assertEquals(alumnos.get(0).getAlumno_Grupos().get(alumnos.get(0).getAlumno_Grupos().indexOf(n)),n);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	@Requisitos({"RF8"})
	@Test
	public void testCambioHorarioyGrupo() {
		Alumno a1 = new Alumno("Mario", "Vazquez", "12345678a", "mario@uma.es");
		Grupo a = new Grupo((long)15,"1", "B","Manyana");
		Grupo nuevo=new Grupo((long)16,"1","A","Manyana");
		try {
			modg.CambioHorarioyGrupo(a1, a, nuevo);
			assertNull(a1.getGrupos().contains(a));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	@Requisitos({"RF8"})
	@Test
	public void testObtenerMatriculaPorGrupo() {
		
		Grupo b = new Grupo((long)15,"1", "C","Manyana");
		try {
			
			assertNotNull(modg.obtenerMatriculaPorGrupo(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Requisitos({"RF8"})
	@Test
	public void testObtenerGrupoPorMatricula() {
		Date d = new Date(System.currentTimeMillis());
		Expediente e1 = new Expediente((long)214623,true,5.0);
		MatriculaPK pk = new MatriculaPK("2", (long)214623);
		Matricula m1 = new Matricula(pk,e1,'I',d);
		try {
			assertNotNull(modg.obtenerGrupoPorMatricula(m1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Requisitos({"RF8"})
	@Test
	public void testBusquedaDeGrupo() {
		Grupo a = new Grupo((long)15,"1", "B","Manyana");
		try {
			
			assertEquals(modg.busquedaGrupo("1", "B", "Manyana"),a );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
