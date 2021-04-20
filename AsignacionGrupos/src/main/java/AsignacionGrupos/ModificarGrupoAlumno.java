package AsignacionGrupos;

import java.util.List;

import Exceptions.*;
import Entidades.*;
public interface ModificarGrupoAlumno {
	
	// ESTE SIRVE PARA CAMBIAR A UN ALUMNO DE GRUPO Y POR TANTO DE HORARIO
	public void CambioHorarioyGrupo(Alumno alumn,String letranueva, String antigualetra, Grupo g) throws AsignacionGruposException;
	
	public long numeroPlazas(Grupo grupo) throws AsignacionGruposException;
	
	//get u set de alumno con expediente
	public List<Expediente> getAlumno_expedientes();
	
	public void setAlumno_expedientes(List<Expediente> alumno_expedientes);
	
	public List<Grupo> getAlumno_Grupos();

	public void setAlumno_Grupos(List<Grupo> grupos);
	
	//get y set de expediente con alumno
	public Alumno getAlumno();
	
	public void setAlumno(Alumno a);
	
	//get y set de Expediente con matricula
	public List<Matricula> getexpedientes_num_expedientes();
	
	public void setexpedientes_num_expedientes(List<Matricula> m) ;
	
	//get y set de matricula con expediente
	public Expediente getExpedientes_num_expedientes();

	public void setExpedientes_num_expedientes(Expediente expedientes_num_expedientes);
	
	//ME FALTA MATRICULA CON GRUPO
	
	//ME FALTA GRUPO CON MATRICULA
	

}
