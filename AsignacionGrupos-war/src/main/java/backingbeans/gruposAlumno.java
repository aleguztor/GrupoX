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

import AsignacionGrupos.*;
import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Grupo;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;

@Named(value = "grupos")
@SessionScoped
public class gruposAlumno implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Grupo> grupos = new LinkedList<Grupo>();
	private static final Logger LOG = Logger.getLogger(gruposAlumno.class.getCanonicalName());
	private Alumno al;
	private Long id;
	@Inject
	AlgoritmoIntf algo;
	@Inject
	CrudEJBLocal crud;
	
	
	
	public String outcome() throws AlumnoNoEncontradoException, ExpedienteNoEncontradoException {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.id = getAlumnoParam(fc);
		this.al = crud.buscarAlumnoPorId(id);
		return "gruposAlumno";
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public Alumno getAl() {
		return al;
	}
	public void setAl(Alumno al) {
		this.al = al;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAlumnoParam(FacesContext fc)  {
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		 
		return Long.parseLong(params.get("id"));
	}
	
	public String algoritmo() {
		algo.asignacionGrupos();
		return "gruposAlumno";
	}
	public String gruposSacar() {
		grupos = al.getGrupos();
		
		return "gruposAlumno";
	}
	
}
