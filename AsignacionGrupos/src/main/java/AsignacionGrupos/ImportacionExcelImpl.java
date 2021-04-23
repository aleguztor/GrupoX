package AsignacionGrupos;

import Exceptions.ExcelNoEncontradoException;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import javax.ejb.*;

@Stateless
public class ImportacionExcelImpl implements ImportacionExcel{
	
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
 
    }
}

