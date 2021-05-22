package backingbeans;


import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;
import Exceptions.AlumnoDuplicadoException;
import Exceptions.AlumnoNoEncontradoException;

@SuppressWarnings("deprecation")
@Named
@ManagedBean

public class AlumnoController {
	@Inject
	private CrudEJBLocal crud;
	
	private Alumno alumno =new Alumno();
	private String dni;
	
	public void modificarAlumno() throws AlumnoDuplicadoException 
	{
		try {
			Alumno au = crud.existeAlumno(alumno);
			if(au!=null)
				crud.modificarAlumno(alumno);
		} catch (AlumnoNoEncontradoException  e) {
			crud.insertarAlumno(alumno);
			
		} 
		
		
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

	public void setNombreAlumno(String nombre) {
		 alumno.setNombre(nombre);
	}
	
	public void setPrimerApellido(String apellido) {
		 alumno.setApellido1(apellido);
	}
	
	public void setSegundoApellido(String apellido) {
		 alumno.setApellido2(apellido);
	}
	
	public void setDNI(String DNI) {
		 alumno.setDNI(DNI);
	}
	
	public void setEmailinstitucional(String email) {
		alumno.setEmail_institucional(email);
	}
	
	
	public void setEmailPersonal(String email) {
		alumno.setEmail_personal(email);
	}
	
	public void setTlf(String tel) {
		alumno.setTelefono(tel);
	}

	public void setMovil(String mov) {
		alumno.setMovil(mov);
	}
	
	
}
