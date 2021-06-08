package AsignacionGrupos;


import javax.ejb.*;
import Exceptions.ExcelNoEncontradoException;

@Local
public interface ImportacionExcel {

	public void ImportarExcel(String ruta) throws ExcelNoEncontradoException;
}
