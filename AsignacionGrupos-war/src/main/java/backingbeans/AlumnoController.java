package backingbeans;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import AsignacionGrupos.CrudEJB;
import Entidades.Alumno;
import Exceptions.AlumnoNoEncontradoException;

@Named
@RequestScoped

public class AlumnoController {
	@Inject
	private CrudEJB crud;
	
	private Alumno alumno;
	
	public Alumno getAlumnoporDni(String dni) throws AlumnoNoEncontradoException {
		alumno  = crud.buscarAlumnoPorDNI(dni);
		if(alumno==null) {
			throw new AlumnoNoEncontradoException();
		}
		return alumno;
		
		
	}
	public String getNombreAlumno() {
		return alumno.getNombre();
	}
	public String getPrimerApellido() {
		return alumno.getApellido1();
	}
	public String getSegundoApellido() {
		return alumno.getApellido2();
	}
	public String getDNI() {
		return alumno.getDNI();
	}
	public String getEmailinstitucional() {
		return alumno.getEmail_institucional();
	}
	public String getEmailPersonal() {
		return alumno.getEmail_personal();
	}
	public String getTlf() {
		return alumno.getTelefono();
	}
	public String getMovil() {
		return alumno.getMovil();
		
	}

	
	
}
