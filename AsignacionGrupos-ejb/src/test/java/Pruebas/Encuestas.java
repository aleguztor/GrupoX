package Pruebas;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import AsignacionGrupos.AsignarEncuestas;
import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Encuesta;
import Entidades.EncuestaCambioHorario;
import Entidades.Expediente;
import Entidades.Expediente_Encuesta_PK;



public class Encuestas {
	private static final Logger LOG = Logger.getLogger(Encuestas.class.getCanonicalName());
	private static final String ASIGNARENCUESTA = "java:global/classes/AsignarEncuestasImpl";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	
	
	private AsignarEncuestas negocio;
	private CrudEJBLocal crud;

	
	@Before
	public void setup() throws NamingException{
		negocio = (AsignarEncuestas) SuiteTest.ctx.lookup(ASIGNARENCUESTA);
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF5"})
	@Test
	public void testAsignarEncuesta() {
		Date d = new Date(System.currentTimeMillis());
		try {
			Alumno a = crud.buscarAlumnoPorDNI("12345678a");
			Expediente e = a.getExpedientes().get(0);
			Expediente_Encuesta_PK pk = new Expediente_Encuesta_PK(e.getNum_Expediente(), d);
			Encuesta en = new Encuesta(pk, e, "Manyana");
			en.setExpediente(e);
			negocio.asignarEncuesta(e.getNum_Expediente(), en);
			a = crud.buscarAlumnoPorDNI("12345678a");
			assertEquals(a.getExpedientes().get(0).getEncuesta().get(0).getExpediente().getNum_Expediente(), e.getNum_Expediente());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Requisitos({"RF5"})
	@Test 
	public void testcrearEncuestaCambioHorario() {
		Date d = new Date(System.currentTimeMillis());
		String dni="12313123A";
		String curso="Quiero el 2";
		String razones="Me enfado con el de la derecha";
		byte[] f= new byte[1024];
		EncuestaCambioHorario e= new EncuestaCambioHorario(d,curso,dni);
		e.setRazones(razones);
		e.setDocumentos(f);
		try {
		crud.insertarEncuestaCambioHorario(e);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
