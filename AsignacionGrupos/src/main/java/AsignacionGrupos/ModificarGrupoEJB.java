package AsignacionGrupos;
import java.util.Iterator;
import java.util.List;

import Entidades.*;
import Exceptions.*;

public class ModificarGrupoEJB implements ModificarGrupoAlumno{
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) {
		Expediente e = m.getExpedientes_num_expedientes();
		return e.getAlumno().getAlumno_Grupos();
	}
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) {
		return g.getAlumno().getExpedientes().get(0).getMatricula();
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
	// EJEMPLO PARA ALE
	/*
	public void EliminarGrupoporfaltaalumno(List<Alumno> alum, List<Grupo> grupos) {
		long plazaslibres1=0;
		long plazaslibres2=0;
		long plazaslibres3=0;
		long plazaslibres4=0;
		long case1;
		Iterator<Grupo> itg= grupos.iterator();
			while(itg.hasNext()) {
				
			Grupo g= itg.next(); // Cogemos el primer grupo
			
			switch (g.getCurso()) {
			case "1": 			//imaginamos que cogemos el 1º A
					plazaslibres1=g.getAlumno().size()-g.getPlazas();
					if(plazaslibres1) //tenemos 20 alumnos
				
				break;
			case "2":
				plazaslibres2+= plazas-numerodealumnos;
				break;
				
			case "3":
				plazaslibres3+= plazas-numerodealumnos;
				break;
				
			case "4":
				plazaslibres4+= plazas-numerodealumnos;
				break;

			default:
				break;
			}
			}
			
			
			long plazas= g.getPlazas();
			long numerodealumnos= g.getAlumno().size();
			long cursomenor=0;
			
			
			while(itg.hasNext()) {
				Grupo g2=itg.next();
				Grupo menor;
				if(g2.getAlumno().size()<=numerodealumnos) {
					cursomenor=g2.getAlumno().size();
					menor= g2;
			}
			}
			switch (g.getCurso()) {
			case "1":
				plazaslibres1+= plazas-numerodealumnos;
				
				break;
			case "2":
				plazaslibres2+= plazas-numerodealumnos;
				break;
				
			case "3":
				plazaslibres3+= plazas-numerodealumnos;
				break;
				
			case "4":
				plazaslibres4+= plazas-numerodealumnos;
				break;

			default:
				break;
			}
						
		}
			
	}*/
}
