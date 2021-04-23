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