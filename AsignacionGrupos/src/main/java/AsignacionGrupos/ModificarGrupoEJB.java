package AsignacionGrupos;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Grupo;
import Entidades.Matricula;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.AsignacionGruposException;
import Exceptions.NoExisteGrupoEnAlumno;

public class ModificarGrupoEJB implements ModificarGrupoAlumno{
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) {
		Expediente e = m.getExpedientes_num_expedientes();
		return e.getAlumno().getAlumno_Grupos();
	}
	
	//Suponiedo que solo exista el expediente de informatica
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) {
		List<Alumno> alumnos = g.getAlumno();
		Iterator<Alumno> it = alumnos.iterator();
		List<Matricula> matriculas = new LinkedList<>();
		while(it.hasNext()) {
			Matricula m = it.next().getExpedientes().get(0).getMatricula().get(0);
			matriculas.add(m);
		}
		return matriculas;
	}
	
	public void CambioGrupoAlumnos(List<Alumno> alum, Grupo antiguo, Grupo nuevo) throws  NoExisteGrupoEnAlumno{
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
	@Override
	public void CambioHorarioyGrupo(Alumno alum, Grupo antiguo, Grupo nuevo) throws AsignacionGruposException {
		if(alum==null) {
			throw  new AlumnoNoEncontradoException();
		}
		
		List<Grupo> grupos= alum.getAlumno_Grupos();
		grupos.remove(antiguo);
		grupos.add(nuevo);			
	}
	
}
