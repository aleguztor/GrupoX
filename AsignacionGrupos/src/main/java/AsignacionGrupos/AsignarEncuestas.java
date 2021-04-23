package AsignacionGrupos;
import Entidades.*;

import Exceptions.*;

import javax.ejb.Local;


@Local
public interface AsignarEncuestas {
	
	public void asignarEncuesta(Long numexp, Encuesta en) throws ExpedienteNoEncontradoException;
}
