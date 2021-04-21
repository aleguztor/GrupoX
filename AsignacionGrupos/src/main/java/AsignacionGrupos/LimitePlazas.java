package AsignacionGrupos;



import java.util.List;

import Entidades.Alumno;
import Entidades.Grupo;
import Exceptions.GrupoNoEncontradoException;

public interface LimitePlazas {
	
    public void limitarPlazasRepetidores (Grupo grupo,Long PlazasRep) throws GrupoNoEncontradoException;
    
    public void limitarPlazasNuevoIngreso (Grupo grupo,Long PlazasRep) throws GrupoNoEncontradoException;
    
    public List<Alumno> EliminarGrupoPorFaltaDeAlumnos (Grupo g) throws GrupoNoEncontradoException;
    
    public Grupo busquedaGrupo(String c, String l, String t) throws GrupoNoEncontradoException;

}

