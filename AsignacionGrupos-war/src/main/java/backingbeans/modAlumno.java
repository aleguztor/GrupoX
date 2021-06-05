package backingbeans;


import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJBLocal;
import Entidades.Alumno;

import Exceptions.*;



@Named
@RequestScoped
public class modAlumno {

	
	private Alumno alumno = new Alumno();
	
	private Alumno al = new Alumno();
	String dni;
	private static final Logger LOG = Logger.getLogger(modAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;
	
	@PostConstruct
	public void init() {
		try {
			al = crud.buscarAlumnoPorDNI(dni);
		} catch (AlumnoNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public Alumno getAl() {
		return al;
	}

	public void setAl(Alumno al) {
		this.al = al;
	}
	public String modificar(String dni) throws AlumnoNoEncontradoException {
		this.al = crud.buscarAlumnoPorDNI(dni);
		return "modificarAlumno.xhtml";
	}
	public String doModificarAlumno() {
		try {
			
			
			if(alumno.getApellido1() != null) {
				al.setApellido1(alumno.getApellido1());
			}
			if(alumno.getApellido2()!= null) {
				al.setApellido2(alumno.getApellido2());
				LOG.info("EL ALUMNO HA SIDO MODIFICADO ");
			}
			if(alumno.getDNI()!=null) {
				al.setDNI(alumno.getDNI());
			}
			if(alumno.getNombre()!=null) {
				al.setNombre(alumno.getNombre());
			}
			if(alumno.getEmail_institucional() != null) {
				al.setEmail_institucional(alumno.getEmail_institucional());
			}
			if(alumno.getEmail_personal() != null) {
				al.setEmail_personal(alumno.getEmail_personal());
			}
			
			if(alumno.getLocalidad_notificacion() != null) {
				al.setLocalidad_notificacion(alumno.getLocalidad_notificacion());
			}
			if(alumno.getCP_notificacion() != null) {
				al.setCP_notificacion(alumno.getCP_notificacion());
			}
			if(alumno.getProvincia_notificacion() != null) {
				al.setProvincia_notificacion(alumno.getProvincia_notificacion());
			}
			if(alumno.getDireccion_notificacion() != null) {
				al.setDireccion_notificacion(alumno.getDireccion_notificacion());
			}
			
			if(alumno.getMovil() != null) {
				al.setMovil(alumno.getMovil());
			}
			
			if(alumno.getTelefono() !=null) {
				al.setTelefono(alumno.getTelefono());
			}
			
			crud.modificarAlumno(al);
			
		} catch (AlumnoNoEncontradoException e) {
			// TODO Auto-generated catch block
			LOG.severe("El alumno no esta en BBDD");
			e.printStackTrace();
		}
		
		return "index.xhtml";
	}
	
	
	
}

