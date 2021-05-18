package AsignacionGrupos;
import java.util.List;

import javax.ejb.Local;

import Entidades.Asignatura;
import Entidades.Grupo;

@Local
public interface AlgoritmoIntf {
	
	public void asignacionGrupos();
	
	public Asignatura buscarAsignaturaPorCodigo(String codigo);
	
	public List<Grupo> buscarGrupos();
}
