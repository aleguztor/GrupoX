package backingbeans;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Entidades.Expediente;
import Entidades.Matricula;
import Exceptions.AlumnoNoEncontradoException;
import Exceptions.ExpedienteNoEncontradoException;
import Exceptions.MatriculaNoEncontradaException;

@Named(value = "listado")
@RequestScoped
public class listadoAlumnosControlador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Alumno alumno;	
	private List<Alumno> alumnos;
	private Long id;
	private static final Logger LOG = Logger.getLogger(listadoAlumnosControlador.class.getCanonicalName());

    @Inject
    private CrudEJBLocal crud;

    @PostConstruct
    public void init() {
        alumnos = crud.getAlumnos();
    }
    
    public List<Alumno> getAlumnos(){
    	return alumnos;
    }

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public String borrarAlumno(String dni) {
		try {
			LOG.severe(crud.obtenerExpedientesAlumno(id).toString());
			Expediente e = crud.obtenerExpedientesAlumno(id).get(0);
			Matricula m = crud.buscarMatriculasPorExpediente(e.getNum_Expediente()).get(0);
			crud.eliminarMatricula(m);
			crud.eliminarExpediente(e);
			crud.eliminarAlumnoPorDNI(dni);
		} catch (AlumnoNoEncontradoException e) {
			e.printStackTrace();
		} catch (MatriculaNoEncontradaException e1) {
			e1.printStackTrace();
		} catch (ExpedienteNoEncontradoException e1) {
			e1.printStackTrace();
		}
		return "listadoAlumnosControlador.xhtml";
	}
    
	
    
    
    
       
}