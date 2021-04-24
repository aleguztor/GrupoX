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



public class CH {
	private static final Logger LOG = Logger.getLogger(CH.class.getCanonicalName());
	private static final String CAMBIOHORARIOEJB = "java:global/classes/CambioHorarioEJB";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";
	
	private CambioHorario cambh;

	
	@Before
	public void setup() throws NamingException{
		cambh = (CambioHorario) SuiteTest.ctx.lookup(CAMBIOHORARIOEJB);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF4"})
	@Test
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
}
