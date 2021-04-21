package AsignacionGrupos;



import java.util.List;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.GrupoNoEncontradoException;

public interface LimitePlazas {
	
    public void limitarPlazasRepetidores (Grupo grupo,Long PlazasRep) throws GrupoNoEncontradoException;
    
    public void limitarPlazasNuevas (Grupo grupo,Long PlazasRep) throws GrupoNoEncontradoException;
    
    public List<Alumno> EliminarGrupoPorFaltaDeAlumnos (Grupo g) throws GrupoNoEncontradoException;

}

