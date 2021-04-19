package AsignacionGrupos;
import java.sql.Date;
import Entidades.*;
//import Excepciones.*;
import Exceptions.ExpedienteNoEncontradoException;

import javax.ejb.Local;


@Local
public interface AGNegocio {
	
	public Alumno obtenerAlumnoPorExpediente(Long num) throws ExpedienteNoEncontradoException;
	public void asignarEncuesta(Long numexp, Date fechaenvio, String turno) throws ExpedienteNoEncontradoException;
}
