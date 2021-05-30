package Pruebas;

import Entidades.*;
import Entidades.Encuesta.Expediente_Encuesta_PK;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.NoExisteGrupoEnAlumno;

import static org.junit.Assert.*;

import java.io.File;
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
	
//	@Requisitos({"RF5"})
	@Test
	public void testAsignarEncuesta() {
		Date d = new Date(System.currentTimeMillis());
		try {
			Alumno a = crud.buscarAlumnoPorDNI("12345678a");
			Expediente e = a.getExpedientes().get(0);
			Encuesta en = new Encuesta(d, e, "Manyana");
			en.setExpediente(e);
			negocio.asignarEncuesta(e.getNum_Expediente(), en);
			a = crud.buscarAlumnoPorDNI("12345678a");
			assertEquals(a.getExpedientes().get(0).getEncuesta().get(0).getExpediente().getNum_Expediente(), e.getNum_Expediente());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	@Test 
	public void testcrearEncuesta() {
		Date d=new Date(System.currentTimeMillis());
	
		String curso="Quiero el 2";
		String razones="Me enfado con el de la derecha";
		File f= new File("pruebapdf.txt");
		Encuesta e= new Encuesta(d,curso, razones, f);
		try {
		crud.insertarEncuesta(e);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
