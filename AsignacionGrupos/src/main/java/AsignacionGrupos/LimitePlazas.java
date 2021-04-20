package AsignacionGrupos;



import Entidades.Grupo;
import Exceptions.GrupoException;

public interface LimitePlazas {
	
    public void limitarPlazasRepetidores (Grupo grupo,Long PlazasRep) throws GrupoException;
    
    public void limitarPlazasNuevas (Grupo grupo,Long PlazasRep) throws GrupoException;

}

