package Pruebas;

import Entidades.*;
import Entidades.Encuesta.Expediente_Encuesta_PK;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.NoExisteGrupoEnAlumno;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


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
	private CrudEJB crud;
	private ModificarGrupoEJB modg;
	private CambioHorarioEJB cambh;
	
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
	@Ignore
	public void testAsignarEncuesta() {
		Date d = new Date(System.currentTimeMillis());
		Expediente e = new Expediente((long)123123, true, 5.0);
			

		try {
			negocio.asignarEncuesta(e.getNum_Expediente(), d, "Manyana");
			Alumno al = negocio.obtenerAlumnoPorExpediente(e.getNum_Expediente());
			Expediente e1 = al.getAlumno_expedientes().get(al.getAlumno_expedientes().indexOf(e));
			Assert.assertEquals(e.getNum_Expediente(), e1.getEncuesta().get(0).getExpediente().getNum_Expediente());
		} catch (ExpedienteNoEncontradoException e1) {
			e1.printStackTrace();
		}
	}
	
	
	@Test
	public void testModificar() {
		try {
			Expediente ex = new Expediente((long)123141234, true, 9.2);
			crud.modificarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e,ex);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testEliminarExp() {
		try {
			Expediente ex = new Expediente((long) 12123123, true, 9);
			crud.eliminarExpediente(ex);;
			assertNull(crud.existeExpediente(ex));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsertarExp() {
		try {
			Expediente ex = new Expediente((long) 12314512,true,6);
			crud.insertarExpediente(ex);
			Expediente e = crud.existeExpediente(ex);
			assertEquals(e,ex);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInsertarAl() {
		try {
			Alumno al = new Alumno("Mario", "Vazquez", "1235754a", "asd@uma.es");
			crud.insertarAlumno(al);
			Alumno a = crud.existeAlumno(al);
			assertEquals(a,al);
			
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testModificarAl() {
		try {
			Alumno al = new Alumno("Mario", "Vazquez", "1235754a", "asd@uma.es");
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
	public void testBusqueda() {
		try {
			Alumno al = new Alumno("Mario", "Vazquez", "1235754a", "asd@uma.es");
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCambioGrupoAlumnos() {
		Alumno al = new Alumno("PEPE", "viruela", "124536b", "adassa@uma.es");
		Alumno ab = new Alumno("Mario", "Vazquez", "1235754a", "asd@uma.es");
		Alumno ac = new Alumno("Alejandro", "Torres", "124232b", "23cvd@uma.es");
		List<Alumno> listaalumnos = new ArrayList<>();
		listaalumnos.add(al);
		listaalumnos.add(ab);
		listaalumnos.add(ac);
		Grupo a = new Grupo("2º", "a","Mañana");
		Grupo b = new Grupo("1º", "b","Mañana");
		Grupo c = new Grupo("1º", "c","Tarde");
		List<Grupo> grupos= new ArrayList<>();
		grupos.add(a);
		grupos.add(b);
		grupos.add(c);
		al.setAlumno_Grupos(grupos);
		ab.setAlumno_Grupos(grupos);
		ac.setAlumno_Grupos(grupos);
		Grupo nuevo= new Grupo("1º", "a", "Mañana");
		try {
			modg.CambioGrupoAlumnos(listaalumnos, c, nuevo);
			assertEquals(al.getAlumno_Grupos().indexOf(c),-1);
			grupos=al.getAlumno_Grupos();
			assertEquals(grupos.get(grupos.indexOf(nuevo)),nuevo);
		} catch (Exception e) {
		
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
