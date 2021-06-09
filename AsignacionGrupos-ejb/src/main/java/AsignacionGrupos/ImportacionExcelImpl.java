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

			Sheet firstSheet = workbook.getSheetAt(0); // miramos la hoja que vamos a usar
			Iterator<Row> rowIterator = firstSheet.iterator(); // iterador de fila
			Row next = rowIterator.next();
			Iterator<Cell> cell = next.cellIterator();
			String curso = null;
			while (cell.hasNext()) {
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
			while (rowIterator.hasNext()) {
				Row nextRow = rowIterator.next();
				Alumno al = new Alumno();
				Matricula mal = null;
				Expediente exp = new Expediente();
				MatriculaPK mpk = new MatriculaPK();
				Date d = new Date(0);// fecha vacia
				List<Expediente> expedientes;
				List<Matricula> matriculas;
				Iterator<Cell> cellIterator = nextRow.cellIterator(); // para movernos por la fial
				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();

					int columnIndex = nextCell.getColumnIndex();

					switch (columnIndex) {
					case 0: // DNI
						String dni = nextCell.getStringCellValue();
						al.setDNI(dni);
						LOG.info("mete dni " + dni);
						break;
					case 1: // NOMBRE
						String nombre = nextCell.getStringCellValue();
						al.setNombre(nombre);
						LOG.info("mete nombre");
						break;
					case 2: // PRIMER APELLIDO
						String apellido1 = nextCell.getStringCellValue();
						al.setApellido1(apellido1);
						LOG.info("mete apellido1");
						break;
					case 3: // SEGUNDO APELLIDO
						String apellido2 = nextCell.getStringCellValue();
						al.setApellido2(apellido2);
						LOG.info("mete apellido2");
						break;
					case 4:// N EXPEDIENTE
						String num_exp = nextCell.getStringCellValue();
						mpk.setExpedientes_num_expedientes(Long.parseLong(num_exp));
						mpk.setCurso_academico(curso);
						exp.setNum_Expediente(Long.parseLong(num_exp));
						LOG.info("mete n_expediente");

						break;
					case 5: // N ARCHIVO
						Integer n_archivo = (int) nextCell.getNumericCellValue();
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
						al.setEmail_personal(email_personal);
						LOG.info("mete email personal");
						break;

					case 8: // telefono
						String telefono = nextCell.getStringCellValue();
						al.setTelefono(telefono);
						LOG.info("mete telefono");
						break;

					case 9: // movil
						String movil = nextCell.getStringCellValue();
						al.setMovil(movil);
						LOG.info("mete movil");
						break;
					case 10: // direccion
						String direccion = nextCell.getStringCellValue();
						al.setDireccion_notificacion(direccion);
						LOG.info("mete direccion");
						break;
					case 11: // localidad
						String localidad = nextCell.getStringCellValue();
						al.setLocalidad_notificacion(localidad);
						LOG.info("mete localidad");
					case 12: // provincia
						String provincia = nextCell.getStringCellValue();
						al.setProvincia_notificacion(provincia);
						LOG.info("mete provincia");
						break;
					case 13: // cp
						String cp = nextCell.getStringCellValue();
						al.setCP_notificacion(cp);
						LOG.info("mete cp");
						break;
					case 14: // fecha_mat
						String fecha = nextCell.getStringCellValue();
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
						mal.setListado_asignaturas(list);
						LOG.info("mete grupos asignados" + list);
						// NOSE RELLENAR ASIGNATURAS MATRICULA
						break;
					case 17: // nota_media
						String nota_media = nextCell.getStringCellValue();
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
						/*
						 * LOG.severe(al.toString()); exp.setAlumno(al); expedientes =
						 * al.getExpedientes(); if (expedientes == null) { expedientes = new
						 * LinkedList<Expediente>(); } expedientes.add(exp);
						 * al.setExpedientes(expedientes); matriculas = exp.getMatricula();
						 * 
						 * matriculas.add(mal); exp.setMatricula(matriculas);
						 * al.setExpedientes(expedientes); LOG.severe(exp.toString());
						 * 
						 * mal.setExpedientes_num_expedientes(exp); LOG.severe(exp.toString());
						 */
						LOG.severe(al.toString());
						LOG.severe(mal.toString());
						//crud.insertarExpediente(exp);
						//crud.insertarMatricula(mal);
						crud.insertarAlumno(al);
						
						break;
					}

				}

				workbook.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
