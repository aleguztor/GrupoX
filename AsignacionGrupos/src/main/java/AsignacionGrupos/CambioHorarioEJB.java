package AsignacionGrupos;

import java.io.File;
import java.util.List;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.*;



public class CambioHorarioEJB implements CambioHorario {
 
	@Override
	public void CambioHorarioyGrupo(Alumno alum, Grupo antiguo, Grupo nuevo) throws AsignacionGruposException {
		if(alum==null) {
			throw  new AlumnoNoEncontradoException();
		}
		
		List<Grupo> grupos= alum.getAlumno_Grupos();
		grupos.remove(antiguo);
		grupos.add(nuevo);			
	}



	@Override
	public long numeroPlazas(Grupo grupo) throws AsignacionGruposException {
		return grupo.getPlazas();
		
	}



}
