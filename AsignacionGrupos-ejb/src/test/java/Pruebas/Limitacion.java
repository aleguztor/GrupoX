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



public class Limitacion {
	private static final Logger LOG = Logger.getLogger(Limitacion.class.getCanonicalName());
	private static final String LIMITEPLAZAS = "java:global/classes/LimitePlazasEJB";
	private static final String CRUDEJB = "java:global/classes/CrudEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	
	
	private CrudEJBLocal crud;
	private LimitePlazas limpla;

	
	@Before
	public void setup() throws NamingException{
		crud = (CrudEJBLocal) SuiteTest.ctx.lookup(CRUDEJB);
		limpla = (LimitePlazas) SuiteTest.ctx.lookup(LIMITEPLAZAS);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
//	@Requisitos({"RF7"})
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
	
//	@Requisitos({"RF7"})
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
	
}
