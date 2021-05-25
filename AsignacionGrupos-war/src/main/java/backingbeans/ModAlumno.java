package backingbeans;


import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

import Exceptions.*;



@Named
@RequestScoped

public class ModAlumno {
	private String dni;
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private String Email_institucional;
	private String Email_personal;
	private String Telefono;
	private String Movil;
	private String Direccion_notificacion;
	private String Localidad_notificacion;
	private String Provincia_notificacion;
	private String cp_notificacion;
	
	private Alumno alumno;
	private static final Logger LOG = Logger.getLogger(ModAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public String getEmail_institucional() {
		return Email_institucional;
	}
	public void setEmail_institucional(String email_institucional) {
		Email_institucional = email_institucional;
	}
	public String getEmail_personal() {
		return Email_personal;
	}
	public void setEmail_personal(String email_personal) {
		Email_personal = email_personal;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getMovil() {
		return Movil;
	}
	public void setMovil(String movil) {
		Movil = movil;
	}
	public String getDireccion_notificacion() {
		return Direccion_notificacion;
	}
	public void setDireccion_notificacion(String direccion_notificacion) {
		Direccion_notificacion = direccion_notificacion;
	}
	public String getLocalidad_notificacion() {
		return Localidad_notificacion;
	}
	public void setLocalidad_notificacion(String localidad_notificacion) {
		Localidad_notificacion = localidad_notificacion;
	}
	public String getProvincia_notificacion() {
		return Provincia_notificacion;
	}
	public void setProvincia_notificacion(String provincia_notificacion) {
		Provincia_notificacion = provincia_notificacion;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCp_notificacion() {
		return cp_notificacion;
	}
	public void setCp_notificacion(String cp_notificacion) {
		this.cp_notificacion = cp_notificacion;
	}
	
	public void insertar() {
		alumno = new Alumno(Nombre,Apellido1,dni,Email_institucional);
		
		if(Apellido2 != null)
			alumno.setApellido2(Apellido2);
		if(Email_personal != null)
			alumno.setEmail_personal(Email_personal);
		if(Telefono != null)
			alumno.setTelefono(Telefono);
		if(Movil != null)
			alumno.setMovil(Movil);
		if(Direccion_notificacion != null)
			alumno.setDireccion_notificacion(Direccion_notificacion);
		if(cp_notificacion != null)
			alumno.setCP_notificacion(cp_notificacion);
		if(Provincia_notificacion != null)
			alumno.setProvincia_notificacion(Provincia_notificacion);
		
		try {
			crud.insertarAlumno(alumno);
		} catch (AlumnoDuplicadoException e) {
			// TODO Auto-generated catch block
			LOG.info("El alumno ya esta en Base de datos");
		}
	}
	
	
}
