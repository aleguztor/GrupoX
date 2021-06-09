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
	
	public String borrarAlumno(Long id) {
		try {
			List<Expediente> e = crud.getExpedientesDeAlumno(id);
			for(Expediente exp : e) {
				List<Matricula> m = crud.buscarMatriculasPorExpediente(exp.getNum_Expediente());
				for(Matricula mat : m) {
					crud.eliminarMatricula(mat);
				}
				crud.eliminarExpediente(exp);
			}
			crud.eliminarAlumno(id);
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