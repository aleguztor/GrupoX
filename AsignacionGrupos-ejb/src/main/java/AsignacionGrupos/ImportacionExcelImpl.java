package AsignacionGrupos;

import Exceptions.ExcelNoEncontradoException;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;



import Entidades.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class ImportacionExcelImpl implements ImportacionExcel{
	@PersistenceContext(unitName="AsignacionGrupos")
	private EntityManager em;
	
	@Override
	public void ImportarExcel() throws ExcelNoEncontradoException{
	
        String excelFilePath = "target/PruebaAlumnadoFAKE.xlsx";
 
        
        try {
            
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0); //miramos la hoja que vamos a usar
            Iterator<Row> rowIterator = firstSheet.iterator(); //iterador de fila
            Row next = rowIterator.next();
            Iterator<Cell> cell = next.cellIterator();
            String curso;
            while(cell.hasNext()) {
            	Cell n = cell.next();
            	int columnIn = n.getColumnIndex();
            	if(columnIn ==1) {
            		curso = n.getStringCellValue();
            	}
            }
            rowIterator.next(); 
            rowIterator.next();
            rowIterator.next();//saltamos las 4 primeras filas para obtener los datos
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator(); //para movernos por la fial
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    Alumno al = new Alumno();
                    Matricula mal;
                    Expediente exp = new Expediente();
                    MatriculaPK mpk = new MatriculaPK();
                    Date d = new Date(0);//fecha vacia
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0: //DNI
                        String dni= nextCell.getStringCellValue();
                        al.setDNI(dni);
                 
                        break;
                    case 1: //NOMBRE
                    	String nombre = nextCell.getStringCellValue();
                    	al.setNombre(nombre);
                    	
                        break;
                    case 2: //PRIMER APELLIDO
                    	String apellido1 = nextCell.getStringCellValue();
                    	al.setApellido1(apellido1);
                    	
                        break;
                    case 3: //SEGUNDO APELLIDO
                    	String apellido2 = nextCell.getStringCellValue();
                    	al.setApellido2(apellido2);
                        break;  
                    case 4: //N EXPEDIENTE
                    	String num_exp = nextCell.getStringCellValue();
                    	mpk.setExpedientes_num_expedientes(Long.parseLong(num_exp));
                    	mpk.setCurso_academico(curso);
                    	exp.setNum_Expediente(Long.parseLong(num_exp));
                    	
                        break;
                    case 5: //N ARCHIVO
                    	String n_archivo = nextCell.getStringCellValue();
                    	mal = new Matricula(mpk, exp, 'A', d);
                        mal.setCurso_academico(curso);
                        mal.setNum_archivo(Integer.parseInt(n_archivo));
                        break;    
                    case 6: //EMAIL_INSTITUCIONAL
                    	String email_institucional = nextCell.getStringCellValue();
                    	al.setEmail_institucional(email_institucional);
                        
                        break;
                    case 7: //EMAIL_PERSONAL
                    	String email_personal = nextCell.getStringCellValue();
                    	al.setEmail_personal(email_personal);

                        break;
                    
                    case 8: //telefono
                    	String telefono = nextCell.getStringCellValue();
                    	al.setTelefono(telefono);
                    	break;
 
                    case 9: //movil
                    	String movil = nextCell.getStringCellValue();
                    	 al.setMovil(movil);
                    	break;
                    case 10: //direccion
                    	String direccion =  nextCell.getStringCellValue();
                    	al.setDireccion_notificacion(direccion);
                    	break;
                    case 11: //provincia
                    	String provincia = nextCell.getStringCellValue();
                    	al.setProvincia_notificacion(provincia);
                    	break;
                    case 12: //cp
                    	String cp = nextCell.getStringCellValue();
                    	al.setCP_notificacion(cp);
                    	break;
                    case 13: //fecha_mat
                    	String fecha =nextCell.getStringCellValue();
                    	mal.setFecha_matricula(new Date(Date.parse(fecha)));
                    	break;
                    case 14: //turno preferente
                    	break;
                    case 15: //grupos_asignados
                    	String list = nextCell.getStringCellValue();
                    	mal.setListado_asignaturas(list);
                    	//NOSE RELLENAR ASIGNATURAS MATRICULA
                    	break;
                    case 16: //nota_media
                    	String nota_media = nextCell.getStringCellValue();
                    	exp.setNota_Media_Provisional(Double.parseDouble(nota_media));
                    	break;
                    case 17: //creditos superados
                    	break;
                    case 18: //creditos fb
                    	break;
                    case 19: //creditos ob
                    	break;
                    case 20: //creditos cf
                    	break;
                    	
                    case 21: //creditos pe
                    	break;
                    case 22: //creditos tf
                    	break;
                }
                exp.setAlumno(al);
                List<Expediente> expedientes = al.getExpedientes();
                expedientes.add(exp);
                List<Matricula> matriculas = exp.getMatricula();
                matriculas.add(mal);
                al.setExpedientes(expedientes);
                mal.setExpedientes_num_expedientes(exp);
                 
               
            }
 
            workbook.close();
             
            // execute the remaining queries
           
             
            
             
       
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    }

	}
}
	/*
	@Override
	public void ImportarExcel() throws ExcelNoEncontradoException{
		String jdbcURL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";
        String username = "";
        String password = "";
 
        String excelFilePath = "target/PruebaAlumnadoFAKE.xlsx";
 
        int batchSize = 20;
 
        Connection connection = null;
 
        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
  
            String sql = "INSERT INTO ALUMNO (DNI, NOMBRE, APELLIDO1, APELLIDO2, EMAIL_INSTITUCIONAL, EMAIL_PERSONAL, MOVIL, TELEFONO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);    
             
            int count = 0;
             
            rowIterator.next(); 
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String dni = nextCell.getStringCellValue();
                        statement.setString(1, dni);
                        break;
                    case 1:
                    	String nombre = nextCell.getStringCellValue();
                        statement.setString(2, nombre);
                        break;
                    case 2:
                    	String apellido1 = nextCell.getStringCellValue();
                        statement.setString(3, apellido1);
                        break;
                    case 3:
                    	String apellido2 = nextCell.getStringCellValue();
                        statement.setString(4, apellido2);
                        break;  
                    case 4:
                    	String email_ins = nextCell.getStringCellValue();
                        statement.setString(5, email_ins);
                        break;
                    case 5:
                    	String email_per = nextCell.getStringCellValue();
                        statement.setString(6, email_per);
                        break;    
                    case 6:
                    	String telefono = nextCell.getStringCellValue();
                        statement.setString(7, telefono);
                        break;
                    case 7:
                    	String movil = nextCell.getStringCellValue();
                        statement.setString(8, movil);
                        break;
                    }
 
                }
                 
                statement.addBatch();
                 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            statement.executeBatch();
  
            connection.commit();
            connection.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }
 
    }*/
}

