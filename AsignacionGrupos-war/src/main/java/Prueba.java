import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Entidades.Alumno;

@Named(value="pruebaPase")
@RequestScoped
public class Prueba implements Serializable{
		
	private Alumno a;
	
	@Inject
	private listadoAlumnosControlador l;
	
	public Prueba() {
		a = l.getAlumno();
	}
	
	
	public Long getId() {
		return a.getId();
	}
	
	public void setListadoAlumnosControlador(listadoAlumnosControlador l) {
		this.l = l;
	}
}
