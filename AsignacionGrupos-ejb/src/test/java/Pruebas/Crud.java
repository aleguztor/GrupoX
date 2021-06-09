package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Asignatura;
import Entidades.Centro;
import Entidades.Clase;
import Entidades.Encuesta;
import Entidades.EncuestaCambioHorario;
import Entidades.Expediente;
import Entidades.Expediente_Encuesta_PK;
import Entidades.Grupo;
import Entidades.Matricula;
import Entidades.MatriculaPK;
import Entidades.Optativa;
import Entidades.Titulacion;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.EncuestaException;
import Exceptions.ExpedienteDuplicadoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.GrupoDuplicadoException;
import Exceptions.GrupoNoEncontradoException;
import Exceptions.MatriculaDuplicadaException;
import Exceptions.MatriculaNoEncontradaException;
import Exceptions.TitulacionException;

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
			Alumno ab = crud.buscarAlumnoPorDNI("12345678a");
			ab.setNombre("pepitodelospalotes");
			crud.modificarAlumno(al,ab);
			
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
	public void testBusquedaAlumnoPorDNI() {
		try {
			assertNotNull(crud.buscarAlumnoPorDNI("12345678a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testGetAlumnos() {
		assertNotNull(crud.getAlumnos().get(0));
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
	
//@Requisitos({"RF2"})
	@Test
	public void testEliminarGrupo() {
		try {
			Grupo g = crud.busquedaGrupo("1","B", "Manyana");
			crud.eliminarGrupo(g);
			assertNull(crud.busquedaGrupo("1","B", "Manyana"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
//	@Requisitos({"RF2"})
	@Test
	public void testInsertarGrupo() {
		try {
			Grupo g = new Grupo((long) 15, "4", "c", "Tarde");
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
			Grupo g = crud.existeGrupo(new Grupo((long) 15,"1�", "c", "Tarde"));
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
			Grupo a = new Grupo((long) 1,"1", "B","Manyana");
			assertNotNull(crud.existeGrupo(a));
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
			Titulacion t = new Titulacion(1014,"Desarrollo movil", 540);
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
			Titulacion t = new Titulacion(1014,"Desarrollo movil", 540);
			crud.insertarTitulacion(t);
			t.setCreditos(250);
			t.setCodigo(666);
			Titulacion b= new Titulacion(666,"",250);
			crud.modificarTitulacion(t,b);
			assertEquals(t, crud.existeTitulacion(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testEliminarTitulacion() {
		try {
			Titulacion t = new Titulacion(1014,"Desarrollo movil", 540);
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
			Titulacion t = new Titulacion(1014,"Desarrollo movil", 540);
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
			int codigoant = as.getCodigo();
			as.setCodigo(122222);
			crud.modificarAsignatura(as);
			assertNotEquals(codigoant, crud.existeAsignatura(as).getCodigo());
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
			Grupo g = new Grupo((long) 15,"20/21", "a", "manyana");
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
			
			Grupo g = new Grupo((long) 15,"20/21", "a", "manyana");
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
			Grupo g = new Grupo((long) 15,"20/21", "a", "manyana");
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
			
			Grupo g = new Grupo((long) 15,"20/21", "a", "manyana");
			Clase c = new Clase(g, dia,hora);
			crud.insertarClase(c);
			assertEquals(c, crud.existeClase(c));
		} catch (Exception e) {

		}
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testInsertarEncuesta() {
			Date d = new Date(System.currentTimeMillis());
			Alumno a = new Alumno("Antono","Bermudez","555333888x","antonio@uma.es");
			Expediente e = new Expediente((long) 555555,true,5.0);
			Expediente_Encuesta_PK pk = new Expediente_Encuesta_PK((long) 555555,d);
			Encuesta en = new Encuesta(pk,e,"Manyana");
			List<Encuesta> ens = new LinkedList<>();
			ens.add(en);
			e.setEncuesta(ens);
			List<Expediente> expedientes = new LinkedList<>();
			expedientes.add(e);
			a.setExpedientes(expedientes);
	
			try {
				crud.insertarAlumno(a);
				crud.insertarExpediente(e);
				crud.insertarEncuesta(en);
				Encuesta encuesta;
				encuesta = crud.obtenerEncuestasPorExpediente((long) 555555).get(0);
				assertEquals(en, encuesta);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testInsertarEncuestaCambioHorario() {
		Date d = new Date(System.currentTimeMillis());
		EncuestaCambioHorario e = new EncuestaCambioHorario(d,"2�","123456789a");
		try {
			crud.insertarEncuestaCambioHorario(e);
			assertEquals(e,crud.existeEncuestaCambioHorario(e));
		} catch (EncuestaException e1) {
			e1.printStackTrace();
		}	
	}	
	
//	@Requisitos({"RF2"})
	@Test
	public void testObtenerExpedientesAlumno() {
		Long id = (long)214623;
		
		List<Expediente> b= new LinkedList<>();
		b.add(new Expediente((long)214623,true,5.0));
		/*try {
		//	assertEquals(crud.obtenerExpedientesAlumno(id).getNum_Expediente(),b.get(0).getNum_Expediente());
		}catch(ExpedienteNoEncontradoException e) {
			e.printStackTrace();
		}*/
	}	
	
//	@Requisitos({"RF2"})
	@Test
	public void testGetEncuestas() {
		assertNotNull(crud.getEncuestas());
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testBuscarMatriculasPorExpediente() {
		Date d = new Date(System.currentTimeMillis());
		Expediente e1 = new Expediente((long)214623,true,5.0);
		Alumno a1 = new Alumno("Mario", "Vazquez", "12345678a", "mario@uma.es");
		List<Expediente> exps = new LinkedList<>();
		exps.add(e1);
		a1.setExpedientes(exps);
		e1.setAlumno(a1);
		MatriculaPK pk = new MatriculaPK("2", (long)214623);
		Matricula m1 = new Matricula(pk,e1,'I',d);
		List<Matricula> matriculas = new LinkedList<>();
		matriculas.add(m1);
		e1.setMatricula(matriculas);
		m1.setExpedientes_num_expedientes(e1);
	
		try {
			crud.insertarAlumno(a1);
			crud.insertarExpediente(e1);
			crud.insertarMatricula(m1);
		
			List<Matricula> buscar= crud.buscarMatriculasPorExpediente(e1.getNum_Expediente());
			LOG.severe(matriculas.toString());
			assertEquals(buscar,matriculas);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

//	@Requisitos({"RF2"})
	@Test
	public void testModificarConDosAlumnos() {
		Alumno a = new Alumno("Juan", "Vazquez", "8219412a", "juan@uma.es");
		Alumno a1 = new Alumno("Mario", "Vazquez", "12345678a", "mario@uma.es");
		try {
			crud.modificarAlumno(a, a1);
			assertNotNull(crud.buscarAlumnoPorDNI(a1.getDNI()));
		}catch(AlumnoNoEncontradoException e) {
			e.printStackTrace();
		}
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testObtenerTitulaciones() {
		assertNotNull(crud.obtenerTitulaciones());
	}
	
//	@Requisitos({"RF2"})
	@Test
	public void testObtenerTitulacionPorId() {
		int codigo = 1041;
		try {
			assertNotNull(crud.obtenerTitulacionPorId(codigo));
		}catch(TitulacionException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testExisteEncuestaCambiaHorario() {
		Date d = new Date(System.currentTimeMillis());
		EncuestaCambioHorario ech = new EncuestaCambioHorario(d, "2A","555333888x");
		List<EncuestaCambioHorario> echs = new LinkedList<>();
		echs.add(ech);
		Alumno a = new Alumno("Antono","Bermudez","555333888x","antonio@uma.es");
		a.setEncuestacambioH(echs);
		try {
			crud.insertarAlumno(a);
		
			crud.insertarEncuestaCambioHorario(ech);
			assertNotNull(crud.existeEncuestaCambioHorario(ech));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testObtenerGrupos() {
		try {
		assertNotNull(crud.obtenerGrupos().get(0).getCurso());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testExpedientesDeAlumno() throws AlumnoDuplicadoException, ExpedienteDuplicadoException {
		
		try {
		assertNotNull(crud.getExpedientesDeAlumno(crud.buscarAlumnoPorDNI("0000000a").getId()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testExisteExpedientePorPK() throws ExpedienteNoEncontradoException {
		assertNotNull(crud.existeExpedientePorPK((long)214623));
	}
	
	@Test
	public void testObtenerEncuestasPorExpediente() throws ExpedienteNoEncontradoException {
		assertNotNull(crud.obtenerEncuestasPorExpediente((long)214623));
	}
	
	@Test
	public void testEliminarEncuestasPorExpediente()  {
		List<Encuesta> b= new LinkedList<>();
		b.add(null);
		Expediente e1 = new Expediente((long)214623,true,5.0);
		
		try {
		crud.eliminarEncuestaPorExpediente((long)214623);
		assertEquals(e1.getEncuesta().get(0),b);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testObtenerGrupoPorId(){
		Grupo grupo = new Grupo((long)12, "20/21", "A", "M");
		try {
			crud.insertarGrupo(grupo);
		} catch (GrupoDuplicadoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			assertNotNull(crud.obtenerGrupoPorId((long) 12));
		} catch (GrupoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testEliminarGrupoPorId() {
		try {
		crud.eliminarGrupoPorId((long) 1);
		assertEquals(crud.obtenerGrupoPorId((long) 1),null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAsignaturas() {
		assertNotNull(crud.getAsignaturas());
	}
	@Test
	public void testEliminarAsignaturasPorReferencia() {
		Asignatura ass= new Asignatura("23fd","Nombre",2,240,true,true);
		
		try {
			crud.insertarAsignatura(ass);
			crud.eliminarAsignaturaPorReferencia("23fd");
			assertNull(crud.existeAsignatura(ass));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
