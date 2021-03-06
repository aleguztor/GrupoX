package Pruebas;

import Entidades.*;
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



public class Importacion {
	private static final Logger LOG = Logger.getLogger(Importacion.class.getCanonicalName());
	private static final String IMPORTACION = "java:global/classes/ImportacionExcelImpl";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	private CrudEJBLocal crud;
	private ImportacionExcel ie;
	
	@Before
	public void setup() throws NamingException{
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		ie = (ImportacionExcel) SuiteTest.ctx.lookup(IMPORTACION);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF1"})
	@Test
	public void testImportacionAlumnos() {
		Alumno a = new Alumno( "Carmelita", "Enr�quez","95115697E", "06104200001@uma.es");
		try {
			String ruta = "target/PruebaAlumnadoFAKE.xlsx";
			ie.ImportarExcel(ruta);
			Alumno res = crud.buscarAlumnoPorDNI("95115697E");
			assertEquals(res.getDNI(), a.getDNI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
}
