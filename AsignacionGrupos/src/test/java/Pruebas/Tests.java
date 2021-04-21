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
	public void testModificarExpediente() {
		try {
			Expediente ex = new Expediente((long)214623, true, 9.2);
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
			Alumno al = new Alumno("Jose", "Gutierrez", "8461761r", "asd@uma.es");
			crud.insertarAlumno(al);
			al.setDireccion_notificacion("Calle la mia");
			al.setEmail_personal("pepito@gmail.com");
			al.setLocalidad_notificacion("Malaga");
			al.setTelefono("123123");
			crud.modificarAlumno(al);
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
	public void testCambioGrupoAlumnos() {
		List<Alumno> alumnos = new LinkedList<>();
		try {
			alumnos.add(crud.buscarAlumnoPorDNI("12345678a"));
			Grupo a = crud.busquedaGrupo("2º", "a", "Manyana");
			Grupo n = crud.busquedaGrupo("1º", "c","Tarde");
			modg.CambioGrupoAlumnos(alumnos, a, n);
			assertEquals(alumnos.get(0).getAlumno_Grupos().indexOf(a),-1);
			assertEquals(alumnos.get(0).getAlumno_Grupos().get(alumnos.get(0).getAlumno_Grupos().indexOf(n)),n);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Test
    public void TestLimitarPlazasNuevoIngreso() {
        Grupo g = new Grupo("1º", "c","Tarde");
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

        Grupo g=new Grupo("1º","c","Tarde");
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
			Grupo g = crud.busquedaGrupo("1º", "a", "Manyana");
			limpla.EliminarGrupoPorFaltaDeAlumnos(g);
			assertNull(crud.busquedaGrupo("1º", "a", "Manyana"));
			
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
