package backingbeans;


import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

import Exceptions.*;



@Named("alumnoBean")
@RequestScoped
public class ModAlumno {

	
	private Alumno alumno;
	private static final Logger LOG = Logger.getLogger(ModAlumno.class.getCanonicalName());
	
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
			Random r = new Random();
			alumno.setId(r.nextLong());
			crud.insertarAlumno(alumno);
		} catch (AlumnoDuplicadoException e) {
				LOG.info("El alumno ya esta en Base de datos incluido");
		}
		return "success";
	}
	
	public List<Alumno> listaAlumnos(){
		 return crud.getAlumnos();
	}
	
	
}
