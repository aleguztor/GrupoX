package backingbeans;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import AsignacionGrupos.CrudEJB;
import Entidades.Alumno;

@Named
@RequestScoped

public class AlumnoController {
	@Inject
	private CrudEJB crud;
	
	private Alumno alumno;
	
	public String doCreateAlumno() {
		alumno = crud.buscarAlumnoPorDNI(dni);
		
	}
	
	
}
