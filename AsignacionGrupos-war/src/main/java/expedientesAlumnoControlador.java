import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Expediente;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value = "expedientes")
@RequestScoped
public class expedientesAlumnoControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Expediente> expedientes = new LinkedList<Expediente>();
	private Expediente expediente;
	private Alumno a;
		
	@Inject
	private CrudEJBLocal crud;
	
	@Inject
	private listadoAlumnosControlador lac;
	
	private Long id;
	
	public expedientesAlumnoControlador() {
		a = new Alumno();
		a.setId((long)0);
//		lac = new listadoAlumnosControlador();
//		a = lac.getAlumno();
		try {
			expedientes = crud.obtenerExpedientesAlumno(a.getId());
		}catch(ExpedienteNoEncontradoException e) {
			e.printStackTrace();
		}
	}
		
	public List<Expediente> getExpedientes(){
		return expedientes;
	}
	
	public Long getId() {
		return id;
	}
	
	
	
}
