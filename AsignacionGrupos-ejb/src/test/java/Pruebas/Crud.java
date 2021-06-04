package Pruebas;

import Entidades.*;
import Entidades.Encuesta.Expediente_Encuesta_PK;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;
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

public class Crud {
	private static final Logger LOG = Logger.getLogger(Crud.class.getCanonicalName());
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";
	private CrudEJBLocal crud;

	@Before
	public void setup() throws NamingException {
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteExpediente() {
		try {
			Expediente ex = new Expediente((long) 214623, true, 6);
			crud.insertarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e, ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarExpediente() {
		try {
			Expediente ex = new Expediente((long) 214623, true, 9.2);
			crud.insertarExpediente(ex);
			ex.setNota_Media_Provisional(1);
			ex.setNum_Expediente((long) 1212);
			crud.modificarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertNotEquals(e, ex);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarExpediente() {
		try {
			Expediente ex = new Expediente((long) 214623, true, 9);
			crud.insertarExpediente(ex);
			crud.eliminarExpediente(ex);

			assertNull(crud.existeExpediente(ex));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarExp() {
		try {
			Expediente ex = new Expediente((long) 214623, true, 6);
			crud.insertarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e, ex);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarAlumno() {
		try {
			Alumno al = new Alumno("Jose", "Gutierrez", "8461761r", "asd@uma.es");
			crud.insertarAlumno(al);
			Alumno a = crud.existeAlumno(al);
			assertEquals(a, al);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarAlumno() {
		try {
			Alumno al = crud.buscarAlumnoPorDNI("12345678a");
			String nombre= al.getNombre();
			
			al.setNombre("pepitodelospalotes");
			crud.modificarAlumno(al);
			
			assertNotEquals("pepitodelospalotes", nombre);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarAlumnoPorDNI() {
		try {

			crud.eliminarAlumnoPorDNI("12345678a");
			assertNull(crud.buscarAlumnoPorDNI("12345678a"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testBusquedaAlumno() {
		try {
			assertNotNull(crud.buscarAlumnoPorDNI("12345678a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarOptativa() {
		try {
			Optativa op = new Optativa("12314", "Overclocking de procesadores patata", 809, 6, true, false);
			crud.insertarOptativa(op);
			assertNotNull(crud.existeOptativa(op));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarOptativa() {
		try {
			Optativa op = new Optativa("12314", "Overclocking de procesadores patata", 809, 6, true, false);

			op.setCreditos(12);
			crud.modificarOptativa(op);
			assertNotEquals(crud.existeOptativa(op).getCodigo(), 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarOptativa() {
		try {
			Optativa op = new Optativa("12314", "Overclocking de procesadores patata", 809, 6, true, false);
			crud.insertarOptativa(op);
			crud.eliminarOptativa(op);
			
			assertNull(crud.existeOptativa(op));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteOptativa() {
		try {
			Optativa op = new Optativa("12314", "Overclocking de procesadores patata", 809, 6, true, false);
			crud.insertarOptativa(op);
			Optativa o = crud.existeOptativa(op);
			assertEquals(op, o);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21", (long) 123123123);
			Expediente e = new Expediente((long) 123, true, 9);
			Date d = new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk, e, 'A', d);
			crud.insertarMatricula(m);
			assertNotNull(crud.existeMatricula(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21", (long) 123123123);
			Expediente e = new Expediente((long) 123, true, 9);
			Date d = new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk, e, 'A', d);
			crud.insertarMatricula(m);
			m.setCurso_academico("22");
			crud.modificarMatricula(m);
			assertEquals(m, crud.existeMatricula(m));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21", (long) 123123123);
			Expediente e = new Expediente((long) 123, true, 9);
			Date d = new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk, e, 'A', d);
			crud.insertarMatricula(m);
			crud.eliminarMatricula(m);

			assertNull(crud.existeMatricula(m));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteMatricula() {
		try {
			Expediente e1 = new Expediente((long) 214623, true, 5.0);
			MatriculaPK pk = new MatriculaPK("2�", (long) 214623);
			Date d = new Date(System.currentTimeMillis());
			Matricula m1 = new Matricula(pk, e1, 'I', d);

			assertNotNull(crud.existeMatricula(m1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarGrupo() {
		try {
			Grupo g = new Grupo("4", "c", "Tarde");
			crud.insertarGrupo(g);
			assertEquals(g, crud.existeGrupo(g));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarGrupo() {
		try {
			Grupo g = crud.existeGrupo(new Grupo("1�", "c", "Tarde"));
			g.setLetra("a");
			crud.modificarGrupo(g);
			assertNotEquals("a", crud.existeGrupo(g).getLetra());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteGrupo() {
		try {
			Grupo g = crud.existeGrupo(new Grupo("1�", "b", "Manyana"));
			assertNotNull(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test

	public void testBusquedaGrupo() {
		try {
			Grupo g = crud.busquedaGrupo("1�", "b", "Manyana");
			assertNotNull(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarTitulacion() {
		try {
			Titulacion t = new Titulacion("Desarrollo movil", 540);
			crud.insertarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarTitulacion() {
		try {
			Titulacion t = new Titulacion("Desarrollo movil", 540);
			crud.insertarTitulacion(t);
			t.setCreditos(250);
			t.setCodigo(666);
			crud.modificarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarTitulacion() {
		try {
			Titulacion t = new Titulacion("Desarrollo movil", 540);
			crud.insertarTitulacion(t);
			crud.eliminarTitulacion(t);
			assertNull(crud.existeTitulacion(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteTitulacion() {
		try {
			Titulacion t = new Titulacion("Desarrollo movil", 540);
			crud.insertarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf11", "Desarrollo de maquinas virtuales", 9999, 12, true, false);
			crud.insertarAsignatura(as);
			assertEquals(as, crud.existeAsignatura(as));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf11", "Desarrollo de maquinas virtuales", 9999, 12, true, false);
			crud.insertarAsignatura(as);
			as.setCodigo(122222);
			crud.modificarAsignatura(as);
			assertNotEquals(as, crud.existeAsignatura(as));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf11", "Desarrollo de maquinas virtuales", 9999, 12, true, false);
			crud.insertarAsignatura(as);
			crud.eliminarAsignatura(as);
			assertNull(crud.existeAsignatura(as));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteAsignatura() {
		try {
			Asignatura as = new Asignatura("rf11", "Desarrollo de maquinas virtuales", 9999, 12, true, false);
			crud.insertarAsignatura(as);
			assertEquals(as, crud.existeAsignatura(as));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testInsertarCentro() {
		try {
			Centro c = new Centro((long) 12313, "Escuela tecnica Civil", "Calle Ave del Paraiso 12", "999999999");
			crud.insertarCentro(c);
			assertEquals(c, crud.existeCentro(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarCentro() {
		try {
			Centro c = new Centro((long) 12313, "Escuela tecnica Civil", "Calle Ave del Paraiso 12", "999999999");
			crud.insertarCentro(c);
			c.setTLF_Conserjeria("1234567890");
			c.setNombre("Marina dor");
			crud.modificarCentro(c);
			assertNotEquals("Escuela tecnica Civil", crud.existeCentro(c).getNombre());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testExisteCentro() {
		try {
			Centro c = new Centro((long) 12313, "Escuela tecnica Civil", "Calle Ave del Paraiso 12", "999999999");
			crud.insertarCentro(c);
			assertEquals(c, crud.existeCentro(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarCentro() {
		try {
			Centro c = new Centro((long) 12313, "Escuela tecnica Civil", "Calle Ave del Paraiso 12", "999999999");
			crud.eliminarCentro(c);;
			assertNull(crud.existeCentro(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Requisitos({"RF2"})
	@Test
	public void testInsertarClase() {
		try {

			Date dia = new Date(System.currentTimeMillis() - 1231231);
			Date hora = new Date(1111);
			Grupo g = new Grupo("20/21", "a", "manyana");
			Clase c = new Clase(g,dia,hora);
			crud.insertarClase(c);
			assertEquals(c, crud.existeClase(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Requisitos({"RF2"})
	@Test
	public void testModificarClase() {
		try {
			Date dia = new Date(System.currentTimeMillis() - 1231231);
			Date hora = new Date(1111);
			
			Grupo g = new Grupo("20/21", "a", "manyana");
			Clase c = new Clase(g, dia,hora);
			crud.insertarClase(c);
			Asignatura as = new Asignatura("rf12", "Desarrollo de maquinas virtuales", 9999, 12, true, false);
			c.setAsignatura(as);
			crud.modificarClase(c);
			assertNotEquals(c, crud.existeClase(c));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Requisitos({"RF2"})
	@Test
	public void testEliminarClase() {
		try {
			Date dia = new Date(System.currentTimeMillis() - 1231231);
			Date hora = new Date(1111);
			Grupo g = new Grupo("20/21", "a", "manyana");
			Clase c = new Clase(g, dia,hora);
			crud.insertarClase(c);
			crud.eliminarClase(c);
			assertNull(crud.existeClase(c));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @Requisitos({"RF2"})
	@Test
	public void testExisteClase() {
		try {
			Date dia = new Date(System.currentTimeMillis() - 1231231);
			Date hora = new Date(1111);
			
			Grupo g = new Grupo("20/21", "a", "manyana");
			Clase c = new Clase(g, dia,hora);
			crud.insertarClase(c);
			assertEquals(c, crud.existeClase(c));
		} catch (Exception e) {

		}
	}

}
