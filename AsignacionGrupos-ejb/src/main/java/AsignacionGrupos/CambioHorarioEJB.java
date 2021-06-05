package AsignacionGrupos;

import javax.ejb.*;
import java.util.List;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.*;


@Stateless
public class CambioHorarioEJB implements CambioHorario {
	private CrudEJBLocal crud;
	
	@Override
	public void CambioHorarioyGrupo(Alumno alum, Grupo antiguo, Grupo nuevo) throws AsignacionGruposException {
		if(alum==null) {
			throw  new AlumnoNoEncontradoException();
		}
		
		List<Grupo> grupos= alum.getAlumno_Grupos();
		grupos.remove(antiguo);
		grupos.add(nuevo);	
		alum.setGrupos(grupos);
		crud.modificarAlumno(alum);
	}

}
