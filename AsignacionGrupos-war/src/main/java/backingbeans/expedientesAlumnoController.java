package backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value="exp")
@SessionScoped
public class expedientesAlumnoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Expediente> expedientes;
	private Long id;
	
	@Inject
	CrudEJBLocal crud;
	
	@Inject
	listadoAlumnosController l;
	
	public expedientesAlumnoController() {
		id = l.getAlumno().getId();
		try {
			expedientes = crud.obtenerExpedientesAlumno(id); 
		}catch(ExpedienteNoEncontradoException e) {
			e.printStackTrace();
		}
	}
}
