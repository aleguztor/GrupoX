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



public class ModAlumnos {
	private static final Logger LOG = Logger.getLogger(ModAlumnos.class.getCanonicalName());
	private static final String MODIFICARGRUPO = "java:global/classes/ModificarGrupoEJB";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	
	
	private CrudEJBLocal crud;
	private ModificarGrupoAlumno modg;

	
	@Before
	public void setup() throws NamingException{
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		modg = (ModificarGrupoAlumno) SuiteTest.ctx.lookup(MODIFICARGRUPO);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
//	@Requisitos({"RF8"})
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
	
}
