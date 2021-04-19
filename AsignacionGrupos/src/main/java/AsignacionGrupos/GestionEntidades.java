package AsignacionGrupos;
import java.util.List;
import Entidades.*;

import javax.ejb.Local;

@Local
public interface GestionEntidades {
		public List<Alumno> obtenerAlumnos() throws Exception;
}
