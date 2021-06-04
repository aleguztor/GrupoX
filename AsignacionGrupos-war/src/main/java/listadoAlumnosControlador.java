import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

@Named(value = "listado")
@RequestScoped
public class listadoAlumnosControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Alumno alumno;
		
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
    
    public synchronized void setAlumno(Alumno a) {
    	alumno = a;
    }
    public synchronized Alumno getAlumno() {
    	return alumno;
    }
    
    
       
}