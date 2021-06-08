package backingbeans;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value = "exp")
@SessionScoped
public class expedientesAlumnoControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Expediente> expedientes; // = new LinkedList<Expediente>();
	private static final Logger LOG = Logger.getLogger(expedientesAlumnoControlador.class.getCanonicalName());
	private Expediente expediente;
	private Long id;
		
	@Inject
	CrudEJBLocal crud;
	
	/*
	 * @PostConstruct public void init() { try { expedientes =
	 * crud.obtenerExpedientesAlumno(id); }catch(ExpedienteNoEncontradoException e)
	 * { e.printStackTrace(); } }
	 */
	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
	}

	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Expediente> getExpedientes(){
		return expedientes;
	}
	
	public Long getId() {
		return id;
	}
	
	public String outcome() throws AlumnoNoEncontradoException, ExpedienteNoEncontradoException {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getAlumnoParam(fc);
		this.expedientes= crud.obtenerExpedientesAlumno(id);
		LOG.severe(Long.toString(id));
		return "expedientesAlumno";
	}
	public Long getAlumnoParam(FacesContext fc)  {
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 
		return Long.parseLong(params.get("id"));
	}
	
	
	
}
