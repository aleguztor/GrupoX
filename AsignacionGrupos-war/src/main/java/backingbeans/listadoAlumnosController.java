package backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

@Named(value="listado")
@SessionScoped
public class listadoAlumnosController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Alumno> alumnos;
	private Alumno alumno = new Alumno();
	
	
	@Inject
	private CrudEJBLocal crud;
	
	@PostConstruct
	public void init() {
		alumnos = crud.getAlumnos();
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public String saveAlumno(Alumno a) {
		alumno = a;
		return "expedientesAlumno.xhtml";
	}

	
}
