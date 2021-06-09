package AsignacionGrupos;

import Exceptions.ExcelNoEncontradoException;

import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

import Entidades.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class ImportacionExcelImpl implements ImportacionExcel {
	@PersistenceContext(unitName = "AsignacionGrupos")
	private EntityManager em;
	@EJB
	CrudEJBLocal crud;
	private static final Logger LOG = Logger.getLogger(ImportacionExcelImpl.class.getCanonicalName());

	@Override
	public void ImportarExcel(String ruta) throws ExcelNoEncontradoException {

		LOG.info("EMPEZAMOS LA IMPORTACION DEL ARCHIVO");
		try {

			FileInputStream inputStream = new FileInputStream(ruta);
			Long id = (Long) em.createQuery("select max(id) from Alumno").getSingleResult();
			if (id == null)
				id = 0L;
			Workbook workbook = new XSSFWorkbook(inputStream);
			boolean acaba = false;
			Sheet firstSheet = workbook.getSheetAt(0); // miramos la hoja que vamos a usar
			Iterator<Row> rowIterator = firstSheet.iterator(); // iterador de fila
			Row next = rowIterator.next();
			Iterator<Cell> cell = next.cellIterator();
			String curso = null;
			while (cell.hasNext() && !acaba) {
				Cell n = cell.next();
				int columnIn = n.getColumnIndex();
				if (columnIn == 1) {
					curso = n.getStringCellValue();
				}
			}
			rowIterator.next();
			rowIterator.next();
			rowIterator.next();
			// saltamos las 4 primeras filas para obtener los datos
			while (rowIterator.hasNext() &&!acaba) {
				Row nextRow = rowIterator.next();
				Alumno al = new Alumno();
				Matricula mal = null;
				Expediente exp = new Expediente();
				MatriculaPK mpk = new MatriculaPK();
				Date d = new Date(0);// fecha vacia
				List<Expediente> expedientes;
				List<Matricula> matriculas;
				Iterator<Cell> cellIterator = nextRow.cellIterator(); // para movernos por la fial
				while (cellIterator.hasNext() && !acaba) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0: // DNI
						String dni = nextCell.getStringCellValue();
						if(dni==""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setDNI(dni);
						LOG.info("mete dni " + dni);
						break;
					case 1: // NOMBRE
						String nombre = nextCell.getStringCellValue();
						if(nombre==""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setNombre(nombre);
						LOG.info("mete nombre");
						break;
					case 2: // PRIMER APELLIDO
						String apellido1 = nextCell.getStringCellValue();
						if(apellido1==""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setApellido1(apellido1);
						LOG.info("mete apellido1");
						break;
					case 3: // SEGUNDO APELLIDO
						String apellido2 = nextCell.getStringCellValue();
						if(apellido2==""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setApellido2(apellido2);
						LOG.info("mete apellido2");
						break;
					case 4:// N EXPEDIENTE
						String num_exp = nextCell.getStringCellValue();
						if(num_exp == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						mpk.setExpedientes_num_expedientes(Long.parseLong(num_exp));
						mpk.setCurso_academico(curso);
						exp.setNum_Expediente(Long.parseLong(num_exp));
						LOG.info("mete n_expediente");

						break;
					case 5: // N ARCHIVO
						Integer n_archivo = (int) nextCell.getNumericCellValue();
						if(n_archivo == null) {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						mal = new Matricula(mpk, exp, 'A', d);
						mal.setCurso_academico(curso);
						mal.setNum_archivo(n_archivo);
						LOG.info("mete archivo");
						break;
					case 6: // EMAIL_INSTITUCIONAL
						String email_institucional = nextCell.getStringCellValue();
						al.setEmail_institucional(email_institucional);
						LOG.info("mete email institucional");
						break;
					case 7: // EMAIL_PERSONAL
						String email_personal = nextCell.getStringCellValue();
						if(email_personal == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setEmail_personal(email_personal);
						LOG.info("mete email personal");
						break;

					case 8: // telefono
						String telefono = nextCell.getStringCellValue();
						if(telefono == ""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setTelefono(telefono);
						LOG.info("mete telefono");
						break;

					case 9: // movil
						String movil = nextCell.getStringCellValue();
						if(movil == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setMovil(movil);
						LOG.info("mete movil");
						break;
					case 10: // direccion
						String direccion = nextCell.getStringCellValue();
						if(direccion == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setDireccion_notificacion(direccion);
						LOG.info("mete direccion");
						break;
					case 11: // localidad
						String localidad = nextCell.getStringCellValue();
						if(localidad == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setLocalidad_notificacion(localidad);
						LOG.info("mete localidad");
					case 12: // provincia
						String provincia = nextCell.getStringCellValue();
						if(provincia == ""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setProvincia_notificacion(provincia);
						LOG.info("mete provincia");
						break;
					case 13: // cp
						String cp = nextCell.getStringCellValue();
						if(cp == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						al.setCP_notificacion(cp);
						LOG.info("mete cp");
						break;
					case 14: // fecha_mat
						String fecha = nextCell.getStringCellValue();
						if(fecha == ""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						LOG.severe(fecha);
						java.util.Date fecha1 = new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(fecha);

						Date fe = new Date(fecha1.getTime());
						mal.setFecha_matricula(fe);
						LOG.info("mete fecha_matricula");
						break;
					case 15:
						break;
					case 16: // grupos_asignados
						String list = nextCell.getStringCellValue();
						if(list == ""){
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						mal.setListado_asignaturas(list);
						LOG.info("mete grupos asignados" + list);
						// NOSE RELLENAR ASIGNATURAS MATRICULA
						break;
					case 17: // nota_media
						String nota_media = nextCell.getStringCellValue();
						if(nota_media == "") {
							LOG.info("faltan datos");
							acaba = true;
							continue;
						}
						LOG.info("mete nota media" + nota_media);
						exp.setNota_Media_Provisional(Double.parseDouble(nota_media));

						break;
					case 18: // creditos superados
						break;
					case 19: // creditos fb
						break;
					case 20: // creditos ob
						break;
					case 21: // creditos cf
						break;

					case 22: // creditos pe
						break;
					case 23: // creditos tf
						al.setId(id+1L);
						id++;
						
						  LOG.severe(al.toString()); exp.setAlumno(al); expedientes =
						  al.getExpedientes(); if (expedientes == null) { expedientes = new
						  LinkedList<Expediente>(); } expedientes.add(exp);
						  al.setExpedientes(expedientes); matriculas = exp.getMatricula();
						  
						  matriculas.add(mal); exp.setMatricula(matriculas);
						  al.setExpedientes(expedientes); LOG.severe(exp.toString());
						  
						  mal.setExpedientes_num_expedientes(exp); LOG.severe(exp.toString());
						 
						LOG.severe(al.toString());
						LOG.severe(mal.toString());
						em.persist(em.merge(al));
						LOG.info("ALUMNO INSERTADO");
						
						/*
						 * em.persist(em.merge(exp)); LOG.info("EXPEDIENTE INSERTADO");
						 * em.persist(em.merge(mal)); LOG.info("MATRICULAINSERTADO");
						 */
						break;
					}

				}
				
				

			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void ImportarAsignaturas(String ruta) throws ExcelNoEncontradoException {

		LOG.info("EMPEZAMOS LA IMPORTACION DEL ARCHIVO");
		try {
		
			FileInputStream inputStream = new FileInputStream(ruta);
			Workbook workbook = new XSSFWorkbook(inputStream);
			
			int numeroDePaginas = workbook.getNumberOfSheets();
			int i=0;
			LOG.severe("WHILE");
			while(i<numeroDePaginas) {
				Sheet sheet = workbook.getSheetAt(i); // miramos la hoja que vamos a usar
				Iterator<Row> rowIterator = sheet.iterator(); // iterador de fila
				Row next = rowIterator.next();
				Iterator<Cell> cell = next.cellIterator();
				Titulacion t = new Titulacion();
				String titulacionNombre = sheet.getSheetName();
				LOG.info("tenemos el nombre de la titulacion " + titulacionNombre);
				Integer codigo = Integer.MIN_VALUE;
				boolean acaba = false;
				boolean tenemosCodigo = false;
				List<Asignatura> asignaturas = new LinkedList<Asignatura>();
				switch(titulacionNombre) {
				case "GII":
					titulacionNombre = "Grado en Ingeniería Informática";
					break;
				case "GISw":
					titulacionNombre = "Grado en Ingeniería del Software";
					break;
				case "GICom":
					titulacionNombre = "Grado en Ingenieria de Computadores";
					break;
				case "Grado Ing. Salud":
					titulacionNombre = "Grado en Ingeniería de la Salud";
					break;
				case "GII+GIM":
					titulacionNombre= "Doble Grado en Ingeniería Informática y Matemáticas";
					break;
				}
				LOG.info("CAMBIAMOS EL NOMBRE");
				rowIterator.next();
				while (rowIterator.hasNext() &&!acaba) {
					Row nextRow = rowIterator.next();
					Asignatura as = new Asignatura();
					Iterator<Cell> cellIterator = nextRow.cellIterator(); // para movernos por la fial
					while (cellIterator.hasNext() && !acaba) {
						Cell nextCell = cellIterator.next();

						int columnIndex = nextCell.getColumnIndex();

						switch (columnIndex) {
						case 0: // titulacion
							int j =1;
							if(!tenemosCodigo) {
								LOG.info("SACAMOS EL CODIGO DE TITULACION");
								codigo =  (int) nextCell.getNumericCellValue();
								t.setCodigo(codigo);
								t.setNombre(titulacionNombre);
								t.setCreditos(240);
								em.persist(em.merge(t));
								LOG.info("Titulacion insertada");
								tenemosCodigo=true;
								j++;
							}
							if((nextCell.getNumericCellValue() == 0)) acaba= true;
							LOG.info("titulacion ");
							break;
						case 1: // ofertada
							String ofertada = nextCell.getStringCellValue();
							if(ofertada.equals("")){
								LOG.info("faltan datos");
								acaba = true;
								continue;
							}
							boolean of;
							if(ofertada.equals("Sí")) {
								of= true;
							}else {
								of=false;
							}
							as.setOfertada(of);
							LOG.info("ofertada");
							break;
						case 2: // codigo
							Integer cod = (int)nextCell.getNumericCellValue();
							
							as.setCodigo(cod);
							LOG.info("codigo");
							break;
						case 3: // referencia
							String ref = Double.toString((int)nextCell.getNumericCellValue());
							if(ref==""){
								LOG.info("faltan datos");
								acaba = true;
								continue;
							}
							as.setReferencia(ref);
							LOG.info("referencia");
							break;
						case 4:// asignatura
							String nombre = nextCell.getStringCellValue();
							if(nombre== "") {
								LOG.info("faltan datos");
								acaba = true;
								continue;
							}
							as.setNombre(nombre);
							LOG.info("nombre");

							break;
						case 5: // curso
							String curso =Double.toString(nextCell.getNumericCellValue());
							if(curso == null) {
								LOG.info("faltan datos");
								acaba = true;
								continue;
							}
							as.setCurso(curso);
							LOG.info("curso");
							break;
						case 6: // credito teoria
							
							LOG.info("creditos teoria");
							break;
						case 7: // credito practica
							
							break;
						case 8:
							Integer creditos;
							if(codigo == 1056) { //ingenieria de la salud si 4.5 = 5
								String cr = nextCell.getStringCellValue();
								if(cr == "4.5")
									creditos = 5;
								
							}else {
								creditos = (int) nextCell.getNumericCellValue();
								as.setCreditos(creditos);
							}
							
							LOG.info("creditos");
							break;
						case 9: // duracion
							String duracion = nextCell.getStringCellValue();
							int dur;
							if(duracion == ""){
								LOG.info("faltan datos");
								acaba = true;
								continue;
							}
							if(duracion =="1º Semestre" || duracion == "1º") {
								dur =1;
							}else {
								dur=2;
							}
							as.setDuracion(dur);
							LOG.info("duracion");
							break;

						case 10: // plazas
							break;
						case 11: // otro idioma
							String idioma = nextCell.getStringCellValue();
							if(idioma == "") {
								as.setIdioma_de_imparticion(false);
							}
							as.setIdioma_de_imparticion(true);
							LOG.info("idioma");
							asignaturas.add(as);
							as.setTitulacion(t);
							em.persist(em.merge(as));
							break;
						
						}

					}
					
					

				}
				//update de titulacion
				Titulacion ti = em.merge(t);
				ti.setAsignaturas(asignaturas);
				i++;
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
