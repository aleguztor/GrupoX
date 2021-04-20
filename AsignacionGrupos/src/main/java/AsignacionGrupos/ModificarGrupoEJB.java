package AsignacionGrupos;
import java.util.Iterator;
import java.util.List;

import Entidades.*;
import Exceptions.NoExisteGrupoEnAlumno;

public class ModificarGrupoEJB {
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) {
		Expediente e = m.getExpedientes_num_expedientes();
		return e.getAlumno().getAlumno_Grupos();
	}
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) {
		return g.getAlumno().getExpedientes().get(0).getMatricula();
	}
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws NoExisteGrupoEnAlumno {
		Iterator<Alumno> it = alum.iterator();
	
		while(it.hasNext()) {
			Alumno al= it.next();
			List<Grupo> grupos= al.getAlumno_Grupos();
			
			if(grupos.indexOf(antiguo)<0) {
				throw new NoExisteGrupoEnAlumno();
			}
		
			grupos.remove(antiguo);
			grupos.add(nuevo);
				
		}
	}
}
