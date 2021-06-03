package backingbeans;


import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

import Exceptions.*;



@Named("alumnoBean")
@RequestScoped
public class insAlumno {

	
	private Alumno alumno = new Alumno();
	
	private static final Logger LOG = Logger.getLogger(insAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public String doCrearAlumno() {
		try {
			LOG.info("" + alumno.getDNI());
			crud.insertarAlumno(alumno);
		} catch (AlumnoDuplicadoException e) {
				LOG.info("El alumno ya esta en Base de datos incluido");
		}
		return "listadoAlumnos.xhtml";
	}
	
	public List<Alumno> listaAlumnos(){
		 return crud.getAlumnos();
	}

	
	
}
