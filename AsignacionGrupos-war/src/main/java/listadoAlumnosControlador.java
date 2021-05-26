import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

@Named(value = "listado")
@SessionScoped
public class listadoAlumnosControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Alumno alumno;
	
	private Long idAlumno;
	
	private List<Alumno> alumnos;

    @Inject
    private CrudEJBLocal crud;

    @PostConstruct
    public void init() {
        alumnos = crud.getAlumnos();
    }
    
    public List<Alumno> getAlumnos(){
    	return alumnos;
    }
    
    public String editId(Long l) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", idAlumno);
		return "success";
	}
    
    public Long getidAlumno() {
    	return idAlumno;
    }
       
}