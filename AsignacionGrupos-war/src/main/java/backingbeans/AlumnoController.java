package backingbeans;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.*;
import Entidades.Alumno;
import Exceptions.AlumnoNoEncontradoException;

@Named(value="alumnocon")
@RequestScoped

public class AlumnoController {
	@Inject
	private CrudEJBLocal crud;
	private String dni;
	private Alumno alumno ;
	
	public String obtenterAlumno() {
		try {
			alumno = crud.buscarAlumnoPorDNI(dni);
			if(alumno == null) {
				return "failed";
			}else {
				return "success";
			}
		} catch (AlumnoNoEncontradoException e) {
			e.printStackTrace();
		}
			return "failed";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
}
