package backingbeans;




import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoNoEncontradoException;


@Named
@RequestScoped

public class AlumnoController {
	@Inject
	private CrudEJBLocal crud;
	
	private Alumno alumno ;
	private String dni;
	
	public AlumnoController() {
		alumno = new Alumno();
	}
	
	public void modificarAlumno() throws AlumnoDuplicadoException 
	{
		
		
		
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Alumno getAlumnoporDni() throws AlumnoNoEncontradoException {
		alumno  = crud.buscarAlumnoPorDNI(dni);
		
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
