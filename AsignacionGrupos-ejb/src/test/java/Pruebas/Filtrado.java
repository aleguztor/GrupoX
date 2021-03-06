package Pruebas;

import Entidades.*;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.NoExisteGrupoEnAlumno;
import Exceptions.TitulacionNoEncontradaException;

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



public class Filtrado {
	private static final Logger LOG = Logger.getLogger(Filtrado.class.getCanonicalName());
	private static final String BUSQUEDAYFILTRADO = "java:global/classes/BusquedaYFiltradoImpl";
	private static final String UNIDAD_PERSISTENCIA_PRUEBAS = "AsignacionGruposTests";

	private BusquedaYFiltrado bf;
	
	@Before
	public void setup() throws NamingException{
		bf = (BusquedaYFiltrado) SuiteTest.ctx.lookup(BUSQUEDAYFILTRADO);
		Base.init(UNIDAD_PERSISTENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF3"})
	@Test
	public void testFiltradoAlumnos() {
		try {
			List<Alumno> a = new LinkedList<>();
			Alumno a1 = new Alumno("Mario", "Vazquez", "12345678a", "mario@uma.es");
			Alumno a2 = new Alumno("Juan", "Moreno", "23456789b", "juan@uma.es");
			Alumno a3 = new Alumno("Marta", "Ruiz", "34567890c", "marta@uma.es");
			a.add(a1);
			a.add(a2);
			a.add(a3);
			Titulacion t =  new Titulacion(1014,"Desarrollo movil",550);
			Asignatura as = new Asignatura("rf12","Desarrollo de maquinas virtuales",9999,12,true,false);
			List<Alumno> res = bf.filtradoAlumnos(t, as);
			assertEquals(a, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	@Requisitos({"RF3"})
	@Test 
	public void testBuscarTitulacionPorNombre() {
		String nombre="Desarrollo movil";
		try {
			Titulacion t= bf.buscarTitulacionPorNombre(nombre);
			assertEquals(nombre,t.getNombre());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
