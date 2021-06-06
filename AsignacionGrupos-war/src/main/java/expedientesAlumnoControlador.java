import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value = "expedientes")
@RequestScoped
public class expedientesAlumnoControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Expediente> expedientes = new LinkedList<Expediente>();
	private Expediente expediente;
	private Long id = (long) 1;
		
	@Inject
	private CrudEJBLocal crud;
	
	@PostConstruct
	public void init() {
		try {
		//id = (Long) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("id");
		expedientes = crud.obtenerExpedientesAlumno(id);
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
