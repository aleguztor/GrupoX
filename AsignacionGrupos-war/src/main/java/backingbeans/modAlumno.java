package backingbeans;


import java.util.Map;
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



@Named(value="modiAlum")
@RequestScoped
public class modAlumno {

	
	private Alumno alumno = new Alumno();
	private Alumno al = new Alumno();
	private static  String dni;
	private static final Logger LOG = Logger.getLogger(modAlumno.class.getCanonicalName());
	
	@Inject 
	CrudEJBLocal crud;
	
	
	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}


	public String outcome() throws AlumnoNoEncontradoException {
		FacesContext fc = FacesContext.getCurrentInstance();
		this.dni = getAlumnoParam(fc).trim();
		
		return "modificarAlumno";
	}
	public String getAlumnoParam(FacesContext fc)  {
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		LOG.severe(params.get("dni"));
		return params.get("dni").toString();
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
	/*public String modificar(String dni) throws AlumnoNoEncontradoException {
		this.al = crud.buscarAlumnoPorDNI(dni);
		LOG.severe(al.getNombre());
		return "modificarAlumno.xhtml";
	}*/
	public String doModificarAlumno() throws AlumnoNoEncontradoException {
		
		this.al=crud.buscarAlumnoPorDNI(dni);
		

			crud.modificarAlumno(al, alumno);
			

	
		return "index";
	}
	
	
	
}