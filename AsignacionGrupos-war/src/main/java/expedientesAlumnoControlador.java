import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Expediente;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value = "expedientes")
@RequestScoped
public class expedientesAlumnoControlador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Expediente> expedientes;
	private Expediente expediente;
		
	@Inject
	private CrudEJBLocal crud;
	
	@Inject
	private listadoAlumnosControlador alc;
	
	@PostConstruct
	public void init() {
		try {
			expedientes = crud.obtenerExpedientesAlumno(alc.getidAlumno());
		} catch (ExpedienteNoEncontradoException e) {
			e.printStackTrace();
		}
	}
	
	public List<Expediente> getExpedientes(){
		return expedientes;
	}
	
	
	
}
