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

//import Excepciones.*;



public class Tests {
	private static final Logger LOG = Logger.getLogger(Tests.class.getCanonicalName());
	private static final String ENTIDADES_EJB = "java:global/classes/AGNegocioImpl";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	private static EJBContainer ejbContainer;
	private static Context ctx;
	
	private AGNegocio negocio;
	private CrudEJBLocal crud;
	private ModificarGrupoAlumno modg;
	private CambioHorario cambh;
	private LimitePlazas limpla;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException{
		negocio = (AGNegocio) ctx.lookup(ENTIDADES_EJB);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Test
	
	public void testAsignarEncuesta() {
		Date d = new Date(System.currentTimeMillis());
		try {
			Alumno a = crud.buscarAlumnoPorDNI("12345678a");
			Expediente e = a.getExpedientes().get(0);
			Expediente_Encuesta_PK pk = new Expediente_Encuesta_PK(e.getNum_Expediente(), d);
			Encuesta en = new Encuesta(pk, "Manyana");
			en.setExpediente(e);
			negocio.asignarEncuesta(e.getNum_Expediente(), en);
			a = crud.buscarAlumnoPorDNI("12345678a");
			assertEquals(a.getExpedientes().get(0).getEncuesta().get(0).getExpediente().getNum_Expediente(), e.getNum_Expediente());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	public void testExisteExpediente() {
		try {
			Expediente ex = new Expediente((long) 214623,true,6);
			crud.insertarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e,ex);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarExpediente() {
		try {
			Expediente ex = new Expediente((long)214623, true, 9.2);
			crud.insertarExpediente(ex);
			ex.setNota_Media_Provisional(1);
			ex.setNum_Expediente((long)1212);
			crud.modificarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e,ex);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarExpediente() {
		try {
			Expediente ex = new Expediente((long) 214623, true, 9);
			crud.insertarExpediente(ex);
			crud.eliminarExpediente(ex);;
			assertNull(crud.existeExpediente(ex));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertarExp() {
		try {
			Expediente ex = new Expediente((long) 214623,true,6);
			crud.insertarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e,ex);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInsertarAlumno() {
		try {
			Alumno al = new Alumno("Jose", "Gutierrez", "8461761r", "asd@uma.es");
			crud.insertarAlumno(al);
			Alumno a = crud.existeAlumno(al);
			assertEquals(a,al);
			
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testModificarAlumno() {
		try {
			Alumno al = crud.buscarAlumnoPorDNI("12345678a");
			
			al.setDireccion_notificacion("Calle la mia");
			al.setEmail_personal("pepito@gmail.com");
			al.setLocalidad_notificacion("Malaga");
			al.setTelefono("123123");
			crud.modificarAlumno(al);
			Alumno a = crud.buscarAlumnoPorDNI("12345678a");
			assertEquals(a, al);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testEliminarAlumnoPorDNI() {
		try {
			
			crud.eliminarAlumnoPorDNI("12345678a");
			assertNull(crud.buscarAlumnoPorDNI("12345678a"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	
	public void testBusquedaAlumno() {
		try {
			assertNotNull(crud.buscarAlumnoPorDNI("12345678a"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test 
	public void testInsertarOptativa() {
		try{
			Optativa op = new Optativa("12314","Overclocking de procesadores patata",809,6,true,false);
			crud.insertarOptativa(op);
			assertNotNull(crud.existeOptativa(op));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void testModificarOptativa() {
		try {
			Optativa op = new Optativa("12314","Overclocking de procesadores patata",809,6,true,false);
			
			op.setCreditos(12);
			crud.modificarOptativa(op);
			assertNotEquals(crud.existeOptativa(op).getCodigo(),6);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarOptativa() {
		try {
			Optativa op = new Optativa("12314","Overclocking de procesadores patata",809,6,true,false);
			crud.insertarOptativa(op);
			crud.eliminarOptativa(op);;
			assertNull(crud.existeOptativa(op));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteOptativa() {
		try{
			Optativa op = new Optativa("12314","Overclocking de procesadores patata",809,6,true,false);
			crud.insertarOptativa(op);
			Optativa o = crud.existeOptativa(op);
			assertEquals(op, o);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Test 
	public void testInsertarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21",(long)123123123);
			Expediente e = new Expediente((long) 123,true,9);
			Date d= new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk,e,'A',d);
			crud.insertarMatricula(m);
			assertNotNull(crud.existeMatricula(m));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testModificarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21",(long)123123123);
			Expediente e = new Expediente((long) 123,true,9);
			Date d= new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk,e,'A',d);
			crud.insertarMatricula(m);
			m.setCurso_academico("22");
			crud.modificarMatricula(m);
			assertEquals(m,crud.existeMatricula(m));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testEliminarMatricula() {
		try {
			MatriculaPK mpk = new MatriculaPK("20/21",(long)123123123);
			Expediente e = new Expediente((long) 123,true,9);
			Date d= new Date(System.currentTimeMillis());
			Matricula m = new Matricula(mpk,e,'A',d);
			crud.insertarMatricula(m);
			crud.eliminarMatricula(m);
			
			assertNull(crud.existeMatricula(m));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteMatricula() {
		try {
			Expediente e1 = new Expediente((long)214623,true,5.0);
			MatriculaPK pk = new MatriculaPK("2�", (long)214623);
			Date d = new Date(System.currentTimeMillis());
			Matricula m1 = new Matricula(pk,e1,'I',d);
			
			assertNotNull(crud.existeMatricula(m1));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInsertarGrupo() {
		try {
			Grupo g = new Grupo("4","c","Tarde");
			crud.insertarGrupo(g);
			assertEquals(g, crud.existeGrupo(g));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarGrupo() {
		try {
			Grupo g = crud.existeGrupo(new Grupo("1�", "c","Tarde"));
			g.setLetra("a");
			crud.modificarGrupo(g);
			assertEquals("a",crud.existeGrupo(g).getLetra() );
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteGrupo() {
		try {
			Grupo g = crud.existeGrupo(new Grupo("1�", "b","Manyana"));
			assertNotNull(g);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBusquedaGrupo() {
		try{
			Grupo g = crud.busquedaGrupo("1�", "b","Manyana");
			assertNotNull(g);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertarTitulacion() {
		try {
			Titulacion t=  new Titulacion("Desarrollo movil",550);
			crud.insertarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testModificarTitulacion() {
		try {
			Titulacion t=  new Titulacion("Desarrollo movil",550);
			crud.insertarTitulacion(t);
			t.setCreditos(250);
			t.setCodigo(666);
			crud.modificarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEliminarTitulacion() {
		try {
			Titulacion t=  new Titulacion("Desarrollo movil",550);
			crud.insertarTitulacion(t);
			crud.eliminarTitulacion(t);
			assertNull(crud.existeTitulacion(t));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteTitulacion() {
		try {
			Titulacion t=  new Titulacion("Desarrollo movil",550);
			crud.insertarTitulacion(t);
			assertEquals(t, crud.existeTitulacion(t));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testInsertarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			crud.insertarAsignatura(as);
			assertEquals(as, crud.existeAsignatura(as));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			crud.insertarAsignatura(as);
			as.setCodigo(122222);
			crud.modificarAsignatura(as);
			assertEquals(as,crud.existeAsignatura(as));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarAsignatura() {
		try {
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			crud.insertarAsignatura(as);
			crud.eliminarAsignatura(as);
			assertNull(crud.existeAsignatura(as));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testExisteAsignatura() {
		try {
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			crud.insertarAsignatura(as);
			assertEquals(as, crud.existeAsignatura(as));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertarCentro() {
		try {
			Centro c = new Centro((long)12313,"Escuela tecnica Civil","Calle Ave del Paraiso 12",999999999);
			crud.insertarCentro(c);
			assertEquals(c,crud.existeCentro(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarCentro() {
		try {
			Centro c = new Centro((long)12313,"Escuela tecnica Civil","Calle Ave del Paraiso 12",999999999);
			crud.insertarCentro(c);
			c.setTLF_Conserjeria(1234567890);
			c.setNombre("Marina dor");
			crud.modificarCentro(c);
			assertEquals(c,crud.existeCentro(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteCentro() {
		try {
			Centro c = new Centro((long)12313,"Escuela tecnica Civil","Calle Ave del Paraiso 12",999999999);
			crud.insertarCentro(c);
			assertEquals(c,crud.existeCentro(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarCentro() {
		try {
			Centro c = new Centro((long)12313,"Escuela tecnica Civil","Calle Ave del Paraiso 12",999999999);
			crud.insertarCentro(c);
			assertNull(crud.existeCentro(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertarClase() {
		try {
			
			Date dia = new Date(System.currentTimeMillis()-1231231);
			Date hora = new Date(1111);
			ClasePK cpk = new ClasePK(dia, hora);
			Grupo g = new Grupo("20/21","a","manyana");
			Clase c = new Clase(g,cpk);
			crud.insertarClase(c);
			assertEquals(c, crud.existeClase(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testModificarClase() {
		try {
			Date dia = new Date(System.currentTimeMillis()-1231231);
			Date hora = new Date(1111);
			ClasePK cpk = new ClasePK(dia, hora);
			Grupo g = new Grupo("20/21","a","manyana");
			Clase c = new Clase(g,cpk);
			crud.insertarClase(c);
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			c.setAsignatura(as);
			crud.modificarClase(c);
			assertEquals(c, crud.existeClase(c));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarClase() {
		try {
			Date dia = new Date(System.currentTimeMillis()-1231231);
			Date hora = new Date(1111);
			ClasePK cpk = new ClasePK(dia, hora);
			Grupo g = new Grupo("20/21","a","manyana");
			Clase c = new Clase(g,cpk);
			crud.insertarClase(c);
			crud.eliminarClase(c);
			assertNull(crud.existeClase(c));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testExisteClase() {
		try {
			Date dia = new Date(System.currentTimeMillis()-1231231);
			Date hora = new Date(1111);
			ClasePK cpk = new ClasePK(dia, hora);
			Grupo g = new Grupo("20/21","a","manyana");
			Clase c = new Clase(g,cpk);
			crud.insertarClase(c);
			assertEquals(c, crud.existeClase(c));
		}catch(Exception e) {
			
		}
	}
	
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
	public void testCambioHorarioyGrupo() {
		Alumno al = new Alumno("PEPE", "viruela", "124536b", "adassa@uma.es");
		Grupo a = new Grupo("2º", "a","Mañana");
		Grupo b = new Grupo("1º", "b","Mañana");
		Grupo c = new Grupo("1º", "c","Tarde");
		List<Grupo> grupos= new ArrayList<>();
		grupos.add(a);
		grupos.add(b);
		grupos.add(c);
		al.setAlumno_Grupos(grupos);
		Grupo nuevo= new Grupo("1º", "a", "Mañana");
		try {
			cambh.CambioHorarioyGrupo(al, a, nuevo);
			assertEquals(al.getAlumno_Grupos().indexOf(c),-1);
			grupos=al.getAlumno_Grupos();
			assertEquals(grupos.get(grupos.indexOf(nuevo)),nuevo);
		}catch(Exception e) {

			e.printStackTrace();
		}
	}
	
	@Test
    public void TestLimitarPlazasNuevoIngreso() {
        Grupo g = new Grupo("1�", "c","Tarde");
        Long nplazas=(long) 10;
        try {
            limpla.limitarPlazasNuevoIngreso(g, nplazas);
            assertEquals(g.getPlazasNuevoIngreso(), nplazas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    
    public void TestLimitarPlazasRepetidores() {

        Grupo g=new Grupo("1�","c","Tarde");
        Long nplazas=(long)10;
        try {
            limpla.limitarPlazasRepetidores(g, nplazas);
            assertEquals(g.getPlazasRepetidores(), nplazas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Test
	
    public void TestEliminarGrupoPorFaltaDeAlumnos() {
		//Suponemos que el limite por falta de alumnos es 3. El grupo A tiene dos alumnos por 
		//tanto deberia borrase.
		try {
			Grupo g = crud.busquedaGrupo("1�", "a", "Manyana");
			limpla.EliminarGrupoPorFaltaDeAlumnos(g);
			assertNull(crud.busquedaGrupo("1�", "a", "Manyana"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	

	@AfterClass
	public static void tearDownClass() {
		if(ejbContainer != null) {
			ejbContainer.close();
		}
	}
}
