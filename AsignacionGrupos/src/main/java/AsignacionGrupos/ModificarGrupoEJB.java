package AsignacionGrupos;
import java.util.List;

import Entidades.*;

public class ModificarGrupoEJB {
	
	public List<Grupo> obtenerGrupoPorMatricula(Matricula m) {
		Expediente e = m.getExpedientes_num_expedientes();
		return e.getAlumno().getGrupos();
	}
	
	public List<Matricula> obtenerMatriculaPorGrupo(Grupo g) {
		return g.getAlumno().getExpedientes().get(0).getMatricula();
	}

}
