package AsignacionGrupos;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.*;



public class CambioHorarioEJB implements CambioHorario {

	@Override
	public void CambioHorarioyGrupo(Alumno alum, String nuevaletra, String antigualetra, Grupo nuevo) throws AsignacionException {
		
		Iterator<Grupo> it;
		List<Grupo> grupos= alum.getAlumno_Grupos();
		it= grupos.iterator();
		
		int cuenta=0;
		while(it.hasNext()) {
			Grupo g= it.next();
			cuenta++;
			if(antigualetra==g.getLetra()) {
				grupos.remove(cuenta);
				grupos.add(nuevo);
			}
		}
			
	}

	@Override
	public void AdjuntarArchivo(File f, Alumno alumno) throws AsignacionGruposException {
		
	}

	@Override
	public long numeroPlazas(Grupo grupo) throws AsignacionGruposException {
		return grupo.getPlazas();
		
	}

}
