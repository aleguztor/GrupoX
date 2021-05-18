package AsignacionGrupos;

import javax.ejb.*;
import java.io.File;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.*;

@Local
public interface CambioHorario {
	/* crear formulario en el jsf*/
	
	
	public void CambioHorarioyGrupo(Alumno alumn,Grupo antiguo, Grupo nuevo) throws AsignacionGruposException;
	// Alumno para saber el cambio que haremos al alumno
	// letranueva para saber la nueva letra que quiere el alumno
	// antigualetra para saber la letra que tenia antes
	// g para introducir el grupo nuevo que tendrá
	// este procedimiento pide todo lo anterior y dependiendo de si hay o no plazas, cosa que se mostrara en el jsf, podremos cambiar
	// de lugar al alumno correspondiente
	
	/*
	 * El siguiente procedimiento será para el jsf, cuando nos pida el adjuntar archivos, deberemos almacenarlo en algun lado.
	 * en Alumno añadiremos la columna de archivo adjunto, que será un pdf en el que pondremos la informacion necesaria
	 */

	
	
	public long numeroPlazas(Grupo grupo) throws AsignacionGruposException;
	
}
