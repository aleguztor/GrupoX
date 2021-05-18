package Pruebas;

import Entidades.*;

import static org.junit.Assert.*;
import java.util.List;
import java.util.logging.Logger;
import javax.naming.NamingException;
import org.junit.*;

import AsignacionGrupos.*;



public class Algoritmo {
	private static final Logger LOG = Logger.getLogger(Algoritmo.class.getCanonicalName());
	private static final String ALGORITMO = "java:global/classes/AlgoritmoImpl";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";
	
	private AlgoritmoIntf alg;
	private CrudEJBLocal crud;

	
	@Before
	public void setup() throws NamingException{
		alg = (AlgoritmoIntf) SuiteTest.ctx.lookup(ALGORITMO);
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
//	@Requisitos({"RF9"})
	@Test
	public void testAlgoritmo() {
		List<Grupo> g = alg.buscarGrupos();
		for(Grupo a : g) {
			LOG.info(a.toString()+"\n");
		}
		alg.asignacionGrupos();
		Alumno a1;
		try {
			a1 = crud.buscarAlumnoPorDNI("12345678a");
			assertEquals(a1.getAlumno_Grupos().get(0).getLetra(), "A");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
}
